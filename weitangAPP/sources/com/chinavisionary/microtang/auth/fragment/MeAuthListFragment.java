package com.chinavisionary.microtang.auth.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.adapter.MeAuthAdapter;
import com.chinavisionary.microtang.auth.model.MeAuthModel;
import com.chinavisionary.microtang.auth.vo.EventUpdateMeAuthVo;
import com.chinavisionary.microtang.auth.vo.MeAuthHandleVo;
import com.chinavisionary.microtang.auth.vo.MeAuthVo;
import com.chinavisionary.microtang.base.BaseFragment;
import g.b.a.m;
import g.b.a.r;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MeAuthListFragment extends BaseFragment<MeAuthVo> {
    public boolean B;
    public int C;
    public MeAuthModel D;
    public c.e.a.a.c.c.a E = new a();

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            MeAuthListFragment.this.K1((MeAuthVo) MeAuthListFragment.this.t.getList().get(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        T1();
    }

    public static MeAuthListFragment getInstance() {
        return new MeAuthListFragment();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void G1(List<MeAuthVo> list) {
        if (list == null || list.isEmpty()) {
            this.t.addDataToList((T) new MeAuthVo());
        }
    }

    public final String H1() {
        MeAuthVo meAuthVo = (MeAuthVo) this.t.getList().get(this.C);
        return x.getString(R.string.placeholder_auth_tip_reject, meAuthVo.getApplyUserPosition() + meAuthVo.getApplyUserName(), meAuthVo.getAddress());
    }

    public final String I1() {
        MeAuthVo meAuthVo = (MeAuthVo) this.t.getList().get(this.C);
        return x.getString(R.string.placeholder_auth_tip_agree, meAuthVo.getApplyUserPosition() + meAuthVo.getApplyUserName(), meAuthVo.getAddress());
    }

    public final void J1(View view) {
        String authDoorKey = ((MeAuthVo) this.t.getList().get(this.C)).getAuthDoorKey();
        MeAuthHandleVo meAuthHandleVo = new MeAuthHandleVo();
        if (!this.B) {
            String str = (String) view.getTag();
            if (x.isNotNull(str)) {
                meAuthHandleVo.setReason(str);
            }
        }
        meAuthHandleVo.setResult(this.B);
        meAuthHandleVo.setAuthDoorKey(authDoorKey);
        z0(R.string.tip_submit_data_loading);
        this.D.postHandleApply(meAuthHandleVo);
    }

    public final void K1(MeAuthVo meAuthVo) {
        d(MeAuthDetailsFragment.getInstance(meAuthVo.getAuthDoorKey()), R.id.flayout_content);
    }

    public final void L1(ResponseRowsVo<MeAuthVo> responseRowsVo) {
        T1();
        if (responseRowsVo != null) {
            D(responseRowsVo.getRows());
            G1(responseRowsVo.getRows());
        }
    }

    public final void M1(ResponseStateVo responseStateVo) {
        T1();
        this.f6483a = 1;
        j0();
    }

    public final void R1() {
        MeAuthModel meAuthModel = (MeAuthModel) h(MeAuthModel.class);
        this.D = meAuthModel;
        meAuthModel.getMeAuthListResult().observe(this, new Observer() { // from class: c.e.c.h.c.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1486a.L1((ResponseRowsVo) obj);
            }
        });
        this.D.getResponseStateResult().observe(this, new Observer() { // from class: c.e.c.h.c.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1488a.M1((ResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.h.c.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1487a.Q1((RequestErrDto) obj);
            }
        });
    }

    public final void S1() {
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        MeAuthAdapter meAuthAdapter = new MeAuthAdapter();
        this.t = meAuthAdapter;
        meAuthAdapter.setOnClickListener(this.y);
        this.t.setEmptyTipMsg(x.getString(R.string.tip_auth_is_empty));
        this.t.setOnItemClickListener(this.E);
    }

    public final void T1() {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_agree) {
            this.C = ((Integer) view.getTag()).intValue();
            this.B = true;
            u0(I1());
        } else if (id != R.id.btn_reject) {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            J1(view);
        } else {
            this.C = ((Integer) view.getTag()).intValue();
            this.B = false;
            t0(H1(), "", 1, true, true);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_tab_me_auth);
        h0(this);
        S1();
        R1();
        z0(R.string.loading_text);
        j0();
    }

    @OnClick({R.id.tv_back})
    public void clickBack() {
        n();
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateMeAuth(EventUpdateMeAuthVo eventUpdateMeAuthVo) {
        this.f6483a = 1;
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_me_auth_list_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.D.getMeAuthList(r());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }
}
