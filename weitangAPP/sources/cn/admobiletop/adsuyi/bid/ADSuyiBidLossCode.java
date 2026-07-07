package cn.admobiletop.adsuyi.bid;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ADSuyiBidLossCode {
    public static final int BID_PRICE_NOT_HIGHEST = 1;
    public static final int BID_TIMEOUT = 2;
    public static final int BID_WIN_BUT_NOT_SHOW = 3;
    public static final int GDT_AD_DATA_ERROR = 4;
    public static final int GDT_NO_AD = 3;
    public static final int GDT_OTHER = 10001;
    public static final int OTHER = 4;
}
