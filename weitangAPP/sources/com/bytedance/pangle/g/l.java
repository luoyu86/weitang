package com.bytedance.pangle.g;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f6090a = Os.sysconf(OsConstants._SC_PAGESIZE);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileDescriptor f6091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f6092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f6093d;

    public l(FileDescriptor fileDescriptor, long j, long j2) {
        this.f6091b = fileDescriptor;
        this.f6092c = j;
        this.f6093d = j2;
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f6093d;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.pangle.g.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.bytedance.pangle.g.j r20, long r21, int r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.l.a(com.bytedance.pangle.g.j, long, int):void");
    }
}
