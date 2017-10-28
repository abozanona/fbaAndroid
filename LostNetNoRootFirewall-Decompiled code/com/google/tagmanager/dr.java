package com.google.tagmanager;

import com.google.tagmanager.ResourceUtil.ExpandedRule;
import java.util.Set;

class dr implements dt {
    final /* synthetic */ dn f1109a;

    dr(dn dnVar) {
        this.f1109a = dnVar;
    }

    public void mo669a(ExpandedRule expandedRule, Set set, Set set2, db dbVar) {
        set.addAll(expandedRule.getAddTags());
        set2.addAll(expandedRule.getRemoveTags());
        dbVar.mo600e().translateAndAddAll(expandedRule.getAddTags(), expandedRule.getAddTagRuleNames());
        dbVar.mo601f().translateAndAddAll(expandedRule.getRemoveTags(), expandedRule.getRemoveTagRuleNames());
    }
}
