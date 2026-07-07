package com.tom_roush.fontbox.ttf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class GlyfCompositeComp {
    public static final short ARGS_ARE_XY_VALUES = 2;
    public static final short ARG_1_AND_2_ARE_WORDS = 1;
    public static final short MORE_COMPONENTS = 32;
    public static final short ROUND_XY_TO_GRID = 4;
    public static final short USE_MY_METRICS = 512;
    public static final short WE_HAVE_AN_X_AND_Y_SCALE = 64;
    public static final short WE_HAVE_A_SCALE = 8;
    public static final short WE_HAVE_A_TWO_BY_TWO = 128;
    public static final short WE_HAVE_INSTRUCTIONS = 256;
    private final short argument1;
    private final short argument2;
    private int firstContour;
    private int firstIndex;
    private final short flags;
    private final int glyphIndex;
    private int point1;
    private int point2;
    private double scale01;
    private double scale10;
    private double xscale;
    private int xtranslate;
    private double yscale;
    private int ytranslate;

    public GlyfCompositeComp(TTFDataStream tTFDataStream) throws IOException {
        this.xscale = 1.0d;
        this.yscale = 1.0d;
        this.scale01 = 0.0d;
        this.scale10 = 0.0d;
        this.xtranslate = 0;
        this.ytranslate = 0;
        this.point1 = 0;
        this.point2 = 0;
        short signedShort = tTFDataStream.readSignedShort();
        this.flags = signedShort;
        this.glyphIndex = tTFDataStream.readUnsignedShort();
        if ((signedShort & 1) != 0) {
            this.argument1 = tTFDataStream.readSignedShort();
            this.argument2 = tTFDataStream.readSignedShort();
        } else {
            this.argument1 = (short) tTFDataStream.readSignedByte();
            this.argument2 = (short) tTFDataStream.readSignedByte();
        }
        if ((signedShort & 2) != 0) {
            this.xtranslate = this.argument1;
            this.ytranslate = this.argument2;
        } else {
            this.point1 = this.argument1;
            this.point2 = this.argument2;
        }
        if ((signedShort & 8) != 0) {
            double signedShort2 = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
            this.yscale = signedShort2;
            this.xscale = signedShort2;
        } else if ((signedShort & 64) != 0) {
            this.xscale = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
            this.yscale = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
        } else if ((signedShort & WE_HAVE_A_TWO_BY_TWO) != 0) {
            this.xscale = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
            this.scale01 = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
            this.scale10 = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
            this.yscale = ((double) tTFDataStream.readSignedShort()) / 16384.0d;
        }
    }

    public short getArgument1() {
        return this.argument1;
    }

    public short getArgument2() {
        return this.argument2;
    }

    public int getFirstContour() {
        return this.firstContour;
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public short getFlags() {
        return this.flags;
    }

    public int getGlyphIndex() {
        return this.glyphIndex;
    }

    public double getScale01() {
        return this.scale01;
    }

    public double getScale10() {
        return this.scale10;
    }

    public double getXScale() {
        return this.xscale;
    }

    public int getXTranslate() {
        return this.xtranslate;
    }

    public double getYScale() {
        return this.yscale;
    }

    public int getYTranslate() {
        return this.ytranslate;
    }

    public int scaleX(int i2, int i3) {
        return Math.round((float) ((((double) i2) * this.xscale) + (((double) i3) * this.scale10)));
    }

    public int scaleY(int i2, int i3) {
        return Math.round((float) ((((double) i2) * this.scale01) + (((double) i3) * this.yscale)));
    }

    public void setFirstContour(int i2) {
        this.firstContour = i2;
    }

    public void setFirstIndex(int i2) {
        this.firstIndex = i2;
    }
}
