package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DataLayer {
    static final int MAX_QUEUE_DEPTH = 500;
    public static final Object OBJECT_NOT_PRESENT = new Object();
    private final ConcurrentHashMap mListeners = new ConcurrentHashMap();
    private final Map mModel = new HashMap();
    private final ReentrantLock mPushLock = new ReentrantLock();
    private final LinkedList mUpdateQueue = new LinkedList();

    DataLayer() {
    }

    public static List listOf(Object... objArr) {
        List arrayList = new ArrayList();
        for (Object add : objArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map mapOf(Object... objArr) {
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map hashMap = new HashMap();
        for (int i = 0; i < objArr.length; i += 2) {
            hashMap.put(objArr[i], objArr[i + 1]);
        }
        return hashMap;
    }

    private void notifyListeners(Map map) {
        for (ae a : this.mListeners.keySet()) {
            a.mo631a(map);
        }
    }

    private void processQueuedUpdates() {
        int i = 0;
        while (true) {
            Map map = (Map) this.mUpdateQueue.poll();
            if (map != null) {
                processUpdate(map);
                int i2 = i + 1;
                if (i2 > MAX_QUEUE_DEPTH) {
                    this.mUpdateQueue.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    private void processUpdate(Map map) {
        synchronized (this.mModel) {
            for (Object next : map.keySet()) {
                mergeMap(expandKeyValue(next, map.get(next)), this.mModel);
            }
        }
        notifyListeners(map);
    }

    @VisibleForTesting
    Map expandKeyValue(Object obj, Object obj2) {
        Map hashMap = new HashMap();
        String[] split = obj.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj3 = hashMap2;
        }
        map.put(split[split.length - 1], obj2);
        return hashMap;
    }

    public Object get(String str) {
        synchronized (this.mModel) {
            Map map = this.mModel;
            String[] split = str.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    @VisibleForTesting
    void mergeList(List list, List list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                mergeList((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                mergeMap((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    @VisibleForTesting
    void mergeMap(Map map, Map map2) {
        for (Object next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof List) {
                if (!(map2.get(next) instanceof List)) {
                    map2.put(next, new ArrayList());
                }
                mergeList((List) obj, (List) map2.get(next));
            } else if (obj instanceof Map) {
                if (!(map2.get(next) instanceof Map)) {
                    map2.put(next, new HashMap());
                }
                mergeMap((Map) obj, (Map) map2.get(next));
            } else {
                map2.put(next, obj);
            }
        }
    }

    public void push(Object obj, Object obj2) {
        push(expandKeyValue(obj, obj2));
    }

    public void push(Map map) {
        this.mPushLock.lock();
        try {
            this.mUpdateQueue.offer(map);
            if (this.mPushLock.getHoldCount() == 1) {
                processQueuedUpdates();
            }
            this.mPushLock.unlock();
        } catch (Throwable th) {
            this.mPushLock.unlock();
        }
    }

    void registerListener(ae aeVar) {
        this.mListeners.put(aeVar, Integer.valueOf(0));
    }

    void unregisterListener(ae aeVar) {
        this.mListeners.remove(aeVar);
    }
}
