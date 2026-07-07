package com.chinavisionary.microtang.main.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.x;
import c.e.c.v.a.c;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.main.bo.ProjectVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RoomModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<RoomModelVo> f7499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<ResponseVo<ProjectVo>> f7500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f7501c;

    public RoomModel() {
        super(null);
        this.f7499a = new MutableLiveData<>();
        this.f7500b = new MutableLiveData<>();
        this.f7501c = (c) create(c.class);
    }

    public void getProjectList() {
        this.f7501c.getProjectList().enqueue(enqueueResponse(this.f7500b));
    }

    public MutableLiveData<ResponseVo<ProjectVo>> getProjectResult() {
        return this.f7500b;
    }

    public void getRoomModel(PageBo pageBo, String str) {
        Map<String, String> queryMap = getQueryMap(pageBo);
        if (x.isNotNull(str)) {
            queryMap.put("projectKey", str);
        }
        this.f7501c.getRoomModel(true, queryMap).enqueue(enqueueResponse(this.f7499a));
    }

    public MutableLiveData<RoomModelVo> getRoomModelResult() {
        return this.f7499a;
    }
}
