package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.main.vo.ModelBannerVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RoomModelVo extends BaseVo {
    private List<DatasBean> datas;
    private int icon;
    private String key;
    private String message;
    private List<ModulesBean> modules;
    private String name;
    private String pageKey;
    private int state;
    private String stateName;
    private boolean success;

    public static class DatasBean extends BaseVo {
        private String dataKey;
        private String dataParam;
        private String dataTitle;
        private int dataType;
        private String dataTypeName;
        private String moduleKey;
        private int showIndex;

        public String getDataKey() {
            return this.dataKey;
        }

        public String getDataParam() {
            return this.dataParam;
        }

        public String getDataTitle() {
            return this.dataTitle;
        }

        public int getDataType() {
            return this.dataType;
        }

        public String getDataTypeName() {
            return this.dataTypeName;
        }

        public String getModuleKey() {
            return this.moduleKey;
        }

        public int getShowIndex() {
            return this.showIndex;
        }

        public void setDataKey(String str) {
            this.dataKey = str;
        }

        public void setDataParam(String str) {
            this.dataParam = str;
        }

        public void setDataTitle(String str) {
            this.dataTitle = str;
        }

        public void setDataType(int i2) {
            this.dataType = i2;
        }

        public void setDataTypeName(String str) {
            this.dataTypeName = str;
        }

        public void setModuleKey(String str) {
            this.moduleKey = str;
        }

        public void setShowIndex(int i2) {
            this.showIndex = i2;
        }
    }

    public static class ModulesBean extends BaseVo implements Cloneable {
        public static final int BANNER_TYPE = 1;
        public static final int CONTENT_TYPE = 3;
        public static final int TITLE_TYPE = 2;
        private String businessCode;
        private String businessType;
        private String dataKey;
        private List<DatasBean> dataList;
        private String dataParam;
        private int direction;
        private String directionName;
        private boolean hasLink;
        private String linkDataPrimaryKey;
        private List<EditBannerView.BannerDto> mBannerDtoList;
        private MerchantInfoVo mMerchantInfoVo;
        private List<ModelBannerVo> modelBannerVos;
        private ModelProductVo modelProductVo;
        private int moduleIcon;
        private String moduleKey;
        private String moduleSubtitle;
        private String moduleTitle;
        private int moduleType;
        private String moduleTypeName;
        private long showIndex;
        private int state;
        private String stateName;
        private List<ModulesBean> subModules;

        public ModulesBean() {
        }

        private List<EditBannerView.BannerDto> modelBannerVoToBannerDto(List<ModelBannerVo> list) {
            ModelBannerVo.ParamBean param;
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (ModelBannerVo modelBannerVo : list) {
                    if (modelBannerVo != null && (param = modelBannerVo.getParam()) != null) {
                        EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
                        bannerDto.setBaseKey(param.getBaseKey());
                        bannerDto.setDataKey(param.getHref());
                        bannerDto.setCover(param.getResourceVo());
                        bannerDto.setKey(param.getHref());
                        bannerDto.setDataType(modelBannerVo.getType());
                        bannerDto.setTitle(param.getTitle());
                        bannerDto.setTargetAppid(param.getTargetAppid());
                        bannerDto.setTargetMiniType(param.getTargetMiniType());
                        bannerDto.setTargetPath(param.getTargetPath());
                        arrayList.add(bannerDto);
                    }
                }
            }
            return arrayList;
        }

        public List<EditBannerView.BannerDto> getBannerDtoList() {
            return this.mBannerDtoList;
        }

        public String getBusinessCode() {
            return this.businessCode;
        }

        public String getBusinessType() {
            return this.businessType;
        }

        public String getDataKey() {
            return this.dataKey;
        }

        public List<DatasBean> getDataList() {
            return this.dataList;
        }

        public String getDataParam() {
            return this.dataParam;
        }

        public int getDirection() {
            return this.direction;
        }

        public String getDirectionName() {
            return this.directionName;
        }

        public String getLinkDataPrimaryKey() {
            return this.linkDataPrimaryKey;
        }

        public MerchantInfoVo getMerchantInfoVo() {
            return this.mMerchantInfoVo;
        }

        public List<ModelBannerVo> getModelBannerVos() {
            return this.modelBannerVos;
        }

        public ModelProductVo getModelProductVo() {
            return this.modelProductVo;
        }

        public int getModuleIcon() {
            return this.moduleIcon;
        }

        public String getModuleKey() {
            return this.moduleKey;
        }

        public String getModuleSubtitle() {
            return this.moduleSubtitle;
        }

        public String getModuleTitle() {
            return this.moduleTitle;
        }

        public int getModuleType() {
            return this.moduleType;
        }

        public String getModuleTypeName() {
            return this.moduleTypeName;
        }

        public long getShowIndex() {
            return this.showIndex;
        }

        public int getState() {
            return this.state;
        }

        public String getStateName() {
            return this.stateName;
        }

        public List<ModulesBean> getSubModules() {
            return this.subModules;
        }

        public boolean isHasLink() {
            return this.hasLink;
        }

        public void setBannerDtoList(List<EditBannerView.BannerDto> list) {
            this.mBannerDtoList = list;
        }

        public void setBusinessCode(String str) {
            this.businessCode = str;
        }

        public void setBusinessType(String str) {
            this.businessType = str;
        }

        public void setDataKey(String str) {
            this.dataKey = str;
        }

        public void setDataList(List<DatasBean> list) {
            this.dataList = list;
        }

        public void setDataParam(String str) {
            this.dataParam = str;
        }

        public void setDirection(int i2) {
            this.direction = i2;
        }

        public void setDirectionName(String str) {
            this.directionName = str;
        }

        public void setHasLink(boolean z) {
            this.hasLink = z;
        }

        public void setLinkDataPrimaryKey(String str) {
            this.linkDataPrimaryKey = str;
        }

        public void setMerchantInfoVo(MerchantInfoVo merchantInfoVo) {
            this.mMerchantInfoVo = merchantInfoVo;
        }

        public void setModelBannerVos(List<ModelBannerVo> list) {
            this.modelBannerVos = list;
            this.mBannerDtoList = modelBannerVoToBannerDto(list);
        }

        public void setModelProductVo(ModelProductVo modelProductVo) {
            this.modelProductVo = modelProductVo;
        }

        public void setModuleIcon(int i2) {
            this.moduleIcon = i2;
        }

        public void setModuleKey(String str) {
            this.moduleKey = str;
        }

        public void setModuleSubtitle(String str) {
            this.moduleSubtitle = str;
        }

        public void setModuleTitle(String str) {
            this.moduleTitle = str;
        }

        public void setModuleType(int i2) {
            this.moduleType = i2;
        }

        public void setModuleTypeName(String str) {
            this.moduleTypeName = str;
        }

        public void setShowIndex(long j) {
            this.showIndex = j;
        }

        public void setState(int i2) {
            this.state = i2;
        }

        public void setStateName(String str) {
            this.stateName = str;
        }

        public void setSubModules(List<ModulesBean> list) {
            this.subModules = list;
        }

        public ModulesBean(ModulesBean modulesBean) {
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public ModulesBean m74clone() {
            try {
                return (ModulesBean) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public List<DatasBean> getDatas() {
        return this.datas;
    }

    public int getIcon() {
        return this.icon;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public List<ModulesBean> getModules() {
        return this.modules;
    }

    public String getName() {
        return this.name;
    }

    public String getPageKey() {
        return this.pageKey;
    }

    public int getState() {
        return this.state;
    }

    public String getStateName() {
        return this.stateName;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setDatas(List<DatasBean> list) {
        this.datas = list;
    }

    public void setIcon(int i2) {
        this.icon = i2;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setModules(List<ModulesBean> list) {
        this.modules = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPageKey(String str) {
        this.pageKey = str;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
