package cn.admobiletop.adsuyi.c;

import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4202i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final long n;

    public M(int i2, int i3, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i4, int i5, int i6, long j9) {
        this.f4194a = i2;
        this.f4195b = i3;
        this.f4196c = j;
        this.f4197d = j2;
        this.f4198e = j3;
        this.f4199f = j4;
        this.f4200g = j5;
        this.f4201h = j6;
        this.f4202i = j7;
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
        printWriter.println(this.f4194a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f4195b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((this.f4195b / this.f4194a) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f4196c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f4197d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f4198e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f4201h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f4199f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f4200g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f4202i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f4194a + ", size=" + this.f4195b + ", cacheHits=" + this.f4196c + ", cacheMisses=" + this.f4197d + ", downloadCount=" + this.k + ", totalDownloadSize=" + this.f4198e + ", averageDownloadSize=" + this.f4201h + ", totalOriginalBitmapSize=" + this.f4199f + ", totalTransformedBitmapSize=" + this.f4200g + ", averageOriginalBitmapSize=" + this.f4202i + ", averageTransformedBitmapSize=" + this.j + ", originalBitmapCount=" + this.l + ", transformedBitmapCount=" + this.m + ", timeStamp=" + this.n + '}';
    }
}
