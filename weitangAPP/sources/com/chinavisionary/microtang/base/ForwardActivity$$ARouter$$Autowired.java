package com.chinavisionary.microtang.base;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: classes.dex */
public class ForwardActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        ForwardActivity forwardActivity = (ForwardActivity) obj;
        forwardActivity.k = forwardActivity.getIntent().getExtras() == null ? forwardActivity.k : forwardActivity.getIntent().getExtras().getString("title", forwardActivity.k);
        forwardActivity.l = forwardActivity.getIntent().getIntExtra("forwardType", forwardActivity.l);
        forwardActivity.m = forwardActivity.getIntent().getExtras() == null ? forwardActivity.m : forwardActivity.getIntent().getExtras().getString("href", forwardActivity.m);
    }
}
