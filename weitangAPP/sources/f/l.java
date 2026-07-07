package f;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f13004a = Logger.getLogger(l.class.getName());

    public class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f13005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OutputStream f13006b;

        public a(u uVar, OutputStream outputStream) {
            this.f13005a = uVar;
            this.f13006b = outputStream;
        }

        @Override // f.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f13006b.close();
        }

        @Override // f.s, java.io.Flushable
        public void flush() throws IOException {
            this.f13006b.flush();
        }

        @Override // f.s
        public u timeout() {
            return this.f13005a;
        }

        public String toString() {
            return "sink(" + this.f13006b + ")";
        }

        @Override // f.s
        public void write(f.c cVar, long j) throws IOException {
            v.checkOffsetAndCount(cVar.f12980c, 0L, j);
            while (j > 0) {
                this.f13005a.throwIfReached();
                p pVar = cVar.f12979b;
                int iMin = (int) Math.min(j, pVar.f13021c - pVar.f13020b);
                this.f13006b.write(pVar.f13019a, pVar.f13020b, iMin);
                int i2 = pVar.f13020b + iMin;
                pVar.f13020b = i2;
                long j2 = iMin;
                j -= j2;
                cVar.f12980c -= j2;
                if (i2 == pVar.f13021c) {
                    cVar.f12979b = pVar.pop();
                    q.a(pVar);
                }
            }
        }
    }

    public class b implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f13007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InputStream f13008b;

        public b(u uVar, InputStream inputStream) {
            this.f13007a = uVar;
            this.f13008b = inputStream;
        }

        @Override // f.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f13008b.close();
        }

        @Override // f.t
        public long read(f.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (j == 0) {
                return 0L;
            }
            try {
                this.f13007a.throwIfReached();
                p pVarG = cVar.g(1);
                int i2 = this.f13008b.read(pVarG.f13019a, pVarG.f13021c, (int) Math.min(j, 8192 - pVarG.f13021c));
                if (i2 == -1) {
                    return -1L;
                }
                pVarG.f13021c += i2;
                long j2 = i2;
                cVar.f12980c += j2;
                return j2;
            } catch (AssertionError e2) {
                if (l.a(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }

        @Override // f.t
        public u timeout() {
            return this.f13007a;
        }

        public String toString() {
            return "source(" + this.f13008b + ")";
        }
    }

    public class c implements s {
        @Override // f.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // f.s, java.io.Flushable
        public void flush() throws IOException {
        }

        @Override // f.s
        public u timeout() {
            return u.NONE;
        }

        @Override // f.s
        public void write(f.c cVar, long j) throws IOException {
            cVar.skip(j);
        }
    }

    public class d extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Socket f13009a;

        public d(Socket socket) {
            this.f13009a = socket;
        }

        @Override // f.a
        public IOException newTimeoutException(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(com.alipay.sdk.m.m.a.h0);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // f.a
        public void timedOut() {
            try {
                this.f13009a.close();
            } catch (AssertionError e2) {
                if (!l.a(e2)) {
                    throw e2;
                }
                l.f13004a.log(Level.WARNING, "Failed to close timed out socket " + this.f13009a, (Throwable) e2);
            } catch (Exception e3) {
                l.f13004a.log(Level.WARNING, "Failed to close timed out socket " + this.f13009a, (Throwable) e3);
            }
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static s appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static s b(OutputStream outputStream, u uVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (uVar != null) {
            return new a(uVar, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static s blackhole() {
        return new c();
    }

    public static e buffer(t tVar) {
        return new o(tVar);
    }

    public static t c(InputStream inputStream, u uVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (uVar != null) {
            return new b(uVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static f.a d(Socket socket) {
        return new d(socket);
    }

    public static s sink(OutputStream outputStream) {
        return b(outputStream, new u());
    }

    public static t source(InputStream inputStream) {
        return c(inputStream, new u());
    }

    public static f.d buffer(s sVar) {
        return new n(sVar);
    }

    public static s sink(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        f.a aVarD = d(socket);
        return aVarD.sink(b(socket.getOutputStream(), aVarD));
    }

    public static t source(File file) throws FileNotFoundException {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    @IgnoreJRERequirement
    public static t source(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static t source(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                f.a aVarD = d(socket);
                return aVarD.source(c(socket.getInputStream(), aVarD));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static s sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    @IgnoreJRERequirement
    public static s sink(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }
}
