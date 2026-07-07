package anet.channel.bytes;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TreeSet<ByteArray> f381a = new TreeSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ByteArray f382b = ByteArray.create(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Random f383c = new Random();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f384d = 0;

    /* JADX INFO: renamed from: anet.channel.bytes.a$a, reason: collision with other inner class name */
    public static class C0006a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f385a = new a();
    }

    public synchronized void a(ByteArray byteArray) {
        if (byteArray != null) {
            int i2 = byteArray.bufferLength;
            if (i2 < 524288) {
                this.f384d += (long) i2;
                this.f381a.add(byteArray);
                while (this.f384d > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.f384d -= (long) (this.f383c.nextBoolean() ? this.f381a.pollFirst() : this.f381a.pollLast()).bufferLength;
                }
            }
        }
    }

    public synchronized ByteArray a(int i2) {
        if (i2 >= 524288) {
            return ByteArray.create(i2);
        }
        ByteArray byteArray = this.f382b;
        byteArray.bufferLength = i2;
        ByteArray byteArrayCeiling = this.f381a.ceiling(byteArray);
        if (byteArrayCeiling == null) {
            byteArrayCeiling = ByteArray.create(i2);
        } else {
            Arrays.fill(byteArrayCeiling.buffer, (byte) 0);
            byteArrayCeiling.dataLength = 0;
            this.f381a.remove(byteArrayCeiling);
            this.f384d -= (long) byteArrayCeiling.bufferLength;
        }
        return byteArrayCeiling;
    }

    public ByteArray a(byte[] bArr, int i2) {
        ByteArray byteArrayA = a(i2);
        System.arraycopy(bArr, 0, byteArrayA.buffer, 0, i2);
        byteArrayA.dataLength = i2;
        return byteArrayA;
    }
}
