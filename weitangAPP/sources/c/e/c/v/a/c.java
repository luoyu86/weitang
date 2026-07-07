package c.e.c.v.a;

import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.contract.vo.ResultTreatyVo;
import com.chinavisionary.microtang.main.bo.BannerVo;
import com.chinavisionary.microtang.main.bo.ProjectVo;
import com.chinavisionary.microtang.main.vo.RoomModelDataVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import h.q.f;
import h.q.s;
import h.q.t;
import h.q.u;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    @f("modules/projects")
    h.b<ResponseContent<ResponseVo<ProjectVo>>> getProjectList();

    @f("houses/{assetkey}/air/specification")
    h.b<ResponseContent<ResultTreatyVo>> getRoomAir(@s("assetkey") String str);

    @f("banners/index")
    h.b<ResponseContent<ResponseVo<BannerVo>>> getRoomBannerList();

    @f("modules")
    h.b<ResponseContent<RoomModelVo>> getRoomModel(@t("initDate") boolean z, @u Map<String, String> map);

    @f("modules/data")
    h.b<ResponseContent<RoomModelDataVo>> getRoomModelData(@t("moduleKeys") List<String> list);
}
