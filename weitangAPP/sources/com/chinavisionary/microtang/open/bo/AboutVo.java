package com.chinavisionary.microtang.open.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class AboutVo extends BaseVo {
    public static final int ABOUT = 1;
    public static final int HELP = 2;
    public static final int PRIVACY = 4;
    public static final int SB = 6;
    public static final int SCORE = 3;
    public static final int SERVER = 7;
    public static final int VERSION = 5;
    private String title;
    private int type;

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
