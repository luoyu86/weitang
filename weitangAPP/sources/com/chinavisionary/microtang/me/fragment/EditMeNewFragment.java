package com.chinavisionary.microtang.me.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.c0.d;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.g.n;
import c.e.c.x.d.i;
import c.e.c.x.d.k;
import c.e.c.x.d.o;
import c.e.c.x.d.p;
import c.e.c.x.e.c0;
import c.e.e.a.x.f;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.dialog.AlertParamVo;
import com.chinavisionary.core.app.event.EventUpdateToken;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.framework.mobile.user.param.NewUpdateAppUserInfoParam;
import com.chinavisionary.framework.mobile.user.param.UpdateAppUserInfoParam;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.me.CancelAccountActivity;
import com.chinavisionary.microtang.me.bo.CancelAccountBo;
import com.chinavisionary.microtang.me.bo.CancelAccountReasonBo;
import com.chinavisionary.microtang.me.bo.NewUpdateDeviceIdVo;
import com.chinavisionary.microtang.me.bo.UpdateDeviceIdVo;
import com.chinavisionary.microtang.me.event.EventCancelAccountSuccess;
import com.chinavisionary.microtang.me.event.EventUpdateNickName;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.model.UserModel;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import g.b.a.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EditMeNewFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public static final Long B = 2000L;
    public CoreRoundedImageView C;
    public TextView D;
    public TextView E;
    public String F;
    public UserModel G;
    public UserOperateModel H;
    public NewUserModel I;
    public NewUserOperateModel J;
    public boolean K;
    public c0 L;
    public final c.e.a.a.c.c.a M = new c.e.a.a.c.c.a() { // from class: c.e.c.x.d.n
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2073a.Z1(view, i2);
        }
    };
    public final c.e.c.x.b.b N = new a();

    @BindView(R.id.btn_submit)
    public AppCompatButton mExitBtn;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title_right)
    public TextView mTitleRightTv;

    @BindView(R.id.tv_title_split_line)
    public TextView mTitleSplitLineTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.e.c.x.b.b {
        public a() {
        }

        @Override // c.e.c.x.b.b
        public void doUpdateNickName(String str) {
            EditMeNewFragment.this.r2(str);
        }

        @Override // c.e.c.x.b.b
        public void onSuccess(String str) {
            EditMeNewFragment.this.D.setText(str);
        }
    }

    public class b implements c.e.a.a.c.c.b {
        public b() {
        }

        @Override // c.e.a.a.c.c.b
        public void onChangeResult(int i2, boolean z) {
            String left = ((LeftTitleToRightArrowVo) EditMeNewFragment.this.t.getList().get(i2)).getLeft();
            q.d(EditMeNewFragment.this.f6485c, "onChangeResult position = " + i2 + ", isCheck = " + z + ",title = " + left);
            f.setScan(z);
            w.getInstance().putBoolean("ble_scan", z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W1(View view) {
        if (view.getId() == R.id.tv_alert_confirm) {
            c2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(View view, int i2) {
        if (i2 >= 0) {
            Q1(i2);
        }
    }

    public static EditMeNewFragment getInstance() {
        return new EditMeNewFragment();
    }

    public final void I1() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeMessages(2098);
            this.f6488f.sendEmptyMessageDelayed(2098, B.longValue());
        }
    }

    public final void J1() {
        z0(R.string.tip_logout_load);
        I1();
        String string = w.getInstance().getString("device_id_key", null);
        if (x.isNotNull(string)) {
            new UpdateDeviceIdVo().setDeviceid(string);
        }
        if (this.I != null) {
            NewUpdateDeviceIdVo newUpdateDeviceIdVo = new NewUpdateDeviceIdVo();
            newUpdateDeviceIdVo.setDeviceid(string);
            this.I.doLogout(newUpdateDeviceIdVo);
        }
    }

    public final void K1(View view) {
        if (this.K) {
            this.K = false;
            String str = (String) view.getTag();
            z0(R.string.tip_submit_data_loading);
            CancelAccountBo cancelAccountBo = new CancelAccountBo();
            if (x.isNotNull(str)) {
                cancelAccountBo.setReason(str);
            }
            NewUserOperateModel newUserOperateModel = this.J;
            if (newUserOperateModel != null) {
                newUserOperateModel.cancelAccount(cancelAccountBo);
                return;
            } else {
                this.H.cancelAccount(cancelAccountBo);
                return;
            }
        }
        if (view.getTag() == null) {
            J1();
            return;
        }
        try {
            int i2 = Integer.parseInt(((String) view.getTag()).trim());
            if (i2 <= 0) {
                F0(R.string.tip_not_less_zero);
                return;
            }
            if (i2 > 10) {
                F0(R.string.tip_max_splash_time);
                i2 = 10;
            }
            ((LeftTitleToRightArrowVo) this.t.getList().get(3)).setRight(i2 + "S");
            this.t.notifyDataSetChanged();
            X0(i2);
            w.getInstance().putInt("ad_time_key", i2);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            F0(R.string.tip_input_number);
        }
    }

    public final void L1(ResponseStateVo responseStateVo) {
        H();
        F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed);
    }

    public final void M1(String str) {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeMessages(2098);
        }
        w.getInstance().clear();
        i2();
        EventUpdateUserInfoVo eventUpdateUserInfoVo = new EventUpdateUserInfoVo();
        eventUpdateUserInfoVo.setWhatMsg(1);
        k(eventUpdateUserInfoVo);
        k(new EventUpdateToken());
        k(new UserSimpleDto());
        n();
    }

    public final void N1(CancelAccountReasonBo cancelAccountReasonBo) {
        c.e.c.x.c.b.initCancelAccountReasonBo(cancelAccountReasonBo);
    }

    public final void O1(ResponseStateVo responseStateVo) {
        H();
        if (responseStateVo == null || !responseStateVo.isSuccess()) {
            return;
        }
        F0(R.string.tip_update_success);
        EventUpdateNickName eventUpdateNickName = new EventUpdateNickName();
        eventUpdateNickName.setSuccess(true);
        k(eventUpdateNickName);
        k(new EventUpdateUserInfoVo());
    }

    public final void P1(UploadResponseDto uploadResponseDto) {
        if (uploadResponseDto == null) {
            F0(R.string.tip_update_failed);
            return;
        }
        List<ResponseUploadImgVo> uploadSuccessList = uploadResponseDto.getUploadSuccessList();
        if (uploadSuccessList == null || uploadSuccessList.isEmpty()) {
            F0(R.string.tip_update_failed);
        } else {
            g2(uploadSuccessList.get(0));
        }
    }

    public final void Q1(int i2) {
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = (LeftTitleToRightArrowVo) this.t.getList().get(i2);
        this.K = false;
        this.L.handleItemClick(leftTitleToRightArrowVo.getOnlyKey());
        if (leftTitleToRightArrowVo.getOnlyKey() == 0 && c.e.c.x.c.a.getInstance().isShowWalletTest()) {
            F0(R.string.title_id_card_auth_succes);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void R1() {
        boolean zAreNotificationsEnabled = NotificationManagerCompat.from(this.f6486d).areNotificationsEnabled();
        BaseRecyclerAdapter<T> baseRecyclerAdapter = this.t;
        c0 c0Var = this.L;
        boolean z = true;
        boolean z2 = !zAreNotificationsEnabled;
        if (!L() && !M()) {
            z = false;
        }
        baseRecyclerAdapter.initListData((List<T>) c0Var.getAdapterData(z2, z));
        this.L.setupCacheSize();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.btn_submit /* 2131230908 */:
                showConfirmAlertToContent(x.getString(R.string.tip_relay_confirm_exit));
                break;
            case R.id.edt_user_name /* 2131231077 */:
                f2();
                break;
            case R.id.img_user_icon /* 2131231297 */:
                d2();
                break;
            case R.id.tv_account_value /* 2131231916 */:
                e2();
                break;
            case R.id.tv_alert_confirm /* 2131231942 */:
                K1(view);
                break;
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        n2();
        m2();
        p2();
        o2();
    }

    public void addFragment(BaseFragment baseFragment) {
        d(baseFragment, R.id.flayout_content);
    }

    public void alertEnableNotification() {
        if (NotificationManagerCompat.from(this.f6486d).areNotificationsEnabled()) {
            return;
        }
        n.getInstance().showAlert(this.f6487e, x.getString(R.string.title_alert_tip), x.getString(R.string.title_app_notification_disenable), x.getString(R.string.title_go_setting), x.getString(R.string.title_ignore), new View.OnClickListener() { // from class: c.e.c.x.d.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2065a.W1(view);
            }
        });
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    public final void c2() {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 26) {
            intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.addFlags(268435456);
            intent.putExtra("android.provider.extra.APP_PACKAGE", this.f6486d.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", this.f6486d.getApplicationInfo().uid);
        } else {
            intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(268435456);
            intent.setData(Uri.fromParts(AbsServerManager.PACKAGE_QUERY_BINDER, this.f6486d.getPackageName(), null));
        }
        startActivity(intent);
    }

    public final void d2() {
        startActivityForResult(new Intent(this.f6487e, (Class<?>) ImageGridActivity.class), 1000);
    }

    public final void e2() {
        d(UpdatePhoneOrPwdFragment.getInstance(1), R.id.flayout_content);
    }

    @m
    public void eventCancelAccountSuccess(EventCancelAccountSuccess eventCancelAccountSuccess) {
        M1("");
    }

    public final void f2() {
        addFragment(UpdateNickNameFragment.getInstance(this.N, this.D.getText().toString()));
    }

    public final void g2(ResponseUploadImgVo responseUploadImgVo) {
        String string = this.D.getText().toString();
        UpdateAppUserInfoParam updateAppUserInfoParam = new UpdateAppUserInfoParam();
        if (x.isNullStr(string)) {
            H();
            F0(R.string.tip_nickname_is_empty);
            return;
        }
        if (responseUploadImgVo != null) {
            String key = responseUploadImgVo.getKey();
            if (x.isNotNull(key)) {
                updateAppUserInfoParam.setAvatarKey(key);
            }
        }
        updateAppUserInfoParam.setNickname(string);
        h2(responseUploadImgVo, updateAppUserInfoParam);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    public final void h2(ResponseUploadImgVo responseUploadImgVo, UpdateAppUserInfoParam updateAppUserInfoParam) {
        if (this.I == null) {
            this.G.updateUserInfo(updateAppUserInfoParam);
            return;
        }
        NewUpdateAppUserInfoParam newUpdateAppUserInfoParam = new NewUpdateAppUserInfoParam();
        newUpdateAppUserInfoParam.setNickname(updateAppUserInfoParam.getNickname());
        if (responseUploadImgVo != null && x.isNotNull(responseUploadImgVo.getSourceUrl())) {
            newUpdateAppUserInfoParam.setAvatarUrl(responseUploadImgVo.getSourceUrl());
        }
        this.I.updateUserInfo(newUpdateAppUserInfoParam);
    }

    public final void i2() {
        k(new EventBadgeMsgVo());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
    }

    public final void j2(ArrayList<ImageItem> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        String str = arrayList.get(0).path;
        this.F = str;
        this.C.loadImageToUrl(str);
        s2();
    }

    public final void k2() {
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_edit_me_head, (ViewGroup) null, false);
        this.C = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_user_icon);
        this.D = (TextView) viewInflate.findViewById(R.id.edt_user_name);
        this.E = (TextView) viewInflate.findViewById(R.id.tv_account_value);
        this.D.setOnClickListener(this.y);
        this.C.setOnClickListener(this.y);
        this.E.setOnClickListener(this.y);
        this.E.setText(t());
        this.t.addHeadView(viewInflate);
    }

    public final void l2() {
        NewUserModel newUserModel = (NewUserModel) h(NewUserModel.class);
        this.I = newUserModel;
        newUserModel.getResultMutableLiveData().observe(this, new k(this));
        this.I.getLogoutLiveData().observe(this, new i(this));
        this.I.getUploadResponseDtoMutableLive().observe(this, new c.e.c.x.d.m(this));
        this.I.getErrRequestLiveData().observe(this, new o(this));
        NewUserOperateModel newUserOperateModel = (NewUserOperateModel) h(NewUserOperateModel.class);
        this.J = newUserOperateModel;
        newUserOperateModel.getCancelAccountLiveData().observe(this, new p(this));
        this.J.getCancelAccountReasonData().observeForever(new Observer() { // from class: c.e.c.x.d.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2057a.N1((CancelAccountReasonBo) obj);
            }
        });
        this.J.getErrRequestLiveData().observe(this, new o(this));
        this.J.getCancelAccountReason();
    }

    public final void m2() {
        this.mSwipeRefreshLayout.setBackgroundColor(getResources().getColor(R.color.colorF8F8F8));
        this.mSwipeRefreshLayout.setEnabled(false);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp_15);
        this.mSwipeRefreshLayout.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        leftTitleToRightArrowAdapter.setISwitchChangeCallback(new b());
        this.t = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.setOnItemClickListener(this.M);
        k2();
        R1();
    }

    public final void n2() {
        this.mTitleTv.setText(R.string.title_user_center);
        this.mTitleSplitLineTv.setVisibility(0);
        this.mExitBtn.setBackgroundDrawable(null);
        this.mExitBtn.setText(R.string.title_exit_login);
        this.mExitBtn.setTextColor(getResources().getColor(R.color.colorFE9900));
        this.mExitBtn.setVisibility(0);
        this.mExitBtn.setOnClickListener(this.y);
        CoreBaseFragment.c cVar = new CoreBaseFragment.c(this);
        this.f6488f = cVar;
        this.L = new c0(this, cVar);
        c.k.a.a.getInstance().setSelectLimit(1);
    }

    public final void o2() {
        UserInfoVo userInfoVoW = w();
        if (userInfoVoW != null) {
            this.C.loadImageToUrl(d.getInstance().getUrlToResourceVo(userInfoVoW.getAvatar()), R.mipmap.ic_default_icon);
            this.D.setText(x.getNotNullStr(userInfoVoW.getNickname(), ""));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == 1004 && intent != null && i2 == 1000) {
            j2((ArrayList) intent.getSerializableExtra("extra_result_items"));
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    public void openActivity(Class<? extends Activity> cls) {
        d0(cls);
    }

    public void openLogoutAccount() {
        if (c.e.c.x.c.b.getCancelAccountProtocol() != null) {
            openActivity(CancelAccountActivity.class);
            return;
        }
        this.K = true;
        String string = x.getString(R.string.alert_title_apply_logout_account);
        AlertParamVo alertParamVo = new AlertParamVo();
        alertParamVo.setTitleFontSize(14.0f);
        alertParamVo.setActivity(this.f6487e);
        alertParamVo.setContentCanIsEmpty(true);
        alertParamVo.setCancel(x.getString(R.string.core_lib_title_cancel));
        alertParamVo.setConfirm(x.getString(R.string.core_lib_title_confirm));
        alertParamVo.setContent("");
        alertParamVo.setHintText(x.getString(R.string.title_hint_reason));
        alertParamVo.setTitle(string);
        alertParamVo.setInputType(1);
        alertParamVo.setOnClickListener(this.y);
        alertParamVo.setCancelable(true);
        s0(alertParamVo);
    }

    public final void p2() {
        if (c.e.a.a.a.getInstance().isH5Model()) {
            l2();
        }
        UserModel userModel = (UserModel) h(UserModel.class);
        this.G = userModel;
        userModel.getResultMutableLiveData().observe(this, new k(this));
        this.G.getLogoutLiveData().observe(this, new i(this));
        this.G.getUploadResponseDtoMutableLive().observe(this, new c.e.c.x.d.m(this));
        this.G.getErrRequestLiveData().observe(this, new o(this));
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.H = userOperateModel;
        userOperateModel.getCancelAccountLiveData().observe(this, new p(this));
        this.H.getErrRequestLiveData().observe(this, new o(this));
    }

    public final void q2(long j) {
        ((LeftTitleToRightArrowVo) this.t.getList().get(c.e.c.m0.i.getItemIndexToOnlyKey(this.t.getList(), 2))).setRight(x.appendStringToResId(R.string.placeholder_m, String.valueOf(j)));
        this.t.notifyDataSetChanged();
    }

    public final void r2(String str) {
        z0(R.string.tip_save_loading);
        UpdateAppUserInfoParam updateAppUserInfoParam = new UpdateAppUserInfoParam();
        updateAppUserInfoParam.setNickname(str);
        h2(null, updateAppUserInfoParam);
    }

    public void replaceFragment(BaseFragment baseFragment) {
        K0(baseFragment, R.id.flayout_content);
    }

    public final void s2() {
        z0(R.string.tip_save_loading);
        if (x.isNullStr(this.F)) {
            g2(null);
        } else {
            this.G.uploadUserIcon(this.F);
        }
    }

    @OnClick({R.id.tv_title_right})
    public void saveUpdateInfoClick(View view) {
        s2();
    }

    public void showConfirmAlertToContent(String str) {
        u0(str);
    }

    public void showInputAlert(String str, String str2) {
        x0(str, str2, 2, true);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            q2(0L);
            F0(R.string.title_cache_clear);
        } else if (i2 == 1) {
            q2(((Long) message.obj).longValue());
        } else {
            if (i2 != 2098) {
                return;
            }
            M1(null);
        }
    }
}
