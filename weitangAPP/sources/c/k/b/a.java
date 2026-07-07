package c.k.b;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable {
    public String bigImageUrl;
    public int imageViewHeight;
    public int imageViewWidth;
    public int imageViewX;
    public int imageViewY;
    public String thumbnailUrl;

    public String getBigImageUrl() {
        return this.bigImageUrl;
    }

    public int getImageViewHeight() {
        return this.imageViewHeight;
    }

    public int getImageViewWidth() {
        return this.imageViewWidth;
    }

    public int getImageViewX() {
        return this.imageViewX;
    }

    public int getImageViewY() {
        return this.imageViewY;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setBigImageUrl(String str) {
        this.bigImageUrl = str;
    }

    public void setImageViewHeight(int i2) {
        this.imageViewHeight = i2;
    }

    public void setImageViewWidth(int i2) {
        this.imageViewWidth = i2;
    }

    public void setImageViewX(int i2) {
        this.imageViewX = i2;
    }

    public void setImageViewY(int i2) {
        this.imageViewY = i2;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public String toString() {
        return "ImageInfo{imageViewY=" + this.imageViewY + ", imageViewX=" + this.imageViewX + ", imageViewWidth=" + this.imageViewWidth + ", imageViewHeight=" + this.imageViewHeight + ", bigImageUrl='" + this.bigImageUrl + "', thumbnailUrl='" + this.thumbnailUrl + "'}";
    }
}
