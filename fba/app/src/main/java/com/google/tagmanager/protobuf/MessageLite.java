package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface MessageLite extends MessageLiteOrBuilder {
	public static interface Builder extends MessageLiteOrBuilder, Cloneable {
		public MessageLite build();

		public MessageLite buildPartial();

		public MessageLite.Builder clear();

		public MessageLite.Builder clone();

		public boolean mergeDelimitedFrom(InputStream r1_InputStream) throws IOException;

		public boolean mergeDelimitedFrom(InputStream r1_InputStream, ExtensionRegistryLite r2_ExtensionRegistryLite) throws IOException;

		public MessageLite.Builder mergeFrom(ByteString r1_ByteString) throws InvalidProtocolBufferException;

		public MessageLite.Builder mergeFrom(ByteString r1_ByteString, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;

		public MessageLite.Builder mergeFrom(CodedInputStream r1_CodedInputStream) throws IOException;

		public MessageLite.Builder mergeFrom(CodedInputStream r1_CodedInputStream, ExtensionRegistryLite r2_ExtensionRegistryLite) throws IOException;

		public MessageLite.Builder mergeFrom(InputStream r1_InputStream) throws IOException;

		public MessageLite.Builder mergeFrom(InputStream r1_InputStream, ExtensionRegistryLite r2_ExtensionRegistryLite) throws IOException;

		public MessageLite.Builder mergeFrom(byte[] r1_byte_A) throws InvalidProtocolBufferException;

		public MessageLite.Builder mergeFrom(byte[] r1_byte_A, int r2i, int r3i) throws InvalidProtocolBufferException;

		public MessageLite.Builder mergeFrom(byte[] r1_byte_A, int r2i, int r3i, ExtensionRegistryLite r4_ExtensionRegistryLite) throws InvalidProtocolBufferException;

		public MessageLite.Builder mergeFrom(byte[] r1_byte_A, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;
	}


	public Parser<MessageLite> getParserForType();

	public int getSerializedSize();

	public MutableMessageLite mutableCopy();

	public Builder newBuilderForType();

	public Builder toBuilder();

	public byte[] toByteArray();

	public ByteString toByteString();

	public void writeDelimitedTo(OutputStream r1_OutputStream) throws IOException;

	public void writeTo(CodedOutputStream r1_CodedOutputStream) throws IOException;

	public void writeTo(OutputStream r1_OutputStream) throws IOException;
}
