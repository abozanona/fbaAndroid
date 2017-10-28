package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.ServingValue;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0175z extends AbstractParser {
    C0175z() {
    }

    public ServingValue m1045a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ServingValue(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1045a(codedInputStream, extensionRegistryLite);
    }
}
