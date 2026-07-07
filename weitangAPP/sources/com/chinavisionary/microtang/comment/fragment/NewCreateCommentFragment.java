package com.chinavisionary.microtang.comment.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.m.f.c;
import c.e.c.m.g.a;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.comment.adapter.NewCommentAdapter;
import com.chinavisionary.microtang.comment.event.EventRefreshCommentList;
import com.chinavisionary.microtang.comment.model.CommentModel;
import com.chinavisionary.microtang.comment.vo.CommentDetailsVo;
import com.chinavisionary.microtang.comment.vo.CreateCommentBo;
import com.chinavisionary.microtang.comment.vo.CreateCommentResponseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NewCreateCommentFragment extends BaseFragment<a> {
    public String B;
    public CommentModel C;
    public c D;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.btn_next)
    public AppCompatButton mNextBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static NewCreateCommentFragment getInstance(String str, String str2) {
        NewCreateCommentFragment newCreateCommentFragment = new NewCreateCommentFragment();
        newCreateCommentFragment.B = str2;
        newCreateCommentFragment.f6484b = str;
        return newCreateCommentFragment;
    }

    public final void E1(ResponseStateVo responseStateVo) {
        boolean zF = F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed);
        k(new EventRefreshCommentList());
        if (zF) {
            m();
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void F1(CommentDetailsVo commentDetailsVo) {
        if (commentDetailsVo == null) {
            F0(R.string.data_error);
            M1();
            return;
        }
        this.mTitleTv.setText(x.getNotNullStr(commentDetailsVo.getCommentTypeName(), this.B));
        if (!commentDetailsVo.isIsComment()) {
            this.mNextBtn.setVisibility(0);
            this.C.getCreateNewCommentInfo(this.f6484b);
        } else {
            M1();
            this.t.initListData((List<T>) this.D.handleCommentDetailsVo(commentDetailsVo));
            this.mNextBtn.setVisibility(8);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void G1(CreateCommentResponseVo createCommentResponseVo) {
        M1();
        this.t.initListData((List<T>) this.D.handleNewCreateComment(createCommentResponseVo));
    }

    public final void H1() {
        CommentModel commentModel = (CommentModel) h(CommentModel.class);
        this.C = commentModel;
        commentModel.getCreateResultLive().observeForever(new Observer() { // from class: c.e.c.m.e.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1665a.E1((ResponseStateVo) obj);
            }
        });
        this.C.getNewCreateCommentLive().observe(this, new Observer() { // from class: c.e.c.m.e.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1664a.G1((CreateCommentResponseVo) obj);
            }
        });
        this.C.getCommentDetailsLive().observe(this, new Observer() { // from class: c.e.c.m.e.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1663a.F1((CommentDetailsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.m.e.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1662a.C((RequestErrDto) obj);
            }
        });
    }

    public final void M1() {
        H();
        a0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(this.B);
        this.D = new c();
        this.t = new NewCommentAdapter();
        p0(this.mBaseSwipeRefreshLayout);
        H1();
        J();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @OnClick({R.id.btn_next})
    public void commentClick(View view) {
        CreateCommentBo submitData = this.D.getSubmitData(this.t.getList());
        if (x.isNotNull(submitData.getTipMsg())) {
            G0(submitData.getTipMsg());
            return;
        }
        z0(R.string.tip_submit_data_loading);
        submitData.setRentCommentKey(this.f6484b);
        this.C.createComment(submitData);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_new_create_comment;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        z0(R.string.loading_text);
        this.C.getCommentDetails(this.f6484b);
    }
}
