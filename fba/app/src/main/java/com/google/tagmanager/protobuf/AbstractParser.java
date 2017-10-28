package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.AbstractMessageLite.Builder.LimitedInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractParser<Type extends MessageLite> implements Parser<MessageType> {
	private static final ExtensionRegistryLite EMPTY_REGISTRY;

	static {
		EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
	}

	private MessageType checkMessageInitialized(MessageType message) throws InvalidProtocolBufferException {
		if (message == null || message.isInitialized()) {
			return message;
		} else {
			throw newUninitializedMessageException(message).asInvalidProtocolBufferException().setUnfinishedMessage(message);
		}
	}

	private UninitializedMessageException newUninitializedMessageException(MessageType message) {
		if (message instanceof AbstractMessageLite) {
			return ((AbstractMessageLite) message).newUninitializedMessageException();
		} else if (message instanceof AbstractMutableMessageLite) {
			return ((AbstractMutableMessageLite) message).newUninitializedMessageException();
		} else {
			return new UninitializedMessageException((MessageLite)message);
		}
	}

	public MessageType parseDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
		return parseDelimitedFrom(input, EMPTY_REGISTRY);
	}

	public MessageType parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		return checkMessageInitialized(parsePartialDelimitedFrom(input, extensionRegistry));
	}

	public MessageType parseFrom(ByteString data) throws InvalidProtocolBufferException {
		return parseFrom(data, EMPTY_REGISTRY);
	}

	public MessageType parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		return checkMessageInitialized(parsePartialFrom(data, extensionRegistry));
	}

	public MessageType parseFrom(CodedInputStream input) throws InvalidProtocolBufferException {
		return parseFrom(input, EMPTY_REGISTRY);
	}

	public MessageType parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		return checkMessageInitialized((MessageLite) parsePartialFrom(input, extensionRegistry));
	}

	public MessageType parseFrom(InputStream input) throws InvalidProtocolBufferException {
		return parseFrom(input, EMPTY_REGISTRY);
	}

	public MessageType parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		return checkMessageInitialized(parsePartialFrom(input, extensionRegistry));
	}

	public MessageType parseFrom(byte[] data) throws InvalidProtocolBufferException {
		return parseFrom(data, EMPTY_REGISTRY);
	}

	public MessageType parseFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
		return parseFrom(data, off, len, EMPTY_REGISTRY);
	}

	public MessageType parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		return checkMessageInitialized(parsePartialFrom(data, off, len, extensionRegistry));
	}

	public MessageType parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		return parseFrom(data, 0, data.length, extensionRegistry);
	}

	public MessageType parsePartialDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
		return parsePartialDelimitedFrom(input, EMPTY_REGISTRY);
	}

	public MessageType parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		try {
			int firstByte = input.read();
			return (firstByte == -1) ? null : parsePartialFrom(new LimitedInputStream(input, CodedInputStream.readRawVarint32(firstByte, input)), extensionRegistry);
		} catch (IOException e) {
			throw new InvalidProtocolBufferException(e.getMessage());
		}
	}

	public MessageType parsePartialFrom(ByteString data) throws InvalidProtocolBufferException {
		return parsePartialFrom(data, EMPTY_REGISTRY);
	}

	public MessageType parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		MessageType message;
		try {
			CodedInputStream input = data.newCodedInput();
			message = (MessageLite) parsePartialFrom(input, extensionRegistry);
			input.checkLastTagWas(0);
			return message;
		} catch (InvalidProtocolBufferException e) {
			throw e.setUnfinishedMessage(message);
		} catch (IOException e_2) {
			throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e_2);
		} catch (InvalidProtocolBufferException e_3) {
			throw e_3;
		} catch (IOException e_2_2) {
			throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e_2_2);
		}
	}

	public MessageType parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
		return (MessageLite) parsePartialFrom(input, EMPTY_REGISTRY);
	}

	public MessageType parsePartialFrom(InputStream input) throws InvalidProtocolBufferException {
		return parsePartialFrom(input, EMPTY_REGISTRY);
	}

	public MessageType parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		CodedInputStream codedInput = CodedInputStream.newInstance(input);
		MessageType message = (MessageLite) parsePartialFrom(codedInput, extensionRegistry);
		try {
			codedInput.checkLastTagWas(0);
			return message;
		} catch (InvalidProtocolBufferException e) {
			throw e.setUnfinishedMessage(message);
		}
	}

	public MessageType parsePartialFrom(byte[] data) throws InvalidProtocolBufferException {
		return parsePartialFrom(data, 0, data.length, EMPTY_REGISTRY);
	}

	public MessageType parsePartialFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
		return parsePartialFrom(data, off, len, EMPTY_REGISTRY);
	}

	public MessageType parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		MessageType message;
		try {
			CodedInputStream input = CodedInputStream.newInstance(data, off, len);
			message = (MessageLite) parsePartialFrom(input, extensionRegistry);
			input.checkLastTagWas(0);
			return message;
		} catch (InvalidProtocolBufferException e) {
			throw e.setUnfinishedMessage(message);
		} catch (IOException e_2) {
			throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e_2);
		} catch (InvalidProtocolBufferException e_3) {
			throw e_3;
		} catch (IOException e_2_2) {
			throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e_2_2);
		}
	}

	public MessageType parsePartialFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
		return parsePartialFrom(data, 0, data.length, extensionRegistry);
	}
}
