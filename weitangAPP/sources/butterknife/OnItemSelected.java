package butterknife;

import androidx.annotation.IdRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface OnItemSelected {

    public enum Callback {
        ITEM_SELECTED,
        NOTHING_SELECTED
    }

    Callback callback() default Callback.ITEM_SELECTED;

    @IdRes
    int[] value() default {-1};
}
