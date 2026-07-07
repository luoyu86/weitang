package c.k.a.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.k.a.e.d;
import com.lzy.imagepicker.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.k.a.a f2781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f2782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f2783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<c.k.a.c.a> f2785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2786f = 0;

    /* JADX INFO: renamed from: c.k.a.b.a$a, reason: collision with other inner class name */
    public class C0040a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f2787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f2788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f2789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f2790d;

        public C0040a(View view) {
            this.f2787a = (ImageView) view.findViewById(R.id.iv_cover);
            this.f2788b = (TextView) view.findViewById(R.id.tv_folder_name);
            this.f2789c = (TextView) view.findViewById(R.id.tv_image_count);
            this.f2790d = (ImageView) view.findViewById(R.id.iv_folder_check);
            view.setTag(this);
        }
    }

    public a(Activity activity, List<c.k.a.c.a> list) {
        this.f2782b = activity;
        if (list == null || list.size() <= 0) {
            this.f2785e = new ArrayList();
        } else {
            this.f2785e = list;
        }
        this.f2781a = c.k.a.a.getInstance();
        this.f2784d = d.getImageItemWidth(this.f2782b);
        this.f2783c = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2785e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    public int getSelectIndex() {
        return this.f2786f;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C0040a c0040a;
        if (view == null) {
            view = this.f2783c.inflate(R.layout.adapter_folder_list_item, viewGroup, false);
            c0040a = new C0040a(view);
        } else {
            c0040a = (C0040a) view.getTag();
        }
        c.k.a.c.a item = getItem(i2);
        c0040a.f2788b.setText(item.name);
        c0040a.f2789c.setText(this.f2782b.getString(R.string.ip_folder_image_count, new Object[]{Integer.valueOf(item.images.size())}));
        try {
            c.k.a.d.a imageLoader = this.f2781a.getImageLoader();
            Activity activity = this.f2782b;
            String str = item.cover.path;
            ImageView imageView = c0040a.f2787a;
            int i3 = this.f2784d;
            imageLoader.displayImage(activity, str, imageView, i3, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f2786f == i2) {
            c0040a.f2790d.setVisibility(0);
        } else {
            c0040a.f2790d.setVisibility(4);
        }
        return view;
    }

    public void refreshData(List<c.k.a.c.a> list) {
        if (list == null || list.size() <= 0) {
            this.f2785e.clear();
        } else {
            this.f2785e = list;
        }
        notifyDataSetChanged();
    }

    public void setSelectIndex(int i2) {
        if (this.f2786f == i2) {
            return;
        }
        this.f2786f = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public c.k.a.c.a getItem(int i2) {
        return this.f2785e.get(i2);
    }
}
