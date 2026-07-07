package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.e;
import c.b.a.f.b;
import c.e.a.a.c.c.a;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.a.d.z;
import c.e.c.j0.c.d;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.vo.ResponseRentConfigFeeVo;
import com.chinavisionary.microtang.sign.model.SignRoomModel;
import com.chinavisionary.microtang.sign.vo.RentClearTimeVo;
import com.chinavisionary.microtang.sign.vo.RentMethodVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RoomRentInfoFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public int C;
    public RentMethodVo D;
    public List<RentMethodVo> E;
    public b<RentMethodVo> F;
    public int G;
    public List<RentClearTimeVo> H;
    public b<RentClearTimeVo> I;
    public Long J;
    public int K;
    public Long L;
    public ResponseRentConfigFeeVo M;
    public boolean N;
    public SignRoomModel O;
    public c.e.c.j0.c.b P;
    public String Q;
    public Long R;
    public Boolean S;
    public boolean T;

    @BindView(R.id.img_back)
    public ImageView mBackImg;

    @BindView(R.id.btn_confirm)
    public AppCompatButton mConfirmBtn;

    @BindView(R.id.recycler_rent_info)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public int B = 7;
    public a U = new a() { // from class: c.e.c.j0.b.k
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1606a.I1(view, i2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I1(View view, int i2) {
        int onlyKey = ((LeftTitleToRightArrowVo) this.t.getList().get(i2)).getOnlyKey();
        if (onlyKey == 1) {
            O1();
            return;
        }
        if (onlyKey == 3) {
            X1();
        } else {
            if (onlyKey != 9) {
                return;
            }
            this.K = i2;
            W1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(int i2, int i3, int i4, View view) {
        this.D = this.E.get(i2);
        b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(int i2, int i3, int i4, View view) {
        e2(i2);
    }

    public static RoomRentInfoFragment getInstance(String str) {
        RoomRentInfoFragment roomRentInfoFragment = new RoomRentInfoFragment();
        roomRentInfoFragment.setArguments(CoreBaseFragment.q(str));
        return roomRentInfoFragment;
    }

    public final void E1(ResponseRentConfigFeeVo responseRentConfigFeeVo) {
        this.M = responseRentConfigFeeVo;
        if (responseRentConfigFeeVo == null) {
            F0(R.string.data_error);
        } else if (responseRentConfigFeeVo.isSuccess()) {
            P1(responseRentConfigFeeVo);
            int i2 = x.isNotNull(responseRentConfigFeeVo.getRentDurationTypeDesc()) ? 8 : 7;
            this.B = i2;
            if (!this.T) {
                this.B = i2 - 1;
            }
            c2(responseRentConfigFeeVo);
            this.mConfirmBtn.setVisibility(0);
        } else {
            G0(responseRentConfigFeeVo.getMessage());
        }
        a2(null);
    }

    public final void F1() {
        this.mTitleTv.setText(R.string.title_room_rent_info);
        this.mConfirmBtn.setText(R.string.title_confirm_rent_info);
        this.mConfirmBtn.setVisibility(8);
        this.mTitleTv.setVisibility(0);
        this.mBackImg.setVisibility(0);
        this.P = new c.e.c.j0.c.b();
    }

    public final void O1() {
        ResponseRentConfigFeeVo responseRentConfigFeeVo = this.M;
        if (responseRentConfigFeeVo != null) {
            SelectRentDateFragment selectRentDateFragment = SelectRentDateFragment.getInstance(responseRentConfigFeeVo);
            selectRentDateFragment.setRoomRentInfoFragment(this);
            K0(selectRentDateFragment, R.id.flayout_content);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void P1(ResponseRentConfigFeeVo responseRentConfigFeeVo) {
        this.T = responseRentConfigFeeVo.isCheckinCleaningDateFlag();
        q.d(getClass().getSimpleName(), "setupAdapterData :" + JSON.toJSONString(responseRentConfigFeeVo));
        this.t.initListData((List<T>) this.P.getAdapterData(responseRentConfigFeeVo, 3, this.J, Z1(), this.T));
    }

    public final void Q1(List<RentMethodVo> list) {
        this.C = 0;
        this.E = list;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.D = list.get(this.C);
        b<RentMethodVo> bVar = this.F;
        if (bVar != null) {
            bVar.setSelectOptions(this.C);
        }
    }

    public final void R1() {
        b<RentMethodVo> bVarBuild = new c.b.a.b.a(this.f6487e, new e() { // from class: c.e.c.j0.b.l
            @Override // c.b.a.d.e
            public final void onOptionsSelect(int i2, int i3, int i4, View view) {
                this.f1607a.L1(i2, i3, i4, view);
            }
        }).build();
        this.F = bVarBuild;
        bVarBuild.setTitleText(x.getString(R.string.title_select_pay_type));
        this.F.setPicker(this.E);
        this.F.setSelectOptions(this.C);
    }

    public final void S1() {
        BaseRecyclerView baseRecyclerView = this.mSwipeRefreshLayout.getBaseRecyclerView();
        this.r = baseRecyclerView;
        baseRecyclerView.setVerticalScrollBarEnabled(true);
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        this.t = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.setOnItemClickListener(this.U);
        this.t.addHeadView(d.getInstance().getAdapterHeadView(this.f6487e, 0));
    }

    public final void T1(List<RentClearTimeVo> list) {
        if (o.isNotEmpty(list)) {
            this.H = list;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RentClearTimeVo rentClearTimeVo = list.get(i2);
                if (rentClearTimeVo != null && rentClearTimeVo.isOptional()) {
                    return;
                }
            }
            U1();
        }
    }

    public final void U1() {
        b<RentClearTimeVo> bVarBuild = new c.b.a.b.a(this.f6487e, new e() { // from class: c.e.c.j0.b.n
            @Override // c.b.a.d.e
            public final void onOptionsSelect(int i2, int i3, int i4, View view) {
                this.f1609a.N1(i2, i3, i4, view);
            }
        }).build();
        this.I = bVarBuild;
        bVarBuild.setTitleText(x.getString(R.string.tip_select_estimate_time));
        if (o.listIsEmpty(this.H)) {
            this.H = new ArrayList();
        }
        this.I.setPicker(this.H);
        if (o.isNotEmpty(this.H)) {
            this.I.setSelectOptions(this.G);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    public final void V1() {
        SignRoomModel signRoomModel = (SignRoomModel) h(SignRoomModel.class);
        this.O = signRoomModel;
        signRoomModel.getConfigFee().observe(this, new Observer() { // from class: c.e.c.j0.b.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1608a.E1((ResponseRentConfigFeeVo) obj);
            }
        });
        this.O.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.j0.b.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1610a.a2((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        F1();
        S1();
        V1();
        j0();
    }

    public final void W1() {
        if (this.I != null) {
            Y1();
        } else if (!o.isNotEmpty(this.H)) {
            F0(R.string.tip_estimated_rent_time_is_empty);
        } else {
            U1();
            Y1();
        }
    }

    public final void X1() {
        b<RentMethodVo> bVar = this.F;
        if (bVar != null) {
            bVar.show();
        } else {
            R1();
            this.F.show();
        }
    }

    public final void Y1() {
        b<RentClearTimeVo> bVar = this.I;
        if (bVar != null) {
            bVar.show();
        }
    }

    public final boolean Z1() {
        return !this.N && x.isNullStr(this.Q);
    }

    public final void a2(RequestErrDto requestErrDto) {
        this.mSwipeRefreshLayout.setRefreshing(false);
        C(requestErrDto);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void b2() {
        if (this.D != null) {
            ((LeftTitleToRightArrowVo) this.t.getList().get(3)).setRight(this.D.getName());
            ArrayList arrayList = new ArrayList(this.t.getList());
            int onlyKeyToPosition = this.P.getOnlyKeyToPosition(arrayList, 5);
            ArrayList arrayList2 = new ArrayList(arrayList.subList(0, this.B));
            arrayList2.addAll(this.D.getConfigItems());
            if (onlyKeyToPosition != -1 && arrayList.size() > onlyKeyToPosition) {
                i("updatePayType position :" + onlyKeyToPosition);
                arrayList2.addAll(arrayList.subList(onlyKeyToPosition, arrayList.size()));
            }
            this.t.initListData(arrayList2);
        }
    }

    public final void c2(ResponseRentConfigFeeVo responseRentConfigFeeVo) {
        Q1(this.P.getRentMethodVoList(responseRentConfigFeeVo));
        T1(responseRentConfigFeeVo.getOptionalCleaningDates());
    }

    @OnClick({R.id.btn_confirm})
    public void confirmClick(View view) {
        if (M0(view)) {
            Long l = this.J;
            if ((l == null || l.longValue() == 0 || this.I == null) && this.T) {
                F0(R.string.tip_select_estimate_time);
                return;
            }
            if (this.D == null) {
                F0(R.string.tip_select_pay_type);
                return;
            }
            RoomSignMainInfoFragment roomSignMainInfoFragment = RoomSignMainInfoFragment.getInstance(this.f6484b);
            roomSignMainInfoFragment.a2(this.M.getRentTermTo());
            roomSignMainInfoFragment.Z1(this.D.getValue());
            roomSignMainInfoFragment.setKeepRent(this.N);
            roomSignMainInfoFragment.Y1(this.J);
            if (x.isNotNull(this.Q)) {
                roomSignMainInfoFragment.setContractKeyAndIsChangeRent(this.Q, this.S, this.R);
            }
            K0(roomSignMainInfoFragment, R.id.flayout_content);
        }
    }

    public final void d2() {
        this.I.dismiss();
        ((LeftTitleToRightArrowVo) this.t.getList().get(this.K)).setRight(z.getTimeYYMMDD(this.J));
        this.t.notifyDataSetChanged();
    }

    public final void e2(int i2) {
        if (o.isNotEmpty(this.H)) {
            RentClearTimeVo rentClearTimeVo = this.H.get(i2);
            if (!rentClearTimeVo.isOptional()) {
                G0(rentClearTimeVo.getReason());
                return;
            }
            this.G = i2;
            this.J = Long.valueOf(rentClearTimeVo.getCheckinCleaningDate());
            d2();
        }
    }

    public void f2(Long l) {
        if (l != null) {
            this.L = l;
            j0();
        }
        i("update select rent date :" + l);
    }

    @OnClick({R.id.tv_back})
    public void finishFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_room_rent_info;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        z0(R.string.loading_text);
        this.O.getRoomConfigFee(this.f6484b, this.L, this.N, this.Q, this.S);
    }

    public void setContractKeyAndIsChangeRent(String str, Boolean bool, Long l) {
        this.Q = str;
        this.S = bool;
        this.R = l;
    }

    public void setKeepRent(boolean z) {
        this.N = z;
    }
}
