package cn.admobiletop.adsuyi.a.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import cn.admobiletop.adsuyi.R;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends RelativeLayout {
    public c(Context context) {
        super(context);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void addResponseClickView(View view) {
        if (view != null) {
            view.setId(R.id.adsuyi_id_view_response);
            ADSuyiViewUtil.addAdViewToAdContainer(this, view, new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public abstract String getPosId();
}
