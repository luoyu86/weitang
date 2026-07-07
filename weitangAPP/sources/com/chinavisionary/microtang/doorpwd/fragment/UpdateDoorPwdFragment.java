package com.chinavisionary.microtang.doorpwd.fragment;

import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.c.q.d.e;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.framework.mobile.login.param.SMSSendParam;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.doorpwd.model.DoorPasswordModel;
import com.chinavisionary.microtang.doorpwd.vo.BleCommandListVo;
import com.chinavisionary.microtang.doorpwd.vo.ResponseDoorPasswordBleCommandBo;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class UpdateDoorPwdFragment extends BaseFragment<String> {
    public boolean B = true;
    public int C = 60;
    public NewUserOperateModel D;
    public DoorPasswordModel E;
    public String F;

    @BindView(R.id.edt_new_again_pwd)
    public EditText mAgainPwdEdt;

    @BindView(R.id.img_open_again_pwd)
    public ImageView mAgainPwdImg;

    @BindView(R.id.tv_confirm)
    public AppCompatButton mConfirmBtn;

    @BindView(R.id.edt_again_pwd)
    public EditText mPwdEdt;

    @BindView(R.id.img_open_pwd)
    public ImageView mPwdImg;

    @BindView(R.id.btn_send_sms)
    public Button mRetryGetTv;

    @BindView(R.id.edt_sms_code)
    public EditText mSmsCodeEdt;

    @BindView(R.id.tv_user_name)
    public TextView mUserNameTv;

    @BindView(R.id.edt_phone)
    public TextView mUserPhoneTv;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (UpdateDoorPwdFragment.this.mSmsCodeEdt.getText().length() == 6) {
                UpdateDoorPwdFragment.this.mPwdEdt.requestFocus();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (UpdateDoorPwdFragment.this.mAgainPwdEdt.getText().length() == 6) {
                UpdateDoorPwdFragment.this.I();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (UpdateDoorPwdFragment.this.mPwdEdt.getText().length() == 6) {
                UpdateDoorPwdFragment.this.mAgainPwdEdt.requestFocus();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public static UpdateDoorPwdFragment getInstance(String str, String str2) {
        UpdateDoorPwdFragment updateDoorPwdFragment = new UpdateDoorPwdFragment();
        updateDoorPwdFragment.f6484b = str;
        updateDoorPwdFragment.F = str2;
        return updateDoorPwdFragment;
    }

    public final void F1(ResponseDoorPasswordBleCommandBo responseDoorPasswordBleCommandBo) {
        if (responseDoorPasswordBleCommandBo.isSuccess()) {
            O1(responseDoorPasswordBleCommandBo);
        } else {
            G0(responseDoorPasswordBleCommandBo.getMessage());
        }
    }

    public final void G1(NewResponseStateVo newResponseStateVo) {
        if (newResponseStateVo.isSuccess()) {
            this.B = false;
            this.C = 60;
            Q1();
            this.mSmsCodeEdt.requestFocus();
            E0(this.mSmsCodeEdt);
            F0(R.string.tip_sms_code_send_success);
        } else {
            F0(R.string.title_sms_code_is_failed);
        }
        H();
    }

    public final void H1() {
        UserInfoVo userInfoVoW = w();
        this.mUserNameTv.setText("姓名：" + userInfoVoW.getPersonName());
        this.mUserPhoneTv.setText(t());
        this.mRetryGetTv.setOnClickListener(this.y);
        this.mConfirmBtn.setOnClickListener(this.y);
        this.mPwdImg.setOnClickListener(this.y);
        this.mAgainPwdImg.setOnClickListener(this.y);
        ImageView imageView = this.mPwdImg;
        Boolean bool = Boolean.FALSE;
        imageView.setTag(bool);
        this.mAgainPwdImg.setTag(bool);
        this.mSmsCodeEdt.addTextChangedListener(new a());
        this.mAgainPwdEdt.addTextChangedListener(new b());
        this.mPwdEdt.addTextChangedListener(new c());
    }

    public final void I1() {
        NewUserOperateModel newUserOperateModel = (NewUserOperateModel) h(NewUserOperateModel.class);
        this.D = newUserOperateModel;
        newUserOperateModel.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.q.c.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1825a.C((RequestErrDto) obj);
            }
        });
        this.D.getSmsCodeResult().observeForever(new Observer() { // from class: c.e.c.q.c.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1824a.G1((NewResponseStateVo) obj);
            }
        });
        DoorPasswordModel doorPasswordModel = (DoorPasswordModel) h(DoorPasswordModel.class);
        this.E = doorPasswordModel;
        doorPasswordModel.getDoorPasswordResult().observeForever(new Observer() { // from class: c.e.c.q.c.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1823a.F1((ResponseDoorPasswordBleCommandBo) obj);
            }
        });
        this.E.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.q.c.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1825a.C((RequestErrDto) obj);
            }
        });
    }

    public final void M1() {
        boolean z = !((Boolean) this.mAgainPwdImg.getTag()).booleanValue();
        if (z) {
            this.mAgainPwdImg.setImageResource(R.mipmap.ic_pwd_open);
            this.mAgainPwdEdt.setInputType(2);
        } else {
            this.mAgainPwdImg.setImageResource(R.mipmap.ic_pwd_close);
            this.mAgainPwdEdt.setInputType(18);
        }
        if (x.isNullStr(this.mAgainPwdEdt.getText().toString())) {
            this.mAgainPwdEdt.setSelection(this.mAgainPwdEdt.getText().length());
        }
        this.mAgainPwdImg.setTag(Boolean.valueOf(z));
    }

    public final void N1() {
        boolean z = !((Boolean) this.mPwdImg.getTag()).booleanValue();
        if (z) {
            this.mPwdImg.setImageResource(R.mipmap.ic_pwd_open);
            this.mPwdEdt.setInputType(2);
        } else {
            this.mPwdImg.setImageResource(R.mipmap.ic_pwd_close);
            this.mPwdEdt.setInputType(18);
        }
        if (x.isNullStr(this.mPwdEdt.getText().toString())) {
            this.mPwdEdt.setSelection(this.mPwdEdt.getText().length());
        }
        this.mPwdImg.setTag(Boolean.valueOf(z));
    }

    public final void O1(ResponseDoorPasswordBleCommandBo responseDoorPasswordBleCommandBo) {
        e outputProperties = responseDoorPasswordBleCommandBo.getOutputProperties();
        H();
        if (outputProperties == null || !o.isNotEmpty(outputProperties.getBleList())) {
            F0(R.string.tip_response_ble_command_empty);
            return;
        }
        responseDoorPasswordBleCommandBo.setAssetKey(this.f6484b);
        responseDoorPasswordBleCommandBo.setRoomName(this.F);
        responseDoorPasswordBleCommandBo.setDoorPwd(this.mPwdEdt.getText().toString());
        responseDoorPasswordBleCommandBo.setModelName(outputProperties.getModelAdapter());
        responseDoorPasswordBleCommandBo.setMacAddress(outputProperties.getMacAddress());
        ArrayList arrayList = new ArrayList();
        for (BleCommandListVo bleCommandListVo : outputProperties.getBleList()) {
            if (bleCommandListVo != null && x.isNotNull(bleCommandListVo.getType()) && o.isNotEmpty(bleCommandListVo.getBle())) {
                if (bleCommandListVo.getType().equals(BleCommandListVo.SETUP_TIME_COMMAND_TYPE)) {
                    responseDoorPasswordBleCommandBo.setSetupCommandId(bleCommandListVo.getCommandId());
                    responseDoorPasswordBleCommandBo.setSetupCommand(c.e.c.q.b.a.getBleCommandToJsonString(bleCommandListVo.getBle()));
                } else if (bleCommandListVo.getType().equals(BleCommandListVo.SETUP_PWD_COMMAND_TYPE) || BleCommandListVo.UPDATE_PWD_COMMAND_TYPE.equals(bleCommandListVo.getType())) {
                    responseDoorPasswordBleCommandBo.setCommandId(bleCommandListVo.getCommandId());
                    responseDoorPasswordBleCommandBo.setCommand(c.e.c.q.b.a.getBleCommandToJsonString(bleCommandListVo.getBle()));
                } else if (bleCommandListVo.getType().equals(BleCommandListVo.UNFREEZE_ONLINE_PASSWORD)) {
                    responseDoorPasswordBleCommandBo.setUnfreezeOnlinePasswordId(bleCommandListVo.getCommandId());
                    responseDoorPasswordBleCommandBo.setUnfreezeOnlinePassword(c.e.c.q.b.a.getBleCommandToJsonString(bleCommandListVo.getBle()));
                } else if (bleCommandListVo.getType().equals(BleCommandListVo.FREEZE_ONLINE_PASSWORD)) {
                    responseDoorPasswordBleCommandBo.setFreezeOnlinePasswordId(bleCommandListVo.getCommandId());
                    responseDoorPasswordBleCommandBo.setFreezeOnlinePassword(c.e.c.q.b.a.getBleCommandToJsonString(bleCommandListVo.getBle()));
                }
            }
        }
        if (x.isNullStr(responseDoorPasswordBleCommandBo.getMacAddress())) {
            G0("Mac地址为空，操作失败");
            return;
        }
        if (x.isNullStr(responseDoorPasswordBleCommandBo.getModelName())) {
            G0("ModelAdapter为空，操作失败");
            return;
        }
        if (x.isNullStr(responseDoorPasswordBleCommandBo.getCommand())) {
            G0("设置密码命令为空，操作失败");
        } else {
            if (x.isNullStr(responseDoorPasswordBleCommandBo.getSetupCommand())) {
                G0("设置时间命令为空，操作失败");
                return;
            }
            responseDoorPasswordBleCommandBo.setCommandIdList(arrayList);
            g0();
            d(UpdateDoorPwdBleFragment.getInstance(responseDoorPasswordBleCommandBo), R.id.flayout_content);
        }
    }

    public final void P1() {
        z0(R.string.tip_submit_data_loading);
        SMSSendParam sMSSendParam = new SMSSendParam();
        sMSSendParam.setPhone(s());
        this.D.onlySendSmsCode(sMSSendParam);
    }

    public final void Q1() {
        int i2 = this.C - 1;
        this.C = i2;
        if (i2 <= 0) {
            this.B = true;
            this.mRetryGetTv.setTextColor(getResources().getColor(R.color.colorFE9A02));
            this.mRetryGetTv.setText(R.string.title_retry_get_sms_code);
            return;
        }
        this.mRetryGetTv.setTextColor(getResources().getColor(R.color.colore757575));
        this.mRetryGetTv.setText("(" + this.C + ")");
        this.f6488f.sendEmptyMessageDelayed(1, 1000L);
    }

    public final void R1() {
        String string = this.mSmsCodeEdt.getText().toString();
        String string2 = this.mPwdEdt.getText().toString();
        String string3 = this.mAgainPwdEdt.getText().toString();
        if (x.isNullStr(string)) {
            F0(R.string.tip_sms_code_is_empty);
            return;
        }
        if (x.isNullStr(string2)) {
            F0(R.string.tip_again_pwd_is_empty);
            return;
        }
        if (x.isNullStr(string3)) {
            F0(R.string.tip_pwd_is_empty);
            return;
        }
        if (string2.length() < 6) {
            F0(R.string.tip_door_pwd_rule_msg);
            return;
        }
        if (!string2.equals(string3)) {
            F0(R.string.tip_again_pwd_not_equals);
            return;
        }
        z0(R.string.tip_submit_data_loading);
        c.e.c.q.d.c cVar = new c.e.c.q.d.c();
        cVar.setPassword(this.mPwdEdt.getText().toString());
        cVar.setCode(this.mSmsCodeEdt.getText().toString());
        cVar.setAssetKey(this.f6484b);
        cVar.setPhone(s());
        this.E.getDoorPassword(cVar);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_send_sms && this.B) {
            P1();
        }
        if (view.getId() == R.id.img_open_pwd) {
            N1();
        }
        if (view.getId() == R.id.img_open_again_pwd) {
            M1();
        }
        if (view.getId() == R.id.tv_confirm) {
            R1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.f6488f = new CoreBaseFragment.c(this);
        H1();
        I1();
    }

    @OnClick({R.id.img_close})
    public void closeFragment() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_update_door_pwd;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        if (message.what == 1) {
            Q1();
        }
    }
}
