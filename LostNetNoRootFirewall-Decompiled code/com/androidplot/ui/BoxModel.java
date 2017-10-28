package com.androidplot.ui;

import android.graphics.RectF;

public class BoxModel implements BoxModelable {
    private float f498a;
    private float f499b;
    private float f500c;
    private float f501d;
    private float f502e;
    private float f503f;
    private float f504g;
    private float f505h;

    public BoxModel(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f498a = f;
        this.f499b = f2;
        this.f500c = f3;
        this.f501d = f4;
        this.f502e = f5;
        this.f503f = f6;
        this.f504g = f7;
        this.f505h = f8;
    }

    public float getMarginBottom() {
        return this.f501d;
    }

    public float getMarginLeft() {
        return this.f498a;
    }

    public float getMarginRight() {
        return this.f500c;
    }

    public float getMarginTop() {
        return this.f499b;
    }

    public RectF getMarginatedRect(RectF rectF) {
        return new RectF(rectF.left + getMarginLeft(), rectF.top + getMarginTop(), rectF.right - getMarginRight(), rectF.bottom - getMarginBottom());
    }

    public RectF getPaddedRect(RectF rectF) {
        return new RectF(rectF.left + getPaddingLeft(), rectF.top + getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
    }

    public float getPaddingBottom() {
        return this.f505h;
    }

    public float getPaddingLeft() {
        return this.f502e;
    }

    public float getPaddingRight() {
        return this.f504g;
    }

    public float getPaddingTop() {
        return this.f503f;
    }

    public void setMarginBottom(float f) {
        this.f501d = f;
    }

    public void setMarginLeft(float f) {
        this.f498a = f;
    }

    public void setMarginRight(float f) {
        this.f500c = f;
    }

    public void setMarginTop(float f) {
        this.f499b = f;
    }

    public void setMargins(float f, float f2, float f3, float f4) {
        setMarginLeft(f);
        setMarginTop(f2);
        setMarginRight(f3);
        setMarginBottom(f4);
    }

    public void setPadding(float f, float f2, float f3, float f4) {
        setPaddingLeft(f);
        setPaddingTop(f2);
        setPaddingRight(f3);
        setPaddingBottom(f4);
    }

    public void setPaddingBottom(float f) {
        this.f505h = f;
    }

    public void setPaddingLeft(float f) {
        this.f502e = f;
    }

    public void setPaddingRight(float f) {
        this.f504g = f;
    }

    public void setPaddingTop(float f) {
        this.f503f = f;
    }
}
