package c.o.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class e implements d {
    @Override // c.o.a.d
    public void log(int i2, @Nullable String str, @NonNull String str2) {
        j.a(str2);
        if (str == null) {
            str = "NO_TAG";
        }
        Log.println(i2, str, str2);
    }
}
