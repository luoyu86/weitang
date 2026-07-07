package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f9629c;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9631b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.f9630a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f9631b = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f9629c = new JSONObject();
        this.f9627a = builder.f9630a;
        this.f9628b = builder.f9631b;
    }

    public String getCustomData() {
        return this.f9627a;
    }

    public JSONObject getOptions() {
        return this.f9629c;
    }

    public String getUserId() {
        return this.f9628b;
    }
}
