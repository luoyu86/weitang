package c.e.c.v.d;

import c.e.a.d.j;
import c.e.a.d.o;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.main.bo.ResponseBannerItemVo;
import com.chinavisionary.microtang.main.bo.ResponseNewBannerItemVo;
import com.chinavisionary.microtang.main.vo.ModelBannerVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(String str) {
        if (!x.isNotNull(str) || str.contains("http")) {
            return str;
        }
        if (str.indexOf("/") == 0) {
            return j.getInstance().getH5BaseUrl() + str.substring(1);
        }
        return j.getInstance().getH5BaseUrl() + str;
    }

    public static ResourceVo b(String str) {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setSampleUrl(str);
        resourceVo.setUrl(str);
        return resourceVo;
    }

    public static RoomModelVo.ModulesBean getBanner(NewResponseRowsVo<ResponseNewBannerItemVo> newResponseRowsVo) {
        RoomModelVo.ModulesBean modulesBean = new RoomModelVo.ModulesBean();
        modulesBean.setModuleType(1);
        modulesBean.setDataKey("banner-key");
        ArrayList arrayList = new ArrayList();
        if (newResponseRowsVo != null && o.isNotEmpty(newResponseRowsVo.getRows())) {
            for (ResponseNewBannerItemVo responseNewBannerItemVo : newResponseRowsVo.getRows()) {
                if (responseNewBannerItemVo != null) {
                    ModelBannerVo modelBannerVo = new ModelBannerVo();
                    ModelBannerVo.ParamBean paramBean = new ModelBannerVo.ParamBean();
                    paramBean.setBaseKey(responseNewBannerItemVo.getPrimaryKey());
                    String linkUrl = responseNewBannerItemVo.getLinkUrl();
                    modelBannerVo.setType(responseNewBannerItemVo.getLinkForwardType());
                    if (8 == responseNewBannerItemVo.getLinkForwardType()) {
                        responseNewBannerItemVo.setTargetMiniType(FundNewsVo.TYPE_ALIPAY);
                    }
                    paramBean.setTargetAppid(responseNewBannerItemVo.getTargetAppid());
                    paramBean.setTargetMiniType(responseNewBannerItemVo.getTargetMiniType());
                    paramBean.setTargetPath(responseNewBannerItemVo.getTargetPath());
                    if (x.isNotNull(linkUrl)) {
                        String linkParam = responseNewBannerItemVo.getLinkParam();
                        if (x.isNotNull(linkParam)) {
                            linkUrl = linkUrl.contains("?") ? linkUrl + "&" + linkParam : linkUrl + "?" + linkParam;
                        }
                        paramBean.setHref(a(linkUrl));
                    } else if (x.isNotNull(responseNewBannerItemVo.getLinkKey())) {
                        modelBannerVo.setType(3);
                        paramBean.setHref(responseNewBannerItemVo.getLinkKey());
                    }
                    paramBean.setTitle(responseNewBannerItemVo.getTitle());
                    paramBean.setResourceVo(b(responseNewBannerItemVo.getIconUrl()));
                    modelBannerVo.setParam(paramBean);
                    arrayList.add(modelBannerVo);
                }
            }
        }
        modulesBean.setModelBannerVos(arrayList);
        return modulesBean;
    }

    public static RoomModelVo.ModulesBean newBannerToModule(NewResponseRowsVo<ResponseBannerItemVo> newResponseRowsVo) {
        ArrayList arrayList = new ArrayList();
        List<ResponseBannerItemVo> rows = newResponseRowsVo.getRows();
        if (o.isNotEmpty(rows)) {
            for (ResponseBannerItemVo responseBannerItemVo : rows) {
                ModelBannerVo modelBannerVo = new ModelBannerVo();
                modelBannerVo.setType(1);
                modelBannerVo.setDataKey(responseBannerItemVo.getPrimaryKey());
                ModelBannerVo.ParamBean paramBean = new ModelBannerVo.ParamBean();
                paramBean.setHref(responseBannerItemVo.getJumpUrl());
                ResourceVo resourceVo = new ResourceVo();
                resourceVo.setUrl(responseBannerItemVo.getCoverUrl());
                resourceVo.setSampleUrl(responseBannerItemVo.getCoverUrl());
                paramBean.setResourceVo(resourceVo);
                modelBannerVo.setParam(paramBean);
                arrayList.add(modelBannerVo);
            }
        }
        RoomModelVo.ModulesBean modulesBean = new RoomModelVo.ModulesBean();
        modulesBean.setDataKey("banner-key");
        modulesBean.setModuleType(1);
        modulesBean.setModelBannerVos(arrayList);
        return modulesBean;
    }
}
