package c.k.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import c.k.b.b;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.ImagePreviewActivity;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2829c;

    public a(Context context, List<c.k.b.a> list) {
        super(context, list);
        this.f2829c = getStatusHeight(context);
    }

    @Override // c.k.b.b
    public void b(Context context, NineGridView nineGridView, int i2, List<c.k.b.a> list) {
        int i3 = 0;
        while (i3 < list.size()) {
            c.k.b.a aVar = list.get(i3);
            View childAt = i3 < nineGridView.getMaxSize() ? nineGridView.getChildAt(i3) : nineGridView.getChildAt(nineGridView.getMaxSize() - 1);
            aVar.imageViewWidth = childAt.getWidth();
            aVar.imageViewHeight = childAt.getHeight();
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            aVar.imageViewX = iArr[0];
            aVar.imageViewY = iArr[1] - this.f2829c;
            i3++;
        }
        Intent intent = new Intent(context, (Class<?>) ImagePreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("IMAGE_INFO", (Serializable) list);
        bundle.putInt("CURRENT_ITEM", i2);
        intent.putExtras(bundle);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(0, 0);
    }

    public int getStatusHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }
}
