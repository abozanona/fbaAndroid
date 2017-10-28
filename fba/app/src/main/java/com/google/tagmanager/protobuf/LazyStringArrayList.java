package com.google.tagmanager.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractList<String> implements LazyStringList, RandomAccess {
	public static final LazyStringList EMPTY;
	private final List<Object> list;

	private static class ByteArrayListView extends AbstractList<byte[]> {
		private final List<Object> list;

		ByteArrayListView(List<Object> list) {
			this.list = list;
		}

		public void add(int index, byte[] s) {
			this.list.add(index, s);
			this.modCount++;
		}

		public byte[] get(int index) {
			Object o = this.list.get(index);
			Object b = LazyStringArrayList.asByteArray(o);
			if (b != o) {
				this.list.set(index, b);
			}
			return b;
		}

		public byte[] remove(int index) {
			Object o = this.list.remove(index);
			this.modCount++;
			return LazyStringArrayList.asByteArray(o);
		}

		public byte[] set(int index, byte[] s) {
			return LazyStringArrayList.asByteArray(this.list.set(index, s));
		}

		public int size() {
			return this.list.size();
		}
	}


	static {
		EMPTY = new UnmodifiableLazyStringList(new LazyStringArrayList());
	}

	public LazyStringArrayList() {
		this.list = new ArrayList();
	}

	public LazyStringArrayList(LazyStringList from) {
		this.list = new ArrayList(from.size());
		addAll(from);
	}

	public LazyStringArrayList(List<String> from) {
		this.list = new ArrayList(from);
	}

	private static byte[] asByteArray(Object o) {
		if (o instanceof byte[]) {
			return (byte[]) ((byte[]) o);
		} else if (o instanceof String) {
			return Internal.toByteArray((String) o);
		} else {
			return ((ByteString) o).toByteArray();
		}
	}

	private static ByteString asByteString(Object o) {
		if (o instanceof ByteString) {
			return (ByteString) o;
		} else if (o instanceof String) {
			return ByteString.copyFromUtf8((String) o);
		} else {
			return ByteString.copyFrom((byte[]) ((byte[]) o));
		}
	}

	private static String asString(Object o) {
		if (o instanceof String) {
			return (String) o;
		} else if (o instanceof ByteString) {
			return ((ByteString) o).toStringUtf8();
		} else {
			return Internal.toStringUtf8((byte[]) ((byte[]) o));
		}
	}

	public void add(int index, String element) {
		this.list.add(index, element);
		this.modCount++;
	}

	public void add(ByteString element) {
		this.list.add(element);
		this.modCount++;
	}

	public void add(byte[] element) {
		this.list.add(element);
		this.modCount++;
	}

	public boolean addAll(int index, Collection<String> c) {
		boolean ret = this.list.addAll(index, (c instanceof LazyStringList) ? ((LazyStringList) c).getUnderlyingElements() : c);
		this.modCount++;
		return ret;
	}

	public boolean addAll(Collection<String> c) {
		return addAll(size(), c);
	}

	public boolean addAllByteArray(Collection<byte[]> c) {
		boolean ret = this.list.addAll(c);
		this.modCount++;
		return ret;
	}

	public boolean addAllByteString(Collection<ByteString> values) {
		boolean ret = this.list.addAll(values);
		this.modCount++;
		return ret;
	}

	public List<byte[]> asByteArrayList() {
		return new ByteArrayListView(this.list);
	}

	public void clear() {
		this.list.clear();
		this.modCount++;
	}

	public String get(int index) {
		Object o = this.list.get(index);
		if (o instanceof String) {
			return (String) o;
		} else if (o instanceof ByteString) {
			ByteString bs = (ByteString) o;
			s = bs.toStringUtf8();
			if (bs.isValidUtf8()) {
				this.list.set(index, s);
				return s;
			}
			return s;
		} else {
			byte[] ba = (byte[]) ((byte[]) o);
			s = Internal.toStringUtf8(ba);
			if (Internal.isValidUtf8(ba)) {
				this.list.set(index, s);
				return s;
			}
			return s;
		}
	}

	public byte[] getByteArray(int index) {
		Object o = this.list.get(index);
		Object b = asByteArray(o);
		if (b != o) {
			this.list.set(index, b);
		}
		return b;
	}

	public ByteString getByteString(int index) {
		ByteString o = this.list.get(index);
		ByteString b = asByteString(o);
		if (b != o) {
			this.list.set(index, b);
		}
		return b;
	}

	public List<?> getUnderlyingElements() {
		return Collections.unmodifiableList(this.list);
	}

	public void mergeFrom(LazyStringList other) {
		Iterator i$ = other.getUnderlyingElements().iterator();
		while (i$.hasNext()) {
			Object o = i$.next();
			if (o instanceof byte[]) {
				byte[] b = (byte[]) ((byte[]) o);
				this.list.add(Arrays.copyOf(b, b.length));
			} else {
				this.list.add(o);
			}
		}
	}

	public String remove(int index) {
		Object o = this.list.remove(index);
		this.modCount++;
		return asString(o);
	}

	public String set(int index, String s) {
		return asString(this.list.set(index, s));
	}

	public void set(int index, ByteString s) {
		this.list.set(index, s);
	}

	public void set(int index, byte[] s) {
		this.list.set(index, s);
	}

	public int size() {
		return this.list.size();
	}
}
