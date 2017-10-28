package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.ByteString.ByteIterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class LiteralByteString extends ByteString {
	protected final byte[] bytes;
	private int hash;

	private class LiteralByteIterator implements ByteIterator {
		private final int limit;
		private int position;

		private LiteralByteIterator() {
			this.position = 0;
			this.limit = size();
		}

		public boolean hasNext() {
			return this.position < this.limit;
		}

		public Byte next() {
			return Byte.valueOf(nextByte());
		}

		public byte nextByte() {
			try {
				byte[] r1_byte_A = bytes;
				int r2i = this.position;
				this.position = r2i + 1;
				return r1_byte_A[r2i];
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new NoSuchElementException(e.getMessage());
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	LiteralByteString(byte[] bytes) {
		this.hash = 0;
		this.bytes = bytes;
	}

	static int hashCode(int h, byte[] bytes, int offset, int length) {
		int i = offset;
		while (i < offset + length) {
			h = (h * 31) + bytes[i];
			i++;
		}
		return h;
	}

	static int hashCode(byte[] bytes) {
		int h = hashCode(bytes.length, bytes, 0, bytes.length);
		if (h == 0) {
			return 1;
		}
		return h;
	}

	public ByteBuffer asReadOnlyByteBuffer() {
		return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
	}

	public List<ByteBuffer> asReadOnlyByteBufferList() {
		List<ByteBuffer> result = new ArrayList(1);
		result.add(asReadOnlyByteBuffer());
		return result;
	}

	public byte byteAt(int index) {
		return this.bytes[index];
	}

	public void copyTo(ByteBuffer target) {
		target.put(this.bytes, getOffsetIntoBytes(), size());
	}

	protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
		System.arraycopy(this.bytes, sourceOffset, target, targetOffset, numberToCopy);
	}

	public boolean equals(Object other) {
		if (other == this) {
			return true;
		} else if (!((other instanceof ByteString))) {
			return false;
		} else if (size() != ((ByteString) other).size()) {
			return false;
		} else if (size() == 0) {
			return true;
		} else if (other instanceof LiteralByteString) {
			return equalsRange((LiteralByteString) other, 0, size());
		} else if (other instanceof RopeByteString) {
			return other.equals(this);
		} else {
			throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + other.getClass());
		}
	}

	boolean equalsRange(LiteralByteString other, int offset, int length) {
		if (length > other.size()) {
			throw new IllegalArgumentException("Length too large: " + length + size());
		} else if (offset + length > other.size()) {
			throw new IllegalArgumentException("Ran off end of other: " + offset + ", " + length + ", " + other.size());
		} else {
			byte[] thisBytes = this.bytes;
			byte[] otherBytes = other.bytes;
			int thisLimit = getOffsetIntoBytes() + length;
			int thisIndex = getOffsetIntoBytes();
			int otherIndex = other.getOffsetIntoBytes() + offset;
			while (thisIndex < thisLimit) {
				if (thisBytes[thisIndex] != otherBytes[otherIndex]) {
					return false;
				} else {
					thisIndex++;
					otherIndex++;
				}
			}
			return true;
		}
	}

	protected int getOffsetIntoBytes() {
		return 0;
	}

	protected int getTreeDepth() {
		return 0;
	}

	public int hashCode() {
		int h = this.hash;
		if (h == 0) {
			int size = size();
			h = partialHash(size, 0, size);
			if (h == 0) {
				h = 1;
			}
			this.hash = h;
		}
		return h;
	}

	protected boolean isBalanced() {
		return true;
	}

	public boolean isValidUtf8() {
		int offset = getOffsetIntoBytes();
		return Utf8.isValidUtf8(this.bytes, offset, size() + offset);
	}

	public ByteIterator iterator() {
		return new LiteralByteIterator(null);
	}

	public CodedInputStream newCodedInput() {
		return CodedInputStream.newInstance(this);
	}

	public InputStream newInput() {
		return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
	}

	protected int partialHash(int h, int offset, int length) {
		return hashCode(h, this.bytes, getOffsetIntoBytes() + offset, length);
	}

	protected int partialIsValidUtf8(int state, int offset, int length) {
		int index = getOffsetIntoBytes() + offset;
		return Utf8.partialIsValidUtf8(state, this.bytes, index, index + length);
	}

	protected int peekCachedHashCode() {
		return this.hash;
	}

	public int size() {
		return this.bytes.length;
	}

	public ByteString substring(int beginIndex, int endIndex) {
		if (beginIndex < 0) {
			throw new IndexOutOfBoundsException("Beginning index: " + beginIndex + " < 0");
		} else if (endIndex > size()) {
			throw new IndexOutOfBoundsException("End index: " + endIndex + " > " + size());
		} else {
			int substringLength = endIndex - beginIndex;
			if (substringLength < 0) {
				throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + beginIndex + ", " + endIndex);
			} else if (substringLength == 0) {
				return ByteString.EMPTY;
			} else {
				return new BoundedByteString(this.bytes, getOffsetIntoBytes() + beginIndex, substringLength);
			}
		}
	}

	public String toString(String charsetName) throws UnsupportedEncodingException {
		return new String(this.bytes, getOffsetIntoBytes(), size(), charsetName);
	}

	public void writeTo(OutputStream outputStream) throws IOException {
		outputStream.write(toByteArray());
	}

	void writeToInternal(OutputStream outputStream, int sourceOffset, int numberToWrite) throws IOException {
		outputStream.write(this.bytes, getOffsetIntoBytes() + sourceOffset, numberToWrite);
	}
}
