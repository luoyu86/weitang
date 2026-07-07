package com.chinavisionary.microtang.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.main.bo.NavigationVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NavigationTrafficView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout.LayoutParams f7502a;

    public NavigationTrafficView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.dp_24));
        this.f7502a = layoutParams;
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.dp_8);
        setOrientation(0);
    }

    public final void b(TextView textView, int i2) {
        if (i2 == 1) {
            textView.setBackgroundResource(R.drawable.bg_traffice_a);
            return;
        }
        if (i2 == 2) {
            textView.setBackgroundResource(R.drawable.bg_traffice_b);
            return;
        }
        if (i2 == 3) {
            textView.setBackgroundResource(R.drawable.bg_traffice_c);
        } else if (i2 != 4) {
            textView.setBackgroundResource(R.drawable.bg_cb_room_sel_drawable);
        } else {
            textView.setBackgroundResource(R.drawable.bg_traffice_d);
        }
    }

    public void setTrafficList(List<NavigationVo.a> list) {
        removeAllViews();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            NavigationVo.a aVar = list.get(i2);
            TextView textView = new TextView(getContext());
            textView.setLayoutParams(this.f7502a);
            textView.setText(aVar.getName());
            b(textView, aVar.getType());
            addView(textView);
        }
    }

    public NavigationTrafficView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public NavigationTrafficView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
