package com.chinavisionary.core.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class AdapterFlowLayout extends FlowLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f6673e;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f6674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6675b;

        public a(View view, int i2) {
            this.f6674a = view;
            this.f6675b = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AdapterFlowLayout.this.f6673e != null) {
                AdapterFlowLayout.this.f6673e.onItemClick(AdapterFlowLayout.this, this.f6674a, this.f6675b);
            }
        }
    }

    public interface b {
        int getCount();

        View getView(AdapterFlowLayout adapterFlowLayout, int i2);
    }

    public interface c {
        void onItemClick(AdapterFlowLayout adapterFlowLayout, View view, int i2);
    }

    public AdapterFlowLayout(Context context) {
        super(context);
    }

    public void setAdapter(b bVar) {
        if (bVar == null || bVar.getCount() == 0) {
            removeAllViews();
            return;
        }
        removeAllViews();
        int count = bVar.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            View view = bVar.getView(this, i2);
            if (view != null) {
                view.setOnClickListener(new a(view, i2));
                addView(view);
            }
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.f6673e = cVar;
    }

    public AdapterFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdapterFlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
