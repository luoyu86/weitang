package c.q.a.c;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3119a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f3120b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Thread f3121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayBlockingQueue<String> f3122d = new ArrayBlockingQueue<>(100);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f3123e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3124f = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                String strTake = this.f3122d.take();
                FileWriter fileWriter = new FileWriter(this.f3124f, true);
                fileWriter.append((CharSequence) strTake).append((CharSequence) "\n");
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e2) {
                e2.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public static d getInstance() {
        return f3119a;
    }

    public void setEnableRecord(boolean z) {
        this.f3123e = z;
    }

    public void setWriterLogPath(String str) {
        this.f3124f = str;
    }

    public void startLoopReadLog() {
        if (!this.f3123e || this.f3124f == null) {
            return;
        }
        Thread thread = this.f3121c;
        if (thread != null) {
            thread.interrupt();
        }
        Thread thread2 = new Thread(new Runnable() { // from class: c.q.a.c.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f3118a.b();
            }
        });
        this.f3121c = thread2;
        thread2.start();
    }

    public void writerLogToQueue(String str) {
        if (this.f3123e) {
            try {
                String str2 = f3120b.format(new Date(System.currentTimeMillis()));
                this.f3122d.put(str + "__" + str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
