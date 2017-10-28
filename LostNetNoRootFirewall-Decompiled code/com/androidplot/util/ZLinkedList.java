package com.androidplot.util;

import java.util.LinkedList;
import java.util.List;

public class ZLinkedList extends LinkedList implements ZIndexable {
    private ListOrganizer f511a = new ListOrganizer(this);

    public void addToBottom(Object obj) {
        this.f511a.addToBottom(obj);
    }

    public void addToTop(Object obj) {
        this.f511a.addToTop(obj);
    }

    public List elements() {
        return this.f511a.elements();
    }

    public boolean moveAbove(Object obj, Object obj2) {
        return this.f511a.moveAbove(obj, obj2);
    }

    public boolean moveBeneath(Object obj, Object obj2) {
        return this.f511a.moveBeneath(obj, obj2);
    }

    public boolean moveDown(Object obj) {
        return this.f511a.moveDown(obj);
    }

    public boolean moveToBottom(Object obj) {
        return this.f511a.moveToBottom(obj);
    }

    public boolean moveToTop(Object obj) {
        return this.f511a.moveToTop(obj);
    }

    public boolean moveUp(Object obj) {
        return this.f511a.moveUp(obj);
    }
}
