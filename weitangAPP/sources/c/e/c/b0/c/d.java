package c.e.c.b0.c;

import c.e.a.d.o;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.order.vo.CleanOrderDetailsVo;
import com.chinavisionary.microtang.order.vo.CleanOrderItemDetailsVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderDetailsVo;
import com.chinavisionary.microtang.vo.StateVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public final List<c.k.b.a> a(List<ResourceVo> list) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ResourceVo resourceVo = list.get(i2);
                c.k.b.a aVar = new c.k.b.a();
                aVar.setBigImageUrl(resourceVo.getUrl());
                aVar.setThumbnailUrl(resourceVo.getSampleUrl());
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public List<LeftTitleToRightArrowVo> getAdapterData(CleanOrderDetailsVo cleanOrderDetailsVo, CleanOrderItemDetailsVo.WorkerInfoBean workerInfoBean) {
        ArrayList arrayList = new ArrayList();
        if (cleanOrderDetailsVo == null) {
            return arrayList;
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft(x.getString(R.string.title_clean_no_item));
        leftTitleToRightArrowVo.setRight(cleanOrderDetailsVo.getCleaningOrderNo());
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.tip_create_order_time));
        leftTitleToRightArrowVo2.setRight(z.getTime(cleanOrderDetailsVo.getCreateTime()));
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_report_clean_address));
        leftTitleToRightArrowVo3.setRight(cleanOrderDetailsVo.getAddress());
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_report_clean_type));
        leftTitleToRightArrowVo4.setRight(cleanOrderDetailsVo.getBusinessTypeName());
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_pre_clean_type));
        leftTitleToRightArrowVo5.setRight(cleanOrderDetailsVo.getProductTypeName());
        arrayList.add(leftTitleToRightArrowVo5);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setLeft(x.getString(R.string.title_auth_clean_open_door));
        leftTitleToRightArrowVo6.setRight(cleanOrderDetailsVo.isAuthOpen() ? x.getString(R.string.title_yes) : x.getString(R.string.title_no));
        arrayList.add(leftTitleToRightArrowVo6);
        if (cleanOrderDetailsVo.isAuthOpen() && cleanOrderDetailsVo.getOpenFromTime() != null && cleanOrderDetailsVo.getOpenToTime() != null) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo7.setLeft(x.getString(R.string.title_repair_auth_open_door_time));
            leftTitleToRightArrowVo7.setRight(z.getTimeFromTo(cleanOrderDetailsVo.getOpenFromTime(), cleanOrderDetailsVo.getOpenToTime()));
            arrayList.add(leftTitleToRightArrowVo7);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_repair_server_time));
        leftTitleToRightArrowVo8.setRight(z.getTimeFromTo(cleanOrderDetailsVo.getFromTime(), cleanOrderDetailsVo.getToTime()));
        arrayList.add(leftTitleToRightArrowVo8);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setLeft(x.getString(R.string.title_contract_phone));
        leftTitleToRightArrowVo9.setRight(x.getPhoneMask(cleanOrderDetailsVo.getPhone()));
        LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo10.setLeft(x.getString(R.string.title_repair_remark));
        leftTitleToRightArrowVo10.setRight(cleanOrderDetailsVo.getRemark());
        if (x.isNotNull(cleanOrderDetailsVo.getRemark())) {
            arrayList.add(leftTitleToRightArrowVo10);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo11.setType(3333);
        RepairOrderDetailsVo repairOrderDetailsVo = new RepairOrderDetailsVo();
        repairOrderDetailsVo.setTitle(x.getString(R.string.title_clean_photo));
        repairOrderDetailsVo.setImageInfo(a(cleanOrderDetailsVo.getResources()));
        leftTitleToRightArrowVo11.setExtObj(repairOrderDetailsVo);
        if (o.isNotEmpty(cleanOrderDetailsVo.getResources())) {
            arrayList.add(leftTitleToRightArrowVo11);
        }
        if (cleanOrderDetailsVo.getStatus() >= 4) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo12 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo12.setTitle(true);
            leftTitleToRightArrowVo12.setTitle(x.getString(R.string.title_clean_process));
            arrayList.add(leftTitleToRightArrowVo12);
            if (workerInfoBean != null && x.isNotNull(workerInfoBean.getHandlerName())) {
                LeftTitleToRightArrowVo leftTitleToRightArrowVo13 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo13.setLeft(x.getString(R.string.title_handler_person));
                leftTitleToRightArrowVo13.setRight(workerInfoBean.getHandlerName());
                arrayList.add(leftTitleToRightArrowVo13);
            }
            LeftTitleToRightArrowVo leftTitleToRightArrowVo14 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo14.setLeft(x.getString(R.string.title_clean_type_name));
            leftTitleToRightArrowVo14.setRight(cleanOrderDetailsVo.getActualProductTypeName());
            arrayList.add(leftTitleToRightArrowVo14);
            if (cleanOrderDetailsVo.getHandleResult() != null) {
                LeftTitleToRightArrowVo leftTitleToRightArrowVo15 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo15.setLeft(x.getString(R.string.title_finish_month));
                leftTitleToRightArrowVo15.setRight(cleanOrderDetailsVo.getHandleResult());
                arrayList.add(leftTitleToRightArrowVo15);
            }
            if (cleanOrderDetailsVo.getFinishTime() != null) {
                LeftTitleToRightArrowVo leftTitleToRightArrowVo16 = new LeftTitleToRightArrowVo();
                leftTitleToRightArrowVo16.setLeft(x.getString(R.string.title_finish_time));
                leftTitleToRightArrowVo16.setRight(z.getTime(cleanOrderDetailsVo.getFinishTime()));
                arrayList.add(leftTitleToRightArrowVo16);
            }
            LeftTitleToRightArrowVo leftTitleToRightArrowVo17 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo17.setType(3333);
            RepairOrderDetailsVo repairOrderDetailsVo2 = new RepairOrderDetailsVo();
            repairOrderDetailsVo2.setTitle(x.getString(R.string.title_clean_over));
            repairOrderDetailsVo2.setImageInfo(a(cleanOrderDetailsVo.getActualResources()));
            leftTitleToRightArrowVo17.setExtObj(repairOrderDetailsVo2);
            if (o.isNotEmpty(cleanOrderDetailsVo.getActualResources())) {
                arrayList.add(leftTitleToRightArrowVo17);
            }
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
