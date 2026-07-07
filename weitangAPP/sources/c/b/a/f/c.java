package c.b.a.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.R;
import java.text.ParseException;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class c extends c.b.a.f.a implements View.OnClickListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f877q;

    public class a implements c.b.a.d.b {
        public a() {
        }

        @Override // c.b.a.d.b
        public void onTimeSelectChanged() {
            try {
                c.this.f865e.f844d.onTimeSelectChanged(e.f895a.parse(c.this.f877q.getTime()));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public c(c.b.a.c.a aVar) {
        super(aVar.Q);
        this.f865e = aVar;
        p(aVar.Q);
    }

    @Override // c.b.a.f.a
    public boolean isDialog() {
        return this.f865e.h0;
    }

    public boolean isLunarCalendar() {
        return this.f877q.isLunarMode();
    }

    public final void o() {
        c.b.a.c.a aVar = this.f865e;
        Calendar calendar = aVar.v;
        if (calendar == null || aVar.w == null) {
            if (calendar != null) {
                aVar.u = calendar;
                return;
            }
            Calendar calendar2 = aVar.w;
            if (calendar2 != null) {
                aVar.u = calendar2;
                return;
            }
            return;
        }
        Calendar calendar3 = aVar.u;
        if (calendar3 == null || calendar3.getTimeInMillis() < this.f865e.v.getTimeInMillis() || this.f865e.u.getTimeInMillis() > this.f865e.w.getTimeInMillis()) {
            c.b.a.c.a aVar2 = this.f865e;
            aVar2.u = aVar2.v;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        String str = (String) view.getTag();
        if (str.equals("submit")) {
            returnData();
        } else if (str.equals("cancel") && (onClickListener = this.f865e.f843c) != null) {
            onClickListener.onClick(view);
        }
        dismiss();
    }

    public final void p(Context context) {
        setDialogOutSideCancelable();
        j();
        h();
        c.b.a.d.a aVar = this.f865e.f846f;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f862b);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.f865e.R) ? context.getResources().getString(R.string.pickerview_submit) : this.f865e.R);
            button2.setText(TextUtils.isEmpty(this.f865e.S) ? context.getResources().getString(R.string.pickerview_cancel) : this.f865e.S);
            textView.setText(TextUtils.isEmpty(this.f865e.T) ? "" : this.f865e.T);
            button.setTextColor(this.f865e.U);
            button2.setTextColor(this.f865e.V);
            textView.setTextColor(this.f865e.W);
            relativeLayout.setBackgroundColor(this.f865e.Y);
            button.setTextSize(this.f865e.Z);
            button2.setTextSize(this.f865e.Z);
            textView.setTextSize(this.f865e.a0);
        } else {
            aVar.customLayout(LayoutInflater.from(context).inflate(this.f865e.N, this.f862b));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.f865e.X);
        q(linearLayout);
    }

    public final void q(LinearLayout linearLayout) {
        int i2;
        c.b.a.c.a aVar = this.f865e;
        e eVar = new e(linearLayout, aVar.t, aVar.P, aVar.b0);
        this.f877q = eVar;
        if (this.f865e.f844d != null) {
            eVar.setSelectChangeCallback(new a());
        }
        this.f877q.setLunarMode(this.f865e.A);
        c.b.a.c.a aVar2 = this.f865e;
        int i3 = aVar2.x;
        if (i3 != 0 && (i2 = aVar2.y) != 0 && i3 <= i2) {
            s();
        }
        c.b.a.c.a aVar3 = this.f865e;
        Calendar calendar = aVar3.v;
        if (calendar == null || aVar3.w == null) {
            if (calendar == null) {
                Calendar calendar2 = aVar3.w;
                if (calendar2 != null && calendar2.get(1) > 2100) {
                    throw new IllegalArgumentException("The endDate should not be later than 2100");
                }
                r();
            } else {
                if (calendar.get(1) < 1900) {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
                r();
            }
        } else {
            if (calendar.getTimeInMillis() > this.f865e.w.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            r();
        }
        t();
        e eVar2 = this.f877q;
        c.b.a.c.a aVar4 = this.f865e;
        eVar2.setLabels(aVar4.B, aVar4.C, aVar4.D, aVar4.E, aVar4.F, aVar4.G);
        e eVar3 = this.f877q;
        c.b.a.c.a aVar5 = this.f865e;
        eVar3.setTextXOffset(aVar5.H, aVar5.I, aVar5.J, aVar5.K, aVar5.L, aVar5.M);
        l(this.f865e.i0);
        this.f877q.setCyclic(this.f865e.z);
        this.f877q.setDividerColor(this.f865e.e0);
        this.f877q.setDividerType(this.f865e.l0);
        this.f877q.setLineSpacingMultiplier(this.f865e.g0);
        this.f877q.setTextColorOut(this.f865e.c0);
        this.f877q.setTextColorCenter(this.f865e.d0);
        this.f877q.isCenterLabel(this.f865e.j0);
    }

    public final void r() {
        e eVar = this.f877q;
        c.b.a.c.a aVar = this.f865e;
        eVar.setRangDate(aVar.v, aVar.w);
        o();
    }

    public void returnData() {
        if (this.f865e.f842b != null) {
            try {
                this.f865e.f842b.onTimeSelect(e.f895a.parse(this.f877q.getTime()), this.m);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void s() {
        this.f877q.setStartYear(this.f865e.x);
        this.f877q.setEndYear(this.f865e.y);
    }

    public void setDate(Calendar calendar) {
        this.f865e.u = calendar;
        t();
    }

    public void setLunarCalendar(boolean z) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(e.f895a.parse(this.f877q.getTime()));
            int i2 = calendar.get(1);
            int i3 = calendar.get(2);
            int i4 = calendar.get(5);
            int i5 = calendar.get(11);
            int i6 = calendar.get(12);
            int i7 = calendar.get(13);
            this.f877q.setLunarMode(z);
            e eVar = this.f877q;
            c.b.a.c.a aVar = this.f865e;
            eVar.setLabels(aVar.B, aVar.C, aVar.D, aVar.E, aVar.F, aVar.G);
            this.f877q.setPicker(i2, i3, i4, i5, i6, i7);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
    }

    public void setTitleText(String str) {
        TextView textView = (TextView) findViewById(R.id.tvTitle);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void t() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f865e.u;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i2 = calendar.get(1);
            i3 = calendar.get(2);
            i4 = calendar.get(5);
            i5 = calendar.get(11);
            i6 = calendar.get(12);
            i7 = calendar.get(13);
        } else {
            i2 = calendar2.get(1);
            i3 = this.f865e.u.get(2);
            i4 = this.f865e.u.get(5);
            i5 = this.f865e.u.get(11);
            i6 = this.f865e.u.get(12);
            i7 = this.f865e.u.get(13);
        }
        int i8 = i5;
        int i9 = i4;
        int i10 = i3;
        e eVar = this.f877q;
        eVar.setPicker(i2, i10, i9, i8, i6, i7);
    }
}
