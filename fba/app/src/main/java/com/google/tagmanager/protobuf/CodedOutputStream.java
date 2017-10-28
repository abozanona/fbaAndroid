package com.google.tagmanager.protobuf;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class CodedOutputStream {
	public static final int DEFAULT_BUFFER_SIZE = 4096;
	public static final int LITTLE_ENDIAN_32_SIZE = 4;
	public static final int LITTLE_ENDIAN_64_SIZE = 8;
	private final byte[] buffer;
	private final int limit;
	private final OutputStream output;
	private int position;
	private int totalBytesWritten;

	private static class ByteBufferOutputStream extends OutputStream {
		private final ByteBuffer byteBuffer;

		public ByteBufferOutputStream(ByteBuffer byteBuffer) {
			this.byteBuffer = byteBuffer;
		}

		public void write(int b) throws IOException {
			this.byteBuffer.put((byte) b);
		}

		public void write(byte[] data, int offset, int length) throws IOException {
			this.byteBuffer.put(data, offset, length);
		}
	}

	public static class OutOfSpaceException extends IOException {
		private static final long serialVersionUID = -6947486886997889499L;

		OutOfSpaceException() {
			super("CodedOutputStream was writing to a flat byte array and ran out of space.");
		}
	}


	private CodedOutputStream(OutputStream output, byte[] buffer) {
		this.totalBytesWritten = 0;
		this.output = output;
		this.buffer = buffer;
		this.position = 0;
		this.limit = buffer.length;
	}

	private CodedOutputStream(byte[] buffer, int offset, int length) {
		this.totalBytesWritten = 0;
		this.output = null;
		this.buffer = buffer;
		this.position = offset;
		this.limit = offset + length;
	}

	public static int computeBoolSize(int fieldNumber, boolean value) {
		return computeTagSize(fieldNumber) + computeBoolSizeNoTag(value);
	}

	public static int computeBoolSizeNoTag(boolean value) {
		return 1;
	}

	public static int computeByteArraySize(int fieldNumber, byte[] value) {
		return computeTagSize(fieldNumber) + computeByteArraySizeNoTag(value);
	}

	public static int computeByteArraySizeNoTag(byte[] value) {
		return computeRawVarint32Size(value.length) + value.length;
	}

	public static int computeByteBufferSize(int fieldNumber, ByteBuffer value) {
		return computeTagSize(fieldNumber) + computeByteBufferSizeNoTag(value);
	}

	public static int computeByteBufferSizeNoTag(ByteBuffer value) {
		return computeRawVarint32Size(value.capacity()) + value.capacity();
	}

	public static int computeBytesSize(int fieldNumber, ByteString value) {
		return computeTagSize(fieldNumber) + computeBytesSizeNoTag(value);
	}

	public static int computeBytesSizeNoTag(ByteString value) {
		return computeRawVarint32Size(value.size()) + value.size();
	}

	public static int computeDoubleSize(int fieldNumber, double value) {
		return computeTagSize(fieldNumber) + computeDoubleSizeNoTag(value);
	}

	public static int computeDoubleSizeNoTag(double value) {
		return LITTLE_ENDIAN_64_SIZE;
	}

	public static int computeEnumSize(int fieldNumber, int value) {
		return computeTagSize(fieldNumber) + computeEnumSizeNoTag(value);
	}

	public static int computeEnumSizeNoTag(int value) {
		return computeInt32SizeNoTag(value);
	}

	public static int computeFixed32Size(int fieldNumber, int value) {
		return computeTagSize(fieldNumber) + computeFixed32SizeNoTag(value);
	}

	public static int computeFixed32SizeNoTag(int value) {
		return LITTLE_ENDIAN_32_SIZE;
	}

	public static int computeFixed64Size(int fieldNumber, long value) {
		return computeTagSize(fieldNumber) + computeFixed64SizeNoTag(value);
	}

	public static int computeFixed64SizeNoTag(long value) {
		return LITTLE_ENDIAN_64_SIZE;
	}

	public static int computeFloatSize(int fieldNumber, float value) {
		return computeTagSize(fieldNumber) + computeFloatSizeNoTag(value);
	}

	public static int computeFloatSizeNoTag(float value) {
		return LITTLE_ENDIAN_32_SIZE;
	}

	public static int computeGroupSize(int fieldNumber, MessageLite value) {
		return (computeTagSize(fieldNumber) * 2) + computeGroupSizeNoTag(value);
	}

	public static int computeGroupSizeNoTag(MessageLite value) {
		return value.getSerializedSize();
	}

	public static int computeInt32Size(int fieldNumber, int value) {
		return computeTagSize(fieldNumber) + computeInt32SizeNoTag(value);
	}

	public static int computeInt32SizeNoTag(int value) {
		return (value >= 0) ? computeRawVarint32Size(value) : Value.ESCAPING_FIELD_NUMBER;
	}

	public static int computeInt64Size(int fieldNumber, long value) {
		return computeTagSize(fieldNumber) + computeInt64SizeNoTag(value);
	}

	public static int computeInt64SizeNoTag(long value) {
		return computeRawVarint64Size(value);
	}

	public static int computeLazyFieldMessageSetExtensionSize(int fieldNumber, LazyField value) {
		return ((computeTagSize(1) * 2) + computeUInt32Size(WireFormat.WIRETYPE_LENGTH_DELIMITED, fieldNumber)) + computeLazyFieldSize(WireFormat.WIRETYPE_START_GROUP, value);
	}

	public static int computeLazyFieldSize(int fieldNumber, LazyField value) {
		return computeTagSize(fieldNumber) + computeLazyFieldSizeNoTag(value);
	}

	public static int computeLazyFieldSizeNoTag(LazyField value) {
		int size = value.getSerializedSize();
		return computeRawVarint32Size(size) + size;
	}

	public static int computeMessageSetExtensionSize(int fieldNumber, MessageLite value) {
		return ((computeTagSize(1) * 2) + computeUInt32Size(WireFormat.WIRETYPE_LENGTH_DELIMITED, fieldNumber)) + computeMessageSize(WireFormat.WIRETYPE_START_GROUP, value);
	}

	public static int computeMessageSize(int fieldNumber, MessageLite value) {
		return computeTagSize(fieldNumber) + computeMessageSizeNoTag(value);
	}

	public static int computeMessageSizeNoTag(MessageLite value) {
		int size = value.getSerializedSize();
		return computeRawVarint32Size(size) + size;
	}

	static int computePreferredBufferSize(int dataLength) {
		if (dataLength > 4096) {
			return 4096;
		}
		return dataLength;
	}

	public static int computeRawMessageSetExtensionSize(int fieldNumber, ByteString value) {
		return ((computeTagSize(1) * 2) + computeUInt32Size(WireFormat.WIRETYPE_LENGTH_DELIMITED, fieldNumber)) + computeBytesSize(WireFormat.WIRETYPE_START_GROUP, value);
	}

	public static int computeRawVarint32Size(int value) {
		if ((value & -128) == 0) {
			return 1;
		} else if ((value & -16384) == 0) {
			return WireFormat.WIRETYPE_LENGTH_DELIMITED;
		} else if ((-2097152 & value) == 0) {
			return WireFormat.WIRETYPE_START_GROUP;
		} else if ((-268435456 & value) == 0) {
			return LITTLE_ENDIAN_32_SIZE;
		} else {
			return WireFormat.WIRETYPE_FIXED32;
		}
	}

	public static int computeRawVarint64Size(long value) {
		if ((-128 & value) == 0) {
			return 1;
		} else if ((-16384 & value) == 0) {
			return WireFormat.WIRETYPE_LENGTH_DELIMITED;
		} else if ((-2097152 & value) == 0) {
			return WireFormat.WIRETYPE_START_GROUP;
		} else if ((-268435456 & value) == 0) {
			return LITTLE_ENDIAN_32_SIZE;
		} else if ((-34359738368L & value) == 0) {
			return WireFormat.WIRETYPE_FIXED32;
		} else if ((-4398046511104L & value) == 0) {
			return Value.MACRO_REFERENCE_FIELD_NUMBER;
		} else if ((-562949953421312L & value) == 0) {
			return Value.FUNCTION_ID_FIELD_NUMBER;
		} else if ((-72057594037927936L & value) == 0) {
			return LITTLE_ENDIAN_64_SIZE;
		} else if ((-9223372036854775808L & value) == 0) {
			return Value.CONTAINS_REFERENCES_FIELD_NUMBER;
		} else {
			return Value.ESCAPING_FIELD_NUMBER;
		}
	}

	public static int computeSFixed32Size(int fieldNumber, int value) {
		return computeTagSize(fieldNumber) + computeSFixed32SizeNoTag(value);
	}

	public static int computeSFixed32SizeNoTag(int value) {
		return LITTLE_ENDIAN_32_SIZE;
	}

	public static int computeSFixed64Size(int fieldNumber, long value) {
		return computeTagSize(fieldNumber) + computeSFixed64SizeNoTag(value);
	}

	public static int computeSFixed64SizeNoTag(long value) {
		return LITTLE_ENDIAN_64_SIZE;
	}

	public static int computeSInt32Size(int fieldNumber, int value) {
		return computeTagSize(fieldNumber) + computeSInt32SizeNoTag(value);
	}

	public static int computeSInt32SizeNoTag(int value) {
		return computeRawVarint32Size(encodeZigZag32(value));
	}

	public static int computeSInt64Size(int fieldNumber, long value) {
		return computeTagSize(fieldNumber) + computeSInt64SizeNoTag(value);
	}

	public static int computeSInt64SizeNoTag(long value) {
		return computeRawVarint64Size(encodeZigZag64(value));
	}

	public static int computeStringSize(int fieldNumber, String value) {
		return computeTagSize(fieldNumber) + computeStringSizeNoTag(value);
	}

	public static int computeStringSizeNoTag(String value) {
		try {
			byte[] bytes = value.getBytes("UTF-8");
			return computeRawVarint32Size(bytes.length) + bytes.length;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 not supported.", e);
		}
	}

	public static int computeTagSize(int fieldNumber) {
		return computeRawVarint32Size(WireFormat.makeTag(fieldNumber, 0));
	}

	public static int computeUInt32Size(int fieldNumber, int value) {
		return computeTagSize(fieldNumber) + computeUInt32SizeNoTag(value);
	}

	public static int computeUInt32SizeNoTag(int value) {
		return computeRawVarint32Size(value);
	}

	public static int computeUInt64Size(int fieldNumber, long value) {
		return computeTagSize(fieldNumber) + computeUInt64SizeNoTag(value);
	}

	public static int computeUInt64SizeNoTag(long value) {
		return computeRawVarint64Size(value);
	}

	@Deprecated
	public static int computeUnknownGroupSize(int fieldNumber, MessageLite value) {
		return computeGroupSize(fieldNumber, value);
	}

	@Deprecated
	public static int computeUnknownGroupSizeNoTag(MessageLite value) {
		return computeGroupSizeNoTag(value);
	}

	public static int encodeZigZag32(int n) {
		return (n << 1) ^ (n >> 31);
	}

	public static long encodeZigZag64(long n) {
		return (n << 1) ^ (n >> 63);
	}

	public static CodedOutputStream newInstance(OutputStream output) {
		return newInstance(output, (int)DEFAULT_BUFFER_SIZE);
	}

	public static CodedOutputStream newInstance(OutputStream output, int bufferSize) {
		return new CodedOutputStream(output, new byte[bufferSize]);
	}

	public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
		return newInstance(byteBuffer, (int)DEFAULT_BUFFER_SIZE);
	}

	public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int bufferSize) {
		return newInstance(new ByteBufferOutputStream(byteBuffer), bufferSize);
	}

	public static CodedOutputStream newInstance(byte[] flatArray) {
		return newInstance(flatArray, 0, flatArray.length);
	}

	public static CodedOutputStream newInstance(byte[] flatArray, int offset, int length) {
		return new CodedOutputStream(flatArray, offset, length);
	}

	private void refreshBuffer() throws IOException {
		if (this.output == null) {
			throw new OutOfSpaceException();
		} else {
			this.output.write(this.buffer, 0, this.position);
			this.position = 0;
		}
	}

	private void writeRawBytesInternal(ByteBuffer value) throws IOException {
		int length = value.remaining();
		if (this.limit - this.position >= length) {
			value.get(this.buffer, this.position, length);
			this.position += length;
			this.totalBytesWritten += length;
			return;
		} else {
			int bytesWritten = this.limit - this.position;
			value.get(this.buffer, this.position, bytesWritten);
			length -= bytesWritten;
			this.position = this.limit;
			this.totalBytesWritten += bytesWritten;
			refreshBuffer();
			while (length > this.limit) {
				value.get(this.buffer, 0, this.limit);
				this.output.write(this.buffer, 0, this.limit);
				length -= this.limit;
				this.totalBytesWritten += this.limit;
			}
			value.get(this.buffer, 0, length);
			this.position = length;
			this.totalBytesWritten += length;
		}
	}

	public void checkNoSpaceLeft() {
		if (spaceLeft() != 0) {
			throw new IllegalStateException("Did not write as much data as expected.");
		}
	}

	public void flush() throws IOException {
		if (this.output != null) {
			refreshBuffer();
		}
	}

	public int getTotalBytesWritten() {
		return this.totalBytesWritten;
	}

	public int spaceLeft() {
		if (this.output == null) {
			return this.limit - this.position;
		} else {
			throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
		}
	}

	public void writeBool(int fieldNumber, boolean value) throws IOException {
		writeTag(fieldNumber, 0);
		writeBoolNoTag(value);
	}

	public void writeBoolNoTag(boolean value) throws IOException {
		writeRawByte((value) ? 1 : 0);
	}

	public void writeByteArray(int fieldNumber, byte[] value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED);
		writeByteArrayNoTag(value);
	}

	public void writeByteArrayNoTag(byte[] value) throws IOException {
		writeRawVarint32(value.length);
		writeRawBytes(value);
	}

	public void writeByteBuffer(int fieldNumber, ByteBuffer value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED);
		writeByteBufferNoTag(value);
	}

	public void writeByteBufferNoTag(ByteBuffer value) throws IOException {
		writeRawVarint32(value.capacity());
		writeRawBytes(value);
	}

	public void writeBytes(int fieldNumber, ByteString value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED);
		writeBytesNoTag(value);
	}

	public void writeBytesNoTag(ByteString value) throws IOException {
		writeRawVarint32(value.size());
		writeRawBytes(value);
	}

	public void writeDouble(int fieldNumber, double value) throws IOException {
		writeTag(fieldNumber, 1);
		writeDoubleNoTag(value);
	}

	public void writeDoubleNoTag(double value) throws IOException {
		writeRawLittleEndian64(Double.doubleToRawLongBits(value));
	}

	public void writeEnum(int fieldNumber, int value) throws IOException {
		writeTag(fieldNumber, 0);
		writeEnumNoTag(value);
	}

	public void writeEnumNoTag(int value) throws IOException {
		writeInt32NoTag(value);
	}

	public void writeFixed32(int fieldNumber, int value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_FIXED32);
		writeFixed32NoTag(value);
	}

	public void writeFixed32NoTag(int value) throws IOException {
		writeRawLittleEndian32(value);
	}

	public void writeFixed64(int fieldNumber, long value) throws IOException {
		writeTag(fieldNumber, 1);
		writeFixed64NoTag(value);
	}

	public void writeFixed64NoTag(long value) throws IOException {
		writeRawLittleEndian64(value);
	}

	public void writeFloat(int fieldNumber, float value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_FIXED32);
		writeFloatNoTag(value);
	}

	public void writeFloatNoTag(float value) throws IOException {
		writeRawLittleEndian32(Float.floatToRawIntBits(value));
	}

	public void writeGroup(int fieldNumber, MessageLite value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_START_GROUP);
		writeGroupNoTag(value);
		writeTag(fieldNumber, LITTLE_ENDIAN_32_SIZE);
	}

	public void writeGroupNoTag(MessageLite value) throws IOException {
		value.writeTo(this);
	}

	public void writeGroupNoTagWithCachedSizes(MutableMessageLite value) throws IOException {
		value.writeToWithCachedSizes(this);
	}

	public void writeGroupWithCachedSizes(int fieldNumber, MutableMessageLite value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_START_GROUP);
		writeGroupNoTagWithCachedSizes(value);
		writeTag(fieldNumber, LITTLE_ENDIAN_32_SIZE);
	}

	public void writeInt32(int fieldNumber, int value) throws IOException {
		writeTag(fieldNumber, 0);
		writeInt32NoTag(value);
	}

	public void writeInt32NoTag(int value) throws IOException {
		if (value >= 0) {
			writeRawVarint32(value);
			return;
		} else {
			writeRawVarint64((long) value);
		}
	}

	public void writeInt64(int fieldNumber, long value) throws IOException {
		writeTag(fieldNumber, 0);
		writeInt64NoTag(value);
	}

	public void writeInt64NoTag(long value) throws IOException {
		writeRawVarint64(value);
	}

	public void writeMessage(int fieldNumber, MessageLite value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED);
		writeMessageNoTag(value);
	}

	public void writeMessageNoTag(MessageLite value) throws IOException {
		writeRawVarint32(value.getSerializedSize());
		value.writeTo(this);
	}

	public void writeMessageNoTagWithCachedSizes(MutableMessageLite value) throws IOException {
		writeRawVarint32(value.getCachedSize());
		value.writeToWithCachedSizes(this);
	}

	public void writeMessageSetExtension(int fieldNumber, MessageLite value) throws IOException {
		writeTag(1, WireFormat.WIRETYPE_START_GROUP);
		writeUInt32(WireFormat.WIRETYPE_LENGTH_DELIMITED, fieldNumber);
		writeMessage(WireFormat.WIRETYPE_START_GROUP, value);
		writeTag(1, LITTLE_ENDIAN_32_SIZE);
	}

	public void writeMessageWithCachedSizes(int fieldNumber, MutableMessageLite value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED);
		writeMessageNoTagWithCachedSizes(value);
	}

	public void writeRawByte(byte value) throws IOException {
		if (this.position == this.limit) {
			refreshBuffer();
		}
		byte[] r0_byte_A = this.buffer;
		int r1i = this.position;
		this.position = r1i + 1;
		r0_byte_A[r1i] = value;
		this.totalBytesWritten++;
	}

	public void writeRawByte(int value) throws IOException {
		writeRawByte((byte) value);
	}

	public void writeRawBytes(ByteString value) throws IOException {
		writeRawBytes(value, 0, value.size());
	}

	public void writeRawBytes(ByteString value, int offset, int length) throws IOException {
		if (this.limit - this.position >= length) {
			value.copyTo(this.buffer, offset, this.position, length);
			this.position += length;
			this.totalBytesWritten += length;
			return;
		} else {
			int bytesWritten = this.limit - this.position;
			value.copyTo(this.buffer, offset, this.position, bytesWritten);
			offset += bytesWritten;
			length -= bytesWritten;
			this.position = this.limit;
			this.totalBytesWritten += bytesWritten;
			refreshBuffer();
			if (length <= this.limit) {
				value.copyTo(this.buffer, offset, 0, length);
				this.position = length;
			} else {
				value.writeTo(this.output, offset, length);
			}
			this.totalBytesWritten += length;
		}
	}

	public void writeRawBytes(ByteBuffer value) throws IOException {
		if (value.hasArray()) {
			writeRawBytes(value.array(), value.arrayOffset(), value.capacity());
			return;
		} else {
			ByteBuffer duplicated = value.duplicate();
			duplicated.clear();
			writeRawBytesInternal(duplicated);
		}
	}

	public void writeRawBytes(byte[] value) throws IOException {
		writeRawBytes(value, 0, value.length);
	}

	public void writeRawBytes(byte[] value, int offset, int length) throws IOException {
		if (this.limit - this.position >= length) {
			System.arraycopy(value, offset, this.buffer, this.position, length);
			this.position += length;
			this.totalBytesWritten += length;
			return;
		} else {
			int bytesWritten = this.limit - this.position;
			System.arraycopy(value, offset, this.buffer, this.position, bytesWritten);
			offset += bytesWritten;
			length -= bytesWritten;
			this.position = this.limit;
			this.totalBytesWritten += bytesWritten;
			refreshBuffer();
			if (length <= this.limit) {
				System.arraycopy(value, offset, this.buffer, 0, length);
				this.position = length;
			} else {
				this.output.write(value, offset, length);
			}
			this.totalBytesWritten += length;
		}
	}

	public void writeRawLittleEndian32(int value) throws IOException {
		writeRawByte(value & 255);
		writeRawByte((value >> 8) & 255);
		writeRawByte((value >> 16) & 255);
		writeRawByte((value >> 24) & 255);
	}

	public void writeRawLittleEndian64(long value) throws IOException {
		writeRawByte(((int) value) & 255);
		writeRawByte(((int) (value >> 8)) & 255);
		writeRawByte(((int) (value >> 16)) & 255);
		writeRawByte(((int) (value >> 24)) & 255);
		writeRawByte(((int) (value >> 32)) & 255);
		writeRawByte(((int) (value >> 40)) & 255);
		writeRawByte(((int) (value >> 48)) & 255);
		writeRawByte(((int) (value >> 56)) & 255);
	}

	public void writeRawMessageSetExtension(int fieldNumber, ByteString value) throws IOException {
		writeTag(1, WireFormat.WIRETYPE_START_GROUP);
		writeUInt32(WireFormat.WIRETYPE_LENGTH_DELIMITED, fieldNumber);
		writeBytes(WireFormat.WIRETYPE_START_GROUP, value);
		writeTag(1, LITTLE_ENDIAN_32_SIZE);
	}

	public void writeRawVarint32(int value) throws IOException {
		while ((value & -128) != 0) {
			writeRawByte((value & 127) | 128);
			value >>>= 7;
		}
		writeRawByte(value);
	}

	public void writeRawVarint64(long value) throws IOException {
		while ((-128 & value) != 0) {
			writeRawByte((((int) value) & 127) | 128);
			value >>>= 7;
		}
		writeRawByte((int) value);
	}

	public void writeSFixed32(int fieldNumber, int value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_FIXED32);
		writeSFixed32NoTag(value);
	}

	public void writeSFixed32NoTag(int value) throws IOException {
		writeRawLittleEndian32(value);
	}

	public void writeSFixed64(int fieldNumber, long value) throws IOException {
		writeTag(fieldNumber, 1);
		writeSFixed64NoTag(value);
	}

	public void writeSFixed64NoTag(long value) throws IOException {
		writeRawLittleEndian64(value);
	}

	public void writeSInt32(int fieldNumber, int value) throws IOException {
		writeTag(fieldNumber, 0);
		writeSInt32NoTag(value);
	}

	public void writeSInt32NoTag(int value) throws IOException {
		writeRawVarint32(encodeZigZag32(value));
	}

	public void writeSInt64(int fieldNumber, long value) throws IOException {
		writeTag(fieldNumber, 0);
		writeSInt64NoTag(value);
	}

	public void writeSInt64NoTag(long value) throws IOException {
		writeRawVarint64(encodeZigZag64(value));
	}

	public void writeString(int fieldNumber, String value) throws IOException {
		writeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED);
		writeStringNoTag(value);
	}

	public void writeStringNoTag(String value) throws IOException {
		byte[] bytes = value.getBytes("UTF-8");
		writeRawVarint32(bytes.length);
		writeRawBytes(bytes);
	}

	public void writeTag(int fieldNumber, int wireType) throws IOException {
		writeRawVarint32(WireFormat.makeTag(fieldNumber, wireType));
	}

	public void writeUInt32(int fieldNumber, int value) throws IOException {
		writeTag(fieldNumber, 0);
		writeUInt32NoTag(value);
	}

	public void writeUInt32NoTag(int value) throws IOException {
		writeRawVarint32(value);
	}

	public void writeUInt64(int fieldNumber, long value) throws IOException {
		writeTag(fieldNumber, 0);
		writeUInt64NoTag(value);
	}

	public void writeUInt64NoTag(long value) throws IOException {
		writeRawVarint64(value);
	}

	@Deprecated
	public void writeUnknownGroup(int fieldNumber, MessageLite value) throws IOException {
		writeGroup(fieldNumber, value);
	}

	@Deprecated
	public void writeUnknownGroupNoTag(MessageLite value) throws IOException {
		writeGroupNoTag(value);
	}
}
