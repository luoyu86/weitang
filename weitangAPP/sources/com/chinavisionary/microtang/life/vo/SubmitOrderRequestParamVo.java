package com.chinavisionary.microtang.life.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SubmitOrderRequestParamVo extends BaseVo {
    private String errMsgTip;
    private boolean isErr;
    private Map<String, String> keyValueMap;
    private String remark;
    private String time;

    public String getErrMsgTip() {
        return this.errMsgTip;
    }

    public Map<String, String> getKeyValueMap() {
        return this.keyValueMap;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getTime() {
        return this.time;
    }

    public boolean isErr() {
        return this.isErr;
    }

    public void setErr(boolean z) {
        this.isErr = z;
    }

    public void setErrMsgTip(String str) {
        this.errMsgTip = str;
    }

    public void setKeyValueMap(Map<String, String> map) {
        this.keyValueMap = map;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setTime(String str) {
        this.time = str;
    }
}
