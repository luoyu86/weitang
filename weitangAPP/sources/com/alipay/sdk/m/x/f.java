package com.alipay.sdk.m.x;

import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Stack<e> f5803a = new Stack<>();

    public void a(e eVar) {
        this.f5803a.push(eVar);
    }

    public boolean b() {
        return this.f5803a.isEmpty();
    }

    public e c() {
        return this.f5803a.pop();
    }

    public void a() {
        if (b()) {
            return;
        }
        Iterator<e> it = this.f5803a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f5803a.clear();
    }
}
