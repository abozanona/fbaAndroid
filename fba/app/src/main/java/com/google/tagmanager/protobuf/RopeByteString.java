package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.ByteString.ByteIterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class RopeByteString extends ByteString {
	private static final int[] minLengthByDepth;
	private int hash;
	private final ByteString left;
	private final int leftLength;
	private final ByteString right;
	private final int totalLength;
	private final int treeDepth;

	private static class Balancer {
		private final Deque<ByteString> prefixesStack;

		private Balancer() {
			this.prefixesStack = new ArrayDeque(minLengthByDepth.length);
		}

		private ByteString balance(ByteString left, ByteString right) {
			doBalance(left);
			doBalance(right);
			ByteString partialString = (ByteString) this.prefixesStack.pop();
			while (!this.prefixesStack.isEmpty()) {
				partialString = new RopeByteString(partialString, null);
			}
			return partialString;
		}

		private void doBalance(ByteString root) {
			if (root.isBalanced()) {
				insert(root);
				return;
			} else if (root instanceof RopeByteString) {
				RopeByteString rbs = (RopeByteString) root;
				doBalance(rbs.left);
				doBalance(rbs.right);
				return;
			} else {
				throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + root.getClass());
			}
		}

		private int getDepthBinForLength(int length) {
			int depth = Arrays.binarySearch(minLengthByDepth, length);
			if (depth < 0) {
				return (-(depth + 1)) - 1;
			}
			return depth;
		}

		/* JADX WARNING: inconsistent code */
		/*
		private void insert(com.google.tagmanager.protobuf.ByteString r10_byteString) {
			r9_this = this;
			r8 = 0;
			r6 = r10_byteString.size();
			r2 = r9.getDepthBinForLength(r6);
			r6 = minLengthByDepth;
			r7 = r2_depthBin + 1;
			r0 = r6[r7];
			r6 = r9.prefixesStack;
			r6 = r6.isEmpty();
			if (r6 != 0) goto L_0x0027;
		L_0x0019:
			r6 = r9.prefixesStack;
			r6 = r6.peek();
			r6 = (com.google.tagmanager.protobuf.ByteString) r6;
			r6 = r6.size();
			if (r6 < r0_binEnd) goto L_0x002d;
		L_0x0027:
			r6 = r9.prefixesStack;
			r6.push(r10_byteString);
		L_0x002c:
			return;
		L_0x002d:
			r6 = minLengthByDepth;
			r1 = r6[r2_depthBin];
			r6 = r9.prefixesStack;
			r4 = r6.pop();
			r4 = (com.google.tagmanager.protobuf.ByteString) r4;
		L_0x003b:
			r6 = r9.prefixesStack;
			r6 = r6.isEmpty();
			if (r6 != 0) goto L_0x0060;
		L_0x0043:
			r6 = r9.prefixesStack;
			r6 = r6.peek();
			r6 = (com.google.tagmanager.protobuf.ByteString) r6;
			r6 = r6.size();
			if (r6 >= r1_binStart) goto L_0x0060;
		L_0x0051:
			r6 = r9.prefixesStack;
			r3 = r6.pop();
			r3 = (com.google.tagmanager.protobuf.ByteString) r3;
			r5 = new com.google.tagmanager.protobuf.RopeByteString;
			r5.<init>(r4_newTree, r8);
			r4_newTree = r5_newTree;
			goto L_0x003b;
		L_0x0060:
			r5_newTree = new com.google.tagmanager.protobuf.ByteString;
			r5_newTree.<init>(r10_byteString, r8);
			r4_newTree = r5_newTree;
		L_0x0066:
			r6 = r9.prefixesStack;
			r6 = r6.isEmpty();
			if (r6 != 0) goto L_0x009b;
		L_0x006e:
			r6 = r4_newTree.size();
			r2_depthBin = r9.getDepthBinForLength(r6);
			r6 = minLengthByDepth;
			r7 = r2_depthBin + 1;
			r0_binEnd = r6[r7];
			r6 = r9.prefixesStack;
			r6 = r6.peek();
			r6 = (com.google.tagmanager.protobuf.ByteString) r6;
			r6 = r6.size();
			if (r6 >= r0_binEnd) goto L_0x009b;
		L_0x008c:
			r6 = r9.prefixesStack;
			r3_left = r6.pop();
			r3_left = (com.google.tagmanager.protobuf.ByteString) r3_left;
			r5_newTree = new com.google.tagmanager.protobuf.ByteString;
			r5_newTree.<init>(r4_newTree, r8);
			r4_newTree = r5_newTree;
			goto L_0x0066;
		L_0x009b:
			r6 = r9.prefixesStack;
			r6.push(r4);
			goto L_0x002c;
		}
		*/
		private void insert(ByteString byteString) {
			int depthBin = getDepthBinForLength(byteString.size());
			int binEnd = minLengthByDepth[depthBin + 1];
			if (this.prefixesStack.isEmpty() || ((ByteString) this.prefixesStack.peek()).size() >= binEnd) {
				this.prefixesStack.push(byteString);
				return;
			} else {
				int binStart = minLengthByDepth[depthBin];
				ByteString newTree = (ByteString) this.prefixesStack.pop();
				while (!this.prefixesStack.isEmpty() && ((ByteString) this.prefixesStack.peek()).size() < binStart) {
					newTree = new RopeByteString(newTree, null);
				}
				newTree = new RopeByteString(byteString, null);
				while (!this.prefixesStack.isEmpty() && ((ByteString) this.prefixesStack.peek()).size() < binEnd) {
					newTree = new RopeByteString(newTree, null);
				}
				this.prefixesStack.push(newTree);
			}
		}
	}

	private static class PieceIterator implements Iterator<LiteralByteString> {
		private final Deque<RopeByteString> breadCrumbs;
		private LiteralByteString next;

		private PieceIterator(ByteString root) {
			this.breadCrumbs = new ArrayDeque(minLengthByDepth.length);
			this.next = getLeafByLeft(root);
		}

		private LiteralByteString getLeafByLeft(ByteString root) {
			ByteString pos = root;
			while (pos instanceof RopeByteString) {
				RopeByteString rbs = (RopeByteString) pos;
				this.breadCrumbs.push(rbs);
				pos = rbs.left;
			}
			return (LiteralByteString) pos;
		}

		/* JADX WARNING: inconsistent code */
		/*
		private com.google.tagmanager.protobuf.LiteralByteString getNextNonEmptyLeaf() {
			r2_this = this;
		L_0x0000:
			r1 = r2.breadCrumbs;
			r1 = r1.isEmpty();
			if (r1 == 0) goto L_0x000a;
		L_0x0008:
			r0 = 0;
		L_0x0009:
			return r0;
		L_0x000a:
			r1 = r2.breadCrumbs;
			r1 = r1.pop();
			r1 = (com.google.tagmanager.protobuf.RopeByteString) r1;
			r1 = r1.right;
			r0 = r2.getLeafByLeft(r1);
			r1 = r0_result.isEmpty();
			if (r1 != 0) goto L_0x0000;
		L_0x0020:
			goto L_0x0009;
		}
		*/
		private LiteralByteString getNextNonEmptyLeaf() {
			throw new UnsupportedOperationException("Method not decompiled: com.google.tagmanager.protobuf.RopeByteString.PieceIterator.getNextNonEmptyLeaf():com.google.tagmanager.protobuf.LiteralByteString");
			// jadx: method processing error
/*
			Error: java.lang.StackOverflowError: Deep code hierarchy
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:57)
	at jadx.core.dex.visitors.DepthTraverser.visit(DepthTraverser.java:29)
	at jadx.core.dex.visitors.DepthTraverser.visit(DepthTraverser.java:16)
	at jadx.core.dex.visitors.DepthTraverser.visit(DepthTraverser.java:13)
	at jadx.core.ProcessClass.run(ProcessClass.java:29)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at java.lang.Thread.run(Thread.java:744)
*/
			/*
			private com.google.tagmanager.protobuf.LiteralByteString getNextNonEmptyLeaf() {
				r2_this = this;
			L_0x0000:
				r1 = r2.breadCrumbs;
				r1 = r1.isEmpty();
				if (r1 == 0) goto L_0x000a;
			L_0x0008:
				r0 = 0;
			L_0x0009:
				return r0;
			L_0x000a:
				r1 = r2.breadCrumbs;
				r1 = r1.pop();
				r1 = (com.google.tagmanager.protobuf.RopeByteString) r1;
				r1 = r1.right;
				r0 = r2.getLeafByLeft(r1);
				r1 = r0_result.isEmpty();
				if (r1 != 0) goto L_0x0000;
			L_0x0020:
				goto L_0x0009;
			}
			*/
		}

		public boolean hasNext() {
			return this.next != null;
		}

		public LiteralByteString next() {
			if (this.next == null) {
				throw new NoSuchElementException();
			} else {
				LiteralByteString result = this.next;
				this.next = getNextNonEmptyLeaf();
				return result;
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class RopeByteIterator implements ByteIterator {
		private ByteIterator bytes;
		int bytesRemaining;
		private final RopeByteString.PieceIterator pieces;

		private RopeByteIterator() {
			this.pieces = new RopeByteString.PieceIterator(null);
			this.bytes = this.pieces.next().iterator();
			this.bytesRemaining = size();
		}

		public boolean hasNext() {
			return this.bytesRemaining > 0;
		}

		public Byte next() {
			return Byte.valueOf(nextByte());
		}

		public byte nextByte() {
			if (!this.bytes.hasNext()) {
				this.bytes = this.pieces.next().iterator();
			}
			this.bytesRemaining--;
			return this.bytes.nextByte();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class RopeInputStream extends InputStream {
		private LiteralByteString currentPiece;
		private int currentPieceIndex;
		private int currentPieceOffsetInRope;
		private int currentPieceSize;
		private int mark;
		private RopeByteString.PieceIterator pieceIterator;

		public RopeInputStream() {
			initialize();
		}

		private void advanceIfCurrentPieceFullyRead() {
			if (this.currentPiece == null || this.currentPieceIndex != this.currentPieceSize) {
			} else {
				this.currentPieceOffsetInRope += this.currentPieceSize;
				this.currentPieceIndex = 0;
				if (this.pieceIterator.hasNext()) {
					this.currentPiece = this.pieceIterator.next();
					this.currentPieceSize = this.currentPiece.size();
				} else {
					this.currentPiece = null;
					this.currentPieceSize = 0;
				}
			}
		}

		private void initialize() {
			this.pieceIterator = new RopeByteString.PieceIterator(null);
			this.currentPiece = this.pieceIterator.next();
			this.currentPieceSize = this.currentPiece.size();
			this.currentPieceIndex = 0;
			this.currentPieceOffsetInRope = 0;
		}

		private int readSkipInternal(byte[] b, int offset, int length) {
			int bytesRemaining = length;
			while (bytesRemaining > 0) {
				advanceIfCurrentPieceFullyRead();
				if (this.currentPiece == null) {
					if (bytesRemaining == length) {
						return -1;
					}
				} else {
					int count = Math.min(this.currentPieceSize - this.currentPieceIndex, bytesRemaining);
					if (b != null) {
						this.currentPiece.copyTo(b, this.currentPieceIndex, offset, count);
						offset += count;
					}
					this.currentPieceIndex += count;
					bytesRemaining -= count;
				}
			}
			return length - bytesRemaining;
		}

		public int available() throws IOException {
			return size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
		}

		public void mark(int readAheadLimit) {
			this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
		}

		public boolean markSupported() {
			return true;
		}

		public int read() throws IOException {
			advanceIfCurrentPieceFullyRead();
			if (this.currentPiece == null) {
				return -1;
			} else {
				LiteralByteString r0_LiteralByteString = this.currentPiece;
				int r1i = this.currentPieceIndex;
				this.currentPieceIndex = r1i + 1;
				return r0_LiteralByteString.byteAt(r1i) & 255;
			}
		}

		public int read(byte[] b, int offset, int length) {
			if (b == null) {
				throw new NullPointerException();
			} else if (offset < 0 || length < 0 || length > b.length - offset) {
				throw new IndexOutOfBoundsException();
			} else {
				return readSkipInternal(b, offset, length);
			}
		}

		public synchronized void reset() {
			synchronized(this) {
				initialize();
				readSkipInternal(null, 0, this.mark);
			}
		}

		public long skip(long length) {
			if (length < 0) {
				throw new IndexOutOfBoundsException();
			} else {
				if (length > 2147483647L) {
					length = 2147483647L;
				}
				return (long) readSkipInternal(null, 0, (int) length);
			}
		}
	}


	static {
		List<Integer> numbers = new ArrayList();
		int f1 = 1;
		int f2 = 1;
		while (f2 > 0) {
			numbers.add(Integer.valueOf(f2));
			f1 = f2;
			f2 = f1 + f2;
		}
		numbers.add(Integer.valueOf(2147483647));
		minLengthByDepth = new int[numbers.size()];
		int i = 0;
		while (i < minLengthByDepth.length) {
			minLengthByDepth[i] = ((Integer) numbers.get(i)).intValue();
			i++;
		}
	}

	private RopeByteString(ByteString left, ByteString right) {
		this.hash = 0;
		this.left = left;
		this.right = right;
		this.leftLength = left.size();
		this.totalLength = this.leftLength + right.size();
		this.treeDepth = Math.max(left.getTreeDepth(), right.getTreeDepth()) + 1;
	}

	/* JADX WARNING: inconsistent code */
	/*
	static com.google.tagmanager.protobuf.ByteString concatenate(com.google.tagmanager.protobuf.ByteString r9_left, com.google.tagmanager.protobuf.ByteString r10_right) {
		r6 = 0;
		r8 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
		r5 = r9_left instanceof com.google.tagmanager.protobuf.RopeByteString;
		if (r5 == 0) goto L_0x0013;
	L_0x0007:
		r5 = r9_left;
		r5 = (com.google.tagmanager.protobuf.RopeByteString) r5;
		r0 = r5;
	L_0x000b:
		r5 = r10_right.size();
		if (r5 != 0) goto L_0x0015;
	L_0x0011:
		r4 = r9_left;
	L_0x0012:
		return r4_result;
	L_0x0013:
		r0_leftRope = r6;
		goto L_0x000b;
	L_0x0015:
		r5 = r9_left.size();
		if (r5 != 0) goto L_0x001d;
	L_0x001b:
		r4_result = r10_right;
		goto L_0x0012;
	L_0x001d:
		r5 = r9_left.size();
		r7 = r10_right.size();
		r2 = r5 + r7;
		if (r2_newLength >= r8) goto L_0x002e;
	L_0x0029:
		r4_result = concatenateBytes(r9_left, r10_right);
		goto L_0x0012;
	L_0x002e:
		if (r0_leftRope == 0) goto L_0x004b;
	L_0x0030:
		r5 = r0_leftRope.right;
		r5 = r5.size();
		r7 = r10_right.size();
		r5 += r7;
		if (r5 >= r8) goto L_0x004b;
	L_0x003d:
		r5 = r0_leftRope.right;
		r3 = concatenateBytes(r5, r10_right);
		r4_result = new com.google.tagmanager.protobuf.ByteString;
		r5 = r0_leftRope.left;
		r4_result.<init>(r5, r3_newRight);
		goto L_0x0012;
	L_0x004b:
		if (r0_leftRope == 0) goto L_0x0074;
	L_0x004d:
		r5 = r0_leftRope.left;
		r5 = r5.getTreeDepth();
		r7 = r0_leftRope.right;
		r7 = r7.getTreeDepth();
		if (r5 <= r7) goto L_0x0074;
	L_0x005b:
		r5 = r0_leftRope.getTreeDepth();
		r7 = r10_right.getTreeDepth();
		if (r5 <= r7) goto L_0x0074;
	L_0x0065:
		r3_newRight = new com.google.tagmanager.protobuf.ByteString;
		r5 = r0_leftRope.right;
		r3_newRight.<init>(r5, r10_right);
		r4_result = new com.google.tagmanager.protobuf.ByteString;
		r5 = r0_leftRope.left;
		r4_result.<init>(r5, r3_newRight);
		goto L_0x0012;
	L_0x0074:
		r5 = r9_left.getTreeDepth();
		r7 = r10_right.getTreeDepth();
		r5 = java.lang.Math.max(r5, r7);
		r1 = r5 + 1;
		r5 = minLengthByDepth;
		r5 = r5[r1_newDepth];
		if (r2_newLength < r5) goto L_0x008e;
	L_0x0088:
		r4_result = new com.google.tagmanager.protobuf.ByteString;
		r4_result.<init>(r9_left, r10_right);
		goto L_0x0012;
	L_0x008e:
		r5 = new com.google.tagmanager.protobuf.RopeByteString$Balancer;
		r5.<init>();
		r4_result = r5.balance(r9_left, r10_right);
		goto L_0x0012;
	}
	*/
	static ByteString concatenate(ByteString left, ByteString right) {
		RopeByteString leftRope;
		leftRope = (left instanceof RopeByteString) ? (RopeByteString) left : null;
		if (right.size() == 0) {
			return left;
		} else if (left.size() == 0) {
			return right;
		} else {
			int newLength = left.size() + right.size();
			if (newLength < 128) {
				return concatenateBytes(left, right);
			} else if (leftRope == null || leftRope.right.size() + right.size() >= 128) {
				return (newLength >= minLengthByDepth[Math.max(left.getTreeDepth(), right.getTreeDepth()) + 1]) ? new RopeByteString(left, right) : new Balancer().balance(left, right);
			} else {
				return new RopeByteString(leftRope.left, concatenateBytes(leftRope.right, right));
			}
		}
	}

	private static LiteralByteString concatenateBytes(ByteString left, ByteString right) {
		int leftSize = left.size();
		int rightSize = right.size();
		byte[] bytes = new byte[(leftSize + rightSize)];
		left.copyTo(bytes, 0, 0, leftSize);
		right.copyTo(bytes, 0, leftSize, rightSize);
		return new LiteralByteString(bytes);
	}

	private boolean equalsFragments(ByteString other) {
		int thisOffset = 0;
		Iterator<LiteralByteString> thisIter = new PieceIterator(null);
		LiteralByteString thisString = (LiteralByteString) thisIter.next();
		int thatOffset = 0;
		Iterator<LiteralByteString> thatIter = new PieceIterator(null);
		LiteralByteString thatString = (LiteralByteString) thatIter.next();
		int pos = 0;
		while (true) {
			int thisRemaining = thisString.size() - thisOffset;
			int thatRemaining = thatString.size() - thatOffset;
			int bytesToCompare = Math.min(thisRemaining, thatRemaining);
			if (!(((thisOffset == 0) ? thisString.equalsRange(thatString, thatOffset, bytesToCompare) : thatString.equalsRange(thisString, thisOffset, bytesToCompare)))) {
				return false;
			} else {
				pos += bytesToCompare;
				if (pos >= this.totalLength) {
					if (pos == this.totalLength) {
						return true;
					} else {
						throw new IllegalStateException();
					}
				} else {
					if (bytesToCompare == thisRemaining) {
						thisOffset = 0;
						thisString = thisIter.next();
					} else {
						thisOffset += bytesToCompare;
					}
					if (bytesToCompare == thatRemaining) {
						thatOffset = 0;
						thatString = thatIter.next();
					} else {
						thatOffset += bytesToCompare;
					}
				}
			}
		}
	}

	static RopeByteString newInstanceForTest(ByteString left, ByteString right) {
		return new RopeByteString(left, right);
	}

	public ByteBuffer asReadOnlyByteBuffer() {
		return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
	}

	public List<ByteBuffer> asReadOnlyByteBufferList() {
		List<ByteBuffer> result = new ArrayList();
		PieceIterator pieces = new PieceIterator(null);
		while (pieces.hasNext()) {
			result.add(pieces.next().asReadOnlyByteBuffer());
		}
		return result;
	}

	public byte byteAt(int index) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException("Index < 0: " + index);
		} else if (index > this.totalLength) {
			throw new ArrayIndexOutOfBoundsException("Index > length: " + index + ", " + this.totalLength);
		} else if (index < this.leftLength) {
			return this.left.byteAt(index);
		} else {
			return this.right.byteAt(index - this.leftLength);
		}
	}

	public void copyTo(ByteBuffer target) {
		this.left.copyTo(target);
		this.right.copyTo(target);
	}

	protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
		if (sourceOffset + numberToCopy <= this.leftLength) {
			this.left.copyToInternal(target, sourceOffset, targetOffset, numberToCopy);
			return;
		} else if (sourceOffset >= this.leftLength) {
			this.right.copyToInternal(target, sourceOffset - this.leftLength, targetOffset, numberToCopy);
			return;
		} else {
			int leftLength = this.leftLength - sourceOffset;
			this.left.copyToInternal(target, sourceOffset, targetOffset, leftLength);
			this.right.copyToInternal(target, 0, targetOffset + leftLength, numberToCopy - leftLength);
		}
	}

	public boolean equals(Object other) {
		if (other == this) {
			return true;
		} else if (!((other instanceof ByteString))) {
			return false;
		} else {
			ByteString otherByteString = (ByteString) other;
			if (this.totalLength != otherByteString.size()) {
				return false;
			} else {
				if (this.totalLength != 0) {
					if (this.hash != 0) {
						int cachedOtherHash = otherByteString.peekCachedHashCode();
						if (cachedOtherHash == 0 || this.hash == cachedOtherHash) {
						} else {
							return false;
						}
					}
					return equalsFragments(otherByteString);
				}
				return true;
			}
		}
	}

	protected int getTreeDepth() {
		return this.treeDepth;
	}

	public int hashCode() {
		int h = this.hash;
		if (h == 0) {
			h = partialHash(this.totalLength, 0, this.totalLength);
			if (h == 0) {
				h = 1;
			}
			this.hash = h;
		}
		return h;
	}

	protected boolean isBalanced() {
		return this.totalLength >= minLengthByDepth[this.treeDepth];
	}

	public boolean isValidUtf8() {
		int leftPartial = this.left.partialIsValidUtf8(0, 0, this.leftLength);
		if (this.right.partialIsValidUtf8(leftPartial, 0, this.right.size()) == 0) {
			return true;
		}
		return false;
	}

	public ByteIterator iterator() {
		return new RopeByteIterator(null);
	}

	public CodedInputStream newCodedInput() {
		return CodedInputStream.newInstance(new RopeInputStream());
	}

	public InputStream newInput() {
		return new RopeInputStream();
	}

	protected int partialHash(int h, int offset, int length) {
		if (offset + length <= this.leftLength) {
			return this.left.partialHash(h, offset, length);
		} else if (offset >= this.leftLength) {
			return this.right.partialHash(h, offset - this.leftLength, length);
		} else {
			int leftLength = this.leftLength - offset;
			int leftPartial = this.left.partialHash(h, offset, leftLength);
			return this.right.partialHash(leftPartial, 0, length - leftLength);
		}
	}

	protected int partialIsValidUtf8(int state, int offset, int length) {
		if (offset + length <= this.leftLength) {
			return this.left.partialIsValidUtf8(state, offset, length);
		} else if (offset >= this.leftLength) {
			return this.right.partialIsValidUtf8(state, offset - this.leftLength, length);
		} else {
			int leftLength = this.leftLength - offset;
			int leftPartial = this.left.partialIsValidUtf8(state, offset, leftLength);
			return this.right.partialIsValidUtf8(leftPartial, 0, length - leftLength);
		}
	}

	protected int peekCachedHashCode() {
		return this.hash;
	}

	public int size() {
		return this.totalLength;
	}

	public ByteString substring(int beginIndex, int endIndex) {
		if (beginIndex < 0) {
			throw new IndexOutOfBoundsException("Beginning index: " + beginIndex + " < 0");
		} else if (endIndex > this.totalLength) {
			throw new IndexOutOfBoundsException("End index: " + endIndex + " > " + this.totalLength);
		} else {
			int substringLength = endIndex - beginIndex;
			if (substringLength < 0) {
				throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + beginIndex + ", " + endIndex);
			} else if (substringLength == 0) {
				return ByteString.EMPTY;
			} else if (substringLength == this.totalLength) {
				return this;
			} else if (endIndex <= this.leftLength) {
				return this.left.substring(beginIndex, endIndex);
			} else if (beginIndex >= this.leftLength) {
				return this.right.substring(beginIndex - this.leftLength, endIndex - this.leftLength);
			} else {
				return new RopeByteString(this.left.substring(beginIndex), this.right.substring(0, endIndex - this.leftLength));
			}
		}
	}

	public String toString(String charsetName) throws UnsupportedEncodingException {
		return new String(toByteArray(), charsetName);
	}

	public void writeTo(OutputStream outputStream) throws IOException {
		this.left.writeTo(outputStream);
		this.right.writeTo(outputStream);
	}

	void writeToInternal(OutputStream out, int sourceOffset, int numberToWrite) throws IOException {
		if (sourceOffset + numberToWrite <= this.leftLength) {
			this.left.writeToInternal(out, sourceOffset, numberToWrite);
			return;
		} else if (sourceOffset >= this.leftLength) {
			this.right.writeToInternal(out, sourceOffset - this.leftLength, numberToWrite);
			return;
		} else {
			int numberToWriteInLeft = this.leftLength - sourceOffset;
			this.left.writeToInternal(out, sourceOffset, numberToWriteInLeft);
			this.right.writeToInternal(out, 0, numberToWrite - numberToWriteInLeft);
		}
	}
}
