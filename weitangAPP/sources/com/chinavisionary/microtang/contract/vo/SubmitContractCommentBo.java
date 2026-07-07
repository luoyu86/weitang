package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.contract.vo.ContractCommentVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SubmitContractCommentBo extends BaseVo {
    private String commentContent;
    private List<ContractCommentVo.CommentItemsBean> commentItems;
    private String contractKey;
    private List<String> enclosureKeys;
    private List<String> tagKeys;

    public String getCommentContent() {
        return this.commentContent;
    }

    public List<ContractCommentVo.CommentItemsBean> getCommentItems() {
        return this.commentItems;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public List<String> getEnclosureKeys() {
        return this.enclosureKeys;
    }

    public List<String> getTagKeys() {
        return this.tagKeys;
    }

    public void setCommentContent(String str) {
        this.commentContent = str;
    }

    public void setCommentItems(List<ContractCommentVo.CommentItemsBean> list) {
        this.commentItems = list;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setEnclosureKeys(List<String> list) {
        this.enclosureKeys = list;
    }

    public void setTagKeys(List<String> list) {
        this.tagKeys = list;
    }
}
