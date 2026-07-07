package c.e.c.c0.c;

import androidx.annotation.NonNull;
import c.e.a.d.x;
import c.e.a.d.z;
import c.e.c.m0.i;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.pre.vo.RequestReserveInfoVo;
import com.chinavisionary.microtang.pre.vo.ReserveRoomInfoVo;
import com.chinavisionary.microtang.vo.ScreenLeftTitleToRightArrowResultVo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public List<LeftTitleToRightArrowVo> getAdapterData(@NonNull ReserveRoomInfoVo reserveRoomInfoVo) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setTitle(x.getString(R.string.title_room_about_info_msg));
        leftTitleToRightArrowVo.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_address));
        leftTitleToRightArrowVo2.setRight(x.getNotNullStr(reserveRoomInfoVo.getAddress(), ""));
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_month_rent_fee));
        leftTitleToRightArrowVo3.setRight(x.bigDecimalToPlainString(reserveRoomInfoVo.getRentFee()));
        leftTitleToRightArrowVo3.setPrice(true);
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_reserve_fee));
        leftTitleToRightArrowVo4.setRight(x.bigDecimalToPlainString(reserveRoomInfoVo.getDepositFee()));
        leftTitleToRightArrowVo4.setPrice(true);
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_reserve_sign_date));
        leftTitleToRightArrowVo5.setRight(String.valueOf(reserveRoomInfoVo.getReserveSignDate()));
        leftTitleToRightArrowVo5.setSimpleDateFormat(z.f1246g);
        leftTitleToRightArrowVo5.setTime(true);
        arrayList.add(leftTitleToRightArrowVo5);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setTitle(x.getString(R.string.title_reserve_person));
        leftTitleToRightArrowVo6.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo6);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo7.setLeft(x.getString(R.string.title_phone_no));
        leftTitleToRightArrowVo7.setRight(reserveRoomInfoVo.getReserveUserPhone());
        arrayList.add(leftTitleToRightArrowVo7);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_reserve_person_name));
        leftTitleToRightArrowVo8.setOnlyKey(111);
        leftTitleToRightArrowVo8.setRight(reserveRoomInfoVo.getReserveUserName());
        arrayList.add(leftTitleToRightArrowVo8);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setLeft(x.getString(R.string.title_card_type));
        leftTitleToRightArrowVo9.setRight(x.getString(R.string.title_id_card));
        arrayList.add(leftTitleToRightArrowVo9);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo10.setOnlyKey(123);
        leftTitleToRightArrowVo10.setLeft(x.getString(R.string.title_id_card_no));
        leftTitleToRightArrowVo10.setRight(reserveRoomInfoVo.getReserveUserIdCardNo());
        arrayList.add(leftTitleToRightArrowVo10);
        return arrayList;
    }

    public ScreenLeftTitleToRightArrowResultVo getEditVo(List<LeftTitleToRightArrowVo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ScreenLeftTitleToRightArrowResultVo screenLeftTitleToRightArrowResultVo = new ScreenLeftTitleToRightArrowResultVo();
        ArrayList arrayList = new ArrayList();
        Iterator<LeftTitleToRightArrowVo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            LeftTitleToRightArrowVo next = it.next();
            if (next != null && (111 == next.getOnlyKey() || 123 == next.getOnlyKey())) {
                arrayList.add(next);
                if (next.isRequired() && x.isNullStr(next.getRight())) {
                    screenLeftTitleToRightArrowResultVo.setTipMsg(x.appendStringToResId(R.string.placeholder_value_is_empty, next.getLeft()));
                    break;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return screenLeftTitleToRightArrowResultVo;
        }
        screenLeftTitleToRightArrowResultVo.setList(arrayList);
        return screenLeftTitleToRightArrowResultVo;
    }

    public RequestReserveInfoVo getRequestReserveInfoVo(List<LeftTitleToRightArrowVo> list, String str) {
        LeftTitleToRightArrowVo itemToOnlyKey = i.getItemToOnlyKey(list, 111);
        LeftTitleToRightArrowVo itemToOnlyKey2 = i.getItemToOnlyKey(list, 123);
        RequestReserveInfoVo requestReserveInfoVo = new RequestReserveInfoVo();
        requestReserveInfoVo.setAssetInstanceKey(str);
        requestReserveInfoVo.setReserveUserName(itemToOnlyKey.getRight());
        if (itemToOnlyKey2 != null) {
            requestReserveInfoVo.setCardNo(x.trimAndUpperCase(itemToOnlyKey2.getRight()));
        }
        return requestReserveInfoVo;
    }
}
