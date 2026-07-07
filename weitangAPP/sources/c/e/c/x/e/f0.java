package c.e.c.x.e;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.chinavisionary.microtang.me.vo.NameValueVo;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface f0 {
    Activity getCurrentContext();

    void openIDCardCamera(int i2);

    void openImageGridActivity(int i2);

    void showToast(@StringRes int i2);

    void updateSelectIdType(NameValueVo nameValueVo);

    void updateSelectOptionName(String str);

    void uploadFile(List<File> list);
}
