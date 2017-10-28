package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.CacheOption;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0165p extends AbstractParser {
    C0165p() {
    }

    public CacheOption m1035a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new CacheOption(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1035a(codedInputStream, extensionRegistryLite);
    }
}
