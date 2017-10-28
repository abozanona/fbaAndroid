package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.OptionalResource;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0169t extends AbstractParser {
    C0169t() {
    }

    public OptionalResource m1039a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new OptionalResource(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1039a(codedInputStream, extensionRegistryLite);
    }
}
