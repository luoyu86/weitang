package com.chinavisionary.microtang.open;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: classes.dex */
public class LiveCheckActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        LiveCheckActivity liveCheckActivity = (LiveCheckActivity) obj;
        liveCheckActivity.k = liveCheckActivity.getIntent().getBooleanExtra("isShowAlert", liveCheckActivity.k);
        liveCheckActivity.l = liveCheckActivity.getIntent().getBooleanExtra("isFinish", liveCheckActivity.l);
        liveCheckActivity.m = liveCheckActivity.getIntent().getExtras() == null ? liveCheckActivity.m : liveCheckActivity.getIntent().getExtras().getString("key", liveCheckActivity.m);
        liveCheckActivity.n = liveCheckActivity.getIntent().getExtras() == null ? liveCheckActivity.n : liveCheckActivity.getIntent().getExtras().getString("showDate", liveCheckActivity.n);
    }
}
