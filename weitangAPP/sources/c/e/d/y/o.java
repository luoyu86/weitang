package c.e.d.y;

import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;

/* JADX INFO: loaded from: classes2.dex */
public interface o {
    void addFragmentToActivity(CoreBaseFragment coreBaseFragment);

    void finishFragmentOrActivity(boolean z);

    FragmentActivity getCurrentActivity();

    CoreBaseFragment getCurrentFragment();

    void handleRequestErr(RequestErrDto requestErrDto);

    void hiedAlertLoading();

    void showAlertLoading(@StringRes int i2);

    void showToast(@StringRes int i2);

    void showToast(String str);

    void updatePayPrice(String str);

    boolean userIsAuth();
}
