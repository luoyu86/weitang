package com.tianmu.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.tianmu.danikula.videocache.file.DiskUsage;
import com.tianmu.danikula.videocache.file.FileNameGenerator;
import com.tianmu.danikula.videocache.file.Md5FileNameGenerator;
import com.tianmu.danikula.videocache.file.TotalCountLruDiskUsage;
import com.tianmu.danikula.videocache.file.TotalSizeLruDiskUsage;
import com.tianmu.danikula.videocache.headers.EmptyHeadersInjector;
import com.tianmu.danikula.videocache.headers.HeaderInjector;
import com.tianmu.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.tianmu.danikula.videocache.sourcestorage.SourceInfoStorageFactory;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class HttpProxyCacheServer {
    private static final String PROXY_HOST = "127.0.0.1";
    private static final String TAG = "HttpProxyCacheServer";
    private final Object clientsLock;
    private final Map<String, HttpProxyCacheServerClients> clientsMap;
    private final Config config;
    private final Pinger pinger;
    private final int port;
    private final ServerSocket serverSocket;
    private final ExecutorService socketProcessor;
    private final Thread waitConnectionThread;

    public static final class Builder {
        private static final long DEFAULT_MAX_SIZE = 536870912;
        private File cacheRoot;
        private DiskUsage diskUsage = new TotalSizeLruDiskUsage(DEFAULT_MAX_SIZE);
        private FileNameGenerator fileNameGenerator = new Md5FileNameGenerator();
        private HeaderInjector headerInjector = new EmptyHeadersInjector();
        private SourceInfoStorage sourceInfoStorage;

        public Builder(Context context) {
            this.sourceInfoStorage = SourceInfoStorageFactory.newSourceInfoStorage(context);
            this.cacheRoot = StorageUtils.getIndividualCacheDirectory(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Config buildConfig() {
            return new Config(this.cacheRoot, this.fileNameGenerator, this.diskUsage, this.sourceInfoStorage, this.headerInjector);
        }

        public HttpProxyCacheServer build() {
            return new HttpProxyCacheServer(buildConfig());
        }

        public Builder cacheDirectory(File file) {
            this.cacheRoot = (File) Preconditions.checkNotNull(file);
            return this;
        }

        public Builder diskUsage(DiskUsage diskUsage) {
            this.diskUsage = (DiskUsage) Preconditions.checkNotNull(diskUsage);
            return this;
        }

        public Builder fileNameGenerator(FileNameGenerator fileNameGenerator) {
            this.fileNameGenerator = (FileNameGenerator) Preconditions.checkNotNull(fileNameGenerator);
            return this;
        }

        public Builder headerInjector(HeaderInjector headerInjector) {
            this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector);
            return this;
        }

        public Builder maxCacheFilesCount(int i2) {
            this.diskUsage = new TotalCountLruDiskUsage(i2);
            return this;
        }

        public Builder maxCacheSize(long j) {
            this.diskUsage = new TotalSizeLruDiskUsage(j);
            return this;
        }
    }

    public final class SocketProcessorRunnable implements Runnable {
        private final Socket socket;

        public SocketProcessorRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpProxyCacheServer.this.processSocket(this.socket);
        }
    }

    public final class WaitRequestsRunnable implements Runnable {
        private final CountDownLatch startSignal;

        public WaitRequestsRunnable(CountDownLatch countDownLatch) {
            this.startSignal = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.startSignal.countDown();
            HttpProxyCacheServer.this.waitForRequest();
        }
    }

    private String appendToProxyUrl(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", PROXY_HOST, Integer.valueOf(this.port), ProxyCacheUtils.encode(str));
    }

    private void closeSocket(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error closing socket", e2));
        }
    }

    private void closeSocketInput(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            Log.i(TAG, "HttpProxyCacheServer Releasing input stream… Socket is closed by client.");
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error closing socket input stream", e2));
        }
    }

    private void closeSocketOutput(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            Log.i(TAG, "HttpProxyCacheServer Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private File getCacheFile(String str) {
        Config config = this.config;
        return new File(config.cacheRoot, config.fileNameGenerator.generate(str));
    }

    private HttpProxyCacheServerClients getClients(String str) {
        HttpProxyCacheServerClients httpProxyCacheServerClients;
        synchronized (this.clientsLock) {
            httpProxyCacheServerClients = this.clientsMap.get(str);
            if (httpProxyCacheServerClients == null) {
                httpProxyCacheServerClients = new HttpProxyCacheServerClients(str, this.config);
                this.clientsMap.put(str, httpProxyCacheServerClients);
            }
        }
        return httpProxyCacheServerClients;
    }

    private int getClientsCount() {
        int clientsCount;
        synchronized (this.clientsLock) {
            Iterator<HttpProxyCacheServerClients> it = this.clientsMap.values().iterator();
            clientsCount = 0;
            while (it.hasNext()) {
                clientsCount += it.next().getClientsCount();
            }
        }
        return clientsCount;
    }

    private boolean isAlive() {
        return this.pinger.ping(3, 70);
    }

    private void onError(Throwable th) {
        Log.i(TAG, "HttpProxyCacheServer error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSocket(Socket socket) {
        try {
            try {
                GetRequest getRequest = GetRequest.read(socket.getInputStream());
                Log.i(TAG, "HttpProxyCacheServer Request to cache proxy: " + getRequest);
                String strDecode = ProxyCacheUtils.decode(getRequest.uri);
                if (this.pinger.isPingRequest(strDecode)) {
                    this.pinger.responseToPing(socket);
                } else {
                    getClients(strDecode).processRequest(getRequest, socket);
                }
                releaseSocket(socket);
                Log.i(TAG, "HttpProxyCacheServer Opened connections: " + getClientsCount());
            } catch (ProxyCacheException e2) {
                e = e2;
                onError(new ProxyCacheException("Error processing request", e));
                releaseSocket(socket);
                Log.i(TAG, "HttpProxyCacheServer Opened connections: " + getClientsCount());
            } catch (SocketException unused) {
                Log.i(TAG, "HttpProxyCacheServer Closing socket… Socket is closed by client.");
                releaseSocket(socket);
                Log.i(TAG, "HttpProxyCacheServer Opened connections: " + getClientsCount());
            } catch (IOException e3) {
                e = e3;
                onError(new ProxyCacheException("Error processing request", e));
                releaseSocket(socket);
                Log.i(TAG, "HttpProxyCacheServer Opened connections: " + getClientsCount());
            }
        } catch (Throwable th) {
            releaseSocket(socket);
            Log.i(TAG, "HttpProxyCacheServer Opened connections: " + getClientsCount());
            throw th;
        }
    }

    private void releaseSocket(Socket socket) {
        closeSocketInput(socket);
        closeSocketOutput(socket);
        closeSocket(socket);
    }

    private void shutdownClients() {
        synchronized (this.clientsLock) {
            Iterator<HttpProxyCacheServerClients> it = this.clientsMap.values().iterator();
            while (it.hasNext()) {
                it.next().shutdown();
            }
            this.clientsMap.clear();
        }
    }

    private void touchFileSafely(File file) {
        try {
            this.config.diskUsage.touch(file);
        } catch (IOException unused) {
            Log.i(TAG, "HttpProxyCacheServer Error touching file " + file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForRequest() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.serverSocket.accept();
                Log.i(TAG, "HttpProxyCacheServer Accept new socket " + socketAccept);
                this.socketProcessor.submit(new SocketProcessorRunnable(socketAccept));
            } catch (Throwable th) {
                onError(new ProxyCacheException("Error during waiting connection", th));
                return;
            }
        }
    }

    public String getProxyUrl(String str) {
        return getProxyUrl(str, true);
    }

    public boolean isCached(String str) {
        Preconditions.checkNotNull(str, "Url can't be null!");
        return getCacheFile(str).exists();
    }

    public void registerCacheListener(CacheListener cacheListener, String str) {
        Preconditions.checkAllNotNull(cacheListener, str);
        synchronized (this.clientsLock) {
            try {
                getClients(str).registerCacheListener(cacheListener);
            } catch (ProxyCacheException unused) {
                Log.i(TAG, "HttpProxyCacheServer Error registering cache listener");
            }
        }
    }

    public void shutdown() {
        Log.i(TAG, "HttpProxyCacheServer Shutdown proxy server");
        shutdownClients();
        this.config.sourceInfoStorage.release();
        this.waitConnectionThread.interrupt();
        try {
            if (this.serverSocket.isClosed()) {
                return;
            }
            this.serverSocket.close();
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error shutting down proxy server", e2));
        }
    }

    public void unregisterCacheListener(CacheListener cacheListener, String str) {
        Preconditions.checkAllNotNull(cacheListener, str);
        synchronized (this.clientsLock) {
            try {
                getClients(str).unregisterCacheListener(cacheListener);
            } catch (ProxyCacheException unused) {
                Log.i(TAG, "HttpProxyCacheServer Error registering cache listener");
            }
        }
    }

    public HttpProxyCacheServer(Context context) {
        this(new Builder(context).buildConfig());
    }

    public String getProxyUrl(String str, boolean z) {
        if (!z || !isCached(str)) {
            return isAlive() ? appendToProxyUrl(str) : str;
        }
        File cacheFile = getCacheFile(str);
        touchFileSafely(cacheFile);
        return Uri.fromFile(cacheFile).toString();
    }

    private HttpProxyCacheServer(Config config) {
        this.clientsLock = new Object();
        this.socketProcessor = Executors.newFixedThreadPool(8);
        this.clientsMap = new ConcurrentHashMap();
        this.config = (Config) Preconditions.checkNotNull(config);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(PROXY_HOST));
            this.serverSocket = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            IgnoreHostProxySelector.install(PROXY_HOST, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new WaitRequestsRunnable(countDownLatch));
            this.waitConnectionThread = thread;
            thread.start();
            countDownLatch.await();
            this.pinger = new Pinger(PROXY_HOST, localPort);
            Log.i(TAG, "HttpProxyCacheServer Proxy cache server started. Is it alive? " + isAlive());
        } catch (IOException | InterruptedException e2) {
            this.socketProcessor.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    public void unregisterCacheListener(CacheListener cacheListener) {
        Preconditions.checkNotNull(cacheListener);
        synchronized (this.clientsLock) {
            Iterator<HttpProxyCacheServerClients> it = this.clientsMap.values().iterator();
            while (it.hasNext()) {
                it.next().unregisterCacheListener(cacheListener);
            }
        }
    }
}
