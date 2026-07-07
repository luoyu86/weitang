package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import android.widget.Button;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.a;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.pre.fragment.ReserveRoomConfirmMsgFragment;
import com.chinavisionary.microtang.room.model.RoomOperationModel;
import com.chinavisionary.microtang.sign.fragments.RoomRentInfoFragment;
import com.chinavisionary.microtang.sign.view.BaseWebView;

/* JADX INFO: loaded from: classes2.dex */
public class AirQualityFragment extends BaseFragment {
    public boolean B;
    public boolean C;
    public RoomOperationModel D;
    public String E;
    public Long F;
    public Boolean G;

    @BindView(R.id.btn_confirm)
    public Button mConfirmBtn;

    @BindView(R.id.web_view_content)
    public BaseWebView mContentWebView;

    @BindView(R.id.constraint_layout_alert_air)
    public View mLayoutAirView;

    public static AirQualityFragment getInstance(String str, boolean z) {
        AirQualityFragment airQualityFragment = new AirQualityFragment();
        airQualityFragment.setArguments(CoreBaseFragment.q(str));
        airQualityFragment.L1(z);
        return airQualityFragment;
    }

    public final void E1(ResponseStateVo responseStateVo) {
        H();
        if (responseStateVo == null) {
            F0(R.string.data_error);
            return;
        }
        if (!responseStateVo.isSuccess()) {
            G0(responseStateVo.getMessage());
            return;
        }
        boolean zIsNullStr = x.isNullStr(responseStateVo.getContent());
        this.mLayoutAirView.setVisibility(zIsNullStr ? 8 : 0);
        this.mContentWebView.loadHtmlContent(responseStateVo.getContent(), false);
        if (zIsNullStr) {
            F1();
        }
    }

    public final void F1() {
        H();
        if (!this.C) {
            g0();
        }
        if (this.B) {
            J1();
        } else {
            K1();
        }
    }

    public final void J1() {
        if (!a.getInstance().isH5Model()) {
            K0(ReserveRoomConfirmMsgFragment.getInstance(this.f6484b), R.id.flayout_content);
        } else {
            g0();
            s1(this.f6484b);
        }
    }

    public final void K1() {
        if (a.getInstance().isH5Model()) {
            g0();
            t1(this.f6484b);
            return;
        }
        RoomRentInfoFragment roomRentInfoFragment = RoomRentInfoFragment.getInstance(this.f6484b);
        if (x.isNotNull(this.E)) {
            roomRentInfoFragment.setContractKeyAndIsChangeRent(this.E, this.G, this.F);
        }
        roomRentInfoFragment.setKeepRent(this.C);
        K0(roomRentInfoFragment, R.id.flayout_content);
    }

    public final void L1(boolean z) {
        this.B = z;
    }

    public final void M1() {
        this.f6488f = new CoreBaseFragment.c(this);
        RoomOperationModel roomOperationModel = (RoomOperationModel) h(RoomOperationModel.class);
        this.D = roomOperationModel;
        roomOperationModel.getAirQualityLiveData().observe(this, new Observer() { // from class: c.e.c.h0.f.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1497a.E1((ResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.h0.f.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1494a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mConfirmBtn.setText(this.B ? R.string.title_know_go_to_pre_order : R.string.title_know_go_to_sign);
        M1();
        z0(R.string.loading_text);
    }

    @OnClick({R.id.btn_think})
    public void cancelClick(View view) {
        n();
    }

    @OnClick({R.id.btn_confirm})
    public void confirmClick(View view) {
        F1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_air_quality;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.D.getRoomAirQuality(this.f6484b);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f6488f.postDelayed(new Runnable() { // from class: c.e.c.h0.f.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f1496a.F1();
            }
        }, 800L);
    }

    public void setBackRentDate(Long l) {
        this.F = l;
    }

    public void setContractKey(String str) {
        this.E = str;
    }

    public void setExtendOldRentFlag(Boolean bool) {
        this.G = bool;
    }

    public void setKeepRent(boolean z) {
        this.C = z;
    }
}
