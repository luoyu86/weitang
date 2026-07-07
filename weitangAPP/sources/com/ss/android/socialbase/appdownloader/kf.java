package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.depend.td;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.zz;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9924a;
    private y ah;
    private String bl;
    private long cf;
    private JSONObject cs;
    private String dn;
    private int dx;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9926e;
    private boolean ej;
    private long ep;
    private int er;
    private int ew;
    private boolean fb;
    private boolean fd;
    private boolean fl;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f9927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f9928h;
    private com.ss.android.socialbase.downloader.notification.ok io;
    private int[] ju;
    private String kf;
    private rh l;
    private String ld;
    private String m;
    private String n;
    private boolean o;
    private Activity ok;
    private List<com.ss.android.socialbase.downloader.model.bl> p;
    private int qu;
    private v qx;
    private IDownloadListener rh;
    private boolean ry;
    private List<String> s;
    private String t;
    private com.ss.android.socialbase.downloader.downloader.h td;
    private boolean tr;
    private zz u;
    private boolean ul;
    private IDownloadFileUriProvider vk;
    private boolean vz;
    private String w;
    private com.ss.android.socialbase.appdownloader.bl.n wv;
    private boolean x;
    private String y;
    private td yt;
    private IDownloadListener z;
    private com.ss.android.socialbase.downloader.downloader.p zz;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f9930q = true;
    private boolean k = false;
    private boolean r = true;
    private boolean j = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f9929i = "application/vnd.android.package-archive";
    private int kz = 5;
    private boolean v = true;
    private EnqueueType em = EnqueueType.ENQUEUE_NONE;
    private int sg = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
    private boolean xy = true;
    private List<z> tg = new ArrayList();

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    private boolean f9925de = true;
    private boolean to = true;

    public kf(@NonNull Context context, @NonNull String str) {
        this.f9924a = context.getApplicationContext();
        this.bl = str;
    }

    public String a() {
        return this.n;
    }

    public rh ah() {
        return this.l;
    }

    public String bl() {
        return this.f9928h;
    }

    public boolean cf() {
        return this.ry;
    }

    public long cs() {
        return this.cf;
    }

    public List<String> de() {
        return this.s;
    }

    public td dn() {
        return this.yt;
    }

    public int[] dx() {
        return this.ju;
    }

    public boolean e() {
        return this.xy;
    }

    public String ej() {
        return this.dn;
    }

    public EnqueueType em() {
        return this.em;
    }

    public String ep() {
        return this.f9927g;
    }

    public zz er() {
        return this.u;
    }

    public boolean ew() {
        return this.f9925de;
    }

    public int fb() {
        return this.sg;
    }

    public boolean fd() {
        return this.ej;
    }

    public boolean fl() {
        return this.fd;
    }

    public int g() {
        return this.qu;
    }

    public Activity getActivity() {
        return this.ok;
    }

    public Context getContext() {
        return this.f9924a;
    }

    public boolean h() {
        return this.r;
    }

    public com.ss.android.socialbase.downloader.downloader.h i() {
        return this.td;
    }

    public String io() {
        return this.m;
    }

    public String j() {
        return this.f9929i;
    }

    public IDownloadListener k() {
        return this.rh;
    }

    public boolean kf() {
        return this.k;
    }

    public boolean kz() {
        return this.fl;
    }

    public com.ss.android.socialbase.appdownloader.bl.n l() {
        return this.wv;
    }

    public boolean m() {
        return this.fb;
    }

    public boolean n() {
        return this.f9930q;
    }

    public int o() {
        return this.kz;
    }

    public String ok() {
        return this.bl;
    }

    public boolean p() {
        return this.j;
    }

    public IDownloadListener q() {
        return this.z;
    }

    public String qu() {
        return this.kf;
    }

    public boolean qx() {
        return this.tr;
    }

    public String r() {
        return this.t;
    }

    public com.ss.android.socialbase.downloader.notification.ok rh() {
        return this.io;
    }

    public String ry() {
        return this.w;
    }

    public List<com.ss.android.socialbase.downloader.model.bl> s() {
        return this.p;
    }

    public boolean sg() {
        return this.vz;
    }

    public com.ss.android.socialbase.downloader.downloader.p t() {
        return this.zz;
    }

    public boolean td() {
        return this.o;
    }

    public String tg() {
        return this.ld;
    }

    public JSONObject to() {
        return this.cs;
    }

    public int tr() {
        return this.dx;
    }

    public String u() {
        return this.y;
    }

    public long ul() {
        return this.ep;
    }

    public boolean v() {
        return this.f9926e;
    }

    public v vk() {
        return this.qx;
    }

    public boolean vz() {
        return this.v;
    }

    public boolean w() {
        return this.to;
    }

    public IDownloadFileUriProvider wv() {
        return this.vk;
    }

    public boolean x() {
        return this.ul;
    }

    public y xy() {
        return this.ah;
    }

    public int y() {
        return this.er;
    }

    public List<z> yt() {
        return this.tg;
    }

    public boolean z() {
        return this.x;
    }

    public int zz() {
        return this.ew;
    }

    public kf a(String str) {
        this.kf = str;
        return this;
    }

    public kf bl(@NonNull String str) {
        this.f9928h = str;
        return this;
    }

    public kf h(String str) {
        this.y = str;
        return this;
    }

    public kf i(boolean z) {
        this.f9925de = z;
        return this;
    }

    public kf j(boolean z) {
        this.fd = z;
        return this;
    }

    public kf k(boolean z) {
        this.fl = z;
        return this;
    }

    public kf kf(String str) {
        this.f9929i = str;
        return this;
    }

    public kf n(String str) {
        this.t = str;
        return this;
    }

    public void ok(int i2) {
        this.ew = i2;
    }

    public kf p(String str) {
        this.m = str;
        return this;
    }

    public kf q(String str) {
        this.f9927g = str;
        return this;
    }

    public kf r(boolean z) {
        this.f9926e = z;
        return this;
    }

    public kf rh(boolean z) {
        this.vz = z;
        return this;
    }

    public kf s(String str) {
        this.dn = str;
        return this;
    }

    public kf t(boolean z) {
        this.ry = z;
        return this;
    }

    public kf z(boolean z) {
        this.xy = z;
        return this;
    }

    public kf a(boolean z) {
        this.k = z;
        return this;
    }

    public kf bl(boolean z) {
        this.j = z;
        return this;
    }

    public kf h(boolean z) {
        this.fb = z;
        return this;
    }

    public kf k(String str) {
        this.ld = str;
        return this;
    }

    public kf kf(boolean z) {
        this.o = z;
        return this;
    }

    public kf n(boolean z) {
        this.ul = z;
        return this;
    }

    public kf ok(String str) {
        this.n = str;
        return this;
    }

    public kf p(boolean z) {
        this.ej = z;
        return this;
    }

    public kf q(boolean z) {
        this.v = z;
        return this;
    }

    public kf r(String str) {
        this.w = str;
        return this;
    }

    public kf s(boolean z) {
        this.x = z;
        return this;
    }

    public kf a(int i2) {
        this.kz = i2;
        return this;
    }

    public kf bl(int i2) {
        this.er = i2;
        return this;
    }

    public kf kf(int i2) {
        this.dx = i2;
        return this;
    }

    public kf n(int i2) {
        this.qu = i2;
        return this;
    }

    public kf ok(List<com.ss.android.socialbase.downloader.model.bl> list) {
        this.p = list;
        return this;
    }

    public kf s(int i2) {
        this.sg = i2;
        return this;
    }

    public kf a(List<String> list) {
        this.s = list;
        return this;
    }

    public kf ok(boolean z) {
        this.f9930q = z;
        return this;
    }

    public kf ok(IDownloadListener iDownloadListener) {
        this.z = iDownloadListener;
        return this;
    }

    public kf ok(long j) {
        this.ep = j;
        return this;
    }

    public kf ok(EnqueueType enqueueType) {
        this.em = enqueueType;
        return this;
    }

    public kf ok(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.vk = iDownloadFileUriProvider;
        return this;
    }

    public kf ok(td tdVar) {
        this.yt = tdVar;
        return this;
    }

    public kf ok(JSONObject jSONObject) {
        this.cs = jSONObject;
        return this;
    }

    public kf ok(z zVar) {
        synchronized (this.tg) {
            if (zVar != null) {
                if (!this.tg.contains(zVar)) {
                    this.tg.add(zVar);
                    return this;
                }
            }
            return this;
        }
    }
}
