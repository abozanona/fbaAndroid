package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.Rule;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0174y extends AbstractParser {
    C0174y() {
    }

    public Rule m1044a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new Rule(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1044a(codedInputStream, extensionRegistryLite);
    }
}
