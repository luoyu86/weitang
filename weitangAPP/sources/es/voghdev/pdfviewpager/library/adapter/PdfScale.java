package es.voghdev.pdfviewpager.library.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class PdfScale {
    public static final float DEFAULT_SCALE = 1.0f;
    public float scale = 1.0f;
    public float centerX = 0.0f;
    public float centerY = 0.0f;

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterY() {
        return this.centerY;
    }

    public float getScale() {
        return this.scale;
    }

    public void setCenterX(float f2) {
        this.centerX = f2;
    }

    public void setCenterY(float f2) {
        this.centerY = f2;
    }

    public void setScale(float f2) {
        this.scale = f2;
    }
}
