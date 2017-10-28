package com.google.tagmanager.protobuf;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.tagmanager.protobuf.MessageLite.Builder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class CodedInputStream {
	private static final int BUFFER_SIZE = 4096;
	private static final int DEFAULT_RECURSION_LIMIT = 64;
	private static final int DEFAULT_SIZE_LIMIT = 67108864;
	private final byte[] buffer;
	private final boolean bufferIsImmutable;
	private int bufferPos;
	private int bufferSize;
	private int bufferSizeAfterLimit;
	private int currentLimit;
	private boolean enableAliasing;
	private final InputStream input;
	private int lastTag;
	private int recursionDepth;
	private int recursionLimit;
	private RefillCallback refillCallback;
	private int sizeLimit;
	private int totalBytesRetired;

	private static interface RefillCallback {
		public void onRefill();
	}

	private class SkippedDataSink implements CodedInputStream.RefillCallback {
		private ByteArrayOutputStream byteArrayStream;
		private int lastPos;

		private SkippedDataSink() {
			this.lastPos = bufferPos;
		}

		ByteBuffer getSkippedData() {
			if (this.byteArrayStream == null) {
				return ByteBuffer.wrap(buffer, this.lastPos, bufferPos - this.lastPos);
			} else {
				this.byteArrayStream.write(buffer, this.lastPos, bufferPos);
				return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
			}
		}

		public void onRefill() {
			if (this.byteArrayStream == null) {
				this.byteArrayStream = new ByteArrayOutputStream();
			}
			this.byteArrayStream.write(buffer, this.lastPos, bufferPos - this.lastPos);
			this.lastPos = 0;
		}
	}


	private CodedInputStream(LiteralByteString byteString) {
		this.enableAliasing = false;
		this.currentLimit = 2147483647;
		this.recursionLimit = 64;
		this.sizeLimit = 67108864;
		this.refillCallback = null;
		this.buffer = byteString.bytes;
		this.bufferPos = byteString.getOffsetIntoBytes();
		this.bufferSize = byteString.getOffsetIntoBytes() + byteString.size();
		this.totalBytesRetired = -this.bufferPos;
		this.input = null;
		this.bufferIsImmutable = true;
	}

	private CodedInputStream(InputStream input) {
		this.enableAliasing = false;
		this.currentLimit = 2147483647;
		this.recursionLimit = 64;
		this.sizeLimit = 67108864;
		this.refillCallback = null;
		this.buffer = new byte[4096];
		this.bufferSize = 0;
		this.bufferPos = 0;
		this.totalBytesRetired = 0;
		this.input = input;
		this.bufferIsImmutable = false;
	}

	private CodedInputStream(byte[] buffer, int off, int len) {
		this.enableAliasing = false;
		this.currentLimit = 2147483647;
		this.recursionLimit = 64;
		this.sizeLimit = 67108864;
		this.refillCallback = null;
		this.buffer = buffer;
		this.bufferSize = off + len;
		this.bufferPos = off;
		this.totalBytesRetired = -off;
		this.input = null;
		this.bufferIsImmutable = false;
	}

	public static int decodeZigZag32(int n) {
		return (n >>> 1) ^ (-(n & 1));
	}

	public static long decodeZigZag64(long n) {
		return (n >>> 1) ^ (-(1 & n));
	}

	static CodedInputStream newInstance(LiteralByteString byteString) {
		CodedInputStream result = new CodedInputStream(byteString);
		try {
			result.pushLimit(byteString.size());
			return result;
		} catch (InvalidProtocolBufferException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static CodedInputStream newInstance(InputStream input) {
		return new CodedInputStream(input);
	}

	public static CodedInputStream newInstance(ByteBuffer buf) {
		if (buf.hasArray()) {
			return newInstance(buf.array(), buf.arrayOffset() + buf.position(), buf.remaining());
		} else {
			ByteBuffer temp = buf.duplicate();
			byte[] buffer = new byte[temp.remaining()];
			temp.get(buffer);
			return newInstance(buffer);
		}
	}

	public static CodedInputStream newInstance(byte[] buf) {
		return newInstance(buf, 0, buf.length);
	}

	public static CodedInputStream newInstance(byte[] buf, int off, int len) {
		CodedInputStream result = new CodedInputStream(buf, off, len);
		try {
			result.pushLimit(len);
			return result;
		} catch (InvalidProtocolBufferException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/* JADX WARNING: inconsistent code */
	/*
	public static int readRawVarint32(int r5_firstByte, java.io.InputStream r6_input) throws java.io.IOException {
		r4 = -1;
		r3 = r5_firstByte & 128;
		if (r3 != 0) goto L_0x0007;
	L_0x0005:
		r2 = r5_firstByte;
	L_0x0006:
		return r2;
	L_0x0007:
		r2 = r5_firstByte & 127;
		r1 = 7;
	L_0x000a:
		r3 = 32;
		if (r1_offset >= r3) goto L_0x0026;
	L_0x000e:
		r0 = r6_input.read();
		if (r0_b != r4) goto L_0x0019;
	L_0x0014:
		r3 = com.google.tagmanager.protobuf.InvalidProtocolBufferException.truncatedMessage();
		throw r3;
	L_0x0019:
		r3 = r0_b & 127;
		r3 <<= r1_offset;
		r2_result |= r3;
		r3 = r0_b & 128;
		if (r3 == 0) goto L_0x0006;
	L_0x0021:
		r1_offset += 7;
		goto L_0x000a;
	L_0x0024:
		r1_offset += 7;
	L_0x0026:
		r3 = 64;
		if (r1_offset >= r3) goto L_0x003a;
	L_0x002a:
		r0_b = r6_input.read();
		if (r0_b != r4) goto L_0x0035;
	L_0x0030:
		r3 = com.google.tagmanager.protobuf.InvalidProtocolBufferException.truncatedMessage();
		throw r3;
	L_0x0035:
		r3 = r0_b & 128;
		if (r3 != 0) goto L_0x0024;
	L_0x0039:
		goto L_0x0006;
	L_0x003a:
		r3 = com.google.tagmanager.protobuf.InvalidProtocolBufferException.malformedVarint();
		throw r3;
	}
	*/
	public static int readRawVarint32(int firstByte, InputStream input) throws IOException {
		if ((firstByte & 128) == 0) {
			return firstByte;
		} else {
			int result = firstByte & 127;
			int offset = Value.FUNCTION_ID_FIELD_NUMBER;
			while (offset < 32) {
				int b = input.read();
				if (b == -1) {
					throw InvalidProtocolBufferException.truncatedMessage();
				} else {
					result |= (b & 127) << offset;
					if ((b & 128) != 0) {
						offset += 7;
					}
					return result;
				}
			}
		}
	}

	static int readRawVarint32(InputStream input) throws IOException {
		int firstByte = input.read();
		if (firstByte == -1) {
			throw InvalidProtocolBufferException.truncatedMessage();
		} else {
			return readRawVarint32(firstByte, input);
		}
	}

	private void recomputeBufferSizeAfterLimit() {
		this.bufferSize += this.bufferSizeAfterLimit;
		int bufferEnd = this.totalBytesRetired + this.bufferSize;
		if (bufferEnd > this.currentLimit) {
			this.bufferSizeAfterLimit = bufferEnd - this.currentLimit;
			this.bufferSize -= this.bufferSizeAfterLimit;
			return;
		} else {
			this.bufferSizeAfterLimit = 0;
		}
	}

	private boolean refillBuffer(boolean mustSucceed) throws IOException {
		if (this.bufferPos < this.bufferSize) {
			throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
		} else if (this.totalBytesRetired + this.bufferSize == this.currentLimit) {
			if (mustSucceed) {
				throw InvalidProtocolBufferException.truncatedMessage();
			} else {
				return false;
			}
		} else {
			if (this.refillCallback != null) {
				this.refillCallback.onRefill();
			}
			this.totalBytesRetired += this.bufferSize;
			this.bufferPos = 0;
			this.bufferSize = (this.input == null) ? -1 : this.input.read(this.buffer);
			if (this.bufferSize == 0 || this.bufferSize < -1) {
				throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.bufferSize + "\nThe InputStream implementation is buggy.");
			} else if (this.bufferSize == -1) {
				this.bufferSize = 0;
				if (mustSucceed) {
					throw InvalidProtocolBufferException.truncatedMessage();
				} else {
					return false;
				}
			} else {
				recomputeBufferSizeAfterLimit();
				int totalBytesRead = (this.totalBytesRetired + this.bufferSize) + this.bufferSizeAfterLimit;
				if (totalBytesRead > this.sizeLimit || totalBytesRead < 0) {
					throw InvalidProtocolBufferException.sizeLimitExceeded();
				} else {
					return true;
				}
			}
		}
	}

	private void skipRawVarint() throws IOException {
		int i = 0;
		while (i < 10) {
			if (readRawByte() >= (byte) 0) {
				return;
			} else {
				i++;
			}
		}
		throw InvalidProtocolBufferException.malformedVarint();
	}

	public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
		if (this.lastTag != value) {
			throw InvalidProtocolBufferException.invalidEndTag();
		}
	}

	public void enableAliasing(boolean enabled) {
		this.enableAliasing = enabled;
	}

	public int getBytesUntilLimit() {
		return (this.currentLimit == 2147483647) ? -1 : this.currentLimit - (this.totalBytesRetired + this.bufferPos);
	}

	public int getLastTag() {
		return this.lastTag;
	}

	public int getTotalBytesRead() {
		return this.totalBytesRetired + this.bufferPos;
	}

	public boolean isAtEnd() throws IOException {
		if (this.bufferPos == this.bufferSize) {
			if (!refillBuffer(false)) {
				return true;
			}
			return false;
		}
		return false;
	}

	public void mergeToMessage(MutableMessageLite message) throws IOException {
		SkippedDataSink dataSink = new SkippedDataSink(null);
		this.refillCallback = dataSink;
		skipMessage();
		this.refillCallback = null;
		ByteBuffer data = dataSink.getSkippedData();
		if (!message.mergeFrom(data.array(), data.position(), data.remaining())) {
			throw InvalidProtocolBufferException.parseFailure();
		}
	}

	public void popLimit(int oldLimit) {
		this.currentLimit = oldLimit;
		recomputeBufferSizeAfterLimit();
	}

	public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
		if (byteLimit < 0) {
			throw InvalidProtocolBufferException.negativeSize();
		} else {
			byteLimit += this.totalBytesRetired + this.bufferPos;
			int oldLimit = this.currentLimit;
			if (byteLimit > oldLimit) {
				throw InvalidProtocolBufferException.truncatedMessage();
			} else {
				this.currentLimit = byteLimit;
				recomputeBufferSizeAfterLimit();
				return oldLimit;
			}
		}
	}

	public boolean readBool() throws IOException {
		return readRawVarint32() != 0;
	}

	public byte[] readByteArray() throws IOException {
		int size = readRawVarint32();
		if (size == 0) {
			return Internal.EMPTY_BYTE_ARRAY;
		} else if (size > this.bufferSize - this.bufferPos || size <= 0) {
			return readRawBytes(size);
		} else {
			byte[] r0_byte_A = Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + size);
			this.bufferPos += size;
			return r0_byte_A;
		}
	}

	public ByteBuffer readByteBuffer() throws IOException {
		int size = readRawVarint32();
		if (size == 0) {
			return Internal.EMPTY_BYTE_BUFFER;
		} else if (size > this.bufferSize - this.bufferPos || size <= 0) {
			return ByteBuffer.wrap(readRawBytes(size));
		} else {
			ByteBuffer result;
			result = (this.input != null || this.bufferIsImmutable || !(this.enableAliasing)) ? ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + size)) : ByteBuffer.wrap(this.buffer, this.bufferPos, size).slice();
			this.bufferPos += size;
			return result;
		}
	}

	public ByteString readBytes() throws IOException {
		int size = readRawVarint32();
		if (size == 0) {
			return ByteString.EMPTY;
		} else if (size > this.bufferSize - this.bufferPos || size <= 0) {
			return new LiteralByteString(readRawBytes(size));
		} else {
			ByteString result;
			result = (!(this.bufferIsImmutable) || !(this.enableAliasing)) ? ByteString.copyFrom(this.buffer, this.bufferPos, size) : new BoundedByteString(this.buffer, this.bufferPos, size);
			this.bufferPos += size;
			return result;
		}
	}

	public double readDouble() throws IOException {
		return Double.longBitsToDouble(readRawLittleEndian64());
	}

	public int readEnum() throws IOException {
		return readRawVarint32();
	}

	public int readFixed32() throws IOException {
		return readRawLittleEndian32();
	}

	public long readFixed64() throws IOException {
		return readRawLittleEndian64();
	}

	public float readFloat() throws IOException {
		return Float.intBitsToFloat(readRawLittleEndian32());
	}

	public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
		if (this.recursionDepth >= this.recursionLimit) {
			throw InvalidProtocolBufferException.recursionLimitExceeded();
		} else {
			this.recursionDepth++;
			T result = (MessageLite) parser.parsePartialFrom(this, extensionRegistry);
			checkLastTagWas(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_END_GROUP));
			this.recursionDepth--;
			return result;
		}
	}

	public void readGroup(int fieldNumber, Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
		if (this.recursionDepth >= this.recursionLimit) {
			throw InvalidProtocolBufferException.recursionLimitExceeded();
		} else {
			this.recursionDepth++;
			builder.mergeFrom(this, extensionRegistry);
			checkLastTagWas(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_END_GROUP));
			this.recursionDepth--;
		}
	}

	public void readGroup(int fieldNumber, MutableMessageLite message, ExtensionRegistryLite extensionRegistry) throws IOException {
		if (this.recursionDepth >= this.recursionLimit) {
			throw InvalidProtocolBufferException.recursionLimitExceeded();
		} else {
			this.recursionDepth++;
			message.mergeFrom(this, extensionRegistry);
			checkLastTagWas(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_END_GROUP));
			this.recursionDepth--;
		}
	}

	public int readInt32() throws IOException {
		return readRawVarint32();
	}

	public long readInt64() throws IOException {
		return readRawVarint64();
	}

	public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
		int length = readRawVarint32();
		if (this.recursionDepth >= this.recursionLimit) {
			throw InvalidProtocolBufferException.recursionLimitExceeded();
		} else {
			int oldLimit = pushLimit(length);
			this.recursionDepth++;
			T result = (MessageLite) parser.parsePartialFrom(this, extensionRegistry);
			checkLastTagWas(0);
			this.recursionDepth--;
			popLimit(oldLimit);
			return result;
		}
	}

	public void readMessage(Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
		int length = readRawVarint32();
		if (this.recursionDepth >= this.recursionLimit) {
			throw InvalidProtocolBufferException.recursionLimitExceeded();
		} else {
			int oldLimit = pushLimit(length);
			this.recursionDepth++;
			builder.mergeFrom(this, extensionRegistry);
			checkLastTagWas(0);
			this.recursionDepth--;
			popLimit(oldLimit);
		}
	}

	public void readMessage(MutableMessageLite message, ExtensionRegistryLite extensionRegistry) throws IOException {
		int length = readRawVarint32();
		if (this.recursionDepth >= this.recursionLimit) {
			throw InvalidProtocolBufferException.recursionLimitExceeded();
		} else {
			int oldLimit = pushLimit(length);
			this.recursionDepth++;
			message.mergeFrom(this, extensionRegistry);
			checkLastTagWas(0);
			this.recursionDepth--;
			popLimit(oldLimit);
		}
	}

	public byte readRawByte() throws IOException {
		if (this.bufferPos == this.bufferSize) {
			refillBuffer(true);
		}
		byte[] r0_byte_A = this.buffer;
		int r1i = this.bufferPos;
		this.bufferPos = r1i + 1;
		return r0_byte_A[r1i];
	}

	public byte[] readRawBytes(int size) throws IOException {
		if (size < 0) {
			throw InvalidProtocolBufferException.negativeSize();
		} else if ((this.totalBytesRetired + this.bufferPos) + size > this.currentLimit) {
			skipRawBytes((this.currentLimit - this.totalBytesRetired) - this.bufferPos);
			throw InvalidProtocolBufferException.truncatedMessage();
		} else if (size <= this.bufferSize - this.bufferPos) {
			bytes = new Object[size];
			System.arraycopy(this.buffer, this.bufferPos, bytes, 0, size);
			this.bufferPos += size;
			return bytes;
		} else if (size < 4096) {
			bytes = new Object[size];
			pos = this.bufferSize - this.bufferPos;
			System.arraycopy(this.buffer, this.bufferPos, bytes, 0, pos);
			this.bufferPos = this.bufferSize;
			refillBuffer(true);
			while (size - pos > this.bufferSize) {
				System.arraycopy(this.buffer, 0, bytes, pos, this.bufferSize);
				pos += this.bufferSize;
				this.bufferPos = this.bufferSize;
				refillBuffer(true);
			}
			System.arraycopy(this.buffer, 0, bytes, pos, size - pos);
			this.bufferPos = size - pos;
			return bytes;
		} else {
			Object chunk;
			int originalBufferPos = this.bufferPos;
			int originalBufferSize = this.bufferSize;
			this.totalBytesRetired += this.bufferSize;
			this.bufferPos = 0;
			this.bufferSize = 0;
			int sizeLeft = size - (originalBufferSize - originalBufferPos);
			List<byte[]> chunks = new ArrayList();
			while (sizeLeft > 0) {
				chunk = new Object[Math.min(sizeLeft, BUFFER_SIZE)];
				pos = 0;
				while (pos < chunk.length) {
					int n;
					n = (this.input == null) ? -1 : this.input.read(chunk, pos, chunk.length - pos);
					if (n == -1) {
						throw InvalidProtocolBufferException.truncatedMessage();
					} else {
						this.totalBytesRetired += n;
						pos += n;
					}
				}
				sizeLeft -= chunk.length;
				chunks.add(chunk);
			}
			bytes = new Object[size];
			pos = originalBufferSize - originalBufferPos;
			System.arraycopy(this.buffer, originalBufferPos, bytes, 0, pos);
			Iterator i$ = chunks.iterator();
			while (i$.hasNext()) {
				chunk = (byte[]) i$.next();
				System.arraycopy(chunk, 0, bytes, pos, chunk.length);
				pos += chunk.length;
			}
			return bytes;
		}
	}

	public int readRawLittleEndian32() throws IOException {
		byte b1 = readRawByte();
		byte b2 = readRawByte();
		byte b3 = readRawByte();
		return (((b1 & 255) | ((b2 & 255) << 8)) | ((b3 & 255) << 16)) | ((readRawByte() & 255) << 24);
	}

	public long readRawLittleEndian64() throws IOException {
		byte b1 = readRawByte();
		byte b2 = readRawByte();
		byte b3 = readRawByte();
		byte b4 = readRawByte();
		byte b5 = readRawByte();
		byte b6 = readRawByte();
		byte b7 = readRawByte();
		return (((((((((long) b1) & 255) | ((((long) b2) & 255) << 8)) | ((((long) b3) & 255) << 16)) | ((((long) b4) & 255) << 24)) | ((((long) b5) & 255) << 32)) | ((((long) b6) & 255) << 40)) | ((((long) b7) & 255) << 48)) | ((((long) readRawByte()) & 255) << 56);
	}

	public int readRawVarint32() throws IOException {
		byte tmp = readRawByte();
		if (tmp >= (byte) 0) {
			return tmp;
		} else {
			int result = tmp & 127;
			tmp = readRawByte();
			if (tmp >= (byte) 0) {
				return result | (tmp << 7);
			} else {
				result |= (tmp & 127) << 7;
				tmp = readRawByte();
				if (tmp >= (byte) 0) {
					return result | (tmp << 14);
				} else {
					result |= (tmp & 127) << 14;
					tmp = readRawByte();
					if (tmp >= (byte) 0) {
						return result | (tmp << 21);
					} else {
						tmp = readRawByte();
						result = (result | ((tmp & 127) << 21)) | (tmp << 28);
						if (tmp < (byte) 0) {
							int i = 0;
							while (i < 5) {
								if (readRawByte() < (byte) 0) {
									i++;
								}
								return result;
							}
							throw InvalidProtocolBufferException.malformedVarint();
						}
						return result;
					}
				}
			}
		}
	}

	public long readRawVarint64() throws IOException {
		int shift = 0;
		long result = 0;
		while (shift < 64) {
			byte b = readRawByte();
			result |= ((long) (b & 127)) << shift;
			if ((b & 128) == 0) {
				return result;
			} else {
				shift += 7;
			}
		}
		throw InvalidProtocolBufferException.malformedVarint();
	}

	public int readSFixed32() throws IOException {
		return readRawLittleEndian32();
	}

	public long readSFixed64() throws IOException {
		return readRawLittleEndian64();
	}

	public int readSInt32() throws IOException {
		return decodeZigZag32(readRawVarint32());
	}

	public long readSInt64() throws IOException {
		return decodeZigZag64(readRawVarint64());
	}

	public String readString() throws IOException {
		int size = readRawVarint32();
		if (size > this.bufferSize - this.bufferPos || size <= 0) {
			return new String(readRawBytes(size), "UTF-8");
		} else {
			String r0_String = new String(this.buffer, this.bufferPos, size, "UTF-8");
			this.bufferPos += size;
			return r0_String;
		}
	}

	public String readStringRequireUtf8() throws IOException {
		ByteString bs;
		int size = readRawVarint32();
		if (size > this.bufferSize - this.bufferPos || size <= 0) {
			bs = new LiteralByteString(readRawBytes(size));
		} else {
			bs = ByteString.copyFrom(this.buffer, this.bufferPos, size);
			this.bufferPos += size;
		}
		if (!bs.isValidUtf8()) {
			throw InvalidProtocolBufferException.invalidUtf8();
		} else {
			return bs.toStringUtf8();
		}
	}

	public int readTag() throws IOException {
		if (isAtEnd()) {
			this.lastTag = 0;
			return 0;
		} else {
			this.lastTag = readRawVarint32();
			if (WireFormat.getTagFieldNumber(this.lastTag) == 0) {
				throw InvalidProtocolBufferException.invalidTag();
			} else {
				return this.lastTag;
			}
		}
	}

	public int readUInt32() throws IOException {
		return readRawVarint32();
	}

	public long readUInt64() throws IOException {
		return readRawVarint64();
	}

	@Deprecated
	public void readUnknownGroup(int fieldNumber, Builder builder) throws IOException {
		readGroup(fieldNumber, builder, null);
	}

	public void resetSizeCounter() {
		this.totalBytesRetired = -this.bufferPos;
	}

	public int setRecursionLimit(int limit) {
		if (limit < 0) {
			throw new IllegalArgumentException("Recursion limit cannot be negative: " + limit);
		} else {
			int oldLimit = this.recursionLimit;
			this.recursionLimit = limit;
			return oldLimit;
		}
	}

	public int setSizeLimit(int limit) {
		if (limit < 0) {
			throw new IllegalArgumentException("Size limit cannot be negative: " + limit);
		} else {
			int oldLimit = this.sizeLimit;
			this.sizeLimit = limit;
			return oldLimit;
		}
	}

	public boolean skipField(int tag) throws IOException {
		switch(WireFormat.getTagWireType(tag)) {
		case Utf8.COMPLETE:
			skipRawVarint();
			return true;
		case WireFormat.WIRETYPE_FIXED64:
			skipRawBytes(CodedOutputStream.LITTLE_ENDIAN_64_SIZE);
			return true;
		case WireFormat.WIRETYPE_LENGTH_DELIMITED:
			skipRawBytes(readRawVarint32());
			return true;
		case WireFormat.WIRETYPE_START_GROUP:
			skipMessage();
			checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), WireFormat.WIRETYPE_END_GROUP));
			return true;
		case WireFormat.WIRETYPE_END_GROUP:
			return false;
		case WireFormat.WIRETYPE_FIXED32:
			skipRawBytes(WireFormat.WIRETYPE_END_GROUP);
			return true;
		}
		throw InvalidProtocolBufferException.invalidWireType();
	}

	public boolean skipField(int tag, CodedOutputStream output) throws IOException {
		switch(WireFormat.getTagWireType(tag)) {
		case Utf8.COMPLETE:
			output.writeRawVarint32(tag);
			output.writeUInt64NoTag(readInt64());
			return true;
		case WireFormat.WIRETYPE_FIXED64:
			output.writeRawVarint32(tag);
			output.writeFixed64NoTag(readRawLittleEndian64());
			return true;
		case WireFormat.WIRETYPE_LENGTH_DELIMITED:
			output.writeRawVarint32(tag);
			output.writeBytesNoTag(readBytes());
			return true;
		case WireFormat.WIRETYPE_START_GROUP:
			output.writeRawVarint32(tag);
			skipMessage(output);
			int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), WireFormat.WIRETYPE_END_GROUP);
			checkLastTagWas(endtag);
			output.writeRawVarint32(endtag);
			return true;
		case WireFormat.WIRETYPE_END_GROUP:
			return false;
		case WireFormat.WIRETYPE_FIXED32:
			output.writeRawVarint32(tag);
			output.writeFixed32NoTag(readRawLittleEndian32());
			return true;
		}
		throw InvalidProtocolBufferException.invalidWireType();
	}

	public void skipMessage() throws IOException {
		int tag;
		do {
			tag = readTag();
			if (tag != 0) {
			}
		} while (skipField(tag));
	}

	public void skipMessage(CodedOutputStream output) throws IOException {
		int tag;
		do {
			tag = readTag();
			if (tag != 0) {
			}
		} while (skipField(tag, output));
	}

	public void skipRawBytes(int size) throws IOException {
		if (size < 0) {
			throw InvalidProtocolBufferException.negativeSize();
		} else if ((this.totalBytesRetired + this.bufferPos) + size > this.currentLimit) {
			skipRawBytes((this.currentLimit - this.totalBytesRetired) - this.bufferPos);
			throw InvalidProtocolBufferException.truncatedMessage();
		} else if (size <= this.bufferSize - this.bufferPos) {
			this.bufferPos += size;
			return;
		} else {
			int pos = this.bufferSize - this.bufferPos;
			this.bufferPos = this.bufferSize;
			refillBuffer(true);
			while (size - pos > this.bufferSize) {
				pos += this.bufferSize;
				this.bufferPos = this.bufferSize;
				refillBuffer(true);
			}
			this.bufferPos = size - pos;
		}
	}
}
