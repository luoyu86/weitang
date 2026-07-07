package com.chinavisionary.framework.mobile.user.param;

/* JADX INFO: loaded from: classes.dex */
public class NewUpdateUserPasswordParam {
    private Boolean flag = Boolean.TRUE;
    private String newConfirmPwd;
    private String newPwd;
    private String oldPwd;

    public Boolean getFlag() {
        return this.flag;
    }

    public String getNewConfirmPwd() {
        return this.newConfirmPwd;
    }

    public String getNewPwd() {
        return this.newPwd;
    }

    public String getOldPwd() {
        return this.oldPwd;
    }

    public void setFlag(Boolean bool) {
        this.flag = bool;
    }

    public void setNewConfirmPwd(String str) {
        this.newConfirmPwd = str;
    }

    public void setNewPwd(String str) {
        this.newPwd = str;
    }

    public void setOldPwd(String str) {
        this.oldPwd = str;
    }
}
