package c.e.c.u.n;

import c.e.a.d.j;
import c.e.a.d.o;
import com.chinavisionary.microtang.login.bo.SpinnerVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1895a = new a();

    public static a getInstance() {
        return f1895a;
    }

    public int getSelectIndex(List<SpinnerVo> list) {
        int i2 = -1;
        if (o.isNotEmpty(list)) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (list.get(i3).isSelect()) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    public List<SpinnerVo> getSpinnerVoList() {
        ArrayList arrayList = new ArrayList();
        SpinnerVo spinnerVo = new SpinnerVo();
        spinnerVo.setEveValue(1);
        spinnerVo.setValue("线上");
        spinnerVo.setSelect(j.getInstance().f1216b == 1);
        arrayList.add(spinnerVo);
        SpinnerVo spinnerVo2 = new SpinnerVo();
        spinnerVo2.setEveValue(7);
        spinnerVo2.setValue("预生产");
        spinnerVo2.setSelect(j.getInstance().f1216b == 7);
        SpinnerVo spinnerVo3 = new SpinnerVo();
        spinnerVo3.setEveValue(9);
        spinnerVo3.setValue("新预生产");
        spinnerVo3.setSelect(j.getInstance().f1216b == 9);
        arrayList.add(spinnerVo3);
        SpinnerVo spinnerVo4 = new SpinnerVo();
        spinnerVo4.setEveValue(6);
        spinnerVo4.setValue("UAT2");
        spinnerVo4.setSelect(j.getInstance().f1216b == 6);
        arrayList.add(spinnerVo4);
        SpinnerVo spinnerVo5 = new SpinnerVo();
        spinnerVo5.setEveValue(10);
        spinnerVo5.setValue("K8S_UAT2");
        spinnerVo5.setSelect(j.getInstance().f1216b == 10);
        SpinnerVo spinnerVo6 = new SpinnerVo();
        spinnerVo6.setEveValue(5);
        spinnerVo6.setValue("UAT");
        spinnerVo6.setSelect(j.getInstance().f1216b == 5);
        SpinnerVo spinnerVo7 = new SpinnerVo();
        spinnerVo7.setEveValue(8);
        spinnerVo7.setValue("深圳(SIT)");
        spinnerVo7.setSelect(j.getInstance().f1216b == 8);
        arrayList.add(spinnerVo7);
        SpinnerVo spinnerVo8 = new SpinnerVo();
        spinnerVo8.setEveValue(3);
        spinnerVo8.setValue("灰度(SIT)");
        spinnerVo8.setSelect(j.getInstance().f1216b == 3);
        return arrayList;
    }
}
