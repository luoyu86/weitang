package com.tom_roush.pdfbox.util;

/* JADX INFO: loaded from: classes2.dex */
public final class Vector {
    private final float x;
    private final float y;

    public Vector(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public Vector scale(float f2) {
        return new Vector(this.x * f2, this.y * f2);
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
