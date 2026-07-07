package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static c f6185d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f6186a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<PluginBroadcastReceiver, BroadcastReceiver> f6187b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Integer> f6188c = new CopyOnWriteArraySet();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<PluginBroadcastReceiver> f6190b = new CopyOnWriteArraySet();

        public final void a(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.f6190b.add(pluginBroadcastReceiver);
            }
        }

        public final void a(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set = this.f6190b;
            if (set == null || set.size() <= 0) {
                return;
            }
            for (PluginBroadcastReceiver pluginBroadcastReceiver : this.f6190b) {
                if (pluginBroadcastReceiver != null) {
                    try {
                        pluginBroadcastReceiver.onReceive(context, intent);
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + (intent != null ? intent.getAction() : "") + "[exception]:", th);
                    }
                }
            }
        }
    }

    private c() {
    }

    public static c a() {
        if (f6185d == null) {
            synchronized (com.bytedance.pangle.service.a.a.class) {
                if (f6185d == null) {
                    f6185d = new c();
                }
            }
        }
        return f6185d;
    }

    public final void a(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        Iterator<String> itActionsIterator = intentFilter.actionsIterator();
        while (itActionsIterator.hasNext()) {
            String next = itActionsIterator.next();
            if (next != null) {
                a aVar = this.f6186a.get(next);
                if (aVar != null) {
                    aVar.a(pluginBroadcastReceiver);
                } else {
                    a aVar2 = new a();
                    aVar2.f6189a = next;
                    aVar2.a(pluginBroadcastReceiver);
                    this.f6186a.put(next, aVar2);
                }
            }
        }
    }

    public final void a(Context context, Intent intent) {
        a value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, a> map = this.f6186a;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, a> entry : this.f6186a.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                value.a(context, intent);
            }
        }
    }
}
