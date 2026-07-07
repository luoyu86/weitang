package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponsePayModeBo extends NewBaseVo {
    public static final String ALI_PAY = "ali-pay";
    public static final String ALI_WITHDRAW_PAY = "ali-withdraw";
    public static final String BOC_ALI_PAY = "boc-ali";
    public static final String BOC_WX_PAY = "boc-wechat";
    public static final String CCB_ALI_PAY = "ccb-ali";
    public static final String CCB_WX_PAY = "ccb-wechat";
    public static final String GJJ_ALI_PAY = "gjj-ali";
    public static final String TL_ALI_PAY = "tl-ali";
    public static final String TL_FZ_ALI_PAY = "tl-ali-fz";
    public static final String TL_FZ_WX_PAY = "tl-wechat-fz";
    public static final String TL_WX_PAY = "tl-wechat";
    public static final String WT_PAY = "vt-wallet";
    public static final String WX_PAY = "wx-pay";
    private List<String> payModeSet;

    public static Integer getPayTypeToMode(String str) {
        str.hashCode();
        switch (str) {
            case "vt-wallet":
                return 3;
            case "ccb-wechat":
                return 4;
            case "ali-withdraw":
                return 6;
            case "ali-pay":
                return 1;
            case "tl-ali":
                return 10;
            case "wx-pay":
                return 2;
            case "tl-ali-fz":
                return 13;
            case "boc-ali":
                return 8;
            case "gjj-ali":
                return 11;
            case "boc-wechat":
                return 7;
            case "tl-wechat":
                return 9;
            case "ccb-ali":
                return 5;
            case "tl-wechat-fz":
                return 12;
            default:
                return null;
        }
    }

    public static String getPayTypeToMode(int i2) {
        switch (i2) {
            case 1:
                return ALI_PAY;
            case 2:
                return WX_PAY;
            case 3:
                return WT_PAY;
            case 4:
                return CCB_WX_PAY;
            case 5:
            default:
                return CCB_ALI_PAY;
            case 6:
                return ALI_WITHDRAW_PAY;
            case 7:
                return BOC_WX_PAY;
            case 8:
                return BOC_ALI_PAY;
            case 9:
                return TL_WX_PAY;
            case 10:
                return TL_ALI_PAY;
            case 11:
                return GJJ_ALI_PAY;
            case 12:
                return TL_FZ_WX_PAY;
            case 13:
                return TL_FZ_ALI_PAY;
        }
    }

    public List<String> getPayModeSet() {
        return this.payModeSet;
    }

    public void setPayModeSet(List<String> list) {
        this.payModeSet = list;
    }
}
