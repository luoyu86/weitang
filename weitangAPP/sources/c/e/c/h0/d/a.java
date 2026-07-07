package c.e.c.h0.d;

import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.room.vo.CreateRoomPreLookVo;
import com.chinavisionary.microtang.room.vo.MoreRentRoomVo;
import com.chinavisionary.microtang.room.vo.PreRoomInfoVo;
import com.chinavisionary.microtang.room.vo.ProductDetailsVo;
import com.chinavisionary.microtang.room.vo.ResponseMoreRentCommentVo;
import com.chinavisionary.microtang.room.vo.RoomSourceDetailsVo;
import h.b;
import h.q.f;
import h.q.o;
import h.q.s;
import h.q.t;
import h.q.u;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @f("houses/{key}/air/specification")
    b<ResponseContent<ResponseStateVo>> getAirQuality(@s("key") String str);

    @f("goods/housing/comment")
    b<ResponseContent<ResponseMoreRentCommentVo>> getRoomCommentList(@t("goodsKey") String str);

    @f("goods/{key}/detail")
    b<ResponseContent<ProductDetailsVo>> getRoomDetails(@s("key") String str);

    @f("goods/rented/houses")
    b<ResponseContent<ResponseVo<MoreRentRoomVo>>> getRoomIdleList(@u Map<String, String> map);

    @o("user/appointment/before")
    b<PreRoomInfoVo> getRoomPreInfo(@h.q.a HashMap<String, Object> map);

    @f("nologin/spacegoods/house/detail/{spaceId}")
    b<RoomSourceDetailsVo> getRoomSourceDetails(@s("spaceId") String str);

    @o("user/appointment")
    b<ResponseStateVo> postPreLook(@h.q.a CreateRoomPreLookVo createRoomPreLookVo);
}
