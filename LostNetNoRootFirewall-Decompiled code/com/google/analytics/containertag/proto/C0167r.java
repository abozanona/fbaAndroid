package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.Container;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0167r extends AbstractParser {
    C0167r() {
    }

    public Container m1037a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new Container(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1037a(codedInputStream, extensionRegistryLite);
    }
}
