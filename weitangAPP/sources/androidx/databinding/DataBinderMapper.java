package androidx.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class DataBinderMapper {
    @NonNull
    public List<DataBinderMapper> collectDependencies() {
        return Collections.emptyList();
    }

    public abstract String convertBrIdToString(int i2);

    public abstract ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2);

    public abstract ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2);

    public abstract int getLayoutId(String str);
}
