package com.intelligoo.sdk.b.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.intelligoo.sdk.ConstantsUtils;
import com.intelligoo.sdk.c;
import com.intelligoo.sdk.c.b;
import com.intelligoo.sdk.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements BluetoothAdapter.LeScanCallback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f9189c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c<Long> f9193g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f9187a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f9188b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9190d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9191e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9192f = false;

    public a a(int i2) {
        this.f9190d = i2;
        return this;
    }

    public a a(p pVar) {
        this.f9189c = pVar;
        return this;
    }

    public a a(boolean z) {
        this.f9191e = z;
        return this;
    }

    public abstract void a();

    public abstract void a(com.intelligoo.sdk.a.a aVar);

    public int b() {
        if (!this.f9191e) {
            this.f9192f = false;
            if (this.f9189c != null) {
                a();
                this.f9189c.b((BluetoothAdapter.LeScanCallback) this);
            }
        } else {
            if (this.f9192f) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (this.f9193g == null) {
                    this.f9193g = new c<>();
                }
                if (this.f9193g.c() >= 5) {
                    Long lValueOf = Long.valueOf(System.currentTimeMillis());
                    if (Long.valueOf(lValueOf.longValue() - this.f9193g.b().longValue()).longValue() < 30000) {
                        return ConstantsUtils.SET_RESULT_ERROR_SCAN_TOO_FREQUENTLY;
                    }
                    this.f9193g.a(lValueOf);
                    this.f9193g.a();
                } else {
                    this.f9193g.a(Long.valueOf(System.currentTimeMillis()));
                }
            }
            if (this.f9190d > 0) {
                this.f9187a.postDelayed(new Runnable() { // from class: com.intelligoo.sdk.b.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar = a.this;
                        aVar.f9192f = false;
                        p pVar = aVar.f9189c;
                        if (pVar != null) {
                            pVar.a(b.SCAN_TIMEOUT);
                            a aVar2 = a.this;
                            aVar2.f9189c.b((BluetoothAdapter.LeScanCallback) aVar2);
                        }
                        a.this.a();
                    }
                }, this.f9190d);
            }
            this.f9192f = true;
            p pVar = this.f9189c;
            if (pVar != null) {
                pVar.a((BluetoothAdapter.LeScanCallback) this);
            }
        }
        return 0;
    }

    public a c() {
        this.f9187a.removeCallbacksAndMessages(null);
        return this;
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(final BluetoothDevice bluetoothDevice, final int i2, final byte[] bArr) {
        this.f9188b.post(new Runnable() { // from class: com.intelligoo.sdk.b.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(new com.intelligoo.sdk.a.a(bluetoothDevice, i2, bArr, System.currentTimeMillis()));
            }
        });
    }
}
