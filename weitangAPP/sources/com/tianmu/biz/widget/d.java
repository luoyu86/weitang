package com.tianmu.biz.widget;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tianmu.biz.widget.n.a;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class d extends e {
    private b y;

    public class a implements a.InterfaceC0198a {
        public a() {
        }

        @Override // com.tianmu.biz.widget.n.a.InterfaceC0198a
        public void onClick(ViewGroup viewGroup, int i2) {
            com.tianmu.c.l.c cVar = d.this.x;
            if (cVar != null) {
                cVar.onClick(viewGroup, i2);
            }
        }
    }

    public interface b {
        void onAction(boolean z);

        void onAddArcViewTips();
    }

    private void s() {
        b bVar = this.y;
        if (bVar != null) {
            bVar.onAddArcViewTips();
        }
    }

    @Override // com.tianmu.biz.widget.e
    public void a() {
        int i2 = this.f10972e;
        if (i2 == 1) {
            s();
            if (this.k) {
                a(false);
            } else {
                d();
            }
        } else if (i2 == 2) {
            s();
            a(false);
        } else if (i2 == 3) {
            s();
            a(true);
        } else if (i2 == 5) {
            s();
            if (this.k) {
                a(false);
            } else {
                f();
            }
        } else if (i2 != 6) {
            s();
            a(false);
        } else {
            b();
        }
        com.tianmu.biz.widget.n.a aVar = this.f10969b;
        if (aVar != null) {
            aVar.b(this.f10976i);
            this.f10969b.a(this.j);
            this.f10969b.a(j(), Color.parseColor(h()), o(), i(), k());
            this.f10969b.a(this.m);
            if (this.v) {
                this.f10969b.c();
            }
            this.f10969b.a(new a());
            RelativeLayout.LayoutParams customInterstitialLayoutParams = TianmuViewUtil.getCustomInterstitialLayoutParams(-2, -2, TianmuDisplayUtil.dp2px(this.f10969b.a()));
            this.f10970c = customInterstitialLayoutParams;
            this.f10968a.addView(this.f10969b, customInterstitialLayoutParams);
        }
    }

    public void a(b bVar) {
        this.y = bVar;
    }

    private void a(boolean z) {
        b bVar = this.y;
        if (bVar != null) {
            bVar.onAction(z);
        }
    }
}
