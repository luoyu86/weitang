package com.alibaba.mtl.log.upload;

import com.alibaba.mtl.log.d.a;
import com.alibaba.mtl.log.d.e;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.l;
import com.alibaba.mtl.log.d.n;
import com.taobao.accs.utl.UtilityImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {
    public static int B = 0;
    private static volatile boolean G = false;
    private static boolean H = false;
    public int C = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f4585a = 200.0f;
    public int D = 0;

    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e2, code lost:
    
        com.alibaba.mtl.log.upload.a.G = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01e5, code lost:
    
        com.alibaba.mtl.log.upload.a.G = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void I() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.upload.a.I():void");
    }

    private a.C0054a a(String str, Map<String, Object> map) {
        if (str != null) {
            byte[] bArr = e.a(2, str, map, false).data;
            i.a("UploadTask", "url:", str);
            if (bArr != null) {
                String str2 = null;
                try {
                    str2 = new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                if (str2 != null) {
                    i.a("UploadTask", "result:", str2);
                    return com.alibaba.mtl.log.d.a.a(str2);
                }
            }
        }
        return a.C0054a.f4551a;
    }

    private int b(List<com.alibaba.mtl.log.model.a> list) {
        if (list == null) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = list.get(i3).X;
            if (str != null && "6005".equalsIgnoreCase(str)) {
                i2++;
            }
        }
        return i2;
    }

    private int h() {
        if (this.C == -1) {
            String strU = l.u();
            if (UtilityImpl.NET_TYPE_WIFI.equalsIgnoreCase(strU)) {
                this.C = 20;
            } else if ("4G".equalsIgnoreCase(strU)) {
                this.C = 16;
            } else if ("3G".equalsIgnoreCase(strU)) {
                this.C = 12;
            } else {
                this.C = 8;
            }
        }
        return this.C;
    }

    public static boolean isRunning() {
        return G;
    }

    public abstract void G();

    public abstract void H();

    @Override // java.lang.Runnable
    public void run() {
        try {
            I();
            G();
        } catch (Throwable unused) {
        }
    }

    private int a(Boolean bool, long j) {
        if (j < 0) {
            return this.C;
        }
        float f2 = this.D / j;
        if (!bool.booleanValue()) {
            this.C /= 2;
            B++;
        } else {
            if (j > 45000) {
                return this.C;
            }
            this.C = (int) ((((double) (f2 * 45000.0f)) / ((double) this.f4585a)) - ((double) B));
        }
        int i2 = this.C;
        if (i2 < 1) {
            this.C = 1;
            B = 0;
        } else if (i2 > 350) {
            this.C = 350;
        }
        i.a("UploadTask", "winsize:", Integer.valueOf(this.C));
        return this.C;
    }

    private Map<String, Object> a(List<com.alibaba.mtl.log.model.a> list) throws Throwable {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            List<String> listA = a(list.get(i2));
            if (listA != null) {
                for (int i3 = 0; i3 < listA.size(); i3++) {
                    StringBuilder sb = (StringBuilder) map.get(listA.get(i3));
                    if (sb == null) {
                        sb = new StringBuilder();
                        map.put(listA.get(i3), sb);
                    } else {
                        sb.append("\n");
                    }
                    sb.append(list.get(i2).i());
                }
            }
        }
        HashMap map2 = new HashMap();
        this.D = 0;
        for (String str : map.keySet()) {
            byte[] bArrA = a(((StringBuilder) map.get(str)).toString());
            map2.put(str, bArrA);
            this.D += bArrA.length;
        }
        float size = this.D / list.size();
        this.f4585a = size;
        i.a("UploadTask", "averagePackageSize:", Float.valueOf(size));
        return map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    private byte[] a(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r1 = 0;
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    String str2 = "UTF-8";
                    gZIPOutputStream2.write(str.getBytes("UTF-8"));
                    gZIPOutputStream2.flush();
                    gZIPOutputStream2.close();
                    r1 = str2;
                } catch (IOException e2) {
                    e = e2;
                    gZIPOutputStream = gZIPOutputStream2;
                    e.printStackTrace();
                    r1 = gZIPOutputStream;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                        r1 = gZIPOutputStream;
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = gZIPOutputStream2;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
            byte[] bArrA = n.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
            try {
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            return bArrA;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private List<String> a(com.alibaba.mtl.log.model.a aVar) {
        return com.alibaba.mtl.log.a.a.m24a(aVar.X);
    }
}
