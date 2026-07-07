package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import com.alibaba.sdk.android.error.ErrorCode;
import com.intelligoo.sdk.utils.BleLog;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsState;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.flowcontrol.FlowControl;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TrafficsMonitor f10290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlowControl f10291d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f10295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.taobao.accs.ut.a.d f10296i;
    private Message j;
    private com.taobao.accs.net.b k;
    private String l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentMap<Message.a, Message> f10293f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentMap<String, ScheduledFuture<?>> f10288a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10294g = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10292e = "";
    private LinkedHashMap<String, String> m = new LinkedHashMap<String, String>() { // from class: com.taobao.accs.data.MessageHandler$1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 50;
        }
    };
    private Map<String, a> n = new HashMap();
    private Runnable o = new f(this);

    public d(Context context, com.taobao.accs.net.b bVar) {
        String str;
        this.l = "MsgRecv_";
        this.f10295h = context;
        this.k = bVar;
        this.f10290c = new TrafficsMonitor(context);
        this.f10291d = new FlowControl(this.f10295h);
        if (bVar == null) {
            str = this.l;
        } else {
            str = this.l + bVar.m;
        }
        this.l = str;
        i();
        h();
    }

    private boolean b(ErrorCode errorCode) {
        return errorCode.getCodeInt() == AccsErrorCode.SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.REQ_TIME_OUT.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.SPDY_CON_DISCONNECTED.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.INAPP_CON_DISCONNECTED.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.SPDY_PING_TIME_OUT.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NO_NETWORK.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NETWORKSDK_SPDY_CLOSE_ERROR.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NETWORK_INAPP_TIMEOUT.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NETWORK_INAPP_CONNECT_FAIL.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NETWORK_INAPP_NO_STRATEGY.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NETWORK_INAPP_EXCEPTION.getCodeInt();
    }

    private void i() {
        try {
            File file = new File(this.f10295h.getDir(Constants.SHARED_FOLDER, 0), Constants.SHARED_MESSAGE_ID_FILE + this.k.i());
            if (!file.exists()) {
                ALog.d(this.l, "message file not exist", new Object[0]);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return;
                }
                this.m.put(line, line);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void j() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f10295h.getDir(Constants.SHARED_FOLDER, 0), Constants.SHARED_MESSAGE_ID_FILE + this.k.i()));
            fileWriter.write("");
            Iterator<String> it = this.m.keySet().iterator();
            while (it.hasNext()) {
                fileWriter.append((CharSequence) it.next()).append((CharSequence) BleLog.LINE_BREAK);
            }
            fileWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(byte[] bArr) throws IOException {
        a(bArr, (String) null);
    }

    public boolean c() {
        return this.f10294g;
    }

    public int d() {
        return this.f10293f.size();
    }

    public Collection<Message> e() {
        return this.f10293f.values();
    }

    public Set<Message.a> f() {
        return this.f10293f.keySet();
    }

    public com.taobao.accs.ut.a.d g() {
        return this.f10296i;
    }

    public void h() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.o);
        } catch (Throwable th) {
            ALog.e(this.l, "restoreTraffics", th, new Object[0]);
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.m.containsKey(str);
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str) || this.m.containsKey(str)) {
            return;
        }
        this.m.put(str, str);
        j();
    }

    public void a(byte[] bArr, String str) throws IOException {
        int i2;
        int i3;
        int iB;
        int i4;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(this.l, "onMessage", "host", str);
        }
        com.taobao.accs.utl.h hVar = new com.taobao.accs.utl.h(bArr);
        try {
            int iA = hVar.a();
            i2 = (iA & 240) >> 4;
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                ALog.d(this.l, "version:" + i2, new Object[0]);
            }
            i3 = iA & 15;
            if (ALog.isPrintLog(level)) {
                ALog.d(this.l, "compress:" + i3, new Object[0]);
            }
            hVar.a();
            iB = hVar.b();
            if (ALog.isPrintLog(level)) {
                ALog.d(this.l, "totalLen:" + iB, new Object[0]);
            }
            i4 = 0;
        } finally {
            try {
            } finally {
            }
        }
        while (i4 < iB) {
            int iB2 = hVar.b();
            int i5 = i4 + 2;
            if (iB2 <= 0) {
                throw new IOException("data format error");
            }
            byte[] bArr2 = new byte[iB2];
            hVar.read(bArr2);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.l, "buf len:" + iB2, new Object[0]);
            }
            i4 = i5 + iB2;
            a(i3, bArr2, str, i2);
        }
    }

    private Intent c(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.s);
        intent.putExtra("command", message.t);
        intent.putExtra(Constants.KEY_SERVICE_ID, message.H);
        intent.putExtra(Constants.KEY_USER_ID, message.G);
        Integer num = message.t;
        if (num != null && num.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.O);
        }
        return intent;
    }

    public void b() {
        ALog.d(this.l, "onRcvPing", new Object[0]);
        synchronized (d.class) {
            this.f10294g = false;
        }
    }

    public void b(Message message) {
        if (this.f10293f.keySet().size() > 0) {
            Iterator<Message.a> it = this.f10293f.keySet().iterator();
            while (it.hasNext()) {
                Message message2 = this.f10293f.get(it.next());
                if (message2 != null && message2.t != null && message2.f().equals(message.f())) {
                    switch (message.t.intValue()) {
                        case 1:
                        case 2:
                            if (message2.t.intValue() == 1 || message2.t.intValue() == 2) {
                                message2.f10268e = true;
                            }
                            break;
                        case 3:
                        case 4:
                            if (message2.t.intValue() == 3 || message2.t.intValue() == 4) {
                                message2.f10268e = true;
                            }
                            break;
                        case 5:
                        case 6:
                            if (message2.t.intValue() == 5 || message2.t.intValue() == 6) {
                                message2.f10268e = true;
                            }
                            break;
                    }
                }
                if (message2 != null && message2.f10268e) {
                    ALog.e(this.l, "cancelControlMessage", "command", message2.t);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:299|223|224|(3:(1:226)(21:227|(1:229)|231|232|333|233|234|(1:236)|237|(1:239)(1:240)|241|(1:243)(1:244)|245|(1:247)(1:248)|249|250|327|251|252|316|253)|316|253)|230|231|232|333|233|234|(0)|237|(0)(0)|241|(0)(0)|245|(0)(0)|249|250|327|251|252) */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x075e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x075f, code lost:
    
        r1 = r25;
        r5 = r12;
        r2 = r14;
        r6 = r17;
        r4 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0767, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0768, code lost:
    
        r5 = r12;
        r2 = r14;
        r6 = r17;
        r4 = r18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02d5 A[PHI: r0
  0x02d5: PHI (r0v114 com.alibaba.sdk.android.error.ErrorCode) = (r0v98 com.alibaba.sdk.android.error.ErrorCode), (r0v104 com.alibaba.sdk.android.error.ErrorCode) binds: [B:90:0x025e, B:96:0x02b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x05c2 A[Catch: Exception -> 0x0770, TryCatch #0 {Exception -> 0x0770, blocks: (B:223:0x055d, B:226:0x0567, B:231:0x05aa, B:234:0x05b4, B:236:0x05c2, B:237:0x05c8, B:239:0x05cc, B:241:0x05d7, B:243:0x0627, B:245:0x0635, B:249:0x069c, B:248:0x069b, B:227:0x0584, B:229:0x058c), top: B:299:0x055d }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05cc A[Catch: Exception -> 0x0770, TryCatch #0 {Exception -> 0x0770, blocks: (B:223:0x055d, B:226:0x0567, B:231:0x05aa, B:234:0x05b4, B:236:0x05c2, B:237:0x05c8, B:239:0x05cc, B:241:0x05d7, B:243:0x0627, B:245:0x0635, B:249:0x069c, B:248:0x069b, B:227:0x0584, B:229:0x058c), top: B:299:0x055d }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0627 A[Catch: Exception -> 0x0770, TryCatch #0 {Exception -> 0x0770, blocks: (B:223:0x055d, B:226:0x0567, B:231:0x05aa, B:234:0x05b4, B:236:0x05c2, B:237:0x05c8, B:239:0x05cc, B:241:0x05d7, B:243:0x0627, B:245:0x0635, B:249:0x069c, B:248:0x069b, B:227:0x0584, B:229:0x058c), top: B:299:0x055d }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0699  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x069b A[Catch: Exception -> 0x0770, TryCatch #0 {Exception -> 0x0770, blocks: (B:223:0x055d, B:226:0x0567, B:231:0x05aa, B:234:0x05b4, B:236:0x05c2, B:237:0x05c8, B:239:0x05cc, B:241:0x05d7, B:243:0x0627, B:245:0x0635, B:249:0x069c, B:248:0x069b, B:227:0x0584, B:229:0x058c), top: B:299:0x055d }] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v28, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r1v76 */
    /* JADX WARN: Type inference failed for: r1v77 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r1v81 */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v30, types: [com.taobao.accs.utl.ALog$Level] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r37v10 */
    /* JADX WARN: Type inference failed for: r37v11 */
    /* JADX WARN: Type inference failed for: r37v12 */
    /* JADX WARN: Type inference failed for: r37v13 */
    /* JADX WARN: Type inference failed for: r37v14 */
    /* JADX WARN: Type inference failed for: r37v16 */
    /* JADX WARN: Type inference failed for: r37v17 */
    /* JADX WARN: Type inference failed for: r37v18 */
    /* JADX WARN: Type inference failed for: r37v2 */
    /* JADX WARN: Type inference failed for: r37v20 */
    /* JADX WARN: Type inference failed for: r37v21 */
    /* JADX WARN: Type inference failed for: r37v22 */
    /* JADX WARN: Type inference failed for: r37v23 */
    /* JADX WARN: Type inference failed for: r37v24 */
    /* JADX WARN: Type inference failed for: r37v25 */
    /* JADX WARN: Type inference failed for: r37v26 */
    /* JADX WARN: Type inference failed for: r37v27 */
    /* JADX WARN: Type inference failed for: r37v28 */
    /* JADX WARN: Type inference failed for: r37v29 */
    /* JADX WARN: Type inference failed for: r37v3 */
    /* JADX WARN: Type inference failed for: r37v4 */
    /* JADX WARN: Type inference failed for: r37v9 */
    /* JADX WARN: Type inference failed for: r39v0, types: [com.taobao.accs.data.d] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v64 */
    /* JADX WARN: Type inference failed for: r4v75 */
    /* JADX WARN: Type inference failed for: r4v76 */
    /* JADX WARN: Type inference failed for: r4v77 */
    /* JADX WARN: Type inference failed for: r4v78 */
    /* JADX WARN: Type inference failed for: r4v79 */
    /* JADX WARN: Type inference failed for: r4v80 */
    /* JADX WARN: Type update failed for variable: r42v0 ??, new type: java.lang.String
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 21261. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:37)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:224)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:86)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:72)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
     */
    /* JADX WARN: Type update failed for variable: r42v0 ??, new type: java.lang.String
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 21261. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:37)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:224)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:86)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:58)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
     */
    /* JADX WARN: Type update failed for variable: r42v0 java.lang.String, new type: java.lang.String
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 21261. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:37)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:224)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:86)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:72)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r40, byte[] r41, java.lang.String r42, int r43) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 2126
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.d.a(int, byte[], java.lang.String, int):void");
    }

    public Message b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f10293f.remove(new Message.a(0, str));
    }

    private void b(Message message, ErrorCode errorCode) {
        if (message == null) {
            return;
        }
        String deviceId = UtilityImpl.getDeviceId(this.f10295h);
        String str = System.currentTimeMillis() + "";
        boolean z = errorCode.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt();
        int iIntValue = message.t.intValue();
        if (iIntValue == 1) {
            com.taobao.accs.ut.a.a aVar = new com.taobao.accs.ut.a.a();
            aVar.f10420a = deviceId;
            aVar.f10421b = str;
            aVar.f10422c = z;
            aVar.a(errorCode);
            aVar.a();
            return;
        }
        if (iIntValue != 3) {
            return;
        }
        com.taobao.accs.ut.a.b bVar = new com.taobao.accs.ut.a.b();
        bVar.f10425a = deviceId;
        bVar.f10426b = str;
        bVar.f10427c = z;
        bVar.f10429e = message.G;
        bVar.a(errorCode);
        bVar.a();
    }

    private byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr;
        if (inputStream == null) {
            return null;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                bArr = new byte[8192];
            } finally {
                try {
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
            }
            while (true) {
                int i2 = gZIPInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            ALog.e(this.l, "uncompress data error " + e2.toString(), new Object[0]);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.f10289b + " uncompress data error " + e2.toString());
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            return null;
        }
    }

    private void a(Message message, byte[] bArr, byte[] bArr2, String str) {
        ErrorCode errorCode;
        JSONArray jSONArrayOptJSONArray;
        ErrorCode errorCode2 = AccsErrorCode.SUCCESS;
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.l, "handleControlMessage parse", "json", jSONObject.toString());
                }
                ErrorCode httpCode = message.t.intValue() == 100 ? errorCode2 : AccsErrorCode.parseHttpCode(jSONObject.getInt("code"));
                try {
                    if (httpCode.getCodeInt() == errorCode2.getCodeInt()) {
                        int iIntValue = message.t.intValue();
                        if (iIntValue == 1) {
                            AccsState.getInstance().a(this.k.m, AccsState.BIND_APP_FROM_CACHE, Boolean.FALSE);
                            UtilityImpl.saveUtdid(Constants.SP_FILE_NAME, this.f10295h);
                            try {
                                this.k.j().a(this.f10295h.getPackageName());
                                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                this.f10292e = JsonUtility.getString(jSONObject2, Constants.KEY_DEVICE_TOKEN, null);
                                if (jSONObject2 != null && (jSONArrayOptJSONArray = jSONObject2.optJSONArray(Constants.KEY_PACKAGE_NAMES)) != null) {
                                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                        String string = jSONArrayOptJSONArray.getString(i2);
                                        if (UtilityImpl.c(this.f10295h, string)) {
                                            this.k.j().a(message.s);
                                        } else {
                                            ALog.i(this.l, "unbind app", "pkg", string);
                                            com.taobao.accs.net.b bVar = this.k;
                                            bVar.b(Message.a(bVar, string), true);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                ALog.i(this.l, "no token/invalid app", th);
                            }
                        } else if (iIntValue != 2) {
                            if (iIntValue == 100 && (this.k instanceof com.taobao.accs.net.j) && !message.n.equals(Constants.TARGET_SERVICE_ST)) {
                                ((com.taobao.accs.net.j) this.k).a(jSONObject);
                            }
                        } else {
                            this.k.j().b(message.s);
                        }
                    } else if (httpCode.getCodeInt() == AccsErrorCode.APP_NOT_BIND.getCodeInt()) {
                        this.k.j().b(message.s);
                    }
                    if (httpCode.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) {
                        ALog.e(this.l, "handleControlMessage parse", "json", jSONObject.toString());
                    }
                    errorCode = httpCode;
                } catch (Throwable th2) {
                    th = th2;
                    errorCode2 = httpCode;
                    ALog.e(this.l, "handleControlMessage", th, new Object[0]);
                    AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.f10289b + th.toString());
                    errorCode = errorCode2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        a(message, errorCode, null, bArr, null);
        a(new TrafficsMonitor.a(message.H, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
    }

    private Map<Integer, String> a(com.taobao.accs.utl.h hVar) {
        HashMap map = null;
        if (hVar == null) {
            return null;
        }
        try {
            int iB = hVar.b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.l, "extHeaderLen:" + iB, new Object[0]);
            }
            int i2 = 0;
            while (i2 < iB) {
                int iB2 = hVar.b();
                int i3 = (64512 & iB2) >> 10;
                int i4 = iB2 & 1023;
                String strA = hVar.a(i4);
                i2 = i2 + 2 + i4;
                if (map == null) {
                    map = new HashMap();
                }
                map.put(Integer.valueOf(i3), strA);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.l, "", "extHeaderType", Integer.valueOf(i3), com.alipay.sdk.m.p0.b.f5579d, strA);
                }
            }
        } catch (Exception e2) {
            ALog.e(this.l, "parseExtHeader", e2, new Object[0]);
        }
        return map;
    }

    public void a(Message message, ErrorCode errorCode) {
        a(message, errorCode, null, null, null);
    }

    public void a(Message message, ErrorCode errorCode, Map<Integer, String> map) {
        a(message, errorCode, null, null, map);
    }

    public void a(Message message, ErrorCode errorCode, Message.ReqType reqType, byte[] bArr, Map<Integer, String> map) {
        ErrorCode errorCode2;
        byte[] bArr2;
        Map<Integer, String> map2;
        Message.ReqType reqType2;
        if (message.t != null && message.a() >= 0 && message.a() != 2) {
            String str = message.O;
            if (str != null) {
                this.f10288a.remove(str);
            }
            int iA = this.f10291d.a(map, message.H);
            if (iA != 0) {
                if (iA == 2) {
                    errorCode2 = AccsErrorCode.SERVIER_HIGH_LIMIT;
                } else if (iA == 3) {
                    errorCode2 = AccsErrorCode.SERVIER_HIGH_LIMIT_BRUSH;
                } else {
                    errorCode2 = AccsErrorCode.SERVIER_LOW_LIMIT;
                }
                reqType2 = null;
                bArr2 = null;
                map2 = null;
            } else {
                errorCode2 = errorCode;
                bArr2 = bArr;
                map2 = map;
                reqType2 = reqType;
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.l, "onResult", "command", message.t, "erorcode", errorCode2);
            }
            if (message.t.intValue() == 102) {
                return;
            }
            if ((message.t.intValue() == 1 && errorCode2.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) || errorCode2.getCodeInt() == AccsErrorCode.APP_NOT_BIND.getCodeInt()) {
                this.k.j().b(message.s);
            }
            if (!message.f10268e) {
                if (b(errorCode2) && message.t.intValue() != 100 && message.R <= Message.f10264a) {
                    message.T = System.currentTimeMillis();
                    int i2 = message.R + 1;
                    message.R = i2;
                    ALog.d(this.l, "onResult", "retryTimes", Integer.valueOf(i2));
                    this.k.b(message, true);
                } else {
                    Intent intentC = c(message);
                    intentC.putExtra(Constants.KEY_ERROR_OBJ, errorCode2);
                    Message.ReqType reqTypeValueOf = Message.ReqType.valueOf(3 & (message.k >> 13));
                    if (reqType2 == Message.ReqType.RES || reqTypeValueOf == Message.ReqType.REQ) {
                        intentC.putExtra(Constants.KEY_SEND_TYPE, Constants.SEND_TYPE_RES);
                    }
                    if (errorCode2.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt()) {
                        intentC.putExtra("data", bArr2);
                    }
                    intentC.putExtra(Constants.KEY_APP_KEY, this.k.f10352b);
                    intentC.putExtra(Constants.KEY_CONFIG_TAG, this.k.m);
                    a(map2, intentC);
                    g.a(this.f10295h, this.k, intentC);
                    if (!TextUtils.isEmpty(message.H)) {
                        UTMini.getInstance().commitEvent(66001, "MsgToBuss0", "commandId=" + message.t, "serviceId=" + message.H + " errorCode=" + errorCode2 + " dataId=" + message.f10273q, Integer.valueOf(Constants.SDK_VERSION_CODE));
                        StringBuilder sb = new StringBuilder();
                        sb.append("1commandId=");
                        sb.append(message.t);
                        sb.append("serviceId=");
                        sb.append(message.H);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
                    }
                }
            } else {
                ALog.e(this.l, "onResult message is cancel", "command", message.t);
            }
            NetPerformanceMonitor netPerformanceMonitorE = message.e();
            if (netPerformanceMonitorE != null) {
                netPerformanceMonitorE.onToBizDate();
                URL url = message.f10269f;
                String string = url == null ? null : url.toString();
                if (errorCode2.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt()) {
                    netPerformanceMonitorE.setRet(true);
                    if (message.R > 0) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.R, 0.0d);
                    } else {
                        AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_POINT_REQUEST, string);
                    }
                } else {
                    if (message.R > 0) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "fail＿" + errorCode2, 0.0d);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "fail", 0.0d);
                    } else if (errorCode2.getCodeInt() != AccsErrorCode.NO_NETWORK.getCodeInt()) {
                        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQUEST, string, UtilityImpl.a(errorCode2.getCodeInt()), this.f10289b + message.H + message.S);
                    }
                    netPerformanceMonitorE.setRet(false);
                    netPerformanceMonitorE.setFailReason(errorCode2);
                }
                AppMonitor.getInstance().commitStat(message.e());
            }
            b(message, errorCode2);
            return;
        }
        ALog.d(this.l, "onError, skip ping/ack", new Object[0]);
    }

    public void a() {
        ALog.d(this.l, "onSendPing", new Object[0]);
        synchronized (d.class) {
            this.f10294g = true;
        }
    }

    public void a(Message message) {
        String str;
        Log.d("ACCS_TEST", "MessageHandler onSend");
        Message message2 = this.j;
        if (message2 != null && (str = message.O) != null && message.H != null && message2.O.equals(str) && this.j.H.equals(message.H)) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.H, message.O, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.a() == -1 || message.a() == 2 || message.f10266c) {
            return;
        }
        this.f10293f.put(message.d(), message);
    }

    public void a(ErrorCode errorCode) {
        this.f10294g = false;
        Message.a[] aVarArr = (Message.a[]) this.f10293f.keySet().toArray(new Message.a[0]);
        if (aVarArr.length > 0) {
            ALog.d(this.l, "onNetworkFail", new Object[0]);
            for (Message.a aVar : aVarArr) {
                Message messageRemove = this.f10293f.remove(aVar);
                if (messageRemove != null) {
                    a(messageRemove, errorCode);
                }
            }
        }
    }

    public Message a(String str) {
        return this.f10293f.get(new Message.a(0, str));
    }

    private byte[] a(String str, Map<Integer, String> map, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    int i2 = Integer.parseInt(map.get(17));
                    int i3 = Integer.parseInt(map.get(16));
                    if (i3 <= 1) {
                        throw new RuntimeException("burstNums <= 1");
                    }
                    if (i2 >= 0 && i2 < i3) {
                        String str2 = map.get(18);
                        long j = 0;
                        try {
                            String str3 = map.get(15);
                            if (!TextUtils.isEmpty(str3)) {
                                j = Long.parseLong(str3);
                            }
                        } catch (Throwable th) {
                            ALog.w(this.l, "putBurstMessage", th, new Object[0]);
                        }
                        a aVar = this.n.get(str);
                        if (aVar == null) {
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(this.l, "putBurstMessage", Constants.KEY_DATA_ID, str, "burstLength", Integer.valueOf(i3));
                            }
                            aVar = new a(str, i3, str2);
                            aVar.a(j);
                            this.n.put(str, aVar);
                        }
                        return aVar.a(i2, i3, bArr);
                    }
                    throw new RuntimeException(String.format("burstNums:%s burstIndex:%s", Integer.valueOf(i3), Integer.valueOf(i2)));
                }
            } catch (Throwable th2) {
                ALog.w(this.l, "putBurstMessage", th2, new Object[0]);
                return null;
            }
        }
        throw new RuntimeException("burstLength == 0");
    }

    private void a(Map<Integer, String> map, Intent intent) {
        if (map == null || intent == null) {
            return;
        }
        intent.putExtra(TaoBaseService.ExtraInfo.EXT_HEADER, (HashMap) map);
    }

    private void a(Intent intent, String str, String str2, short s) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("source", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra(Constants.KEY_TARGET, str2);
            }
            intent.putExtra(Constants.KEY_FLAGS, s);
        }
    }

    private void a(String str, String str2) {
        com.taobao.accs.ut.a.e eVar = new com.taobao.accs.ut.a.e();
        eVar.f10449a = UtilityImpl.getDeviceId(this.f10295h);
        eVar.f10451c = str;
        eVar.f10452d = "" + System.currentTimeMillis();
        eVar.f10454f = "";
        eVar.f10453e = str2;
        eVar.f10450b = "";
        eVar.a();
    }

    public void a(TrafficsMonitor.a aVar) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new e(this, aVar));
        } catch (Throwable th) {
            ALog.e(this.l, "addTrafficsInfo", th, new Object[0]);
        }
    }
}
