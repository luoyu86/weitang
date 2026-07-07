package com.tianmu.j.b.c;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.tianmu.j.b.c.a implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaPlayer f12280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f12281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12282d;

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaPlayer f12283a;

        public a(b bVar, MediaPlayer mediaPlayer) {
            this.f12283a = mediaPlayer;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f12283a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public b(Context context) {
        this.f12281c = context.getApplicationContext();
    }

    private boolean m() {
        try {
            for (MediaPlayer.TrackInfo trackInfo : this.f12280b.getTrackInfo()) {
                if (trackInfo.getTrackType() == 1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.tianmu.j.b.c.a
    public void a(String str, Map<String, String> map) {
        try {
            this.f12280b.setDataSource(this.f12281c, Uri.parse(str), map);
        } catch (Exception unused) {
            this.f12279a.onError();
        }
    }

    @Override // com.tianmu.j.b.c.a
    public long b() {
        return this.f12280b.getDuration();
    }

    @Override // com.tianmu.j.b.c.a
    public float c() {
        if (Build.VERSION.SDK_INT < 23) {
            return 1.0f;
        }
        try {
            float speed = this.f12280b.getPlaybackParams().getSpeed();
            if (speed == 0.0f) {
                return 1.0f;
            }
            return speed;
        } catch (Exception unused) {
            return 1.0f;
        }
    }

    @Override // com.tianmu.j.b.c.a
    public void d() {
        this.f12280b = new MediaPlayer();
        l();
        this.f12280b.setAudioStreamType(3);
        this.f12280b.setOnErrorListener(this);
        this.f12280b.setOnCompletionListener(this);
        this.f12280b.setOnInfoListener(this);
        this.f12280b.setOnBufferingUpdateListener(this);
        this.f12280b.setOnPreparedListener(this);
        this.f12280b.setOnVideoSizeChangedListener(this);
    }

    @Override // com.tianmu.j.b.c.a
    public boolean e() {
        return this.f12280b.isPlaying();
    }

    @Override // com.tianmu.j.b.c.a
    public void f() {
        try {
            this.f12280b.pause();
        } catch (IllegalStateException unused) {
            this.f12279a.onError();
        }
    }

    @Override // com.tianmu.j.b.c.a
    public void g() {
        try {
            this.f12282d = true;
            this.f12280b.prepareAsync();
        } catch (IllegalStateException unused) {
            this.f12279a.onError();
        }
    }

    @Override // com.tianmu.j.b.c.a
    public void h() {
        this.f12280b.setOnErrorListener(null);
        this.f12280b.setOnCompletionListener(null);
        this.f12280b.setOnInfoListener(null);
        this.f12280b.setOnBufferingUpdateListener(null);
        this.f12280b.setOnPreparedListener(null);
        this.f12280b.setOnVideoSizeChangedListener(null);
        k();
        MediaPlayer mediaPlayer = this.f12280b;
        this.f12280b = null;
        new a(this, mediaPlayer).start();
    }

    @Override // com.tianmu.j.b.c.a
    public void i() {
        k();
        this.f12280b.reset();
        this.f12280b.setSurface(null);
        this.f12280b.setDisplay(null);
        this.f12280b.setVolume(1.0f, 1.0f);
    }

    @Override // com.tianmu.j.b.c.a
    public void j() {
        try {
            this.f12280b.start();
        } catch (IllegalStateException unused) {
            this.f12279a.onError();
        }
    }

    @Override // com.tianmu.j.b.c.a
    public void k() {
        try {
            if (this.f12280b.isPlaying()) {
                this.f12280b.stop();
            }
        } catch (IllegalStateException unused) {
            this.f12279a.onError();
        }
    }

    public void l() {
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f12279a.a();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        this.f12279a.onError();
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        if (i2 != 3) {
            this.f12279a.a(i2, i3);
            return true;
        }
        if (!this.f12282d) {
            return true;
        }
        this.f12279a.a(i2, i3);
        this.f12282d = false;
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f12279a.b();
        j();
        if (m()) {
            return;
        }
        this.f12279a.a(3, 0);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        if (videoWidth == 0 || videoHeight == 0) {
            return;
        }
        this.f12279a.b(videoWidth, videoHeight);
    }

    @Override // com.tianmu.j.b.c.a
    public void a(AssetFileDescriptor assetFileDescriptor) {
        try {
            this.f12280b.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        } catch (Exception unused) {
            this.f12279a.onError();
        }
    }

    @Override // com.tianmu.j.b.c.a
    public void a(long j) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f12280b.seekTo(j, 3);
            } else {
                this.f12280b.seekTo((int) j);
            }
        } catch (IllegalStateException unused) {
            this.f12279a.onError();
        }
    }

    @Override // com.tianmu.j.b.c.a
    public long a() {
        return this.f12280b.getCurrentPosition();
    }

    @Override // com.tianmu.j.b.c.a
    public void a(Surface surface) {
        try {
            this.f12280b.setSurface(surface);
        } catch (Exception unused) {
            this.f12279a.onError();
        }
    }

    @Override // com.tianmu.j.b.c.a
    public void a(float f2, float f3) {
        this.f12280b.setVolume(f2, f3);
    }

    @Override // com.tianmu.j.b.c.a
    public void a(boolean z) {
        this.f12280b.setLooping(z);
    }
}
