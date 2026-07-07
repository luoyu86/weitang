package com.ss.android.socialbase.downloader.kf;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class rh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10093a;
    private final JSONObject ok;

    private rh(JSONObject jSONObject) {
        this.ok = jSONObject;
    }

    private int i() {
        return this.ok.optInt("url_balance", 2);
    }

    public boolean a() {
        return i() > 0;
    }

    public boolean bl() {
        return i() == 1;
    }

    public long h() {
        long jOptInt = ((long) this.ok.optInt("segment_min_kb", 512)) * 1024;
        return jOptInt < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : jOptInt;
    }

    public int j() {
        return this.ok.optInt("ip_strategy", 0);
    }

    public long k() {
        long jOptInt = this.ok.optInt("connect_timeout", -1);
        if (jOptInt >= 2000) {
            return jOptInt;
        }
        return -1L;
    }

    public boolean kf() {
        return this.ok.optInt("segment_mode", 1) == 0;
    }

    public int n() {
        return this.ok.optInt("buffer_size", 8192);
    }

    public void ok(int i2) {
        this.f10093a = a(i2);
    }

    public long p() {
        long jOptInt = ((long) this.ok.optInt("segment_min_init_mb", 10)) * 1048576;
        if (jOptInt < 5242880) {
            return 5242880L;
        }
        return jOptInt;
    }

    public long q() {
        long jOptInt = ((long) this.ok.optInt("segment_max_kb", 0)) * 1048576;
        if (jOptInt < h()) {
            return -1L;
        }
        return jOptInt;
    }

    public long r() {
        long jOptInt = this.ok.optInt("read_timeout", -1);
        if (jOptInt >= 4000) {
            return jOptInt;
        }
        return -1L;
    }

    public int rh() {
        return this.ok.optInt("ratio_segment", 0);
    }

    public int s() {
        return this.ok.optInt("buffer_count", 512);
    }

    public float t() {
        return Math.min(Math.max(0.0f, (float) this.ok.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public float z() {
        return (float) this.ok.optDouble("main_ratio", 0.0d);
    }

    private int a(int i2) {
        int iOptInt = this.ok.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return i() == 1 ? Math.min(iOptInt, i2) : iOptInt;
        }
        if (i() > 0) {
            return i2;
        }
        return 1;
    }

    public int ok() {
        return this.f10093a;
    }

    @NonNull
    public static rh ok(@NonNull JSONObject jSONObject) {
        return new rh(jSONObject);
    }
}
