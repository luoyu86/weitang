package c.e.c.m.b;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.microtang.comment.bo.ResponseCommentBadgeBo;
import com.chinavisionary.microtang.comment.bo.ResponseCommentListBo;
import com.chinavisionary.microtang.comment.vo.CheckCreateCommentBo;
import com.chinavisionary.microtang.comment.vo.CommentDetailsVo;
import com.chinavisionary.microtang.comment.vo.CreateCommentBo;
import com.chinavisionary.microtang.comment.vo.CreateCommentResponseVo;
import h.b;
import h.q.i;
import h.q.o;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @o("business/comment/create")
    b<ResponseStateVo> createComment(@i("Token") String str, @h.q.a CreateCommentBo createCommentBo);

    @o("business/comment/popup/data")
    b<CheckCreateCommentBo> getCheckCreateComment(@i("Token") String str, @h.q.a HashMap<String, Object> map);

    @o("business/comment/sign/popup/data")
    b<CheckCreateCommentBo> getCheckSignComment(@i("Token") String str, @h.q.a HashMap<String, Object> map);

    @o("business/comment/detail")
    b<CommentDetailsVo> getCommentDetails(@i("Token") String str, @h.q.a HashMap<String, Object> map);

    @o("business/live/comment/list")
    b<ResponseCommentListBo> getCommentList(@i("Token") String str, @h.q.a c.e.c.m.c.a aVar);

    @o("business/comment/page/data")
    b<CreateCommentResponseVo> getCreateNewCommentInfo(@i("Token") String str, @h.q.a HashMap<String, Object> map);

    @o("business/live/comment/flage")
    b<ResponseCommentBadgeBo> getIsShowCommentBadge(@i("Token") String str, @h.q.a BaseVo baseVo);
}
