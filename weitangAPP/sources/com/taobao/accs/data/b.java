package com.taobao.accs.data;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Comparator<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f10286a;

    public b(a aVar) {
        this.f10286a = aVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Integer num, Integer num2) {
        return num.intValue() - num2.intValue();
    }
}
