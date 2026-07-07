package com.chinavisionary.microtang.comment.vo;

import c.e.a.d.o;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommentDetailsVo extends NewBaseVo {
    private List<KeyValueVo> address;
    private boolean comment;
    private int commentType;
    private String commentTypeName;
    private String content;
    private List<String> imageUrls;
    private boolean isComment;
    private String rentCommentKey;
    private List<ResourceVo> resources;
    private List<CommentDetailsScoreVo> scores;

    private List<ResourceVo> getImageResUrls() {
        List<String> list = this.imageUrls;
        if (list == null || !o.isNotEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.imageUrls) {
            ResourceVo resourceVo = new ResourceVo();
            resourceVo.setSampleUrl(str);
            resourceVo.setKey("232323");
            resourceVo.setUrl(str);
            arrayList.add(resourceVo);
        }
        return arrayList;
    }

    public List<KeyValueVo> getAddress() {
        return this.address;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public String getCommentTypeName() {
        return this.commentTypeName;
    }

    public String getContent() {
        return this.content;
    }

    public List<String> getImageUrls() {
        return this.imageUrls;
    }

    public String getRentCommentKey() {
        return this.rentCommentKey;
    }

    public List<ResourceVo> getResources() {
        List<String> list = this.imageUrls;
        if (list == null || !o.isNotEmpty(list)) {
            return this.resources;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.imageUrls) {
            ResourceVo resourceVo = new ResourceVo();
            resourceVo.setSampleUrl(str);
            resourceVo.setKey("232323");
            resourceVo.setUrl(str);
            arrayList.add(resourceVo);
        }
        return arrayList;
    }

    public List<CommentDetailsScoreVo> getScores() {
        return this.scores;
    }

    public boolean isComment() {
        return this.comment;
    }

    public boolean isIsComment() {
        return this.isComment;
    }

    public void setAddress(List<KeyValueVo> list) {
        this.address = list;
    }

    public void setComment(boolean z) {
        this.comment = z;
    }

    public void setCommentType(int i2) {
        this.commentType = i2;
    }

    public void setCommentTypeName(String str) {
        this.commentTypeName = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setImageUrls(List<String> list) {
        this.imageUrls = list;
    }

    public void setIsComment(boolean z) {
        this.isComment = z;
    }

    public void setRentCommentKey(String str) {
        this.rentCommentKey = str;
    }

    public void setResources(List<ResourceVo> list) {
        this.resources = list;
    }

    public void setScores(List<CommentDetailsScoreVo> list) {
        this.scores = list;
    }
}
