package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile IFullTraceAnalysis f468a = new C0008a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f469b = false;

    /* JADX INFO: renamed from: anet.channel.fulltrace.a$a, reason: collision with other inner class name */
    public static class C0008a implements IFullTraceAnalysis {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IFullTraceAnalysis f470a;

        public C0008a(IFullTraceAnalysis iFullTraceAnalysis) {
            this.f470a = iFullTraceAnalysis;
            boolean unused = a.f469b = true;
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public void commitRequest(String str, RequestStatistic requestStatistic) {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (a.f469b && (iFullTraceAnalysis = this.f470a) != null) {
                try {
                    iFullTraceAnalysis.commitRequest(str, requestStatistic);
                } catch (Throwable th) {
                    boolean unused = a.f469b = false;
                    ALog.e("anet.AnalysisFactory", "fulltrace commit fail.", null, th, new Object[0]);
                }
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public String createRequest() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.f469b || (iFullTraceAnalysis = this.f470a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.createRequest();
            } catch (Throwable th) {
                boolean unused = a.f469b = false;
                ALog.e("anet.AnalysisFactory", "createRequest fail.", null, th, new Object[0]);
                return null;
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public b getSceneInfo() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.f469b || (iFullTraceAnalysis = this.f470a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.getSceneInfo();
            } catch (Throwable th) {
                boolean unused = a.f469b = false;
                ALog.e("anet.AnalysisFactory", "getSceneInfo fail", null, th, new Object[0]);
                return null;
            }
        }
    }

    public static IFullTraceAnalysis a() {
        return f468a;
    }

    public static void a(IFullTraceAnalysis iFullTraceAnalysis) {
        f468a = new C0008a(iFullTraceAnalysis);
    }
}
