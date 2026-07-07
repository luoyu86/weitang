package c.e.e.a.s;

import android.os.Build;
import c.e.e.a.x.l;

/* JADX INFO: loaded from: classes2.dex */
public class f extends a {
    private static final int ANDROID_OS = 1;
    public static final int FAILED = 0;
    public static final int SUCCESS = 1;
    private String appName;
    private String appVersion;
    private String assetInstanceKey;
    private String failReason;
    private Boolean isUserCacheOpenDoor;
    private Long openDoorEndTime;
    private Long openDoorStartTime;
    private Integer phoneSystemType;
    private String phoneSystemVersion;
    private String phoneType;
    private String remark;
    private Long scanTime;
    private Integer status;
    private String tipMsg;

    public f() {
        this.appName = l.getInstance().getAppName();
        this.phoneType = Build.MANUFACTURER + ":" + Build.BRAND + ":" + Build.MODEL;
        this.phoneSystemType = 1;
        this.phoneSystemVersion = String.valueOf(Build.VERSION.SDK_INT);
        this.status = 0;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getAssetInstanceKey() {
        return this.assetInstanceKey;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public Long getOpenDoorEndTime() {
        return this.openDoorEndTime;
    }

    public Long getOpenDoorStartTime() {
        return this.openDoorStartTime;
    }

    public Integer getPhoneSystemType() {
        return this.phoneSystemType;
    }

    public String getPhoneSystemVersion() {
        return this.phoneSystemVersion;
    }

    public String getPhoneType() {
        return this.phoneType;
    }

    public String getRemark() {
        return this.remark;
    }

    public Long getScanTime() {
        return this.scanTime;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getTipMsg() {
        return this.tipMsg;
    }

    public Boolean getUserCacheOpenDoor() {
        return this.isUserCacheOpenDoor;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setAssetInstanceKey(String str) {
        this.assetInstanceKey = str;
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public void setOpenDoorEndTime(Long l) {
        this.openDoorEndTime = l;
    }

    public void setOpenDoorStartTime(Long l) {
        this.openDoorStartTime = l;
    }

    public void setPhoneSystemType(Integer num) {
        this.phoneSystemType = num;
    }

    public void setPhoneSystemVersion(String str) {
        this.phoneSystemVersion = str;
    }

    public void setPhoneType(String str) {
        this.phoneType = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setScanTime(Long l) {
        this.scanTime = l;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setTipMsg(String str) {
        this.tipMsg = str;
    }

    public void setUserCacheOpenDoor(Boolean bool) {
        this.isUserCacheOpenDoor = bool;
    }

    public f(f fVar) {
        this.appName = l.getInstance().getAppName();
        this.phoneType = Build.MANUFACTURER + ":" + Build.BRAND + ":" + Build.MODEL;
        this.phoneSystemType = 1;
        this.phoneSystemVersion = String.valueOf(Build.VERSION.SDK_INT);
        this.status = 0;
        this.appName = fVar.appName;
        this.isUserCacheOpenDoor = fVar.isUserCacheOpenDoor;
        this.appVersion = fVar.appVersion;
        this.assetInstanceKey = fVar.assetInstanceKey;
        this.phoneType = fVar.phoneType;
        this.phoneSystemType = fVar.phoneSystemType;
        this.phoneSystemVersion = fVar.phoneSystemVersion;
        this.status = fVar.status;
        this.openDoorStartTime = fVar.openDoorStartTime;
        this.openDoorEndTime = fVar.openDoorEndTime;
        this.scanTime = fVar.scanTime;
        this.failReason = fVar.failReason;
        this.remark = fVar.remark;
        this.tipMsg = fVar.tipMsg;
    }
}
