package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Debug.DebugEvents;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0152c extends AbstractParser {
    C0152c() {
    }

    public DebugEvents m1023a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DebugEvents(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1023a(codedInputStream, extensionRegistryLite);
    }
}
