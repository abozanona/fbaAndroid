package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Debug.RuleEvaluationStepInfo;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0159j extends AbstractParser {
    C0159j() {
    }

    public RuleEvaluationStepInfo m1030a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new RuleEvaluationStepInfo(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1030a(codedInputStream, extensionRegistryLite);
    }
}
