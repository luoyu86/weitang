package com.tom_roush.fontbox.ttf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalHeaderTable extends TTFTable {
    public static final String TAG = "hhea";
    private int advanceWidthMax;
    private short ascender;
    private short caretSlopeRise;
    private short caretSlopeRun;
    private short descender;
    private short lineGap;
    private short metricDataFormat;
    private short minLeftSideBearing;
    private short minRightSideBearing;
    private int numberOfHMetrics;
    private short reserved1;
    private short reserved2;
    private short reserved3;
    private short reserved4;
    private short reserved5;
    private float version;
    private short xMaxExtent;

    public HorizontalHeaderTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
    }

    public int getAdvanceWidthMax() {
        return this.advanceWidthMax;
    }

    public short getAscender() {
        return this.ascender;
    }

    public short getCaretSlopeRise() {
        return this.caretSlopeRise;
    }

    public short getCaretSlopeRun() {
        return this.caretSlopeRun;
    }

    public short getDescender() {
        return this.descender;
    }

    public short getLineGap() {
        return this.lineGap;
    }

    public short getMetricDataFormat() {
        return this.metricDataFormat;
    }

    public short getMinLeftSideBearing() {
        return this.minLeftSideBearing;
    }

    public short getMinRightSideBearing() {
        return this.minRightSideBearing;
    }

    public int getNumberOfHMetrics() {
        return this.numberOfHMetrics;
    }

    public short getReserved1() {
        return this.reserved1;
    }

    public short getReserved2() {
        return this.reserved2;
    }

    public short getReserved3() {
        return this.reserved3;
    }

    public short getReserved4() {
        return this.reserved4;
    }

    public short getReserved5() {
        return this.reserved5;
    }

    public float getVersion() {
        return this.version;
    }

    public short getXMaxExtent() {
        return this.xMaxExtent;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.version = tTFDataStream.read32Fixed();
        this.ascender = tTFDataStream.readSignedShort();
        this.descender = tTFDataStream.readSignedShort();
        this.lineGap = tTFDataStream.readSignedShort();
        this.advanceWidthMax = tTFDataStream.readUnsignedShort();
        this.minLeftSideBearing = tTFDataStream.readSignedShort();
        this.minRightSideBearing = tTFDataStream.readSignedShort();
        this.xMaxExtent = tTFDataStream.readSignedShort();
        this.caretSlopeRise = tTFDataStream.readSignedShort();
        this.caretSlopeRun = tTFDataStream.readSignedShort();
        this.reserved1 = tTFDataStream.readSignedShort();
        this.reserved2 = tTFDataStream.readSignedShort();
        this.reserved3 = tTFDataStream.readSignedShort();
        this.reserved4 = tTFDataStream.readSignedShort();
        this.reserved5 = tTFDataStream.readSignedShort();
        this.metricDataFormat = tTFDataStream.readSignedShort();
        this.numberOfHMetrics = tTFDataStream.readUnsignedShort();
        this.initialized = true;
    }

    public void setAdvanceWidthMax(int i2) {
        this.advanceWidthMax = i2;
    }

    public void setAscender(short s) {
        this.ascender = s;
    }

    public void setCaretSlopeRise(short s) {
        this.caretSlopeRise = s;
    }

    public void setCaretSlopeRun(short s) {
        this.caretSlopeRun = s;
    }

    public void setDescender(short s) {
        this.descender = s;
    }

    public void setLineGap(short s) {
        this.lineGap = s;
    }

    public void setMetricDataFormat(short s) {
        this.metricDataFormat = s;
    }

    public void setMinLeftSideBearing(short s) {
        this.minLeftSideBearing = s;
    }

    public void setMinRightSideBearing(short s) {
        this.minRightSideBearing = s;
    }

    public void setNumberOfHMetrics(int i2) {
        this.numberOfHMetrics = i2;
    }

    public void setReserved1(short s) {
        this.reserved1 = s;
    }

    public void setReserved2(short s) {
        this.reserved2 = s;
    }

    public void setReserved3(short s) {
        this.reserved3 = s;
    }

    public void setReserved4(short s) {
        this.reserved4 = s;
    }

    public void setReserved5(short s) {
        this.reserved5 = s;
    }

    public void setVersion(float f2) {
        this.version = f2;
    }

    public void setXMaxExtent(short s) {
        this.xMaxExtent = s;
    }
}
