package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0156g extends AbstractParser {
    C0156g() {
    }

    public ResolvedFunctionCall m1027a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ResolvedFunctionCall(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1027a(codedInputStream, extensionRegistryLite);
    }
}
