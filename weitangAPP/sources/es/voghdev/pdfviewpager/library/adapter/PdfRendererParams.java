package es.voghdev.pdfviewpager.library.adapter;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public class PdfRendererParams {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    public Bitmap.Config config = DEFAULT_CONFIG;
    public int height;
    public int offScreenSize;
    public float renderQuality;
    public int width;

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getOffScreenSize() {
        return this.offScreenSize;
    }

    public float getRenderQuality() {
        return this.renderQuality;
    }

    public int getWidth() {
        return this.width;
    }

    public void setConfig(Bitmap.Config config) {
        this.config = config;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setOffScreenSize(int i2) {
        this.offScreenSize = i2;
    }

    public void setRenderQuality(float f2) {
        this.renderQuality = f2;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }
}
