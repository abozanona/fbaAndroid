package android.support.v4.app;

import android.app.Notification;
import java.util.Iterator;

class ao implements ak {
    ao() {
    }

    public Notification mo2a(ai aiVar) {
        as asVar = new as(aiVar.f114a, aiVar.f131r, aiVar.f115b, aiVar.f116c, aiVar.f121h, aiVar.f119f, aiVar.f122i, aiVar.f117d, aiVar.f118e, aiVar.f120g, aiVar.f127n, aiVar.f128o, aiVar.f129p, aiVar.f124k, aiVar.f123j, aiVar.f126m);
        Iterator it = aiVar.f130q.iterator();
        while (it.hasNext()) {
            af afVar = (af) it.next();
            asVar.m116a(afVar.f104a, afVar.f105b, afVar.f106c);
        }
        if (aiVar.f125l != null) {
            if (aiVar.f125l instanceof ah) {
                ah ahVar = (ah) aiVar.f125l;
                asVar.m118a(ahVar.d, ahVar.f, ahVar.e, ahVar.f113a);
            } else if (aiVar.f125l instanceof aj) {
                aj ajVar = (aj) aiVar.f125l;
                asVar.m119a(ajVar.d, ajVar.f, ajVar.e, ajVar.f132a);
            } else if (aiVar.f125l instanceof ag) {
                ag agVar = (ag) aiVar.f125l;
                asVar.m117a(agVar.d, agVar.f, agVar.e, agVar.f110a, agVar.f111b, agVar.f112c);
            }
        }
        return asVar.m115a();
    }
}
