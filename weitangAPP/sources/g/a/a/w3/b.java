package g.a.a.w3;

import g.a.a.v;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    public static final v A;
    public static final v B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f13407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f13408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f13409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f13410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v f13411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v f13412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v f13413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v f13414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v f13415i;
    public static final v j;
    public static final v k;
    public static final v l;
    public static final v m;
    public static final v n;
    public static final v o;
    public static final v p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final v f13416q;
    public static final v r;
    public static final v s;
    public static final v t;
    public static final v u;
    public static final v v;
    public static final v w;
    public static final v x;
    public static final v y;
    public static final v z;

    static {
        v vVar = new v("1.3.36.3");
        f13407a = vVar;
        f13408b = vVar.branch("2.1");
        f13409c = vVar.branch("2.2");
        f13410d = vVar.branch("2.3");
        v vVarBranch = vVar.branch("3.1");
        f13411e = vVarBranch;
        f13412f = vVarBranch.branch("2");
        f13413g = vVarBranch.branch("3");
        f13414h = vVarBranch.branch(MessageService.MSG_ACCS_READY_REPORT);
        v vVarBranch2 = vVar.branch("3.2");
        f13415i = vVarBranch2;
        j = vVarBranch2.branch("1");
        k = vVarBranch2.branch("2");
        v vVarBranch3 = vVar.branch("3.2.8");
        l = vVarBranch3;
        v vVarBranch4 = vVarBranch3.branch("1");
        m = vVarBranch4;
        v vVarBranch5 = vVarBranch4.branch("1");
        n = vVarBranch5;
        o = vVarBranch5.branch("1");
        p = vVarBranch5.branch("2");
        f13416q = vVarBranch5.branch("3");
        r = vVarBranch5.branch(MessageService.MSG_ACCS_READY_REPORT);
        s = vVarBranch5.branch("5");
        t = vVarBranch5.branch("6");
        u = vVarBranch5.branch("7");
        v = vVarBranch5.branch(MessageService.MSG_ACCS_NOTIFY_CLICK);
        w = vVarBranch5.branch(MessageService.MSG_ACCS_NOTIFY_DISMISS);
        x = vVarBranch5.branch(AgooConstants.ACK_REMOVE_PACKAGE);
        y = vVarBranch5.branch(AgooConstants.ACK_BODY_NULL);
        z = vVarBranch5.branch(AgooConstants.ACK_PACK_NULL);
        A = vVarBranch5.branch(AgooConstants.ACK_FLAG_NULL);
        B = vVarBranch5.branch(AgooConstants.ACK_PACK_NOBIND);
    }
}
