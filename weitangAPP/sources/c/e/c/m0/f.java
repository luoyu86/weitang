package c.e.c.m0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.prelook.vo.TagVo;
import com.nex3z.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f1690a;

    public static f getInstance() {
        if (f1690a == null) {
            synchronized (f.class) {
                if (f1690a == null) {
                    f1690a = new f();
                }
            }
        }
        return f1690a;
    }

    public CheckBox addCommentTag(Context context, TagVo tagVo, View.OnClickListener onClickListener, FrameLayout.LayoutParams layoutParams, int i2) {
        CheckBox checkBox = new CheckBox(context);
        checkBox.setId(R.id.id_comment_tag);
        checkBox.setOnClickListener(onClickListener);
        checkBox.setText(tagVo.getContent());
        checkBox.setTag(tagVo.getKey());
        checkBox.setLayoutParams(layoutParams);
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setPadding(i2, i2, i2, i2);
        checkBox.setGravity(17);
        checkBox.setBackgroundResource(R.drawable.bg_cb_comment_tag);
        checkBox.setTextColor(context.getResources().getColor(R.color.color686868));
        checkBox.setTextSize(2, 14.0f);
        return checkBox;
    }

    public TextView addCommentTagReturnTv(Context context, TagVo tagVo, FrameLayout.LayoutParams layoutParams, int i2) {
        TextView textView = new TextView(context);
        textView.setId(R.id.id_comment_tag);
        textView.setText(tagVo.getContent());
        textView.setTag(tagVo.getKey());
        textView.setLayoutParams(layoutParams);
        textView.setPadding(i2, i2, i2, i2);
        textView.setGravity(17);
        textView.setBackgroundResource(R.drawable.bg_cb_comment_tag);
        textView.setTextColor(context.getResources().getColor(R.color.color686868));
        textView.setTextSize(2, 14.0f);
        return textView;
    }

    public List<String> getSelectTag(FlowLayout flowLayout) {
        ArrayList arrayList = new ArrayList();
        int childCount = flowLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            CheckBox checkBox = (CheckBox) flowLayout.getChildAt(i2);
            if (checkBox.isChecked()) {
                arrayList.add((String) checkBox.getTag());
            }
        }
        return arrayList;
    }
}
