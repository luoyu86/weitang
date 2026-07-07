package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountItemBo extends BaseVo {
    public static final int ITEM_TYPE_CONTENT = 1;
    public static final int ITEM_TYPE_REASON = 4;
    public static final int ITEM_TYPE_TITLE = 2;
    public static final int ITEM_TYPE_TITLE_CONTENT = 3;
    private String content;
    private boolean isCheck;
    private boolean isNeedShowRemark;
    private boolean isShowRemark;
    private int itemType = 4;
    private String reason;
    private String reasonKey;
    private String remarkValue;
    private String subtitle;
    private String title;

    public String getContent() {
        return this.content;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getReason() {
        return this.reason;
    }

    public String getReasonKey() {
        return this.reasonKey;
    }

    public String getRemarkValue() {
        return this.remarkValue;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public boolean isNeedShowRemark() {
        return this.isNeedShowRemark;
    }

    public boolean isShowRemark() {
        return this.isShowRemark;
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setNeedShowRemark(boolean z) {
        this.isNeedShowRemark = z;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setReasonKey(String str) {
        this.reasonKey = str;
    }

    public void setRemarkValue(String str) {
        this.remarkValue = str;
    }

    public void setShowRemark(boolean z) {
        this.isShowRemark = z;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
