package com.chinavisionary.microtang.msg.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseMsgVo extends BaseVo {
    private List<MsgVo> rows;
    private int totalSize;

    public List<MsgVo> getRows() {
        return this.rows;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public void setRows(List<MsgVo> list) {
        this.rows = list;
    }

    public void setTotalSize(int i2) {
        this.totalSize = i2;
    }
}
