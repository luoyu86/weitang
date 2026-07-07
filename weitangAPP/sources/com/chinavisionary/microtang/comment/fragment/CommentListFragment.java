package com.chinavisionary.microtang.comment.fragment;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.m.c.a;
import c.e.c.m0.c;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.comment.CommentActivity;
import com.chinavisionary.microtang.comment.adapter.CommentAdapter;
import com.chinavisionary.microtang.comment.bo.ResponseCommentListBo;
import com.chinavisionary.microtang.comment.event.EventRefreshCommentList;
import com.chinavisionary.microtang.comment.model.CommentModel;
import com.chinavisionary.microtang.comment.vo.CommentItemVo;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;
import g.b.a.m;

/* JADX INFO: loaded from: classes.dex */
public class CommentListFragment extends BaseFragment<CommentItemVo> {
    public int B;
    public CommentModel C;
    public a D;
    public final c.e.a.a.c.c.a E = new c.e.a.a.c.c.a() { // from class: c.e.c.m.e.c
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1656a.K1(view, i2);
        }
    };

    @BindView(R.id.recycler_comment)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(View view, int i2) {
        if (i2 >= 0) {
            CommentItemVo commentItemVo = (CommentItemVo) this.t.getList().get(i2);
            if (commentItemVo == null || !x.isNotNull(commentItemVo.getKey())) {
                F0(R.string.tip_comment_key_is_emtpy);
            } else if (x.isNotNull(commentItemVo.getJumpUrl()) && commentItemVo.getCommentType() == 7) {
                c0(BridgeWebViewActivity.class, commentItemVo.getJumpUrl());
            } else {
                L1(commentItemVo.getKey(), commentItemVo.getTitle());
            }
        }
    }

    public static CommentListFragment getInstance(int i2) {
        CommentListFragment commentListFragment = new CommentListFragment();
        commentListFragment.B = i2;
        return commentListFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1() {
        if (this.f6483a == 1 && this.t.getList().isEmpty()) {
            this.t.setEmptyTipMsg(x.getString(R.string.title_comment_is_empty_content));
            CommentItemVo commentItemVo = new CommentItemVo();
            commentItemVo.setItemType(34952);
            this.t.addDataToList((T) commentItemVo);
        }
    }

    public final void F1(ResponseCommentListBo responseCommentListBo) {
        if (responseCommentListBo != null) {
            D(responseCommentListBo.getRows());
        } else {
            D(null);
        }
        E1();
    }

    public final void G1(RequestErrDto requestErrDto) {
        boolean zOpenTipActivity;
        if (requestErrDto == null || 1 != this.B) {
            zOpenTipActivity = false;
        } else {
            int code = requestErrDto.getCode();
            zOpenTipActivity = c.getInstance().openTipActivity(this.f6487e, code);
            q.d(this.f6485c, "handleResponseErr errCode = " + code);
            if (zOpenTipActivity) {
                n();
            }
        }
        if (zOpenTipActivity) {
            return;
        }
        C(requestErrDto);
    }

    public final void L1(String str, String str2) {
        if (this.f6487e != null) {
            Intent intent = new Intent(this.f6487e, (Class<?>) CommentActivity.class);
            intent.putExtra("key", str);
            intent.putExtra("title", str2);
            this.f6487e.startActivity(intent);
        }
    }

    public final void M1() {
        CommentModel commentModel = (CommentModel) h(CommentModel.class);
        this.C = commentModel;
        commentModel.getCommentListResult().observe(this, new Observer() { // from class: c.e.c.m.e.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1657a.F1((ResponseCommentListBo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.m.e.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1655a.G1((RequestErrDto) obj);
            }
        });
    }

    public final void N1() {
        BaseSwipeRefreshLayout baseSwipeRefreshLayout = this.mBaseSwipeRefreshLayout;
        this.s = baseSwipeRefreshLayout;
        this.r = baseSwipeRefreshLayout.getBaseRecyclerView();
        CommentAdapter commentAdapter = new CommentAdapter();
        this.t = commentAdapter;
        commentAdapter.setOnItemClickListener(this.E);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.l = false;
        h0(this);
        a aVar = new a();
        this.D = aVar;
        aVar.setCommentFlage(this.B);
        M1();
        N1();
        z0(R.string.loading_text);
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_comment;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getCommentList(this.D);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @m
    public void refreshCommentList(EventRefreshCommentList eventRefreshCommentList) {
        j0();
    }
}
