package c.e.c.u.k;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import c.e.a.d.o;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.login.bo.SpinnerVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements SpinnerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<SpinnerVo> f1861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1866f = -1;

    public a(Context context) {
        this.f1862b = context.getResources().getColor(R.color.color_white);
        this.f1865e = context.getResources().getColor(R.color.color686868);
        this.f1863c = context.getResources().getColor(R.color.color000000);
        this.f1864d = context.getResources().getColor(R.color.color_white);
    }

    public final View a(int i2, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_drop_down_view, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_value);
        List<SpinnerVo> list = this.f1861a;
        if (list != null) {
            textView.setText(list.get(i2).getValue());
        }
        return viewInflate;
    }

    public final View b(int i2, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_drop_down_view, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_value);
        List<SpinnerVo> list = this.f1861a;
        if (list != null) {
            textView.setText(list.get(i2).getValue());
        }
        return viewInflate;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (o.isNotEmpty(this.f1861a)) {
            return this.f1861a.size();
        }
        return 0;
    }

    @Override // android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        return a(i2, viewGroup);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (o.isNotEmpty(this.f1861a)) {
            return this.f1861a.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i2) {
        return 1;
    }

    public List<SpinnerVo> getList() {
        return this.f1861a;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        return b(i2, viewGroup);
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return false;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public void setCacheSelectPosition(int i2) {
        int i3 = this.f1866f;
        if (i3 != -1) {
            this.f1861a.get(i3).setSelect(false);
        }
        this.f1866f = i2;
        this.f1861a.get(i2).setSelect(true);
    }

    public void setupDataList(List<SpinnerVo> list) {
        this.f1861a = list;
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
