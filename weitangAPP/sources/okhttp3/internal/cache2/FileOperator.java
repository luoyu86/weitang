package okhttp3.internal.cache2;

import f.c;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void read(long j, c cVar, long j2) throws IOException {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j, j2, cVar);
            j += jTransferTo;
            j2 -= jTransferTo;
        }
    }

    public void write(long j, c cVar, long j2) throws IOException {
        if (j2 < 0 || j2 > cVar.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(cVar, j3, j4);
            j3 += jTransferFrom;
            j4 -= jTransferFrom;
        }
    }
}
