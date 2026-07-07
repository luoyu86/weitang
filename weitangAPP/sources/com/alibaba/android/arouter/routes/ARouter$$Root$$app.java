package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.taobao.accs.common.Constants;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Root$$app implements IRouteRoot {
    @Override // com.alibaba.android.arouter.facade.template.IRouteRoot
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put("bill_tab", ARouter$$Group$$bill_tab.class);
        map.put("contract", ARouter$$Group$$contract.class);
        map.put("forward", ARouter$$Group$$forward.class);
        map.put("id_auth", ARouter$$Group$$id_auth.class);
        map.put("live_check", ARouter$$Group$$live_check.class);
        map.put("login", ARouter$$Group$$login.class);
        map.put(Constants.SHARED_MESSAGE_ID_FILE, ARouter$$Group$$message.class);
        map.put("pay_success_tip", ARouter$$Group$$pay_success_tip.class);
        map.put("reserve_list", ARouter$$Group$$reserve_list.class);
        map.put("webview", ARouter$$Group$$webview.class);
    }
}
