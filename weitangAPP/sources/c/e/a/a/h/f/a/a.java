package c.e.a.a.h.f.a;

import com.chinavisionary.core.app.config.bo.AppUpdateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import h.b;
import h.q.f;
import h.q.s;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @f("nologin/system/version/{type}")
    b<ResponseContent<AppUpdateVo>> getAppVersion(@s("type") String str);
}
