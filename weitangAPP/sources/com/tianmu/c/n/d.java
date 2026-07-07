package com.tianmu.c.n;

import com.tianmu.utils.TianmuViewUtil;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d f11836c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, com.tianmu.biz.widget.a> f11837a = new HashMap(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<Integer> f11838b = new LinkedHashSet(5);

    private d() {
    }

    public static d a() {
        if (f11836c == null) {
            synchronized (d.class) {
                if (f11836c == null) {
                    f11836c = new d();
                }
            }
        }
        return f11836c;
    }

    public synchronized void b(Integer num) {
        Map<Integer, com.tianmu.biz.widget.a> map = this.f11837a;
        if (map != null && this.f11838b != null) {
            if (map.get(num) != null) {
                this.f11837a.get(num).w();
            }
            this.f11837a.remove(num);
            this.f11838b.remove(num);
        }
    }

    public synchronized com.tianmu.biz.widget.a a(Integer num) {
        Map<Integer, com.tianmu.biz.widget.a> map = this.f11837a;
        if (map == null || this.f11838b == null) {
            return null;
        }
        com.tianmu.biz.widget.a aVar = map.get(num);
        if (aVar != null) {
            this.f11838b.remove(num);
            this.f11838b.add(num);
        }
        return aVar;
    }

    public synchronized void a(Integer num, com.tianmu.biz.widget.a aVar) {
        Map<Integer, com.tianmu.biz.widget.a> map = this.f11837a;
        if (map != null && this.f11838b != null) {
            if (map.size() == 5) {
                Integer next = this.f11838b.iterator().next();
                TianmuViewUtil.removeSelfFromParent(this.f11837a.get(next));
                b(next);
            }
            this.f11838b.add(num);
            this.f11837a.put(num, aVar);
        }
    }
}
