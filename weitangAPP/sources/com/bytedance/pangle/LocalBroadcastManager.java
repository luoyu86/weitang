package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    public static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<PluginBroadcastReceiver, ArrayList<b>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<b>> mActions = new HashMap<>();
    private final ArrayList<a> mPendingBroadcasts = new ArrayList<>();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f5930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<b> f5931b;

        public a(Intent intent, ArrayList<b> arrayList) {
            this.f5930a = intent;
            this.f5931b = arrayList;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentFilter f5932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PluginBroadcastReceiver f5933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5934c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5935d;

        public b(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.f5932a = intentFilter;
            this.f5933b = pluginBroadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f5933b);
            sb.append(" filter=");
            sb.append(this.f5932a);
            if (this.f5935d) {
                sb.append(" DEAD");
            }
            sb.append(com.alipay.sdk.m.u.i.f5699d);
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    public final void executePendingBroadcasts() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.mPendingBroadcasts.toArray(aVarArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = aVarArr[i2];
                int size2 = aVar.f5931b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    b bVar = aVar.f5931b.get(i3);
                    if (!bVar.f5935d) {
                        bVar.f5933b.onReceive(this.mAppContext, aVar.f5930a);
                    }
                }
            }
        }
    }

    public final void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            b bVar = new b(intentFilter, pluginBroadcastReceiver);
            ArrayList<b> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(pluginBroadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<b> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final boolean sendBroadcast(Intent intent) {
        int i2;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v(TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v(TAG, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    b bVar = arrayList3.get(i3);
                    if (z) {
                        Log.v(TAG, "Matching against filter " + bVar.f5932a);
                    }
                    if (bVar.f5934c) {
                        if (z) {
                            Log.v(TAG, "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i2 = i3;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = bVar.f5932a.match(action, strResolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (iMatch >= 0) {
                            if (z) {
                                Log.v(TAG, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.f5934c = true;
                            i3 = i2 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v(TAG, "  Filter did not match: ".concat(iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((b) arrayList5.get(i4)).f5934c = false;
                    }
                    this.mPendingBroadcasts.add(new a(intent, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public final void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public final void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<b> arrayListRemove = this.mReceivers.remove(pluginBroadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                b bVar = arrayListRemove.get(size);
                bVar.f5935d = true;
                for (int i2 = 0; i2 < bVar.f5932a.countActions(); i2++) {
                    String action = bVar.f5932a.getAction(i2);
                    ArrayList<b> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.f5933b == pluginBroadcastReceiver) {
                                bVar2.f5935d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
