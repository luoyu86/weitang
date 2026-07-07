package com.ss.android.downloadlib.addownload.a;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    public static class ok {
        private static q ok = new q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences bl() {
        return r.getContext().getSharedPreferences("sp_ad_download_event", 0);
    }

    @NonNull
    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.ok.a> a() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.ok.a> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = bl().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long jLongValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.downloadad.api.ok.a aVarA = com.ss.android.downloadad.api.ok.a.a(new JSONObject(String.valueOf(entry.getValue())));
                    if (jLongValue > 0 && aVarA != null) {
                        concurrentHashMap.put(Long.valueOf(jLongValue), aVarA);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }

    private q() {
    }

    public static q ok() {
        return ok.ok;
    }

    public void ok(com.ss.android.downloadad.api.ok.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        ok((Collection<com.ss.android.downloadad.api.ok.a>) arrayList);
    }

    public synchronized void ok(final Collection<com.ss.android.downloadad.api.ok.a> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.q.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor editorEdit = q.this.bl().edit();
                        for (com.ss.android.downloadad.api.ok.a aVar : collection) {
                            if (aVar != null && aVar.a() != 0) {
                                editorEdit.putString(String.valueOf(aVar.a()), aVar.ju().toString());
                            }
                        }
                        editorEdit.apply();
                    }
                }, true);
            }
        }
    }

    public void ok(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.q.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = q.this.bl().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            }
        }, true);
    }
}
