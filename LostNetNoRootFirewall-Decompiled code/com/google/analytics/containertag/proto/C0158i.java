package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Debug.ResolvedRule;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0158i extends AbstractParser {
    C0158i() {
    }

    public ResolvedRule m1029a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ResolvedRule(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1029a(codedInputStream, extensionRegistryLite);
    }
}
