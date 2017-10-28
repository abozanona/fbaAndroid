package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.proto.Serving.FunctionCall;
import com.google.analytics.containertag.proto.Serving.Property;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.containertag.proto.Serving.Rule;
import com.google.analytics.containertag.proto.Serving.ServingValue;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ResourceUtil {
	static /* synthetic */ class AnonymousClass_1 {
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
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.TEMPLATE.ordinal()] = 4;
			} catch (NoSuchFieldError e_4) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.STRING.ordinal()] = 5;
			} catch (NoSuchFieldError e_5) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.FUNCTION_ID.ordinal()] = 6;
			} catch (NoSuchFieldError e_6) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.INTEGER.ordinal()] = 7;
			} catch (NoSuchFieldError e_7) {
			}
			$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.BOOLEAN.ordinal()] = 8;
		}
	}

	public static class ExpandedFunctionCall {
		private final Map<String, Value> mPropertiesMap;

		private ExpandedFunctionCall(Map<String, Value> propertiesMap) {
			this.mPropertiesMap = propertiesMap;
		}

		public static ResourceUtil.ExpandedFunctionCallBuilder newBuilder() {
			return new ResourceUtil.ExpandedFunctionCallBuilder();
		}

		public Map<String, Value> getProperties() {
			return Collections.unmodifiableMap(this.mPropertiesMap);
		}

		public String toString() {
			return "Properties: " + getProperties();
		}

		public void updateCacheableProperty(String key, Value v) {
			this.mPropertiesMap.put(key, v);
		}
	}

	public static class ExpandedFunctionCallBuilder {
		private final Map<String, Value> mPropertiesMap;

		private ExpandedFunctionCallBuilder() {
			this.mPropertiesMap = new HashMap();
		}

		public ResourceUtil.ExpandedFunctionCallBuilder addProperty(String key, Value value) {
			this.mPropertiesMap.put(key, value);
			return this;
		}

		public ResourceUtil.ExpandedFunctionCall build() {
			return new ResourceUtil.ExpandedFunctionCall(null);
		}
	}

	public static class ExpandedResource {
		private final Map<String, List<ResourceUtil.ExpandedFunctionCall>> mMacros;
		private final int mResourceFormatVersion;
		private final List<ResourceUtil.ExpandedRule> mRules;
		private final String mVersion;

		private ExpandedResource(List<ResourceUtil.ExpandedRule> rules, Map<String, List<ResourceUtil.ExpandedFunctionCall>> macros, String version, int resourceFormatVersion) {
			this.mRules = Collections.unmodifiableList(rules);
			this.mMacros = Collections.unmodifiableMap(macros);
			this.mVersion = version;
			this.mResourceFormatVersion = resourceFormatVersion;
		}

		public static ResourceUtil.ExpandedResourceBuilder newBuilder() {
			return new ResourceUtil.ExpandedResourceBuilder();
		}

		public Map<String, List<ResourceUtil.ExpandedFunctionCall>> getAllMacros() {
			return this.mMacros;
		}

		public List<ResourceUtil.ExpandedFunctionCall> getMacros(String name) {
			return (List) this.mMacros.get(name);
		}

		public int getResourceFormatVersion() {
			return this.mResourceFormatVersion;
		}

		public List<ResourceUtil.ExpandedRule> getRules() {
			return this.mRules;
		}

		public String getVersion() {
			return this.mVersion;
		}

		public String toString() {
			return "Rules: " + getRules() + "  Macros: " + this.mMacros;
		}
	}

	public static class ExpandedResourceBuilder {
		private final Map<String, List<ResourceUtil.ExpandedFunctionCall>> mMacros;
		private final List<ResourceUtil.ExpandedFunctionCall> mPredicates;
		private int mResourceFormatVersion;
		private final List<ResourceUtil.ExpandedRule> mRules;
		private final List<ResourceUtil.ExpandedFunctionCall> mTags;
		private String mVersion;

		private ExpandedResourceBuilder() {
			this.mRules = new ArrayList();
			this.mTags = new ArrayList();
			this.mPredicates = new ArrayList();
			this.mMacros = new HashMap();
			this.mVersion = "";
			this.mResourceFormatVersion = 0;
		}

		public ResourceUtil.ExpandedResourceBuilder addMacro(ResourceUtil.ExpandedFunctionCall f) {
			String macroName = Types.valueToString((Value) f.getProperties().get(Key.INSTANCE_NAME.toString()));
			List<ResourceUtil.ExpandedFunctionCall> macroList = (List) this.mMacros.get(macroName);
			if (macroList == null) {
				macroList = new ArrayList();
				this.mMacros.put(macroName, macroList);
			}
			macroList.add(f);
			return this;
		}

		public ResourceUtil.ExpandedResourceBuilder addRule(ResourceUtil.ExpandedRule r) {
			this.mRules.add(r);
			return this;
		}

		public ResourceUtil.ExpandedResource build() {
			return new ResourceUtil.ExpandedResource(this.mMacros, this.mVersion, this.mResourceFormatVersion, null);
		}

		public ResourceUtil.ExpandedResourceBuilder setResourceFormatVersion(int resourceFormatVersion) {
			this.mResourceFormatVersion = resourceFormatVersion;
			return this;
		}

		public ResourceUtil.ExpandedResourceBuilder setVersion(String version) {
			this.mVersion = version;
			return this;
		}
	}

	public static class ExpandedRule {
		private final List<String> mAddMacroRuleNames;
		private final List<ResourceUtil.ExpandedFunctionCall> mAddMacros;
		private final List<String> mAddTagRuleNames;
		private final List<ResourceUtil.ExpandedFunctionCall> mAddTags;
		private final List<ResourceUtil.ExpandedFunctionCall> mNegativePredicates;
		private final List<ResourceUtil.ExpandedFunctionCall> mPositivePredicates;
		private final List<String> mRemoveMacroRuleNames;
		private final List<ResourceUtil.ExpandedFunctionCall> mRemoveMacros;
		private final List<String> mRemoveTagRuleNames;
		private final List<ResourceUtil.ExpandedFunctionCall> mRemoveTags;

		private ExpandedRule(List<ResourceUtil.ExpandedFunctionCall> postivePredicates, List<ResourceUtil.ExpandedFunctionCall> negativePredicates, List<ResourceUtil.ExpandedFunctionCall> addTags, List<ResourceUtil.ExpandedFunctionCall> removeTags, List<ResourceUtil.ExpandedFunctionCall> addMacros, List<ResourceUtil.ExpandedFunctionCall> removeMacros, List<String> addMacroRuleNames, List<String> removeMacroRuleNames, List<String> addTagRuleNames, List<String> removeTagRuleNames) {
			this.mPositivePredicates = Collections.unmodifiableList(postivePredicates);
			this.mNegativePredicates = Collections.unmodifiableList(negativePredicates);
			this.mAddTags = Collections.unmodifiableList(addTags);
			this.mRemoveTags = Collections.unmodifiableList(removeTags);
			this.mAddMacros = Collections.unmodifiableList(addMacros);
			this.mRemoveMacros = Collections.unmodifiableList(removeMacros);
			this.mAddMacroRuleNames = Collections.unmodifiableList(addMacroRuleNames);
			this.mRemoveMacroRuleNames = Collections.unmodifiableList(removeMacroRuleNames);
			this.mAddTagRuleNames = Collections.unmodifiableList(addTagRuleNames);
			this.mRemoveTagRuleNames = Collections.unmodifiableList(removeTagRuleNames);
		}

		public static ResourceUtil.ExpandedRuleBuilder newBuilder() {
			return new ResourceUtil.ExpandedRuleBuilder();
		}

		public List<String> getAddMacroRuleNames() {
			return this.mAddMacroRuleNames;
		}

		public List<ResourceUtil.ExpandedFunctionCall> getAddMacros() {
			return this.mAddMacros;
		}

		public List<String> getAddTagRuleNames() {
			return this.mAddTagRuleNames;
		}

		public List<ResourceUtil.ExpandedFunctionCall> getAddTags() {
			return this.mAddTags;
		}

		public List<ResourceUtil.ExpandedFunctionCall> getNegativePredicates() {
			return this.mNegativePredicates;
		}

		public List<ResourceUtil.ExpandedFunctionCall> getPositivePredicates() {
			return this.mPositivePredicates;
		}

		public List<String> getRemoveMacroRuleNames() {
			return this.mRemoveMacroRuleNames;
		}

		public List<ResourceUtil.ExpandedFunctionCall> getRemoveMacros() {
			return this.mRemoveMacros;
		}

		public List<String> getRemoveTagRuleNames() {
			return this.mRemoveTagRuleNames;
		}

		public List<ResourceUtil.ExpandedFunctionCall> getRemoveTags() {
			return this.mRemoveTags;
		}

		public String toString() {
			return "Positive predicates: " + getPositivePredicates() + "  Negative predicates: " + getNegativePredicates() + "  Add tags: " + getAddTags() + "  Remove tags: " + getRemoveTags() + "  Add macros: " + getAddMacros() + "  Remove macros: " + getRemoveMacros();
		}
	}

	public static class ExpandedRuleBuilder {
		private final List<String> mAddMacroRuleNames;
		private final List<ResourceUtil.ExpandedFunctionCall> mAddMacros;
		private final List<String> mAddTagRuleNames;
		private final List<ResourceUtil.ExpandedFunctionCall> mAddTags;
		private final List<ResourceUtil.ExpandedFunctionCall> mNegativePredicates;
		private final List<ResourceUtil.ExpandedFunctionCall> mPositivePredicates;
		private final List<String> mRemoveMacroRuleNames;
		private final List<ResourceUtil.ExpandedFunctionCall> mRemoveMacros;
		private final List<String> mRemoveTagRuleNames;
		private final List<ResourceUtil.ExpandedFunctionCall> mRemoveTags;

		private ExpandedRuleBuilder() {
			this.mPositivePredicates = new ArrayList();
			this.mNegativePredicates = new ArrayList();
			this.mAddTags = new ArrayList();
			this.mRemoveTags = new ArrayList();
			this.mAddMacros = new ArrayList();
			this.mRemoveMacros = new ArrayList();
			this.mAddMacroRuleNames = new ArrayList();
			this.mRemoveMacroRuleNames = new ArrayList();
			this.mAddTagRuleNames = new ArrayList();
			this.mRemoveTagRuleNames = new ArrayList();
		}

		public ResourceUtil.ExpandedRuleBuilder addAddMacro(ResourceUtil.ExpandedFunctionCall f) {
			this.mAddMacros.add(f);
			return this;
		}

		public ResourceUtil.ExpandedRuleBuilder addAddMacroRuleName(String ruleName) {
			this.mAddMacroRuleNames.add(ruleName);
			return this;
		}

		public ResourceUtil.ExpandedRuleBuilder addAddTag(ResourceUtil.ExpandedFunctionCall f) {
			this.mAddTags.add(f);
			return this;
		}

		public ResourceUtil.ExpandedRuleBuilder addAddTagRuleName(String ruleName) {
			this.mAddTagRuleNames.add(ruleName);
			return this;
		}

		public ResourceUtil.ExpandedRuleBuilder addNegativePredicate(ResourceUtil.ExpandedFunctionCall f) {
			this.mNegativePredicates.add(f);
			return this;
		}

		public ResourceUtil.ExpandedRuleBuilder addPositivePredicate(ResourceUtil.ExpandedFunctionCall f) {
			this.mPositivePredicates.add(f);
			return this;
		}

		public ResourceUtil.ExpandedRuleBuilder addRemoveMacro(ResourceUtil.ExpandedFunctionCall f) {
			this.mRemoveMacros.add(f);
			return this;
		}

		public ResourceUtil.ExpandedRuleBuilder addRemoveMacroRuleName(String ruleName) {
			this.mRemoveMacroRuleNames.add(ruleName);
			return this;
		}

		public ResourceUtil.ExpandedRuleBuilder addRemoveTag(ResourceUtil.ExpandedFunctionCall f) {
			this.mRemoveTags.add(f);
			return this;
		}

		public ResourceUtil.ExpandedRuleBuilder addRemoveTagRuleName(String ruleName) {
			this.mRemoveTagRuleNames.add(ruleName);
			return this;
		}

		public ResourceUtil.ExpandedRule build() {
			return new ResourceUtil.ExpandedRule(this.mNegativePredicates, this.mAddTags, this.mRemoveTags, this.mAddMacros, this.mRemoveMacros, this.mAddMacroRuleNames, this.mRemoveMacroRuleNames, this.mAddTagRuleNames, this.mRemoveTagRuleNames, null);
		}
	}

	public static class InvalidResourceException extends Exception {
		public InvalidResourceException(String s) {
			super(s);
		}
	}


	private ResourceUtil() {
	}

	private static ExpandedFunctionCall expandFunctionCall(FunctionCall functionCall, Resource resource, Value[] expandedValues, int idx) throws InvalidResourceException {
		ExpandedFunctionCallBuilder builder = ExpandedFunctionCall.newBuilder();
		Iterator i$ = functionCall.getPropertyList().iterator();
		while (i$.hasNext()) {
			Property p = (Property) getWithBoundsCheck(resource.getPropertyList(), ((Integer) i$.next()).intValue(), "properties");
			builder.addProperty((String) getWithBoundsCheck(resource.getKeyList(), p.getKey(), "keys"), (Value) getWithBoundsCheck((Object[])expandedValues, p.getValue(), "values"));
		}
		return builder.build();
	}

	private static ExpandedRule expandRule(Rule rule, List<ExpandedFunctionCall> tags, List<ExpandedFunctionCall> macros, List<ExpandedFunctionCall> predicates, Resource resource) {
		ExpandedRuleBuilder ruleBuilder = ExpandedRule.newBuilder();
		Iterator i$ = rule.getPositivePredicateList().iterator();
		while (i$.hasNext()) {
			ruleBuilder.addPositivePredicate((ExpandedFunctionCall) predicates.get(((Integer) i$.next()).intValue()));
		}
		i$ = rule.getNegativePredicateList().iterator();
		while (i$.hasNext()) {
			ruleBuilder.addNegativePredicate((ExpandedFunctionCall) predicates.get(i$.next().intValue()));
		}
		i$ = rule.getAddTagList().iterator();
		while (i$.hasNext()) {
			ruleBuilder.addAddTag((ExpandedFunctionCall) tags.get(((Integer) i$.next()).intValue()));
		}
		i$ = rule.getAddTagRuleNameList().iterator();
		while (i$.hasNext()) {
			ruleBuilder.addAddTagRuleName(resource.getValue(((Integer) i$.next()).intValue()).getString());
		}
		i$ = rule.getRemoveTagList().iterator();
		while (i$.hasNext()) {
			ruleBuilder.addRemoveTag((ExpandedFunctionCall) tags.get(i$.next().intValue()));
		}
		i$ = rule.getRemoveTagRuleNameList().iterator();
		while (i$.hasNext()) {
			ruleBuilder.addRemoveTagRuleName(resource.getValue(i$.next().intValue()).getString());
		}
		i$ = rule.getAddMacroList().iterator();
		while (i$.hasNext()) {
			ruleBuilder.addAddMacro((ExpandedFunctionCall) macros.get(((Integer) i$.next()).intValue()));
		}
		i$ = rule.getAddMacroRuleNameList().iterator();
		while (i$.hasNext()) {
			ruleBuilder.addAddMacroRuleName(resource.getValue(i$.next().intValue()).getString());
		}
		i$ = rule.getRemoveMacroList().iterator();
		while (i$.hasNext()) {
			ruleBuilder.addRemoveMacro((ExpandedFunctionCall) macros.get(i$.next().intValue()));
		}
		i$ = rule.getRemoveMacroRuleNameList().iterator();
		while (i$.hasNext()) {
			ruleBuilder.addRemoveMacroRuleName(resource.getValue(i$.next().intValue()).getString());
		}
		return ruleBuilder.build();
	}

	private static Value expandValue(int i, Resource resource, Value[] expandedValues, Set<Integer> pendingExpansions) throws InvalidResourceException {
		if (pendingExpansions.contains(Integer.valueOf(i))) {
			logAndThrow("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + pendingExpansions + ".");
		}
		Value value = (Value) getWithBoundsCheck(resource.getValueList(), i, "values");
		if (expandedValues[i] != null) {
			return expandedValues[i];
		} else {
			Value toAdd = null;
			pendingExpansions.add(Integer.valueOf(i));
			Builder builder;
			Iterator i$;
			ServingValue servingValue;
			switch(AnonymousClass_1.$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[value.getType().ordinal()]) {
			case WireFormat.WIRETYPE_FIXED64:
				builder = newValueBuilderBasedOnValue(value);
				i$ = getServingValue(value).getListItemList().iterator();
				while (i$.hasNext()) {
					builder.addListItem(expandValue(((Integer) i$.next()).intValue(), resource, expandedValues, pendingExpansions));
				}
				toAdd = builder.build();
				break;
			case WireFormat.WIRETYPE_LENGTH_DELIMITED:
				builder = newValueBuilderBasedOnValue(value);
				servingValue = getServingValue(value);
				if (servingValue.getMapKeyCount() != servingValue.getMapValueCount()) {
					logAndThrow("Uneven map keys (" + servingValue.getMapKeyCount() + ") and map values (" + servingValue.getMapValueCount() + ")");
				}
				i$ = servingValue.getMapKeyList().iterator();
				while (i$.hasNext()) {
					builder.addMapKey(expandValue(((Integer) i$.next()).intValue(), resource, expandedValues, pendingExpansions));
				}
				i$ = servingValue.getMapValueList().iterator();
				while (i$.hasNext()) {
					builder.addMapValue(expandValue(((Integer) i$.next()).intValue(), resource, expandedValues, pendingExpansions));
				}
				toAdd = builder.build();
				break;
			case WireFormat.WIRETYPE_START_GROUP:
				String macroName;
				builder = newValueBuilderBasedOnValue(value);
				servingValue = getServingValue(value);
				if (!servingValue.hasMacroNameReference()) {
					logAndThrow("Missing macro name reference");
					macroName = "";
				} else {
					macroName = Types.valueToString(expandValue(servingValue.getMacroNameReference(), resource, expandedValues, pendingExpansions));
				}
				builder.setMacroReference(macroName);
				toAdd = builder.build();
				break;
			case WireFormat.WIRETYPE_END_GROUP:
				builder = newValueBuilderBasedOnValue(value);
				i$ = getServingValue(value).getTemplateTokenList().iterator();
				while (i$.hasNext()) {
					builder.addTemplateToken(expandValue(((Integer) i$.next()).intValue(), resource, expandedValues, pendingExpansions));
				}
				toAdd = builder.build();
				break;
			case WireFormat.WIRETYPE_FIXED32:
			case Value.MACRO_REFERENCE_FIELD_NUMBER:
			case Value.FUNCTION_ID_FIELD_NUMBER:
			case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
				toAdd = value;
				break;
			}
			if (toAdd == null) {
				logAndThrow("Invalid value: " + value);
			}
			expandedValues[i] = toAdd;
			pendingExpansions.remove(Integer.valueOf(i));
			return toAdd;
		}
	}

	public static ExpandedResource getExpandedResource(Resource resource) throws InvalidResourceException {
		Value[] expandedValues = new Value[resource.getValueCount()];
		int i = 0;
		while (i < resource.getValueCount()) {
			expandValue(i, resource, expandedValues, new HashSet(0));
			i++;
		}
		ExpandedResourceBuilder builder = ExpandedResource.newBuilder();
		List<ExpandedFunctionCall> tags = new ArrayList();
		i = 0;
		while (i < resource.getTagCount()) {
			tags.add(expandFunctionCall(resource.getTag(i), resource, expandedValues, i));
			i++;
		}
		List<ExpandedFunctionCall> predicates = new ArrayList();
		i = 0;
		while (i < resource.getPredicateCount()) {
			predicates.add(expandFunctionCall(resource.getPredicate(i), resource, expandedValues, i));
			i++;
		}
		List<ExpandedFunctionCall> macros = new ArrayList();
		i = 0;
		while (i < resource.getMacroCount()) {
			ExpandedFunctionCall thisMacro = expandFunctionCall(resource.getMacro(i), resource, expandedValues, i);
			builder.addMacro(thisMacro);
			macros.add(thisMacro);
			i++;
		}
		Iterator i$ = resource.getRuleList().iterator();
		while (i$.hasNext()) {
			builder.addRule(expandRule((Rule) i$.next(), tags, macros, predicates, resource));
		}
		builder.setVersion(resource.getVersion());
		builder.setResourceFormatVersion(resource.getResourceFormatVersion());
		return builder.build();
	}

	private static ServingValue getServingValue(Value value) throws InvalidResourceException {
		if (!value.hasExtension(ServingValue.ext)) {
			logAndThrow("Expected a ServingValue and didn't get one. Value is: " + value);
		}
		return (ServingValue) value.getExtension(ServingValue.ext);
	}

	private static <T> T getWithBoundsCheck(List<T> list, int idx, String listName) throws InvalidResourceException {
		if (idx < 0 || idx >= list.size()) {
			logAndThrow("Index out of bounds detected: " + idx + " in " + listName);
		}
		return list.get(idx);
	}

	private static <T> T getWithBoundsCheck(T[] array, int idx, String listName) throws InvalidResourceException {
		if (idx < 0 || idx >= array.length) {
			logAndThrow("Index out of bounds detected: " + idx + " in " + listName);
		}
		return array[idx];
	}

	private static void logAndThrow(String error) throws InvalidResourceException {
		Log.e(error);
		throw new InvalidResourceException(error);
	}

	public static Builder newValueBuilderBasedOnValue(Value v) {
		Builder result = Value.newBuilder().setType(v.getType()).addAllEscaping(v.getEscapingList());
		if (v.getContainsReferences()) {
			result.setContainsReferences(true);
		}
		return result;
	}
}
