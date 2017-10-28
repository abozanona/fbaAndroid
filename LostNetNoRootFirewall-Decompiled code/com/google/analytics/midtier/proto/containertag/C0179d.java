package com.google.analytics.midtier.proto.containertag;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0179d extends AbstractParser {
    C0179d() {
    }

    public Value m1048a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new Value(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1048a(codedInputStream, extensionRegistryLite);
    }
}
