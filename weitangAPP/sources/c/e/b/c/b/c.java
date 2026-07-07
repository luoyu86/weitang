package c.e.b.c.b;

import c.e.b.c.d.k;
import c.e.b.c.d.s;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import d.k0.d.p;
import d.k0.d.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c extends c.e.b.c.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1278b = new a(null);

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
            if (str != null) {
                c.e.b.c.d.d dVar2 = (c.e.b.c.d.d) JSON.parseObject(str, c.e.b.c.d.d.class);
                if (dVar != null) {
                    int count = dVar2 != null ? dVar2.getCount() : 9;
                    c.e.b.c.c.a aVarA = c.this.a();
                    t.checkNotNullExpressionValue(dVar2, "chooseMediaParam");
                    aVarA.performChooseImage(dVar, count, dVar2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: c.e.b.c.b.c$c, reason: collision with other inner class name */
    public static final class C0026c implements c.e.b.a.a {
        public C0026c() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            if (str != null) {
                c.e.b.b.a.d(c.this.getClass().getSimpleName(), "registerChooseImagePickerBridge : " + str);
                c.e.b.c.d.d dVar2 = (c.e.b.c.d.d) JSON.parseObject(str, c.e.b.c.d.d.class);
                if (dVar != null) {
                    int count = dVar2 != null ? dVar2.getCount() : 9;
                    c.e.b.c.c.a aVarA = c.this.a();
                    t.checkNotNullExpressionValue(dVar2, "chooseMediaParam");
                    aVarA.performChooseImage(dVar, count, dVar2);
                }
            }
        }
    }

    public static final class d implements c.e.b.a.a {
        public d() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            if (str != null) {
                c.e.b.b.a.d(c.this.getClass().getSimpleName(), "previewImage : " + str);
                c.this.b(str);
            }
        }
    }

    public static final class e implements c.e.b.a.a {
        public e() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            if (str != null) {
                c.e.b.b.a.d(c.this.getClass().getSimpleName(), "OLD_PREVIEW_IMAGE_BRIDGE : " + str);
                c.this.c(str);
            }
        }
    }

    public static final class f implements c.e.b.a.a {
        public f() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            if (str != null) {
                c.e.b.b.a.d(c.this.getClass().getSimpleName(), "showImagePicker : " + str);
                c.this.b(str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.e.b.c.c.a aVar) {
        super(aVar);
        t.checkNotNullParameter(aVar, "view");
    }

    public final void b(String str) {
        ArrayList<String> imagesUrl;
        try {
            k kVar = (k) JSON.parseObject(str, k.class);
            if (kVar == null || (imagesUrl = kVar.getImagesUrl()) == null || imagesUrl.size() <= 0) {
                return;
            }
            if (kVar.getNumber() >= imagesUrl.size() || kVar.getNumber() < 0) {
                kVar.setNumber(0);
            }
            c.e.b.c.c.a aVarA = a();
            ArrayList<String> imagesUrl2 = kVar.getImagesUrl();
            t.checkNotNullExpressionValue(imagesUrl2, "previewImageRec.imagesUrl");
            aVarA.performOpenImagePreview(imagesUrl2, kVar.getNumber());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c(String str) {
        List<String> picList;
        try {
            s sVar = (s) JSON.parseObject(str, s.class);
            if (sVar == null || (picList = sVar.getPicList()) == null || picList.size() <= 0) {
                return;
            }
            if (sVar.getPosition() >= picList.size() || sVar.getPosition() < 0) {
                sVar.setPosition(0);
            }
            c.e.b.c.c.a aVarA = a();
            List<String> picList2 = sVar.getPicList();
            t.checkNotNullExpressionValue(picList2, "previewImageRec.picList");
            aVarA.performOpenImagePreview(picList2, sVar.getPosition());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("chooseImage", new b());
    }

    public final void e(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("chooseMedia", new C0026c());
    }

    public final void f(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("previewImage", new d());
        bridgeWebView.registerHandler("onImagePreview", new e());
    }

    public final void g(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("showImagePicker", new f());
    }

    @Override // c.e.b.c.b.a
    public void registerBridge(BridgeWebView bridgeWebView) {
        t.checkNotNullParameter(bridgeWebView, "webView");
        f(bridgeWebView);
        g(bridgeWebView);
        d(bridgeWebView);
        e(bridgeWebView);
    }
}
