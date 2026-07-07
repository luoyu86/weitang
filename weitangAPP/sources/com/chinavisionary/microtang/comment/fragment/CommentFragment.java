package com.chinavisionary.microtang.comment.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.c.c.a;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.comment.vo.CommentVo;
import com.chinavisionary.microtang.contract.ContractActivity;
import com.chinavisionary.microtang.prelook.PreLookActivity;
import com.chinavisionary.microtang.repair.RepairHistoryActivity;
import com.chinavisionary.microtang.web.WebViewActivity;

/* JADX INFO: loaded from: classes.dex */
public class CommentFragment extends BaseFragment<CommentVo> {
    public a B = new a() { // from class: c.e.c.m.e.a
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1654a.F1(view, i2);
        }
    };

    @BindView(R.id.recycler_comment)
    public BaseRecyclerView mCommentRecycler;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: E1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F1(View view, int i2) {
        if (i2 == 0) {
            H1();
        } else if (i2 == 1) {
            G1();
        } else {
            if (i2 != 2) {
                return;
            }
            I1();
        }
    }

    public static CommentFragment getInstance() {
        return new CommentFragment();
    }

    public final void G1() {
        Intent intent = new Intent(this.f6487e, (Class<?>) PreLookActivity.class);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public final void H1() {
        Intent intent = new Intent(this.f6487e, (Class<?>) ContractActivity.class);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public final void I1() {
        Intent intent = new Intent(this.f6487e, (Class<?>) RepairHistoryActivity.class);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_wait_comment);
        this.r = this.mCommentRecycler;
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @OnClick({R.id.tv_rent_change_info})
    public void catRentChangeInfo(View view) {
        Intent intent = new Intent(this.f6487e, (Class<?>) WebViewActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", "http://www.baidu.com");
        startActivity(intent);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_comment;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
