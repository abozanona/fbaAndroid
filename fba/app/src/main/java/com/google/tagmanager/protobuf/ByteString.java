package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class ByteString implements Iterable<Byte> {
	static final /* synthetic */ boolean $assertionsDisabled;
	static final int CONCATENATE_BY_COPY_SIZE = 128;
	public static final ByteString EMPTY;
	static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
	static final int MIN_READ_FROM_CHUNK_SIZE = 256;

	public static interface ByteIterator extends Iterator<Byte> {
		public byte nextByte();
	}

	static final class CodedBuilder {
		private final byte[] buffer;
		private final CodedOutputStream output;

		private CodedBuilder(int size) {
			this.buffer = new byte[size];
			this.output = CodedOutputStream.newInstance(this.buffer);
		}

		public ByteString build() {
			this.output.checkNoSpaceLeft();
			return new LiteralByteString(this.buffer);
		}

		public CodedOutputStream getCodedOutput() {
			return this.output;
		}
	}

	public static final class Output extends OutputStream {
		private static final byte[] EMPTY_BYTE_ARRAY;
		private byte[] buffer;
		private int bufferPos;
		private final ArrayList<ByteString> flushedBuffers;
		private int flushedBuffersTotalBytes;
		private final int initialCapacity;

		static {
			EMPTY_BYTE_ARRAY = new byte[0];
		}

		Output(int initialCapacity) {
			if (initialCapacity < 0) {
				throw new IllegalArgumentException("Buffer size < 0");
			} else {
				this.initialCapacity = initialCapacity;
				this.flushedBuffers = new ArrayList();
				this.buffer = new byte[initialCapacity];
			}
		}

		private void flushFullBuffer(int minSize) {
			this.flushedBuffers.add(new LiteralByteString(this.buffer));
			this.flushedBuffersTotalBytes += this.buffer.length;
			this.buffer = new byte[Math.max(this.initialCapacity, Math.max(minSize, this.flushedBuffersTotalBytes >>> 1))];
			this.bufferPos = 0;
		}

		private void flushLastBuffer() {
			if (this.bufferPos < this.buffer.length) {
				if (this.bufferPos > 0) {
					Object bufferCopy = new Object[this.bufferPos];
					System.arraycopy(this.buffer, 0, bufferCopy, 0, this.bufferPos);
					this.flushedBuffers.add(new LiteralByteString(bufferCopy));
				}
			} else {
				this.flushedBuffers.add(new LiteralByteString(this.buffer));
				this.buffer = EMPTY_BYTE_ARRAY;
			}
			this.flushedBuffersTotalBytes += this.bufferPos;
			this.bufferPos = 0;
		}

		public synchronized void reset() {
			synchronized(this) {
				this.flushedBuffers.clear();
				this.flushedBuffersTotalBytes = 0;
				this.bufferPos = 0;
			}
		}

		public synchronized int size() {
			int r0i;
			synchronized(this) {
				r0i = this.flushedBuffersTotalBytes + this.bufferPos;
			}
			return r0i;
		}

		public synchronized ByteString toByteString() {
			ByteString r0_ByteString;
			synchronized(this) {
				flushLastBuffer();
				r0_ByteString = ByteString.copyFrom(this.flushedBuffers);
			}
			return r0_ByteString;
		}

		public String toString() {
			Object[] r1_Object_A = new Object[2];
			r1_Object_A[0] = Integer.toHexString(System.identityHashCode(this));
			r1_Object_A[1] = Integer.valueOf(size());
			return String.format("<ByteString.Output@%s size=%d>", r1_Object_A);
		}

		public synchronized void write(int b) {
			synchronized(this) {
				if (this.bufferPos == this.buffer.length) {
					flushFullBuffer(1);
				}
				byte[] r0_byte_A = this.buffer;
				int r1i = this.bufferPos;
				this.bufferPos = r1i + 1;
				r0_byte_A[r1i] = (byte) b;
			}
		}

		public synchronized void write(byte[] b, int offset, int length) {
			synchronized(this) {
				if (length <= this.buffer.length - this.bufferPos) {
					System.arraycopy(b, offset, this.buffer, this.bufferPos, length);
					this.bufferPos += length;
				} else {
					int copySize = this.buffer.length - this.bufferPos;
					System.arraycopy(b, offset, this.buffer, this.bufferPos, copySize);
					length -= copySize;
					flushFullBuffer(length);
					System.arraycopy(b, offset + copySize, this.buffer, 0, length);
					this.bufferPos = length;
				}
			}
		}

		public void writeTo(OutputStream out) throws IOException {
			ByteString[] cachedFlushBuffers;
			Object cachedBuffer;
			int cachedBufferPos;
			synchronized(this) {
				cachedFlushBuffers = (ByteString[]) this.flushedBuffers.toArray(new ByteString[this.flushedBuffers.size()]);
				cachedBuffer = this.buffer;
				cachedBufferPos = this.bufferPos;
			}
			ByteString[] arr$ = cachedFlushBuffers;
			int len$ = arr$.length;
			int i$ = 0;
			while (i$ < len$) {
				arr$[i$].writeTo(out);
				i$++;
			}
			Object cachedBufferCopy = new Object[cachedBufferPos];
			System.arraycopy(cachedBuffer, 0, cachedBufferCopy, 0, cachedBufferPos);
			out.write(cachedBufferCopy);
		}
	}


	static {
		int r1i = 0;
		$assertionsDisabled = !ByteString.class.desiredAssertionStatus();
		EMPTY = new LiteralByteString(new byte[r1i]);
	}

	ByteString() {
	}

	/* JADX WARNING: inconsistent code */
	/*
	private static com.google.tagmanager.protobuf.ByteString balancedConcat(java.util.Iterator<com.google.tagmanager.protobuf.ByteString> r6_iterator, int r7_length) {
		r5 = 1;
		r4 = $assertionsDisabled;
		if (r4 != 0) goto L_0x000d;
	L_0x0005:
		if (r7_length >= r5) goto L_0x000d;
	L_0x0007:
		r4 = new java.lang.AssertionError;
		r4.<init>();
		throw r4;
	L_0x000d:
		if (r7_length != r5) goto L_0x0016;
	L_0x000f:
		r2 = r6_iterator.next();
		r2 = (com.google.tagmanager.protobuf.ByteString) r2;
	L_0x0015:
		return r2_result;
	L_0x0016:
		r0 = r7_length >>> 1;
		r1 = balancedConcat(r6_iterator, r0_halfLength);
		r4 = r7_length - r0_halfLength;
		r3 = balancedConcat(r6_iterator, r4);
		r2_result = r1_left.concat(r3_right);
		goto L_0x0015;
	}
	*/
	private static ByteString balancedConcat(Iterator<ByteString> r6_Iterator_ByteString, int length) {
		if ($assertionsDisabled || length >= 1) {
			int halfLength = length >>> 1;
			return balancedConcat(iterator, halfLength).concat(balancedConcat(iterator, length - halfLength));
		} else {
			throw new AssertionError();
		}
	}

	public static ByteString copyFrom(Iterable<ByteString> byteStrings) {
		Collection<ByteString> collection;
		if (!((byteStrings instanceof Collection))) {
			collection = new ArrayList();
			Iterator i$ = byteStrings.iterator();
			while (i$.hasNext()) {
				collection.add((ByteString) i$.next());
			}
		} else {
			collection = (Collection) byteStrings;
		}
		return (collection.isEmpty()) ? EMPTY : balancedConcat(collection.iterator(), collection.size());
	}

	public static ByteString copyFrom(String text, String charsetName) throws UnsupportedEncodingException {
		return new LiteralByteString(text.getBytes(charsetName));
	}

	public static ByteString copyFrom(ByteBuffer bytes) {
		return copyFrom(bytes, bytes.remaining());
	}

	public static ByteString copyFrom(ByteBuffer bytes, int size) {
		byte[] copy = new byte[size];
		bytes.get(copy);
		return new LiteralByteString(copy);
	}

	public static ByteString copyFrom(byte[] bytes) {
		return copyFrom(bytes, 0, bytes.length);
	}

	public static ByteString copyFrom(byte[] bytes, int offset, int size) {
		Object copy = new Object[size];
		System.arraycopy(bytes, offset, copy, 0, size);
		return new LiteralByteString(copy);
	}

	public static ByteString copyFromUtf8(String text) {
		try {
			return new LiteralByteString(text.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 not supported?", e);
		}
	}

	static CodedBuilder newCodedBuilder(int size) {
		return new CodedBuilder(null);
	}

	public static Output newOutput() {
		return new Output(128);
	}

	public static Output newOutput(int initialCapacity) {
		return new Output(initialCapacity);
	}

	private static ByteString readChunk(InputStream in, int chunkSize) throws IOException {
		byte[] buf = new byte[chunkSize];
		int bytesRead = 0;
		while (bytesRead < chunkSize) {
			int count = in.read(buf, bytesRead, chunkSize - bytesRead);
			if (count == -1) {
				return (bytesRead != 0) ? null : copyFrom(buf, 0, bytesRead);
			} else {
				bytesRead += count;
			}
		}
		if (bytesRead != 0) {
		}
	}

	public static ByteString readFrom(InputStream streamToDrain) throws IOException {
		return readFrom(streamToDrain, MIN_READ_FROM_CHUNK_SIZE, MAX_READ_FROM_CHUNK_SIZE);
	}

	public static ByteString readFrom(InputStream streamToDrain, int chunkSize) throws IOException {
		return readFrom(streamToDrain, chunkSize, chunkSize);
	}

	public static ByteString readFrom(InputStream streamToDrain, int minChunkSize, int maxChunkSize) throws IOException {
		Iterable results = new ArrayList();
		int chunkSize = minChunkSize;
		while (true) {
			ByteString chunk = readChunk(streamToDrain, chunkSize);
			if (chunk == null) {
				return copyFrom(results);
			} else {
				results.add(chunk);
				chunkSize = Math.min(chunkSize * 2, maxChunkSize);
			}
		}
	}

	public abstract ByteBuffer asReadOnlyByteBuffer();

	public abstract List<ByteBuffer> asReadOnlyByteBufferList();

	public abstract byte byteAt(int r1i);

	public ByteString concat(ByteString other) {
		int thisSize = size();
		int otherSize = other.size();
		if (((long) thisSize) + ((long) otherSize) >= 2147483647L) {
			throw new IllegalArgumentException("ByteString would be too long: " + thisSize + "+" + otherSize);
		} else {
			return RopeByteString.concatenate(this, other);
		}
	}

	public abstract void copyTo(ByteBuffer r1_ByteBuffer);

	public void copyTo(byte[] target, int offset) {
		copyTo(target, 0, offset, size());
	}

	public void copyTo(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
		if (sourceOffset < 0) {
			throw new IndexOutOfBoundsException("Source offset < 0: " + sourceOffset);
		} else if (targetOffset < 0) {
			throw new IndexOutOfBoundsException("Target offset < 0: " + targetOffset);
		} else if (numberToCopy < 0) {
			throw new IndexOutOfBoundsException("Length < 0: " + numberToCopy);
		} else if (sourceOffset + numberToCopy > size()) {
			throw new IndexOutOfBoundsException("Source end offset < 0: " + (sourceOffset + numberToCopy));
		} else if (targetOffset + numberToCopy > target.length) {
			throw new IndexOutOfBoundsException("Target end offset < 0: " + (targetOffset + numberToCopy));
		} else {
			if (numberToCopy > 0) {
				copyToInternal(target, sourceOffset, targetOffset, numberToCopy);
			}
		}
	}

	protected abstract void copyToInternal(byte[] r1_byte_A, int r2i, int r3i, int r4i);

	public boolean endsWith(ByteString suffix) {
		return (size() < suffix.size() || !substring(size() - suffix.size()).equals(suffix)) ? $assertionsDisabled : true;
	}

	public abstract boolean equals(Object r1_Object);

	protected abstract int getTreeDepth();

	public abstract int hashCode();

	protected abstract boolean isBalanced();

	public boolean isEmpty() {
		return (size() == 0) ? true : $assertionsDisabled;
	}

	public abstract boolean isValidUtf8();

	public abstract ByteIterator iterator();

	public abstract CodedInputStream newCodedInput();

	public abstract InputStream newInput();

	protected abstract int partialHash(int r1i, int r2i, int r3i);

	protected abstract int partialIsValidUtf8(int r1i, int r2i, int r3i);

	protected abstract int peekCachedHashCode();

	public abstract int size();

	public boolean startsWith(ByteString prefix) {
		if (size() >= prefix.size()) {
			if (substring(0, prefix.size()).equals(prefix)) {
				return true;
			}
			return $assertionsDisabled;
		}
		return $assertionsDisabled;
	}

	public ByteString substring(int beginIndex) {
		return substring(beginIndex, size());
	}

	public abstract ByteString substring(int r1i, int r2i);

	public byte[] toByteArray() {
		int size = size();
		if (size == 0) {
			return Internal.EMPTY_BYTE_ARRAY;
		} else {
			byte[] result = new byte[size];
			copyToInternal(result, 0, 0, size);
			return result;
		}
	}

	public String toString() {
		Object[] r1_Object_A = new Object[2];
		r1_Object_A[0] = Integer.toHexString(System.identityHashCode(this));
		r1_Object_A[1] = Integer.valueOf(size());
		return String.format("<ByteString@%s size=%d>", r1_Object_A);
	}

	public abstract String toString(String r1_String) throws UnsupportedEncodingException;

	public String toStringUtf8() {
		try {
			return toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 not supported?", e);
		}
	}

	public abstract void writeTo(OutputStream r1_OutputStream) throws IOException;

	void writeTo(OutputStream out, int sourceOffset, int numberToWrite) throws IOException {
		if (sourceOffset < 0) {
			throw new IndexOutOfBoundsException("Source offset < 0: " + sourceOffset);
		} else if (numberToWrite < 0) {
			throw new IndexOutOfBoundsException("Length < 0: " + numberToWrite);
		} else if (sourceOffset + numberToWrite > size()) {
			throw new IndexOutOfBoundsException("Source end offset exceeded: " + (sourceOffset + numberToWrite));
		} else {
			if (numberToWrite > 0) {
				writeToInternal(out, sourceOffset, numberToWrite);
			}
		}
	}

	abstract void writeToInternal(OutputStream r1_OutputStream, int r2i, int r3i) throws IOException;
}
