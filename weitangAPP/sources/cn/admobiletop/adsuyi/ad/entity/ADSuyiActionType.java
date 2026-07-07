package cn.admobiletop.adsuyi.ad.entity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiActionType {
    public static final int ACTION_CALL_PHONE = 3;
    public static final int ACTION_DOWNLOAD = 2;
    public static final int ACTION_LANDING_PAGE_APP = 0;
    public static final int ACTION_LANDING_PAGE_BROWSER = 1;
    public static final int ACTION_UNKNOWN = -1;

    public static String getActionTex(int i2, String str) {
        return TextUtils.isEmpty(str) ? getActionText(i2) : str;
    }

    public static String getActionText(int i2) {
        return i2 != 2 ? i2 != 3 ? "查看详情" : "拨打电话" : "下载安装";
    }
}
