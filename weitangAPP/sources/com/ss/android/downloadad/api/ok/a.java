package com.ss.android.downloadad.api.ok;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.r;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9739a;
    private boolean ah;
    public final AtomicBoolean bl;
    private long cf;
    private String cs;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9740d;

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    private boolean f9741de;
    private boolean dn;
    private boolean dx;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9742e;
    private long ej;
    private boolean em;
    private int ep;
    private long er;
    private transient boolean ew;
    private int fb;
    private boolean fd;
    private boolean fl;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f9744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9745i;
    private long io;
    private String j;
    private boolean ju;
    private String k;
    private long kf;
    private long kz;
    private boolean l;
    private boolean ld;
    private int m;
    private long n;
    private int o;
    public boolean ok;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f9746q;
    private String qu;
    private boolean qx;
    private String r;
    private int rh;
    private boolean ry;
    public final AtomicBoolean s;
    private boolean sg;
    private int t;
    private String td;
    private boolean tg;
    private boolean to;
    private boolean tr;
    private boolean u;
    private JSONObject ul;
    private String v;

    @AdBaseConstants.FunnelType
    private int vk;
    private long vz;
    private boolean w;
    private int wv;
    private String x;
    private String xy;
    private boolean y;
    private long yt;
    private int z;
    private String zz;

    private a() {
        this.p = 1;
        this.u = true;
        this.y = false;
        this.m = 0;
        this.ep = 0;
        this.fl = false;
        this.fd = false;
        this.em = true;
        this.sg = true;
        this.ok = true;
        this.f9739a = true;
        this.bl = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        this.vk = 1;
        this.qx = true;
        this.cf = -1L;
    }

    public void a(int i2) {
        this.ep = i2;
    }

    public String ah() {
        return this.td;
    }

    public void bl(long j) {
        this.er = j;
    }

    public AdDownloadController c() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.y).setLinkMode(this.rh).setDownloadMode(this.t).setEnableShowComplianceDialog(this.qx).setEnableAH(this.ok).setEnableAM(this.f9739a).build();
    }

    public boolean cf() {
        return this.ry;
    }

    public boolean cs() {
        return this.fl;
    }

    public AdDownloadModel d() {
        return new AdDownloadModel.Builder().setAdId(this.n).setExtraValue(this.kf).setLogExtra(this.f9744h).setPackageName(this.f9746q).setExtra(this.ul).setIsAd(this.u).setVersionCode(this.f9745i).setVersionName(this.x).setDownloadUrl(this.k).setModelType(this.z).setMimeType(this.f9742e).setAppName(this.td).setAppIcon(this.zz).setTaskKey(this.f9740d).setDeepLink(new DeepLink(this.r, this.j, null)).build();
    }

    public boolean de() {
        return this.to;
    }

    public boolean dn() {
        return this.ld;
    }

    public boolean dx() {
        return this.ew;
    }

    public long e() {
        return this.io;
    }

    public boolean ej() {
        return this.dx;
    }

    public String em() {
        return this.x;
    }

    public int ep() {
        return this.ep;
    }

    public long er() {
        return this.kz;
    }

    public boolean ew() {
        return this.dn;
    }

    public int fb() {
        return this.fb;
    }

    public int fd() {
        return this.f9745i;
    }

    public int fl() {
        return this.p;
    }

    public int g() {
        return this.f9743g;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject h() {
        return this.ul;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject i() {
        return null;
    }

    public void i(boolean z) {
        this.qx = z;
    }

    public void io(boolean z) {
        this.f9739a = z;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public long j() {
        return this.kf;
    }

    public JSONObject ju() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.n);
            jSONObject.put("mExtValue", this.kf);
            jSONObject.put("mLogExtra", this.f9744h);
            jSONObject.put("mDownloadStatus", this.p);
            jSONObject.put("mPackageName", this.f9746q);
            jSONObject.put("mIsAd", this.u);
            jSONObject.put("mTimeStamp", this.io);
            jSONObject.put("mExtras", this.ul);
            jSONObject.put("mVersionCode", this.f9745i);
            jSONObject.put("mVersionName", this.x);
            jSONObject.put("mDownloadId", this.o);
            jSONObject.put("mIsV3Event", this.ah);
            jSONObject.put("mScene", this.wv);
            jSONObject.put("mEventTag", this.qu);
            jSONObject.put("mEventRefer", this.xy);
            jSONObject.put("mDownloadUrl", this.k);
            jSONObject.put("mEnableBackDialog", this.y);
            jSONObject.put("hasSendInstallFinish", this.bl.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.s.get());
            jSONObject.put("mLastFailedErrCode", this.f9743g);
            jSONObject.put("mLastFailedErrMsg", this.v);
            jSONObject.put("mOpenUrl", this.r);
            jSONObject.put("mLinkMode", this.rh);
            jSONObject.put("mDownloadMode", this.t);
            jSONObject.put("mModelType", this.z);
            jSONObject.put("mAppName", this.td);
            jSONObject.put("mAppIcon", this.zz);
            jSONObject.put("mDownloadFailedTimes", this.m);
            long j = this.vz;
            if (j == 0) {
                j = this.io;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.ep);
            jSONObject.put("mJumpInstallTime", this.kz);
            jSONObject.put("mCancelInstallTime", this.er);
            jSONObject.put("mLastFailedResumeCount", this.fb);
            jSONObject.put("mIsUpdateDownload", this.fl);
            jSONObject.put("mOriginMimeType", this.f9742e);
            jSONObject.put("mIsPatchApplyHandled", this.fd);
            jSONObject.put("downloadFinishReason", this.cs);
            jSONObject.put("clickDownloadTime", this.yt);
            jSONObject.put("clickDownloadSize", this.ej);
            jSONObject.put("installAfterCleanSpace", this.l);
            jSONObject.put(TTDownloadField.TT_FUNNEL_TYPE, this.vk);
            jSONObject.put(TTDownloadField.TT_WEB_URL, this.j);
            jSONObject.put(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, this.qx);
            jSONObject.put(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, this.tr);
            int i2 = 1;
            jSONObject.put("enable_new_activity", this.em ? 1 : 0);
            jSONObject.put("enable_pause", this.sg ? 1 : 0);
            jSONObject.put("enable_ah", this.ok ? 1 : 0);
            if (!this.f9739a) {
                i2 = 0;
            }
            jSONObject.put("enable_am", i2);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.ju));
            jSONObject.put("task_key", this.f9740d);
        } catch (Exception e2) {
            r.u().ok(e2, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String k() {
        return this.qu;
    }

    public void kf(long j) {
        if (j > 0) {
            this.io = j;
        }
    }

    public long kz() {
        long j = this.vz;
        return j == 0 ? this.io : j;
    }

    public int l() {
        return this.rh;
    }

    public String ld() {
        return this.f9740d;
    }

    public synchronized void m() {
        this.m++;
    }

    public void n(long j) {
        this.kf = j;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadController o() {
        return c();
    }

    public void ok(int i2) {
        this.m = i2;
    }

    public void p(int i2) {
        this.wv = i2;
    }

    public void q(int i2) {
        this.vk = i2;
    }

    public boolean qu() {
        return this.y;
    }

    public long qx() {
        return this.yt;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject r() {
        return null;
    }

    public void r(String str) {
        this.zz = str;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public List<String> rh() {
        return null;
    }

    public void rh(boolean z) {
        this.to = z;
    }

    public boolean ry() {
        return this.f9741de;
    }

    public void s(int i2) {
        this.f9743g = i2;
    }

    public int sg() {
        return this.wv;
    }

    public AdDownloadEventConfig sr() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.qu).setRefer(this.xy).setIsEnableV3Event(this.ah).build();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public Object t() {
        return null;
    }

    public void t(boolean z) {
        this.ld = z;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject td() {
        return null;
    }

    public void td(boolean z) {
        this.em = z;
    }

    public boolean tg() {
        return this.fd;
    }

    public boolean to() {
        return this.ju;
    }

    public long tr() {
        return this.ej;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int u() {
        return -1;
    }

    public void u(boolean z) {
        this.ok = z;
    }

    public void ul(boolean z) {
        this.ju = z;
    }

    public String v() {
        return this.v;
    }

    public boolean vk() {
        return this.tg;
    }

    public synchronized void vz() {
        this.ep++;
    }

    public String w() {
        return this.f9742e;
    }

    public String wv() {
        return this.cs;
    }

    public void x(boolean z) {
        this.tr = z;
    }

    public long xy() {
        return this.cf;
    }

    public int y() {
        return this.m;
    }

    public boolean yt() {
        return this.l;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean z() {
        return this.ah;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int zz() {
        return this.o;
    }

    public void a(long j) {
        this.kz = j;
    }

    public void bl(int i2) {
        this.fb = i2;
    }

    public void h(int i2) {
        this.o = i2;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadModel io() {
        return d();
    }

    public void j(int i2) {
        this.z = i2;
    }

    public void k(String str) {
        this.td = str;
    }

    public void kf(int i2) {
        this.f9745i = i2;
    }

    public void n(int i2) {
        this.p = i2;
    }

    public void ok(long j) {
        this.vz = j;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int p() {
        return this.vk;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String q() {
        return this.xy;
    }

    public void r(int i2) {
        this.t = i2;
    }

    public void rh(String str) {
        this.f9740d = str;
    }

    public void s(long j) {
        this.n = j;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadEventConfig ul() {
        return sr();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean x() {
        return this.em;
    }

    public void z(String str) {
        this.f9742e = str;
    }

    public void zz(boolean z) {
        this.sg = z;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public long a() {
        return this.n;
    }

    public void bl(String str) {
        this.f9744h = str;
    }

    public void h(String str) {
        this.xy = str;
    }

    public void j(String str) {
        this.cs = str;
    }

    public void k(int i2) {
        this.rh = i2;
    }

    public void kf(String str) {
        this.qu = str;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String n() {
        return this.f9746q;
    }

    public void ok(String str) {
        this.v = str;
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.r = str;
    }

    public void r(boolean z) {
        this.ry = z;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String s() {
        return this.f9744h;
    }

    public void z(boolean z) {
        this.f9741de = z;
    }

    public void a(String str) {
        this.f9746q = str;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean bl() {
        return this.u;
    }

    public void h(long j) {
        this.cf = j;
    }

    public void j(boolean z) {
        this.dn = z;
    }

    public void k(boolean z) {
        this.ew = z;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String kf() {
        return this.r;
    }

    public void n(String str) {
        this.j = str;
    }

    public void ok(boolean z) {
        this.u = z;
    }

    public void p(long j) {
        this.yt = j;
    }

    public void q(long j) {
        this.ej = j;
    }

    public void s(String str) {
        this.x = str;
    }

    public void a(boolean z) {
        this.ah = z;
    }

    public void bl(boolean z) {
        this.y = z;
    }

    public void h(boolean z) {
        this.dx = z;
    }

    public void kf(boolean z) {
        this.l = z;
    }

    public void n(boolean z) {
        this.tg = z;
    }

    public void ok(JSONObject jSONObject) {
        this.ul = jSONObject;
    }

    public void p(boolean z) {
        this.fl = z;
    }

    public void q(boolean z) {
        this.fd = z;
    }

    public void s(boolean z) {
        this.w = z;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.s(com.ss.android.download.api.bl.a.ok(jSONObject, "mId"));
            aVar.n(com.ss.android.download.api.bl.a.ok(jSONObject, "mExtValue"));
            aVar.bl(jSONObject.optString("mLogExtra"));
            aVar.n(jSONObject.optInt("mDownloadStatus"));
            aVar.a(jSONObject.optString("mPackageName"));
            boolean z = true;
            aVar.ok(jSONObject.optBoolean("mIsAd", true));
            aVar.kf(com.ss.android.download.api.bl.a.ok(jSONObject, "mTimeStamp"));
            aVar.kf(jSONObject.optInt("mVersionCode"));
            aVar.s(jSONObject.optString("mVersionName"));
            aVar.h(jSONObject.optInt("mDownloadId"));
            aVar.a(jSONObject.optBoolean("mIsV3Event"));
            aVar.p(jSONObject.optInt("mScene"));
            aVar.kf(jSONObject.optString("mEventTag"));
            aVar.h(jSONObject.optString("mEventRefer"));
            aVar.p(jSONObject.optString("mDownloadUrl"));
            aVar.bl(jSONObject.optBoolean("mEnableBackDialog"));
            aVar.bl.set(jSONObject.optBoolean("hasSendInstallFinish"));
            aVar.s.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            aVar.s(jSONObject.optInt("mLastFailedErrCode"));
            aVar.ok(jSONObject.optString("mLastFailedErrMsg"));
            aVar.q(jSONObject.optString("mOpenUrl"));
            aVar.k(jSONObject.optInt("mLinkMode"));
            aVar.r(jSONObject.optInt("mDownloadMode"));
            aVar.j(jSONObject.optInt("mModelType"));
            aVar.k(jSONObject.optString("mAppName"));
            aVar.r(jSONObject.optString("mAppIcon"));
            aVar.ok(jSONObject.optInt("mDownloadFailedTimes", 0));
            aVar.ok(com.ss.android.download.api.bl.a.ok(jSONObject, "mRecentDownloadResumeTime"));
            aVar.a(jSONObject.optInt("mClickPauseTimes"));
            aVar.a(com.ss.android.download.api.bl.a.ok(jSONObject, "mJumpInstallTime"));
            aVar.bl(com.ss.android.download.api.bl.a.ok(jSONObject, "mCancelInstallTime"));
            aVar.bl(jSONObject.optInt("mLastFailedResumeCount"));
            aVar.j(jSONObject.optString("downloadFinishReason"));
            aVar.q(jSONObject.optLong("clickDownloadSize"));
            aVar.p(jSONObject.optLong("clickDownloadTime"));
            aVar.p(jSONObject.optBoolean("mIsUpdateDownload"));
            aVar.z(jSONObject.optString("mOriginMimeType"));
            aVar.q(jSONObject.optBoolean("mIsPatchApplyHandled"));
            aVar.kf(jSONObject.optBoolean("installAfterCleanSpace"));
            aVar.q(jSONObject.optInt(TTDownloadField.TT_FUNNEL_TYPE, 1));
            aVar.n(jSONObject.optString(TTDownloadField.TT_WEB_URL));
            aVar.i(jSONObject.optBoolean(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, true));
            aVar.x(jSONObject.optBoolean(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW));
            aVar.td(jSONObject.optInt("enable_new_activity", 1) == 1);
            aVar.zz(jSONObject.optInt("enable_pause", 1) == 1);
            aVar.u(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            aVar.io(z);
            aVar.ok(jSONObject.optJSONObject("mExtras"));
            aVar.ul(jSONObject.optBoolean("intent_jump_browser_success"));
            aVar.rh(jSONObject.optString("task_key"));
        } catch (Exception e2) {
            r.u().ok(e2, "NativeDownloadModel fromJson");
        }
        return aVar;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String ok() {
        return this.k;
    }

    public a(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public a(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i2) {
        this.p = 1;
        this.u = true;
        this.y = false;
        this.m = 0;
        this.ep = 0;
        this.fl = false;
        this.fd = false;
        this.em = true;
        this.sg = true;
        this.ok = true;
        this.f9739a = true;
        this.bl = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        this.vk = 1;
        this.qx = true;
        this.cf = -1L;
        this.n = downloadModel.getId();
        this.kf = downloadModel.getExtraValue();
        this.f9744h = downloadModel.getLogExtra();
        this.f9746q = downloadModel.getPackageName();
        this.ul = downloadModel.getExtra();
        this.u = downloadModel.isAd();
        this.f9745i = downloadModel.getVersionCode();
        this.x = downloadModel.getVersionName();
        this.k = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.r = downloadModel.getDeepLink().getOpenUrl();
            this.j = downloadModel.getDeepLink().getWebUrl();
        }
        this.z = downloadModel.getModelType();
        this.td = downloadModel.getName();
        this.zz = downloadModel.getAppIcon();
        this.f9742e = downloadModel.getMimeType();
        this.qu = downloadEventConfig.getClickButtonTag();
        this.xy = downloadEventConfig.getRefer();
        this.ah = downloadEventConfig.isEnableV3Event();
        this.y = downloadController.isEnableBackDialog();
        this.rh = downloadController.getLinkMode();
        this.t = downloadController.getDownloadMode();
        this.qx = downloadController.enableShowComplianceDialog();
        this.tr = downloadController.isAutoDownloadOnCardShow();
        this.em = downloadController.enableNewActivity();
        this.ok = downloadController.enableAH();
        this.f9739a = downloadController.enableAM();
        this.o = i2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.io = jCurrentTimeMillis;
        this.vz = jCurrentTimeMillis;
        this.fd = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.f9740d = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
