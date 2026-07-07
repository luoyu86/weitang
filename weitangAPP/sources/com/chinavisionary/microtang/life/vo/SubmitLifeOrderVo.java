package com.chinavisionary.microtang.life.vo;

import c.e.c.t.q.a;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SubmitLifeOrderVo extends BaseVo {
    public static final int ITEM_TYPE_ADDRESS = 231;
    public static final int ITEM_TYPE_CB = 241;
    public static final int ITEM_TYPE_EDT = 245;
    public static final int ITEM_TYPE_INFO = 233;
    public static final int ITEM_TYPE_TIME = 221;
    private String hintValue;
    private boolean isShowSplitLine;
    private int itemType;
    private List<a> mKeyValueVos;
    private String tip;
    private String title;
    private String value;

    public String getHintValue() {
        return this.hintValue;
    }

    public int getItemType() {
        return this.itemType;
    }

    public List<a> getKeyValueVos() {
        return this.mKeyValueVos;
    }

    public String getTip() {
        return this.tip;
    }

    public String getTitle() {
        return this.title;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isShowSplitLine() {
        return this.isShowSplitLine;
    }

    public void setHintValue(String str) {
        this.hintValue = str;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setKeyValueVos(List<a> list) {
        this.mKeyValueVos = list;
    }

    public void setShowSplitLine(boolean z) {
        this.isShowSplitLine = z;
    }

    public void setTip(String str) {
        this.tip = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
