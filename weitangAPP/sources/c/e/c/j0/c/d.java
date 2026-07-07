package c.e.c.j0.c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.view.ExitStateView;
import com.chinavisionary.microtang.vo.StateVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f1623a;

    public static d getInstance() {
        if (f1623a == null) {
            synchronized (d.class) {
                if (f1623a == null) {
                    f1623a = new d();
                }
            }
        }
        return f1623a;
    }

    public final List<StateVo> a(int i2) {
        ArrayList arrayList = new ArrayList();
        StateVo stateVo = new StateVo();
        stateVo.setOver(i2 >= 0);
        stateVo.setTitle(x.getString(R.string.title_confirm_pre_msg));
        arrayList.add(stateVo);
        StateVo stateVo2 = new StateVo();
        stateVo2.setOver(2 <= i2);
        stateVo2.setTitle(x.getString(R.string.title_confirm_contract));
        arrayList.add(stateVo2);
        StateVo stateVo3 = new StateVo();
        stateVo3.setOver(3 <= i2);
        stateVo3.setTitle(x.getString(R.string.title_confirm_pay_price));
        arrayList.add(stateVo3);
        StateVo stateVo4 = new StateVo();
        stateVo4.setOver(4 <= i2);
        stateVo4.setTitle(x.getString(R.string.title_sign_contract));
        arrayList.add(stateVo4);
        return arrayList;
    }

    public final List<StateVo> b(int i2) {
        ArrayList arrayList = new ArrayList();
        StateVo stateVo = new StateVo();
        stateVo.setOver(i2 >= 0);
        stateVo.setTitle(x.getString(R.string.title_confirm_lease));
        arrayList.add(stateVo);
        StateVo stateVo2 = new StateVo();
        stateVo2.setOver(1 <= i2);
        stateVo2.setTitle(x.getString(R.string.title_confirm_rent_subject));
        arrayList.add(stateVo2);
        StateVo stateVo3 = new StateVo();
        stateVo3.setOver(2 <= i2);
        stateVo3.setTitle(x.getString(R.string.title_confirm_contract));
        arrayList.add(stateVo3);
        StateVo stateVo4 = new StateVo();
        stateVo4.setOver(3 <= i2);
        stateVo4.setTitle(x.getString(R.string.title_confirm_pay_price));
        arrayList.add(stateVo4);
        StateVo stateVo5 = new StateVo();
        stateVo5.setOver(4 <= i2);
        stateVo5.setTitle(x.getString(R.string.title_sign_contract));
        arrayList.add(stateVo5);
        return arrayList;
    }

    public View getAdapterHeadView(Context context, int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.dp_48));
        ExitStateView exitStateView = new ExitStateView(context);
        exitStateView.setLayoutParams(layoutParams);
        exitStateView.setStateVoList(b(i2));
        return exitStateView;
    }

    public View getPreAdapterHeadView(Context context, int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.dp_48));
        ExitStateView exitStateView = new ExitStateView(context);
        exitStateView.setLayoutParams(layoutParams);
        exitStateView.setStateVoList(a(i2));
        return exitStateView;
    }
}
