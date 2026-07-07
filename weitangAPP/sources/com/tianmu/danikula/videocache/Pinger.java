package com.tianmu.danikula.videocache;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class Pinger {
    private static final String PING_REQUEST = "ping";
    private static final String PING_RESPONSE = "ping ok";
    private static final String TAG = "Pinger";
    private final String host;
    private final ExecutorService pingExecutor = Executors.newSingleThreadExecutor();
    private final int port;

    public class PingCallable implements Callable<Boolean> {
        private PingCallable() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(Pinger.this.pingServer());
        }
    }

    public Pinger(String str, int i2) {
        this.host = (String) Preconditions.checkNotNull(str);
        this.port = i2;
    }

    private List<Proxy> getDefaultProxies() {
        try {
            return ProxySelector.getDefault().select(new URI(getPingUrl()));
        } catch (URISyntaxException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private String getPingUrl() {
        return String.format(Locale.US, "http://%s:%d/%s", this.host, Integer.valueOf(this.port), PING_REQUEST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pingServer() {
        HttpUrlSource httpUrlSource = new HttpUrlSource(getPingUrl());
        try {
            try {
                byte[] bytes = PING_RESPONSE.getBytes();
                httpUrlSource.open(0L);
                byte[] bArr = new byte[bytes.length];
                httpUrlSource.read(bArr);
                boolean zEquals = Arrays.equals(bytes, bArr);
                Log.i(TAG, "Ping response: `" + new String(bArr) + "`, pinged? " + zEquals);
                return zEquals;
            } catch (ProxyCacheException unused) {
                Log.i(TAG, "Error reading ping response");
                httpUrlSource.close();
                return false;
            }
        } finally {
            httpUrlSource.close();
        }
    }

    public boolean isPingRequest(String str) {
        return PING_REQUEST.equals(str);
    }

    public boolean ping(int i2, int i3) {
        Preconditions.checkArgument(i2 >= 1);
        Preconditions.checkArgument(i3 > 0);
        int i4 = 0;
        while (i4 < i2) {
            try {
            } catch (InterruptedException | ExecutionException unused) {
                Log.i(TAG, "Error pinging server due to unexpected error");
            } catch (TimeoutException unused2) {
                Log.i(TAG, "Error pinging server (attempt: " + i4 + ", timeout: " + i3 + "). ");
            }
            if (((Boolean) this.pingExecutor.submit(new PingCallable()).get(i3, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i4++;
            i3 *= 2;
        }
        Log.i(TAG, String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i4), Integer.valueOf(i3 / 2), getDefaultProxies()));
        return false;
    }

    public void responseToPing(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(PING_RESPONSE.getBytes());
    }
}
