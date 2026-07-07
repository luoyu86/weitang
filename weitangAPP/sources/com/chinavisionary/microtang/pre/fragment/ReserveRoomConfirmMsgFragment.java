package com.chinavisionary.microtang.pre.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.f.b;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.c0.c.e;
import c.e.c.j0.c.d;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.alert.AlertListFragment;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.vo.NameValueVo;
import com.chinavisionary.microtang.pre.adapter.PreRoomConfirmMsgAdapter;
import com.chinavisionary.microtang.pre.model.ReserveModel;
import com.chinavisionary.microtang.pre.vo.RequestReserveInfoVo;
import com.chinavisionary.microtang.pre.vo.ReserveRoomInfoVo;
import com.chinavisionary.microtang.sign.fragments.RoomSignContractNearbyFragment;
import com.chinavisionary.microtang.vo.ScreenLeftTitleToRightArrowResultVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveRoomConfirmMsgFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public String B;
    public ReserveModel C;
    public int D;
    public b<NameValueVo> E;
    public e F;
    public c.e.a.a.c.c.a G = new c.e.a.a.c.c.a() { // from class: c.e.c.c0.b.i
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1409a.J1(view, i2);
        }
    };
    public AlertListFragment.a H = new a();

    @BindView(R.id.btn_next)
    public Button mNextBtn;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements AlertListFragment.a {
        public a() {
        }

        @Override // com.chinavisionary.microtang.alert.AlertListFragment.a
        public void alertCancel(View view) {
        }

        @Override // com.chinavisionary.microtang.alert.AlertListFragment.a
        public void alertConfirm(View view, List<LeftTitleToRightArrowVo> list) {
            ReserveRoomConfirmMsgFragment.this.F1(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J1(View view, int i2) {
        if (666 == ((LeftTitleToRightArrowVo) this.t.getList().get(i2)).getOnlyKey()) {
            this.D = i2;
            P1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(RequestErrDto requestErrDto) {
        this.mSwipeRefreshLayout.setRefreshing(false);
        C(requestErrDto);
    }

    public static ReserveRoomConfirmMsgFragment getInstance(String str) {
        ReserveRoomConfirmMsgFragment reserveRoomConfirmMsgFragment = new ReserveRoomConfirmMsgFragment();
        reserveRoomConfirmMsgFragment.setArguments(CoreBaseFragment.q(str));
        return reserveRoomConfirmMsgFragment;
    }

    public final void F1(List<LeftTitleToRightArrowVo> list) {
        RequestReserveInfoVo requestReserveInfoVo = this.F.getRequestReserveInfoVo(list, this.f6484b);
        q.d(getClass().getSimpleName(), "handleConfirm reserveInfoVo:" + JSON.toJSONString(requestReserveInfoVo));
        RoomSignContractNearbyFragment roomSignContractNearbyFragment = RoomSignContractNearbyFragment.getInstance(this.f6484b);
        roomSignContractNearbyFragment.setRequestReserveInfoVo(requestReserveInfoVo, this.B);
        K0(roomSignContractNearbyFragment, R.id.flayout_content);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void G1(ReserveRoomInfoVo reserveRoomInfoVo) {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
        if (reserveRoomInfoVo == null) {
            this.mNextBtn.setVisibility(8);
            return;
        }
        if (!reserveRoomInfoVo.isSuccess()) {
            this.mNextBtn.setVisibility(8);
            G0(reserveRoomInfoVo.getMessage());
        } else {
            this.mNextBtn.setVisibility(0);
            this.B = x.bigDecimalToPlainString(reserveRoomInfoVo.getDepositFee());
            this.t.initListData((List<T>) this.F.getAdapterData(reserveRoomInfoVo));
        }
    }

    public final void H1() {
        this.mTitleTv.setText(R.string.title_pre_room_confirm_msg);
        this.F = new e();
    }

    public final void N1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        PreRoomConfirmMsgAdapter preRoomConfirmMsgAdapter = new PreRoomConfirmMsgAdapter();
        this.t = preRoomConfirmMsgAdapter;
        preRoomConfirmMsgAdapter.setOnItemClickListener(this.G);
        this.t.addHeadView(d.getInstance().getPreAdapterHeadView(this.f6487e, 0));
    }

    public final void O1() {
        ReserveModel reserveModel = (ReserveModel) h(ReserveModel.class);
        this.C = reserveModel;
        reserveModel.getRoomInfoVoLiveData().observe(this, new Observer() { // from class: c.e.c.c0.b.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1410a.G1((ReserveRoomInfoVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.c0.b.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1411a.L1((RequestErrDto) obj);
            }
        });
    }

    public final void P1() {
        b<NameValueVo> bVar = this.E;
        if (bVar != null) {
            bVar.show();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        H1();
        N1();
        O1();
        j0();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_pre_room_confirm_msg;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        z0(R.string.loading_text);
        this.C.getReserveRoomInfoToKey(this.f6484b);
    }

    @OnClick({R.id.btn_next})
    public void nextClick() {
        ScreenLeftTitleToRightArrowResultVo editVo;
        List<LeftTitleToRightArrowVo> list = this.t.getList();
        if (o.isNotEmpty(list) && x.isNotNull(this.B) && (editVo = this.F.getEditVo(list)) != null) {
            String tipMsg = editVo.getTipMsg();
            if (!x.isNullStr(tipMsg)) {
                G0(tipMsg);
                return;
            }
            AlertListFragment alertListFragment = AlertListFragment.getInstance(editVo.getList(), x.getString(R.string.title_info_confirm));
            alertListFragment.setIAlertListClickListener(this.H);
            d(alertListFragment, R.id.flayout_content);
        }
    }
}
