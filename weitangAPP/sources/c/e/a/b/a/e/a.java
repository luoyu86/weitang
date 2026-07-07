package c.e.a.b.a.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.e.a.b.a.g.b;
import com.bumptech.glide.RequestManager;
import com.chinavisionary.core.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<b> f1071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RequestManager f1072b;

    /* JADX INFO: renamed from: c.e.a.b.a.e.a$a, reason: collision with other inner class name */
    public class C0019a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f1073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f1074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f1075c;

        public C0019a(View view) {
            this.f1073a = (ImageView) view.findViewById(R.id.iv_dir_cover);
            this.f1074b = (TextView) view.findViewById(R.id.tv_dir_name);
            this.f1075c = (TextView) view.findViewById(R.id.tv_dir_count);
        }

        public void bindData(b bVar) {
            a.this.f1072b.load(bVar.getCoverPath()).dontAnimate().thumbnail(0.1f).into(this.f1073a);
            this.f1074b.setText(bVar.getName());
            TextView textView = this.f1075c;
            textView.setText(textView.getContext().getString(R.string.__picker_image_count, Integer.valueOf(bVar.getPhotos().size())));
        }
    }

    public a(RequestManager requestManager, List<b> list) {
        this.f1071a = new ArrayList();
        this.f1071a = list;
        this.f1072b = requestManager;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1071a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return this.f1071a.get(i2).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C0019a c0019a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.__picker_item_directory, viewGroup, false);
            c0019a = new C0019a(view);
            view.setTag(c0019a);
        } else {
            c0019a = (C0019a) view.getTag();
        }
        c0019a.bindData(this.f1071a.get(i2));
        return view;
    }

    @Override // android.widget.Adapter
    public b getItem(int i2) {
        return this.f1071a.get(i2);
    }
}
