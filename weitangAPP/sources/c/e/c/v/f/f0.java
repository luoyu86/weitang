package c.e.c.v.f;

import com.chinavisionary.microtang.main.vo.RoomModelVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f0 f1954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<RoomModelVo.ModulesBean> f1955b;

    public static f0 getInstance() {
        if (f1954a == null) {
            synchronized (f0.class) {
                if (f1954a == null) {
                    f1954a = new f0();
                }
            }
        }
        return f1954a;
    }

    public List<RoomModelVo.ModulesBean> getModulesBeans() {
        return this.f1955b;
    }

    public void recycler() {
        List<RoomModelVo.ModulesBean> list = this.f1955b;
        if (list != null) {
            list.clear();
        }
    }

    public void setModulesBeans(List<RoomModelVo.ModulesBean> list) {
        this.f1955b = list;
    }
}
