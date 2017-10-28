package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Debug.DataLayerEventEvaluationInfo;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0151b extends AbstractParser {
    C0151b() {
    }

    public DataLayerEventEvaluationInfo m1022a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new DataLayerEventEvaluationInfo(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1022a(codedInputStream, extensionRegistryLite);
    }
}
