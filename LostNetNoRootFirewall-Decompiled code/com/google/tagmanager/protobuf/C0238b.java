package com.google.tagmanager.protobuf;

final class C0238b extends AbstractParser {
    final /* synthetic */ MutableMessageLite f1238a;

    C0238b(MutableMessageLite mutableMessageLite) {
        this.f1238a = mutableMessageLite;
    }

    public MutableMessageLite m1821a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Object newMessageForType = this.f1238a.newMessageForType();
        if (newMessageForType.mergeFrom(codedInputStream, extensionRegistryLite)) {
            return newMessageForType;
        }
        throw InvalidProtocolBufferException.parseFailure().setUnfinishedMessage(newMessageForType);
    }

    public /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return m1821a(codedInputStream, extensionRegistryLite);
    }
}
