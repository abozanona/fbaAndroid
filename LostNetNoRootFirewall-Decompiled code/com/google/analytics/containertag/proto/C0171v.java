package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0171v extends AbstractParser {
    C0171v() {
    }

    public Resource m1041a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new Resource(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1041a(codedInputStream, extensionRegistryLite);
    }
}
