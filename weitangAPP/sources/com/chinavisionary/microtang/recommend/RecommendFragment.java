package com.chinavisionary.microtang.recommend;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.c.f0.a.a;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.recommend.adapter.RecommendAdapter;
import com.chinavisionary.microtang.recommend.vo.RecommendVo;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendFragment extends BaseFragment<RecommendVo> {

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static RecommendFragment getInstance() {
        return new RecommendFragment();
    }

    public final void E1() {
        D(a.getInstance().getRecommendList());
    }

    public final void F1() {
        BaseRecyclerView baseRecyclerView = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        this.r = baseRecyclerView;
        baseRecyclerView.setBackgroundColor(getResources().getColor(R.color.color_line));
        RecommendAdapter recommendAdapter = new RecommendAdapter();
        this.t = recommendAdapter;
        recommendAdapter.setOnClickListener(this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_me_recommend);
        F1();
        E1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.tv_back})
    public void onBackClick() {
        n();
    }
}
