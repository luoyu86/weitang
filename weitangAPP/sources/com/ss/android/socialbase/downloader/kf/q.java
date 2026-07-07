package com.ss.android.socialbase.downloader.kf;

import android.util.Log;
import com.intelligoo.sdk.utils.BleLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10086a;
    private final long bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10087h;
    private long kf;
    private volatile long n;
    public volatile z ok;
    private JSONObject p;
    private final AtomicLong s;

    public q(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.s = atomicLong;
        this.f10086a = 0;
        this.bl = j;
        atomicLong.set(j);
        this.n = j;
        if (j2 >= j) {
            this.kf = j2;
        } else {
            this.kf = -1L;
        }
    }

    public long a() {
        long j = this.kf;
        if (j >= this.bl) {
            return (j - n()) + 1;
        }
        return -1L;
    }

    public long bl() {
        return this.bl;
    }

    public int h() {
        return this.f10087h;
    }

    public int k() {
        return this.f10086a;
    }

    public long kf() {
        return this.kf;
    }

    public long n() {
        z zVar = this.ok;
        if (zVar != null) {
            long jS = zVar.s();
            if (jS > this.n) {
                return jS;
            }
        }
        return this.n;
    }

    public long ok() {
        return this.s.get() - this.bl;
    }

    public void p() {
        this.f10086a++;
    }

    public void q() {
        this.f10086a--;
    }

    public JSONObject r() throws JSONException {
        JSONObject jSONObject = this.p;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.p = jSONObject;
        }
        jSONObject.put("st", bl());
        jSONObject.put("cu", s());
        jSONObject.put("en", kf());
        return jSONObject;
    }

    public long s() {
        long j = this.s.get();
        long j2 = this.kf;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public String toString() {
        return "Segment{startOffset=" + this.bl + ",\t currentOffset=" + this.s + ",\t currentOffsetRead=" + n() + ",\t endOffset=" + this.kf + '}';
    }

    public void bl(long j) {
        if (j >= this.bl) {
            this.kf = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.kf = j;
        }
    }

    public void ok(long j) {
        long j2 = this.bl;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.kf;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.s.set(j);
    }

    public void a(long j) {
        this.s.addAndGet(j);
    }

    public void s(long j) {
        if (j >= this.s.get()) {
            this.n = j;
        }
    }

    public void a(int i2) {
        this.f10086a = i2;
    }

    public void ok(int i2) {
        this.f10087h = i2;
    }

    public static String ok(List<q> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<q>() { // from class: com.ss.android.socialbase.downloader.kf.q.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public int compare(q qVar, q qVar2) {
                return (int) (qVar.bl() - qVar2.bl());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<q> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(BleLog.LINE_BREAK);
        }
        return sb.toString();
    }

    public q(q qVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.s = atomicLong;
        this.f10086a = 0;
        this.bl = qVar.bl;
        this.kf = qVar.kf;
        atomicLong.set(qVar.s.get());
        this.n = atomicLong.get();
        this.f10087h = qVar.f10087h;
    }

    public q(JSONObject jSONObject) {
        this.s = new AtomicLong();
        this.f10086a = 0;
        this.bl = jSONObject.optLong("st");
        bl(jSONObject.optLong("en"));
        ok(jSONObject.optLong("cu"));
        s(s());
    }
}
