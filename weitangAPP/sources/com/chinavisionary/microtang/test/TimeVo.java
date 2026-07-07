package com.chinavisionary.microtang.test;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TimeVo extends BaseVo {
    private String api;
    private DataBean data;
    private List<String> ret;
    private String v;

    public String getApi() {
        return this.api;
    }

    public DataBean getData() {
        return this.data;
    }

    public List<String> getRet() {
        return this.ret;
    }

    public String getV() {
        return this.v;
    }

    public void setApi(String str) {
        this.api = str;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setRet(List<String> list) {
        this.ret = list;
    }

    public void setV(String str) {
        this.v = str;
    }
}
