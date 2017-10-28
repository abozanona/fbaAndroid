package com.google.tagmanager;

import com.google.analytics.tracking.android.HitTypes;
import java.util.Map;

class ei implements ae {
    final /* synthetic */ TagManager f1149a;

    ei(TagManager tagManager) {
        this.f1149a = tagManager;
    }

    public void mo631a(Map map) {
        Object obj = map.get(HitTypes.EVENT);
        if (obj != null) {
            this.f1149a.refreshTagsInAllContainers(obj.toString());
        }
    }
}
