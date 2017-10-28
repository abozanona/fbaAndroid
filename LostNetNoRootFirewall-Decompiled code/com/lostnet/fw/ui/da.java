package com.lostnet.fw.ui;

import java.util.Comparator;

class da implements Comparator {
    final /* synthetic */ LogsActivity f1760a;

    private da(LogsActivity logsActivity) {
        this.f1760a = logsActivity;
    }

    public int m2111a(cx cxVar, cx cxVar2) {
        return cxVar.f1748a.f1751a < cxVar2.f1748a.f1751a ? 1 : cxVar.f1748a.f1751a > cxVar2.f1748a.f1751a ? -1 : cxVar.f1748a.f1752b >= cxVar2.f1748a.f1752b ? cxVar.f1748a.f1752b > cxVar2.f1748a.f1752b ? -1 : 0 : 1;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2111a((cx) obj, (cx) obj2);
    }
}
