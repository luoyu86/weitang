package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

/* JADX INFO: loaded from: classes2.dex */
public class WXGetA8Key {

    public static class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXGetA8Key.Req";
        public String url;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            if (!d.b(this.url)) {
                return true;
            }
            Log.e(TAG, "url is null or nil");
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.url = bundle.getString("_geta8key_url");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 43;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_geta8key_url", this.url);
        }
    }

    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.WXGetA8Key.Resp";
        public String redirectUrl;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.redirectUrl = bundle.getString("_geta8key_redirect_url");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 43;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_geta8key_redirect_url", this.redirectUrl);
        }
    }
}
