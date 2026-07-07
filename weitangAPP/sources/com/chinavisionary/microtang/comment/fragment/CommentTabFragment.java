package com.chinavisionary.microtang.comment.fragment;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import c.e.a.d.x;
import c.e.c.v.f.k0;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseTabFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommentTabFragment extends BaseTabFragment {
    public k0 C;
    public final ViewPager.OnPageChangeListener D = new a();

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            CommentTabFragment.this.C.updateSelectActivityRecordTabToPosition(i2, true);
        }
    }

    public static CommentTabFragment getInstance() {
        return new CommentTabFragment();
    }

    public final List<Fragment> M1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 : N1()) {
            arrayList.add(CommentListFragment.getInstance(i2));
        }
        return arrayList;
    }

    public final int[] N1() {
        return new int[]{1, 0};
    }

    public final List<String> O1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x.getString(R.string.title_wait_comment_tab));
        arrayList.add(x.getString(R.string.title_comment_over_tab));
        return arrayList;
    }

    public final void P1() {
        this.C = new k0();
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getFragmentManager(), M1());
        tabFragmentAdapter.setTitleList(O1());
        K1(tabFragmentAdapter);
        F1().addOnPageChangeListener(this.D);
        this.C.setupCommentListTab(E1());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.microtang.base.BaseTabFragment, com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        super.W();
        J1(R.string.title_menu_rent_comment);
        E1().setTabMode(1);
        G1(false);
        H1(true);
        this.u.findViewById(R.id.flayout_content).setBackgroundColor(getResources().getColor(R.color.color_white));
        this.u.findViewById(R.id.tv_title_split_line).setVisibility(0);
        P1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
    }
}
