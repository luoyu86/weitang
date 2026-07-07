package com.bytedance.sdk.openadsdk.api.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadEventConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements Bridge {
    private DownloadEventConfig ok;

    public a(DownloadEventConfig downloadEventConfig) {
        this.ok = downloadEventConfig;
    }

    public String a() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickButtonTag();
        }
        return null;
    }

    public String bl() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickItemTag();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 223515) {
            if (valueSet == null) {
                return null;
            }
            ok(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_DOWNLOAD_SCENE_PARAMETER, Integer.class)).intValue());
            return null;
        }
        if (i2 != 223517 || valueSet == null) {
            return null;
        }
        ok((String) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_REFER_PARAMETER, String.class));
        return null;
    }

    public String h() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickContinueLabel();
        }
        return null;
    }

    public boolean j() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableClickEvent();
        }
        return false;
    }

    public Object k() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraEventObject();
        }
        return null;
    }

    public String kf() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickPauseLabel();
        }
        return null;
    }

    public String n() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickStartLabel();
        }
        return null;
    }

    public String ok() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getRefer();
        }
        return null;
    }

    public String p() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickInstallLabel();
        }
        return null;
    }

    public String q() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getStorageDenyLabel();
        }
        return null;
    }

    public int r() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getDownloadScene();
        }
        return 0;
    }

    public JSONObject rh() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraJson();
        }
        return null;
    }

    public String s() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickLabel();
        }
        return null;
    }

    public JSONObject t() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getParamsJson();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_REFER, ok()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_BUTTON_TAG, a()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_ITEM_TAG, bl()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_LABEL, s()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_START_LABEL, n()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_PAUSE_LABEL, kf()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_CONTINUE_LABEL, h()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_INSTALL_LABEL, p()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_STORAGE_DENY_LABEL, q()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_EVENT_OBJECT, k()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_DOWNLOAD_SCENE, r()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_CLICK_EVENT, j()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_V3_EVENT, z()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_JSON, rh()).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_PARAMS_JSON, t()).a();
    }

    public boolean z() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableV3Event();
        }
        return false;
    }

    public void ok(int i2) {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            downloadEventConfig.setDownloadScene(i2);
        }
    }

    public void ok(String str) {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            downloadEventConfig.setRefer(str);
        }
    }
}
