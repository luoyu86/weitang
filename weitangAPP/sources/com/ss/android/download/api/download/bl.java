package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class bl implements DownloadEventConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9713a;
    private String bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f9714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f9715i;
    private Object j;
    private String k;
    private String kf;
    private String n;
    private String ok;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f9716q;
    private String r;
    private boolean rh;
    private String s;
    private boolean t;
    private String x;
    private boolean z;

    public static final class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9717a;
        private String bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f9718h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f9719i;
        private Object j;
        private String k;
        private String kf;
        private String n;
        private String ok;
        private String p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private String f9720q;
        private String r;
        private boolean rh;
        private String s;
        private boolean t;
        private String x;
        private boolean z;

        public bl ok() {
            return new bl(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.ok;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.kf;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f9714h;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.bl;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.n;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.s;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.x;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.k;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f9713a;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.z;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i2) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public bl() {
    }

    private bl(ok okVar) {
        this.ok = okVar.ok;
        this.f9713a = okVar.f9717a;
        this.bl = okVar.bl;
        this.s = okVar.s;
        this.n = okVar.n;
        this.kf = okVar.kf;
        this.f9714h = okVar.f9718h;
        this.p = okVar.p;
        this.f9716q = okVar.f9720q;
        this.k = okVar.k;
        this.r = okVar.r;
        this.j = okVar.j;
        this.z = okVar.z;
        this.rh = okVar.rh;
        this.t = okVar.t;
        this.f9715i = okVar.f9719i;
        this.x = okVar.x;
    }
}
