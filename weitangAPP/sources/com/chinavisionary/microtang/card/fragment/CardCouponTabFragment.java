package com.chinavisionary.microtang.card.fragment;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseTabFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CardCouponTabFragment extends BaseTabFragment {
    public static CardCouponTabFragment getInstance() {
        return new CardCouponTabFragment();
    }

    public final List<Fragment> L1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList.add(CardCouponFragment.getInstance(i2));
        }
        return arrayList;
    }

    public final List<String> M1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("全部");
        arrayList.add("待使用");
        arrayList.add("已使用");
        arrayList.add("已过期");
        return arrayList;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.microtang.base.BaseTabFragment, com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        super.W();
        E1().setTabMode(1);
        J1(R.string.title_sale);
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getChildFragmentManager(), L1());
        tabFragmentAdapter.setTitleList(M1());
        K1(tabFragmentAdapter);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
    }
}
