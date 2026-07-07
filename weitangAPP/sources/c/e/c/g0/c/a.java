package c.e.c.g0.c;

import c.e.a.d.o;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.repair.vo.RepairOrderDetailsVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderItemDetailsVo;
import com.chinavisionary.microtang.vo.StateVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public final List<c.k.b.a> a(List<ResourceVo> list) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ResourceVo resourceVo = list.get(i2);
                if (resourceVo != null) {
                    c.k.b.a aVar = new c.k.b.a();
                    aVar.setBigImageUrl(resourceVo.getUrl());
                    aVar.setThumbnailUrl(resourceVo.getSampleUrl());
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    public List<LeftTitleToRightArrowVo> getAdapterData(RepairOrderItemDetailsVo.BaseInfoBean baseInfoBean) {
        ArrayList arrayList = new ArrayList();
        if (baseInfoBean == null) {
            return arrayList;
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft(x.getString(R.string.title_repair_no_item));
        leftTitleToRightArrowVo.setRight(baseInfoBean.getRepairOrderNo());
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_report_repair_address));
        leftTitleToRightArrowVo2.setRight(baseInfoBean.getAddress());
        arrayList.add(leftTitleToRightArrowVo2);
        if (x.isNotNull(baseInfoBean.getPlace())) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_report_repair_place));
            leftTitleToRightArrowVo3.setRight(baseInfoBean.getPlace());
            arrayList.add(leftTitleToRightArrowVo3);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_report_repair_type));
        leftTitleToRightArrowVo4.setRight(baseInfoBean.getAssetDesc());
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_fault_describe));
        leftTitleToRightArrowVo5.setRight(baseInfoBean.getReason());
        arrayList.add(leftTitleToRightArrowVo5);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setLeft(x.getString(R.string.title_is_auth_open_door));
        leftTitleToRightArrowVo6.setRight(baseInfoBean.getAuthOpen() ? x.getString(R.string.title_yes) : x.getString(R.string.title_no));
        arrayList.add(leftTitleToRightArrowVo6);
        if (baseInfoBean.getAuthOpen() && baseInfoBean.getOpenFromTime() != null && baseInfoBean.getOpenToTime() != null) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo7.setLeft(x.getString(R.string.title_repair_auth_open_door_time));
            leftTitleToRightArrowVo7.setRight(z.getTimeFromTo(baseInfoBean.getOpenFromTime(), baseInfoBean.getOpenToTime()));
            arrayList.add(leftTitleToRightArrowVo7);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_repair_server_time));
        leftTitleToRightArrowVo8.setRight(z.getTimeFromTo(baseInfoBean.getFromTime(), baseInfoBean.getToTime()));
        arrayList.add(leftTitleToRightArrowVo8);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setLeft(x.getString(R.string.title_contract_phone));
        leftTitleToRightArrowVo9.setRight(x.getPhoneMask(baseInfoBean.getPhone()));
        arrayList.add(leftTitleToRightArrowVo9);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo10.setLeft(x.getString(R.string.title_repair_remark));
        leftTitleToRightArrowVo10.setRight(baseInfoBean.getRemark());
        if (x.isNotNull(baseInfoBean.getRemark())) {
            arrayList.add(leftTitleToRightArrowVo10);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo11.setType(3333);
        RepairOrderDetailsVo repairOrderDetailsVo = new RepairOrderDetailsVo();
        repairOrderDetailsVo.setTitle(x.getString(R.string.title_repair_photo));
        repairOrderDetailsVo.setImageInfo(a(baseInfoBean.getBreakdownResource()));
        leftTitleToRightArrowVo11.setExtObj(repairOrderDetailsVo);
        if (o.isNotEmpty(baseInfoBean.getBreakdownResource())) {
            arrayList.add(leftTitleToRightArrowVo11);
        }
        if (baseInfoBean.getStatus() >= 3) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo12 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo12.setTitle(true);
            leftTitleToRightArrowVo12.setTitle(x.getString(R.string.title_repair_process));
            arrayList.add(leftTitleToRightArrowVo12);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo13 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo13.setLeft(x.getString(R.string.title_fault_type));
            leftTitleToRightArrowVo13.setRight(baseInfoBean.getActualAssetDesc());
            arrayList.add(leftTitleToRightArrowVo13);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo14 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo14.setLeft(x.getString(R.string.title_fault_reason));
            leftTitleToRightArrowVo14.setRight(baseInfoBean.getActualReason());
            arrayList.add(leftTitleToRightArrowVo14);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo15 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo15.setType(3333);
            RepairOrderDetailsVo repairOrderDetailsVo2 = new RepairOrderDetailsVo();
            repairOrderDetailsVo2.setTitle(x.getString(R.string.title_repair_over));
            repairOrderDetailsVo2.setImageInfo(a(baseInfoBean.getActualBreakdownResource()));
            leftTitleToRightArrowVo15.setExtObj(repairOrderDetailsVo2);
            arrayList.add(leftTitleToRightArrowVo15);
        }
        return arrayList;
    }

    public List<StateVo> getStateVoListToState(int i2) {
        ArrayList arrayList = new ArrayList();
        StateVo stateVo = new StateVo();
        stateVo.setTitle(x.getString(R.string.title_make_order));
        stateVo.setOver(i2 >= 1);
        arrayList.add(stateVo);
        new StateVo().setTitle(x.getString(R.string.title_acceptance_order));
        StateVo stateVo2 = new StateVo();
        stateVo2.setTitle(x.getString(R.string.title_handler_order));
        stateVo2.setOver(i2 >= 3);
        arrayList.add(stateVo2);
        StateVo stateVo3 = new StateVo();
        stateVo3.setTitle(x.getString(R.string.title_over_order));
        stateVo3.setOver(i2 >= 4);
        arrayList.add(stateVo3);
        return arrayList;
    }
}
