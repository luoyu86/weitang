package com.chinavisionary.microtang.pre.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PreOrderAppealFragment extends BaseFragment<LeftTitleToRightArrowVo> {

    @BindView(R.id.recycler_appeal)
    public BaseRecyclerView mAppealRecyclerView;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static PreOrderAppealFragment getInstance(String str) {
        return new PreOrderAppealFragment();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 6; i2++) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo.setLeft("表单" + i2);
            leftTitleToRightArrowVo.setEdit(true);
            arrayList.add(leftTitleToRightArrowVo);
        }
        this.t.initListData(arrayList);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText("取消预定--申诉");
        this.r = this.mAppealRecyclerView;
        this.t = new LeftTitleToRightArrowAdapter();
        E1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_pre_order_appeal;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.btn_submit})
    public void submitClick(View view) {
        z0(R.string.tip_submit_data_loading);
    }
}
