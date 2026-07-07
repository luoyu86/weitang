package com.chinavisionary.microtang.community;

import android.os.Bundle;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.community.fragment.ActivityCommentFragment;
import com.chinavisionary.microtang.web.vo.ActivityEvaluateVo;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityEvaluateActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        try {
            ActivityEvaluateVo activityEvaluateVo = (ActivityEvaluateVo) JSON.parseObject(this.f6477e, ActivityEvaluateVo.class);
            Y(ActivityCommentFragment.getInstance(activityEvaluateVo.getActivityPrimaryKey(), activityEvaluateVo.getActivityName(), !activityEvaluateVo.isEvaluate()), R.id.flayout_content);
        } catch (Exception e2) {
            e2.printStackTrace();
            e0(R.string.tip_open_failed_param_failed);
            finish();
        }
    }
}
