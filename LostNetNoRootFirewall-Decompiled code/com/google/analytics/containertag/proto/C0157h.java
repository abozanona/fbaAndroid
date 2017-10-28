package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Debug.ResolvedProperty;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0157h extends AbstractParser {
    C0157h() {
    }

    public ResolvedProperty m1028a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ResolvedProperty(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1028a(codedInputStream, extensionRegistryLite);
    }
}
