package com.bytedance.sdk.openadsdk.api.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bl implements Bridge {
    private DownloadModel ok;

    public bl(DownloadModel downloadModel) {
        this.ok = downloadModel;
    }

    public List<String> a() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getBackupUrls();
        }
        return null;
    }

    public String ah() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getSdkMonitorScene();
        }
        return null;
    }

    public String bl() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getNotificationJumpUrl();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        switch (i2) {
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_WIFI /* 223417 */:
                td();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_TOAST /* 223419 */:
                u();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_NOTIFICATION /* 223420 */:
                io();
                return null;
            case 223430:
                if (valueSet != null) {
                    return (T) ok((String) valueSet.objectValue(223431, String.class));
                }
                return null;
            default:
                return null;
        }
    }

    public boolean e() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.autoInstallWithoutNotification();
        }
        return false;
    }

    public boolean em() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.shouldDownloadWithPatchApply();
        }
        return false;
    }

    public String ep() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getLogExtra();
        }
        return null;
    }

    public DeepLink er() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getDeepLink();
        }
        return null;
    }

    public List<String> fb() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getClickTrackUrl();
        }
        return null;
    }

    public IDownloadFileUriProvider fd() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getDownloadFileUriProvider();
        }
        return null;
    }

    public com.ss.android.download.api.model.s fl() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getQuickAppModel();
        }
        return null;
    }

    public JSONObject g() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getExtra();
        }
        return null;
    }

    public long h() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getExtraValue();
        }
        return 0L;
    }

    public String i() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getFilePath();
        }
        return null;
    }

    public void io() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            downloadModel.forceHideNotification();
        }
    }

    public boolean j() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isShowNotification();
        }
        return false;
    }

    public Map<String, String> k() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getHeaders();
        }
        return null;
    }

    public long kf() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getExpectFileLength();
        }
        return 0L;
    }

    public String kz() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getAppIcon();
        }
        return null;
    }

    public boolean l() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isAutoInstall();
        }
        return false;
    }

    public boolean m() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isAd();
        }
        return false;
    }

    public String n() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getMd5();
        }
        return null;
    }

    public int o() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getVersionCode();
        }
        return 0;
    }

    public String ok() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getDownloadUrl();
        }
        return null;
    }

    public String p() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getName();
        }
        return null;
    }

    public String q() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getMimeType();
        }
        return null;
    }

    public int qu() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getFunnelType();
        }
        return 0;
    }

    public boolean r() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isShowToast();
        }
        return false;
    }

    public boolean rh() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isInExternalPublicDir();
        }
        return false;
    }

    public long s() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getId();
        }
        return 0L;
    }

    public int sg() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getExecutorGroup();
        }
        return 0;
    }

    public boolean t() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isVisibleInDownloadsUi();
        }
        return false;
    }

    public void td() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            downloadModel.forceWifi();
        }
    }

    public void u() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            downloadModel.forceHideToast();
        }
    }

    public boolean ul() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.needIndependentProcess();
        }
        return false;
    }

    public int v() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getModelType();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_URL, ok()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_BACKUP_URLS, a()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NOTIFICATION_JUMP_URL, bl()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_ID, s()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MD5, n()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXPECT_FILE_LENGTH, kf()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXTRA_VALUE, h()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NAME, p()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MIME_TYPE, q()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_HEADERS, k()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_TOAST, r()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_NOTIFICATION, j()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_NEED_WIFI, z()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_IN_EXTERNAL_PUBLIC_DIR, rh()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_VISIBLE_IN_DOWNLOADS_UI, t()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_PATH, i()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_NAME, x()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_SETTINGS, zz()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_NEED_INDEPENDENT_PROCESS, ul()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_CODE, o()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_NAME, y()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_AD, m()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_LOG_EXTRA, ep()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_PACKAGE_NAME, vz()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_APP_ICON, kz()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DEEP_LINK, er()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_CLICK_TRACK_URL, fb()).ok(223430, g()).ok(223431, v()).ok(223432, fl()).ok(223433, e()).ok(223434, fd()).ok(223435, em()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXECUTOR_GROUP, sg()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FUNNEL_TYPE, qu()).ok(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_START_TOAST, xy()).ok(223432, ah()).ok(223433, l()).ok(223434, wv()).ok(223435, vk()).a();
    }

    public boolean vk() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.enablePause();
        }
        return false;
    }

    public String vz() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getPackageName();
        }
        return null;
    }

    public boolean wv() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.distinctDir();
        }
        return false;
    }

    public String x() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getFileName();
        }
        return null;
    }

    public String xy() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getStartToast();
        }
        return null;
    }

    public String y() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getVersionName();
        }
        return null;
    }

    public boolean z() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isNeedWifi();
        }
        return false;
    }

    public JSONObject zz() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getDownloadSettings();
        }
        return null;
    }

    public DownloadModel ok(String str) {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.setFilePath(str);
        }
        return null;
    }
}
