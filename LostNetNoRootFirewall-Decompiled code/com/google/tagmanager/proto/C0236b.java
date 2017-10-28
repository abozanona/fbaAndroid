package com.google.tagmanager.proto;

import com.google.tagmanager.proto.Resource.ResourceWithMetadata;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

final class C0236b extends AbstractParser {
    C0236b() {
    }

    public ResourceWithMetadata m1727a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ResourceWithMetadata(codedInputStream, extensionRegistryLite);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1727a(codedInputStream, extensionRegistryLite);
    }
}
