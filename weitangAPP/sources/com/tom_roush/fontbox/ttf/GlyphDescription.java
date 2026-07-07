package com.tom_roush.fontbox.ttf;

/* JADX INFO: loaded from: classes2.dex */
public interface GlyphDescription {
    int getContourCount();

    int getEndPtOfContours(int i2);

    byte getFlags(int i2);

    int getPointCount();

    short getXCoordinate(int i2);

    short getYCoordinate(int i2);

    boolean isComposite();

    void resolve();
}
