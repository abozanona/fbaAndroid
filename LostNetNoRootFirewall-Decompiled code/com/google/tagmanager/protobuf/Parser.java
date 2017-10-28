package com.google.tagmanager.protobuf;

import java.io.InputStream;

public interface Parser {
    Object parseDelimitedFrom(InputStream inputStream);

    Object parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    Object parseFrom(ByteString byteString);

    Object parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite);

    Object parseFrom(CodedInputStream codedInputStream);

    Object parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

    Object parseFrom(InputStream inputStream);

    Object parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    Object parseFrom(byte[] bArr);

    Object parseFrom(byte[] bArr, int i, int i2);

    Object parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite);

    Object parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite);

    Object parsePartialDelimitedFrom(InputStream inputStream);

    Object parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    Object parsePartialFrom(ByteString byteString);

    Object parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite);

    Object parsePartialFrom(CodedInputStream codedInputStream);

    Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

    Object parsePartialFrom(InputStream inputStream);

    Object parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    Object parsePartialFrom(byte[] bArr);

    Object parsePartialFrom(byte[] bArr, int i, int i2);

    Object parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite);

    Object parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite);
}
