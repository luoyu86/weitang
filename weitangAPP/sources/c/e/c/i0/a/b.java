package c.e.c.i0.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.service.bo.CreateFormBo;
import com.chinavisionary.microtang.service.bo.DataSourceVo;
import com.chinavisionary.microtang.service.bo.ResponseFormBo;
import com.chinavisionary.microtang.service.bo.ResponseFormTemplateDetailsVo;
import h.q.f;
import h.q.o;
import h.q.s;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    @o("frameworks/forms")
    h.b<ResponseContent<String>> createForm(@h.q.a CreateFormBo createFormBo);

    @f("frameworks/forms/{formKey}")
    h.b<ResponseContent<ResponseFormBo>> getFormData(@s("formKey") String str);

    @f("frameworks/forms/datasources/{formDataSourceKey}")
    h.b<ResponseContent<DataSourceVo>> getFormDataSource(@s("formDataSourceKey") String str);

    @f("frameworks/forms/datasources/template/{formTemplateKey}")
    h.b<ResponseContent<ResponseRowsVo<DataSourceVo>>> getFormTemplateDataSource(@s("formTemplateKey") String str);

    @f("frameworks/forms/templates/{templateKey}")
    h.b<ResponseContent<ResponseFormTemplateDetailsVo>> getFormTemplateDetails(@s("templateKey") String str);
}
