package com.chinavisionary.microtang.doorpwd.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class UpdateDoorPwdBleFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UpdateDoorPwdBleFragment f7194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7198f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateDoorPwdBleFragment f7199c;

        public a(UpdateDoorPwdBleFragment updateDoorPwdBleFragment) {
            this.f7199c = updateDoorPwdBleFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7199c.addPwd();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateDoorPwdBleFragment f7201c;

        public b(UpdateDoorPwdBleFragment updateDoorPwdBleFragment) {
            this.f7201c = updateDoorPwdBleFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7201c.backFinish();
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateDoorPwdBleFragment f7203c;

        public c(UpdateDoorPwdBleFragment updateDoorPwdBleFragment) {
            this.f7203c = updateDoorPwdBleFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7203c.delPwd();
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateDoorPwdBleFragment f7205c;

        public d(UpdateDoorPwdBleFragment updateDoorPwdBleFragment) {
            this.f7205c = updateDoorPwdBleFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7205c.updatePwd();
        }
    }

    @UiThread
    public UpdateDoorPwdBleFragment_ViewBinding(UpdateDoorPwdBleFragment updateDoorPwdBleFragment, View view) {
        this.f7194b = updateDoorPwdBleFragment;
        updateDoorPwdBleFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        updateDoorPwdBleFragment.mConnectStateImg = (CoreRoundedImageView) b.c.d.findRequiredViewAsType(view, R.id.img_ble_connect_state, "field 'mConnectStateImg'", CoreRoundedImageView.class);
        updateDoorPwdBleFragment.mPwdValueTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_pwd_value, "field 'mPwdValueTv'", TextView.class);
        updateDoorPwdBleFragment.mPwdValueTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_pwd_value_title, "field 'mPwdValueTitleTv'", TextView.class);
        updateDoorPwdBleFragment.mRoomNameTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_room_name, "field 'mRoomNameTv'", TextView.class);
        updateDoorPwdBleFragment.mMtTipMsgTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_mt_tip_msg, "field 'mMtTipMsgTv'", TextView.class);
        updateDoorPwdBleFragment.mOperationStateTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_operation_state, "field 'mOperationStateTv'", TextView.class);
        updateDoorPwdBleFragment.mConnectTimerTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_ble_connect_timer, "field 'mConnectTimerTv'", TextView.class);
        updateDoorPwdBleFragment.mStateLLayout = (LinearLayout) b.c.d.findRequiredViewAsType(view, R.id.ll_state, "field 'mStateLLayout'", LinearLayout.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.btn_add_pwd, "method 'addPwd'");
        this.f7195c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(updateDoorPwdBleFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'backFinish'");
        this.f7196d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(updateDoorPwdBleFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.btn_del_pwd, "method 'delPwd'");
        this.f7197e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(updateDoorPwdBleFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.btn_update_pwd, "method 'updatePwd'");
        this.f7198f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(updateDoorPwdBleFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UpdateDoorPwdBleFragment updateDoorPwdBleFragment = this.f7194b;
        if (updateDoorPwdBleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7194b = null;
        updateDoorPwdBleFragment.mTitleTv = null;
        updateDoorPwdBleFragment.mConnectStateImg = null;
        updateDoorPwdBleFragment.mPwdValueTv = null;
        updateDoorPwdBleFragment.mPwdValueTitleTv = null;
        updateDoorPwdBleFragment.mRoomNameTv = null;
        updateDoorPwdBleFragment.mMtTipMsgTv = null;
        updateDoorPwdBleFragment.mOperationStateTv = null;
        updateDoorPwdBleFragment.mConnectTimerTv = null;
        updateDoorPwdBleFragment.mStateLLayout = null;
        this.f7195c.setOnClickListener(null);
        this.f7195c = null;
        this.f7196d.setOnClickListener(null);
        this.f7196d = null;
        this.f7197e.setOnClickListener(null);
        this.f7197e = null;
        this.f7198f.setOnClickListener(null);
        this.f7198f = null;
    }
}
