package com.google.tagmanager.protobuf;

import java.io.InputStream;

public interface Parser<Type> {
	public MessageType parseDelimitedFrom(InputStream r1_InputStream) throws InvalidProtocolBufferException;

	public MessageType parseDelimitedFrom(InputStream r1_InputStream, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parseFrom(ByteString r1_ByteString) throws InvalidProtocolBufferException;

	public MessageType parseFrom(ByteString r1_ByteString, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parseFrom(CodedInputStream r1_CodedInputStream) throws InvalidProtocolBufferException;

	public MessageType parseFrom(CodedInputStream r1_CodedInputStream, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parseFrom(InputStream r1_InputStream) throws InvalidProtocolBufferException;

	public MessageType parseFrom(InputStream r1_InputStream, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parseFrom(byte[] r1_byte_A) throws InvalidProtocolBufferException;

	public MessageType parseFrom(byte[] r1_byte_A, int r2i, int r3i) throws InvalidProtocolBufferException;

	public MessageType parseFrom(byte[] r1_byte_A, int r2i, int r3i, ExtensionRegistryLite r4_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parseFrom(byte[] r1_byte_A, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parsePartialDelimitedFrom(InputStream r1_InputStream) throws InvalidProtocolBufferException;

	public MessageType parsePartialDelimitedFrom(InputStream r1_InputStream, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parsePartialFrom(ByteString r1_ByteString) throws InvalidProtocolBufferException;

	public MessageType parsePartialFrom(ByteString r1_ByteString, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parsePartialFrom(CodedInputStream r1_CodedInputStream) throws InvalidProtocolBufferException;

	public MessageType parsePartialFrom(CodedInputStream r1_CodedInputStream, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parsePartialFrom(InputStream r1_InputStream) throws InvalidProtocolBufferException;

	public MessageType parsePartialFrom(InputStream r1_InputStream, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parsePartialFrom(byte[] r1_byte_A) throws InvalidProtocolBufferException;

	public MessageType parsePartialFrom(byte[] r1_byte_A, int r2i, int r3i) throws InvalidProtocolBufferException;

	public MessageType parsePartialFrom(byte[] r1_byte_A, int r2i, int r3i, ExtensionRegistryLite r4_ExtensionRegistryLite) throws InvalidProtocolBufferException;

	public MessageType parsePartialFrom(byte[] r1_byte_A, ExtensionRegistryLite r2_ExtensionRegistryLite) throws InvalidProtocolBufferException;
}
