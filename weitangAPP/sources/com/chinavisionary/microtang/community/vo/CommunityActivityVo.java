package com.chinavisionary.microtang.community.vo;

import androidx.annotation.NonNull;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityVo extends CommunityGuideVo implements Cloneable {
    private ResourceVo coverResource;

    public ResourceVo getCoverResource() {
        return this.coverResource;
    }

    public void setCoverResource(ResourceVo resourceVo) {
        this.coverResource = resourceVo;
    }

    @Override // com.chinavisionary.microtang.community.vo.CommunityGuideVo
    @NonNull
    /* JADX INFO: renamed from: clone */
    public CommunityActivityVo mo71clone() {
        CommunityActivityVo communityActivityVo = (CommunityActivityVo) super.mo71clone();
        communityActivityVo.coverResource = this.coverResource.m69clone();
        return communityActivityVo;
    }
}
