package es.voghdev.pdfviewpager.library.remote;

import android.content.Context;
import android.os.Handler;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadFileUrlConnectionImpl implements DownloadFile {
    private static final int BUFFER_LEN = 1024;
    private static final int KILOBYTE = 1024;
    private static final int NOTIFY_PERIOD = 153600;
    public Context context;
    public DownloadFile.Listener listener;
    public Handler uiThread;

    public class NullListener implements DownloadFile.Listener {
        public NullListener() {
        }

        @Override // es.voghdev.pdfviewpager.library.remote.DownloadFile.Listener
        public void onFailure(Exception exc) {
        }

        @Override // es.voghdev.pdfviewpager.library.remote.DownloadFile.Listener
        public void onProgressUpdate(int i2, int i3) {
        }

        @Override // es.voghdev.pdfviewpager.library.remote.DownloadFile.Listener
        public void onSuccess(String str, String str2) {
        }
    }

    public DownloadFileUrlConnectionImpl(Context context, Handler handler, DownloadFile.Listener listener) {
        this.listener = new NullListener();
        this.context = context;
        this.uiThread = handler;
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyProgressOnUiThread(final int i2, final int i3) {
        Handler handler = this.uiThread;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: es.voghdev.pdfviewpager.library.remote.DownloadFileUrlConnectionImpl.4
            @Override // java.lang.Runnable
            public void run() {
                DownloadFileUrlConnectionImpl.this.listener.onProgressUpdate(i2, i3);
            }
        });
    }

    @Override // es.voghdev.pdfviewpager.library.remote.DownloadFile
    public void download(final String str, final String str2) {
        new Thread(new Runnable() { // from class: es.voghdev.pdfviewpager.library.remote.DownloadFileUrlConnectionImpl.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadFileUrlConnectionImpl downloadFileUrlConnectionImpl;
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    int contentLength = httpURLConnection.getContentLength();
                    byte[] bArr = new byte[1024];
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    int i2 = 0;
                    while (true) {
                        int i3 = 0;
                        while (true) {
                            int i4 = bufferedInputStream.read(bArr);
                            if (i4 <= 0) {
                                httpURLConnection.disconnect();
                                fileOutputStream.close();
                                DownloadFileUrlConnectionImpl.this.notifySuccessOnUiThread(str, str2);
                                return;
                            } else {
                                fileOutputStream.write(bArr, 0, i4);
                                i2 += i4;
                                i3 += i4;
                                downloadFileUrlConnectionImpl = DownloadFileUrlConnectionImpl.this;
                                if (downloadFileUrlConnectionImpl.listener == null || i3 <= DownloadFileUrlConnectionImpl.NOTIFY_PERIOD) {
                                }
                            }
                        }
                        downloadFileUrlConnectionImpl.notifyProgressOnUiThread(i2, contentLength);
                    }
                } catch (MalformedURLException e2) {
                    DownloadFileUrlConnectionImpl.this.notifyFailureOnUiThread(e2);
                } catch (IOException e3) {
                    DownloadFileUrlConnectionImpl.this.notifyFailureOnUiThread(e3);
                }
            }
        }).start();
    }

    public void notifyFailureOnUiThread(final Exception exc) {
        Handler handler = this.uiThread;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: es.voghdev.pdfviewpager.library.remote.DownloadFileUrlConnectionImpl.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadFileUrlConnectionImpl.this.listener.onFailure(exc);
            }
        });
    }

    public void notifySuccessOnUiThread(final String str, final String str2) {
        Handler handler = this.uiThread;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: es.voghdev.pdfviewpager.library.remote.DownloadFileUrlConnectionImpl.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadFileUrlConnectionImpl.this.listener.onSuccess(str, str2);
            }
        });
    }
}
