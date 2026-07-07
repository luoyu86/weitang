package com.tianmu.j.b.c;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements AudioManager.OnAudioFocusChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<f> f12285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AudioManager f12286c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f12284a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12287d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12288e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12289f = 0;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12290a;

        public a(int i2) {
            this.f12290a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.f12290a);
        }
    }

    public d(@NonNull f fVar) {
        this.f12285b = new WeakReference<>(fVar);
        this.f12286c = (AudioManager) fVar.getContext().getApplicationContext().getSystemService("audio");
    }

    public void b() {
        AudioManager audioManager;
        if (this.f12289f == 1 || (audioManager = this.f12286c) == null) {
            return;
        }
        if (1 == audioManager.requestAudioFocus(this, 3, 1)) {
            this.f12289f = 1;
        } else {
            this.f12287d = true;
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i2) {
        if (this.f12289f == i2) {
            return;
        }
        this.f12284a.post(new a(i2));
        this.f12289f = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        f fVar = this.f12285b.get();
        if (fVar == null) {
            return;
        }
        if (i2 == -3) {
            if (!fVar.e() || fVar.s()) {
                return;
            }
            fVar.a(0.1f, 0.1f);
            return;
        }
        if (i2 == -2 || i2 == -1) {
            if (fVar.e()) {
                this.f12288e = true;
                fVar.u();
                return;
            }
            return;
        }
        if (i2 == 1 || i2 == 2) {
            if (this.f12287d || this.f12288e) {
                fVar.g();
                this.f12287d = false;
                this.f12288e = false;
            }
            if (fVar.s()) {
                return;
            }
            fVar.a(1.0f, 1.0f);
        }
    }

    public void a() {
        AudioManager audioManager = this.f12286c;
        if (audioManager == null) {
            return;
        }
        this.f12287d = false;
        audioManager.abandonAudioFocus(this);
    }
}
