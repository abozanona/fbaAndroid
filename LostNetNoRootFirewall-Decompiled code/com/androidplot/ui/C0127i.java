package com.androidplot.ui;

abstract class C0127i {
    private Enum f525a;
    private float f526b;

    public C0127i(float f, Enum enumR) {
        mo191a(f, enumR);
        set(f, enumR);
    }

    protected abstract void mo191a(float f, Enum enumR);

    public Enum getLayoutType() {
        return this.f525a;
    }

    public abstract float getPixelValue(float f);

    public float getValue() {
        return this.f526b;
    }

    public void set(float f, Enum enumR) {
        mo191a(f, enumR);
        this.f526b = f;
        this.f525a = enumR;
    }

    public void setLayoutType(Enum enumR) {
        mo191a(this.f526b, enumR);
        this.f525a = enumR;
    }

    public void setValue(float f) {
        mo191a(f, this.f525a);
        this.f526b = f;
    }
}
