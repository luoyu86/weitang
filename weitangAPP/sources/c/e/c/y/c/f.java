package c.e.c.y.c;

import android.view.View;
import android.widget.TextView;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.merchant.vo.BuyCartCountVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f2264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f2265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f2266c;

    public f(View view) {
        this.f2264a = (TextView) view.findViewById(R.id.tv_product_count_fee);
        this.f2266c = (TextView) view.findViewById(R.id.tv_buy_cart_count);
        this.f2265b = (TextView) view.findViewById(R.id.tv_product_express_fee);
    }

    public final void a(int i2) {
        this.f2266c.setText(String.valueOf(i2));
        this.f2266c.setVisibility(i2 > 0 ? 0 : 8);
    }

    public final void b(BigDecimal bigDecimal) {
        this.f2264a.setText(x.appendStringToResId(R.string.rmb_placeholder, x.bigDecimalToPlainString(bigDecimal)));
    }

    public void updateBuyCountAndPrice(BuyCartCountVo buyCartCountVo) {
        if (buyCartCountVo != null) {
            a(buyCartCountVo.getBuyCount());
            b(buyCartCountVo.getBuyCountPrice());
        }
    }

    public void updateProductExpressFee(BigDecimal bigDecimal) {
        this.f2265b.setText(R.string.title_self_raising);
    }
}
