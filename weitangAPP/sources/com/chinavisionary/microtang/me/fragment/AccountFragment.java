package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.c.c.a;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AccountFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public a B = new a() { // from class: c.e.c.x.d.c
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2029a.H1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H1(View view, int i2) {
        E1(i2);
    }

    public static AccountFragment getInstance() {
        return new AccountFragment();
    }

    public final void E1(int i2) {
        if (i2 == 0) {
            J1();
        } else {
            updatePwd();
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void F1() {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft(x.getString(R.string.title_phone_no));
        leftTitleToRightArrowVo.setCenter(t());
        leftTitleToRightArrowVo.setOnlyKey(0);
        leftTitleToRightArrowVo.setRight(x.getString(R.string.title_update));
        leftTitleToRightArrowVo.setShowArrow(true);
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_password));
        leftTitleToRightArrowVo2.setOnlyKey(1);
        leftTitleToRightArrowVo2.setRight(x.getString(R.string.title_update));
        leftTitleToRightArrowVo2.setShowArrow(true);
        arrayList.add(leftTitleToRightArrowVo2);
        this.t.initListData(arrayList);
    }

    public final void I1() {
        this.mSwipeRefreshLayout.setEnabled(false);
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        this.t = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.setOnItemClickListener(this.B);
    }

    public final void J1() {
        d(UpdatePhoneOrPwdFragment.getInstance(1), R.id.flayout_content);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_account_info);
        I1();
        F1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    public final void updatePwd() {
        d(UpdatePhoneOrPwdFragment.getInstance(2), R.id.flayout_content);
    }
}
