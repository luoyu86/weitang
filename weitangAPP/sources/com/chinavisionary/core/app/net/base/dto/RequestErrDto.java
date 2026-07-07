package com.chinavisionary.core.app.net.base.dto;

/* JADX INFO: loaded from: classes.dex */
public class RequestErrDto extends BaseVo {
    public static final String GET_CANCEL_ACCOUNT_URL = "server-api/vtapp/v1/contract/rent/cancellation/reason";
    public static final String GET_CONSTANT_URL = "server-api/vtapp/v1/nologin/constant";
    public static final String GET_ORDER_IS_TICKET_URL = "business/order/commodity/is/ticket";
    public static final String GET_SPACE_GOODS_PWD_ROOM_LIST_URL = "user/rent/spacegoods/list/pwd";
    public static final int PARAM_EMPTY_CODE = 900;
    public static final int RESPONSE_EMPTY_CODE = 901;
    public static final int RESPONSE_ERR_CODE = 902;
    private int code;
    private String errMsg;
    private String srcErr;
    private String url;

    public int getCode() {
        return this.code;
    }

    public String getErrMsg() {
        String str = this.errMsg;
        return str == null ? "" : str;
    }

    public String getSrcErr() {
        return this.srcErr;
    }

    public String getUrl() {
        String str = this.url;
        return str == null ? "" : str;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setErrMsg(String str) {
        if (str == null) {
            str = "";
        }
        this.errMsg = str;
    }

    public void setSrcErr(String str) {
        this.srcErr = str;
    }

    public void setUrl(String str) {
        if (str == null) {
            str = "";
        }
        this.url = str;
    }
}
