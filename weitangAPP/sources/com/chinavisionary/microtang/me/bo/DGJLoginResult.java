package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DGJLoginResult extends BaseVo {
    private DataBean data;
    private String msg;
    private int ret;

    public static class DataBean extends BaseVo {
        private int auto_upload_event;
        private String client_id;
        private a community_info;
        private List<?> dbname_server_list;
        private String full_name;
        private String identity;
        private String image_path;
        private String nickname;
        private List<?> rid;
        private String token_pwd;
        private String voip_account;
        private String voip_pwd;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<?> f7553a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List<?> f7554b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List<?> f7555c;

            public List<?> getDev_list() {
                return this.f7553a;
            }

            public List<?> getProperty_list() {
                return this.f7555c;
            }

            public List<?> getRoom_list() {
                return this.f7554b;
            }

            public void setDev_list(List<?> list) {
                this.f7553a = list;
            }

            public void setProperty_list(List<?> list) {
                this.f7555c = list;
            }

            public void setRoom_list(List<?> list) {
                this.f7554b = list;
            }
        }

        public int getAuto_upload_event() {
            return this.auto_upload_event;
        }

        public String getClient_id() {
            return this.client_id;
        }

        public a getCommunity_info() {
            return this.community_info;
        }

        public List<?> getDbname_server_list() {
            return this.dbname_server_list;
        }

        public String getFull_name() {
            return this.full_name;
        }

        public String getIdentity() {
            return this.identity;
        }

        public String getImage_path() {
            return this.image_path;
        }

        public String getNickname() {
            return this.nickname;
        }

        public List<?> getRid() {
            return this.rid;
        }

        public String getToken_pwd() {
            return this.token_pwd;
        }

        public String getVoip_account() {
            return this.voip_account;
        }

        public String getVoip_pwd() {
            return this.voip_pwd;
        }

        public void setAuto_upload_event(int i2) {
            this.auto_upload_event = i2;
        }

        public void setClient_id(String str) {
            this.client_id = str;
        }

        public void setCommunity_info(a aVar) {
            this.community_info = aVar;
        }

        public void setDbname_server_list(List<?> list) {
            this.dbname_server_list = list;
        }

        public void setFull_name(String str) {
            this.full_name = str;
        }

        public void setIdentity(String str) {
            this.identity = str;
        }

        public void setImage_path(String str) {
            this.image_path = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setRid(List<?> list) {
            this.rid = list;
        }

        public void setToken_pwd(String str) {
            this.token_pwd = str;
        }

        public void setVoip_account(String str) {
            this.voip_account = str;
        }

        public void setVoip_pwd(String str) {
            this.voip_pwd = str;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getRet() {
        return this.ret;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRet(int i2) {
        this.ret = i2;
    }
}
