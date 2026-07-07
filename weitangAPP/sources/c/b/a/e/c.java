package c.b.a.e;

import com.bigkoo.pickerview.R;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static int getAnimationResource(int i2, boolean z) {
        if (i2 != 80) {
            return -1;
        }
        return z ? R.anim.pickerview_slide_in_bottom : R.anim.pickerview_slide_out_bottom;
    }
}
