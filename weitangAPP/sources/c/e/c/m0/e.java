package c.e.c.m0;

import android.widget.TextView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static void setupBadge(EventBadgeMsgVo eventBadgeMsgVo, TextView textView, TextView textView2) {
        if (textView == null || textView2 == null) {
            return;
        }
        boolean zIsShow = eventBadgeMsgVo.isShow();
        boolean zIsShowPaint = eventBadgeMsgVo.isShowPaint();
        int badgeNumber = eventBadgeMsgVo.getBadgeNumber();
        if (badgeNumber <= 0) {
            zIsShow = false;
        }
        if (badgeNumber <= 99) {
            textView.getLayoutParams().width = textView.getContext().getResources().getDimensionPixelSize(R.dimen.dp_14);
            textView.setText(String.valueOf(badgeNumber));
        } else {
            textView.getLayoutParams().width = textView.getContext().getResources().getDimensionPixelSize(R.dimen.dp_20);
            textView.setText("99+");
        }
        textView2.setVisibility((zIsShow && zIsShowPaint) ? 0 : 8);
        textView.setVisibility((!zIsShow || zIsShowPaint) ? 8 : 0);
    }
}
