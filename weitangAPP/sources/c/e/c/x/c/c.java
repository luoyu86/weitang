package c.e.c.x.c;

import com.chinavisionary.microtang.me.vo.FundNewsVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2020a = new c();

    public static c getInstance() {
        return f2020a;
    }

    public List<FundNewsVo> getFundData() {
        ArrayList arrayList = new ArrayList();
        FundNewsVo fundNewsVo = new FundNewsVo();
        fundNewsVo.setItemType(2);
        arrayList.add(fundNewsVo);
        FundNewsVo fundNewsVo2 = new FundNewsVo();
        fundNewsVo2.setItemType(3);
        arrayList.add(fundNewsVo2);
        FundNewsVo fundNewsVo3 = new FundNewsVo();
        fundNewsVo3.setItemType(34952);
        arrayList.add(fundNewsVo3);
        return arrayList;
    }

    public List<FundNewsVo> getNewsTestData() {
        return new ArrayList();
    }
}
