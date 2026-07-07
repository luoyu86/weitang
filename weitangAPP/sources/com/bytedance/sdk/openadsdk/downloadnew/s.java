package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.ok.h;
import com.bytedance.sdk.openadsdk.api.ok.kf;
import com.bytedance.sdk.openadsdk.api.ok.n;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.s;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Bridge {
    private static volatile s ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6374a;
    private AdDownloadModel.Builder bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AdDownloadEventConfig.Builder f6375h;
    private AdDownloadController kf;
    private AdDownloadController.Builder n;
    private AdDownloadEventConfig p;
    private AdDownloadModel s;

    private s(Context context) {
        this.f6374a = context;
    }

    private void a(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder builderOk = ok(((Long) map.get("id")).longValue(), (String) map.get(TTDownloadField.TT_APP_ICON), ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue(), (String) map.get(TTDownloadField.TT_LOG_EXTRA), (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON), (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS), (String) map.get(TTDownloadField.TT_FILE_PATH), (String) map.get(TTDownloadField.TT_DOWNLOAD_URL), (String) map.get("appName"), (String) map.get("packageName"), ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue(), (String) map.get(TTDownloadField.TT_OPEN_URL), (String) map.get(TTDownloadField.TT_WEB_TITLE), (String) map.get(TTDownloadField.TT_WEB_URL));
        this.bl = builderOk;
        this.s = builderOk.build();
    }

    private DownloadStatusChangeListener bl(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        if (obj instanceof EventListener) {
            return new n((EventListener) obj);
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private ExitInstallListener h(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    private DownloadController kf(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private DownloadEventConfig n(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    public static s ok(Context context) {
        if (ok == null) {
            synchronized (s.class) {
                if (ok == null) {
                    ok = new s(context);
                }
            }
        }
        return ok;
    }

    private static boolean ok(IDownloadButtonClickListener iDownloadButtonClickListener) {
        return iDownloadButtonClickListener != null;
    }

    private OnItemClickListener p(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new h((EventListener) obj);
        }
        return null;
    }

    private IDownloadButtonClickListener q(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new kf((EventListener) obj);
        }
        return null;
    }

    private int qa() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getDownloadMode();
    }

    private DownloadModel s(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    public String ah() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getMimeType();
    }

    public boolean az() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.distinctDir();
    }

    public boolean b() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAutoInstall();
    }

    public JSONObject c() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getExtra();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 != 20) {
            return (T) ok(cls, i2, (valueSet == null || valueSet.objectValue(0, Map.class) == null) ? new HashMap<>() : (Map) valueSet.objectValue(0, Map.class));
        }
        ok((Bundle) valueSet.objectValue(0, Bundle.class));
        return null;
    }

    public void cf() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideNotification();
    }

    public String cs() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getFileName();
    }

    public DeepLink d() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDeepLink();
    }

    public String de() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getVersionName();
    }

    public boolean dn() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAd();
    }

    public void dx() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideToast();
    }

    public long e() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExpectFileLength();
    }

    public boolean ej() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public String em() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getDownloadUrl();
    }

    public Object ep() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraEventObject();
    }

    public boolean er() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return false;
        }
        return adDownloadEventConfig.isEnableV3Event();
    }

    public boolean ew() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.needIndependentProcess();
    }

    public com.ss.android.download.api.model.s f() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getQuickAppModel();
    }

    public JSONObject fb() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraJson();
    }

    public long fd() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExtraValue();
    }

    public String fl() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getMd5();
    }

    public JSONObject g() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getParamsJson();
    }

    public int hd() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return 2;
        }
        return adDownloadModel.getExecutorGroup();
    }

    public boolean i() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableOppoAutoDownload();
    }

    public String io() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickStartLabel();
    }

    public boolean j() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAutoDownloadOnCardShow();
    }

    public String je() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public boolean jl() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.enablePause();
    }

    public String ju() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getAppIcon();
    }

    public Object k() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraObject();
    }

    public boolean kz() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return true;
        }
        return adDownloadEventConfig.isEnableClickEvent();
    }

    public Map<String, String> l() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getHeaders();
    }

    public String ld() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getPackageName();
    }

    public String m() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getStorageDenyLabel();
    }

    public String o() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    public boolean pb() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.autoInstallWithoutNotification();
    }

    public boolean qh() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? com.ss.android.download.api.bl.a.ok(com.ss.android.socialbase.downloader.h.ok.ok(tg()), ah()) : adDownloadModel.shouldDownloadWithPatchApply();
    }

    public String qu() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getNotificationJumpUrl();
    }

    public boolean qx() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public boolean r() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableShowComplianceDialog();
    }

    public boolean rh() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAH();
    }

    public int ry() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getVersionCode();
    }

    public List<String> sg() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getBackupUrls();
    }

    public String sj() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public List<String> sr() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getClickTrackUrl();
    }

    public boolean t() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAM();
    }

    public String td() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickButtonTag();
    }

    public JSONObject tg() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDownloadSettings();
    }

    public String to() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getLogExtra();
    }

    public String tr() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getFilePath();
    }

    public String u() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickLabel();
    }

    public String ul() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    public long v() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getId();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return c.d.a.a.a.a.a.ok().ok(0, bl.ok).ok(1, Boolean.valueOf(bl.f6366a)).ok(10000, 3).a();
    }

    public boolean vk() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowNotification();
    }

    public int vz() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return 0;
        }
        return adDownloadEventConfig.getDownloadScene();
    }

    public void w() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceWifi();
    }

    public boolean wv() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowToast();
    }

    public String x() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getRefer();
    }

    public int xh() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return 1;
        }
        return adDownloadModel.getFunnelType();
    }

    public String xy() {
        AdDownloadModel adDownloadModel = this.s;
        return adDownloadModel == null ? "" : adDownloadModel.getName();
    }

    public String y() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickInstallLabel();
    }

    public boolean yt() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isNeedWifi();
    }

    public int yz() {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getModelType();
    }

    public boolean z() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableNewActivity();
    }

    public String zz() {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickItemTag();
    }

    private void k(boolean z) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(z);
        } catch (Throwable unused) {
        }
    }

    private void kf(int i2) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setDownloadMode(i2);
    }

    private void n(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG);
        String str2 = (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG);
        String str3 = (String) map.get(TTDownloadField.TT_CLICK_LABEL);
        int iIntValue = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue();
        String str4 = (String) map.get(TTDownloadField.TT_REFER);
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON);
        String str5 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_START);
        String str6 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        String str7 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE);
        String str8 = (String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY);
        String str9 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean zBooleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject3 = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickLabel(str3).setClickStartLabel(str5).setClickContinueLabel(str6).setClickPauseLabel(str7).setStorageDenyLabel(str8).setClickInstallLabel(str9).setIsEnableClickEvent(zBooleanValue).setDownloadScene(iIntValue).setIsEnableV3Event(zBooleanValue2).setRefer(str4).setExtraJson(jSONObject).setParamsJson(jSONObject2);
        this.f6375h = paramsJson;
        if (jSONObject3 != null) {
            paramsJson.setExtraEventObject(jSONObject3);
        }
        this.p = this.f6375h.build();
    }

    private void s(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG);
        String str2 = (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG);
        String str3 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_START);
        String str4 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        String str5 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE);
        String str6 = (String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY);
        String str7 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean zBooleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickStartLabel(str3).setClickContinueLabel(str4).setClickPauseLabel(str5).setStorageDenyLabel(str6).setClickInstallLabel(str7).setIsEnableClickEvent(zBooleanValue).setIsEnableV3Event(zBooleanValue2);
        this.f6375h = isEnableV3Event;
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.p = this.f6375h.build();
    }

    public boolean h() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.shouldUseNewWebView();
    }

    public AdDownloadModel i(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFileName(str);
    }

    public AdDownloadModel j(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setDownloadUrl(str);
    }

    public AdDownloadModel r(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAppIcon(str);
    }

    public AdDownloadModel rh(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setMimeType(str);
    }

    public AdDownloadModel t(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFilePath(str);
    }

    public AdDownloadModel x(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionName(str);
    }

    public AdDownloadModel z(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNotificationJumpUrl(str);
    }

    private void bl(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int iIntValue = ((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue();
        int iIntValue2 = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue();
        boolean zBooleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_BACK_DIALOG)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ADD_TO_DOWNLOAD_MANAGE)).booleanValue();
        Object obj = map.get(TTDownloadField.TT_EXTRA_OPERATION);
        boolean zBooleanValue3 = ((Boolean) map.get(TTDownloadField.TT_SHOULD_USE_NEW_WEB_VIEW)).booleanValue();
        int iIntValue3 = ((Integer) map.get(TTDownloadField.TT_INTERCEPT_FLAG)).intValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        Object obj2 = map.get(TTDownloadField.TT_EXTRA_OBJECT);
        boolean zBooleanValue4 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue();
        boolean zBooleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(iIntValue).setDownloadMode(iIntValue2).setIsEnableBackDialog(zBooleanValue).setIsAddToDownloadManage(zBooleanValue2).setExtraOperation(obj).setShouldUseNewWebView(zBooleanValue3).setInterceptFlag(iIntValue3).setExtraJson(jSONObject).setExtraObject(obj2).setEnableShowComplianceDialog(zBooleanValue4).setIsAutoDownloadOnCardShow(zBooleanValue5).setEnableNewActivity(zBooleanValue6).setEnableAH(zBooleanValue7).setEnableAM(zBooleanValue8).setEnableOppoAutoDownload(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
        this.n = enableOppoAutoDownload;
        this.kf = enableOppoAutoDownload.build();
    }

    public void h(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setStartToast(str);
    }

    public AdDownloadModel k(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setPackageName(str);
    }

    public int kf() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return 1;
        }
        return adDownloadController.getDowloadChunkCount();
    }

    public int p() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getInterceptFlag();
    }

    public JSONObject q() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraJson();
    }

    private void kf(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long jLongValue = ((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue();
        String str = (String) map.get(TTDownloadField.TT_MD5);
        long jLongValue2 = ((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue();
        boolean zBooleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue();
        int iIntValue = ((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue();
        List<String> list = (List) map.get(TTDownloadField.TT_CLICK_TRACK_URL);
        List<String> list2 = (List) map.get(TTDownloadField.TT_BACK_UP_URLS);
        String str2 = (String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL);
        String str3 = (String) map.get(TTDownloadField.TT_MIME_TYPE);
        Map<String, String> map2 = (Map) map.get(TTDownloadField.TT_HEADERS);
        boolean zBooleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue();
        boolean zBooleanValue3 = ((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue();
        String str4 = (String) map.get(TTDownloadField.TT_FILE_NAME);
        int iIntValue2 = ((Integer) map.get(TTDownloadField.TT_VERSION_CODE)).intValue();
        String str5 = (String) map.get(TTDownloadField.TT_VERSION_NAME);
        String str6 = (String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL);
        com.ss.android.download.api.model.s sVarOk = new s.ok().ok(str6).a((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).ok();
        int iIntValue3 = ((Integer) map.get(TTDownloadField.TT_EXECUTOR_GROUP)).intValue();
        String str7 = (String) map.get(TTDownloadField.TT_START_TOAST);
        String str8 = (String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE);
        boolean zBooleanValue4 = ((Boolean) map.get(TTDownloadField.TT_AUTO_INSTALL)).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get(TTDownloadField.TT_DISTINCT_DIR)).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_PAUSE)).booleanValue();
        long jLongValue3 = ((Long) map.get("id")).longValue();
        String str9 = (String) map.get(TTDownloadField.TT_APP_ICON);
        boolean zBooleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue();
        String str10 = (String) map.get(TTDownloadField.TT_LOG_EXTRA);
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS);
        String str11 = (String) map.get(TTDownloadField.TT_FILE_PATH);
        String str12 = (String) map.get(TTDownloadField.TT_DOWNLOAD_URL);
        String str13 = (String) map.get("appName");
        String str14 = (String) map.get("packageName");
        boolean zBooleanValue9 = ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue();
        String str15 = (String) map.get(TTDownloadField.TT_OPEN_URL);
        String str16 = (String) map.get(TTDownloadField.TT_WEB_TITLE);
        String str17 = (String) map.get(TTDownloadField.TT_WEB_URL);
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(jLongValue).setMd5(str).setId(jLongValue3).setExtraValue(jLongValue2).setIsAd(zBooleanValue).setModelType(iIntValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(zBooleanValue2).setIsShowNotification(zBooleanValue7).setNeedWifi(zBooleanValue3).setFileName(str4).setVersionCode(iIntValue2).setVersionName(str5).setQuickAppModel(sVarOk).setAutoInstallWithoutNotification(zBooleanValue8).setExecutorGroup(iIntValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(zBooleanValue4).setDistinctDir(zBooleanValue5).setEnablePause(zBooleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.s.2
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str18, String str19) {
                return null;
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str11)) {
            fileUriProvider.setFilePath(str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            fileUriProvider.setDownloadUrl(str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            fileUriProvider.setAppName(str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            fileUriProvider.setPackageName(str14);
        }
        fileUriProvider.setNeedIndependentProcess(zBooleanValue9);
        fileUriProvider.setDeepLink(ok(jLongValue3, str15, str16, str17));
        this.s = this.bl.build();
    }

    public AdDownloadModel h(boolean z) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsShowNotification(z);
    }

    public <T> T ok(Class<T> cls, int i2, Map<String, Object> map) {
        DownloadModel downloadModelS;
        DownloadModel downloadModelS2;
        DownloadEventConfig downloadEventConfigN;
        DownloadController downloadControllerKf;
        DownloadModel downloadModelS3;
        DownloadEventConfig downloadEventConfigN2;
        DownloadController downloadControllerKf2;
        DownloadEventConfig downloadEventConfigN3;
        DownloadController downloadControllerKf3;
        DownloadEventConfig downloadEventConfigN4;
        DownloadController downloadControllerKf4;
        switch (i2) {
            case 3:
                bl.ok(((Integer) map.get(TTDownloadField.TT_HID)).intValue());
                break;
            case 4:
                AdDownloadModel adDownloadModel = this.s;
                bl.ok().ok(adDownloadModel == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel.getDownloadUrl(), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue());
                break;
            case 5:
                int iIntValue = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                AdDownloadModel adDownloadModel2 = this.s;
                if (adDownloadModel2 == null) {
                    downloadModelS = s(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    downloadModelS = s(adDownloadModel2);
                }
                bl.ok().ok(this.f6374a, iIntValue, bl(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), downloadModelS);
                break;
            case 6:
                AdDownloadModel adDownloadModel3 = this.s;
                break;
            case 7:
                bl.a();
                break;
            case 8:
                AdDownloadModel adDownloadModel4 = this.s;
                bl.ok().ok(adDownloadModel4 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel4.getDownloadUrl(), ((Boolean) map.get(TTDownloadField.TT_FORCE)).booleanValue());
                break;
            case 9:
                bl.ok(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get(TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                break;
            case 10:
                bl.ok((String) map.get(TTDownloadField.TT_DOWNLOAD_PATH));
                break;
            case 12:
                Uri uri = (Uri) map.get("uri");
                AdDownloadModel adDownloadModel5 = this.s;
                if (adDownloadModel5 == null) {
                    downloadModelS2 = s(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    downloadModelS2 = s(adDownloadModel5);
                }
                AdDownloadEventConfig adDownloadEventConfig = this.p;
                if (adDownloadEventConfig == null) {
                    downloadEventConfigN = n(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    downloadEventConfigN = n(adDownloadEventConfig);
                }
                AdDownloadController adDownloadController = this.kf;
                if (adDownloadController == null) {
                    downloadControllerKf = kf(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    downloadControllerKf = kf(adDownloadController);
                }
                IDownloadButtonClickListener iDownloadButtonClickListenerQ = q(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (!ok(iDownloadButtonClickListenerQ)) {
                }
                break;
            case 13:
                int iIntValue2 = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                boolean zBooleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue();
                String str = (String) map.get(TTDownloadField.TT_USERAGENT);
                AdDownloadModel adDownloadModel6 = this.s;
                if (adDownloadModel6 == null) {
                    downloadModelS3 = s(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    downloadModelS3 = s(adDownloadModel6);
                }
                DownloadModel downloadModel = downloadModelS3;
                AdDownloadEventConfig adDownloadEventConfig2 = this.p;
                if (adDownloadEventConfig2 == null) {
                    downloadEventConfigN2 = n(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    downloadEventConfigN2 = n(adDownloadEventConfig2);
                }
                DownloadEventConfig downloadEventConfig = downloadEventConfigN2;
                AdDownloadController adDownloadController2 = this.kf;
                if (adDownloadController2 == null) {
                    downloadControllerKf2 = kf(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    downloadControllerKf2 = kf(adDownloadController2);
                }
                DownloadController downloadController = downloadControllerKf2;
                DownloadStatusChangeListener downloadStatusChangeListenerBl = bl(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER));
                IDownloadButtonClickListener iDownloadButtonClickListenerQ2 = q(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (ok(iDownloadButtonClickListenerQ2)) {
                    bl.ok().n().ok(this.f6374a, str, zBooleanValue, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListenerBl, iIntValue2, iDownloadButtonClickListenerQ2);
                } else {
                    bl.ok().n().ok(this.f6374a, str, zBooleanValue, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListenerBl, iIntValue2);
                }
                break;
            case 14:
                AdDownloadModel adDownloadModel7 = this.s;
                long jLongValue = adDownloadModel7 == null ? ((Long) map.get("id")).longValue() : adDownloadModel7.getId();
                AdDownloadModel adDownloadModel8 = this.s;
                break;
            case 16:
                AdDownloadModel adDownloadModel9 = this.s;
                String downloadUrl = adDownloadModel9 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel9.getDownloadUrl();
                AdDownloadModel adDownloadModel10 = this.s;
                long jLongValue2 = adDownloadModel10 == null ? ((Long) map.get("id")).longValue() : adDownloadModel10.getId();
                int iIntValue3 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                AdDownloadEventConfig adDownloadEventConfig3 = this.p;
                if (adDownloadEventConfig3 == null) {
                    downloadEventConfigN3 = n(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    downloadEventConfigN3 = n(adDownloadEventConfig3);
                }
                DownloadEventConfig downloadEventConfig2 = downloadEventConfigN3;
                AdDownloadController adDownloadController3 = this.kf;
                if (adDownloadController3 == null) {
                    downloadControllerKf3 = kf(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    downloadControllerKf3 = kf(adDownloadController3);
                }
                bl.ok().ok(downloadUrl, jLongValue2, iIntValue3, downloadEventConfig2, downloadControllerKf3);
                break;
            case 17:
                AdDownloadModel adDownloadModel11 = this.s;
                String downloadUrl2 = adDownloadModel11 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel11.getDownloadUrl();
                long jLongValue3 = ((Long) map.get("id")).longValue();
                int iIntValue4 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                AdDownloadEventConfig adDownloadEventConfig4 = this.p;
                if (adDownloadEventConfig4 == null) {
                    downloadEventConfigN4 = n(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    downloadEventConfigN4 = n(adDownloadEventConfig4);
                }
                DownloadEventConfig downloadEventConfig3 = downloadEventConfigN4;
                AdDownloadController adDownloadController4 = this.kf;
                if (adDownloadController4 == null) {
                    downloadControllerKf4 = kf(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    downloadControllerKf4 = kf(adDownloadController4);
                }
                bl.ok().ok(downloadUrl2, jLongValue3, iIntValue4, downloadEventConfig3, downloadControllerKf4, p(map.get(TTDownloadField.TT_ITEM_CLICK_LISTENER)), q(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER)));
                break;
            case 18:
                AdDownloadModel adDownloadModel12 = this.s;
                break;
            case 19:
                AdDownloadModel adDownloadModel13 = this.s;
                break;
            case 23:
                if (((Boolean) map.get(TTDownloadField.TT_MATE_IS_EMPTY)).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.bl = builder;
                    this.s = builder.build();
                } else {
                    a(map);
                }
                break;
            case 24:
                ok((String) map.get(TTDownloadField.TT_APP_ICON), (String) map.get("appName"), (String) map.get("packageName"));
                break;
            case 25:
                ok(((Integer) map.get(TTDownloadField.TT_AUTO_OPEN)).intValue(), ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue(), ((Boolean) map.get(TTDownloadField.TT_IS_HAVE_DOWNLOAD_SDK_CONFIG)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue());
                break;
            case 26:
                kf(((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue());
                break;
            case 28:
                k(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
                break;
            case 29:
                s(map);
                break;
            case 30:
                a(((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue());
                break;
            case 31:
                n(((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue());
                break;
            case 32:
                bl(map);
                break;
            case 44:
                ok(((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue());
                break;
            case 46:
                ok(((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue());
                break;
            case 49:
                a(((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue());
                break;
            case 50:
                bl(((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue());
                break;
            case 53:
                ok(map.get(TTDownloadField.TT_EXTRA_OBJECT));
                break;
            case 54:
                ok((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                break;
            case 56:
                n(map);
                break;
            case 72:
                a(map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT));
                break;
            case 73:
                ok((String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG));
                break;
            case 74:
                a((JSONObject) map.get(TTDownloadField.TT_EVENT_CONFIG_EXTRA_JSON));
                break;
            case 75:
                bl((JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON));
                break;
            case 76:
                a((String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG));
                break;
            case 78:
                bl((String) map.get(TTDownloadField.TT_REFER));
                break;
            case 79:
                s((String) map.get(TTDownloadField.TT_QUICK_APP_EVENT_TAG));
                break;
            case 80:
                kf(map);
                break;
            case 98:
                w();
                break;
            case 100:
                dx();
                break;
            case 101:
                cf();
                break;
            case 123:
                n((String) map.get(TTDownloadField.TT_MD5));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH /* 124 */:
                ok(((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue());
                break;
            case 125:
                s(((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue());
                break;
            case 127:
                a(((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue());
                break;
            case 128:
                kf((String) map.get("appName"));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA /* 129 */:
                s((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                break;
            case 130:
                h((String) map.get(TTDownloadField.TT_START_TOAST));
                break;
            case 131:
                p((String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID /* 132 */:
                bl(((Long) map.get("id")).longValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD /* 133 */:
                kf(((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE /* 134 */:
                bl(((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_LOG_EXTRA /* 135 */:
                q((String) map.get(TTDownloadField.TT_LOG_EXTRA));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME /* 136 */:
                k((String) map.get("packageName"));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON /* 137 */:
                r((String) map.get(TTDownloadField.TT_APP_ICON));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL /* 139 */:
                ok((List<String>) map.get(TTDownloadField.TT_CLICK_TRACK_URL));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL /* 140 */:
                j((String) map.get(TTDownloadField.TT_DOWNLOAD_URL));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS /* 141 */:
                a((List<String>) map.get(TTDownloadField.TT_BACK_UP_URLS));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL /* 142 */:
                z((String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE /* 143 */:
                rh((String) map.get(TTDownloadField.TT_MIME_TYPE));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS /* 144 */:
                ok((Map<String, String>) map.get(TTDownloadField.TT_HEADERS));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION /* 145 */:
                h(((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH /* 146 */:
                t((String) map.get(TTDownloadField.TT_FILE_PATH));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME /* 147 */:
                i((String) map.get(TTDownloadField.TT_FILE_NAME));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS /* 148 */:
                p(((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE /* 149 */:
                s(((Integer) map.get(TTDownloadField.TT_VERSION_CODE)).intValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME /* 150 */:
                x((String) map.get(TTDownloadField.TT_VERSION_NAME));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_QUICK_APP_MODEL /* 151 */:
                ok(new s.ok().ok((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL)).a((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).ok());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_AUTO_INSTALL_WITHOUT_NOTIFICATION /* 152 */:
                q(((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FUNNEL_TYPE /* 153 */:
                n(((Integer) map.get(TTDownloadField.TT_FUNNEL_TYPE)).intValue());
                break;
        }
        return null;
    }

    public void p(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setSdkMonitorScene(str);
    }

    public AdDownloadModel q(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setLogExtra(str);
    }

    public AdDownloadModel p(boolean z) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNeedIndependentProcess(z);
    }

    public AdDownloadModel q(boolean z) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAutoInstallWithoutNotification(z);
    }

    public boolean a() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableBackDialog();
    }

    public void a(boolean z) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setIsAutoDownloadOnCardShow(z);
    }

    public void a(Object obj) {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraEventObject(obj);
    }

    public void a(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraJson(jSONObject);
    }

    public Object s() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraClickOperation();
    }

    public void a(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickItemTag(str);
    }

    public void s(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setQuickAppEventTag(str);
    }

    public void a(int i2) {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setDownloadScene(i2);
    }

    public void s(boolean z) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setNeedWifi(z);
    }

    public void a(long j) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtraValue(j);
    }

    public void s(JSONObject jSONObject) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtra(jSONObject);
    }

    public AdDownloadModel a(List<String> list) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setBackupUrls(list);
    }

    public AdDownloadModel s(int i2) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionCode(i2);
    }

    public boolean n() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableMultipleDownload();
    }

    public boolean bl() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAddToDownloadManage();
    }

    public void n(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setMd5(str);
    }

    public void bl(boolean z) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableNewActivity(z);
    }

    public void n(boolean z) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setIsShowToast(z);
    }

    public void bl(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setParamsJson(jSONObject);
    }

    public AdDownloadModel n(int i2) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFunnelType(i2);
    }

    public void bl(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setRefer(str);
    }

    public AdDownloadModel bl(long j) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setId(j);
    }

    public AdDownloadModel bl(int i2) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setModelType(i2);
    }

    public void kf(String str) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setAppName(str);
    }

    public AdDownloadModel kf(boolean z) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsAd(z);
    }

    public void ok(Bundle bundle) {
        bl.ok(this.f6374a);
    }

    private AdDownloadModel.Builder ok(long j, String str, boolean z, boolean z2, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j).setAppIcon(str).setIsShowNotification(z).setAutoInstallWithoutNotification(z2).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.s.1
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str11) {
                return null;
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setFilePath(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setDownloadUrl(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            fileUriProvider.setAppName(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            fileUriProvider.setPackageName(str6);
        }
        fileUriProvider.setNeedIndependentProcess(z3);
        fileUriProvider.setDeepLink(ok(j, str7, str8, str9));
        return fileUriProvider;
    }

    private DeepLink ok(long j, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void ok(String str, String str2, String str3) {
        AdDownloadModel.Builder builder = this.bl;
        if (builder == null) {
            return;
        }
        this.s = builder.setAppIcon(str).setAppName(str2).setPackageName(str3).build();
    }

    private void ok(int i2, int i3, boolean z, boolean z2, boolean z3) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i2).setDownloadMode(i3).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.n = isAddToDownloadManage;
        if (z) {
            isAddToDownloadManage.setEnableAH(z2);
            this.n.setEnableAM(z3);
        }
        this.kf = this.n.build();
    }

    public int ok() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getLinkMode();
    }

    public void ok(int i2) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setLinkMode(i2);
    }

    public void ok(boolean z) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableShowComplianceDialog(z);
    }

    public void ok(Object obj) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraObject(obj);
    }

    public void ok(JSONObject jSONObject) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraJson(jSONObject);
    }

    public void ok(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickButtonTag(str);
    }

    public void ok(long j) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExpectFileLength(j);
    }

    public AdDownloadModel ok(List<String> list) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setClickTrackUrl(list);
    }

    public AdDownloadModel ok(Map<String, String> map) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setHeaders(map);
    }

    public AdDownloadModel ok(com.ss.android.download.api.model.s sVar) {
        AdDownloadModel adDownloadModel = this.s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setQuickAppModel(sVar);
    }
}
