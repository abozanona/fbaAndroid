package com.androidplot.xy;

import android.graphics.Canvas;
import android.util.Pair;
import com.androidplot.Plot;
import com.androidplot.PlotListener;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleXYSeries implements PlotListener, XYSeries {
    private volatile LinkedList f624a;
    private volatile LinkedList f625b;
    private volatile String f626c;
    private ReentrantReadWriteLock f627d;

    public enum ArrayFormat {
        Y_VALS_ONLY,
        XY_VALS_INTERLEAVED
    }

    static {
        SimpleXYSeries.class.getName();
    }

    public SimpleXYSeries(String str) {
        this.f624a = new LinkedList();
        this.f625b = new LinkedList();
        this.f626c = null;
        this.f627d = new ReentrantReadWriteLock(true);
        this.f626c = str;
    }

    public SimpleXYSeries(List list, ArrayFormat arrayFormat, String str) {
        this(str);
        setModel(list, arrayFormat);
    }

    public SimpleXYSeries(List list, List list2, String str) {
        this(str);
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("Neither the xVals nor the yVals parameters may be null.");
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("xVals and yVals List parameters must be of the same size.");
        } else {
            this.f624a.addAll(list);
            this.f625b.addAll(list2);
        }
    }

    public void addFirst(Number number, Number number2) {
        this.f627d.writeLock().lock();
        try {
            if (this.f624a != null) {
                this.f624a.addFirst(number);
            }
            this.f625b.addFirst(number2);
        } finally {
            this.f627d.writeLock().unlock();
        }
    }

    public void addLast(Number number, Number number2) {
        this.f627d.writeLock().lock();
        try {
            if (this.f624a != null) {
                this.f624a.addLast(number);
            }
            this.f625b.addLast(number2);
        } finally {
            this.f627d.writeLock().unlock();
        }
    }

    public String getTitle() {
        return this.f626c;
    }

    public Number getX(int i) {
        return this.f624a != null ? (Number) this.f624a.get(i) : Integer.valueOf(i);
    }

    public Number getY(int i) {
        return (Number) this.f625b.get(i);
    }

    public void onAfterDraw(Plot plot, Canvas canvas) {
        this.f627d.readLock().unlock();
    }

    public void onBeforeDraw(Plot plot, Canvas canvas) {
        this.f627d.readLock().lock();
    }

    public Pair removeFirst() {
        this.f627d.writeLock().lock();
        Pair pair;
        try {
            if (size() <= 0) {
                throw new NoSuchElementException();
            }
            pair = new Pair(this.f624a != null ? (Number) this.f624a.removeFirst() : Integer.valueOf(0), this.f625b.removeFirst());
            return pair;
        } finally {
            pair = this.f627d.writeLock();
            pair.unlock();
        }
    }

    public Pair removeLast() {
        Pair pair;
        this.f627d.writeLock().lock();
        try {
            if (size() <= 0) {
                throw new NoSuchElementException();
            }
            pair = new Pair(this.f624a != null ? (Number) this.f624a.removeLast() : Integer.valueOf(this.f625b.size() - 1), this.f625b.removeLast());
            return pair;
        } finally {
            pair = this.f627d.writeLock();
            pair.unlock();
        }
    }

    public void setModel(List list, ArrayFormat arrayFormat) {
        int i = 0;
        this.f627d.writeLock().lock();
        try {
            this.f624a = null;
            this.f625b.clear();
            if (list == null || list.size() == 0) {
                this.f627d.writeLock().unlock();
                return;
            }
            switch (C0143e.f779a[arrayFormat.ordinal()]) {
                case 1:
                    for (Number add : list) {
                        this.f625b.add(add);
                    }
                    break;
                case 2:
                    if (this.f624a == null) {
                        this.f624a = new LinkedList();
                    }
                    if (list.size() % 2 == 0) {
                        int size = list.size() / 2;
                        int i2 = 0;
                        while (i2 < size) {
                            this.f624a.add(list.get(i));
                            this.f625b.add(list.get(i + 1));
                            i2++;
                            i += 2;
                        }
                        break;
                    }
                    throw new IndexOutOfBoundsException("Cannot auto-generate series from odd-sized xy List.");
                default:
                    throw new IllegalArgumentException("Unexpected enum value: " + arrayFormat);
            }
            this.f627d.writeLock().unlock();
        } catch (Throwable th) {
            this.f627d.writeLock().unlock();
        }
    }

    public void setTitle(String str) {
        this.f627d.writeLock().lock();
        try {
            this.f626c = str;
        } finally {
            this.f627d.writeLock().unlock();
        }
    }

    public void setX(Number number, int i) {
        this.f627d.writeLock().lock();
        try {
            this.f624a.set(i, number);
        } finally {
            this.f627d.writeLock().unlock();
        }
    }

    public void setXY(Number number, Number number2, int i) {
        this.f627d.writeLock().lock();
        try {
            this.f625b.set(i, number2);
            this.f624a.set(i, number);
        } finally {
            this.f627d.writeLock().unlock();
        }
    }

    public void setY(Number number, int i) {
        this.f627d.writeLock().lock();
        try {
            this.f625b.set(i, number);
        } finally {
            this.f627d.writeLock().unlock();
        }
    }

    public int size() {
        return this.f625b != null ? this.f625b.size() : 0;
    }

    public void useImplicitXVals() {
        this.f627d.writeLock().lock();
        try {
            this.f624a = null;
        } finally {
            this.f627d.writeLock().unlock();
        }
    }
}
