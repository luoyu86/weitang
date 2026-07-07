package com.taobao.accs.net;

import com.taobao.accs.data.Message;

/* JADX INFO: loaded from: classes2.dex */
public class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Message f10414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f10416c;

    public x(w wVar, Message message, boolean z) {
        this.f10416c = wVar;
        this.f10414a = message;
        this.f10415b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f10416c.t) {
            this.f10416c.a(this.f10414a);
            if (this.f10416c.t.size() == 0) {
                this.f10416c.t.add(this.f10414a);
            } else {
                Message message = (Message) this.f10416c.t.getFirst();
                if (this.f10414a.a() == 1 || this.f10414a.a() == 0) {
                    this.f10416c.t.addLast(this.f10414a);
                    if (message.a() == 2) {
                        this.f10416c.t.removeFirst();
                    }
                } else if (this.f10414a.a() != 2 || message.a() != 2) {
                    this.f10416c.t.addLast(this.f10414a);
                } else if (!message.f10267d && this.f10414a.f10267d) {
                    this.f10416c.t.removeFirst();
                    this.f10416c.t.addFirst(this.f10414a);
                }
            }
            if (this.f10415b || this.f10416c.s == 3) {
                try {
                    this.f10416c.t.notifyAll();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
