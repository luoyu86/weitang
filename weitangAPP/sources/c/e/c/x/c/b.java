package c.e.c.x.c;

import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.bo.CancelAccountItemBo;
import com.chinavisionary.microtang.me.bo.CancelAccountReasonBo;
import com.chinavisionary.microtang.me.bo.ReasonCloudDtosBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CancelAccountReasonBo f2018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f2019b;

    public static final String getCancelAccountProtocol() {
        if (f2018a != null) {
            return x.isNotNull(f2019b) ? f2019b : f2018a.getCancellationAgreement();
        }
        return null;
    }

    public static List<CancelAccountItemBo> getCancelFailedData() {
        ArrayList arrayList = new ArrayList();
        CancelAccountItemBo cancelAccountItemBo = new CancelAccountItemBo();
        cancelAccountItemBo.setItemType(2);
        cancelAccountItemBo.setTitle("可能的原因如下");
        arrayList.add(cancelAccountItemBo);
        CancelAccountReasonBo cancelAccountReasonBo = f2018a;
        if (cancelAccountReasonBo != null && x.isNotNull(cancelAccountReasonBo.getCancellationFailureReason())) {
            String[] strArrSplit = f2018a.getCancellationFailureReason().split("\\r\\n");
            if (strArrSplit.length > 0) {
                for (String str : strArrSplit) {
                    CancelAccountItemBo cancelAccountItemBo2 = new CancelAccountItemBo();
                    cancelAccountItemBo2.setItemType(1);
                    cancelAccountItemBo2.setContent(str);
                    arrayList.add(cancelAccountItemBo2);
                }
            }
        }
        return arrayList;
    }

    public static List<CancelAccountItemBo> getOneData() {
        ArrayList arrayList = new ArrayList();
        CancelAccountItemBo cancelAccountItemBo = new CancelAccountItemBo();
        cancelAccountItemBo.setItemType(2);
        cancelAccountItemBo.setTitle(x.getString(R.string.title_cancel_account_reason_title));
        arrayList.add(cancelAccountItemBo);
        CancelAccountReasonBo cancelAccountReasonBo = f2018a;
        if (cancelAccountReasonBo != null) {
            List<ReasonCloudDtosBean> reasonCloudDtos = cancelAccountReasonBo.getReasonCloudDtos();
            if (o.isNotEmpty(reasonCloudDtos)) {
                for (ReasonCloudDtosBean reasonCloudDtosBean : reasonCloudDtos) {
                    if (reasonCloudDtosBean != null && x.isNotNull(reasonCloudDtosBean.getCancellationReasonTypeName())) {
                        CancelAccountItemBo cancelAccountItemBo2 = new CancelAccountItemBo();
                        cancelAccountItemBo2.setItemType(4);
                        cancelAccountItemBo2.setReason(reasonCloudDtosBean.getCancellationReasonTypeName());
                        cancelAccountItemBo2.setReasonKey(reasonCloudDtosBean.getCancellationReasonType() + "");
                        cancelAccountItemBo2.setNeedShowRemark(reasonCloudDtosBean.isOtherReason());
                        arrayList.add(cancelAccountItemBo2);
                    }
                }
            }
        }
        return arrayList;
    }

    public static CancelAccountItemBo getSelectCancel(List<CancelAccountItemBo> list) {
        if (!o.isNotEmpty(list)) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).isCheck()) {
                return list.get(i2);
            }
        }
        return null;
    }

    public static List<CancelAccountItemBo> getThreeData() {
        ArrayList arrayList = new ArrayList();
        CancelAccountItemBo cancelAccountItemBo = new CancelAccountItemBo();
        cancelAccountItemBo.setItemType(2);
        cancelAccountItemBo.setTitle("请注意，注销后账号中的资产和权益将视为自动放弃");
        arrayList.add(cancelAccountItemBo);
        CancelAccountReasonBo cancelAccountReasonBo = f2018a;
        if (cancelAccountReasonBo == null) {
            q.d("CancelAccountData", "getThreeData mCancelAccountReasonBo is null");
        } else if (x.isNotNull(cancelAccountReasonBo.getCancellationConsequence())) {
            String[] strArrSplit = f2018a.getCancellationConsequence().split("\\r\\n");
            if (strArrSplit.length > 0) {
                for (String str : strArrSplit) {
                    CancelAccountItemBo cancelAccountItemBo2 = new CancelAccountItemBo();
                    cancelAccountItemBo2.setItemType(1);
                    cancelAccountItemBo2.setContent(str);
                    arrayList.add(cancelAccountItemBo2);
                }
            }
            q.d("CancelAccountData", "getThreeData = " + f2018a.getCancellationConsequence() + ", splitArray.length = " + strArrSplit.length);
        } else {
            q.d("CancelAccountData", "getThreeData getCancellationConsequence is null");
        }
        return arrayList;
    }

    public static List<CancelAccountItemBo> getTwoData() {
        ArrayList arrayList = new ArrayList();
        CancelAccountItemBo cancelAccountItemBo = new CancelAccountItemBo();
        cancelAccountItemBo.setItemType(2);
        cancelAccountItemBo.setTitle(x.getString(R.string.title_cancel_account_condition));
        arrayList.add(cancelAccountItemBo);
        CancelAccountReasonBo cancelAccountReasonBo = f2018a;
        if (cancelAccountReasonBo != null && x.isNotNull(cancelAccountReasonBo.getCancellationCondition())) {
            String[] strArrSplit = f2018a.getCancellationCondition().split("\\r\\n");
            if (strArrSplit.length > 0) {
                CancelAccountItemBo cancelAccountItemBo2 = null;
                boolean z = true;
                for (String str : strArrSplit) {
                    if (cancelAccountItemBo2 == null) {
                        cancelAccountItemBo2 = new CancelAccountItemBo();
                        cancelAccountItemBo2.setItemType(3);
                    }
                    String strReplace = str.replace("\t", "");
                    if (z) {
                        cancelAccountItemBo2.setTitle(strReplace);
                        z = false;
                    } else {
                        cancelAccountItemBo2.setContent(strReplace);
                        arrayList.add(cancelAccountItemBo2);
                        cancelAccountItemBo2 = null;
                        z = true;
                    }
                }
            }
        }
        return arrayList;
    }

    public static void initCancelAccountReasonBo(CancelAccountReasonBo cancelAccountReasonBo) {
        f2018a = cancelAccountReasonBo;
    }

    public static void updateCancelAccountReason(String str) {
        CancelAccountReasonBo cancelAccountReasonBo = f2018a;
        if (cancelAccountReasonBo != null) {
            f2019b = cancelAccountReasonBo.getCancellationAgreement().replace("${reason}", str);
        }
    }
}
