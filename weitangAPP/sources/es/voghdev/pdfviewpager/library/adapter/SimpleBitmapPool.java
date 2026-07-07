package es.voghdev.pdfviewpager.library.adapter;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleBitmapPool implements BitmapContainer {
    public Bitmap[] bitmaps;
    private Bitmap.Config config;
    private int height;
    private int poolSize;
    private int width;

    public SimpleBitmapPool(PdfRendererParams pdfRendererParams) {
        this.poolSize = getPoolSize(pdfRendererParams.getOffScreenSize());
        this.width = pdfRendererParams.getWidth();
        this.height = pdfRendererParams.getHeight();
        this.config = pdfRendererParams.getConfig();
        this.bitmaps = new Bitmap[this.poolSize];
    }

    private int getPoolSize(int i2) {
        return (i2 * 2) + 1;
    }

    @Override // es.voghdev.pdfviewpager.library.adapter.BitmapContainer
    public void clear() {
        recycleAll();
    }

    public void createBitmapAtIndex(int i2) {
        this.bitmaps[i2] = Bitmap.createBitmap(this.width, this.height, this.config);
    }

    @Override // es.voghdev.pdfviewpager.library.adapter.BitmapContainer
    public Bitmap get(int i2) {
        return getBitmap(i2);
    }

    public Bitmap getBitmap(int i2) {
        int indexFromPosition = getIndexFromPosition(i2);
        if (this.bitmaps[indexFromPosition] == null) {
            createBitmapAtIndex(indexFromPosition);
        }
        this.bitmaps[indexFromPosition].eraseColor(0);
        return this.bitmaps[indexFromPosition];
    }

    public int getIndexFromPosition(int i2) {
        return i2 % this.poolSize;
    }

    public void recycleAll() {
        for (int i2 = 0; i2 < this.poolSize; i2++) {
            Bitmap[] bitmapArr = this.bitmaps;
            if (bitmapArr[i2] != null) {
                bitmapArr[i2].recycle();
                this.bitmaps[i2] = null;
            }
        }
    }

    @Override // es.voghdev.pdfviewpager.library.adapter.BitmapContainer
    public void remove(int i2) {
        this.bitmaps[i2].recycle();
        this.bitmaps[i2] = null;
    }
}
