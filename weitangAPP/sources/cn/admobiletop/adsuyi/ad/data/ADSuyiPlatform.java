package cn.admobiletop.adsuyi.ad.data;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiPlatform {
    public static final String PLAFORM_ADMOBILE = "admobile";
    public static final String PLAFORM_TIANMU = "tianmu";

    boolean check();

    String getAppId();

    String getAppKey();

    String getPlatform();
}
