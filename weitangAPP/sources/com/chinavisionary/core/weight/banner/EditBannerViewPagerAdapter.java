package com.chinavisionary.core.weight.banner;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.chinavisionary.core.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EditBannerViewPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6767a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<View> f6768b = new ArrayList();

    public final void a() {
        int size = this.f6768b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f6768b.get(i2).setTag(R.id.edt_banner_view_img_path_position, Integer.valueOf(i2));
        }
    }

    public void addView(View view) {
        if (this.f6768b == null) {
            this.f6768b = new ArrayList();
        }
        if (this.f6768b.isEmpty()) {
            this.f6768b.add(view);
        } else {
            this.f6768b.add(0, view);
        }
        notifyDataSetChanged();
    }

    public void clearList() {
        List<View> list = this.f6768b;
        if (list != null) {
            list.clear();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f6768b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int i2 = this.f6767a;
        if (i2 <= 0) {
            return super.getItemPosition(obj);
        }
        this.f6767a = i2 - 1;
        return -2;
    }

    public List getList() {
        return this.f6768b;
    }

    public List<String> getPicList() {
        ArrayList arrayList = new ArrayList();
        Iterator<View> it = this.f6768b.iterator();
        while (it.hasNext()) {
            Object tag = it.next().getTag(R.id.edt_banner_view_img_path_id);
            if (tag != null) {
                arrayList.add((String) tag);
            }
        }
        return arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        if (this.f6768b.isEmpty()) {
            return null;
        }
        View view = this.f6768b.get(i2);
        if (view.getParent() == null) {
            viewGroup.addView(view);
        }
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.f6767a = getCount();
        super.notifyDataSetChanged();
        a();
    }

    public void recyclerReference() {
        this.f6768b.clear();
        this.f6768b = null;
    }

    public void setViews(List list) {
        if (list == null) {
            list = new ArrayList();
        }
        this.f6768b = list;
        notifyDataSetChanged();
    }
}
