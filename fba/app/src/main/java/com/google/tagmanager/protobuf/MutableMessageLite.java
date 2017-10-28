package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface MutableMessageLite extends MessageLite, Cloneable {
	public MutableMessageLite clear();

	public MutableMessageLite clone();

	public int getCachedSize();

	public MessageLite getDefaultInstanceForType();

	public MessageLite immutableCopy();

	public boolean mergeDelimitedFrom(InputStream r1_InputStream);

	public boolean mergeDelimitedFrom(InputStream r1_InputStream, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public boolean mergeFrom(ByteString r1_ByteString);

	public boolean mergeFrom(ByteString r1_ByteString, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public boolean mergeFrom(CodedInputStream r1_CodedInputStream);

	public boolean mergeFrom(CodedInputStream r1_CodedInputStream, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public boolean mergeFrom(InputStream r1_InputStream);

	public boolean mergeFrom(InputStream r1_InputStream, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public boolean mergeFrom(ByteBuffer r1_ByteBuffer);

	public boolean mergeFrom(ByteBuffer r1_ByteBuffer, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public boolean mergeFrom(byte[] r1_byte_A);

	public boolean mergeFrom(byte[] r1_byte_A, int r2i, int r3i);

	public boolean mergeFrom(byte[] r1_byte_A, int r2i, int r3i, ExtensionRegistryLite r4_ExtensionRegistryLite);

	public boolean mergeFrom(byte[] r1_byte_A, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public boolean mergePartialFrom(CodedInputStream r1_CodedInputStream, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public MutableMessageLite newMessageForType();

	public boolean parseDelimitedFrom(InputStream r1_InputStream);

	public boolean parseDelimitedFrom(InputStream r1_InputStream, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public boolean parseFrom(ByteString r1_ByteString);

	public boolean parseFrom(ByteString r1_ByteString, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public boolean parseFrom(InputStream r1_InputStream);

	public boolean parseFrom(InputStream r1_InputStream, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public boolean parseFrom(ByteBuffer r1_ByteBuffer);

	public boolean parseFrom(ByteBuffer r1_ByteBuffer, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public boolean parseFrom(byte[] r1_byte_A);

	public boolean parseFrom(byte[] r1_byte_A, int r2i, int r3i);

	public boolean parseFrom(byte[] r1_byte_A, int r2i, int r3i, ExtensionRegistryLite r4_ExtensionRegistryLite);

	public boolean parseFrom(byte[] r1_byte_A, ExtensionRegistryLite r2_ExtensionRegistryLite);

	public void writeToWithCachedSizes(CodedOutputStream r1_CodedOutputStream) throws IOException;
}
