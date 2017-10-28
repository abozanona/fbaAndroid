package com.google.tagmanager;

import com.google.analytics.containertag.proto.Serving;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

class cs {
    private static ExtensionRegistryLite f1049a;

    public static synchronized ExtensionRegistryLite m1533a() {
        ExtensionRegistryLite extensionRegistryLite;
        synchronized (cs.class) {
            if (f1049a == null) {
                f1049a = ExtensionRegistryLite.newInstance();
                Serving.registerAllExtensions(f1049a);
            }
            extensionRegistryLite = f1049a;
        }
        return extensionRegistryLite;
    }
}
