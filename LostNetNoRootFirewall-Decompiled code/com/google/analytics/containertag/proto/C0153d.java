package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Debug.EventInfo;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0153d extends AbstractParser {
    C0153d() {
    }

    public EventInfo m1024a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new EventInfo(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1024a(codedInputStream, extensionRegistryLite);
    }
}
