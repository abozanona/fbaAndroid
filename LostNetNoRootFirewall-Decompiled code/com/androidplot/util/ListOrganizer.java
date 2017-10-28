package com.androidplot.util;

import java.util.List;

public class ListOrganizer implements ZIndexable {
    private List f577a;

    public ListOrganizer(List list) {
        this.f577a = list;
    }

    public void addToBottom(Object obj) {
        this.f577a.add(0, obj);
    }

    public void addToTop(Object obj) {
        this.f577a.add(this.f577a.size(), obj);
    }

    public List elements() {
        return this.f577a;
    }

    public boolean moveAbove(Object obj, Object obj2) {
        if (obj == obj2) {
            throw new IllegalArgumentException("Illegal argument to moveAbove(A, B); A cannot be equal to B.");
        }
        this.f577a.remove(obj);
        this.f577a.add(this.f577a.indexOf(obj2) + 1, obj);
        return true;
    }

    public boolean moveBeneath(Object obj, Object obj2) {
        if (obj == obj2) {
            throw new IllegalArgumentException("Illegal argument to moveBeaneath(A, B); A cannot be equal to B.");
        }
        this.f577a.remove(obj);
        this.f577a.add(this.f577a.indexOf(obj2), obj);
        return true;
    }

    public boolean moveDown(Object obj) {
        int indexOf = this.f577a.indexOf(obj);
        return indexOf == -1 ? false : indexOf <= 0 ? true : moveBeneath(obj, this.f577a.get(indexOf - 1));
    }

    public boolean moveToBottom(Object obj) {
        this.f577a.remove(obj);
        this.f577a.add(0, obj);
        return true;
    }

    public boolean moveToTop(Object obj) {
        if (!this.f577a.remove(obj)) {
            return false;
        }
        this.f577a.add(this.f577a.size(), obj);
        return true;
    }

    public boolean moveUp(Object obj) {
        int indexOf = this.f577a.indexOf(obj);
        return indexOf == -1 ? false : indexOf >= this.f577a.size() + -1 ? true : moveAbove(obj, this.f577a.get(indexOf + 1));
    }
}
