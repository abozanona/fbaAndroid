package com.androidplot.util;

import java.util.HashMap;
import java.util.List;

public class ZHash implements ZIndexable {
    private HashMap f596a = new HashMap();
    private ZLinkedList f597b = new ZLinkedList();

    public synchronized void addToBottom(Object obj, Object obj2) {
        if (this.f596a.containsKey(obj)) {
            this.f596a.put(obj, obj2);
        } else {
            this.f596a.put(obj, obj2);
            this.f597b.addToBottom(obj);
        }
    }

    public synchronized void addToTop(Object obj, Object obj2) {
        if (this.f596a.containsKey(obj)) {
            this.f596a.put(obj, obj2);
        } else {
            this.f596a.put(obj, obj2);
            this.f597b.addToTop(obj);
        }
    }

    public List elements() {
        return this.f597b;
    }

    public Object get(Object obj) {
        return this.f596a.get(obj);
    }

    public List getKeysAsList() {
        return this.f597b;
    }

    public List keys() {
        return elements();
    }

    public synchronized boolean moveAbove(Object obj, Object obj2) {
        boolean moveAbove;
        if (obj == obj2) {
            throw new IllegalArgumentException("Illegal argument to moveAbove(A, B); A cannot be equal to B.");
        }
        moveAbove = (this.f596a.containsKey(obj2) && this.f596a.containsKey(obj)) ? this.f597b.moveAbove(obj, obj2) : false;
        return moveAbove;
    }

    public synchronized boolean moveBeneath(Object obj, Object obj2) {
        boolean moveBeneath;
        if (obj == obj2) {
            throw new IllegalArgumentException("Illegal argument to moveBeaneath(A, B); A cannot be equal to B.");
        }
        moveBeneath = (this.f596a.containsKey(obj2) && this.f596a.containsKey(obj)) ? this.f597b.moveBeneath(obj, obj2) : false;
        return moveBeneath;
    }

    public synchronized boolean moveDown(Object obj) {
        return !this.f596a.containsKey(obj) ? false : this.f597b.moveDown(obj);
    }

    public synchronized boolean moveToBottom(Object obj) {
        return !this.f596a.containsKey(obj) ? false : this.f597b.moveToBottom(obj);
    }

    public synchronized boolean moveToTop(Object obj) {
        return !this.f596a.containsKey(obj) ? false : this.f597b.moveToTop(obj);
    }

    public synchronized boolean moveUp(Object obj) {
        return !this.f596a.containsKey(obj) ? false : this.f597b.moveUp(obj);
    }

    public synchronized boolean remove(Object obj) {
        boolean z;
        if (this.f596a.containsKey(obj)) {
            this.f596a.remove(obj);
            this.f597b.remove(obj);
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public int size() {
        return this.f597b.size();
    }
}
