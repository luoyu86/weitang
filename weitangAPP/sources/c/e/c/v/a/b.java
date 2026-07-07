package c.e.c.v.a;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.microtang.main.bo.ProjectVo;
import com.chinavisionary.microtang.main.bo.RequestGroupItemDetailsBo;
import com.chinavisionary.microtang.main.bo.RequestGroupItemDetailsRoomListBo;
import com.chinavisionary.microtang.main.bo.RequestGroupListParamBo;
import com.chinavisionary.microtang.main.bo.RequestProjectParamBo;
import com.chinavisionary.microtang.main.bo.RequestSwitchProjectBo;
import com.chinavisionary.microtang.main.bo.ResponseAliYunOssBo;
import com.chinavisionary.microtang.main.vo.CityItemVo;
import com.chinavisionary.microtang.main.vo.ResponseGroupItemDetailsRoomVo;
import com.chinavisionary.microtang.main.vo.ResponseGroupItemDetailsVo;
import com.chinavisionary.microtang.main.vo.ResponseGroupResultVo;
import h.q.i;
import h.q.o;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    @o("nologin/group/picture/auth")
    h.b<ResponseAliYunOssBo> getAliYunOssAuth(@i("Token") String str, @h.q.a BaseVo baseVo);

    @o("nologin/project/city")
    h.b<NewResponseRowsVo<CityItemVo>> getCityList(@i("Token") String str, @h.q.a BaseVo baseVo);

    @o("nologin/group/detail")
    h.b<ResponseGroupItemDetailsVo> getGroupItemDetails(@i("Token") String str, @h.q.a RequestGroupItemDetailsBo requestGroupItemDetailsBo);

    @o("nologin/group/house/list")
    h.b<NewResponseRowsVo<ResponseGroupItemDetailsRoomVo>> getGroupItemDetailsRoomList(@i("Token") String str, @h.q.a RequestGroupItemDetailsRoomListBo requestGroupItemDetailsRoomListBo);

    @o("nologin/group/list")
    h.b<NewResponseRowsVo<ResponseGroupResultVo>> getGroupList(@i("Token") String str, @h.q.a RequestGroupListParamBo requestGroupListParamBo);

    @o("nologin/project/list")
    h.b<NewResponseRowsVo<ProjectVo>> getProjectList(@i("Token") String str, @h.q.a RequestProjectParamBo requestProjectParamBo);

    @o("nologin/update/project")
    h.b<NewResponseStateVo> switchProject(@i("Token") String str, @h.q.a RequestSwitchProjectBo requestSwitchProjectBo);
}
