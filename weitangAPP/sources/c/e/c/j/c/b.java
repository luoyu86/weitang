package c.e.c.j.c;

import android.view.View;
import android.widget.TextView;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.bill.vo.BillDetailsVo;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f1585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f1586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f1587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f1588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BillDetailsVo f1590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CoreBaseFragment.c f1591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f1592h = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Long expiryDate;
            if (b.this.f1590f != null) {
                boolean z = false;
                Long lValueOf = Long.valueOf(System.currentTimeMillis());
                if (b.this.f1590f.getBillStatus().intValue() == 0 && (expiryDate = b.this.f1590f.getExpiryDate()) != null) {
                    long jLongValue = expiryDate.longValue() - lValueOf.longValue();
                    z = true;
                    if (jLongValue > 0) {
                        b.this.f1590f.setSurplusTime(z.secondToMinute(Long.valueOf(jLongValue / 1000)));
                    } else {
                        b.this.f1590f.setBillStatus(14);
                        b.this.f1590f.setBillStatusName(x.getString(R.string.title_pay_time_out));
                    }
                }
                b.this.stopCountdown();
                if (z) {
                    b.this.d();
                    b bVar = b.this;
                    bVar.e(bVar.f1590f.getSurplusTime());
                }
            }
        }
    }

    public b(View view, int i2) {
        this.f1589e = i2;
        this.f1587c = (TextView) view.findViewById(R.id.tv_title);
        this.f1588d = (TextView) view.findViewById(R.id.tv_content);
        this.f1585a = (TextView) view.findViewById(R.id.tv_pay_state);
        this.f1586b = (TextView) view.findViewById(R.id.tv_pay_countdown);
    }

    public final void d() {
        CoreBaseFragment.c cVar = this.f1591g;
        if (cVar == null || this.f1589e == 1) {
            return;
        }
        cVar.postDelayed(this.f1592h, 1000L);
    }

    public final void e(String str) {
        this.f1586b.setText(x.getNotNullStr(str, ""));
    }

    public void setBaseHandler(CoreBaseFragment.c cVar) {
        this.f1591g = cVar;
    }

    public void stopCountdown() {
        CoreBaseFragment.c cVar = this.f1591g;
        if (cVar != null) {
            cVar.removeCallbacks(this.f1592h);
        }
    }

    public void updateBillState(String str, Integer num) {
        if (num != null) {
            boolean z = num.intValue() == 0;
            this.f1585a.setText(x.getNotNullStr(str, ""));
            this.f1586b.setVisibility(z ? 0 : 8);
            if (z) {
                d();
            }
        }
    }

    public void updateHeadViewData(BillDetailsVo billDetailsVo) {
        if (billDetailsVo != null) {
            this.f1590f = billDetailsVo;
            boolean z = this.f1589e == 12340;
            this.f1585a.setVisibility(z ? 8 : 0);
            this.f1587c.setText(x.getNotNullStr(this.f1590f.getBody(), ""));
            this.f1588d.setText(x.appendStringToResId(z ? R.string.placeholder_title_price : R.string.placeholder_title_pay_price, x.bigDecimalAdd(this.f1590f.getAmount(), this.f1590f.getLateFee())));
            if (z) {
                return;
            }
            updateBillState(this.f1590f.getBillStatusName(), this.f1590f.getBillStatus());
        }
    }
}
