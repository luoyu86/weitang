package c.e.a.d.c0;

import android.app.Activity;
import android.widget.ImageView;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class a implements c.k.a.d.a {
    public final boolean a(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    @Override // c.k.a.d.a
    public void clearImageViewCache(ImageView imageView) {
        try {
            d.getInstance().recyclerImageView(imageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.k.a.d.a
    public void clearMemoryCache() {
    }

    @Override // c.k.a.d.a
    public void displayImage(Activity activity, String str, ImageView imageView, int i2, int i3) {
        try {
            if (a(str)) {
                d.getInstance().display(Integer.parseInt(str), imageView, i2, i3);
            } else {
                d.getInstance().display(str, imageView, i2, i3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.k.a.d.a
    public void displayImagePreview(Activity activity, String str, ImageView imageView, int i2, int i3) {
        try {
            if (a(str)) {
                d.getInstance().display(Integer.parseInt(str), imageView, i2, i3);
            } else {
                d.getInstance().display(str, imageView, i2, i3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
