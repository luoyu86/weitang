package com.chinavisionary.microtang.push;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.e0.a.b;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.community.CommunityActivityEvaluateActivity;
import com.chinavisionary.microtang.msg.MsgDetailsActivity;
import com.chinavisionary.microtang.msg.vo.MsgVo;
import com.chinavisionary.microtang.push.event.EventReadPushMessageVo;
import com.chinavisionary.microtang.web.vo.ActivityEvaluateVo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PushMsgActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return 0;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        q.d(getClass().getSimpleName(), "msg :" + this.f6477e);
        if (x.isNotNull(this.f6477e)) {
            MsgVo msgVo = (MsgVo) JSON.parseObject(this.f6477e, MsgVo.class);
            Map<String, String> ext = msgVo.getExt();
            if (ext != null) {
                if (ext.containsKey("messageKey")) {
                    n0(ext.get("messageKey"));
                }
                int i2 = -1;
                if (ext.containsKey("forwardType")) {
                    String str = ext.get("forwardType");
                    if (x.isNotNull(str)) {
                        i2 = Integer.parseInt(str);
                    }
                }
                if (ext.containsKey("targetAppid") && ext.containsKey("targetPath") && (i2 == 15 || i2 == 18)) {
                    String str2 = ext.get("targetAppid");
                    String str3 = ext.get("targetPath");
                    if (x.isNotNull(str2) && x.isNotNull(str3)) {
                        g0(i2, str2, str3);
                    }
                } else if (ext.containsKey("activityPrimaryKey") && ext.containsKey("activityName") && i2 == 9) {
                    String str4 = ext.get("activityPrimaryKey");
                    String str5 = ext.get("activityName");
                    String str6 = ext.get("isEvaluate");
                    if (x.isNotNull(str4) && x.isNotNull(str5)) {
                        ActivityEvaluateVo activityEvaluateVo = new ActivityEvaluateVo();
                        activityEvaluateVo.setActivityName(str5);
                        activityEvaluateVo.setActivityPrimaryKey(str4);
                        activityEvaluateVo.setEvaluate("1".equals(str6));
                        W(CommunityActivityEvaluateActivity.class, JSON.toJSONString(activityEvaluateVo));
                    }
                } else if (ext.containsKey("URL")) {
                    g0(i2, ext.get("URL"), msgVo.getTitle());
                } else {
                    m0();
                }
            } else {
                m0();
            }
        }
        finish();
    }

    public final void m0() {
        Intent intent = new Intent(this, (Class<?>) MsgDetailsActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", this.f6477e);
        startActivity(intent);
    }

    public final void n0(String str) {
        if (x.isNotNull(str)) {
            b.getInstance().setNotifyMessageKey(null);
            EventReadPushMessageVo eventReadPushMessageVo = new EventReadPushMessageVo();
            eventReadPushMessageVo.setMessageKey(str);
            j0(eventReadPushMessageVo);
        }
    }
}
