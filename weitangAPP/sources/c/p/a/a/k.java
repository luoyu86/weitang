package c.p.a.a;

import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f3002a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3003b = "9A0301038A7A8A7B";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3004c = "9A0301037A8A7A8B";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UUID f3005d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UUID f3006e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UUID f3007f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f3008g = true;

    public static k getInstance() {
        return f3002a;
    }

    public UUID getNotifyUuid() {
        return this.f3006e;
    }

    public UUID getServiceUuid() {
        return this.f3007f;
    }

    public UUID getWriterUuid() {
        return this.f3005d;
    }

    public boolean isReadDataToDisconnect() {
        return this.f3008g;
    }

    public void setNotifyUuid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3006e = UUID.fromString(str);
    }

    public void setReadDataToDisconnect(boolean z) {
        this.f3008g = z;
    }

    public void setServiceUuid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3007f = UUID.fromString(str);
    }

    public void setWriterUuid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3005d = UUID.fromString(str);
    }
}
