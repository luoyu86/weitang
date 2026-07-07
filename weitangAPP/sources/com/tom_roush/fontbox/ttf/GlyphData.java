package com.tom_roush.fontbox.ttf;

import android.graphics.Path;
import com.tom_roush.fontbox.util.BoundingBox;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class GlyphData {
    private BoundingBox boundingBox = null;
    private GlyfDescript glyphDescription = null;
    private short numberOfContours;
    private short xMax;
    private short xMin;
    private short yMax;
    private short yMin;

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public GlyphDescription getDescription() {
        return this.glyphDescription;
    }

    public short getNumberOfContours() {
        return this.numberOfContours;
    }

    public Path getPath() {
        return new GlyphRenderer(this.glyphDescription).getPath();
    }

    public short getXMaximum() {
        return this.xMax;
    }

    public short getXMinimum() {
        return this.xMin;
    }

    public short getYMaximum() {
        return this.yMax;
    }

    public short getYMinimum() {
        return this.yMin;
    }

    public void initData(GlyphTable glyphTable, TTFDataStream tTFDataStream, int i2) throws IOException {
        this.numberOfContours = tTFDataStream.readSignedShort();
        this.xMin = tTFDataStream.readSignedShort();
        this.yMin = tTFDataStream.readSignedShort();
        this.xMax = tTFDataStream.readSignedShort();
        short signedShort = tTFDataStream.readSignedShort();
        this.yMax = signedShort;
        this.boundingBox = new BoundingBox(this.xMin, this.yMin, this.xMax, signedShort);
        short s = this.numberOfContours;
        if (s >= 0) {
            this.glyphDescription = new GlyfSimpleDescript(s, tTFDataStream, (short) (i2 - this.xMin));
        } else {
            this.glyphDescription = new GlyfCompositeDescript(tTFDataStream, glyphTable);
        }
    }

    public void initEmptyData() throws IOException {
        this.glyphDescription = new GlyfSimpleDescript();
        this.boundingBox = new BoundingBox();
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public void setNumberOfContours(short s) {
        this.numberOfContours = s;
    }
}
