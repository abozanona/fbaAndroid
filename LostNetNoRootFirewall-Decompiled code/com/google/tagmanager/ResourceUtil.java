package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.proto.Serving.FunctionCall;
import com.google.analytics.containertag.proto.Serving.Property;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.containertag.proto.Serving.Rule;
import com.google.analytics.containertag.proto.Serving.ServingValue;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ResourceUtil {

    public class ExpandedFunctionCall {
        private final Map mPropertiesMap;

        private ExpandedFunctionCall(Map map) {
            this.mPropertiesMap = map;
        }

        public static ExpandedFunctionCallBuilder newBuilder() {
            return new ExpandedFunctionCallBuilder();
        }

        public Map getProperties() {
            return Collections.unmodifiableMap(this.mPropertiesMap);
        }

        public String toString() {
            return "Properties: " + getProperties();
        }

        public void updateCacheableProperty(String str, Value value) {
            this.mPropertiesMap.put(str, value);
        }
    }

    public class ExpandedFunctionCallBuilder {
        private final Map mPropertiesMap;

        private ExpandedFunctionCallBuilder() {
            this.mPropertiesMap = new HashMap();
        }

        public ExpandedFunctionCallBuilder addProperty(String str, Value value) {
            this.mPropertiesMap.put(str, value);
            return this;
        }

        public ExpandedFunctionCall build() {
            return new ExpandedFunctionCall(this.mPropertiesMap);
        }
    }

    public class ExpandedResource {
        private final Map mMacros;
        private final int mResourceFormatVersion;
        private final List mRules;
        private final String mVersion;

        private ExpandedResource(List list, Map map, String str, int i) {
            this.mRules = Collections.unmodifiableList(list);
            this.mMacros = Collections.unmodifiableMap(map);
            this.mVersion = str;
            this.mResourceFormatVersion = i;
        }

        public static ExpandedResourceBuilder newBuilder() {
            return new ExpandedResourceBuilder();
        }

        public Map getAllMacros() {
            return this.mMacros;
        }

        public List getMacros(String str) {
            return (List) this.mMacros.get(str);
        }

        public int getResourceFormatVersion() {
            return this.mResourceFormatVersion;
        }

        public List getRules() {
            return this.mRules;
        }

        public String getVersion() {
            return this.mVersion;
        }

        public String toString() {
            return "Rules: " + getRules() + "  Macros: " + this.mMacros;
        }
    }

    public class ExpandedResourceBuilder {
        private final Map mMacros;
        private final List mPredicates;
        private int mResourceFormatVersion;
        private final List mRules;
        private final List mTags;
        private String mVersion;

        private ExpandedResourceBuilder() {
            this.mRules = new ArrayList();
            this.mTags = new ArrayList();
            this.mPredicates = new ArrayList();
            this.mMacros = new HashMap();
            this.mVersion = "";
            this.mResourceFormatVersion = 0;
        }

        public ExpandedResourceBuilder addMacro(ExpandedFunctionCall expandedFunctionCall) {
            String a = es.m1668a((Value) expandedFunctionCall.getProperties().get(Key.INSTANCE_NAME.toString()));
            List list = (List) this.mMacros.get(a);
            if (list == null) {
                list = new ArrayList();
                this.mMacros.put(a, list);
            }
            list.add(expandedFunctionCall);
            return this;
        }

        public ExpandedResourceBuilder addRule(ExpandedRule expandedRule) {
            this.mRules.add(expandedRule);
            return this;
        }

        public ExpandedResource build() {
            return new ExpandedResource(this.mRules, this.mMacros, this.mVersion, this.mResourceFormatVersion);
        }

        public ExpandedResourceBuilder setResourceFormatVersion(int i) {
            this.mResourceFormatVersion = i;
            return this;
        }

        public ExpandedResourceBuilder setVersion(String str) {
            this.mVersion = str;
            return this;
        }
    }

    public class ExpandedRule {
        private final List mAddMacroRuleNames;
        private final List mAddMacros;
        private final List mAddTagRuleNames;
        private final List mAddTags;
        private final List mNegativePredicates;
        private final List mPositivePredicates;
        private final List mRemoveMacroRuleNames;
        private final List mRemoveMacros;
        private final List mRemoveTagRuleNames;
        private final List mRemoveTags;

        private ExpandedRule(List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10) {
            this.mPositivePredicates = Collections.unmodifiableList(list);
            this.mNegativePredicates = Collections.unmodifiableList(list2);
            this.mAddTags = Collections.unmodifiableList(list3);
            this.mRemoveTags = Collections.unmodifiableList(list4);
            this.mAddMacros = Collections.unmodifiableList(list5);
            this.mRemoveMacros = Collections.unmodifiableList(list6);
            this.mAddMacroRuleNames = Collections.unmodifiableList(list7);
            this.mRemoveMacroRuleNames = Collections.unmodifiableList(list8);
            this.mAddTagRuleNames = Collections.unmodifiableList(list9);
            this.mRemoveTagRuleNames = Collections.unmodifiableList(list10);
        }

        public static ExpandedRuleBuilder newBuilder() {
            return new ExpandedRuleBuilder();
        }

        public List getAddMacroRuleNames() {
            return this.mAddMacroRuleNames;
        }

        public List getAddMacros() {
            return this.mAddMacros;
        }

        public List getAddTagRuleNames() {
            return this.mAddTagRuleNames;
        }

        public List getAddTags() {
            return this.mAddTags;
        }

        public List getNegativePredicates() {
            return this.mNegativePredicates;
        }

        public List getPositivePredicates() {
            return this.mPositivePredicates;
        }

        public List getRemoveMacroRuleNames() {
            return this.mRemoveMacroRuleNames;
        }

        public List getRemoveMacros() {
            return this.mRemoveMacros;
        }

        public List getRemoveTagRuleNames() {
            return this.mRemoveTagRuleNames;
        }

        public List getRemoveTags() {
            return this.mRemoveTags;
        }

        public String toString() {
            return "Positive predicates: " + getPositivePredicates() + "  Negative predicates: " + getNegativePredicates() + "  Add tags: " + getAddTags() + "  Remove tags: " + getRemoveTags() + "  Add macros: " + getAddMacros() + "  Remove macros: " + getRemoveMacros();
        }
    }

    public class ExpandedRuleBuilder {
        private final List mAddMacroRuleNames;
        private final List mAddMacros;
        private final List mAddTagRuleNames;
        private final List mAddTags;
        private final List mNegativePredicates;
        private final List mPositivePredicates;
        private final List mRemoveMacroRuleNames;
        private final List mRemoveMacros;
        private final List mRemoveTagRuleNames;
        private final List mRemoveTags;

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

        public ExpandedRuleBuilder addAddMacro(ExpandedFunctionCall expandedFunctionCall) {
            this.mAddMacros.add(expandedFunctionCall);
            return this;
        }

        public ExpandedRuleBuilder addAddMacroRuleName(String str) {
            this.mAddMacroRuleNames.add(str);
            return this;
        }

        public ExpandedRuleBuilder addAddTag(ExpandedFunctionCall expandedFunctionCall) {
            this.mAddTags.add(expandedFunctionCall);
            return this;
        }

        public ExpandedRuleBuilder addAddTagRuleName(String str) {
            this.mAddTagRuleNames.add(str);
            return this;
        }

        public ExpandedRuleBuilder addNegativePredicate(ExpandedFunctionCall expandedFunctionCall) {
            this.mNegativePredicates.add(expandedFunctionCall);
            return this;
        }

        public ExpandedRuleBuilder addPositivePredicate(ExpandedFunctionCall expandedFunctionCall) {
            this.mPositivePredicates.add(expandedFunctionCall);
            return this;
        }

        public ExpandedRuleBuilder addRemoveMacro(ExpandedFunctionCall expandedFunctionCall) {
            this.mRemoveMacros.add(expandedFunctionCall);
            return this;
        }

        public ExpandedRuleBuilder addRemoveMacroRuleName(String str) {
            this.mRemoveMacroRuleNames.add(str);
            return this;
        }

        public ExpandedRuleBuilder addRemoveTag(ExpandedFunctionCall expandedFunctionCall) {
            this.mRemoveTags.add(expandedFunctionCall);
            return this;
        }

        public ExpandedRuleBuilder addRemoveTagRuleName(String str) {
            this.mRemoveTagRuleNames.add(str);
            return this;
        }

        public ExpandedRule build() {
            return new ExpandedRule(this.mPositivePredicates, this.mNegativePredicates, this.mAddTags, this.mRemoveTags, this.mAddMacros, this.mRemoveMacros, this.mAddMacroRuleNames, this.mRemoveMacroRuleNames, this.mAddTagRuleNames, this.mRemoveTagRuleNames);
        }
    }

    public class InvalidResourceException extends Exception {
        public InvalidResourceException(String str) {
            super(str);
        }
    }

    public static Builder m1306a(Value value) {
        Builder addAllEscaping = Value.newBuilder().setType(value.getType()).addAllEscaping(value.getEscapingList());
        if (value.getContainsReferences()) {
            addAllEscaping.setContainsReferences(true);
        }
        return addAllEscaping;
    }

    private static Value m1307a(int i, Resource resource, Value[] valueArr, Set set) {
        if (set.contains(Integer.valueOf(i))) {
            m1313a("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        Value value = (Value) m1311a(resource.getValueList(), i, "values");
        if (valueArr[i] != null) {
            return valueArr[i];
        }
        Value value2 = null;
        set.add(Integer.valueOf(i));
        Builder a;
        switch (dl.f1090a[value.getType().ordinal()]) {
            case 1:
                a = m1306a(value);
                for (Integer intValue : m1314b(value).getListItemList()) {
                    a.addListItem(m1307a(intValue.intValue(), resource, valueArr, set));
                }
                value2 = a.build();
                break;
            case 2:
                a = m1306a(value);
                ServingValue b = m1314b(value);
                if (b.getMapKeyCount() != b.getMapValueCount()) {
                    m1313a("Uneven map keys (" + b.getMapKeyCount() + ") and map values (" + b.getMapValueCount() + ")");
                }
                for (Integer intValue2 : b.getMapKeyList()) {
                    a.addMapKey(m1307a(intValue2.intValue(), resource, valueArr, set));
                }
                for (Integer intValue22 : b.getMapValueList()) {
                    a.addMapValue(m1307a(intValue22.intValue(), resource, valueArr, set));
                }
                value2 = a.build();
                break;
            case 3:
                String a2;
                a = m1306a(value);
                ServingValue b2 = m1314b(value);
                if (b2.hasMacroNameReference()) {
                    a2 = es.m1668a(m1307a(b2.getMacroNameReference(), resource, valueArr, set));
                } else {
                    m1313a("Missing macro name reference");
                    a2 = "";
                }
                a.setMacroReference(a2);
                value2 = a.build();
                break;
            case 4:
                a = m1306a(value);
                for (Integer intValue222 : m1314b(value).getTemplateTokenList()) {
                    a.addTemplateToken(m1307a(intValue222.intValue(), resource, valueArr, set));
                }
                value2 = a.build();
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                value2 = value;
                break;
        }
        if (value2 == null) {
            m1313a("Invalid value: " + value);
        }
        valueArr[i] = value2;
        set.remove(Integer.valueOf(i));
        return value2;
    }

    private static ExpandedFunctionCall m1308a(FunctionCall functionCall, Resource resource, Value[] valueArr, int i) {
        ExpandedFunctionCallBuilder newBuilder = ExpandedFunctionCall.newBuilder();
        for (Integer intValue : functionCall.getPropertyList()) {
            Property property = (Property) m1311a(resource.getPropertyList(), intValue.intValue(), "properties");
            newBuilder.addProperty((String) m1311a(resource.getKeyList(), property.getKey(), "keys"), (Value) m1312a((Object[]) valueArr, property.getValue(), "values"));
        }
        return newBuilder.build();
    }

    public static ExpandedResource m1309a(Resource resource) {
        int i;
        int i2 = 0;
        Value[] valueArr = new Value[resource.getValueCount()];
        for (i = 0; i < resource.getValueCount(); i++) {
            m1307a(i, resource, valueArr, new HashSet(0));
        }
        ExpandedResourceBuilder newBuilder = ExpandedResource.newBuilder();
        List arrayList = new ArrayList();
        for (i = 0; i < resource.getTagCount(); i++) {
            arrayList.add(m1308a(resource.getTag(i), resource, valueArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < resource.getPredicateCount(); i++) {
            arrayList2.add(m1308a(resource.getPredicate(i), resource, valueArr, i));
        }
        List arrayList3 = new ArrayList();
        while (i2 < resource.getMacroCount()) {
            ExpandedFunctionCall a = m1308a(resource.getMacro(i2), resource, valueArr, i2);
            newBuilder.addMacro(a);
            arrayList3.add(a);
            i2++;
        }
        for (Rule a2 : resource.getRuleList()) {
            newBuilder.addRule(m1310a(a2, arrayList, arrayList3, arrayList2, resource));
        }
        newBuilder.setVersion(resource.getVersion());
        newBuilder.setResourceFormatVersion(resource.getResourceFormatVersion());
        return newBuilder.build();
    }

    private static ExpandedRule m1310a(Rule rule, List list, List list2, List list3, Resource resource) {
        ExpandedRuleBuilder newBuilder = ExpandedRule.newBuilder();
        for (Integer intValue : rule.getPositivePredicateList()) {
            newBuilder.addPositivePredicate((ExpandedFunctionCall) list3.get(intValue.intValue()));
        }
        for (Integer intValue2 : rule.getNegativePredicateList()) {
            newBuilder.addNegativePredicate((ExpandedFunctionCall) list3.get(intValue2.intValue()));
        }
        for (Integer intValue22 : rule.getAddTagList()) {
            newBuilder.addAddTag((ExpandedFunctionCall) list.get(intValue22.intValue()));
        }
        for (Integer intValue222 : rule.getAddTagRuleNameList()) {
            newBuilder.addAddTagRuleName(resource.getValue(intValue222.intValue()).getString());
        }
        for (Integer intValue2222 : rule.getRemoveTagList()) {
            newBuilder.addRemoveTag((ExpandedFunctionCall) list.get(intValue2222.intValue()));
        }
        for (Integer intValue22222 : rule.getRemoveTagRuleNameList()) {
            newBuilder.addRemoveTagRuleName(resource.getValue(intValue22222.intValue()).getString());
        }
        for (Integer intValue222222 : rule.getAddMacroList()) {
            newBuilder.addAddMacro((ExpandedFunctionCall) list2.get(intValue222222.intValue()));
        }
        for (Integer intValue2222222 : rule.getAddMacroRuleNameList()) {
            newBuilder.addAddMacroRuleName(resource.getValue(intValue2222222.intValue()).getString());
        }
        for (Integer intValue22222222 : rule.getRemoveMacroList()) {
            newBuilder.addRemoveMacro((ExpandedFunctionCall) list2.get(intValue22222222.intValue()));
        }
        for (Integer intValue222222222 : rule.getRemoveMacroRuleNameList()) {
            newBuilder.addRemoveMacroRuleName(resource.getValue(intValue222222222.intValue()).getString());
        }
        return newBuilder.build();
    }

    private static Object m1311a(List list, int i, String str) {
        if (i < 0 || i >= list.size()) {
            m1313a("Index out of bounds detected: " + i + " in " + str);
        }
        return list.get(i);
    }

    private static Object m1312a(Object[] objArr, int i, String str) {
        if (i < 0 || i >= objArr.length) {
            m1313a("Index out of bounds detected: " + i + " in " + str);
        }
        return objArr[i];
    }

    private static void m1313a(String str) {
        bs.m1438a(str);
        throw new InvalidResourceException(str);
    }

    private static ServingValue m1314b(Value value) {
        if (!value.hasExtension(ServingValue.ext)) {
            m1313a("Expected a ServingValue and didn't get one. Value is: " + value);
        }
        return (ServingValue) value.getExtension(ServingValue.ext);
    }
}
