package g.a.i.b.i;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class a0 {

    public static class a extends ObjectInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set f14442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f14443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f14444c;

        static {
            HashSet hashSet = new HashSet();
            f14442a = hashSet;
            hashSet.add("java.util.TreeMap");
            hashSet.add("java.lang.Integer");
            hashSet.add("java.lang.Number");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDS");
            hashSet.add("java.util.ArrayList");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
            hashSet.add("[B");
            hashSet.add("java.util.LinkedList");
            hashSet.add("java.util.Stack");
            hashSet.add("java.util.Vector");
            hashSet.add("[Ljava.lang.Object;");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
        }

        public a(Class cls, InputStream inputStream) throws IOException {
            super(inputStream);
            this.f14444c = false;
            this.f14443b = cls;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            if (this.f14444c) {
                if (!f14442a.contains(objectStreamClass.getName())) {
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
            } else {
                if (!objectStreamClass.getName().equals(this.f14443b.getName())) {
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
                this.f14444c = true;
            }
            return super.resolveClass(objectStreamClass);
        }
    }

    public static boolean areEqual(byte[][] bArr, byte[][] bArr2) {
        if (hasNullPointer(bArr) || hasNullPointer(bArr2)) {
            throw new NullPointerException("a or b == null");
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!g.a.j.a.areEqual(bArr[i2], bArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    public static long bytesToXBigEndian(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "in == null");
        long j = 0;
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            j = (j << 8) | ((long) (bArr[i4] & 255));
        }
        return j;
    }

    public static int calculateTau(int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (((i2 >> i4) & 1) == 0) {
                return i4;
            }
        }
        return 0;
    }

    public static byte[] cloneArray(byte[] bArr) {
        Objects.requireNonNull(bArr, "in == null");
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static byte[][] cloneArray(byte[][] bArr) {
        if (hasNullPointer(bArr)) {
            throw new NullPointerException("in has null pointers");
        }
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = new byte[bArr[i2].length];
            System.arraycopy(bArr[i2], 0, bArr2[i2], 0, bArr[i2].length);
        }
        return bArr2;
    }

    public static void copyBytesAtOffset(byte[] bArr, byte[] bArr2, int i2) {
        Objects.requireNonNull(bArr, "dst == null");
        Objects.requireNonNull(bArr2, "src == null");
        if (i2 < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        }
        if (bArr2.length + i2 > bArr.length) {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            bArr[i2 + i3] = bArr2[i3];
        }
    }

    public static Object deserialize(byte[] bArr, Class cls) throws ClassNotFoundException, IOException {
        a aVar = new a(cls, new ByteArrayInputStream(bArr));
        Object object = aVar.readObject();
        if (aVar.available() != 0) {
            throw new IOException("unexpected data found at end of ObjectInputStream");
        }
        if (cls.isInstance(object)) {
            return object;
        }
        throw new IOException("unexpected class found in ObjectInputStream");
    }

    public static void dumpByteArray(byte[][] bArr) {
        if (hasNullPointer(bArr)) {
            throw new NullPointerException("x has null pointers");
        }
        for (byte[] bArr2 : bArr) {
            System.out.println(g.a.j.r.c.toHexString(bArr2));
        }
    }

    public static byte[] extractBytesAtOffset(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "src == null");
        if (i2 < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        }
        if (i2 + i3 > bArr.length) {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
        byte[] bArr2 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr2[i4] = bArr[i2 + i4];
        }
        return bArr2;
    }

    public static int getDigestSize(g.a.d.e eVar) {
        Objects.requireNonNull(eVar, "digest == null");
        String algorithmName = eVar.getAlgorithmName();
        if (algorithmName.equals("SHAKE128")) {
            return 32;
        }
        if (algorithmName.equals("SHAKE256")) {
            return 64;
        }
        return eVar.getDigestSize();
    }

    public static int getLeafIndex(long j, int i2) {
        return (int) (j & ((1 << i2) - 1));
    }

    public static long getTreeIndex(long j, int i2) {
        return j >> i2;
    }

    public static boolean hasNullPointer(byte[][] bArr) {
        if (bArr == null) {
            return true;
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIndexValid(int i2, long j) {
        if (j >= 0) {
            return j < (1 << i2);
        }
        throw new IllegalStateException("index must not be negative");
    }

    public static boolean isNewAuthenticationPathNeeded(long j, int i2, int i3) {
        return j != 0 && (j + 1) % ((long) Math.pow((double) (1 << i2), (double) i3)) == 0;
    }

    public static boolean isNewBDSInitNeeded(long j, int i2, int i3) {
        return j != 0 && j % ((long) Math.pow((double) (1 << i2), (double) (i3 + 1))) == 0;
    }

    public static int log2(int i2) {
        int i3 = 0;
        while (true) {
            i2 >>= 1;
            if (i2 == 0) {
                return i3;
            }
            i3++;
        }
    }

    public static void longToBigEndian(long j, byte[] bArr, int i2) {
        Objects.requireNonNull(bArr, "in == null");
        if (bArr.length - i2 < 8) {
            throw new IllegalArgumentException("not enough space in array");
        }
        bArr[i2] = (byte) ((j >> 56) & 255);
        bArr[i2 + 1] = (byte) ((j >> 48) & 255);
        bArr[i2 + 2] = (byte) ((j >> 40) & 255);
        bArr[i2 + 3] = (byte) ((j >> 32) & 255);
        bArr[i2 + 4] = (byte) ((j >> 24) & 255);
        bArr[i2 + 5] = (byte) ((j >> 16) & 255);
        bArr[i2 + 6] = (byte) ((j >> 8) & 255);
        bArr[i2 + 7] = (byte) (j & 255);
    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toBytesBigEndian(long j, int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            bArr[i3] = (byte) j;
            j >>>= 8;
        }
        return bArr;
    }
}
