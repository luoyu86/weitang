package a.a.u;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends LinkedHashMap<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f231a;

    public c(d dVar) {
        this.f231a = dVar;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, String> entry) {
        return size() > 100;
    }
}
