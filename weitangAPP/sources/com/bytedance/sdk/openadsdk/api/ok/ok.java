package com.bytedance.sdk.openadsdk.api.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadController;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {
    private DownloadController ok;

    public ok(DownloadController downloadController) {
        this.ok = downloadController;
    }

    public int a() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getDownloadMode();
        }
        return 0;
    }

    public boolean bl() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.isEnableBackDialog();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 223317) {
            if (valueSet == null) {
                return null;
            }
            a(((Boolean) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_NEW_ACTIVITY, Boolean.class)).booleanValue());
            return null;
        }
        switch (i2) {
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_DOWNLOAD_MODE /* 223311 */:
                if (valueSet != null) {
                    ok(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_MODE, Integer.class)).intValue());
                }
                break;
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_LINK_MODE /* 223312 */:
                if (valueSet != null) {
                    a(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_LINK_MODE, Integer.class)).intValue());
                }
                break;
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_ENABLE_SHOW_COMPLIANCE_DIALOG /* 223313 */:
                if (valueSet != null) {
                    ok(((Boolean) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_SHOW_COMPLIANCE_DIALOG, Boolean.class)).booleanValue());
                }
                break;
        }
        return null;
    }

    public Object h() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getExtraClickOperation();
        }
        return null;
    }

    public boolean i() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.enableAM();
        }
        return false;
    }

    public boolean j() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.enableShowComplianceDialog();
        }
        return false;
    }

    public JSONObject k() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getExtraJson();
        }
        return null;
    }

    public int kf() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getDowloadChunkCount();
        }
        return 0;
    }

    public boolean n() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.isEnableMultipleDownload();
        }
        return false;
    }

    public int ok() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getLinkMode();
        }
        return 0;
    }

    public boolean p() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.shouldUseNewWebView();
        }
        return false;
    }

    public int q() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getInterceptFlag();
        }
        return 0;
    }

    public Object r() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getExtraObject();
        }
        return null;
    }

    public boolean rh() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.enableNewActivity();
        }
        return false;
    }

    public boolean s() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.isAddToDownloadManage();
        }
        return false;
    }

    public boolean t() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.enableAH();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_LINK_MODE, ok()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_DOWNLOAD_MODE, a()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ENABLE_BACK_DIALOG, bl()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ADD_TO_DOWNLOAD_MANAGE, s()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ENABLE_MULTIPLE_DOWNLOAD, n()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_DOWNLOAD_CHUNK_COUNT, kf()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_CLICK_OPERATION, h()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SHOULD_USE_NEW_WEB_VIEW, p()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_INTERCEPT_FLAG, q()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_JSON, k()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_OBJECT, r()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_JSON, k()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_SHOW_COMPLIANCE_DIALOG, j()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, z()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_NEW_ACTIVITY, rh()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_AH, t()).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_AM, i()).a();
    }

    public boolean z() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.isAutoDownloadOnCardShow();
        }
        return false;
    }

    public void a(int i2) {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            downloadController.setLinkMode(i2);
        }
    }

    public void ok(int i2) {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            downloadController.setDownloadMode(i2);
        }
    }

    public void a(boolean z) {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            downloadController.setEnableNewActivity(z);
        }
    }

    public void ok(boolean z) {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            downloadController.setEnableShowComplianceDialog(z);
        }
    }
}
