package c.k.b;

import android.content.Context;
import android.widget.ImageView;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.NineGridViewWrapper;
import com.lzy.ninegrid.R;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<a> f2826b;

    public b(Context context, List<a> list) {
        this.f2825a = context;
        this.f2826b = list;
    }

    public ImageView a(Context context) {
        NineGridViewWrapper nineGridViewWrapper = new NineGridViewWrapper(context);
        nineGridViewWrapper.setScaleType(ImageView.ScaleType.CENTER_CROP);
        nineGridViewWrapper.setImageResource(R.drawable.ic_default_color);
        return nineGridViewWrapper;
    }

    public void b(Context context, NineGridView nineGridView, int i2, List<a> list) {
    }

    public List<a> getImageInfo() {
        return this.f2826b;
    }

    public void setImageInfoList(List<a> list) {
        this.f2826b = list;
    }
}
