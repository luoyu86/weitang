package com.chinavisionary.microtang.vo;

import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenLeftTitleToRightArrowResultVo extends BaseVo {
    private List<LeftTitleToRightArrowVo> list;
    private String tipMsg;

    public List<LeftTitleToRightArrowVo> getList() {
        return this.list;
    }

    public String getTipMsg() {
        return this.tipMsg;
    }

    public void setList(List<LeftTitleToRightArrowVo> list) {
        this.list = list;
    }

    public void setTipMsg(String str) {
        this.tipMsg = str;
    }
}
