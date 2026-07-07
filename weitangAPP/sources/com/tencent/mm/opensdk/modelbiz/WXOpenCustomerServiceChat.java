package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/* JADX INFO: loaded from: classes2.dex */
public class WXOpenCustomerServiceChat {

    public static final class Req extends BaseReq {
        public String corpId = "";
        public String url = "";

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final int getType() {
            return 37;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_open_customer_service_chat_corpId", this.corpId);
            bundle.putString("_open_customer_service_chat_url", this.url);
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
            return 37;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
