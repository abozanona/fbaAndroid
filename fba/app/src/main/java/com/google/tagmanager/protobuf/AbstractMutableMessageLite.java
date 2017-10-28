package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.AbstractMessageLite.Builder;
import com.google.tagmanager.protobuf.AbstractMessageLite.Builder.LimitedInputStream;
import com.google.tagmanager.protobuf.ByteString.CodedBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Collection;

public abstract class AbstractMutableMessageLite implements MutableMessageLite {
	protected int cachedSize;
	private boolean isMutable;

	static class AnonymousClass_1 extends AbstractParser<T> {
		final /* synthetic */ MutableMessageLite val$defaultInstance;

		AnonymousClass_1(MutableMessageLite r1_MutableMessageLite) {
			this.val$defaultInstance = r1_MutableMessageLite;
		}

		public T parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			T message = this.val$defaultInstance.newMessageForType();
			if (!message.mergeFrom(input, extensionRegistry)) {
				throw InvalidProtocolBufferException.parseFailure().setUnfinishedMessage(message);
			}
			return message;
		}
	}


	public AbstractMutableMessageLite() {
		this.isMutable = true;
		this.cachedSize = -1;
	}

	protected static <T> void addAll(Iterable<T> values, Collection<T> list) {
		Builder.addAll(values, list);
	}

	protected static <T extends MutableMessageLite> Parser<T> internalNewParserForType(T defaultInstance) {
		return new AnonymousClass_1(defaultInstance);
	}

	protected static UninitializedMessageException newUninitializedMessageException(MessageLite message) {
		return new UninitializedMessageException(message);
	}

	protected void assertMutable() {
		if (!(this.isMutable)) {
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

	public boolean mergeDelimitedFrom(InputStream input) {
		return mergeDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());
	}

	public boolean mergeDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) {
		int firstByte;
		boolean r4z = false;
		try {
			firstByte = input.read();
			if (firstByte == -1) {
				return r4z;
			} else {
				r4z = mergeFrom(new LimitedInputStream(input, CodedInputStream.readRawVarint32(firstByte, input)), extensionRegistry);
				return r4z;
			}
		} catch (IOException e) {
		}
	}

	public boolean mergeFrom(ByteString data) {
		CodedInputStream input = data.newCodedInput();
		return mergeFrom(input) && input.getLastTag() == 0;
	}

	public boolean mergeFrom(ByteString data, ExtensionRegistryLite extensionRegistry) {
		CodedInputStream input = data.newCodedInput();
		return mergeFrom(input, extensionRegistry) && input.getLastTag() == 0;
	}

	public boolean mergeFrom(CodedInputStream input) {
		return mergeFrom(input, ExtensionRegistryLite.getEmptyRegistry());
	}

	public boolean mergeFrom(InputStream input) {
		CodedInputStream codedInput = CodedInputStream.newInstance(input);
		return mergeFrom(codedInput) && codedInput.getLastTag() == 0;
	}

	public boolean mergeFrom(InputStream input, ExtensionRegistryLite extensionRegistry) {
		CodedInputStream codedInput = CodedInputStream.newInstance(input);
		return mergeFrom(codedInput, extensionRegistry) && codedInput.getLastTag() == 0;
	}

	public boolean mergeFrom(ByteBuffer data) {
		CodedInputStream input = CodedInputStream.newInstance(data);
		return mergeFrom(input) && input.getLastTag() == 0;
	}

	public boolean mergeFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) {
		CodedInputStream input = CodedInputStream.newInstance(data);
		return mergeFrom(input, extensionRegistry) && input.getLastTag() == 0;
	}

	public boolean mergeFrom(byte[] data) {
		return mergeFrom(data, 0, data.length);
	}

	public boolean mergeFrom(byte[] data, int off, int len) {
		CodedInputStream input = CodedInputStream.newInstance(data, off, len);
		return mergeFrom(input) && input.getLastTag() == 0;
	}

	public boolean mergeFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) {
		CodedInputStream input = CodedInputStream.newInstance(data, off, len);
		return mergeFrom(input, extensionRegistry) && input.getLastTag() == 0;
	}

	public boolean mergeFrom(byte[] data, ExtensionRegistryLite extensionRegistry) {
		return mergeFrom(data, 0, data.length, extensionRegistry);
	}

	public boolean mergePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
		return mergeFrom(input, extensionRegistry);
	}

	public MutableMessageLite mutableCopy() {
		throw new UnsupportedOperationException("mutableCopy() is not supported in mutable messages. Use clone() if you need to make a copy of the mutable message.");
	}

	public MessageLite.Builder newBuilderForType() {
		throw new UnsupportedOperationException("newBuilderForType() is not supported in mutable messages.");
	}

	UninitializedMessageException newUninitializedMessageException() {
		return new UninitializedMessageException((MessageLite)this);
	}

	public boolean parseDelimitedFrom(InputStream input) {
		clear();
		return mergeDelimitedFrom(input);
	}

	public boolean parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) {
		clear();
		return mergeDelimitedFrom(input, extensionRegistry);
	}

	public boolean parseFrom(ByteString data) {
		clear();
		return mergeFrom(data);
	}

	public boolean parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) {
		clear();
		return mergeFrom(data, extensionRegistry);
	}

	public boolean parseFrom(CodedInputStream input) {
		clear();
		return mergeFrom(input);
	}

	public boolean parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
		clear();
		return mergeFrom(input, extensionRegistry);
	}

	public boolean parseFrom(InputStream input) {
		clear();
		return mergeFrom(input);
	}

	public boolean parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) {
		clear();
		return mergeFrom(input, extensionRegistry);
	}

	public boolean parseFrom(ByteBuffer data) {
		clear();
		return mergeFrom(data);
	}

	public boolean parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) {
		clear();
		return mergeFrom(data, extensionRegistry);
	}

	public boolean parseFrom(byte[] data) {
		clear();
		return mergeFrom(data, 0, data.length);
	}

	public boolean parseFrom(byte[] data, int off, int len) {
		clear();
		return mergeFrom(data, off, len);
	}

	public boolean parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) {
		clear();
		return mergeFrom(data, off, len, extensionRegistry);
	}

	public boolean parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) {
		clear();
		return mergeFrom(data, 0, data.length, extensionRegistry);
	}

	public MessageLite.Builder toBuilder() {
		throw new UnsupportedOperationException("toBuilder() is not supported in mutable messages.");
	}

	public byte[] toByteArray() {
		try {
			byte[] result = new byte[getSerializedSize()];
			CodedOutputStream output = CodedOutputStream.newInstance(result);
			writeTo(output);
			output.checkNoSpaceLeft();
			return result;
		} catch (IOException e) {
			throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
		}
	}

	public ByteString toByteString() {
		try {
			CodedBuilder out = ByteString.newCodedBuilder(getSerializedSize());
			writeTo(out.getCodedOutput());
			return out.build();
		} catch (IOException e) {
			throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
		}
	}

	public void writeDelimitedTo(OutputStream output) throws IOException {
		int serialized = getSerializedSize();
		CodedOutputStream codedOutput = CodedOutputStream.newInstance(output, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(serialized) + serialized));
		codedOutput.writeRawVarint32(serialized);
		writeTo(codedOutput);
		codedOutput.flush();
	}

	public void writeTo(CodedOutputStream output) throws IOException {
		getSerializedSize();
		writeToWithCachedSizes(output);
	}

	public void writeTo(OutputStream output) throws IOException {
		CodedOutputStream codedOutput = CodedOutputStream.newInstance(output, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
		writeTo(codedOutput);
		codedOutput.flush();
	}
}
