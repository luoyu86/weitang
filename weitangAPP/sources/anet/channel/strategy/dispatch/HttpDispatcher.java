package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class HttpDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<IDispatchEventListener> f637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private anet.channel.strategy.dispatch.a f638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f642f;

    public interface IDispatchEventListener {
        void onEvent(DispatchEvent dispatchEvent);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static HttpDispatcher f643a = new HttpDispatcher();

        private a() {
        }
    }

    private void a() {
        if (this.f642f.get() || GlobalAppRuntimeInfo.getContext() == null || !this.f642f.compareAndSet(false, true)) {
            return;
        }
        this.f641e.add(DispatchConstants.getAmdcServerDomain());
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            this.f641e.addAll(Arrays.asList(DispatchConstants.initHostArray));
        }
    }

    public static HttpDispatcher getInstance() {
        return a.f643a;
    }

    public static void setInitHosts(List<String> list) {
        if (list != null) {
            DispatchConstants.initHostArray = (String[]) list.toArray(new String[0]);
        }
    }

    public synchronized void addHosts(List<String> list) {
        if (list != null) {
            this.f641e.addAll(list);
            this.f640d.clear();
        }
    }

    public void addListener(IDispatchEventListener iDispatchEventListener) {
        this.f637a.add(iDispatchEventListener);
    }

    public synchronized Set<String> getInitHosts() {
        a();
        return new HashSet(this.f641e);
    }

    public boolean isInitHostsChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zContains = this.f640d.contains(str);
        if (!zContains) {
            this.f640d.add(str);
        }
        return !zContains;
    }

    public void removeListener(IDispatchEventListener iDispatchEventListener) {
        this.f637a.remove(iDispatchEventListener);
    }

    public void sendAmdcRequest(Set<String> set, int i2) {
    }

    public void setEnable(boolean z) {
        this.f639c = z;
    }

    public void switchENV() {
        this.f640d.clear();
        this.f641e.clear();
        this.f642f.set(false);
    }

    private HttpDispatcher() {
        this.f637a = new CopyOnWriteArraySet<>();
        this.f638b = new anet.channel.strategy.dispatch.a();
        this.f639c = true;
        this.f640d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f641e = new TreeSet();
        this.f642f = new AtomicBoolean();
        a();
    }
}
