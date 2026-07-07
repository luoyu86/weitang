package com.chinavisionary.microtang.alert;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.alert.adapter.AlertListAdapter;
import com.chinavisionary.microtang.base.BaseFragment;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AlertListFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public String B;
    public List<LeftTitleToRightArrowVo> C;
    public a D;

    @BindView(R.id.recycler_content)
    public BaseRecyclerView mRecyclerContent;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public interface a {
        void alertCancel(View view);

        void alertConfirm(View view, List<LeftTitleToRightArrowVo> list);
    }

    public static AlertListFragment getInstance(List<LeftTitleToRightArrowVo> list, String str) {
        AlertListFragment alertListFragment = new AlertListFragment();
        alertListFragment.E1(list);
        alertListFragment.setTitle(str);
        return alertListFragment;
    }

    public final void E1(List<LeftTitleToRightArrowVo> list) {
        this.C = list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(x.getNotNullStr(this.B, x.getString(R.string.title_alert_tip)));
        this.r = this.mRecyclerContent;
        AlertListAdapter alertListAdapter = new AlertListAdapter();
        this.t = alertListAdapter;
        alertListAdapter.initListData(this.C);
    }

    @OnClick({R.id.btn_action_confirm, R.id.btn_action_cancel})
    public void actionClickView(View view) {
        g0();
        if (this.D != null) {
            int id = view.getId();
            if (id == R.id.btn_action_cancel) {
                this.D.alertCancel(view);
            } else {
                if (id != R.id.btn_action_confirm) {
                    return;
                }
                this.D.alertConfirm(view, this.C);
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_alert_list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    public void setIAlertListClickListener(a aVar) {
        this.D = aVar;
    }

    public final void setTitle(String str) {
        this.B = str;
    }
}
