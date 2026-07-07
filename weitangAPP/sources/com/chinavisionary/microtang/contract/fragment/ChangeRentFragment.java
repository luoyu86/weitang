package com.chinavisionary.microtang.contract.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.g;
import c.b.a.f.c;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractChangeResponse;
import com.chinavisionary.microtang.room.SearchRoomActivity;
import com.chinavisionary.microtang.sign.view.BaseWebView;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class ChangeRentFragment extends BaseFragment<String> {
    public Long B;
    public c C;
    public ContractModel D;
    public boolean E;
    public String F;
    public String G;

    @BindView(R.id.cb_agree)
    public CheckBox mAgreeCb;

    @BindView(R.id.web_view_protocol)
    public BaseWebView mBaseWebView;

    @BindView(R.id.view_title_bg)
    public View mBgView;

    @BindView(R.id.tv_rent_back_time)
    public TextView mRentBackRoomTv;

    @BindView(R.id.tv_rent_back_time_value)
    public TextView mRentBackTimeTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.b.a.d.a {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(View view) {
            ChangeRentFragment.this.C.returnData();
        }

        @Override // c.b.a.d.a
        public void customLayout(View view) {
            ((TextView) view.findViewById(R.id.tv_title_look_room)).setText(R.string.tip_title_exit_rent_date);
            ((Button) view.findViewById(R.id.btn_confirm_time)).setOnClickListener(new View.OnClickListener() { // from class: c.e.c.o.c.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f1733a.b(view2);
                }
            });
        }
    }

    public class b implements g {
        public b() {
        }

        @Override // c.b.a.d.g
        public void onTimeSelect(Date date, View view) {
            ChangeRentFragment.this.I1(date);
        }
    }

    public static ChangeRentFragment getInstance(String str, String str2) {
        ChangeRentFragment changeRentFragment = new ChangeRentFragment();
        changeRentFragment.J1(str2);
        changeRentFragment.setArguments(CoreBaseFragment.q(str));
        return changeRentFragment;
    }

    public final void I1(Date date) {
        this.B = Long.valueOf(date.getTime());
        this.C.dismiss();
        this.mRentBackTimeTv.setText(z.getTimeYYMMDD(this.B));
    }

    public final void J1(String str) {
        this.F = str;
    }

    public final void K1(ContractChangeResponse contractChangeResponse) {
        H();
        if (contractChangeResponse != null) {
            String remark = contractChangeResponse.getRemark();
            this.G = contractChangeResponse.getOldRentBackRemark();
            this.mAgreeCb.setText(x.getNotNullStr(remark, "").replace("\n", "，"));
            this.mBaseWebView.loadHtmlContent("<h5 align='center'>" + x.getString(R.string.title_change_rent_info) + "</h5>" + contractChangeResponse.getContent(), false);
            L1(contractChangeResponse.getOldRentBackTimeFrom(), contractChangeResponse.getOldRentBackTimeTo());
            Long oldRentBackTimeFrom = contractChangeResponse.getOldRentBackTimeFrom();
            this.B = oldRentBackTimeFrom;
            this.mRentBackTimeTv.setText(z.getTimeYYMMDD(oldRentBackTimeFrom));
        }
    }

    public final void L1(Long l, Long l2) {
        if (l == null || l2 == null || l.longValue() >= l2.longValue()) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        Long l3 = this.B;
        if (l3 != null && l3.longValue() >= l.longValue() && this.B.longValue() <= l2.longValue()) {
            calendar.setTimeInMillis(this.B.longValue());
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l.longValue());
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeInMillis(l2.longValue());
        c cVarBuild = new c.b.a.b.b(this.f6487e, new b()).setLayoutRes(R.layout.item_custom_time_picker_layout, new a()).setType(new boolean[]{true, true, true, false, false, false}).setLabel("年", "月", "日", "", "", "").setDividerColor(-12303292).setContentTextSize(20).setDate(calendar).setRangDate(calendar2, calendar3).isDialog(true).setOutSideColor(0).setOutSideCancelable(true).build();
        this.C = cVarBuild;
        cVarBuild.setKeyBackCancelable(true);
    }

    public final void M1() {
        c cVar = this.C;
        if (cVar != null) {
            cVar.show();
        }
    }

    public final void N1() {
        if (!this.mAgreeCb.isChecked()) {
            F0(R.string.tip_change_rent_protocol);
            return;
        }
        if (this.B == null) {
            F0(R.string.tip_title_exit_rent_date);
            return;
        }
        Intent intent = new Intent(this.f6486d, (Class<?>) SearchRoomActivity.class);
        intent.putExtra("extendOldRentFlag", this.E);
        intent.putExtra("key", this.f6484b);
        intent.putExtra("extendOldRentDateFlag", this.B);
        startActivity(intent);
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.tv_rent_back_time_value) {
            M1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mBgView.setVisibility(0);
        this.mBgView.setBackgroundColor(getResources().getColor(R.color.color_white));
        this.mTitleTv.setText(R.string.title_request_change_rent);
        this.mRentBackRoomTv.setText(x.appendStringToResId(R.string.title_estimate_exit_rent_time, this.F));
        this.mRentBackTimeTv.setOnClickListener(this.y);
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.D = contractModel;
        contractModel.getChangeRent().observe(this, new Observer() { // from class: c.e.c.o.c.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1735a.K1((ContractChangeResponse) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1737a.C((RequestErrDto) obj);
            }
        });
        j0();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @OnClick({R.id.img_info_tip})
    public void clickHelp() {
        u0(this.G);
    }

    @OnClick({R.id.btn_keep_rent_date})
    public void clickKeepRentDate(View view) {
        this.E = true;
        N1();
    }

    @OnClick({R.id.btn_new_rent})
    public void clickNewSignRentDate(View view) {
        this.E = false;
        N1();
    }

    @OnClick({R.id.tv_rent_back_time})
    public void clickShowTimeView() {
        M1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_change_rent_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        z0(R.string.loading_text);
        this.D.getContractChangeRent(this.f6484b);
    }
}
