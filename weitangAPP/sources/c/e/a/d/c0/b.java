package c.e.a.d.c0;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import c.e.a.d.x;
import com.lzy.ninegrid.NineGridView;

/* JADX INFO: loaded from: classes.dex */
public class b implements NineGridView.b {
    @Override // com.lzy.ninegrid.NineGridView.b
    public Bitmap getCacheImage(String str) {
        return null;
    }

    @Override // com.lzy.ninegrid.NineGridView.b
    public void onDisplayImage(Context context, ImageView imageView, String str) {
        if (!x.isNumeric(str)) {
            d.getInstance().display(str, imageView);
        } else {
            d.getInstance().display(Integer.parseInt(str), imageView);
        }
    }
}
