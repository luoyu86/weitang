package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.merchant.model.CommentModel;
import com.chinavisionary.microtang.merchant.vo.MerchantCommentVo;
import com.chinavisionary.microtang.room.adapter.MoreRentCommentAdapter;

/* JADX INFO: loaded from: classes.dex */
public class MerchantMainCommentFragment extends BaseFragment<MerchantCommentVo> {
    public CommentModel B;
    public int C;

    @BindView(R.id.swipe_refresh_layout_comment)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    public static MerchantMainCommentFragment getInstance(String str, int i2) {
        MerchantMainCommentFragment merchantMainCommentFragment = new MerchantMainCommentFragment();
        merchantMainCommentFragment.setArguments(CoreBaseFragment.q(str));
        merchantMainCommentFragment.I1(i2);
        return merchantMainCommentFragment;
    }

    public final void E1(ResponseRowsVo<MerchantCommentVo> responseRowsVo) {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
        if (responseRowsVo == null || !responseRowsVo.getSuccess()) {
            return;
        }
        D(responseRowsVo.getRows());
    }

    public final void F1(RequestErrDto requestErrDto) {
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
        C(requestErrDto);
    }

    public final void I1(int i2) {
        this.C = i2;
    }

    public final void J1() {
        CommentModel commentModel = (CommentModel) h(CommentModel.class);
        this.B = commentModel;
        commentModel.getMerchantCommentResult().observe(this, new Observer() { // from class: c.e.c.y.b.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2245a.E1((ResponseRowsVo) obj);
            }
        });
        this.B.getCommentListResult().observe(this, new Observer() { // from class: c.e.c.y.b.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2245a.E1((ResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.y.b.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2246a.F1((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        MoreRentCommentAdapter moreRentCommentAdapter = new MoreRentCommentAdapter();
        this.t = moreRentCommentAdapter;
        moreRentCommentAdapter.setEmptyTipMsg(getString(R.string.title_comment_is_empty));
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        J1();
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_merchant_main_comment_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        int i2 = this.C;
        if (i2 == 1) {
            this.B.getMerchantComment(this.f6484b, r());
        } else if (i2 == 2) {
            this.B.getCommodityComment(this.f6484b, r());
        }
    }
}
