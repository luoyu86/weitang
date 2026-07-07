package com.chinavisionary.core.app.config.bo;

import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.weight.banner.EditBannerView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppConfigExtVo extends BaseVo {
    private String IMUrl;
    private String adScreen;
    private ADScreen adScreenVo;
    private String androidCompatible;
    private String catDeviceFunctionRecord;
    private String checkinProtocolUrl;
    private String checkinTip;
    private String commonPublicKey;
    private String communityDefaultBannerUrl;
    private String customerServicePhone;
    private String deviceRepair;
    private String doorLockDesc1;
    private String doorLockDesc2;
    private String doorLockDesc3;
    private String helpCourseUrl;
    private String lifeDefaultBannerUrl;
    private String lowBattery;
    private AppCompatibleDeviceListVo mAppCompatibleDeviceListVo;
    private List<EditBannerView.BannerDto> mBannerDto;
    private LaboratoryConfig mLaboratoryConfig;
    private String oaidCertUrl;
    private String privacyPolicyUrl;
    private boolean qqAppStory;
    private String registerProtocolUrl;
    private String roomDefaultBannerUrl;
    private String safetyNoticeUrl;
    private String shoppingBanner;
    private String specialDeclarationUrl;
    private String testConfig;
    private String transferOutTip;
    private String valueaddTip;
    private int versionCode;
    private boolean hasEnableGrayStyle = false;
    private boolean isSupportOldActivity = true;
    private boolean enableEmergencyLock = true;
    private boolean enableNewMtLock = true;
    private boolean isEnableNetworkCache = true;
    private boolean hasEnableAd = false;
    private boolean hasEnableMeBannerAd = true;
    private boolean hasEnableMainBannerAd = true;
    private boolean hasEnableLifeBannerAd = true;
    private boolean hasEnableActivityBannerAd = true;
    private boolean hasEnableSplashAd = true;
    private boolean hasEnableLockInterstitialAd = true;
    private int oaidVersion = 1;
    private boolean hasEnableInterstitialAd = true;
    private int cacheValidTime = 15;
    private int maxOftenLock = 2;

    public static class ADScreen extends BaseVo {
        private LockScreenBean lockScreen;
        private SplashScreenBean splashScreen;

        public static class LockScreenBean extends BaseVo {
            private Integer forwardType;
            private String href;
            private String resource;
            private Long timer;
            private String title;

            public int getForwardType() {
                if (this.forwardType == null) {
                    this.forwardType = -1;
                }
                return this.forwardType.intValue();
            }

            public String getHref() {
                return this.href;
            }

            public String getResource() {
                return this.resource;
            }

            public long getTimer() {
                if (this.timer == null) {
                    this.timer = 1L;
                }
                return this.timer.longValue();
            }

            public String getTitle() {
                return this.title;
            }

            public void setForwardType(Integer num) {
                this.forwardType = num;
            }

            public void setHref(String str) {
                this.href = str;
            }

            public void setResource(String str) {
                this.resource = str;
            }

            public void setTimer(Long l) {
                this.timer = l;
            }

            public void setTitle(String str) {
                this.title = str;
            }
        }

        public static class SplashScreenBean extends BaseVo {
            private Integer forwardType;
            private String href;
            private String resource;
            private String targetAppid;
            private String targetMiniType;
            private String targetPath;
            private Long timer;
            private String title;

            public Integer getForwardType() {
                if (this.forwardType == null) {
                    this.forwardType = -1;
                }
                return this.forwardType;
            }

            public String getHref() {
                return this.href;
            }

            public String getResource() {
                return this.resource;
            }

            public String getTargetAppid() {
                return this.targetAppid;
            }

            public String getTargetMiniType() {
                return this.targetMiniType;
            }

            public String getTargetPath() {
                return this.targetPath;
            }

            public Long getTimer() {
                if (this.timer == null) {
                    this.timer = 1L;
                }
                return this.timer;
            }

            public String getTitle() {
                return this.title;
            }

            public void setForwardType(Integer num) {
                this.forwardType = num;
            }

            public void setHref(String str) {
                this.href = str;
            }

            public void setResource(String str) {
                this.resource = str;
            }

            public void setTargetAppid(String str) {
                this.targetAppid = str;
            }

            public void setTargetMiniType(String str) {
                this.targetMiniType = str;
            }

            public void setTargetPath(String str) {
                this.targetPath = str;
            }

            public void setTimer(Long l) {
                this.timer = l;
            }

            public void setTitle(String str) {
                this.title = str;
            }
        }

        public LockScreenBean getLockScreen() {
            return this.lockScreen;
        }

        public SplashScreenBean getSplashScreen() {
            return this.splashScreen;
        }

        public void setLockScreen(LockScreenBean lockScreenBean) {
            this.lockScreen = lockScreenBean;
        }

        public void setSplashScreen(SplashScreenBean splashScreenBean) {
            this.splashScreen = splashScreenBean;
        }
    }

    public String getAdScreen() {
        return this.adScreen;
    }

    public ADScreen getAdScreenVo() {
        String str = this.adScreen;
        if (str != null) {
            try {
                this.adScreenVo = (ADScreen) JSON.parseObject(str, ADScreen.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.adScreenVo;
    }

    public String getAndroidCompatible() {
        return this.androidCompatible;
    }

    public AppCompatibleDeviceListVo getAppCompatibleDeviceListVo() {
        String str = this.androidCompatible;
        if (str != null) {
            this.mAppCompatibleDeviceListVo = (AppCompatibleDeviceListVo) JSON.parseObject(str, AppCompatibleDeviceListVo.class);
        }
        return this.mAppCompatibleDeviceListVo;
    }

    public List<EditBannerView.BannerDto> getBannerDto() {
        if (x.isNotNull(this.shoppingBanner) && this.mBannerDto == null) {
            this.mBannerDto = JSON.parseArray(this.shoppingBanner, EditBannerView.BannerDto.class);
        }
        return this.mBannerDto;
    }

    public int getCacheValidTime() {
        return this.cacheValidTime;
    }

    public String getCatDeviceFunctionRecord() {
        return this.catDeviceFunctionRecord;
    }

    public String getCheckinProtocolUrl() {
        return this.checkinProtocolUrl;
    }

    public String getCheckinTip() {
        return this.checkinTip;
    }

    public String getCommonPublicKey() {
        return this.commonPublicKey;
    }

    public String getCommunityDefaultBannerUrl() {
        return this.communityDefaultBannerUrl;
    }

    public String getCustomerServicePhone() {
        return this.customerServicePhone;
    }

    public String getDeviceRepair() {
        return this.deviceRepair;
    }

    public String getDoorLockDesc1() {
        return this.doorLockDesc1;
    }

    public String getDoorLockDesc2() {
        return this.doorLockDesc2;
    }

    public String getDoorLockDesc3() {
        return this.doorLockDesc3;
    }

    public String getHelpCourseUrl() {
        return this.helpCourseUrl;
    }

    public String getIMUrl() {
        return this.IMUrl;
    }

    public LaboratoryConfig getLaboratoryConfig() {
        String str = this.testConfig;
        if (str != null) {
            this.mLaboratoryConfig = (LaboratoryConfig) JSON.parseObject(str, LaboratoryConfig.class);
        }
        return this.mLaboratoryConfig;
    }

    public String getLifeDefaultBannerUrl() {
        return this.lifeDefaultBannerUrl;
    }

    public String getLowBattery() {
        String str = this.lowBattery;
        return str == null ? "当前电量低，请及时更换电池" : str;
    }

    public int getMaxOftenLock() {
        return this.maxOftenLock;
    }

    public String getOaidCertUrl() {
        return this.oaidCertUrl;
    }

    public int getOaidVersion() {
        return this.oaidVersion;
    }

    public String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public String getRegisterProtocolUrl() {
        return this.registerProtocolUrl;
    }

    public String getRoomDefaultBannerUrl() {
        return this.roomDefaultBannerUrl;
    }

    public String getSafetyNoticeUrl() {
        return this.safetyNoticeUrl;
    }

    public String getShoppingBanner() {
        return this.shoppingBanner;
    }

    public String getSpecialDeclarationUrl() {
        return this.specialDeclarationUrl;
    }

    public String getTestConfig() {
        return this.testConfig;
    }

    public String getTransferOutTip() {
        return this.transferOutTip;
    }

    public String getValueaddTip() {
        return this.valueaddTip;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public boolean isEnableEmergencyLock() {
        return this.enableEmergencyLock;
    }

    public boolean isEnableNetworkCache() {
        return this.isEnableNetworkCache;
    }

    public boolean isEnableNewMtLock() {
        return this.enableNewMtLock;
    }

    public boolean isHasEnableActivityBannerAd() {
        return this.hasEnableActivityBannerAd;
    }

    public boolean isHasEnableAd() {
        return this.hasEnableAd;
    }

    public boolean isHasEnableGrayStyle() {
        return this.hasEnableGrayStyle;
    }

    public boolean isHasEnableInterstitialAd() {
        return this.hasEnableInterstitialAd;
    }

    public boolean isHasEnableLifeBannerAd() {
        return this.hasEnableLifeBannerAd;
    }

    public boolean isHasEnableLockInterstitialAd() {
        return this.hasEnableLockInterstitialAd;
    }

    public boolean isHasEnableMainBannerAd() {
        return this.hasEnableMainBannerAd;
    }

    public boolean isHasEnableMeBannerAd() {
        return this.hasEnableMeBannerAd;
    }

    public boolean isHasEnableSplashAd() {
        return this.hasEnableSplashAd;
    }

    public boolean isQqAppStory() {
        return this.qqAppStory;
    }

    public boolean isSupportOldActivity() {
        return this.isSupportOldActivity;
    }

    public void setAdScreen(String str) {
        this.adScreen = str;
    }

    public void setAdScreenVo(ADScreen aDScreen) {
        this.adScreenVo = aDScreen;
    }

    public void setAndroidCompatible(String str) {
        this.androidCompatible = str;
    }

    public void setAppCompatibleDeviceListVo(AppCompatibleDeviceListVo appCompatibleDeviceListVo) {
        this.mAppCompatibleDeviceListVo = appCompatibleDeviceListVo;
    }

    public void setCacheValidTime(int i2) {
        this.cacheValidTime = i2;
    }

    public void setCatDeviceFunctionRecord(String str) {
        this.catDeviceFunctionRecord = str;
    }

    public void setCheckinProtocolUrl(String str) {
        this.checkinProtocolUrl = str;
    }

    public void setCheckinTip(String str) {
        this.checkinTip = str;
    }

    public void setCommonPublicKey(String str) {
        this.commonPublicKey = str;
    }

    public void setCommunityDefaultBannerUrl(String str) {
        this.communityDefaultBannerUrl = str;
    }

    public void setCustomerServicePhone(String str) {
        this.customerServicePhone = str;
    }

    public void setDeviceRepair(String str) {
        this.deviceRepair = str;
    }

    public void setDoorLockDesc1(String str) {
        this.doorLockDesc1 = str;
    }

    public void setDoorLockDesc2(String str) {
        this.doorLockDesc2 = str;
    }

    public void setDoorLockDesc3(String str) {
        this.doorLockDesc3 = str;
    }

    public void setEnableEmergencyLock(boolean z) {
        this.enableEmergencyLock = z;
    }

    public void setEnableNetworkCache(boolean z) {
        this.isEnableNetworkCache = z;
    }

    public void setEnableNewMtLock(boolean z) {
        this.enableNewMtLock = z;
    }

    public void setHasEnableActivityBannerAd(boolean z) {
        this.hasEnableActivityBannerAd = z;
    }

    public void setHasEnableAd(boolean z) {
        this.hasEnableAd = z;
    }

    public void setHasEnableGrayStyle(boolean z) {
        this.hasEnableGrayStyle = z;
    }

    public void setHasEnableInterstitialAd(boolean z) {
        this.hasEnableInterstitialAd = z;
    }

    public void setHasEnableLifeBannerAd(boolean z) {
        this.hasEnableLifeBannerAd = z;
    }

    public void setHasEnableLockInterstitialAd(boolean z) {
        this.hasEnableLockInterstitialAd = z;
    }

    public void setHasEnableMainBannerAd(boolean z) {
        this.hasEnableMainBannerAd = z;
    }

    public void setHasEnableMeBannerAd(boolean z) {
        this.hasEnableMeBannerAd = z;
    }

    public void setHasEnableSplashAd(boolean z) {
        this.hasEnableSplashAd = z;
    }

    public void setHelpCourseUrl(String str) {
        this.helpCourseUrl = str;
    }

    public void setIMUrl(String str) {
        this.IMUrl = str;
    }

    public void setLaboratoryConfig(LaboratoryConfig laboratoryConfig) {
        this.mLaboratoryConfig = laboratoryConfig;
    }

    public void setLifeDefaultBannerUrl(String str) {
        this.lifeDefaultBannerUrl = str;
    }

    public void setLowBattery(String str) {
        this.lowBattery = str;
    }

    public void setMaxOftenLock(int i2) {
        this.maxOftenLock = i2;
    }

    public void setOaidCertUrl(String str) {
        this.oaidCertUrl = str;
    }

    public void setOaidVersion(int i2) {
        this.oaidVersion = i2;
    }

    public void setPrivacyPolicyUrl(String str) {
        this.privacyPolicyUrl = str;
    }

    public void setQqAppStory(boolean z) {
        this.qqAppStory = z;
    }

    public void setRegisterProtocolUrl(String str) {
        this.registerProtocolUrl = str;
    }

    public void setRoomDefaultBannerUrl(String str) {
        this.roomDefaultBannerUrl = str;
    }

    public void setSafetyNoticeUrl(String str) {
        this.safetyNoticeUrl = str;
    }

    public void setShoppingBanner(String str) {
        this.shoppingBanner = str;
    }

    public void setSpecialDeclarationUrl(String str) {
        this.specialDeclarationUrl = str;
    }

    public void setSupportOldActivity(boolean z) {
        this.isSupportOldActivity = z;
    }

    public void setTestConfig(String str) {
        this.testConfig = str;
    }

    public void setTransferOutTip(String str) {
        this.transferOutTip = str;
    }

    public void setValueaddTip(String str) {
        this.valueaddTip = str;
    }

    public void setVersionCode(int i2) {
        this.versionCode = i2;
    }
}
