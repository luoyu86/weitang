package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/* JADX INFO: loaded from: classes2.dex */
public class WXQRCodePay {

    public static class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXQRCodePayReq.Req";
        public String codeContent;
        public String extraMsg;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return !TextUtils.isEmpty(this.codeContent);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 38;
        }
    }

    public static final class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final int getType() {
            return 38;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
