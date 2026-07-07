package com.chinavisionary.microtang.web;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        WebViewActivity webViewActivity = (WebViewActivity) obj;
        webViewActivity.k = webViewActivity.getIntent().getBooleanExtra("isFddContract", webViewActivity.k);
        webViewActivity.l = webViewActivity.getIntent().getIntExtra("payFeeType", webViewActivity.l);
        webViewActivity.m = webViewActivity.getIntent().getExtras() == null ? webViewActivity.m : webViewActivity.getIntent().getExtras().getString("signUrl", webViewActivity.m);
        webViewActivity.n = webViewActivity.getIntent().getExtras() == null ? webViewActivity.n : webViewActivity.getIntent().getExtras().getString("returnUrl", webViewActivity.n);
    }
}
