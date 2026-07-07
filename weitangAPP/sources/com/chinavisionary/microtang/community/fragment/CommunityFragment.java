package com.chinavisionary.microtang.community.fragment;

import android.view.View;
import butterknife.BindView;
import c.e.a.a.c.c.a;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.community.adapter.CommunityAdapter;
import com.chinavisionary.microtang.community.vo.CommunityVo;
import com.chinavisionary.microtang.contract.adapter.ContractGridSpecItemDecoration;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommunityFragment extends BaseFragment<CommunityVo> {
    public int B;
    public final a C = new a() { // from class: c.e.c.n.d.o
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1730a.F1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout_main)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: E1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F1(View view, int i2) {
        F0(((CommunityVo) this.t.getList().get(i2)).getViewType());
    }

    public static CommunityFragment getInstance(int i2) {
        CommunityFragment communityFragment = new CommunityFragment();
        communityFragment.G1(i2);
        return communityFragment;
    }

    public final void G1(int i2) {
        this.B = i2;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        CommunityAdapter communityAdapter = new CommunityAdapter();
        this.t = communityAdapter;
        communityAdapter.setOnItemClickListener(this.C);
        this.t.initListData((List<T>) c.e.c.n.e.a.getInstance().getTestData(this.B));
        this.r.addItemDecoration(new ContractGridSpecItemDecoration(getResources().getDimensionPixelSize(R.dimen.dp_1)));
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_community;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
