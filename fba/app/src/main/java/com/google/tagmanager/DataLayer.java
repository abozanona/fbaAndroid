package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DataLayer {
	static final int MAX_QUEUE_DEPTH = 500;
	public static final Object OBJECT_NOT_PRESENT;
	private final ConcurrentHashMap<Listener, Integer> mListeners;
	private final Map<Object, Object> mModel;
	private final ReentrantLock mPushLock;
	private final LinkedList<Map<Object, Object>> mUpdateQueue;

	static interface Listener {
		public void changed(Map<Object, Object> r1_Map_ObjectObject);
	}


	static {
		OBJECT_NOT_PRESENT = new Object();
	}

	DataLayer() {
		this.mListeners = new ConcurrentHashMap();
		this.mModel = new HashMap();
		this.mPushLock = new ReentrantLock();
		this.mUpdateQueue = new LinkedList();
	}

	public static List<Object> listOf(Object ... objects) {
		List<Object> list = new ArrayList();
		int i = 0;
		while (i < objects.length) {
			list.add(objects[i]);
			i++;
		}
		return list;
	}

	public static Map<Object, Object> mapOf(Object ... objects) {
		if (objects.length % 2 != 0) {
			throw new IllegalArgumentException("expected even number of key-value pairs");
		} else {
			Map<Object, Object> map = new HashMap();
			int i = 0;
			while (i < objects.length) {
				map.put(objects[i], objects[i + 1]);
				i += 2;
			}
			return map;
		}
	}

	private void notifyListeners(Map<Object, Object> update) {
		Iterator i$ = this.mListeners.keySet().iterator();
		while (i$.hasNext()) {
			((Listener) i$.next()).changed(update);
		}
	}

	private void processQueuedUpdates() {
		int numUpdatesProcessed = 0;
		do {
			Map<Object, Object> update = (Map) this.mUpdateQueue.poll();
			if (update != null) {
				processUpdate(update);
				numUpdatesProcessed++;
			}
			return;
		} while (numUpdatesProcessed <= 500);
		this.mUpdateQueue.clear();
		throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
	}

	private void processUpdate(Map<Object, Object> update) {
		Map r3_Map = this.mModel;
		synchronized(r3_Map) {
			Iterator i$ = update.keySet().iterator();
			while (i$.hasNext()) {
				Object key = i$.next();
				mergeMap(expandKeyValue(key, update.get(key)), this.mModel);
			}
		}
		notifyListeners(update);
	}

	@VisibleForTesting
	Map<Object, Object> expandKeyValue(Object key, Object value) {
		Map<Object, Object> result = new HashMap();
		Object target = result;
		String[] split = key.toString().split("\\.");
		int i = 0;
		while (i < split.length - 1) {
			HashMap<Object, Object> map = new HashMap();
			target.put(split[i], map);
			target = map;
			i++;
		}
		target.put(split[split.length - 1], value);
		return result;
	}

	public Object get(String key) {
		Map target;
		Map r10_Map = this.mModel;
		synchronized(r10_Map) {
			target = this.mModel;
			String[] arr$ = key.split("\\.");
			int len$ = arr$.length;
			int i$ = 0;
			while (i$ < len$) {
				String s = arr$[i$];
				if (!((target instanceof Map))) {
					target = null;
				} else {
					Map value = target.get(s);
					if (value == null) {
						target = null;
					} else {
						target = value;
						i$++;
					}
				}
			}
		}
		return target;
	}

	@VisibleForTesting
	void mergeList(List<Object> from, List<Object> to) {
		while (to.size() < from.size()) {
			to.add(null);
		}
		int index = 0;
		while (index < from.size()) {
			Object fromValue = from.get(index);
			if (fromValue instanceof List) {
				if (!((to.get(index) instanceof List))) {
					to.set(index, new ArrayList());
				}
				mergeList((List) fromValue, (List) to.get(index));
			} else if (fromValue instanceof Map) {
				if (!((to.get(index) instanceof Map))) {
					to.set(index, new HashMap());
				}
				mergeMap((Map) fromValue, (Map) to.get(index));
			} else if (fromValue != OBJECT_NOT_PRESENT) {
				to.set(index, fromValue);
			}
			index++;
		}
	}

	@VisibleForTesting
	void mergeMap(Map<Object, Object> from, Map<Object, Object> to) {
		Iterator i$ = from.keySet().iterator();
		while (i$.hasNext()) {
			Object key = i$.next();
			Object fromValue = from.get(key);
			if (fromValue instanceof List) {
				if (!((to.get(key) instanceof List))) {
					to.put(key, new ArrayList());
				}
				mergeList((List) fromValue, (List) to.get(key));
			} else if (fromValue instanceof Map) {
				if (!((to.get(key) instanceof Map))) {
					to.put(key, new HashMap());
				}
				mergeMap((Map) fromValue, (Map) to.get(key));
			} else {
				to.put(key, fromValue);
			}
		}
	}

	public void push(Object key, Object value) {
		push(expandKeyValue(key, value));
	}

	public void push(Map<Object, Object> update) {
		this.mPushLock.lock();
		this.mUpdateQueue.offer(update);
		if (this.mPushLock.getHoldCount() == 1) {
			processQueuedUpdates();
		}
		this.mPushLock.unlock();
	}

	void registerListener(Listener listener) {
		this.mListeners.put(listener, Integer.valueOf(0));
	}

	void unregisterListener(Listener listener) {
		this.mListeners.remove(listener);
	}
}
