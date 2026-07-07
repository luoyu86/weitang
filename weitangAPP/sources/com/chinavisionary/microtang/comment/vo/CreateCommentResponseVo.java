package com.chinavisionary.microtang.comment.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CreateCommentResponseVo extends NewBaseVo {
    private List<KeyValueVo> address;
    private String commentBannerText;
    private int commentType;
    private String commentTypeName;
    private String rentCommentKey;
    private List<ScoresBean> scores = new ArrayList();

    public List<KeyValueVo> getAddress() {
        return this.address;
    }

    public String getCommentBannerText() {
        return this.commentBannerText;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public String getCommentTypeName() {
        return this.commentTypeName;
    }

    public String getRentCommentKey() {
        return this.rentCommentKey;
    }

    public List<ScoresBean> getScores() {
        return this.scores;
    }

    public void setAddress(List<KeyValueVo> list) {
        this.address = list;
    }

    public void setCommentBannerText(String str) {
        this.commentBannerText = str;
    }

    public void setCommentType(int i2) {
        this.commentType = i2;
    }

    public void setCommentTypeName(String str) {
        this.commentTypeName = str;
    }

    public void setRentCommentKey(String str) {
        this.rentCommentKey = str;
    }

    public void setScores(List<ScoresBean> list) {
        this.scores = list;
    }
}
