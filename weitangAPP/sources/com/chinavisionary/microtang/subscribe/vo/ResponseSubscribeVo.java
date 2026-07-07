package com.chinavisionary.microtang.subscribe.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseSubscribeVo extends BaseVo {
    private List<SubscribeLookVo> rows;
    private int total;

    public List<SubscribeLookVo> getRows() {
        return this.rows;
    }

    public int getTotal() {
        return this.total;
    }

    public void setRows(List<SubscribeLookVo> list) {
        this.rows = list;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }
}
