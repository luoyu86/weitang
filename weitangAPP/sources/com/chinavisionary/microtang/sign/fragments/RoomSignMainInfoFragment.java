package com.chinavisionary.microtang.sign.fragments;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.g.n;
import c.e.c.j0.b.v;
import c.e.c.j0.c.c;
import c.e.c.j0.c.d;
import c.k.a.a;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.model.UploadModel;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.EventUpdateContractList;
import com.chinavisionary.microtang.contract.vo.ResponseSignMainInfoVo;
import com.chinavisionary.microtang.contract.vo.SignMainInfoVo;
import com.chinavisionary.microtang.contract.vo.UpdateContractEventVo;
import com.chinavisionary.microtang.room.vo.CheckTogetherVo;
import com.chinavisionary.microtang.sign.adapter.RoomSignMainInfoAdapter;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.autosize.internal.CustomAdapt;

/* JADX INFO: loaded from: classes2.dex */
public class RoomSignMainInfoFragment extends BaseFragment<LeftTitleToRightArrowVo> implements CustomAdapt {
    public int B;
    public int C;
    public int D = 0;
    public boolean E;
    public int F;
    public String G;
    public Long H;
    public Long I;
    public boolean J;
    public String K;
    public UploadModel L;
    public ContractModel M;
    public SignMainInfoVo N;
    public boolean O;
    public String P;
    public Boolean Q;
    public Long R;
    public c S;

    @BindView(R.id.recycler_view_sign_main_info)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(View view, View view2) {
        if (view2.getId() == R.id.tv_alert_confirm) {
            E1(view);
        }
    }

    public static RoomSignMainInfoFragment getInstance(String str) {
        RoomSignMainInfoFragment roomSignMainInfoFragment = new RoomSignMainInfoFragment();
        roomSignMainInfoFragment.setArguments(CoreBaseFragment.q(str));
        return roomSignMainInfoFragment;
    }

    public final void E1(View view) {
        int iIntValue = ((Integer) view.getTag(R.id.id_room_sign_id_del_position)).intValue();
        int iIntValue2 = ((Integer) view.getTag(view.getId())).intValue();
        List list = (List) ((LeftTitleToRightArrowVo) this.t.getList().get(iIntValue)).getExtObj();
        list.remove(iIntValue2);
        list.add(iIntValue2, new ContactDetailsVo.RoommatesBean());
        this.t.notifyDataSetChanged();
    }

    public final void F1(View view) {
        c2(view);
        g2(false, null);
    }

    public final void G1(View view) {
        c2(view);
        g2(true, null);
    }

    public final void H1(final View view) {
        n.getInstance().showAlert(this.f6487e, x.getString(R.string.title_alert_tip), x.getString(R.string.tip_alert_content_clear_together_info), x.getString(R.string.title_confirm), x.getString(R.string.title_think), new View.OnClickListener() { // from class: c.e.c.j0.b.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f1620a.N1(view, view2);
            }
        });
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void I1(ResponseSignMainInfoVo responseSignMainInfoVo) {
        if (responseSignMainInfoVo != null) {
            this.D = responseSignMainInfoVo.getMaxRoommateNumber();
            this.t.initListData((List<T>) this.S.getAdapterData(responseSignMainInfoVo));
        }
        f2(null);
    }

