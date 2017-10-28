package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.FunctionCall;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0168s extends AbstractParser {
    C0168s() {
    }

    public FunctionCall m1038a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new FunctionCall(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1038a(codedInputStream, extensionRegistryLite);
    }
}
