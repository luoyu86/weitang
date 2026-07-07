package com.chinavisionary.microtang.community.vo;

import androidx.annotation.NonNull;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CommunityGuideVo extends BaseVo implements Cloneable {
    private int commentCount;
    private boolean isTopSticky;
    private Long publishTime;
    private String publisher;
    private String subtitle;
    private String title;
    private String topSticky;

    public int getCommentCount() {
        return this.commentCount;
    }

    public Long getPublishTime() {
        return this.publishTime;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopSticky() {
        return this.topSticky;
    }

    public boolean isTopSticky() {
        return this.isTopSticky;
    }

    public void setCommentCount(int i2) {
        this.commentCount = i2;
    }

    public void setPublishTime(Long l) {
        this.publishTime = l;
    }

    public void setPublisher(String str) {
        this.publisher = str;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTopSticky(String str) {
        this.topSticky = str;
    }

    @Override // 
    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CommunityGuideVo mo71clone() {
        CommunityGuideVo communityGuideVo;
        CloneNotSupportedException e2;
        try {
            communityGuideVo = (CommunityGuideVo) super.clone();
        } catch (CloneNotSupportedException e3) {
            communityGuideVo = null;
            e2 = e3;
        }
        try {
            communityGuideVo.title = this.title;
            communityGuideVo.isTopSticky = this.isTopSticky;
        } catch (CloneNotSupportedException e4) {
            e2 = e4;
            e2.printStackTrace();
        }
        return communityGuideVo;
    }

    public void setTopSticky(boolean z) {
        this.isTopSticky = z;
    }
}
