package com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class a<T> extends LinkedList<T> {
    private final int max;

    public a(int i2) {
        this.max = i2;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(T t) {
        if (size() == this.max) {
            removeFirst();
        }
        return super.add(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean addAll(Collection<? extends T> collection) {
        int size = (size() + collection.size()) - this.max;
        if (size > 0) {
            removeRange(0, size);
        }
        return super.addAll(collection);
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addFirst(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addLast(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }
}
