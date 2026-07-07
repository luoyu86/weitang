package com.chinavisionary.microtang.base;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TabFragmentAdapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Fragment> f6854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f6855b;

    public TabFragmentAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.f6854a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<Fragment> list = this.f6854a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<Fragment> getFragments() {
        return this.f6854a;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        List<Fragment> list = this.f6854a;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int i2) {
        List<String> list = this.f6855b;
        return list == null ? super.getPageTitle(i2) : list.get(i2);
    }

    public void setTitleList(List<String> list) {
        this.f6855b = list;
    }
}
