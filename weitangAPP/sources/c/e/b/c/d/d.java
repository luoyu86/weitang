package c.e.b.c.d;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d extends c {
    public static final String SOURCE_TYPE_CAMERA = "camera";
    public static final String SOURCE_TYPE_PHOTO = "photo";
    private int count;
    private String mediaType;
    private ArrayList<String> sourceType;

    public int getCount() {
        return this.count;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public ArrayList<String> getSourceType() {
        return this.sourceType;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public void setMediaType(String str) {
        this.mediaType = str;
    }

    public void setSourceType(ArrayList<String> arrayList) {
        this.sourceType = arrayList;
    }
}
