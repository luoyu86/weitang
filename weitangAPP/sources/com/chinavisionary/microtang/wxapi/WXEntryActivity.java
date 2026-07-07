package com.chinavisionary.microtang.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import c.e.a.d.q;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.vo.EventWxMiniBack;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import g.b.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IWXAPI f8722a;

    public final void a() {
    }

    public final void b(ShowMessageFromWX.Req req) {
        WXMediaMessage wXMediaMessage = req.message;
        WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) wXMediaMessage.mediaObject;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("description: ");
        stringBuffer.append(wXMediaMessage.description);
        stringBuffer.append("\n");
        stringBuffer.append("extInfo: ");
        stringBuffer.append(wXAppExtendObject.extInfo);
        stringBuffer.append("\n");
        stringBuffer.append("filePath: ");
        stringBuffer.append(wXAppExtendObject.filePath);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_empty_layout);
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this, "wx566d59045c104e04", false);
        this.f8722a = iwxapiCreateWXAPI;
        iwxapiCreateWXAPI.registerApp("wx566d59045c104e04");
        this.f8722a.handleIntent(getIntent(), this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f8722a.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        int type = baseReq.getType();
        if (type == 3) {
            a();
        } else {
            if (type != 4) {
                return;
            }
            b((ShowMessageFromWX.Req) baseReq);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        q.d(getClass().getSimpleName(), "onResp type = " + baseResp.getType());
        if (baseResp.getType() == 2) {
            finish();
        }
        if (baseResp.getType() == 19) {
            String str = ((WXLaunchMiniProgram.Resp) baseResp).extMsg;
            q.d(getClass().getSimpleName(), "COMMAND_LAUNCH_WX_MINIPROGRAM extraData = " + str);
            c.getDefault().post(new EventWxMiniBack());
            finish();
        }
    }
}
