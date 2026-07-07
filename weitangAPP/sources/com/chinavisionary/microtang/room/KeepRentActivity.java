package com.chinavisionary.microtang.room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.Observer;
import c.e.a.a.a;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.room.fragment.AirQualityFragment;
import com.chinavisionary.microtang.room.model.RoomOperationModel;
import com.chinavisionary.microtang.sign.fragments.RoomRentInfoFragment;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;
import me.jessyan.autosize.internal.CancelAdapt;

/* JADX INFO: loaded from: classes2.dex */
public class KeepRentActivity extends BaseActivity implements CancelAdapt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(ResponseStateVo responseStateVo) {
        K();
        if (responseStateVo == null) {
            e0(R.string.data_error);
            return;
        }
        if (!responseStateVo.isSuccess()) {
            showToast(responseStateVo.getMessage());
            return;
        }
        if (!x.isNullStr(responseStateVo.getContent())) {
            AirQualityFragment airQualityFragment = AirQualityFragment.getInstance(this.f6477e, false);
            airQualityFragment.setKeepRent(true);
            Y(airQualityFragment, R.id.flayout_content);
        } else if (a.getInstance().isH5Model()) {
            finish();
            q0(BridgeWebViewActivity.class, c.e.c.r.a.getSignRoom(this.f6477e));
        } else {
            RoomRentInfoFragment roomRentInfoFragment = RoomRentInfoFragment.getInstance(this.f6477e);
            roomRentInfoFragment.setKeepRent(true);
            Y(roomRentInfoFragment, R.id.flayout_content);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        RoomOperationModel roomOperationModel = (RoomOperationModel) c(RoomOperationModel.class);
        roomOperationModel.getAirQualityLiveData().observe(this, new Observer() { // from class: c.e.c.h0.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1492a.p0((ResponseStateVo) obj);
            }
        });
        roomOperationModel.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.h0.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1491a.m0((RequestErrDto) obj);
            }
        });
        if (x.isNotNull(this.f6477e)) {
            showLoading(x.getString(R.string.loading_text));
            roomOperationModel.getRoomAirQuality(this.f6477e);
        }
    }

    public final void m0(RequestErrDto requestErrDto) {
        K();
        if (requestErrDto != null) {
            showToast(requestErrDto.getErrMsg());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (h0(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public final void q0(Class<? extends Activity> cls, String str) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(268435456);
        if (str != null) {
            intent.putExtra("key", str);
        }
        startActivity(intent);
    }
}
