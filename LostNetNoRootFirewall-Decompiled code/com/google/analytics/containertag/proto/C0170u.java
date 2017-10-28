package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.Property;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0170u extends AbstractParser {
    C0170u() {
    }

    public Property m1040a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new Property(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1040a(codedInputStream, extensionRegistryLite);
    }
}
