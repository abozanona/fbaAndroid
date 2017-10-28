package com.androidplot.ui;

import com.androidplot.Series;
import java.util.LinkedList;
import java.util.List;

public class SeriesAndFormatterList {
    private LinkedList f532a = new LinkedList();
    private LinkedList f533b = new LinkedList();

    public boolean add(Series series, Object obj) {
        if (series == null || obj == null) {
            throw new IllegalArgumentException("series and formatter must not be null.");
        } else if (this.f532a.contains(series)) {
            return false;
        } else {
            this.f532a.add(series);
            this.f533b.add(obj);
            return true;
        }
    }

    public boolean contains(Series series) {
        return this.f532a.contains(series);
    }

    public Object getFormatter(int i) {
        return this.f533b.get(i);
    }

    public Object getFormatter(Series series) {
        return this.f533b.get(this.f532a.indexOf(series));
    }

    public List getFormatterList() {
        return this.f533b;
    }

    public Series getSeries(int i) {
        return (Series) this.f532a.get(i);
    }

    public List getSeriesList() {
        return this.f532a;
    }

    public boolean remove(Series series) {
        int indexOf = this.f532a.indexOf(series);
        if (indexOf < 0) {
            return false;
        }
        this.f532a.remove(indexOf);
        this.f533b.remove(indexOf);
        return true;
    }

    public Object setFormatter(Series series, Object obj) {
        return this.f533b.set(this.f532a.indexOf(series), obj);
    }

    public int size() {
        return this.f532a.size();
    }
}
