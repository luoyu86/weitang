package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTDownloadEventModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6373a;
    private JSONObject bl;
    private String ok;
    private JSONObject s;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.bl;
    }

    public String getLabel() {
        return this.f6373a;
    }

    public JSONObject getMaterialMeta() {
        return this.s;
    }

    public String getTag() {
        return this.ok;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.bl = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.f6373a = str;
        return this;
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.s = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.ok = str;
        return this;
    }
}
