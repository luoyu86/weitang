package com.taobao.accs.messenger;

import android.app.Service;
import android.os.Messenger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MessengerService extends Service {
    public static final String INTENT = "intent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f10327a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Messenger f10328b = new Messenger(new b(this));

    public static /* synthetic */ void a() {
    }
}
