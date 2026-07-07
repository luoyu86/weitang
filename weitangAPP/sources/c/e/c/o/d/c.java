package c.e.c.o.d;

import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.contract.vo.ContractExitRentStateDetailsVo;
import com.chinavisionary.microtang.vo.StateVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1789a;

    public List<LeftTitleToRightArrowVo> getAdapterData(ContractExitRentStateDetailsVo contractExitRentStateDetailsVo, int i2) {
        ArrayList arrayList = new ArrayList();
        if (contractExitRentStateDetailsVo != null) {
            this.f1789a = contractExitRentStateDetailsVo.getRentBackKey();
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo.setTitle(x.getString(R.string.title_rent_user_info));
            leftTitleToRightArrowVo.setTitle(true);
            arrayList.add(leftTitleToRightArrowVo);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_user_name));
            leftTitleToRightArrowVo2.setRight(x.getNameMask(contractExitRentStateDetailsVo.getSignUserName()));
            arrayList.add(leftTitleToRightArrowVo2);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_phone_no));
            leftTitleToRightArrowVo3.setRight(x.getPhoneMask(contractExitRentStateDetailsVo.getSignUserPhone()));
            arrayList.add(leftTitleToRightArrowVo3);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_card_type));
            leftTitleToRightArrowVo4.setRight(contractExitRentStateDetailsVo.getCardType());
            arrayList.add(leftTitleToRightArrowVo4);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_id_card_no));
            leftTitleToRightArrowVo5.setRight(x.getIDNoMask(contractExitRentStateDetailsVo.getCardNo()));
            arrayList.add(leftTitleToRightArrowVo5);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo6.setTitle(x.getString(R.string.tab_title_room_info));
            leftTitleToRightArrowVo6.setTitle(true);
            arrayList.add(leftTitleToRightArrowVo6);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo7.setLeft(x.getString(R.string.title_address));
            leftTitleToRightArrowVo7.setRight(contractExitRentStateDetailsVo.getAddress());
            arrayList.add(leftTitleToRightArrowVo7);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo8.setTitle(x.getString(R.string.title_rescission_info));
            leftTitleToRightArrowVo8.setTitle(true);
            arrayList.add(leftTitleToRightArrowVo8);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo9.setLeft(x.getString(R.string.title_apply_date));
            leftTitleToRightArrowVo9.setRight(z.getTimeYYMMDD(contractExitRentStateDetailsVo.getRentBackApplyDate()));
            arrayList.add(leftTitleToRightArrowVo9);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo10.setLeft(x.getString(R.string.title_rescission_date));
            leftTitleToRightArrowVo10.setRight(z.getTimeYYMMDD(contractExitRentStateDetailsVo.getRentBackDate()));
            arrayList.add(leftTitleToRightArrowVo10);
            if (contractExitRentStateDetailsVo.getRentBackStatus() >= 4) {
                LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo11.setTitle(x.getString(R.string.title_property_delivery));
                leftTitleToRightArrowVo11.setTitle(true);
                arrayList.add(leftTitleToRightArrowVo11);
                LeftTitleToRightArrowVo leftTitleToRightArrowVo12 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo12.setKey(contractExitRentStateDetailsVo.getContractKey());
                leftTitleToRightArrowVo12.setLeft(x.getString(R.string.title_delivery_list));
                leftTitleToRightArrowVo12.setRight(x.getString(R.string.title_cat));
                leftTitleToRightArrowVo12.setShowArrow(true);
                leftTitleToRightArrowVo12.setOnlyKey(i2);
                arrayList.add(leftTitleToRightArrowVo12);
                List<ContractExitRentStateDetailsVo.ExpensesIncurredsBean> expensesIncurreds = contractExitRentStateDetailsVo.getExpensesIncurreds();
                if (expensesIncurreds != null && !expensesIncurreds.isEmpty()) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo13 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo13.setTitle(x.getString(R.string.title_cost));
                    leftTitleToRightArrowVo13.setTitle(true);
                    arrayList.add(leftTitleToRightArrowVo13);
                    for (ContractExitRentStateDetailsVo.ExpensesIncurredsBean expensesIncurredsBean : expensesIncurreds) {
                        if (expensesIncurredsBean != null) {
                            LeftTitleToRightArrowVo leftTitleToRightArrowVo14 = new LeftTitleToRightArrowVo();
                            leftTitleToRightArrowVo14.setLeft(expensesIncurredsBean.getExpensesIncurredName());
                            leftTitleToRightArrowVo14.setRight(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(expensesIncurredsBean.getExpensesIncurredAmount())));
                            arrayList.add(leftTitleToRightArrowVo14);
                        }
                    }
                }
                List<ContractExitRentStateDetailsVo.RefundsBean> refunds = contractExitRentStateDetailsVo.getRefunds();
                if (refunds != null && !refunds.isEmpty()) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo15 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo15.setTitle(x.getString(R.string.title_exit_cost));
                    leftTitleToRightArrowVo15.setTitle(true);
                    arrayList.add(leftTitleToRightArrowVo15);
                    for (ContractExitRentStateDetailsVo.RefundsBean refundsBean : refunds) {
                        if (refundsBean != null) {
                            LeftTitleToRightArrowVo leftTitleToRightArrowVo16 = new LeftTitleToRightArrowVo();
                            leftTitleToRightArrowVo16.setLeft(refundsBean.getRefundName());
                            leftTitleToRightArrowVo16.setRight(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(refundsBean.getRefundAmount())));
                            arrayList.add(leftTitleToRightArrowVo16);
                        }
                    }
                }
                List<ContractExitRentStateDetailsVo.ReceivablesBean> receivables = contractExitRentStateDetailsVo.getReceivables();
                if (receivables != null && !receivables.isEmpty()) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo17 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo17.setTitle(x.getString(R.string.title_receive_cost));
                    leftTitleToRightArrowVo17.setTitle(true);
                    arrayList.add(leftTitleToRightArrowVo17);
                    for (ContractExitRentStateDetailsVo.ReceivablesBean receivablesBean : receivables) {
                        if (receivablesBean != null) {
                            LeftTitleToRightArrowVo leftTitleToRightArrowVo18 = new LeftTitleToRightArrowVo();
                            leftTitleToRightArrowVo18.setLeft(receivablesBean.getReceivablesName());
                            leftTitleToRightArrowVo18.setRight(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(receivablesBean.getReceivablesAmount())));
                            arrayList.add(leftTitleToRightArrowVo18);
                        }
                    }
                }
                LeftTitleToRightArrowVo leftTitleToRightArrowVo19 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo19.setTitle(x.getString(R.string.title_exit_price_state));
                leftTitleToRightArrowVo19.setTitle(true);
                arrayList.add(leftTitleToRightArrowVo19);
                LeftTitleToRightArrowVo leftTitleToRightArrowVo20 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo20.setLeft(x.getString(R.string.title_exit_price));
                leftTitleToRightArrowVo20.setRight(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(contractExitRentStateDetailsVo.getRefundTotalAmount())));
                arrayList.add(leftTitleToRightArrowVo20);
                LeftTitleToRightArrowVo leftTitleToRightArrowVo21 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo21.setLeft(x.getString(R.string.title_exit_price_account));
                leftTitleToRightArrowVo21.setRight(contractExitRentStateDetailsVo.getBankAccount());
                LeftTitleToRightArrowVo leftTitleToRightArrowVo22 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo22.setLeft(x.getString(R.string.title_exit_bank));
                leftTitleToRightArrowVo22.setRight(contractExitRentStateDetailsVo.getBankName());
                if (x.isNotNull(contractExitRentStateDetailsVo.getRefundStatusName())) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo23 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo23.setLeft(x.getString(R.string.title_exit_price_state));
                    leftTitleToRightArrowVo23.setRight(contractExitRentStateDetailsVo.getRefundStatusName());
                    arrayList.add(leftTitleToRightArrowVo23);
                }
            }
            if (x.isNotNull(contractExitRentStateDetailsVo.getRentbackRemind())) {
                LeftTitleToRightArrowVo leftTitleToRightArrowVo24 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo24.setTitle(x.getString(R.string.title_fixed_loss_appeal));
                leftTitleToRightArrowVo24.setTitle(true);
                arrayList.add(leftTitleToRightArrowVo24);
                LeftTitleToRightArrowVo leftTitleToRightArrowVo25 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo25.setLeft(x.getString(R.string.title_fixed_loss_appeal));
                leftTitleToRightArrowVo25.setRight(x.getNotNullStr(contractExitRentStateDetailsVo.getRentbackRemind(), ""));
                leftTitleToRightArrowVo25.setAutoLink(4);
                arrayList.add(leftTitleToRightArrowVo25);
            }
        }
        return arrayList;
    }

    public String getRentBackKey() {
        return this.f1789a;
    }

    public List<StateVo> getStateVoList(int i2) {
        ArrayList arrayList = new ArrayList();
        StateVo stateVo = new StateVo();
        stateVo.setTitle(x.getString(R.string.title_exit_state_apply));
        stateVo.setOver(1 <= i2);
        arrayList.add(stateVo);
        StateVo stateVo2 = new StateVo();
        stateVo2.setTitle(x.getString(R.string.title_exit_state_accept));
        stateVo2.setOver(2 <= i2);
        arrayList.add(stateVo2);
        StateVo stateVo3 = new StateVo();
        stateVo3.setTitle(x.getString(R.string.title_exit_state_confirm));
        stateVo3.setOver(4 <= i2);
        arrayList.add(stateVo3);
        StateVo stateVo4 = new StateVo();
        stateVo4.setTitle(x.getString(R.string.title_exit_state_finish));
        stateVo4.setOver(5 <= i2);
        arrayList.add(stateVo4);
        return arrayList;
    }
}
