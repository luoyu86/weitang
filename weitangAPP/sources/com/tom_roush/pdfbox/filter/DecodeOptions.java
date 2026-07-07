package com.tom_roush.pdfbox.filter;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
public class DecodeOptions {
    public static final DecodeOptions DEFAULT = new FinalDecodeOptions(true);
    private boolean filterSubsampled;
    private Rect sourceRegion;
    private int subsamplingOffsetX;
    private int subsamplingOffsetY;
    private int subsamplingX;
    private int subsamplingY;

    public static class FinalDecodeOptions extends DecodeOptions {
        public FinalDecodeOptions(boolean z) {
            super.setFilterSubsampled(z);
        }

        @Override // com.tom_roush.pdfbox.filter.DecodeOptions
        public void setFilterSubsampled(boolean z) {
        }

        @Override // com.tom_roush.pdfbox.filter.DecodeOptions
        public void setSourceRegion(Rect rect) {
            throw new UnsupportedOperationException("This instance may not be modified.");
        }

        @Override // com.tom_roush.pdfbox.filter.DecodeOptions
        public void setSubsamplingOffsetX(int i2) {
            throw new UnsupportedOperationException("This instance may not be modified.");
        }

        @Override // com.tom_roush.pdfbox.filter.DecodeOptions
        public void setSubsamplingOffsetY(int i2) {
            throw new UnsupportedOperationException("This instance may not be modified.");
        }

        @Override // com.tom_roush.pdfbox.filter.DecodeOptions
        public void setSubsamplingX(int i2) {
            throw new UnsupportedOperationException("This instance may not be modified.");
        }

        @Override // com.tom_roush.pdfbox.filter.DecodeOptions
        public void setSubsamplingY(int i2) {
            throw new UnsupportedOperationException("This instance may not be modified.");
        }
    }

    public DecodeOptions() {
        this.sourceRegion = null;
        this.subsamplingX = 1;
        this.subsamplingY = 1;
        this.subsamplingOffsetX = 0;
        this.subsamplingOffsetY = 0;
        this.filterSubsampled = false;
    }

    public Rect getSourceRegion() {
        return this.sourceRegion;
    }

    public int getSubsamplingOffsetX() {
        return this.subsamplingOffsetX;
    }

    public int getSubsamplingOffsetY() {
        return this.subsamplingOffsetY;
    }

    public int getSubsamplingX() {
        return this.subsamplingX;
    }

    public int getSubsamplingY() {
        return this.subsamplingY;
    }

    public boolean isFilterSubsampled() {
        return this.filterSubsampled;
    }

    public void setFilterSubsampled(boolean z) {
        this.filterSubsampled = z;
    }

    public void setSourceRegion(Rect rect) {
        this.sourceRegion = rect;
    }

    public void setSubsamplingOffsetX(int i2) {
        this.subsamplingOffsetX = i2;
    }

    public void setSubsamplingOffsetY(int i2) {
        this.subsamplingOffsetY = i2;
    }

    public void setSubsamplingX(int i2) {
        this.subsamplingX = i2;
    }

    public void setSubsamplingY(int i2) {
        this.subsamplingY = i2;
    }

    public DecodeOptions(Rect rect) {
        this.sourceRegion = null;
        this.subsamplingX = 1;
        this.subsamplingY = 1;
        this.subsamplingOffsetX = 0;
        this.subsamplingOffsetY = 0;
        this.filterSubsampled = false;
        this.sourceRegion = rect;
    }

    public DecodeOptions(int i2, int i3, int i4, int i5) {
        this(new Rect(i2, i3, i4, i5));
    }

    public DecodeOptions(int i2) {
        this.sourceRegion = null;
        this.subsamplingX = 1;
        this.subsamplingY = 1;
        this.subsamplingOffsetX = 0;
        this.subsamplingOffsetY = 0;
        this.filterSubsampled = false;
        this.subsamplingX = i2;
        this.subsamplingY = i2;
    }
}
