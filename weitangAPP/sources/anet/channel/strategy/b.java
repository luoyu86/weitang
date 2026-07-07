package anet.channel.strategy;

import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.net.InetAddress;
import java.util.Collections;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f631c;

    public b(a aVar, String str, Object obj) {
        this.f631c = aVar;
        this.f629a = str;
        this.f630b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                String hostAddress = InetAddress.getByName(this.f629a).getHostAddress();
                LinkedList linkedList = new LinkedList();
                ConnProtocol connProtocol = StrategyTemplate.getInstance().getConnProtocol(this.f629a);
                if (connProtocol != null) {
                    linkedList.add(IPConnStrategy.a(hostAddress, !this.f631c.a(connProtocol) ? 80 : Constants.PORT, connProtocol, 0, 0, 1, 45000));
                }
                linkedList.add(IPConnStrategy.a(hostAddress, 80, ConnProtocol.HTTP, 0, 0, 0, 0));
                linkedList.add(IPConnStrategy.a(hostAddress, Constants.PORT, ConnProtocol.HTTPS, 0, 0, 0, 0));
                this.f631c.f627a.put(this.f629a, linkedList);
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, "host", this.f629a, "ip", hostAddress, "list", linkedList);
                }
                synchronized (this.f631c.f628b) {
                    this.f631c.f628b.remove(this.f629a);
                }
                synchronized (this.f630b) {
                    this.f630b.notifyAll();
                }
            } catch (Exception unused) {
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.LocalDnsStrategyTable", "resolve ip by local dns failed", null, "host", this.f629a);
                }
                this.f631c.f627a.put(this.f629a, Collections.EMPTY_LIST);
                synchronized (this.f631c.f628b) {
                    this.f631c.f628b.remove(this.f629a);
                    synchronized (this.f630b) {
                        this.f630b.notifyAll();
                    }
                }
            }
        } catch (Throwable th) {
            synchronized (this.f631c.f628b) {
                this.f631c.f628b.remove(this.f629a);
                synchronized (this.f630b) {
                    this.f630b.notifyAll();
                    throw th;
                }
            }
        }
    }
}
