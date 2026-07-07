package com.chinavisionary.microtang.auth.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.model.MeAuthModel;
import com.chinavisionary.microtang.auth.vo.EventUpdateMeAuthVo;
import com.chinavisionary.microtang.auth.vo.MeAuthDetailsVo;
import com.chinavisionary.microtang.auth.vo.MeAuthHandleVo;
import com.chinavisionary.microtang.base.BaseFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MeAuthDetailsFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public boolean B;
    public MeAuthDetailsVo C;
    public MeAuthModel D;

    @BindView(R.id.btn_agree)
    public Button mAgreeBtn;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.btn_reject)
    public Button mRejectBtn;

    @BindView(R.id.tv_state)
    public TextView mStateTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        S1();
        j0();
    }

    public static MeAuthDetailsFragment getInstance(String str) {
        MeAuthDetailsFragment meAuthDetailsFragment = new MeAuthDetailsFragment();
        meAuthDetailsFragment.setArguments(CoreBaseFragment.q(str));
        return meAuthDetailsFragment;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1(MeAuthDetailsVo meAuthDetailsVo) {
        S1();
        P1(meAuthDetailsVo.getAuthDoorApprovalStatus());
        this.mStateTv.setText(x.getNotNullStr(meAuthDetailsVo.getAuthDoorApprovalStatusName(), ""));
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft(x.getString(R.string.title_order_name));
        leftTitleToRightArrowVo.setRight(x.getNotNullStr(meAuthDetailsVo.getOrderTitle(), ""));
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_order_code));
        leftTitleToRightArrowVo2.setRight(x.getNotNullStr(meAuthDetailsVo.getAuthDoorKey(), ""));
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_apply_reason));
        leftTitleToRightArrowVo3.setRight(x.getNotNullStr(meAuthDetailsVo.getApplyReason(), ""));
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_auth_room));
        leftTitleToRightArrowVo4.setRight(x.getNotNullStr(meAuthDetailsVo.getAddress(), ""));
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_auth_time));
        leftTitleToRightArrowVo5.setRight(z.getTime(Long.valueOf(meAuthDetailsVo.getApplyOpenDoorStart())) + "-" + z.getTime(Long.valueOf(meAuthDetailsVo.getApplyOpenDoorEnd())));
        arrayList.add(leftTitleToRightArrowVo5);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setTitle(x.getString(R.string.title_apply_info));
        leftTitleToRightArrowVo6.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo6);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo7.setLeft(x.getString(R.string.title_apply_user));
        leftTitleToRightArrowVo7.setRight(x.getNotNullStr(meAuthDetailsVo.getApplyUserName(), ""));
        arrayList.add(leftTitleToRightArrowVo7);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_apply_user_position));
        leftTitleToRightArrowVo8.setRight(x.getNotNullStr(meAuthDetailsVo.getApplyUserPosition(), ""));
        arrayList.add(leftTitleToRightArrowVo8);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setLeft(x.getString(R.string.title_apply_user_phone));
        leftTitleToRightArrowVo9.setAutoLink(4);
        leftTitleToRightArrowVo9.setRight(x.getNotNullStr(meAuthDetailsVo.getApplyUserPhone(), ""));
        arrayList.add(leftTitleToRightArrowVo9);
        if (meAuthDetailsVo.getAuthResultTime() != null) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo10.setTitle(x.getString(R.string.title_handle_result));
            leftTitleToRightArrowVo10.setTitle(true);
            arrayList.add(leftTitleToRightArrowVo10);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo11.setLeft(x.getString(R.string.title_order_handle_time));
            leftTitleToRightArrowVo11.setRight(z.getTime(meAuthDetailsVo.getAuthResultTime()));
            arrayList.add(leftTitleToRightArrowVo11);
        }
        if (x.isNotNull(meAuthDetailsVo.getAuthResultReason())) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo12 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo12.setLeft(x.getString(R.string.title_order_reject_reason));
            leftTitleToRightArrowVo12.setRight(x.getNotNullStr(meAuthDetailsVo.getAuthResultReason(), ""));
            arrayList.add(leftTitleToRightArrowVo12);
        }
        this.t.initListData(arrayList);
    }

    public final String F1() {
        return x.getString(R.string.placeholder_auth_tip_reject, this.C.getApplyUserPosition() + this.C.getApplyUserName(), this.C.getAddress());
    }

    public final String G1() {
        return x.getString(R.string.placeholder_auth_tip_agree, this.C.getApplyUserPosition() + this.C.getApplyUserName(), this.C.getAddress());
    }

    public final void H1(View view) {
        String authDoorKey = this.C.getAuthDoorKey();
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

    public final void I1(MeAuthDetailsVo meAuthDetailsVo) {
        E1(meAuthDetailsVo);
        this.C = meAuthDetailsVo;
    }

    public final void J1(ResponseStateVo responseStateVo) {
        S1();
        j0();
        if (responseStateVo == null || !responseStateVo.isSuccess()) {
            return;
        }
        k(new EventUpdateMeAuthVo());
    }

    public final void O1() {
        this.mAgreeBtn.setOnClickListener(this.y);
        this.mRejectBtn.setOnClickListener(this.y);
    }

    public final void P1(int i2) {
        int i3 = i2 == 1 ? 0 : 8;
        this.mAgreeBtn.setVisibility(i3);
        this.mRejectBtn.setVisibility(i3);
    }

    public final void Q1() {
        MeAuthModel meAuthModel = (MeAuthModel) h(MeAuthModel.class);
        this.D = meAuthModel;
        meAuthModel.getMeAuthDetailsResult().observe(this, new Observer() { // from class: c.e.c.h.c.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1484a.I1((MeAuthDetailsVo) obj);
            }
        });
        this.D.getResponseStateResult().observe(this, new Observer() { // from class: c.e.c.h.c.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1485a.J1((ResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.h.c.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1483a.N1((RequestErrDto) obj);
            }
        });
    }

    public final void R1() {
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        this.t = new LeftTitleToRightArrowAdapter();
    }

    public final void S1() {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_agree) {
            this.B = true;
            u0(G1());
        } else if (id == R.id.btn_reject) {
            this.B = false;
            t0(F1(), "", 1, true, true);
        } else {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            H1(view);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_auth_details);
        O1();
        R1();
        Q1();
        z0(R.string.loading_text);
        j0();
    }

    @OnClick({R.id.tv_back})
    public void clickBack() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_me_auth_details_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.D.getMeAuthDetails(this.f6484b);
    }
}
