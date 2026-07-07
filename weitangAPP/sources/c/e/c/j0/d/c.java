package c.e.c.j0.d;

import android.content.Context;
import android.widget.ImageView;
import com.chinavisionary.microtang.sign.view.NineGridViewLayout;
import com.lzy.ninegrid.NineGridViewWrapper;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<c.k.b.a> f1627b;

    public c(Context context, List<c.k.b.a> list) {
        this.f1626a = context;
        this.f1627b = list;
    }

    public ImageView a(Context context) {
        NineGridViewWrapper nineGridViewWrapper = new NineGridViewWrapper(context);
        nineGridViewWrapper.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return nineGridViewWrapper;
    }

    public void b(Context context, NineGridViewLayout nineGridViewLayout, int i2, List<c.k.b.a> list) {
    }

    public List<c.k.b.a> getImageInfo() {
        return this.f1627b;
    }

    public void setImageInfoList(List<c.k.b.a> list) {
        this.f1627b = list;
    }
}
