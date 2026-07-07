package com.chinavisionary.microtang.main.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: classes.dex */
public class PaySuccessTipActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        PaySuccessTipActivity paySuccessTipActivity = (PaySuccessTipActivity) obj;
        paySuccessTipActivity.k = paySuccessTipActivity.getIntent().getExtras() == null ? paySuccessTipActivity.k : paySuccessTipActivity.getIntent().getExtras().getString("appletJsonKey", paySuccessTipActivity.k);
    }
}