    public final void J1(ResponseStateVo responseStateVo) {
        boolean zF = F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed);
        this.O = zF;
        if (zF) {
            k(new UpdateContractEventVo());
            String key = responseStateVo.getKey();
            this.G = key;
            if (x.isNotNull(key)) {
                V1();
            } else {
                F0(R.string.title_response_contract_key_is_empty);
            }
        }
    }

    public final void K1() {
        this.mTitleTv.setText(R.string.title_sign_main_info);
        a.getInstance().setSelectLimit(1);
        this.S = new c();
    }

    public final void R1(View view) {
        c2(view);
        U1();
    }

    public final void S1(View view) {
        c2(view);
        U1();
    }

    public final void T1(int i2) {
        startActivityForResult(new Intent(this.f6487e, (Class<?>) ImageGridActivity.class), i2);
    }

    public final void U1() {
        n.getInstance().showAlertPhoto(this.f6487e, this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (M0(view)) {
            switch (view.getId()) {
                case R.id.btn_del_together /* 2131230868 */:
                    H1(view);
                    break;
                case R.id.img_del_back /* 2131231222 */:
                    F1(view);
                    break;
                case R.id.img_del_face /* 2131231224 */:
                    G1(view);
                    break;
                case R.id.img_id_back /* 2131231233 */:
                    this.E = true;
                    R1(view);
                    break;
                case R.id.img_id_face /* 2131231234 */:
                    this.E = false;
                    S1(view);
                    break;
                case R.id.tv_alert_camera /* 2131231940 */:
                    c.r.a.a.c.create(this).openCamera(this.E ? 2 : 1);
                    break;
                case R.id.tv_alert_photo_select /* 2131231944 */:
                    T1(this.E ? 2 : 1);
                    break;
            }
        }
    }

    public final void V1() {
        k(new EventUpdateContractList());
        RoomSignContractNearbyFragment roomSignContractNearbyFragment = RoomSignContractNearbyFragment.getInstance(this.G);
        roomSignContractNearbyFragment.setKeepRent(this.J);
        K0(roomSignContractNearbyFragment, R.id.flayout_content);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        K1();
        d2();
        e2();
        b2();
        z0(R.string.loading_text);
        j0();
    }

    public final void W1(SignMainInfoVo signMainInfoVo) {
        signMainInfoVo.setAssetKey(this.f6484b);
        if (x.isNotNull(this.G)) {
            signMainInfoVo.setContractKey(this.G);
        }
        if (x.isNotNull(this.P)) {
            signMainInfoVo.setPreContractKey(this.P);
            signMainInfoVo.setChangeRentFlag(Boolean.TRUE);
            if (this.R.longValue() != -1) {
                signMainInfoVo.setEstimateRentbackTime(this.R);
            }
        }
        if (x.isNotNull(this.K)) {
            signMainInfoVo.setSigningCode(this.K);
        }
        Long l = this.I;
        if (l != null) {
            signMainInfoVo.setSelectedCheckinCleaningDate(l);
        }
        signMainInfoVo.setPaymentMethod(this.F);
        if (this.N == null) {
            this.N = signMainInfoVo;
        }
        this.M.saveSignMain(signMainInfoVo);
    }

    public final void X1(SignMainInfoVo signMainInfoVo) {
        Long l = this.H;
        if (l != null) {
            signMainInfoVo.setRentTermTo(l);
        }
        signMainInfoVo.setRenewalFlag(this.J);
        if (this.N == null || !this.O) {
            W1(signMainInfoVo);
            return;
        }
        if (JSON.toJSONString(this.N).equals(JSON.toJSONString(signMainInfoVo))) {
            V1();
        } else {
            W1(signMainInfoVo);
        }
    }

    public void Y1(Long l) {
        this.I = l;
    }

    public void Z1(int i2) {
        this.F = i2;
    }

    public void a2(Long l) {
        this.H = l;
    }

    public final void b2() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.M = contractModel;
        contractModel.getSignMainInfo().observe(this, new Observer() { // from class: c.e.c.j0.b.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1618a.I1((ResponseSignMainInfoVo) obj);
            }
        });
        this.M.getRequestResult().observe(this, new Observer() { // from class: c.e.c.j0.b.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1619a.J1((ResponseStateVo) obj);
            }
        });
        this.M.getErrRequestLiveData().observe(this, new v(this));
    }

    public final void c2(View view) {
        this.B = ((Integer) view.getTag(R.id.id_room_sign_id_card_position)).intValue();
        this.C = ((Integer) view.getTag(view.getId())).intValue();
    }

    @OnClick({R.id.btn_confirm})
    public void confirmClick(View view) {
        if (M0(view)) {
            CheckTogetherVo submitMsg = this.S.getSubmitMsg(this.t.getList());
            if (submitMsg.isAddTogether()) {
                G0(submitMsg.getTipMsg());
            } else {
                j2(submitMsg.getSignMainInfoVo());
            }
        }
    }

    public final void d2() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        RoomSignMainInfoAdapter roomSignMainInfoAdapter = new RoomSignMainInfoAdapter();
        this.t = roomSignMainInfoAdapter;
        roomSignMainInfoAdapter.setOnClickListener(this.y);
        this.t.addHeadView(d.getInstance().getAdapterHeadView(this.f6487e, 1));
    }

    public final void e2() {
        UploadModel uploadModel = (UploadModel) h(UploadModel.class);
        this.L = uploadModel;
        uploadModel.getUploadResponseDtoMutableLive().observe(this, new Observer() { // from class: c.e.c.j0.b.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1622a.i2((UploadResponseDto) obj);
            }
        });
        this.L.getErrRequestLiveData().observe(this, new v(this));
    }

    public final void f2(RequestErrDto requestErrDto) {
        C(requestErrDto);
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @OnClick({R.id.tv_back})
    public void finishFragment(View view) {
        n();
    }

    public final void g2(boolean z, String str) {
        i("path :" + str);
        List list = (List) ((LeftTitleToRightArrowVo) this.t.getList().get(this.B)).getExtObj();
        if (z) {
            ((ContactDetailsVo.RoommatesBean) list.get(this.C)).setIdCardFront(str);
        } else {
            ((ContactDetailsVo.RoommatesBean) list.get(this.C)).setIdCardBack(str);
        }
        this.t.notifyDataSetChanged();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_room_sign_main_info;
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        return 360.0f;
    }

    public final void h2(String str, boolean z) {
        g2(z, this.S.renameFile(str));
    }

    public final void i2(UploadResponseDto uploadResponseDto) {
        try {
            this.S.updateUploadIDKey(uploadResponseDto, (LeftTitleToRightArrowVo) this.t.getList().get(this.t.getList().size() - 1));
            X1(this.S.getSubmitMsg(this.t.getList()).getSignMainInfoVo());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.M.getSignMain(this.G, this.f6484b);
    }

    public final void j2(SignMainInfoVo signMainInfoVo) {
        if (!(this.D > 0)) {
            z0(R.string.tip_submit_data_loading);
            X1(signMainInfoVo);
            return;
        }
        List<ContactDetailsVo.RoommatesBean> list = (List) ((LeftTitleToRightArrowVo) this.t.getList().get(this.t.getList().size() - 1)).getExtObj();
        CheckTogetherVo checkTogetherVoIsAddTogetherInfo = this.S.isAddTogetherInfo(list);
        i("uploadTogetherIDCard isAddTogether :" + checkTogetherVoIsAddTogetherInfo.isAddTogether());
        if (!checkTogetherVoIsAddTogetherInfo.isAddTogether()) {
            z0(R.string.tip_submit_data_loading);
            X1(signMainInfoVo);
        } else {
            if (!x.isNullStr(checkTogetherVoIsAddTogetherInfo.getTipMsg())) {
                G0(checkTogetherVoIsAddTogetherInfo.getTipMsg());
                return;
            }
            List<File> idCardFile = this.S.getIdCardFile(list);
            if (idCardFile == null || idCardFile.isEmpty()) {
                return;
            }
            z0(R.string.tip_submit_data_loading);
            this.L.uploadPicList(idCardFile);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == 17) {
            String imagePath = c.r.a.a.c.getImagePath(intent);
            if (TextUtils.isEmpty(imagePath)) {
                return;
            }
            if (i2 == 1) {
                h2(imagePath, true);
                return;
            } else {
                if (i2 == 2) {
                    h2(imagePath, false);
                    return;
                }
                return;
            }
        }
        if (i3 != 1004 || intent == null) {
            return;
        }
        boolean z = i2 == 1;
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("extra_result_items");
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        g2(z, ((ImageItem) arrayList.get(0)).path);
    }

    public void setContractKey(String str) {
        this.G = str;
    }

    public void setContractKeyAndIsChangeRent(String str, Boolean bool, Long l) {
        this.P = str;
        this.Q = bool;
        this.R = l;
    }

    public void setKeepRent(boolean z) {
        this.J = z;
    }
}
