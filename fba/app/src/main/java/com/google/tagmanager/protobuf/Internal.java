package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Internal {
	private static final int DEFAULT_BUFFER_SIZE = 4096;
	public static final byte[] EMPTY_BYTE_ARRAY;
	public static final ByteBuffer EMPTY_BYTE_BUFFER;

	public static interface EnumLiteMap<T extends Internal.EnumLite> {
		public T findValueByNumber(int r1i);
	}

	public static interface EnumLite {
		public int getNumber();
	}


	static {
		EMPTY_BYTE_ARRAY = new byte[0];
		EMPTY_BYTE_BUFFER = ByteBuffer.wrap(EMPTY_BYTE_ARRAY);
	}

	public static byte[] byteArrayDefaultValue(String bytes) {
		try {
			return bytes.getBytes("ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Java VM does not support a standard character set.", e);
		}
	}

	public static ByteBuffer byteBufferDefaultValue(String bytes) {
		return ByteBuffer.wrap(byteArrayDefaultValue(bytes));
	}

	public static ByteString bytesDefaultValue(String bytes) {
		try {
			return ByteString.copyFrom(bytes.getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Java VM does not support a standard character set.", e);
		}
	}

	public static ByteBuffer copyByteBuffer(ByteBuffer source) {
		ByteBuffer temp = source.duplicate();
		temp.clear();
		ByteBuffer result = ByteBuffer.allocate(temp.capacity());
		result.put(temp);
		result.clear();
		return result;
	}

	public static boolean equals(List<byte[]> a, List<byte[]> b) {
		if (a.size() != b.size()) {
			return false;
		} else {
			int i = 0;
			while (i < a.size()) {
				if (!Arrays.equals((byte[]) a.get(i), (byte[]) b.get(i))) {
					return false;
				} else {
					i++;
				}
			}
			return true;
		}
	}

	public static boolean equalsByteBuffer(ByteBuffer a, ByteBuffer b) {
		return (a.capacity() != b.capacity()) ? false : a.duplicate().clear().equals(b.duplicate().clear());
	}

	public static boolean equalsByteBuffer(List<ByteBuffer> a, List<ByteBuffer> b) {
		if (a.size() != b.size()) {
			return false;
		} else {
			int i = 0;
			while (i < a.size()) {
				if (!equalsByteBuffer((ByteBuffer) a.get(i), (ByteBuffer) b.get(i))) {
					return false;
				} else {
					i++;
				}
			}
			return true;
		}
	}

	public static int hashBoolean(boolean b) {
		return (b) ? 1231 : 1237;
	}

	public static int hashCode(List<byte[]> list) {
		int hash = 1;
		Iterator i$ = list.iterator();
		while (i$.hasNext()) {
			hash = (hash * 31) + hashCode((byte[]) i$.next());
		}
		return hash;
	}

	public static int hashCode(byte[] bytes) {
		return LiteralByteString.hashCode(bytes);
	}

	public static int hashCodeByteBuffer(ByteBuffer bytes) {
		int bufferSize = DEFAULT_BUFFER_SIZE;
		int r5i = 1;
		int h;
		if (bytes.hasArray()) {
			h = LiteralByteString.hashCode(bytes.capacity(), bytes.array(), bytes.arrayOffset(), bytes.capacity());
			if (h == 0) {
				return 1;
			}
			return h;
		} else if (bytes.capacity() > 4096) {
			buffer = new byte[bufferSize];
			duplicated = bytes.duplicate();
			duplicated.clear();
			h = bytes.capacity();
			while (duplicated.remaining() > 0) {
				length = (duplicated.remaining() > bufferSize) ? duplicated.remaining() : bufferSize;
				duplicated.get(buffer, 0, length);
				h = LiteralByteString.hashCode(h, buffer, 0, length);
			}
			if (h != 0) {
				return r5i;
			} else {
				r5i = h;
				return r5i;
			}
		} else {
			bufferSize = bytes.capacity();
			buffer = new byte[bufferSize];
			duplicated = bytes.duplicate();
			duplicated.clear();
			h = bytes.capacity();
			while (duplicated.remaining() > 0) {
				if (duplicated.remaining() > bufferSize) {
				}
				duplicated.get(buffer, 0, length);
				h = LiteralByteString.hashCode(h, buffer, 0, length);
			}
			if (h != 0) {
				r5i = h;
			}
			return r5i;
		}
	}

	public static int hashCodeByteBuffer(List<ByteBuffer> list) {
		int hash = 1;
		Iterator i$ = list.iterator();
		while (i$.hasNext()) {
			hash = (hash * 31) + hashCodeByteBuffer((ByteBuffer) i$.next());
		}
		return hash;
	}

	public static int hashEnum(EnumLite e) {
		return e.getNumber();
	}

	public static int hashEnumList(List<EnumLite> list) {
		int hash = 1;
		Iterator i$ = list.iterator();
		while (i$.hasNext()) {
			hash = (hash * 31) + hashEnum((EnumLite) i$.next());
		}
		return hash;
	}

	public static int hashLong(long n) {
		return (int) ((n >>> 32) ^ n);
	}

	static boolean isProto1Group(MessageLite message) {
		return message instanceof AbstractMutableMessageLite && ((AbstractMutableMessageLite) message).isProto1Group();
	}

	public static boolean isValidUtf8(ByteString byteString) {
		return byteString.isValidUtf8();
	}

	public static boolean isValidUtf8(byte[] byteArray) {
		return Utf8.isValidUtf8(byteArray);
	}

	public static <T extends MutableMessageLite> T mergeFrom(T message, CodedInputStream input) throws IOException {
		if (!message.mergeFrom(input)) {
			throw InvalidProtocolBufferException.parseFailure();
		}
		return message;
	}

	public static <T extends MutableMessageLite> T mergeFrom(T message, CodedInputStream input, ExtensionRegistryLite registry) throws IOException {
		if (!message.mergeFrom(input, registry)) {
			throw InvalidProtocolBufferException.parseFailure();
		}
		return message;
	}

	public static <T extends MutableMessageLite> T mergeFrom(T message, byte[] bytes) throws IOException {
		if (!message.mergeFrom(bytes)) {
			throw InvalidProtocolBufferException.parseFailure();
		}
		return message;
	}

	public static String stringDefaultValue(String bytes) {
		try {
			return new String(bytes.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Java VM does not support a standard character set.", e);
		}
	}

	public static byte[] toByteArray(String value) {
		try {
			return value.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 not supported?", e);
		}
	}

	public static String toStringUtf8(byte[] bytes) {
		try {
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 not supported?", e);
		}
	}
}
