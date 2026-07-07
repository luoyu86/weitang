package c.e.a.d;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f1227a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f1228b = new CopyOnWriteArraySet();

    public static u getInstance() {
        return f1227a;
    }

    public void initData() {
        Set<String> stringSet = w.getInstance().getStringSet("remote_open_door_data", null);
        if (stringSet != null) {
            this.f1228b.addAll(stringSet);
        }
    }

    public boolean isRemoteOpenDoorData(String str) {
        return this.f1228b.contains(str);
    }

    public void updateRemoteOpenDoorData(String str, boolean z) {
        if (z) {
            this.f1228b.add(str);
        } else {
            this.f1228b.remove(str);
        }
        w.getInstance().putStringSet("remote_open_door_data", this.f1228b);
    }

    public void updateRemoteOpenDoorData(String str) {
        updateRemoteOpenDoorData(str, true);
    }
}
