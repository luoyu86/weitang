package c.e.c.m0;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.room.vo.ProductDetailsVo;
import com.chinavisionary.microtang.view.FlowLayout;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile g f1691a;

    public static g getInstance() {
        if (f1691a == null) {
            synchronized (g.class) {
                if (f1691a == null) {
                    f1691a = new g();
                }
            }
        }
        return f1691a;
    }

    public void setupCommentTag(List<ProductDetailsVo.TagsBean> list, FlowLayout flowLayout, Context context) {
        flowLayout.removeAllViews();
        if (list == null || list.isEmpty()) {
            return;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.dp_6);
        context.getResources().getDimensionPixelSize(R.dimen.dp_46);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ProductDetailsVo.TagsBean tagsBean = list.get(i2);
            String tagName = tagsBean.getTagName();
            if (x.isNotNull(tagName)) {
                TextView textView = new TextView(context);
                textView.setText(tagName + " " + tagsBean.getChooseNumber());
                textView.setBackgroundResource(R.drawable.bg_product_tag);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                textView.setTextAppearance(context, R.style.ProductDetailsTagTvStyle);
                flowLayout.addView(textView, layoutParams);
            }
        }
    }
}
