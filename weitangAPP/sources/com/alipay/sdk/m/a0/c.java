package com.alipay.sdk.m.a0;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class c implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f5261a;

    public c(b bVar) {
        this.f5261a = bVar;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
