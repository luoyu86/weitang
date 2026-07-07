package com.bytedance.sdk.openadsdk.mediation.init;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediationConfigUserInfoForSegment implements Serializable {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, String> f6437h;
    public final String TAG = "TTMediationSDK";
    private String ok = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6436a = "";
    private String bl = "";
    private int s = 0;
    private String n = "";
    private String kf = "";

    public static boolean checkValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment = (MediationConfigUserInfoForSegment) obj;
        boolean z2 = getAge() == mediationConfigUserInfoForSegment.getAge() && TextUtils.equals(getUserValueGroup(), mediationConfigUserInfoForSegment.getUserValueGroup()) && TextUtils.equals(getUserId(), mediationConfigUserInfoForSegment.getUserId()) && TextUtils.equals(getChannel(), mediationConfigUserInfoForSegment.getChannel()) && TextUtils.equals(getSubChannel(), mediationConfigUserInfoForSegment.getSubChannel()) && TextUtils.equals(getGender(), mediationConfigUserInfoForSegment.getGender());
        Map<String, String> customInfos = mediationConfigUserInfoForSegment.getCustomInfos();
        Map<String, String> map = this.f6437h;
        if (map != null && customInfos != null) {
            if (map.size() == customInfos.size()) {
                for (String str : this.f6437h.keySet()) {
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(this.f6437h.get(str), customInfos.get(str))) {
                    }
                }
                z = true;
            }
            z = false;
            break;
        }
        if (map != null || customInfos != null) {
            z = false;
            break;
        }
        z = true;
        return z2 && z;
    }

    public int getAge() {
        return this.s;
    }

    @Nullable
    public String getChannel() {
        return this.f6436a;
    }

    @Nullable
    public Map<String, String> getCustomInfos() {
        return this.f6437h;
    }

    @Nullable
    public String getGender() {
        return this.n;
    }

    @Nullable
    public String getSubChannel() {
        return this.bl;
    }

    @Nullable
    public String getUserId() {
        return this.ok;
    }

    @Nullable
    public String getUserValueGroup() {
        return this.kf;
    }

    public void setAge(int i2) {
        this.s = i2;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.f6436a = str;
        } else {
            Log.e("TTMediationSDK", "流量分组channer字段存在不合法输入");
        }
    }

    public void setCustomInfos(Map<String, String> map) {
        this.f6437h = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!checkValid(entry.getKey())) {
                    Log.e("TTMediationSDK", "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (checkValid(entry.getValue())) {
                    this.f6437h.put(entry.getKey(), entry.getValue());
                } else {
                    Log.e("TTMediationSDK", "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                }
            }
        }
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.n = str;
        } else {
            Log.e("TTMediationSDK", "流量分组gender字段存在不合法输入");
        }
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.bl = str;
        } else {
            Log.e("TTMediationSDK", "流量分组sub_channer字段存在不合法输入");
        }
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.ok = str;
        } else {
            Log.e("TTMediationSDK", "流量分组user_id字段存在不合法输入");
        }
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.kf = str;
        } else {
            Log.e("TTMediationSDK", "流量分组user_value_group字段存在不合法输入");
        }
    }
}
