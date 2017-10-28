package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.AbstractMessageLite.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Collection;

public abstract class AbstractMutableMessageLite implements MutableMessageLite {
    protected int cachedSize = -1;
    private boolean isMutable = true;

    protected static void addAll(Iterable iterable, Collection collection) {
        Builder.addAll(iterable, collection);
    }

    protected static Parser internalNewParserForType(MutableMessageLite mutableMessageLite) {
        return new C0238b(mutableMessageLite);
    }

    protected static UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
        return new UninitializedMessageException(messageLite);
    }

    protected void assertMutable() {
        if (!this.isMutable) {
            throw new IllegalStateException("Try to modify an immutable message.");
        }
    }

    public MutableMessageLite clone() {
        throw new UnsupportedOperationException("clone() should be implemented by subclasses.");
    }

    public final int getCachedSize() {
        return this.cachedSize;
    }

    protected boolean isProto1Group() {
        return false;
    }

    protected void makeImmutable() {
        this.isMutable = false;
    }

    public boolean mergeDelimitedFrom(InputStream inputStream) {
        return mergeDelimitedFrom(inputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        boolean z = false;
        try {
            int read = inputStream.read();
            if (read != -1) {
                z = mergeFrom(new C0237a(inputStream, CodedInputStream.readRawVarint32(read, inputStream)), extensionRegistryLite);
            }
        } catch (IOException e) {
        }
        return z;
    }

    public boolean mergeFrom(ByteString byteString) {
        CodedInputStream newCodedInput = byteString.newCodedInput();
        return mergeFrom(newCodedInput) && newCodedInput.getLastTag() == 0;
    }

    public boolean mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream newCodedInput = byteString.newCodedInput();
        return mergeFrom(newCodedInput, extensionRegistryLite) && newCodedInput.getLastTag() == 0;
    }

    public boolean mergeFrom(CodedInputStream codedInputStream) {
        return mergeFrom(codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    public boolean mergeFrom(InputStream inputStream) {
        CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
        return mergeFrom(newInstance) && newInstance.getLastTag() == 0;
    }

    public boolean mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
        return mergeFrom(newInstance, extensionRegistryLite) && newInstance.getLastTag() == 0;
    }

    public boolean mergeFrom(ByteBuffer byteBuffer) {
        CodedInputStream newInstance = CodedInputStream.newInstance(byteBuffer);
        return mergeFrom(newInstance) && newInstance.getLastTag() == 0;
    }

    public boolean mergeFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream newInstance = CodedInputStream.newInstance(byteBuffer);
        return mergeFrom(newInstance, extensionRegistryLite) && newInstance.getLastTag() == 0;
    }

    public boolean mergeFrom(byte[] bArr) {
        return mergeFrom(bArr, 0, bArr.length);
    }

    public boolean mergeFrom(byte[] bArr, int i, int i2) {
        CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i, i2);
        return mergeFrom(newInstance) && newInstance.getLastTag() == 0;
    }

    public boolean mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i, i2);
        return mergeFrom(newInstance, extensionRegistryLite) && newInstance.getLastTag() == 0;
    }

    public boolean mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return mergeFrom(bArr, 0, bArr.length, extensionRegistryLite);
    }

    public boolean mergePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return mergeFrom(codedInputStream, extensionRegistryLite);
    }

    public MutableMessageLite mutableCopy() {
        throw new UnsupportedOperationException("mutableCopy() is not supported in mutable messages. Use clone() if you need to make a copy of the mutable message.");
    }

    public MessageLite.Builder newBuilderForType() {
        throw new UnsupportedOperationException("newBuilderForType() is not supported in mutable messages.");
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException((MessageLite) this);
    }

    public boolean parseDelimitedFrom(InputStream inputStream) {
        clear();
        return mergeDelimitedFrom(inputStream);
    }

    public boolean parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        clear();
        return mergeDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public boolean parseFrom(ByteString byteString) {
        clear();
        return mergeFrom(byteString);
    }

    public boolean parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        clear();
        return mergeFrom(byteString, extensionRegistryLite);
    }

    public boolean parseFrom(CodedInputStream codedInputStream) {
        clear();
        return mergeFrom(codedInputStream);
    }

    public boolean parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        clear();
        return mergeFrom(codedInputStream, extensionRegistryLite);
    }

    public boolean parseFrom(InputStream inputStream) {
        clear();
        return mergeFrom(inputStream);
    }

    public boolean parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        clear();
        return mergeFrom(inputStream, extensionRegistryLite);
    }

    public boolean parseFrom(ByteBuffer byteBuffer) {
        clear();
        return mergeFrom(byteBuffer);
    }

    public boolean parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        clear();
        return mergeFrom(byteBuffer, extensionRegistryLite);
    }

    public boolean parseFrom(byte[] bArr) {
        clear();
        return mergeFrom(bArr, 0, bArr.length);
    }

    public boolean parseFrom(byte[] bArr, int i, int i2) {
        clear();
        return mergeFrom(bArr, i, i2);
    }

    public boolean parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
        clear();
        return mergeFrom(bArr, i, i2, extensionRegistryLite);
    }

    public boolean parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        clear();
        return mergeFrom(bArr, 0, bArr.length, extensionRegistryLite);
    }

    public MessageLite.Builder toBuilder() {
        throw new UnsupportedOperationException("toBuilder() is not supported in mutable messages.");
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr);
            writeTo(newInstance);
            newInstance.checkNoSpaceLeft();
            return bArr;
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public ByteString toByteString() {
        try {
            C0244g newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(newCodedBuilder.m1829b());
            return newCodedBuilder.m1828a();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize));
        newInstance.writeRawVarint32(serializedSize);
        writeTo(newInstance);
        newInstance.flush();
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        writeToWithCachedSizes(codedOutputStream);
    }

    public void writeTo(OutputStream outputStream) {
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
        writeTo(newInstance);
        newInstance.flush();
    }
}
