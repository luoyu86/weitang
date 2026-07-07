package com.chinavisionary.microtang.contract.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.g.n;
import c.e.c.j0.c.c;
import c.k.a.a;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.model.UploadModel;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractLiveTogetherVo;
import com.chinavisionary.microtang.contract.vo.ContractTogetherLiveVo;
import com.chinavisionary.microtang.contract.vo.UpdateTogetherLiveBo;
import com.chinavisionary.microtang.room.vo.CheckTogetherVo;
import com.chinavisionary.microtang.sign.adapter.RoomSignMainInfoAdapter;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractLiveTogetherFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public boolean B;
    public ContractModel C;
    public UploadModel D;
    public int E;
    public int F;
    public boolean G = true;
    public c H;

    @BindView(R.id.tv_title_right)
    public TextView mRightTv;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(View view, View view2) {
        if (view2.getId() == R.id.tv_alert_confirm) {
            int iIntValue = ((Integer) view.getTag(R.id.id_room_sign_id_del_position)).intValue();
            int iIntValue2 = ((Integer) view.getTag(view.getId())).intValue();
            List list = (List) ((LeftTitleToRightArrowVo) this.t.getList().get(iIntValue)).getExtObj();
            list.remove(iIntValue2);
            list.add(iIntValue2, new ContactDetailsVo.RoommatesBean());
            this.t.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(ContractLiveTogetherVo contractLiveTogetherVo) {
        c2();
        if (contractLiveTogetherVo != null) {
            I1(contractLiveTogetherVo.getRoommates(), contractLiveTogetherVo.getMaxRoommateNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P1(ResponseStateVo responseStateVo) {
        c2();
        if (F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed)) {
            j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R1(RequestErrDto requestErrDto) {
        c2();
        C(requestErrDto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T1(UploadResponseDto uploadResponseDto) {
        H();
        updateUploadIDKey(uploadResponseDto);
    }

    public static ContractLiveTogetherFragment getInstance(String str) {
        ContractLiveTogetherFragment contractLiveTogetherFragment = new ContractLiveTogetherFragment();
        contractLiveTogetherFragment.setArguments(CoreBaseFragment.q(str));
        return contractLiveTogetherFragment;
    }

    public final List<ContactDetailsVo.RoommatesBean> E1(List<ContractTogetherLiveVo> list, int i2) {
        ArrayList arrayList = new ArrayList();
        int size = list == null ? 0 : list.size();
        for (int i3 = 0; i3 < size; i3++) {
            ContractTogetherLiveVo contractTogetherLiveVo = list.get(i3);
            ContactDetailsVo.RoommatesBean roommatesBean = new ContactDetailsVo.RoommatesBean();
            roommatesBean.setName(contractTogetherLiveVo.getName());
            roommatesBean.setPhone(contractTogetherLiveVo.getPhone());
            roommatesBean.setIdCardNo(contractTogetherLiveVo.getIdCardNo());
            roommatesBean.setIdCardBackKey(contractTogetherLiveVo.getIdCardBack());
            roommatesBean.setIdCardFrontKey(contractTogetherLiveVo.getIdCardFront());
            ResourceVo idCardBackResourceVo = contractTogetherLiveVo.getIdCardBackResourceVo();
            ResourceVo idCardFrontResourceVo = contractTogetherLiveVo.getIdCardFrontResourceVo();
            if (idCardBackResourceVo != null) {
                roommatesBean.setIdCardBack(idCardBackResourceVo.getUrl());
            }
            if (idCardFrontResourceVo != null) {
                roommatesBean.setIdCardFront(idCardFrontResourceVo.getUrl());
            }
            arrayList.add(roommatesBean);
        }
        int i4 = i2 - size;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(new ContactDetailsVo.RoommatesBean());
            }
        }
        return arrayList;
    }

    public final void F1(View view) {
        a2(view);
        d2(false, null);
    }

    public final void G1(View view) {
        a2(view);
        d2(true, null);
    }

    public final void H1(final View view) {
        n.getInstance().showAlert(this.f6487e, x.getString(R.string.title_alert_tip), x.getString(R.string.tip_alert_content_clear_together_confirm), x.getString(R.string.title_confirm), x.getString(R.string.title_think), new View.OnClickListener() { // from class: c.e.c.o.c.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f1752a.L1(view, view2);
            }
        });
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void I1(List<ContractTogetherLiveVo> list, int i2) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setType(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        leftTitleToRightArrowVo.setEdit(this.G);
        leftTitleToRightArrowVo.setExtObj(E1(list, i2));
        arrayList.add(leftTitleToRightArrowVo);
        this.t.initListData(arrayList);
    }

    public final void U1(View view) {
        a2(view);
        X1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
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
                this.B = true;
                U1(view);
                break;
            case R.id.img_id_face /* 2131231234 */:
                this.B = false;
                V1(view);
                break;
            case R.id.tv_alert_camera /* 2131231940 */:
                c.r.a.a.c.create(this).openCamera(this.B ? 2 : 1);
                break;
            case R.id.tv_alert_photo_select /* 2131231944 */:
                W1(this.B ? 2 : 1);
                break;
            case R.id.tv_title_right /* 2131232481 */:
                Y1();
                break;
        }
    }

    public final void V1(View view) {
        a2(view);
        X1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_together_live);
        this.mRightTv.setVisibility(this.G ? 0 : 8);
        this.mRightTv.setText(R.string.title_save);
        this.mRightTv.setOnClickListener(this.y);
        a.getInstance().setSelectLimit(1);
        this.H = new c();
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        RoomSignMainInfoAdapter roomSignMainInfoAdapter = new RoomSignMainInfoAdapter();
        this.t = roomSignMainInfoAdapter;
        roomSignMainInfoAdapter.setOnClickListener(this.y);
        Z1();
        b2();
        z0(R.string.loading_text);
        j0();
    }

    public final void W1(int i2) {
        startActivityForResult(new Intent(this.f6487e, (Class<?>) ImageGridActivity.class), i2);
    }

    public final void X1() {
        n.getInstance().showAlertPhoto(this.f6487e, this.y);
    }

    public final void Y1() {
        List<ContactDetailsVo.RoommatesBean> list = (List) ((LeftTitleToRightArrowVo) this.t.getList().get(this.t.getList().size() - 1)).getExtObj();
        c cVar = this.H;
        if (cVar != null) {
            CheckTogetherVo checkTogetherVoIsAddTogetherInfo = cVar.isAddTogetherInfo(list);
            if (!checkTogetherVoIsAddTogetherInfo.isAddTogether()) {
                z0(R.string.tip_submit_data_loading);
                f2(list);
            } else {
                if (!x.isNullStr(checkTogetherVoIsAddTogetherInfo.getTipMsg())) {
                    G0(checkTogetherVoIsAddTogetherInfo.getTipMsg());
                    return;
                }
                List<File> idCardFile = this.H.getIdCardFile(list);
                if (idCardFile == null || idCardFile.isEmpty()) {
                    updateUploadIDKey(null);
                } else {
                    z0(R.string.tip_submit_data_loading);
                    this.D.uploadPicList(idCardFile);
                }
            }
        }
    }

    public final void Z1() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.C = contractModel;
        contractModel.getContractTogetherLiveList().observe(this, new Observer() { // from class: c.e.c.o.c.i0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1750a.N1((ContractLiveTogetherVo) obj);
            }
        });
        this.C.getRequestResult().observe(this, new Observer() { // from class: c.e.c.o.c.k0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1755a.P1((ResponseStateVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.g0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1746a.R1((RequestErrDto) obj);
            }
        });
    }

    public final void a2(View view) {
        this.E = ((Integer) view.getTag(R.id.id_room_sign_id_card_position)).intValue();
        this.F = ((Integer) view.getTag(view.getId())).intValue();
    }

    public final void b2() {
        UploadModel uploadModel = (UploadModel) h(UploadModel.class);
        this.D = uploadModel;
        uploadModel.getUploadResponseDtoMutableLive().observe(this, new Observer() { // from class: c.e.c.o.c.h0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1748a.T1((UploadResponseDto) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.f0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1744a.C((RequestErrDto) obj);
            }
        });
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        n();
    }

    public final void c2() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    public final void d2(boolean z, String str) {
        i("path :" + str);
        List list = (List) ((LeftTitleToRightArrowVo) this.t.getList().get(this.E)).getExtObj();
        if (z) {
            ((ContactDetailsVo.RoommatesBean) list.get(this.F)).setIdCardFront(str);
        } else {
            ((ContactDetailsVo.RoommatesBean) list.get(this.F)).setIdCardBack(str);
        }
        this.t.notifyDataSetChanged();
    }

    public final void e2(String str, boolean z) {
        c cVar = this.H;
        if (cVar != null) {
            d2(z, cVar.renameFile(str));
        }
    }

    public final void f2(List<ContactDetailsVo.RoommatesBean> list) {
        if (this.H != null) {
            UpdateTogetherLiveBo updateTogetherLiveBo = new UpdateTogetherLiveBo();
            updateTogetherLiveBo.setContractKey(this.f6484b);
            updateTogetherLiveBo.setRoommates(this.H.getUpdateTogetherLiveBoRoommatesBean(list));
            this.C.saveContractTogetherLiveList(this.f6484b, updateTogetherLiveBo);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getContractTogetherLiveList(this.f6484b);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == 17) {
            String imagePath = c.r.a.a.c.getImagePath(intent);
            if (TextUtils.isEmpty(imagePath)) {
                return;
            }
            if (i2 == 1) {
                e2(imagePath, true);
                return;
            } else {
                if (i2 == 2) {
                    e2(imagePath, false);
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
        d2(z, ((ImageItem) arrayList.get(0)).path);
    }

    public void setEdit(boolean z) {
        this.G = z;
    }

    public void updateUploadIDKey(UploadResponseDto uploadResponseDto) {
        z0(R.string.tip_save_data_loading);
        List<ContactDetailsVo.RoommatesBean> list = (List) ((LeftTitleToRightArrowVo) this.t.getList().get(this.t.getList().size() - 1)).getExtObj();
        if (uploadResponseDto != null && list != null) {
            List<ResponseUploadImgVo> uploadSuccessList = uploadResponseDto.getUploadSuccessList();
            int size = uploadSuccessList.size();
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ContactDetailsVo.RoommatesBean roommatesBean = list.get(i2);
                if (roommatesBean != null) {
                    String idCardFront = roommatesBean.getIdCardFront();
                    String idCardBack = roommatesBean.getIdCardBack();
                    File file = x.isNotNull(idCardFront) ? new File(idCardFront) : null;
                    File file2 = x.isNotNull(idCardBack) ? new File(idCardBack) : null;
                    for (int i3 = 0; i3 < size; i3++) {
                        ResponseUploadImgVo responseUploadImgVo = uploadSuccessList.get(i3);
                        if (responseUploadImgVo != null) {
                            String originalName = responseUploadImgVo.getOriginalName();
                            if (originalName != null && file2 != null && (file2.getName().equals(originalName) || originalName.indexOf(file2.getName()) == 0)) {
                                list.get(i2).setIdCardBackKey(responseUploadImgVo.getKey());
                            } else if (originalName != null && file != null && (file.getName().equals(originalName) || originalName.indexOf(file.getName()) == 0)) {
                                list.get(i2).setIdCardFrontKey(responseUploadImgVo.getKey());
                            }
                        }
                    }
                }
            }
        }
        f2(list);
    }
}
