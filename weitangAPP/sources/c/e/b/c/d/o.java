package c.e.b.c.d;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class o extends c {
    public static final String IMAGE_TYPE = "image";
    public static final String TEXT_TYPE = "text";
    public static final String VIDEO_TYPE = "video";
    public static final String WEBPAGE_TYPE = "webpage";
    private Bitmap bitmap;
    private f data;
    private String sence;
    private String type;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public f getData() {
        return this.data;
    }

    public String getSence() {
        return this.sence;
    }

    public String getType() {
        return this.type;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setData(f fVar) {
        this.data = fVar;
    }

    public void setSence(String str) {
        this.sence = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
