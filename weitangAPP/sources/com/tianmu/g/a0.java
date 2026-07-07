package com.tianmu.g;

import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f12037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f12038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f12039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f12040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f12041i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final long n;

    public a0(int i2, int i3, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i4, int i5, int i6, long j9) {
        this.f12033a = i2;
        this.f12034b = i3;
        this.f12035c = j;
        this.f12036d = j2;
        this.f12037e = j3;
        this.f12038f = j4;
        this.f12039g = j5;
        this.f12040h = j6;
        this.f12041i = j7;
        this.j = j8;
        this.k = i4;
        this.l = i5;
        this.m = i6;
        this.n = j9;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f12033a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f12034b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((this.f12034b / this.f12033a) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f12035c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f12036d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f12037e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f12040h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f12038f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f12039g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f12041i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f12033a + ", size=" + this.f12034b + ", cacheHits=" + this.f12035c + ", cacheMisses=" + this.f12036d + ", downloadCount=" + this.k + ", totalDownloadSize=" + this.f12037e + ", averageDownloadSize=" + this.f12040h + ", totalOriginalBitmapSize=" + this.f12038f + ", totalTransformedBitmapSize=" + this.f12039g + ", averageOriginalBitmapSize=" + this.f12041i + ", averageTransformedBitmapSize=" + this.j + ", originalBitmapCount=" + this.l + ", transformedBitmapCount=" + this.m + ", timeStamp=" + this.n + '}';
    }
}
