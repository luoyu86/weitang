package com.chinavisionary.microtang.me.fragment;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.x.e.d0;
import c.e.c.x.e.e0;
import c.e.c.x.e.f0;
import c.r.a.a.c;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.model.AuthModel;
import com.chinavisionary.microtang.auth.vo.RequestIDCardBo;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.fragment.IDFragment;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.me.vo.NameValueVo;
import com.chinavisionary.microtang.me.vo.UserIDCardVo;
import com.chinavisionary.microtang.me.vo.WorkAddressVo;
import com.chinavisionary.microtang.web.event.EventReloadWebView;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import g.b.a.m;
import g.b.a.r;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.autosize.internal.CancelAdapt;

/* JADX INFO: loaded from: classes.dex */
public class IDFragment extends BaseFragment<LeftTitleToRightArrowVo> implements CancelAdapt {
    public int B;
    public AuthModel C;
    public UserOperateModel D;
    public RequestIDCardBo E;
    public UploadResponseDto F;
    public d0 G;
    public e0 H;
    public final c.e.a.a.c.c.a I = new a();
    public final f0 J = new b();

    @BindView(R.id.recycler)
    public BaseRecyclerView mRecyclerView;

    @BindView(R.id.btn_next)
    public AppCompatButton mSubmitBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            IDFragment.this.B = i2;
            IDFragment.this.H.showOptionToOnlyKey(((LeftTitleToRightArrowVo) IDFragment.this.t.getList().get(i2)).getOnlyKey());
        }
    }

    public class b implements f0 {
        public b() {
        }

        @Override // c.e.c.x.e.f0
        public Activity getCurrentContext() {
            return IDFragment.this.f6487e;
        }

        @Override // c.e.c.x.e.f0
        public void openIDCardCamera(int i2) {
            c.create(IDFragment.this).openCamera(i2);
        }

        @Override // c.e.c.x.e.f0
        public void openImageGridActivity(int i2) {
            IDFragment.this.startActivityForResult(new Intent(IDFragment.this.f6487e, (Class<?>) ImageGridActivity.class), i2);
        }

        @Override // c.e.c.x.e.f0
        public void showToast(int i2) {
            IDFragment.this.F0(i2);
        }

        @Override // c.e.c.x.e.f0
        public void updateSelectIdType(NameValueVo nameValueVo) {
            IDFragment.this.B = 1;
            IDFragment.this.q2(nameValueVo.getName());
        }

        @Override // c.e.c.x.e.f0
        public void updateSelectOptionName(String str) {
            IDFragment.this.q2(str);
        }

        @Override // c.e.c.x.e.f0
        public void uploadFile(List<File> list) {
            if (IDFragment.this.H.isUnselectedEduMarriage()) {
                return;
            }
            IDFragment.this.z0(R.string.tip_uploading);
            IDFragment.this.C.uploadFile(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c2(ResponseRowsVo responseRowsVo) {
        this.H.setupEduVos(responseRowsVo, this.t.getList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e2(ResponseRowsVo responseRowsVo) {
        this.H.setupMarriages(responseRowsVo, this.t.getList());
    }

    public static /* synthetic */ void f2(ResponseRowsVo responseRowsVo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h2(ResponseRowsVo responseRowsVo) {
        this.H.setupPolitical(responseRowsVo, this.t.getList());
    }

    public static IDFragment getInstance() {
        return new IDFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j2(ResponseRowsVo responseRowsVo) {
        if (L()) {
            return;
        }
        this.H.setupIDTypeVos(responseRowsVo, this.t.getList());
    }

    public final void N1() {
        UploadResponseDto uploadResponseDto;
        RequestIDCardBo requestIDCardBo = this.E;
        if (requestIDCardBo != null && (uploadResponseDto = this.F) != null) {
            T0(requestIDCardBo, uploadResponseDto, this.G.getIDHeadImageVo());
        }
        A1(x.getString(R.string.tip_auth_failed_retry_camera));
    }

    public final void O1(ResponseStateVo responseStateVo) {
        if (!F(responseStateVo, R.string.tip_auth_success, R.string.tip_auth_failed)) {
            N1();
            return;
        }
        k(new EventReloadWebView());
        this.mSubmitBtn.setText(R.string.title_save_update);
        r2();
    }

    public final void P1() {
        z0(R.string.tip_get_id_card_info);
        UserInfoVo userInfoVoW = w();
        userInfoVoW.setValidate(true);
        m0(JSON.toJSONString(userInfoVoW));
        g.b.a.c.getDefault().post(new EventUpdateUserInfoVo());
        this.C.getUserIDInfo();
    }

    public final void Q1(ResponseStateVo responseStateVo) {
        H();
        if (L()) {
            F(responseStateVo, R.string.tip_update_success, R.string.tip_update_failed);
        } else {
            P1();
        }
    }

    public final void R1(String str) {
        H();
        U1(str);
        this.C.getMarriageList();
        if (c.e.a.a.a.getInstance().isDebug()) {
            this.C.getIDTypeList();
        }
        this.C.getPoliticalList();
        this.C.getEductionList();
        this.D.getWorkAddressUrl();
        this.mSubmitBtn.setVisibility(0);
    }

    public final void S1(ResponseRowsVo<WorkAddressVo> responseRowsVo) {
        this.H.setupWorkAddressList(responseRowsVo, this.t.getList());
    }

    public final void T1(UploadResponseDto uploadResponseDto) {
        H();
        z0(R.string.tip_auth_loading);
        this.F = uploadResponseDto;
        RequestIDCardBo requestIDCardBo = this.C.setupImageKey(uploadResponseDto, this.G.getIDHeadImageVo());
        this.E = requestIDCardBo;
        requestIDCardBo.setType(this.H.getSelectIdCardType());
        this.C.userAuth(this.E);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void U1(String str) {
        UserIDCardVo userIDCardVo;
        boolean zL = L();
        if (x.isNotNull(str)) {
            userIDCardVo = (UserIDCardVo) JSON.parseObject(j(str), UserIDCardVo.class);
        } else {
            userIDCardVo = new UserIDCardVo();
            userIDCardVo.setPhone(s());
        }
        if (zL) {
            this.t.removeHeadView();
        }
        this.t.initListData((List<T>) this.C.getList(userIDCardVo, zL));
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    public final void V1() {
        h0(this);
        this.mTitleTv.setText(R.string.title_id_info);
        c.k.a.a.getInstance().setSelectLimit(1);
        this.mSubmitBtn.setText(L() ? R.string.title_save_update : R.string.title_submit_auth);
        this.r = this.mRecyclerView;
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        this.t = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.setOnItemClickListener(this.I);
        this.G = new d0(this.J);
        this.H = new e0(this.J);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        if (c.e.a.a.a.getInstance().isH5Model()) {
            m();
            q1();
            return;
        }
        V1();
        o2();
        n2();
        m2();
        I1();
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_id;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        z0(R.string.tip_get_id_card_info);
        this.C.getUserIDInfo();
    }

    public final void l2(String str, boolean z) {
        this.G.loadImageToFile(str, z);
    }

    public final void m2() {
        boolean zL = L();
        View adapterHeadView = this.G.getAdapterHeadView(zL);
        if (zL) {
            return;
        }
        this.t.addHeadView(adapterHeadView);
    }

    public final void n2() {
        AuthModel authModel = (AuthModel) h(AuthModel.class);
        this.C = authModel;
        authModel.getUploadResponseDtoMutableLive().observe(this, new Observer() { // from class: c.e.c.x.d.e0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2038a.T1((UploadResponseDto) obj);
            }
        });
        this.C.getResultMutableLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.b0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2026a.O1((ResponseStateVo) obj);
            }
        });
        this.C.getEduList().observe(this, new Observer() { // from class: c.e.c.x.d.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2105a.c2((ResponseRowsVo) obj);
            }
        });
        this.C.getMarriageResultList().observe(this, new Observer() { // from class: c.e.c.x.d.c0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2030a.e2((ResponseRowsVo) obj);
            }
        });
        this.C.getWorkAddressResultList().observe(this, new Observer() { // from class: c.e.c.x.d.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IDFragment.f2((ResponseRowsVo) obj);
            }
        });
        this.C.getPoliticalResultList().observe(this, new Observer() { // from class: c.e.c.x.d.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2109a.h2((ResponseRowsVo) obj);
            }
        });
        this.C.getIDTypeResultList().observe(this, new Observer() { // from class: c.e.c.x.d.a0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2022a.j2((ResponseRowsVo) obj);
            }
        });
        this.C.getIDCardData().observe(this, new Observer() { // from class: c.e.c.x.d.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2112a.R1((String) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new c.e.c.x.d.f0(this));
    }

    @OnClick({R.id.btn_next})
    public void nextClick() {
        if (L()) {
            r2();
        } else {
            this.G.handlerSubmitAuth();
        }
    }

    public final void o2() {
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.D = userOperateModel;
        userOperateModel.getResultMutableLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2118a.Q1((ResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new c.e.c.x.d.f0(this));
        this.D.getWorkAddressItemList().observe(this, new Observer() { // from class: c.e.c.x.d.d0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2034a.S1((ResponseRowsVo) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == 17) {
            String imagePath = c.getImagePath(intent);
            if (TextUtils.isEmpty(imagePath)) {
                return;
            }
            p2(imagePath, i2 == 1);
            return;
        }
        if (i3 != 1004 || intent == null) {
            return;
        }
        boolean z = i2 == 1;
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("extra_result_items");
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        l2(((ImageItem) arrayList.get(0)).path, z);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    public final void p2(String str, boolean z) {
        l2(this.C.renameFile(str), z);
    }

    public final void q2(String str) {
        ((LeftTitleToRightArrowVo) this.t.getList().get(this.B)).setRight(str);
        this.t.notifyDataSetChanged();
    }

    public final void r2() {
        if (this.H.isUnselectedEduMarriage()) {
            return;
        }
        z0(R.string.tip_save_data_loading);
        this.D.updateUserIdInfo(this.H.getUpdateUserIdBo(this.t.getList()));
    }

    @m(threadMode = r.MAIN)
    public void setupUserCameraImg(c.e.a.b.a.g.a aVar) {
        String path = aVar.getPath();
        if (x.isNullStr(path)) {
            F0(R.string.tip_auth_own_photo_is_empty);
            return;
        }
        q.d(getClass().getSimpleName(), "ownPhoto :" + path);
        this.G.setupOwnPhoto(path);
    }
}
