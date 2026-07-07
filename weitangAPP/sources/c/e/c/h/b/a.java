package c.e.c.h.b;

import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.vo.NameValueVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public final String a(int i2) {
        return x.getString(i2);
    }

    public List<LeftTitleToRightArrowVo> getEduData() {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setTitle(a(R.string.title_edu_auth_alert_tip));
        leftTitleToRightArrowVo.setType(20);
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(a(R.string.title_graduation_time));
        leftTitleToRightArrowVo2.setHint(a(R.string.hint_please_select_graduation_time));
        leftTitleToRightArrowVo2.setOnlyKey(11);
        leftTitleToRightArrowVo2.setShowArrow(true);
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(a(R.string.title_graduation_source));
        leftTitleToRightArrowVo3.setHint(a(R.string.hint_plase_select_graduation_source));
        leftTitleToRightArrowVo3.setShowArrow(true);
        leftTitleToRightArrowVo3.setOnlyKey(8);
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(a(R.string.title_edu_checkout_sms_code));
        leftTitleToRightArrowVo4.setHint(a(R.string.hint_plase_select_edu_check_out));
        leftTitleToRightArrowVo4.setShowArrow(true);
        leftTitleToRightArrowVo4.setEdit(true);
        leftTitleToRightArrowVo4.setMaxLength(20);
        leftTitleToRightArrowVo4.setInputType(2);
        leftTitleToRightArrowVo4.setOnlyKey(10);
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setType(-2);
        arrayList.add(leftTitleToRightArrowVo5);
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setUrl(String.valueOf(R.mipmap.ic_edu_photo));
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setExtObj(resourceVo);
        leftTitleToRightArrowVo6.setType(19);
        leftTitleToRightArrowVo6.setOnlyKey(9);
        arrayList.add(leftTitleToRightArrowVo6);
        return arrayList;
    }

    public List<NameValueVo> getEduSourceList() {
        ArrayList arrayList = new ArrayList();
        NameValueVo nameValueVo = new NameValueVo();
        nameValueVo.setName("国内院校");
        nameValueVo.setValue(1);
        arrayList.add(nameValueVo);
        NameValueVo nameValueVo2 = new NameValueVo();
        nameValueVo2.setName("国外院校");
        nameValueVo2.setValue(2);
        arrayList.add(nameValueVo2);
        return arrayList;
    }
}
