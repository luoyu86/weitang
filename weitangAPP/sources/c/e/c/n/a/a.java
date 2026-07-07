package c.e.c.n.a;

import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.microtang.community.vo.NewCommunityActivityItemVo;
import com.chinavisionary.microtang.community.vo.RequestActivityCommentBo;
import com.chinavisionary.microtang.community.vo.RequestActivityCommentDetailsBo;
import com.chinavisionary.microtang.community.vo.RequestGetActivityRecordParamBo;
import com.chinavisionary.microtang.community.vo.ResponseActivityCommentVo;
import h.b;
import h.q.f;
import h.q.o;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @o("vtapp/v1/activity/score/detail")
    b<ResponseActivityCommentVo> getActivityComment(@h.q.a RequestActivityCommentDetailsBo requestActivityCommentDetailsBo);

    @f("vtapp/v1/nologin/activity/list")
    b<NewResponseRowsVo<NewCommunityActivityItemVo>> getActivityList(@u Map<String, String> map);

    @o("vtapp/v1/user/activity/list")
    b<NewResponseRowsVo<NewCommunityActivityItemVo>> getMyActivityList(@h.q.a RequestGetActivityRecordParamBo requestGetActivityRecordParamBo);

    @o("vtapp/v1/activity/score/create")
    b<NewResponseStateVo> postActivityComment(@h.q.a RequestActivityCommentBo requestActivityCommentBo);
}
