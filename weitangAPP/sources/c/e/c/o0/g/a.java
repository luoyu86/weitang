package c.e.c.o0.g;

import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.web.vo.ResponseArticleVo;
import h.b;
import h.q.f;
import h.q.s;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @f("frameworks/article/{articleKey}")
    b<ResponseContent<ResponseArticleVo>> getArticleToKey(@s("articleKey") String str);
}
