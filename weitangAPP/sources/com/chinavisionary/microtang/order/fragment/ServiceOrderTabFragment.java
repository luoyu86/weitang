package com.chinavisionary.microtang.order.fragment;

import android.view.View;
import androidx.fragment.app.Fragment;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseTabFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ServiceOrderTabFragment extends BaseTabFragment {
    public static ServiceOrderTabFragment getInstance() {
        return new ServiceOrderTabFragment();
    }

    public final List<Fragment> L1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ServiceOrderListFragment.getInstance(null));
        arrayList.add(ServiceOrderListFragment.getInstance(4));
        arrayList.add(ServiceOrderListFragment.getInstance(3));
        arrayList.add(ServiceOrderListFragment.getInstance(5));
        return arrayList;
    }

    public final List<String> M1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x.getString(R.string.title_server_order_all));
        arrayList.add(x.getString(R.string.title_server_order_wait_comment));
        arrayList.add(x.getString(R.string.title_server_order_progress));
        arrayList.add(x.getString(R.string.title_server_order_over));
        return arrayList;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.microtang.base.BaseTabFragment, com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        super.W();
        G1(false);
        H1(true);
        E1().setTabMode(1);
        J1(R.string.title_me_service_order_all);
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getChildFragmentManager(), L1());
        tabFragmentAdapter.setTitleList(M1());
        K1(tabFragmentAdapter);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
    }
}
