package com.qq.e.ads.nativ;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f9610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f9612h;

    public interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String DESCRIPTION_URL = "description_url";
        public static final String ICP_NUMBER = "icp_number";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        this.f9605a = jSONObject.optString("app_name");
        this.f9606b = jSONObject.optString(Keys.AUTHOR_NAME);
        this.f9607c = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.f9608d = jSONObject.optString(Keys.PERMISSION_URL);
        this.f9609e = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.f9610f = jSONObject.optString(Keys.VERSION_NAME);
        this.f9611g = jSONObject.optString(Keys.DESCRIPTION_URL);
        this.f9612h = jSONObject.optString(Keys.ICP_NUMBER);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.f9605a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.f9606b;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getDescriptionUrl() {
        return this.f9611g;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getIcpNumber() {
        return this.f9612h;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.f9607c;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.f9608d;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.f9609e;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.f9610f;
    }
}
