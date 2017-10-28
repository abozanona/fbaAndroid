package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.CacheFactory.CacheSizeManager;
import com.google.tagmanager.CustomFunctionCall.CustomEvaluator;
import com.google.tagmanager.ResourceUtil.ExpandedFunctionCall;
import com.google.tagmanager.ResourceUtil.ExpandedResource;
import com.google.tagmanager.ResourceUtil.ExpandedRule;
import com.google.tagmanager.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Runtime {
	static final String DEFAULT_RULE_NAME = "Unknown";
	private static final ObjectAndStatic<Value> DEFAULT_VALUE_AND_STATIC;
	private static final int MAX_CACHE_SIZE = 1048576;
	private final EventInfoDistributor eventInfoDistributor;
	private volatile String mCurrentEventName;
	private final Cache<ExpandedFunctionCall, ObjectAndStatic<Value>> mFunctionCallCache;
	private final Cache<String, ObjectAndStatic<Value>> mMacroEvaluationCache;
	private final Map<String, MacroInfo> mMacroLookup;
	private final Map<String, FunctionCallImplementation> mMacroMap;
	private final Map<String, FunctionCallImplementation> mPredicateMap;
	private final ExpandedResource mResource;
	private final Set<ExpandedRule> mRules;
	private final Map<String, FunctionCallImplementation> mTrackingTagMap;

	static interface AddRemoveSetPopulator {
		public void rulePassed(ExpandedRule r1_ExpandedRule, Set<ExpandedFunctionCall> r2_Set_ExpandedFunctionCall, Set<ExpandedFunctionCall> r3_Set_ExpandedFunctionCall, ResolvedRuleBuilder r4_ResolvedRuleBuilder);
	}

	class AnonymousClass_3 implements Runtime.AddRemoveSetPopulator {
		final /* synthetic */ Map val$addMacroRuleNames;
		final /* synthetic */ Map val$addMacros;
		final /* synthetic */ Map val$removeMacroRuleNames;
		final /* synthetic */ Map val$removeMacros;

		AnonymousClass_3(Map r2_Map, Map r3_Map, Map r4_Map, Map r5_Map) {
			this.val$addMacros = r2_Map;
			this.val$addMacroRuleNames = r3_Map;
			this.val$removeMacros = r4_Map;
			this.val$removeMacroRuleNames = r5_Map;
		}

		public void rulePassed(ExpandedRule rule, Set<ExpandedFunctionCall> add, Set<ExpandedFunctionCall> remove, ResolvedRuleBuilder debugRuleBuilder) {
			List<ExpandedFunctionCall> thisAddMacro = (List) this.val$addMacros.get(rule);
			List<String> thisMacroEnablingRuleNames = (List) this.val$addMacroRuleNames.get(rule);
			if (thisAddMacro != null) {
				add.addAll(thisAddMacro);
				debugRuleBuilder.getAddedMacroFunctions().translateAndAddAll(thisAddMacro, thisMacroEnablingRuleNames);
			}
			List<ExpandedFunctionCall> thisRemoveMacro = (List) this.val$removeMacros.get(rule);
			List<String> thisRemoveMacroRuleNames = (List) this.val$removeMacroRuleNames.get(rule);
			if (thisRemoveMacro != null) {
				remove.addAll(thisRemoveMacro);
				debugRuleBuilder.getRemovedMacroFunctions().translateAndAddAll(thisRemoveMacro, thisRemoveMacroRuleNames);
			}
		}
	}

	static /* synthetic */ class AnonymousClass_5 {
		static final /* synthetic */ int[] $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type;

		static {
			$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type = new int[Type.values().length];
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.LIST.ordinal()] = 1;
			} catch (NoSuchFieldError e) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.MAP.ordinal()] = 2;
			} catch (NoSuchFieldError e_2) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.MACRO_REFERENCE.ordinal()] = 3;
			} catch (NoSuchFieldError e_3) {
			}
			$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.TEMPLATE.ordinal()] = 4;
		}
	}

	private static class MacroInfo {
		private final Map<ExpandedRule, List<String>> mAddMacroNames;
		private final Map<ExpandedRule, List<ExpandedFunctionCall>> mAddMacros;
		private ExpandedFunctionCall mDefault;
		private final Map<ExpandedRule, List<String>> mRemoveMacroNames;
		private final Map<ExpandedRule, List<ExpandedFunctionCall>> mRemoveMacros;
		private final Set<ExpandedRule> mRules;

		public MacroInfo() {
			this.mRules = new HashSet();
			this.mAddMacros = new HashMap();
			this.mAddMacroNames = new HashMap();
			this.mRemoveMacros = new HashMap();
			this.mRemoveMacroNames = new HashMap();
		}

		public void addAddMacroForRule(ExpandedRule rule, ExpandedFunctionCall function) {
			List<ExpandedFunctionCall> result = (List) this.mAddMacros.get(rule);
			if (result == null) {
				result = new ArrayList();
				this.mAddMacros.put(rule, result);
			}
			result.add(function);
		}

		public void addAddMacroRuleNameForRule(ExpandedRule rule, String ruleName) {
			List<String> result = (List) this.mAddMacroNames.get(rule);
			if (result == null) {
				result = new ArrayList();
				this.mAddMacroNames.put(rule, result);
			}
			result.add(ruleName);
		}

		public void addRemoveMacroForRule(ExpandedRule rule, ExpandedFunctionCall function) {
			List<ExpandedFunctionCall> result = (List) this.mRemoveMacros.get(rule);
			if (result == null) {
				result = new ArrayList();
				this.mRemoveMacros.put(rule, result);
			}
			result.add(function);
		}

		public void addRemoveMacroRuleNameForRule(ExpandedRule rule, String ruleName) {
			List<String> result = (List) this.mRemoveMacroNames.get(rule);
			if (result == null) {
				result = new ArrayList();
				this.mRemoveMacroNames.put(rule, result);
			}
			result.add(ruleName);
		}

		public void addRule(ExpandedRule rule) {
			this.mRules.add(rule);
		}

		public Map<ExpandedRule, List<String>> getAddMacroRuleNames() {
			return this.mAddMacroNames;
		}

		public Map<ExpandedRule, List<ExpandedFunctionCall>> getAddMacros() {
			return this.mAddMacros;
		}

		public ExpandedFunctionCall getDefault() {
			return this.mDefault;
		}

		public Map<ExpandedRule, List<String>> getRemoveMacroRuleNames() {
			return this.mRemoveMacroNames;
		}

		public Map<ExpandedRule, List<ExpandedFunctionCall>> getRemoveMacros() {
			return this.mRemoveMacros;
		}

		public Set<ExpandedRule> getRules() {
			return this.mRules;
		}

		public void setDefault(ExpandedFunctionCall def) {
			this.mDefault = def;
		}
	}


	static {
		DEFAULT_VALUE_AND_STATIC = new ObjectAndStatic(Types.getDefaultValue(), true);
	}

	public Runtime(Context context, ExpandedResource resource, DataLayer dataLayer, CustomEvaluator functionCallMacroEvaluator, CustomEvaluator functionCallTagEvaluator) {
		this(context, resource, dataLayer, functionCallMacroEvaluator, functionCallTagEvaluator, new NoopEventInfoDistributor());
	}

	public Runtime(Context context, ExpandedResource resource, DataLayer dataLayer, CustomEvaluator functionCallMacroEvaluator, CustomEvaluator functionCallTagEvaluator, EventInfoDistributor eventInfoDistributor) {
		if (resource == null) {
			throw new NullPointerException("resource cannot be null");
		} else {
			ExpandedFunctionCall function;
			this.mResource = resource;
			this.mRules = new HashSet(resource.getRules());
			this.eventInfoDistributor = eventInfoDistributor;
			CacheFactory r11_CacheFactory = new CacheFactory();
			this.mFunctionCallCache = r11_CacheFactory.createCache(MAX_CACHE_SIZE, new CacheSizeManager<ExpandedFunctionCall, ObjectAndStatic<Value>>() {
			public int sizeOf(ExpandedFunctionCall key, ObjectAndStatic<Value> value) {
				return ((Value) value.getObject()).toByteArray().length;
			}
		});
			r11_CacheFactory = new CacheFactory();
			this.mMacroEvaluationCache = r11_CacheFactory.createCache(MAX_CACHE_SIZE, new CacheSizeManager<String, ObjectAndStatic<Value>>() {
			public int sizeOf(String key, ObjectAndStatic<Value> value) {
				int r1i = key.length();
				return ((Value) value.getObject()).toByteArray().length + r1i;
			}
		});
			this.mTrackingTagMap = new HashMap();
			addTrackingTag(new ArbitraryPixelTag(context));
			addTrackingTag(new CustomFunctionCall(functionCallTagEvaluator));
			addTrackingTag(new UniversalAnalyticsTag(context, dataLayer));
			this.mPredicateMap = new HashMap();
			addPredicate(new ContainsPredicate());
			addPredicate(new EndsWithPredicate());
			addPredicate(new EqualsPredicate());
			addPredicate(new GreaterEqualsPredicate());
			addPredicate(new GreaterThanPredicate());
			addPredicate(new LessEqualsPredicate());
			addPredicate(new LessThanPredicate());
			addPredicate(new RegexPredicate());
			addPredicate(new StartsWithPredicate());
			this.mMacroMap = new HashMap();
			addMacro(new AdvertiserIdMacro(context));
			addMacro(new AdvertisingTrackingEnabledMacro());
			addMacro(new AdwordsClickReferrerMacro(context));
			addMacro(new AppIdMacro(context));
			addMacro(new AppNameMacro(context));
			addMacro(new AppVersionMacro(context));
			addMacro(new ConstantMacro());
			addMacro(new CustomFunctionCall(functionCallMacroEvaluator));
			addMacro(new DataLayerMacro(dataLayer));
			addMacro(new DeviceIdMacro(context));
			addMacro(new DeviceNameMacro());
			addMacro(new EncodeMacro());
			addMacro(new EventMacro(this));
			addMacro(new GtmVersionMacro());
			addMacro(new HashMacro());
			addMacro(new InstallReferrerMacro(context));
			addMacro(new JoinerMacro());
			addMacro(new LanguageMacro());
			addMacro(new MobileAdwordsUniqueIdMacro(context));
			addMacro(new OsVersionMacro());
			addMacro(new PlatformMacro());
			addMacro(new RandomMacro());
			addMacro(new RegexGroupMacro());
			addMacro(new ResolutionMacro(context));
			addMacro(new RuntimeVersionMacro());
			addMacro(new SdkVersionMacro());
			addMacro(new TimeMacro());
			this.mMacroLookup = new HashMap();
			Iterator i$ = this.mRules.iterator();
			while (i$.hasNext()) {
				String ruleName;
				MacroInfo info;
				ExpandedRule rule = (ExpandedRule) i$.next();
				if (eventInfoDistributor.debugMode()) {
					verifyFunctionAndNameListSizes(rule.getAddMacros(), rule.getAddMacroRuleNames(), "add macro");
					verifyFunctionAndNameListSizes(rule.getRemoveMacros(), rule.getRemoveMacroRuleNames(), "remove macro");
					verifyFunctionAndNameListSizes(rule.getAddTags(), rule.getAddTagRuleNames(), "add tag");
					verifyFunctionAndNameListSizes(rule.getRemoveTags(), rule.getRemoveTagRuleNames(), "remove tag");
				}
				int i = 0;
				while (i < rule.getAddMacros().size()) {
					function = (ExpandedFunctionCall) rule.getAddMacros().get(i);
					ruleName = DEFAULT_RULE_NAME;
					if (!eventInfoDistributor.debugMode() || i >= rule.getAddMacroRuleNames().size()) {
						info = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(function));
						info.addRule(rule);
						info.addAddMacroForRule(rule, function);
						info.addAddMacroRuleNameForRule(rule, ruleName);
						i++;
					} else {
						ruleName = rule.getAddMacroRuleNames().get(i);
						info = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(function));
						info.addRule(rule);
						info.addAddMacroForRule(rule, function);
						info.addAddMacroRuleNameForRule(rule, ruleName);
						i++;
					}
				}
				i = 0;
				while (i < rule.getRemoveMacros().size()) {
					function = rule.getRemoveMacros().get(i);
					ruleName = DEFAULT_RULE_NAME;
					if (!eventInfoDistributor.debugMode() || i >= rule.getRemoveMacroRuleNames().size()) {
						info = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(function));
						info.addRule(rule);
						info.addRemoveMacroForRule(rule, function);
						info.addRemoveMacroRuleNameForRule(rule, ruleName);
						i++;
					} else {
						ruleName = rule.getRemoveMacroRuleNames().get(i);
						info = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(function));
						info.addRule(rule);
						info.addRemoveMacroForRule(rule, function);
						info.addRemoveMacroRuleNameForRule(rule, ruleName);
						i++;
					}
				}
			}
			i$ = this.mResource.getAllMacros().entrySet().iterator();
			while (i$.hasNext()) {
				Entry<String, List<ExpandedFunctionCall>> ent = (Entry) i$.next();
				Iterator i$_2 = ((List) ent.getValue()).iterator();
				while (i$_2.hasNext()) {
					function = i$_2.next();
					if (!Types.valueToBoolean((Value) function.getProperties().get(Key.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
						getOrAddMacroInfo(this.mMacroLookup, (String) ent.getKey()).setDefault(function);
					}
				}
			}
		}
	}

	private static void addFunctionImplToMap(Map<String, FunctionCallImplementation> addTo, FunctionCallImplementation impl) {
		if (addTo.containsKey(impl.getInstanceFunctionId())) {
			throw new IllegalArgumentException("Duplicate function type name: " + impl.getInstanceFunctionId());
		} else {
			addTo.put(impl.getInstanceFunctionId(), impl);
		}
	}

	private ObjectAndStatic<Set<ExpandedFunctionCall>> calculateGenericToRun(Set<ExpandedRule> rules, Set<String> pendingMacroExpansions, AddRemoveSetPopulator setPopulator, RuleEvaluationStepInfoBuilder debugRulesEvaluation) {
		Set<ExpandedFunctionCall> add = new HashSet();
		Set<ExpandedFunctionCall> remove = new HashSet();
		boolean allStatic = true;
		Iterator i$ = rules.iterator();
		while (i$.hasNext()) {
			ExpandedRule rule = (ExpandedRule) i$.next();
			ResolvedRuleBuilder debugRuleBuilder = debugRulesEvaluation.createResolvedRuleBuilder();
			ObjectAndStatic<Boolean> result = evaluatePredicatesInRule(rule, pendingMacroExpansions, debugRuleBuilder);
			if (((Boolean) result.getObject()).booleanValue()) {
				setPopulator.rulePassed(rule, add, remove, debugRuleBuilder);
			}
			allStatic = (!allStatic || !result.isStatic()) ? false : true;
		}
		add.removeAll(remove);
		debugRulesEvaluation.setEnabledFunctions(add);
		return new ObjectAndStatic(add, allStatic);
	}

	private ObjectAndStatic<Value> evaluateMacroReferenceCycleDetection(String macroName, Set<String> pendingMacroExpansions, MacroEvaluationInfoBuilder debugMacroEvaluation) {
		ObjectAndStatic<Value> cachedResult = (ObjectAndStatic) this.mMacroEvaluationCache.get(macroName);
		if (cachedResult == null || this.eventInfoDistributor.debugMode()) {
			MacroInfo macroInfo = (MacroInfo) this.mMacroLookup.get(macroName);
			if (macroInfo == null) {
				Log.e("Invalid macro: " + macroName);
				return DEFAULT_VALUE_AND_STATIC;
			} else {
				ExpandedFunctionCall macro;
				ObjectAndStatic<Set<ExpandedFunctionCall>> macrosToRun = calculateMacrosToRun(macroName, macroInfo.getRules(), macroInfo.getAddMacros(), macroInfo.getAddMacroRuleNames(), macroInfo.getRemoveMacros(), macroInfo.getRemoveMacroRuleNames(), pendingMacroExpansions, debugMacroEvaluation.createRulesEvaluation());
				if (((Set) macrosToRun.getObject()).isEmpty()) {
					macro = macroInfo.getDefault();
				} else {
					if (((Set) macrosToRun.getObject()).size() > 1) {
						Log.w("Multiple macros active for macroName " + macroName);
					}
					macro = ((Set) macrosToRun.getObject()).iterator().next();
				}
				if (macro == null) {
					return DEFAULT_VALUE_AND_STATIC;
				} else {
					boolean isStatic;
					ObjectAndStatic<Value> toReturn;
					ObjectAndStatic<Value> macroResult = executeFunction(this.mMacroMap, macro, pendingMacroExpansions, debugMacroEvaluation.createResult());
					isStatic = (!macrosToRun.isStatic() || !macroResult.isStatic()) ? false : true;
					if (macroResult == DEFAULT_VALUE_AND_STATIC) {
						toReturn = DEFAULT_VALUE_AND_STATIC;
					} else {
						ObjectAndStatic<Value> r0_ObjectAndStatic_Value = new ObjectAndStatic(macroResult.getObject(), isStatic);
					}
					if (toReturn.isStatic()) {
						this.mMacroEvaluationCache.put(macroName, toReturn);
					}
					return toReturn;
				}
			}
		}
		return cachedResult;
	}

	private ObjectAndStatic<Value> executeFunction(Map<String, FunctionCallImplementation> implMap, ExpandedFunctionCall functionCall, Set<String> pendingMacroExpansions, ResolvedFunctionCallBuilder debugFunctionCall) {
		Value functionIdValue = (Value) functionCall.getProperties().get(Key.FUNCTION.toString());
		if (functionIdValue == null) {
			Log.e("No function id in properties");
			return DEFAULT_VALUE_AND_STATIC;
		} else {
			String functionId = functionIdValue.getFunctionId();
			FunctionCallImplementation impl = (FunctionCallImplementation) implMap.get(functionId);
			if (impl == null) {
				Log.e(functionId + " has no backing implementation.");
				return DEFAULT_VALUE_AND_STATIC;
			} else {
				ObjectAndStatic<Value> cachedResult = (ObjectAndStatic) this.mFunctionCallCache.get(functionCall);
				if (cachedResult == null || this.eventInfoDistributor.debugMode()) {
					ObjectAndStatic<Value> result;
					Map<String, Value> expandedParams = new HashMap();
					boolean allParamsStatic = true;
					Iterator i$ = functionCall.getProperties().entrySet().iterator();
					while (i$.hasNext()) {
						Entry<String, Value> originalParam = (Entry) i$.next();
						result = macroExpandValue((Value) originalParam.getValue(), pendingMacroExpansions, debugFunctionCall.createResolvedPropertyBuilder((String) originalParam.getKey()).createPropertyValueBuilder((Value) originalParam.getValue()));
						if (result == DEFAULT_VALUE_AND_STATIC) {
							return DEFAULT_VALUE_AND_STATIC;
						} else {
							if (result.isStatic()) {
								functionCall.updateCacheableProperty((String) originalParam.getKey(), (Value) result.getObject());
							} else {
								allParamsStatic = false;
							}
							expandedParams.put(originalParam.getKey(), result.getObject());
						}
					}
					if (!impl.hasRequiredKeys(expandedParams.keySet())) {
						Log.e("Incorrect keys for function " + functionId + " required " + impl.getRequiredKeys() + " had " + expandedParams.keySet());
						return DEFAULT_VALUE_AND_STATIC;
					} else {
						boolean cacheable;
						cacheable = (!allParamsStatic || !impl.isCacheable()) ? false : true;
						result = new ObjectAndStatic(impl.evaluate(expandedParams), cacheable);
						if (cacheable) {
							this.mFunctionCallCache.put(functionCall, result);
						}
						debugFunctionCall.setFunctionResult((Value) result.getObject());
						return result;
					}
				}
				return cachedResult;
			}
		}
	}

	private static String getFunctionName(ExpandedFunctionCall functionCall) {
		return Types.valueToString((Value) functionCall.getProperties().get(Key.INSTANCE_NAME.toString()));
	}

	private static MacroInfo getOrAddMacroInfo(Map<String, MacroInfo> macroLookup, String key) {
		MacroInfo result = (MacroInfo) macroLookup.get(key);
		if (result == null) {
			result = new MacroInfo();
			macroLookup.put(key, result);
			return result;
		}
		return result;
	}

	private ObjectAndStatic<Value> macroExpandValue(Value value, Set<String> pendingMacroExpansions, ValueBuilder debugValueBuilder) {
		if (!value.getContainsReferences()) {
			return new ObjectAndStatic(value, true);
		} else {
			Builder builder;
			int i;
			ObjectAndStatic<Value> macroExpand;
			switch(AnonymousClass_5.$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[value.getType().ordinal()]) {
			case WireFormat.WIRETYPE_FIXED64:
				builder = ResourceUtil.newValueBuilderBasedOnValue(value);
				i = 0;
				while (i < value.getListItemCount()) {
					macroExpand = macroExpandValue(value.getListItem(i), pendingMacroExpansions, debugValueBuilder.getListItem(i));
					if (macroExpand == DEFAULT_VALUE_AND_STATIC) {
						return DEFAULT_VALUE_AND_STATIC;
					} else {
						builder.addListItem((Value) macroExpand.getObject());
						i++;
					}
				}
				return new ObjectAndStatic(builder.build(), false);
			case WireFormat.WIRETYPE_LENGTH_DELIMITED:
				builder = ResourceUtil.newValueBuilderBasedOnValue(value);
				if (value.getMapKeyCount() != value.getMapValueCount()) {
					Log.e("Invalid serving value: " + value.toString());
					return DEFAULT_VALUE_AND_STATIC;
				} else {
					i = 0;
					while (i < value.getMapKeyCount()) {
						ObjectAndStatic<Value> macroExpandKey = macroExpandValue(value.getMapKey(i), pendingMacroExpansions, debugValueBuilder.getMapKey(i));
						ObjectAndStatic<Value> macroExpandValue = macroExpandValue(value.getMapValue(i), pendingMacroExpansions, debugValueBuilder.getMapValue(i));
						if (macroExpandKey == DEFAULT_VALUE_AND_STATIC || macroExpandValue == DEFAULT_VALUE_AND_STATIC) {
							return DEFAULT_VALUE_AND_STATIC;
						} else {
							builder.addMapKey((Value) macroExpandKey.getObject());
							builder.addMapValue((Value) macroExpandValue.getObject());
							i++;
						}
					}
					return new ObjectAndStatic(builder.build(), false);
				}
			case WireFormat.WIRETYPE_START_GROUP:
				if (pendingMacroExpansions.contains(value.getMacroReference())) {
					Log.e("Macro cycle detected.  Current macro reference: " + value.getMacroReference() + "." + "  Previous macro references: " + pendingMacroExpansions.toString() + ".");
					return DEFAULT_VALUE_AND_STATIC;
				} else {
					pendingMacroExpansions.add(value.getMacroReference());
					ObjectAndStatic<Value> result = ValueEscapeUtil.applyEscapings(evaluateMacroReferenceCycleDetection(value.getMacroReference(), pendingMacroExpansions, debugValueBuilder.createValueMacroEvaluationInfoExtension()), value.getEscapingList());
					pendingMacroExpansions.remove(value.getMacroReference());
					return result;
				}
			case WireFormat.WIRETYPE_END_GROUP:
				builder = ResourceUtil.newValueBuilderBasedOnValue(value);
				i = 0;
				while (i < value.getTemplateTokenCount()) {
					macroExpand = macroExpandValue(value.getTemplateToken(i), pendingMacroExpansions, debugValueBuilder.getTemplateToken(i));
					if (macroExpand == DEFAULT_VALUE_AND_STATIC) {
						return DEFAULT_VALUE_AND_STATIC;
					} else {
						builder.addTemplateToken((Value) macroExpand.getObject());
						i++;
					}
				}
				return new ObjectAndStatic(builder.build(), false);
			}
			Log.e("Unknown type: " + value.getType());
			return DEFAULT_VALUE_AND_STATIC;
		}
	}

	private static void verifyFunctionAndNameListSizes(List<ExpandedFunctionCall> functionList, List<String> ruleNameList, String operation) {
		if (functionList.size() != ruleNameList.size()) {
			Log.i("Invalid resource: imbalance of rule names of functions for " + operation + " operation. Using default rule name instead");
		}
	}

	@VisibleForTesting
	void addMacro(FunctionCallImplementation macro) {
		addFunctionImplToMap(this.mMacroMap, macro);
	}

	@VisibleForTesting
	void addPredicate(FunctionCallImplementation predicate) {
		addFunctionImplToMap(this.mPredicateMap, predicate);
	}

	@VisibleForTesting
	void addTrackingTag(FunctionCallImplementation tag) {
		addFunctionImplToMap(this.mTrackingTagMap, tag);
	}

	@VisibleForTesting
	ObjectAndStatic<Set<ExpandedFunctionCall>> calculateMacrosToRun(String macroName, Set<ExpandedRule> rules, Map<ExpandedRule, List<ExpandedFunctionCall>> addMacros, Map<ExpandedRule, List<String>> addMacroRuleNames, Map<ExpandedRule, List<ExpandedFunctionCall>> removeMacros, Map<ExpandedRule, List<String>> removeMacroRuleNames, Set<String> pendingMacroExpansions, RuleEvaluationStepInfoBuilder debugRulesEvaluation) {
		return calculateGenericToRun(rules, pendingMacroExpansions, new AnonymousClass_3(addMacros, addMacroRuleNames, removeMacros, removeMacroRuleNames), debugRulesEvaluation);
	}

	@VisibleForTesting
	ObjectAndStatic<Set<ExpandedFunctionCall>> calculateTagsToRun(Set<ExpandedRule> rules, RuleEvaluationStepInfoBuilder debugRulesEvaluation) {
		return calculateGenericToRun(rules, new HashSet(), new AddRemoveSetPopulator() {
			public void rulePassed(ExpandedRule rule, Set<ExpandedFunctionCall> add, Set<ExpandedFunctionCall> remove, ResolvedRuleBuilder debugRuleBuilder) {
				add.addAll(rule.getAddTags());
				remove.addAll(rule.getRemoveTags());
				debugRuleBuilder.getAddedTagFunctions().translateAndAddAll(rule.getAddTags(), rule.getAddTagRuleNames());
				debugRuleBuilder.getRemovedTagFunctions().translateAndAddAll(rule.getRemoveTags(), rule.getRemoveTagRuleNames());
			}
		}, debugRulesEvaluation);
	}

	public ObjectAndStatic<Value> evaluateMacroReference(String macroName) {
		EventInfoBuilder eventInfoBuilder = this.eventInfoDistributor.createMacroEvalutionEventInfo(macroName);
		ObjectAndStatic<Value> result = evaluateMacroReferenceCycleDetection(macroName, new HashSet(), eventInfoBuilder.createMacroEvaluationInfoBuilder());
		eventInfoBuilder.processEventInfo();
		return result;
	}

	@VisibleForTesting
	ObjectAndStatic<Boolean> evaluatePredicate(ExpandedFunctionCall predicate, Set<String> pendingMacroExpansions, ResolvedFunctionCallBuilder debugFunctionCall) {
		ObjectAndStatic<Value> result = executeFunction(this.mPredicateMap, predicate, pendingMacroExpansions, debugFunctionCall);
		Boolean predicateResult = Types.valueToBoolean((Value) result.getObject());
		debugFunctionCall.setFunctionResult(Types.objectToValue(predicateResult));
		return new ObjectAndStatic(predicateResult, result.isStatic());
	}

	@VisibleForTesting
	ObjectAndStatic<Boolean> evaluatePredicatesInRule(ExpandedRule rule, Set<String> pendingMacroExpansions, ResolvedRuleBuilder debugRuleBuilder) {
		ObjectAndStatic<Boolean> result;
		boolean r5z = true;
		boolean r6z = false;
		boolean allStatic = true;
		Iterator i$ = rule.getNegativePredicates().iterator();
		while (i$.hasNext()) {
			result = evaluatePredicate((ExpandedFunctionCall) i$.next(), pendingMacroExpansions, debugRuleBuilder.createNegativePredicate());
			if (((Boolean) result.getObject()).booleanValue()) {
				debugRuleBuilder.setValue(Types.objectToValue(Boolean.valueOf(r6z)));
				return new ObjectAndStatic(Boolean.valueOf(r6z), result.isStatic());
			} else if (!allStatic || !result.isStatic()) {
				allStatic = false;
			} else {
				allStatic = true;
			}
		}
		i$ = rule.getPositivePredicates().iterator();
		while (i$.hasNext()) {
			result = evaluatePredicate(i$.next(), pendingMacroExpansions, debugRuleBuilder.createPositivePredicate());
			if (!((Boolean) result.getObject()).booleanValue()) {
				debugRuleBuilder.setValue(Types.objectToValue(Boolean.valueOf(r6z)));
				return new ObjectAndStatic(Boolean.valueOf(r6z), result.isStatic());
			} else if (!allStatic || !result.isStatic()) {
				allStatic = false;
			} else {
				allStatic = true;
			}
		}
		debugRuleBuilder.setValue(Types.objectToValue(Boolean.valueOf(r5z)));
		return new ObjectAndStatic(Boolean.valueOf(r5z), allStatic);
	}

	public synchronized void evaluateTags(String currentEventName) {
		synchronized(this) {
			setCurrentEventName(currentEventName);
			EventInfoBuilder eventInfoBuilder = this.eventInfoDistributor.createDataLayerEventEvaluationEventInfo(currentEventName);
			DataLayerEventEvaluationInfoBuilder debugDataLayerBuilder = eventInfoBuilder.createDataLayerEventEvaluationInfoBuilder();
			Iterator i$ = ((Set) calculateTagsToRun(this.mRules, debugDataLayerBuilder.createRulesEvaluation()).getObject()).iterator();
			while (i$.hasNext()) {
				executeFunction(this.mTrackingTagMap, (ExpandedFunctionCall) i$.next(), new HashSet(), debugDataLayerBuilder.createAndAddResult());
			}
			eventInfoBuilder.processEventInfo();
			setCurrentEventName(null);
		}
	}

	synchronized String getCurrentEventName() {
		String r0_String;
		synchronized(this) {
			r0_String = this.mCurrentEventName;
		}
		return r0_String;
	}

	public ExpandedResource getResource() {
		return this.mResource;
	}

	@VisibleForTesting
	synchronized void setCurrentEventName(String currentEventName) {
		synchronized(this) {
			this.mCurrentEventName = currentEventName;
		}
	}
}
