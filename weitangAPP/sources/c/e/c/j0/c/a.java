package c.e.c.j0.c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.contract.vo.ContractRentFeeVo;
import com.chinavisionary.microtang.sign.vo.RoomPayCostVo;
import com.chinavisionary.microtang.view.ExitStateView;
import com.chinavisionary.microtang.vo.StateVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public final List<StateVo> a() {
        ArrayList arrayList = new ArrayList();
        StateVo stateVo = new StateVo();
        stateVo.setOver(true);
        stateVo.setTitle(x.getString(R.string.title_confirm_lease));
        arrayList.add(stateVo);
        StateVo stateVo2 = new StateVo();
        stateVo2.setOver(true);
        stateVo2.setTitle(x.getString(R.string.title_confirm_rent_subject));
        arrayList.add(stateVo2);
        StateVo stateVo3 = new StateVo();
        stateVo3.setOver(true);
        stateVo3.setTitle(x.getString(R.string.title_confirm_contract));
        arrayList.add(stateVo3);
        StateVo stateVo4 = new StateVo();
        stateVo4.setOver(true);
        stateVo4.setTitle(x.getString(R.string.title_confirm_pay_price));
        arrayList.add(stateVo4);
        StateVo stateVo5 = new StateVo();
        stateVo5.setOver(false);
        stateVo5.setTitle(x.getString(R.string.title_sign_contract));
        arrayList.add(stateVo5);
        return arrayList;
    }

    public RoomPayCostVo getAdapterData(List<ContractRentFeeVo> list) {
        RoomPayCostVo roomPayCostVo = new RoomPayCostVo();
        ArrayList arrayList = new ArrayList();
        String str = null;
        if (list != null && !list.isEmpty()) {
            for (ContractRentFeeVo contractRentFeeVo : list) {
                if (contractRentFeeVo != null) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo.setTitle(true);
                    leftTitleToRightArrowVo.setTitle(contractRentFeeVo.getBody());
                    arrayList.add(leftTitleToRightArrowVo);
                    List<ContractRentFeeVo.FeesBean> fees = contractRentFeeVo.getFees();
                    if (fees != null && !fees.isEmpty()) {
                        for (ContractRentFeeVo.FeesBean feesBean : fees) {
                            if (feesBean != null) {
                                String amount = feesBean.getAmount();
                                if (x.isNullStr(str) && feesBean.getFeeType() == -1) {
                                    str = amount;
                                }
                                LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
                                leftTitleToRightArrowVo2.setLeft(feesBean.getFeeTypeName());
                                leftTitleToRightArrowVo2.setRight(amount);
                                arrayList.add(leftTitleToRightArrowVo2);
                            }
                        }
                    }
                }
            }
        }
        roomPayCostVo.setPayPrice(str);
        roomPayCostVo.setRightArrowVoList(arrayList);
        return roomPayCostVo;
    }

    public View getAdapterHeadView(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.dp_48));
        ExitStateView exitStateView = new ExitStateView(context);
        exitStateView.setLayoutParams(layoutParams);
        exitStateView.setStateVoList(a());
        return exitStateView;
    }
}
