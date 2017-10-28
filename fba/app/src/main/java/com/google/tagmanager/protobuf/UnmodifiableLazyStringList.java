package com.google.tagmanager.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
	private final LazyStringList list;

	class AnonymousClass_1 implements ListIterator<String> {
		ListIterator<String> iter;
		final /* synthetic */ int val$index;

		AnonymousClass_1(int r4i) {
			this.val$index = r4i;
			this.iter = list.listIterator(this.val$index);
		}

		public void add(String o) {
			throw new UnsupportedOperationException();
		}

		public boolean hasNext() {
			return this.iter.hasNext();
		}

		public boolean hasPrevious() {
			return this.iter.hasPrevious();
		}

		public String next() {
			return (String) this.iter.next();
		}

		public int nextIndex() {
			return this.iter.nextIndex();
		}

		public String previous() {
			return (String) this.iter.previous();
		}

		public int previousIndex() {
			return this.iter.previousIndex();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public void set(String o) {
			throw new UnsupportedOperationException();
		}
	}


	public UnmodifiableLazyStringList(LazyStringList list) {
		this.list = list;
	}

	public void add(ByteString element) {
		throw new UnsupportedOperationException();
	}

	public void add(byte[] element) {
		throw new UnsupportedOperationException();
	}

	public boolean addAllByteArray(Collection<byte[]> element) {
		throw new UnsupportedOperationException();
	}

	public boolean addAllByteString(Collection<ByteString> element) {
		throw new UnsupportedOperationException();
	}

	public List<byte[]> asByteArrayList() {
		return Collections.unmodifiableList(this.list.asByteArrayList());
	}

	public String get(int index) {
		return (String) this.list.get(index);
	}

	public byte[] getByteArray(int index) {
		return this.list.getByteArray(index);
	}

	public ByteString getByteString(int index) {
		return this.list.getByteString(index);
	}

	public List<?> getUnderlyingElements() {
		return this.list.getUnderlyingElements();
	}

	public Iterator<String> iterator() {
		return new Iterator<String>() {
			Iterator<String> iter;

			{
				this.iter = list.iterator();
			}

			public boolean hasNext() {
				return this.iter.hasNext();
			}

			public String next() {
				return (String) this.iter.next();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public ListIterator<String> listIterator(int index) {
		return new AnonymousClass_1(index);
	}

	public void mergeFrom(LazyStringList other) {
		throw new UnsupportedOperationException();
	}

	public void set(int index, ByteString element) {
		throw new UnsupportedOperationException();
	}

	public void set(int index, byte[] element) {
		throw new UnsupportedOperationException();
	}

	public int size() {
		return this.list.size();
	}
}
