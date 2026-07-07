package com.chinavisionary.core.photo.photopicker.camera;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: classes.dex */
public class CameraActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        CameraActivity cameraActivity = (CameraActivity) obj;
        cameraActivity.p = cameraActivity.getIntent().getBooleanExtra("isShowChangeBtn", cameraActivity.p);
    }
}
