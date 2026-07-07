package c.e.c.x.e;

import android.view.View;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.vo.OrderVo;

/* JADX INFO: loaded from: classes.dex */
public interface g0 {
    void addFragment(BaseFragment baseFragment);

    void addFragment(BaseFragment baseFragment, boolean z);

    void clickBannerItem(View view);

    void clickForward(OrderVo orderVo);

    void clickFunction(String str);

    void clickFunctionType(String str);

    void clickWxMiniAppManager();

    FragmentActivity getCurrentActivity();

    void handleOftenUseRoomEventMonitor(String str);

    void hideAlertLoading();

    boolean isLoginApp();

    void showAlertDialog(String str, String str2, boolean z, View.OnClickListener onClickListener);

    void showAlertLoading(@StringRes int i2);

    void showAlertLoading(String str);

    void showOpenDoorSuccessAlert();

    void showToast(@StringRes int i2);

    void showToast(String str);

    boolean userIsAuth();

    boolean userIsRent();
}
