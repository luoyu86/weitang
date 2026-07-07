package com.ta.utdid2.a.a;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f10202d = true;

    /* JADX INFO: renamed from: com.ta.utdid2.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0176a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f10203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10204b;
    }

    public static class b extends AbstractC0176a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final byte[] f10205b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final byte[] f10206c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ boolean f10207d = true;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f146c;
        private int count;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private final byte[] f147d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f10208e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private final byte[] f148e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f10209f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f10210g;

        public b(int i2, byte[] bArr) {
            this.f10203a = bArr;
            this.f10208e = (i2 & 1) == 0;
            boolean z = (i2 & 2) == 0;
            this.f10209f = z;
            this.f10210g = (i2 & 4) != 0;
            this.f148e = (i2 & 8) == 0 ? f10205b : f10206c;
            this.f147d = new byte[2];
            this.f146c = 0;
            this.count = z ? 19 : -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x00e6 A[SYNTHETIC] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 513
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.a.a.a.b.a(byte[], int, int, boolean):boolean");
        }
    }

    private a() {
    }

    public static byte[] encode(byte[] bArr, int i2) {
        return encode(bArr, 0, bArr.length, i2);
    }

    public static String encodeToString(byte[] bArr, int i2) {
        try {
            return new String(encode(bArr, i2), CharEncoding.US_ASCII);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @SuppressLint({"Assert"})
    public static byte[] encode(byte[] bArr, int i2, int i3, int i4) {
        b bVar = new b(i4, null);
        int i5 = (i3 / 3) * 4;
        if (!bVar.f10208e) {
            int i6 = i3 % 3;
            if (i6 == 1) {
                i5 += 2;
            } else if (i6 == 2) {
                i5 += 3;
            }
        } else if (i3 % 3 > 0) {
            i5 += 4;
        }
        if (bVar.f10209f && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (bVar.f10210g ? 2 : 1);
        }
        bVar.f10203a = new byte[i5];
        bVar.a(bArr, i2, i3, true);
        if (f10202d || bVar.f10204b == i5) {
            return bVar.f10203a;
        }
        throw new AssertionError();
    }
}
