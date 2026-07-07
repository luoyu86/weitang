package c.i.a.a;

import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2555i;
    public float j;
    public float k;
    public int l;
    public int m;
    public int o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2556q;
    public boolean r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2547a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2548b = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2549c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2550d = Integer.MIN_VALUE;
    public List<Integer> n = new ArrayList();

    public void a(View view, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f2547a = Math.min(this.f2547a, (view.getLeft() - flexItem.getMarginLeft()) - i2);
        this.f2548b = Math.min(this.f2548b, (view.getTop() - flexItem.getMarginTop()) - i3);
        this.f2549c = Math.max(this.f2549c, view.getRight() + flexItem.getMarginRight() + i4);
        this.f2550d = Math.max(this.f2550d, view.getBottom() + flexItem.getMarginBottom() + i5);
    }

    public int getCrossSize() {
        return this.f2553g;
    }

    public int getFirstIndex() {
        return this.o;
    }

    public int getItemCount() {
        return this.f2554h;
    }

    public int getItemCountNotGone() {
        return this.f2554h - this.f2555i;
    }

    public int getMainSize() {
        return this.f2551e;
    }

    public float getTotalFlexGrow() {
        return this.j;
    }

    public float getTotalFlexShrink() {
        return this.k;
    }
}
