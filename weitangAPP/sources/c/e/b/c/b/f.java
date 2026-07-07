package c.e.b.c.b;

import c.e.a.d.x;
import c.e.b.c.c.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.chinavisionary.jslibrary.R;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import d.k0.d.p;
import d.k0.d.t;
import d.p0.y;

/* JADX INFO: loaded from: classes.dex */
public final class f extends c.e.b.c.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1293b = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(p pVar) {
            this();
        }
    }

    public static final class b implements c.e.b.a.a {
        public b() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            t.checkNotNullParameter(str, "data");
            try {
                c.e.b.c.d.a aVar = (c.e.b.c.d.a) JSON.parseObject(str, c.e.b.c.d.a.class);
                t.checkNotNullExpressionValue(aVar, "foodPayVo");
                String primaryKey = aVar.getPrimaryKey();
                if (primaryKey != null) {
                    if (primaryKey.length() > 0) {
                        c.e.b.c.d.i iVar = new c.e.b.c.d.i();
                        iVar.setType(12);
                        if (aVar.isPayReserveBill()) {
                            iVar.setType(16);
                        }
                        if (aVar.isPayFirstBill()) {
                            iVar.setType(10);
                        }
                        if (aVar.isPayOrderBill()) {
                            iVar.setType(21);
                        }
                        iVar.setHasRentBill(aVar.isPayRentBill());
                        iVar.setBill(aVar.isPayBill());
                        iVar.setPrimaryKey(aVar.getPrimaryKey());
                        iVar.setSrcToH5(true);
                        a.C0028a.addFragmentToActivity$default(f.this.a(), iVar, false, 2, null);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static final class c implements c.e.b.a.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BridgeWebView f1296b;

        public c(BridgeWebView bridgeWebView) {
            this.f1296b = bridgeWebView;
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            t.checkNotNullParameter(str, "data");
            c.e.b.c.d.g gVar = (c.e.b.c.d.g) JSON.parseObject(str, c.e.b.c.d.g.class);
            String url = this.f1296b.getUrl();
            c.e.b.c.d.i iVarC = null;
            boolean zContains$default = url != null ? y.contains$default((CharSequence) url, (CharSequence) "commodity", false, 2, (Object) null) : false;
            if (gVar == null || gVar.getType() == null) {
                return;
            }
            String type = gVar.getType();
            if (type != null) {
                int iHashCode = type.hashCode();
                if (iHashCode != 106006350) {
                    if (iHashCode == 510593761 && type.equals("owner-bill")) {
                        iVarC = f.this.d();
                    }
                } else if (type.equals("order")) {
                    iVarC = f.this.c();
                }
            }
            if (iVarC != null) {
                f.this.b(iVarC, gVar, zContains$default);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.e.b.c.c.a aVar) {
        super(aVar);
        t.checkNotNullParameter(aVar, "view");
    }

    public final void b(c.e.b.c.d.i iVar, c.e.b.c.d.g gVar, boolean z) {
        iVar.setPayCode(gVar.getOrderId());
        iVar.setPrice(x.getNotNullStr(gVar.getPayAmount(), ""));
        a().addFragmentToActivity(iVar, !z);
    }

    public final c.e.b.c.d.i c() {
        c.e.b.c.d.i iVar = new c.e.b.c.d.i();
        iVar.setType(16);
        iVar.setTitle(x.getString(R.string.js_lib_title_order_pay_fee));
        return iVar;
    }

    public final c.e.b.c.d.i d() {
        c.e.b.c.d.i iVar = new c.e.b.c.d.i();
        iVar.setType(10);
        iVar.setBill(true);
        iVar.setTitle(x.getString(R.string.js_lib_title_bill_pay_fee));
        return iVar;
    }

    public final void e(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("appPay", new b());
    }

    @Override // c.e.b.c.b.a
    public void registerBridge(BridgeWebView bridgeWebView) {
        t.checkNotNullParameter(bridgeWebView, "webView");
        e(bridgeWebView);
        bridgeWebView.registerHandler("gotoPay", new c(bridgeWebView));
    }
}
