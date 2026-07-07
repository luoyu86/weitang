package com.chinavisionary.microtang.community.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActivityConstantVo extends NewBaseVo {
    private List<KeyValueVo> activityLabType;

    public List<KeyValueVo> getActivityLabType() {
        return this.activityLabType;
    }

    public void setActivityLabType(List<KeyValueVo> list) {
        this.activityLabType = list;
    }
}
