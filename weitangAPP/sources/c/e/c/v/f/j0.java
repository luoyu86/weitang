package c.e.c.v.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.community.fragment.CommunityActivityTabFragment;
import com.chinavisionary.microtang.life.LifeTabFragment;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.main.fragments.EmptyFragment;
import com.chinavisionary.microtang.main.fragments.RoomMainFragment;
import com.chinavisionary.microtang.me.fragment.MeFragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<View> f1977a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f1978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f1979c;

    public List<Fragment> a() {
        ArrayList arrayList = new ArrayList();
        if (c.e.a.a.a.getInstance().isNewVersionModel()) {
            arrayList.add(RoomMainFragment.getInstance(1));
            arrayList.add(LifeTabFragment.getInstance());
        } else {
            arrayList.add(RoomMainFragment.getInstance(1));
        }
        arrayList.add(EmptyFragment.getInstance());
        if (c.e.a.a.a.getInstance().isNewVersionModel()) {
            arrayList.add(CommunityActivityTabFragment.getInstance());
        }
        arrayList.add(MeFragment.getInstance());
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(int r5, boolean r6) {
        /*
            r4 = this;
            if (r5 != 0) goto Lc
            if (r6 == 0) goto L8
            r0 = 2131493117(0x7f0c00fd, float:1.8609705E38)
            goto Ld
        L8:
            r0 = 2131493116(0x7f0c00fc, float:1.8609703E38)
            goto Ld
        Lc:
            r0 = 0
        Ld:
            c.e.a.a.a r1 = c.e.a.a.a.getInstance()
            boolean r1 = r1.isNewVersionModel()
            r2 = 2131493120(0x7f0c0100, float:1.8609711E38)
            r3 = 2131493118(0x7f0c00fe, float:1.8609707E38)
            if (r1 == 0) goto L42
            r1 = 1
            if (r5 != r1) goto L29
            if (r6 == 0) goto L26
            r0 = 2131493178(0x7f0c013a, float:1.8609829E38)
            goto L29
        L26:
            r0 = 2131493177(0x7f0c0139, float:1.8609827E38)
        L29:
            r1 = 3
            if (r5 != r1) goto L35
            if (r6 == 0) goto L32
            r0 = 2131493112(0x7f0c00f8, float:1.8609695E38)
            goto L35
        L32:
            r0 = 2131493111(0x7f0c00f7, float:1.8609693E38)
        L35:
            r1 = 4
            if (r5 != r1) goto L48
            if (r6 == 0) goto L3e
        L3a:
            r0 = 2131493120(0x7f0c0100, float:1.8609711E38)
            goto L48
        L3e:
            r0 = 2131493118(0x7f0c00fe, float:1.8609707E38)
            goto L48
        L42:
            r1 = 2
            if (r5 != r1) goto L48
            if (r6 == 0) goto L3e
            goto L3a
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.v.f.j0.b(int, boolean):int");
    }

    public final void c(View view, @StringRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        ((ImageView) view.findViewById(R.id.img_tab_icon)).setImageResource(i3);
        textView.setText(i2);
        textView.setTextColor(textView.getResources().getColor(i4));
    }

    public void d(TabLayout tabLayout) {
        View view;
        this.f1977a = new ArrayList();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(tabLayout.getContext());
        View view2 = null;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.tab_item_layout, (ViewGroup) null);
        this.f1977a.add(viewInflate);
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.tab_item_layout, (ViewGroup) null);
        this.f1978b = (TextView) viewInflate2.findViewById(R.id.tv_badge_value);
        this.f1979c = (TextView) viewInflate2.findViewById(R.id.tv_badge_paint);
        c(viewInflate, R.string.title_room_src, R.mipmap.ic_tab_main_sel, R.color.color_title);
        if (c.e.a.a.a.getInstance().isNewVersionModel()) {
            View viewInflate3 = layoutInflaterFrom.inflate(R.layout.tab_item_layout, (ViewGroup) null);
            View viewInflate4 = layoutInflaterFrom.inflate(R.layout.tab_item_layout, (ViewGroup) null);
            c(viewInflate3, R.string.title_life, R.mipmap.tab_icon_food_normal, R.color.color_title);
            c(viewInflate4, R.string.title_community, R.mipmap.ic_tab_community_normal, R.color.color_title);
            this.f1977a.add(viewInflate3);
            this.f1977a.add(viewInflate4);
            this.f1977a.add(viewInflate4);
            tabLayout.newTab();
            tabLayout.newTab();
            view = viewInflate4;
            view2 = viewInflate3;
        } else {
            this.f1977a.add(viewInflate2);
            view = null;
        }
        c(viewInflate2, R.string.title_me, R.mipmap.ic_tab_me, R.color.color_title);
        this.f1977a.add(viewInflate2);
        tabLayout.newTab();
        tabLayout.newTab();
        tabLayout.newTab();
        TabLayout.Tab tabAt = tabLayout.getTabAt(0);
        if (tabAt != null) {
            tabAt.setCustomView(viewInflate);
        }
        if (!c.e.a.a.a.getInstance().isNewVersionModel()) {
            TabLayout.Tab tabAt2 = tabLayout.getTabAt(2);
            if (tabAt2 != null) {
                tabAt2.setCustomView(viewInflate2);
                return;
            }
            return;
        }
        TabLayout.Tab tabAt3 = tabLayout.getTabAt(1);
        if (tabAt3 != null) {
            tabAt3.setCustomView(view2);
        }
        TabLayout.Tab tabAt4 = tabLayout.getTabAt(3);
        if (tabAt4 != null) {
            tabAt4.setCustomView(view);
        }
        TabLayout.Tab tabAt5 = tabLayout.getTabAt(4);
        if (tabAt5 != null) {
            tabAt5.setCustomView(viewInflate2);
        }
    }

    public void e(EventBadgeMsgVo eventBadgeMsgVo) {
        c.e.c.m0.e.setupBadge(eventBadgeMsgVo, this.f1978b, this.f1979c);
    }

    public void f(int i2) {
        int size = this.f1977a.size();
        int i3 = 0;
        while (i3 < size) {
            View view = this.f1977a.get(i3);
            TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
            boolean z = i3 == i2;
            int iB = b(i3, z);
            textView.setTextColor(z ? textView.getResources().getColor(R.color.tab_item_select_color) : textView.getResources().getColor(R.color.color_title));
            ((ImageView) view.findViewById(R.id.img_tab_icon)).setImageResource(iB);
            i3++;
        }
    }
}
