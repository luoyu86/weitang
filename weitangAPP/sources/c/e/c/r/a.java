package c.e.c.r;

import c.e.a.a.b;
import c.e.a.d.j;
import c.e.a.d.x;
import c.e.c.m0.c;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String appendH5BaseUrl(String str) {
        if (!x.isNotNull(str) || x.isHttpUrl(str)) {
            return str;
        }
        if (str.indexOf("/") == 0 && str.length() >= 2) {
            str = str.substring(1);
        }
        return j.getInstance().getH5BaseUrl() + str;
    }

    public static String getAssetsConfirm(String str) {
        return j.getInstance().getH5BaseUrl() + "process/contract/assets?contractKey=" + str;
    }

    public static String getAuthList() {
        return j.getInstance().getH5BaseUrl() + "process/power/door/list";
    }

    public static String getEnterpriseCertificate() {
        return j.getInstance().getH5BaseUrl() + "process/authentication/enterprise/details";
    }

    public static String getH5Url(String str) {
        if ("/".equals(str.substring(0, 1))) {
            return j.getInstance().getH5BaseUrl() + str.substring(1);
        }
        return j.getInstance().getH5BaseUrl() + str;
    }

    public static String getIMUrl() {
        AppConfigExtVo appConfigExtVo = c.getInstance().getAppConfigExtVo();
        String iMUrl = (appConfigExtVo == null || !x.isNotNull(appConfigExtVo.getIMUrl())) ? "https://www.v5kf.com/public/chat/chat?sid=194326&entry=5&ref=link&accountid=2f71603018c2c" : appConfigExtVo.getIMUrl();
        if (b.getInstance().getUserName() == null) {
            return iMUrl;
        }
        try {
            return iMUrl + "&oid=" + b.getInstance().getUserKey() + "&nickname=" + URLEncoder.encode(b.getInstance().getUserName(), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return iMUrl + "&oid=" + b.getInstance().getUserKey() + "&nickname=" + b.getInstance().getUserName();
        }
    }

    public static String getIdCardCertificate() {
        return j.getInstance().getH5BaseUrl() + "process/idcard/info";
    }

    public static String getMyBill() {
        return j.getInstance().getH5BaseUrl() + "project/bill/list";
    }

    public static String getMyContract() {
        return j.getInstance().getH5BaseUrl() + "process/contract/list";
    }

    public static String getMyCoupon() {
        return j.getInstance().getH5BaseUrl() + "project/coupon/list";
    }

    public static String getMyMessageActivity() {
        return j.getInstance().getH5BaseUrl() + "project/notice/list";
    }

    public static String getMyOrder() {
        return j.getInstance().getH5BaseUrl() + "project/order/list";
    }

    public static String getMyRepairActivity() {
        return j.getInstance().getH5BaseUrl() + "project/repair/list";
    }

    public static String getMyReserve() {
        return j.getInstance().getH5BaseUrl() + "process/reserve/list";
    }

    public static String getMySaleActivity() {
        return j.getInstance().getH5BaseUrl() + "activity/deals/list";
    }

    public static String getMyServiceActivity() {
        return j.getInstance().getH5BaseUrl() + "project/complaint/list";
    }

    public static String getMycatDeviceRecord() {
        return j.getInstance().getH5BaseUrl() + "project/record/meterReading/list";
    }

    public static String getMycommunityActivity() {
        return j.getInstance().getH5BaseUrl() + "activity/community/list";
    }

    public static String getRentSignRoom(String str) {
        if (x.isNotNull(str) && str.indexOf("/") == 0 && str.length() >= 2) {
            str = str.substring(1);
        }
        return j.getInstance().getH5BaseUrl() + str;
    }

    public static String getReserveRoom(String str) {
        return j.getInstance().getH5BaseUrl() + "process/reserve/form?assetKey=" + str;
    }

    public static String getSignRoom(String str) {
        return j.getInstance().getH5BaseUrl() + "process/sign/step?assetKey=" + str;
    }

    public static String serviceOrder() {
        return j.getInstance().getH5BaseUrl() + "project/order/list";
    }
}
