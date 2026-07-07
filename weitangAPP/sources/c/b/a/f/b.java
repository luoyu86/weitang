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
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b<T> extends a implements View.OnClickListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f876q;

    public b(c.b.a.c.a aVar) {
        super(aVar.Q);
        this.f865e = aVar;
        n(aVar.Q);
    }

    @Override // c.b.a.f.a
    public boolean isDialog() {
        return this.f865e.h0;
    }

    public final void n(Context context) {
        setDialogOutSideCancelable();
        j();
        h();
        i();
        c.b.a.d.a aVar = this.f865e.f846f;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(this.f865e.N, this.f862b);
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
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.optionspicker);
        linearLayout.setBackgroundColor(this.f865e.X);
        d dVar = new d(linearLayout, this.f865e.s);
        this.f876q = dVar;
        c.b.a.d.d dVar2 = this.f865e.f845e;
        if (dVar2 != null) {
            dVar.setOptionsSelectChangeListener(dVar2);
        }
        this.f876q.setTextContentSize(this.f865e.b0);
        d dVar3 = this.f876q;
        c.b.a.c.a aVar2 = this.f865e;
        dVar3.setLabels(aVar2.f847g, aVar2.f848h, aVar2.f849i);
        d dVar4 = this.f876q;
        c.b.a.c.a aVar3 = this.f865e;
        dVar4.setTextXOffset(aVar3.m, aVar3.n, aVar3.o);
        d dVar5 = this.f876q;
        c.b.a.c.a aVar4 = this.f865e;
        dVar5.setCyclic(aVar4.p, aVar4.f850q, aVar4.r);
        this.f876q.setTypeface(this.f865e.k0);
        l(this.f865e.i0);
        this.f876q.setDividerColor(this.f865e.e0);
        this.f876q.setDividerType(this.f865e.l0);
        this.f876q.setLineSpacingMultiplier(this.f865e.g0);
        this.f876q.setTextColorOut(this.f865e.c0);
        this.f876q.setTextColorCenter(this.f865e.d0);
        this.f876q.isCenterLabel(this.f865e.j0);
    }

    public final void o() {
        d dVar = this.f876q;
        if (dVar != null) {
            c.b.a.c.a aVar = this.f865e;
            dVar.setCurrentItems(aVar.j, aVar.k, aVar.l);
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

    public void returnData() {
        if (this.f865e.f841a != null) {
            int[] currentItems = this.f876q.getCurrentItems();
            this.f865e.f841a.onOptionsSelect(currentItems[0], currentItems[1], currentItems[2], this.m);
        }
    }

    public void setNPicker(List<T> list, List<T> list2, List<T> list3) {
        this.f876q.setLinkage(false);
        this.f876q.setNPicker(list, list2, list3);
        o();
    }

    public void setPicker(List<T> list) {
        setPicker(list, null, null);
    }

    public void setSelectOptions(int i2) {
        this.f865e.j = i2;
        o();
    }

    public void setTitleText(String str) {
        TextView textView = (TextView) findViewById(R.id.tvTitle);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setPicker(List<T> list, List<List<T>> list2) {
        setPicker(list, list2, null);
    }

    public void setPicker(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f876q.setPicker(list, list2, list3);
        o();
    }

    public void setSelectOptions(int i2, int i3) {
        c.b.a.c.a aVar = this.f865e;
        aVar.j = i2;
        aVar.k = i3;
        o();
    }

    public void setSelectOptions(int i2, int i3, int i4) {
        c.b.a.c.a aVar = this.f865e;
        aVar.j = i2;
        aVar.k = i3;
        aVar.l = i4;
        o();
    }
}
