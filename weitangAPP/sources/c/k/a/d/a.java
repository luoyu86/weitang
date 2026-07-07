package c.k.a.d;

import android.app.Activity;
import android.widget.ImageView;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends Serializable {
    void clearImageViewCache(ImageView imageView);

    void clearMemoryCache();

    void displayImage(Activity activity, String str, ImageView imageView, int i2, int i3);

    void displayImagePreview(Activity activity, String str, ImageView imageView, int i2, int i3);
}
