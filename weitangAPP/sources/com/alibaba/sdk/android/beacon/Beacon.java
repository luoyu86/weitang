package com.alibaba.sdk.android.beacon;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Beacon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final HandlerThread f72a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final b f73a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final List<OnUpdateListener> f74a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<OnServiceErrListener> f4606b;
    private final String mAppKey;
    private final String mAppSecret;
    private final Map<String, String> mExtras;
    private Handler mHandler;
    private long mLoopInterval;

    public final class BeaconHandler extends Handler {
        public static final int MSG_ADD_ERR_LISTENER = 6;
        public static final int MSG_ADD_UPDATE_LISTENER = 4;
        public static final int MSG_ERR_CALLBACK = 7;
        public static final int MSG_REMOVE_UPDATE_LISTENER = 5;
        public static final int MSG_START = 0;
        public static final int MSG_START_POLLING = 2;
        public static final int MSG_STOP_POLLING = 3;
        public static final int MSG_UPDATE = 1;

        public BeaconHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                switch (message.what) {
                    case 0:
                        Beacon.this.c((Context) message.obj);
                        break;
                    case 1:
                        Beacon.this.d((Context) message.obj);
                        break;
                    case 2:
                        Beacon.this.e((Context) message.obj);
                        break;
                    case 3:
                        Beacon.this.b();
                        break;
                    case 4:
                        Beacon.this.a((OnUpdateListener) message.obj);
                        break;
                    case 5:
                        Beacon.this.b((OnUpdateListener) message.obj);
                        break;
                    case 6:
                        Beacon.this.a((OnServiceErrListener) message.obj);
                        break;
                    case 7:
                        Beacon.this.b((Error) message.obj);
                        break;
                }
            } catch (Exception e2) {
                Log.i("beacon", e2.getMessage(), e2);
            }
        }
    }

    public static final class Builder {
        public String mAppKey;
        public String mAppSecret;
        public Map<String, String> mExtras = new HashMap();
        public long mLoopInterval = 300000;

        public Builder appKey(String str) {
            this.mAppKey = str.trim();
            return this;
        }

        public Builder appSecret(String str) {
            this.mAppSecret = str.trim();
            return this;
        }

        public Beacon build() {
            return new Beacon(this);
        }

        public Builder extras(Map<String, String> map) {
            this.mExtras.putAll(map);
            return this;
        }

        public Builder loopInterval(long j) {
            if (j < 60000) {
                this.mLoopInterval = 60000L;
            } else {
                this.mLoopInterval = j;
            }
            return this;
        }
    }

    public static final class Config {
        public final String key;
        public final String value;

        public Config(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public static final class Error {
        public final String errCode;
        public final String errMsg;

        public Error(String str, String str2) {
            this.errCode = str;
            this.errMsg = str2;
        }
    }

    public interface OnServiceErrListener {
        void onErr(Error error);
    }

    public interface OnUpdateListener {
        void onUpdate(List<Config> list);
    }

    private Beacon(Builder builder) {
        this.f74a = new ArrayList();
        this.f4606b = new ArrayList();
        this.f4605a = 255;
        this.mAppKey = builder.mAppKey;
        this.mAppSecret = builder.mAppSecret;
        this.mExtras = builder.mExtras;
        this.mLoopInterval = builder.mLoopInterval;
        this.f73a = new b(this);
        HandlerThread handlerThread = new HandlerThread("Beacon Daemon");
        this.f72a = handlerThread;
        handlerThread.start();
        a();
    }

    private void a() {
        this.mHandler = new BeaconHandler(this.f72a.getLooper());
    }

    private void a(Context context) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = context;
        this.mHandler.sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OnServiceErrListener onServiceErrListener) {
        this.f4606b.add(onServiceErrListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OnUpdateListener onUpdateListener) {
        this.f74a.add(onUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.mHandler.getLooper().quitSafely();
        } else {
            this.mHandler.getLooper().quit();
        }
        a();
    }

    private void b(Context context) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.obj = context;
        this.mHandler.sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Error error) {
        Iterator<OnServiceErrListener> it = this.f4606b.iterator();
        while (it.hasNext()) {
            it.next().onErr(error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(OnUpdateListener onUpdateListener) {
        this.f74a.remove(onUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        b(context);
        this.f4605a = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        this.f73a.m35a(context, this.mAppKey, this.mAppSecret, this.mExtras);
        List<Config> listA = this.f73a.a();
        Iterator<OnUpdateListener> it = this.f74a.iterator();
        while (it.hasNext()) {
            it.next().onUpdate(listA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        }
        a(context);
        this.mHandler.sendEmptyMessageDelayed(2, this.mLoopInterval);
    }

    private boolean isStarted() {
        return this.f4605a == 1;
    }

    public static final void setPrepare(boolean z) {
        a.f4607a = z;
    }

    public void a(Error error) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 7;
        messageObtain.obj = error;
        this.mHandler.sendMessage(messageObtain);
    }

    public void addServiceErrListener(OnServiceErrListener onServiceErrListener) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 6;
        messageObtain.obj = onServiceErrListener;
        this.mHandler.sendMessage(messageObtain);
    }

    public void addUpdateListener(OnUpdateListener onUpdateListener) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 4;
        messageObtain.obj = onUpdateListener;
        this.mHandler.sendMessage(messageObtain);
    }

    public List<Config> getConfigs() {
        return this.f73a.a();
    }

    public void start(Context context) {
        if (isStarted()) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = context;
        this.mHandler.sendMessage(messageObtain);
    }

    public void stop() {
        if (isStarted()) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            this.mHandler.sendMessage(messageObtain);
        }
    }
}
