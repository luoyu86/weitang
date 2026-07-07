package c.e.c.v.f;

import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.main.bo.ProjectVo;
import com.chinavisionary.microtang.main.bo.ResponseBannerItemVo;
import com.chinavisionary.microtang.main.event.EventUpdateAliYunOss;
import com.chinavisionary.microtang.main.vo.GroupItemVo;
import com.chinavisionary.microtang.main.vo.ModelBannerVo;
import com.chinavisionary.microtang.main.vo.ModelProductVo;
import com.chinavisionary.microtang.main.vo.ResponseGroupResultVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.repair.vo.RepairLeftVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1959a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Integer> f1960b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, RoomModelVo.ModulesBean> f1961c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<String> f1962d = new ArrayList<>();

    public final List<RoomModelVo.ModulesBean> a(List<String> list, Map<String, ArrayList<ModelBannerVo>> map, Map<String, ArrayList<RoomModelVo.ModulesBean>> map2) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (this.f1961c.containsKey(str)) {
                RoomModelVo.ModulesBean modulesBean = this.f1961c.get(str);
                if (map.containsKey(str)) {
                    ArrayList<ModelBannerVo> arrayList2 = map.get(str);
                    if (modulesBean != null && arrayList2 != null && !arrayList2.isEmpty()) {
                        modulesBean.setDataKey(arrayList2.get(arrayList2.size() - 1).getDataKey());
                        modulesBean.setModelBannerVos(arrayList2);
                    }
                    if (!c.e.a.a.a.getInstance().isNewVersionModel()) {
                        arrayList.add(modulesBean);
                    }
                } else if (map2.containsKey(str)) {
                    ArrayList<RoomModelVo.ModulesBean> arrayList3 = map2.get(str);
                    if (arrayList3 != null) {
                        arrayList.addAll(arrayList3);
                    }
                } else {
                    arrayList.add(modulesBean);
                }
            }
        }
        return arrayList;
    }

    public final List<ResourceVo> b(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(new ResourceVo());
        }
        return arrayList;
    }

    public final RoomModelVo.ModulesBean c(ResponseGroupResultVo responseGroupResultVo) {
        RoomModelVo.ModulesBean modulesBean = new RoomModelVo.ModulesBean();
        modulesBean.setModuleTitle(responseGroupResultVo.getProjectName());
        modulesBean.setModuleSubtitle(responseGroupResultVo.getProjectDesc());
        modulesBean.setModuleType(2);
        return modulesBean;
    }

    public final RoomModelVo.ModulesBean d(int i2, BaseRecyclerAdapter<RoomModelVo.ModulesBean> baseRecyclerAdapter) {
        if (i2 <= 1 || baseRecyclerAdapter.getList() == null || baseRecyclerAdapter.getList().isEmpty()) {
            return null;
        }
        return baseRecyclerAdapter.getList().get(baseRecyclerAdapter.getList().size() - 1);
    }

    public final List<String> e(int i2, BaseRecyclerAdapter<RoomModelVo.ModulesBean> baseRecyclerAdapter) {
        ArrayList arrayList = new ArrayList();
        if (i2 == 1) {
            return this.f1962d;
        }
        RoomModelVo.ModulesBean modulesBeanD = d(i2, baseRecyclerAdapter);
        if (modulesBeanD == null || this.f1962d.isEmpty()) {
            return arrayList;
        }
        int iIndexOf = this.f1962d.indexOf(modulesBeanD.getModuleKey());
        ArrayList<String> arrayList2 = this.f1962d;
        return arrayList2.subList(iIndexOf, arrayList2.size());
    }

    public final ModelProductVo.ParamBean f(GroupItemVo groupItemVo) {
        boolean z;
        ModelProductVo.ParamBean paramBean = new ModelProductVo.ParamBean();
        paramBean.setKey(groupItemVo.getGroupKey());
        paramBean.setCommodityTitle(groupItemVo.getGroupName());
        paramBean.setCommoditySubtitle(groupItemVo.getGroupDesc());
        paramBean.setMinimumMonthlyRent(groupItemVo.getRentPrice());
        List<ResourceVo> listG = g(groupItemVo);
        if (c.e.a.d.o.listIsEmpty(listG)) {
            listG = h(groupItemVo.getGroupName());
            z = true;
        } else {
            z = false;
        }
        if (c.e.a.d.o.isNotEmpty(listG)) {
            if (z) {
                c.e.a.a.i.b.sortResourceList(listG);
            }
            paramBean.setResourceVos(listG);
        } else {
            paramBean.setRefresh(z);
            paramBean.setResourceVos(b(3));
        }
        return paramBean;
    }

    public final List<ResourceVo> g(GroupItemVo groupItemVo) {
        ArrayList arrayList = new ArrayList();
        if (c.e.a.d.x.isNotNull(groupItemVo.getOnePicture())) {
            arrayList.add(i(groupItemVo.getOnePicture()));
        }
        if (c.e.a.d.x.isNotNull(groupItemVo.getTwoPicture())) {
            arrayList.add(i(groupItemVo.getTwoPicture()));
        }
        if (c.e.a.d.x.isNotNull(groupItemVo.getThreePicture())) {
            arrayList.add(i(groupItemVo.getThreePicture()));
        }
        return arrayList;
    }

    public List<RoomModelVo.ModulesBean> getAdapterData(NewResponseRowsVo<ResponseGroupResultVo> newResponseRowsVo) {
        boolean zIsRefresh;
        ArrayList arrayList = new ArrayList();
        if (newResponseRowsVo == null || !c.e.a.d.o.isNotEmpty(newResponseRowsVo.getRows())) {
            zIsRefresh = false;
        } else {
            zIsRefresh = false;
            for (ResponseGroupResultVo responseGroupResultVo : newResponseRowsVo.getRows()) {
                if (responseGroupResultVo != null && c.e.a.d.o.isNotEmpty(responseGroupResultVo.getGroupItemCloudDtos())) {
                    arrayList.add(c(responseGroupResultVo));
                    for (GroupItemVo groupItemVo : responseGroupResultVo.getGroupItemCloudDtos()) {
                        if (groupItemVo != null && c.e.a.d.x.isNotNull(groupItemVo.getGroupKey())) {
                            RoomModelVo.ModulesBean modulesBean = new RoomModelVo.ModulesBean();
                            modulesBean.setDataKey(groupItemVo.getGroupKey());
                            ModelProductVo modelProductVo = new ModelProductVo();
                            ModelProductVo.ParamBean paramBeanF = f(groupItemVo);
                            if (!zIsRefresh) {
                                zIsRefresh = paramBeanF.isRefresh();
                            }
                            modelProductVo.setParam(paramBeanF);
                            modulesBean.setModelProductVo(modelProductVo);
                            modulesBean.setModuleType(3);
                            arrayList.add(modulesBean);
                        }
                    }
                }
            }
        }
        boolean z = System.currentTimeMillis() - this.f1959a > 30000;
        if (zIsRefresh && z) {
            this.f1959a = System.currentTimeMillis();
            k();
        }
        return arrayList;
    }

    public List<RoomModelVo.ModulesBean> getAdapterDataToRoomModel(RoomModelVo roomModelVo, int i2, BaseRecyclerAdapter<RoomModelVo.ModulesBean> baseRecyclerAdapter) {
        j(roomModelVo, i2);
        ArrayList arrayList = new ArrayList();
        if (roomModelVo == null) {
            return arrayList;
        }
        List<RoomModelVo.DatasBean> datas = roomModelVo.getDatas();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (datas == null || datas.isEmpty()) {
            return arrayList;
        }
        l(datas, map, map2);
        List<String> listE = e(i2, baseRecyclerAdapter);
        return (listE == null || listE.isEmpty()) ? arrayList : a(listE, map, map2);
    }

    public PageBo getPageBoAndSetLastModuleKey(PageBo pageBo, BaseRecyclerAdapter<RoomModelVo.ModulesBean> baseRecyclerAdapter) {
        RoomModelVo.ModulesBean modulesBeanD = d(pageBo.getPage(), baseRecyclerAdapter);
        if (modulesBeanD != null) {
            pageBo.setModuleKey(modulesBeanD.getModuleKey());
            pageBo.setDataKey(modulesBeanD.getDataKey());
        }
        return pageBo;
    }

    public ProjectVo getSelectProjectVo(List<ProjectVo> list, String str) {
        if (c.e.a.d.x.isNotNull(str)) {
            for (ProjectVo projectVo : list) {
                if (projectVo != null && str.equals(projectVo.getProjectKey())) {
                    return projectVo;
                }
            }
        }
        return null;
    }

    public final List<ResourceVo> h(String str) {
        return c.e.a.a.i.b.getInstance().getResourceListToPath(c.e.a.a.i.b.getGroupFilePathToGroupName(str));
    }

    public final ResourceVo i(String str) {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setUrl(str);
        resourceVo.setSampleUrl(str);
        return resourceVo;
    }

    public boolean isFull(BaseRecyclerAdapter<RoomModelVo.ModulesBean> baseRecyclerAdapter, int i2) {
        return baseRecyclerAdapter.getItemViewType(i2) == 26214 || baseRecyclerAdapter.getItemViewType(i2) == 2 || baseRecyclerAdapter.getItemViewType(i2) == 34952 || baseRecyclerAdapter.getItemViewType(i2) == 39321 || baseRecyclerAdapter.getItemViewType(i2) == 1;
    }

    public final void j(RoomModelVo roomModelVo, int i2) {
        if (roomModelVo != null) {
            if (i2 == 1) {
                this.f1962d.clear();
                this.f1961c.clear();
                this.f1960b.clear();
            }
            List<RoomModelVo.ModulesBean> modules = roomModelVo.getModules();
            if (modules == null || modules.isEmpty()) {
                return;
            }
            for (RoomModelVo.ModulesBean modulesBean : modules) {
                if (modulesBean != null && c.e.a.d.x.isNotNull(modulesBean.getModuleKey())) {
                    String moduleKey = modulesBean.getModuleKey();
                    this.f1962d.add(moduleKey);
                    this.f1961c.put(moduleKey, modulesBean);
                    this.f1960b.put(moduleKey, Integer.valueOf(modulesBean.getModuleType()));
                }
            }
        }
    }

    public final void k() {
        EventUpdateAliYunOss eventUpdateAliYunOss = new EventUpdateAliYunOss();
        eventUpdateAliYunOss.setMethodName("sendRefreshAliYunOss");
        g.b.a.c.getDefault().post(eventUpdateAliYunOss);
    }

    public final void l(List<RoomModelVo.DatasBean> list, Map<String, ArrayList<ModelBannerVo>> map, Map<String, ArrayList<RoomModelVo.ModulesBean>> map2) {
        for (RoomModelVo.DatasBean datasBean : list) {
            if (datasBean != null) {
                String moduleKey = datasBean.getModuleKey();
                if (c.e.a.d.x.isNotNull(moduleKey) && this.f1960b.containsKey(moduleKey)) {
                    Integer num = this.f1960b.get(moduleKey);
                    String dataKey = datasBean.getDataKey();
                    String dataParam = datasBean.getDataParam();
                    if (c.e.a.d.x.isNotNull(dataParam) && num != null) {
                        int iIntValue = num.intValue();
                        if (iIntValue == 1) {
                            m(dataParam, dataKey, moduleKey, map);
                        } else if (iIntValue == 3) {
                            n(moduleKey, dataParam, dataKey, map2);
                        }
                    }
                }
            }
        }
    }

    public final void m(String str, String str2, String str3, Map<String, ArrayList<ModelBannerVo>> map) {
        try {
            ModelBannerVo modelBannerVo = (ModelBannerVo) JSON.parseObject(str, ModelBannerVo.class);
            modelBannerVo.setDataKey(str2);
            if (map.containsKey(str3)) {
                ArrayList<ModelBannerVo> arrayList = map.get(str3);
                if (arrayList != null) {
                    arrayList.add(modelBannerVo);
                }
            } else {
                ArrayList<ModelBannerVo> arrayList2 = new ArrayList<>();
                arrayList2.add(modelBannerVo);
                map.put(str3, arrayList2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void n(String str, String str2, String str3, Map<String, ArrayList<RoomModelVo.ModulesBean>> map) {
        if (this.f1961c.containsKey(str)) {
            ModelProductVo modelProductVo = (ModelProductVo) JSON.parseObject(str2, ModelProductVo.class);
            RoomModelVo.ModulesBean modulesBean = this.f1961c.get(str);
            if (modulesBean != null) {
                RoomModelVo.ModulesBean modulesBeanM74clone = modulesBean.m74clone();
                modulesBeanM74clone.setDataKey(str3);
                modulesBeanM74clone.setModelProductVo(modelProductVo);
                if (!map.containsKey(str)) {
                    ArrayList<RoomModelVo.ModulesBean> arrayList = new ArrayList<>();
                    arrayList.add(modulesBeanM74clone);
                    map.put(str, arrayList);
                } else {
                    ArrayList<RoomModelVo.ModulesBean> arrayList2 = map.get(str);
                    if (arrayList2 != null) {
                        arrayList2.add(modulesBeanM74clone);
                    }
                }
            }
        }
    }

    public RoomModelVo.ModulesBean newBannerToModule(NewResponseRowsVo<ResponseBannerItemVo> newResponseRowsVo) {
        ArrayList arrayList = new ArrayList();
        List<ResponseBannerItemVo> rows = newResponseRowsVo.getRows();
        if (c.e.a.d.o.isNotEmpty(rows)) {
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

    public List<RepairLeftVo> projectToRepairLeftVo(List<ProjectVo> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (c.e.a.d.o.isNotEmpty(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ProjectVo projectVo = list.get(i2);
                if (projectVo != null) {
                    String projectKey = projectVo.getProjectKey();
                    RepairLeftVo repairLeftVo = new RepairLeftVo();
                    repairLeftVo.setKey(projectKey);
                    repairLeftVo.setTitle(projectVo.getProjectName());
                    if (str == null && i2 == 0) {
                        repairLeftVo.setSelect(true);
                        str = projectKey;
                    }
                    arrayList.add(repairLeftVo);
                }
            }
        }
        return arrayList;
    }

    public void saveSelectProject(ProjectVo projectVo) {
        c.e.a.a.i.b.getInstance().setProjectName(projectVo.getProjectName());
        c.e.a.d.w.getInstance().putString("selectProjectName", projectVo.getProjectName());
        if (c.e.a.d.x.isNotNull(projectVo.getProjectKey())) {
            c.e.a.d.w.getInstance().putString("selectProjectKey", projectVo.getProjectKey());
        }
    }

    public void updateCityTv(TextView textView, String str) {
        textView.setText(c.e.a.d.x.getNotNullStr(str, c.e.a.d.x.getString(R.string.title_sz)));
        if (c.e.a.d.x.isNotNull(str)) {
            str.length();
        }
    }
}
