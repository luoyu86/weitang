package com.chinavisionary.core.app.config.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LaboratoryConfig extends BaseVo {

    /* JADX INFO: renamed from: android, reason: collision with root package name */
    private AndroidBean f6510android;
    private boolean androidTestEnable;

    public static class AndroidBean extends BaseVo {
        private int maxVersionCode;
        private int minVersionCode;
        private List<String> userList;

        public int getMaxVersionCode() {
            return this.maxVersionCode;
        }

        public int getMinVersionCode() {
            return this.minVersionCode;
        }

        public List<String> getUserList() {
            return this.userList;
        }

        public void setMaxVersionCode(int i2) {
            this.maxVersionCode = i2;
        }

        public void setMinVersionCode(int i2) {
            this.minVersionCode = i2;
        }

        public void setUserList(List<String> list) {
            this.userList = list;
        }
    }

    public AndroidBean getAndroid() {
        return this.f6510android;
    }

    public boolean isAndroidTestEnable() {
        return this.androidTestEnable;
    }

    public void setAndroid(AndroidBean androidBean) {
        this.f6510android = androidBean;
    }

    public void setAndroidTestEnable(boolean z) {
        this.androidTestEnable = z;
    }
}
