package com.androidplot.pie;

import com.androidplot.Series;

public class Segment implements Series {
    private String f488a;
    private Number f489b;

    public Segment(String str, Number number) {
        this.f488a = str;
        setValue(number);
    }

    public String getTitle() {
        return this.f488a;
    }

    public Number getValue() {
        return this.f489b;
    }

    public void setTitle(String str) {
        this.f488a = str;
    }

    public void setValue(Number number) {
        this.f489b = number;
    }
}
