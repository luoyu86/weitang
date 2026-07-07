package com.chinavisionary.paymentlibrary.vo;

import c.e.a.a.a;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes2.dex */
public class PayBillResultVo extends NewBaseVo {
    private String billKey;
    private String key;
    private String orderKey;
    private String pageUrl;
    private String payId;
    private String paySign;
    private String paymentKey;
    private String qrUrl;
    private String valueaddedOrderKey;
    private Boolean sandBox = Boolean.FALSE;
    private boolean pullPay = true;

    public String getBillKey() {
        return x.isNotNull(this.valueaddedOrderKey) ? this.valueaddedOrderKey : this.billKey;
    }

    public String getKey() {
        return this.key;
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }

    public String getPayId() {
        return this.payId;
    }

    public String getPaySign() {
        if (a.getInstance().isJHModel()) {
            if (this.paySign != null) {
                q.d(getClass().getSimpleName(), "getPaySign paySign = " + this.paySign);
                return this.paySign;
            }
            if (this.qrUrl != null) {
                try {
                    String strDecode = URLDecoder.decode(new String(this.qrUrl.getBytes(), "UTF-8"), "UTF-8");
                    q.d(getClass().getSimpleName(), "getPaySign qrPayUrl = " + strDecode);
                    return strDecode;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.payId != null) {
                q.d(getClass().getSimpleName(), "getPaySign payId = " + this.payId);
                return this.payId;
            }
        }
        return this.paySign;
    }

    public String getPaymentKey() {
        return x.isNotNull(this.payId) ? this.payId : x.isNotNull(this.orderKey) ? this.orderKey : this.paymentKey;
    }

    public boolean getPullPay() {
        return this.pullPay;
    }

    public String getQrUrl() {
        return this.qrUrl;
    }

    public Boolean getSandBox() {
        return this.sandBox;
    }

    public String getValueaddedOrderKey() {
        return this.valueaddedOrderKey;
    }

    public void setBillKey(String str) {
        this.billKey = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }

    public void setPageUrl(String str) {
        this.pageUrl = str;
    }

    public void setPayId(String str) {
        this.payId = str;
    }

    public void setPaySign(String str) {
        this.paySign = str;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }

    public void setPullPay(boolean z) {
        this.pullPay = z;
    }

    public void setQrUrl(String str) {
        this.qrUrl = str;
    }

    public void setSandBox(Boolean bool) {
        this.sandBox = bool;
    }

    public void setValueaddedOrderKey(String str) {
        this.valueaddedOrderKey = str;
    }
}
