package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Debug.MacroEvaluationInfo;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0155f extends AbstractParser {
    C0155f() {
    }

    public MacroEvaluationInfo m1026a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new MacroEvaluationInfo(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1026a(codedInputStream, extensionRegistryLite);
    }
}
