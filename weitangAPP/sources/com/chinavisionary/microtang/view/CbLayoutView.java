package com.chinavisionary.microtang.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class CbLayoutView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f8635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, c.e.c.t.q.a> f8636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CheckBox f8637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup.LayoutParams f8638d;

    public class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.e.c.t.q.a f8639a;

        public a(c.e.c.t.q.a aVar) {
            this.f8639a = aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.getTag() != null) {
                CheckBox checkBox = (CheckBox) compoundButton;
                if (CbLayoutView.this.f8637c == null && z) {
                    CbLayoutView.this.f8637c = checkBox;
                } else {
                    String str = (String) compoundButton.getTag();
                    if (z) {
                        if (CbLayoutView.this.f8637c != null && !str.equals((String) CbLayoutView.this.f8637c.getTag())) {
                            CbLayoutView.this.f8637c.setChecked(false);
                        }
                        CbLayoutView.this.f8637c = checkBox;
                    } else if (CbLayoutView.this.f8637c != null && str.equals((String) CbLayoutView.this.f8637c.getTag())) {
                        CbLayoutView.this.f8637c = null;
                    }
                }
            }
            this.f8639a.setHasSelect(z);
        }
    }

    public CbLayoutView(Context context) {
        super(context);
        this.f8636b = new ConcurrentHashMap<>();
    }

    public final void c(c.e.c.t.q.a aVar) {
        if (this.f8635a == null) {
            this.f8635a = LayoutInflater.from(getContext());
            this.f8638d = new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.dp_34));
        }
        this.f8636b.put(aVar.getKey(), aVar);
        View viewInflate = this.f8635a.inflate(R.layout.item_submit_life_order_sub_select, (ViewGroup) null, false);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.cb_item);
        checkBox.setChecked(aVar.isHasSelect());
        checkBox.setText(aVar.getTitle());
        checkBox.setTag(aVar.getKey());
        if (aVar.isHasSelect()) {
            this.f8637c = checkBox;
        }
        checkBox.setOnCheckedChangeListener(new a(aVar));
        addView(viewInflate, this.f8638d);
    }

    public c.e.c.t.q.a getSelectResult() {
        CheckBox checkBox = this.f8637c;
        if (checkBox == null || checkBox.getTag() == null) {
            return null;
        }
        String str = (String) this.f8637c.getTag();
        if (x.isNotNull(str)) {
            return this.f8636b.get(str);
        }
        return null;
    }

    public void initCbData(List<c.e.c.t.q.a> list) {
        this.f8636b.clear();
        removeAllViews();
        Iterator<c.e.c.t.q.a> it = list.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        invalidate();
    }

    public CbLayoutView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8636b = new ConcurrentHashMap<>();
    }

    public CbLayoutView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8636b = new ConcurrentHashMap<>();
    }

    public CbLayoutView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f8636b = new ConcurrentHashMap<>();
    }
}
