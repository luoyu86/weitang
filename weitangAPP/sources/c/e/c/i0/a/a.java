package c.e.c.i0.a;

import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.service.bo.CreateServiceCommentBo;
import com.chinavisionary.microtang.service.vo.CustomerHotReasonVo;
import com.chinavisionary.microtang.service.vo.CustomerServerRecordVo;
import com.chinavisionary.microtang.service.vo.MeReasonVo;
import com.chinavisionary.microtang.service.vo.QuestionsCategoriesVo;
import com.chinavisionary.microtang.service.vo.QuestionsTemplateVo;
import com.chinavisionary.microtang.service.vo.RequestCreateQuestionsFromVo;
import com.chinavisionary.microtang.service.vo.RequestCustomerVo;
import h.q.f;
import h.q.o;
import h.q.s;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @o("consult")
    h.b<ResponseContent<ResponseStateVo>> createQuestion(@h.q.a RequestCreateQuestionsFromVo requestCreateQuestionsFromVo);

    @f("consult/hot/issue")
    h.b<ResponseContent<ResponseVo<CustomerHotReasonVo>>> getHotQuestionsList();

    @f("consult")
    h.b<ResponseContent<ResponseVo<MeReasonVo>>> getMeQuestionsList();

    @f("customers/services/questions/categories/{key}")
    h.b<ResponseContent<ResponseVo<QuestionsCategoriesVo>>> getQuestions(@s("key") String str);

    @f("customers/services/questions/categories")
    h.b<ResponseContent<ResponseVo<QuestionsCategoriesVo>>> getQuestionsCategories();

    @f("workorder/customer/complaintList")
    h.b<ResponseContent<ResponseVo<CustomerServerRecordVo>>> getRecordList(@u Map<String, String> map);

    @f("consult/template")
    h.b<ResponseContent<QuestionsTemplateVo>> getTemplateKey();

    @o("customers/services/questions")
    h.b<ResponseContent<ResponseStateVo>> postCustomerService(@h.q.a RequestCustomerVo requestCustomerVo);

    @o("consult/reply")
    h.b<ResponseContent<ResponseStateVo>> postCustomerServiceComment(@h.q.a CreateServiceCommentBo createServiceCommentBo);
}
