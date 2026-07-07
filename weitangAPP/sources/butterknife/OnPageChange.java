package butterknife;

import androidx.annotation.IdRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnPageChange {

    public enum Callback {
        PAGE_SELECTED,
        PAGE_SCROLLED,
        PAGE_SCROLL_STATE_CHANGED
    }

    Callback callback() default Callback.PAGE_SELECTED;

    @IdRes
    int[] value() default {-1};
}
