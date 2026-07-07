package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class VideoOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f9547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f9550i;

    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9551a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9552b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f9553c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f9554d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f9555e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f9556f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f9557g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f9558h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f9559i;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f9551a = z;
            return this;
        }

        public Builder setAutoPlayPolicy(int i2) {
            if (i2 < 0 || i2 > 2) {
                i2 = 1;
                GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
            }
            this.f9552b = i2;
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f9557g = z;
            return this;
        }

        public Builder setEnableDetailPage(boolean z) {
            this.f9555e = z;
            return this;
        }

        public Builder setEnableUserControl(boolean z) {
            this.f9556f = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.f9558h = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.f9559i = i2;
            return this;
        }

        public Builder setNeedCoverImage(boolean z) {
            this.f9554d = z;
            return this;
        }

        public Builder setNeedProgressBar(boolean z) {
            this.f9553c = z;
            return this;
        }
    }

    public VideoOption(Builder builder) {
        this.f9542a = builder.f9551a;
        this.f9543b = builder.f9552b;
        this.f9544c = builder.f9553c;
        this.f9545d = builder.f9554d;
        this.f9546e = builder.f9555e;
        this.f9547f = builder.f9556f;
        this.f9548g = builder.f9557g;
        this.f9549h = builder.f9558h;
        this.f9550i = builder.f9559i;
    }

    public boolean getAutoPlayMuted() {
        return this.f9542a;
    }

    public int getAutoPlayPolicy() {
        return this.f9543b;
    }

    public int getMaxVideoDuration() {
        return this.f9549h;
    }

    public int getMinVideoDuration() {
        return this.f9550i;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f9542a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f9543b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f9548g));
        } catch (Exception e2) {
            GDTLogger.d("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f9548g;
    }

    public boolean isEnableDetailPage() {
        return this.f9546e;
    }

    public boolean isEnableUserControl() {
        return this.f9547f;
    }

    public boolean isNeedCoverImage() {
        return this.f9545d;
    }

    public boolean isNeedProgressBar() {
        return this.f9544c;
    }
}
