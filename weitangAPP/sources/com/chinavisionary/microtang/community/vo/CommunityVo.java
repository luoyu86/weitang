package com.chinavisionary.microtang.community.vo;

import androidx.annotation.NonNull;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.main.vo.ModelBannerVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommunityVo extends BaseVo implements Cloneable {
    private CommunityActivityVo communityActivityVo;
    private CommunityCommentVo communityCommentVo;
    private CommunityGuideVo communityGuideVo;
    private List<ModelBannerVo> dataList;
    private int viewType;

    public CommunityActivityVo getCommunityActivityVo() {
        return this.communityActivityVo;
    }

    public CommunityCommentVo getCommunityCommentVo() {
        return this.communityCommentVo;
    }

    public CommunityGuideVo getCommunityGuideVo() {
        return this.communityGuideVo;
    }

    public List<ModelBannerVo> getDataList() {
        return this.dataList;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setCommunityActivityVo(CommunityActivityVo communityActivityVo) {
        this.communityActivityVo = communityActivityVo;
    }

    public void setCommunityCommentVo(CommunityCommentVo communityCommentVo) {
        this.communityCommentVo = communityCommentVo;
    }

    public void setCommunityGuideVo(CommunityGuideVo communityGuideVo) {
        this.communityGuideVo = communityGuideVo;
    }

    public void setDataList(List<ModelBannerVo> list) {
        this.dataList = list;
    }

    public void setViewType(int i2) {
        this.viewType = i2;
    }

    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CommunityVo m73clone() {
        CommunityVo communityVo;
        CloneNotSupportedException e2;
        try {
            communityVo = (CommunityVo) super.clone();
        } catch (CloneNotSupportedException e3) {
            communityVo = null;
            e2 = e3;
        }
        try {
            communityVo.viewType = ((CommunityVo) super.clone()).viewType;
            communityVo.communityGuideVo = ((CommunityVo) super.clone()).communityGuideVo;
            communityVo.communityCommentVo = ((CommunityVo) super.clone()).communityCommentVo;
            communityVo.communityActivityVo = ((CommunityVo) super.clone()).communityActivityVo;
        } catch (CloneNotSupportedException e4) {
            e2 = e4;
            e2.printStackTrace();
        }
        return communityVo;
    }
}
