package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.ResolvedFunctionCall;
import com.google.analytics.containertag.proto.MutableDebug.ResolvedProperty;
import com.google.analytics.containertag.proto.MutableDebug.ResolvedRule;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.ResourceUtil.ExpandedFunctionCall;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

class DebugResolvedRuleBuilder implements ResolvedRuleBuilder {
	ResolvedFunctionCallTranslatorList addMacrosHolder;
	ResolvedFunctionCallTranslatorList addTagsHolder;
	ResolvedFunctionCallTranslatorList removeMacrosHolder;
	ResolvedFunctionCallTranslatorList removeTagsHolder;
	ResolvedRule resolvedRule;

	class DebugResolvedFunctionCallListTranslator implements ResolvedFunctionCallTranslatorList {
		@VisibleForTesting
		List<ResolvedFunctionCall> toBuild;

		DebugResolvedFunctionCallListTranslator(List<ResolvedFunctionCall> result) {
			this.toBuild = result;
		}

		public void translateAndAddAll(List<ExpandedFunctionCall> functions, List<String> ruleNames) {
			int i = 0;
			while (i < functions.size()) {
				this.toBuild.add(DebugResolvedRuleBuilder.translateExpandedFunctionCall((ExpandedFunctionCall) functions.get(i)));
				if (i < ruleNames.size()) {
					((ResolvedFunctionCall) this.toBuild.get(i)).setAssociatedRuleName((String) ruleNames.get(i));
				} else {
					((ResolvedFunctionCall) this.toBuild.get(i)).setAssociatedRuleName("Unknown");
				}
				i++;
			}
		}
	}


	public DebugResolvedRuleBuilder(ResolvedRule rule) {
		this.resolvedRule = rule;
		this.addMacrosHolder = new DebugResolvedFunctionCallListTranslator(this.resolvedRule.getMutableAddMacrosList());
		this.removeMacrosHolder = new DebugResolvedFunctionCallListTranslator(this.resolvedRule.getMutableRemoveMacrosList());
		this.addTagsHolder = new DebugResolvedFunctionCallListTranslator(this.resolvedRule.getMutableAddTagsList());
		this.removeTagsHolder = new DebugResolvedFunctionCallListTranslator(this.resolvedRule.getMutableRemoveTagsList());
	}

	public static ResolvedFunctionCall translateExpandedFunctionCall(ExpandedFunctionCall f) {
		ResolvedFunctionCall result = ResolvedFunctionCall.newMessage();
		Iterator i$ = f.getProperties().entrySet().iterator();
		while (i$.hasNext()) {
			Entry<String, Value> originalParam = (Entry) i$.next();
			ResolvedProperty prop = ResolvedProperty.newMessage();
			prop.setKey((String) originalParam.getKey());
			prop.setValue(DebugValueBuilder.copyImmutableValue((Value) originalParam.getValue()));
			result.addProperties(prop);
		}
		return result;
	}

	public ResolvedFunctionCallBuilder createNegativePredicate() {
		return new DebugResolvedFunctionCallBuilder(this.resolvedRule.addNegativePredicates());
	}

	public ResolvedFunctionCallBuilder createPositivePredicate() {
		return new DebugResolvedFunctionCallBuilder(this.resolvedRule.addPositivePredicates());
	}

	public ResolvedFunctionCallTranslatorList getAddedMacroFunctions() {
		return this.addMacrosHolder;
	}

	public ResolvedFunctionCallTranslatorList getAddedTagFunctions() {
		return this.addTagsHolder;
	}

	public ResolvedFunctionCallTranslatorList getRemovedMacroFunctions() {
		return this.removeMacrosHolder;
	}

	public ResolvedFunctionCallTranslatorList getRemovedTagFunctions() {
		return this.removeTagsHolder;
	}

	public void setValue(Value result) {
		this.resolvedRule.setResult(DebugValueBuilder.copyImmutableValue(result));
	}
}
