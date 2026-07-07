package com.tom_roush.fontbox.util;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BoundingBox {
    private float lowerLeftX;
    private float lowerLeftY;
    private float upperRightX;
    private float upperRightY;

    public BoundingBox() {
    }

    public boolean contains(float f2, float f3) {
        return f2 >= this.lowerLeftX && f2 <= this.upperRightX && f3 >= this.lowerLeftY && f3 <= this.upperRightY;
    }

    public float getHeight() {
        return getUpperRightY() - getLowerLeftY();
    }

    public float getLowerLeftX() {
        return this.lowerLeftX;
    }

    public float getLowerLeftY() {
        return this.lowerLeftY;
    }

    public float getUpperRightX() {
        return this.upperRightX;
    }

    public float getUpperRightY() {
        return this.upperRightY;
    }

    public float getWidth() {
        return getUpperRightX() - getLowerLeftX();
    }

    public void setLowerLeftX(float f2) {
        this.lowerLeftX = f2;
    }

    public void setLowerLeftY(float f2) {
        this.lowerLeftY = f2;
    }

    public void setUpperRightX(float f2) {
        this.upperRightX = f2;
    }

    public void setUpperRightY(float f2) {
        this.upperRightY = f2;
    }

    public String toString() {
        return "[" + getLowerLeftX() + "," + getLowerLeftY() + "," + getUpperRightX() + "," + getUpperRightY() + "]";
    }

    public BoundingBox(float f2, float f3, float f4, float f5) {
        this.lowerLeftX = f2;
        this.lowerLeftY = f3;
        this.upperRightX = f4;
        this.upperRightY = f5;
    }

    public BoundingBox(List<Number> list) {
        this.lowerLeftX = list.get(0).floatValue();
        this.lowerLeftY = list.get(1).floatValue();
        this.upperRightX = list.get(2).floatValue();
        this.upperRightY = list.get(3).floatValue();
    }
}
