package c.e.c.v.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.chinavisionary.microtang.R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<View> f1981a;

    public final int a(int i2, int i3) {
        return i2 == 0 ? R.mipmap.ic_tab_select_left : i2 == i3 + (-1) ? R.mipmap.ic_tab_select_right : R.mipmap.ic_tab_select_middle;
    }

    public final void b(View view, @StringRes int i2, @DrawableRes int i3, @ColorRes int i4, boolean z) {
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        if (z) {
            ((ImageView) view.findViewById(R.id.img_tab_icon)).setImageResource(i3);
        }
        textView.setText(i2);
        textView.setTextColor(textView.getResources().getColor(i4));
    }

    public final void c(View view, String str, @DrawableRes int i2, @ColorRes int i3) {
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        ((ImageView) view.findViewById(R.id.img_tab_icon)).setImageResource(i2);
        textView.getLayoutParams().width = -1;
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextColor(textView.getResources().getColor(i3));
    }

    public void setupCommentListTab(TabLayout tabLayout) {
        this.f1981a = new ArrayList();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(tabLayout.getContext());
        View viewInflate = layoutInflaterFrom.inflate(R.layout.tab_item_community_activity_layout, (ViewGroup) tabLayout, false);
        b(viewInflate, R.string.title_wait_comment_tab, R.drawable.bg_main_tab, R.color.color_B4B8BE, true);
        this.f1981a.add(viewInflate);
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.tab_item_community_activity_layout, (ViewGroup) tabLayout, false);
        b(viewInflate2, R.string.title_comment_over_tab, R.drawable.bg_main_tab, R.color.color_B4B8BE, true);
        this.f1981a.add(viewInflate2);
        tabLayout.newTab();
        tabLayout.newTab();
        TabLayout.Tab tabAt = tabLayout.getTabAt(0);
        if (tabAt != null) {
            tabAt.setCustomView(viewInflate);
        }
        TabLayout.Tab tabAt2 = tabLayout.getTabAt(1);
        if (tabAt2 != null) {
            tabAt2.setCustomView(viewInflate2);
        }
        updateSelectActivityRecordTabToPosition(0, true);
    }

    public void setupCommunityActivityListTab(TabLayout tabLayout) {
        this.f1981a = new ArrayList();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(tabLayout.getContext());
        View viewInflate = layoutInflaterFrom.inflate(R.layout.tab_item_community_activity_layout, (ViewGroup) tabLayout, false);
        b(viewInflate, R.string.title_wt_activity_join, R.drawable.bg_main_tab, R.color.color_B4B8BE, true);
        this.f1981a.add(viewInflate);
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.tab_item_community_activity_layout, (ViewGroup) tabLayout, false);
        b(viewInflate2, R.string.title_wt_activitying, R.drawable.bg_main_tab, R.color.color_B4B8BE, true);
        this.f1981a.add(viewInflate2);
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.tab_item_community_activity_layout, (ViewGroup) tabLayout, false);
        b(viewInflate3, R.string.title_wt_activity_over, R.drawable.bg_main_tab, R.color.color_B4B8BE, true);
        this.f1981a.add(viewInflate3);
        tabLayout.newTab();
        tabLayout.newTab();
        tabLayout.newTab();
        TabLayout.Tab tabAt = tabLayout.getTabAt(0);
        if (tabAt != null) {
            tabAt.setCustomView(viewInflate);
        }
        TabLayout.Tab tabAt2 = tabLayout.getTabAt(1);
        if (tabAt2 != null) {
            tabAt2.setCustomView(viewInflate2);
        }
        TabLayout.Tab tabAt3 = tabLayout.getTabAt(2);
        if (tabAt3 != null) {
            tabAt3.setCustomView(viewInflate3);
        }
        updateSelectActivityRecordTabToPosition(0, true);
    }

    public void setupCommunityActivityTab(TabLayout tabLayout, List<String> list) {
        this.f1981a = new ArrayList();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(tabLayout.getContext());
        View viewInflate = layoutInflaterFrom.inflate(R.layout.tab_item_community_activity_new_layout, (ViewGroup) tabLayout, false);
        b(viewInflate, R.string.title_all_activity, R.drawable.bg_main_tab, R.color.color262626, true);
        this.f1981a.add(viewInflate);
        tabLayout.newTab();
        TabLayout.Tab tabAt = tabLayout.getTabAt(0);
        if (tabAt != null) {
            tabAt.setCustomView(viewInflate);
        }
        if (c.e.a.d.o.isNotEmpty(list)) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                View viewInflate2 = layoutInflaterFrom.inflate(R.layout.tab_item_community_activity_new_layout, (ViewGroup) tabLayout, false);
                c(viewInflate2, list.get(i2), R.drawable.bg_main_tab, R.color.color262626);
                this.f1981a.add(viewInflate2);
                tabLayout.newTab();
                i2++;
                TabLayout.Tab tabAt2 = tabLayout.getTabAt(i2);
                if (tabAt2 != null) {
                    tabAt2.setCustomView(viewInflate2);
                }
            }
        }
        updateSelectActivityTabToPosition(0, true);
    }

    public void setupTab(TabLayout tabLayout) {
        this.f1981a = new ArrayList();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(tabLayout.getContext());
        View viewInflate = layoutInflaterFrom.inflate(R.layout.tab_item_room_main_layout, (ViewGroup) tabLayout, false);
        b(viewInflate, R.string.title_wt_preferred, R.drawable.bg_main_tab, R.color.color262626, false);
        this.f1981a.add(viewInflate);
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.tab_item_room_main_layout, (ViewGroup) tabLayout, false);
        b(viewInflate2, R.string.title_wt_clear, R.drawable.bg_main_tab, R.color.color262626, false);
        this.f1981a.add(viewInflate2);
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.tab_item_room_main_right_layout, (ViewGroup) tabLayout, false);
        b(viewInflate3, R.string.title_wt_tab_food, R.drawable.bg_main_tab, R.color.color262626, false);
        this.f1981a.add(viewInflate3);
        tabLayout.newTab();
        tabLayout.newTab();
        tabLayout.newTab();
        TabLayout.Tab tabAt = tabLayout.getTabAt(0);
        if (tabAt != null) {
            tabAt.setCustomView(viewInflate);
        }
        TabLayout.Tab tabAt2 = tabLayout.getTabAt(1);
        if (tabAt2 != null) {
            tabAt2.setCustomView(viewInflate2);
        }
        TabLayout.Tab tabAt3 = tabLayout.getTabAt(2);
        if (tabAt3 != null) {
            tabAt3.setCustomView(viewInflate3);
        }
        updateSelectTabToPosition(0);
    }

    public void updateSelectActivityRecordTabToPosition(int i2, boolean z) {
        int size = this.f1981a.size();
        int i3 = 0;
        while (i3 < size) {
            View view = this.f1981a.get(i3);
            TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
            boolean z2 = i3 == i2;
            if (z) {
                textView.setTextColor(z2 ? textView.getResources().getColor(R.color.colorFE9900) : textView.getResources().getColor(R.color.color_B4B8BE));
            }
            int i4 = size - 1;
            ((ImageView) view.findViewById(R.id.img_tab_icon)).setVisibility(z2 ? 0 : 8);
            i3++;
        }
    }

    public void updateSelectActivityTabToPosition(int i2, boolean z) {
        int size = this.f1981a.size();
        int i3 = 0;
        while (i3 < size) {
            View view = this.f1981a.get(i3);
            TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
            boolean z2 = i3 == i2;
            if (z) {
                textView.setTextColor(z2 ? textView.getResources().getColor(R.color.colorFE9900) : textView.getResources().getColor(R.color.color_333333));
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.img_tab_icon);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_tab_bg);
            int i4 = 8;
            imageView.setVisibility(z2 ? 0 : 8);
            imageView2.setBackgroundResource(a(i2, size));
            if (z2) {
                i4 = 0;
            }
            imageView2.setVisibility(i4);
            i3++;
        }
    }

    public void updateSelectTabToPosition(int i2) {
        updateSelectTabToPosition(i2, false);
    }

    public void updateSelectTabToPosition(int i2, boolean z) {
        int size = this.f1981a.size();
        int i3 = 0;
        while (i3 < size) {
            View view = this.f1981a.get(i3);
            TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
            boolean z2 = i3 == i2;
            if (z) {
                textView.setTextColor(z2 ? textView.getResources().getColor(R.color.colorFE9900) : textView.getResources().getColor(R.color.color_333333));
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.img_tab_icon);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_tab_bg);
            int i4 = size - 1;
            int i5 = 8;
            imageView.setVisibility(z2 ? 0 : 8);
            imageView2.setBackgroundResource(a(i2, size));
            if (z2) {
                i5 = 0;
            }
            imageView2.setVisibility(i5);
            i3++;
        }
    }
}
