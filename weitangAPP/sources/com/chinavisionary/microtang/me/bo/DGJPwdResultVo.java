package com.chinavisionary.microtang.me.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DGJPwdResultVo extends BaseVo {
    private List<DataBean> data;
    private String msg;
    private int ret;

    public static class DataBean extends BaseVo {
        private String dbname_company;
        private int dev_id;
        private String dev_mac;
        private String dev_sn;
        private int door_no;
        private List<ReaderBean> reader;
        private String show_name;

        public static class ReaderBean extends BaseVo {
            private int battery_state;
            private String cardno;
            private int dev_type;
            private String dev_type_name;
            private int door_no;
            private String ekey;
            private int encryption;
            private String end_date;
            private String function;
            private int network;
            private String open_pwd;
            private int open_type;
            private int privilege;
            private String reader_mac;
            private String reader_sn;
            private int section;
            private String sectionkey;
            private String start_date;
            private int start_floor;
            private int use_count;
            private int verified;
            private String wxapp_ekey;

            public int getBattery_state() {
                return this.battery_state;
            }

            public String getCardno() {
                return this.cardno;
            }

            public int getDev_type() {
                return this.dev_type;
            }

            public String getDev_type_name() {
                return this.dev_type_name;
            }

            public int getDoor_no() {
                return this.door_no;
            }

            public String getEkey() {
                return this.ekey;
            }

            public int getEncryption() {
                return this.encryption;
            }

            public String getEnd_date() {
                return this.end_date;
            }

            public String getFunction() {
                return this.function;
            }

            public int getNetwork() {
                return this.network;
            }

            public String getOpen_pwd() {
                return this.open_pwd;
            }

            public int getOpen_type() {
                return this.open_type;
            }

            public int getPrivilege() {
                return this.privilege;
            }

            public String getReader_mac() {
                return this.reader_mac;
            }

            public String getReader_sn() {
                return this.reader_sn;
            }

            public int getSection() {
                return this.section;
            }

            public String getSectionkey() {
                return this.sectionkey;
            }

            public String getStart_date() {
                return this.start_date;
            }

            public int getStart_floor() {
                return this.start_floor;
            }

            public int getUse_count() {
                return this.use_count;
            }

            public int getVerified() {
                return this.verified;
            }

            public String getWxapp_ekey() {
                return this.wxapp_ekey;
            }

            public void setBattery_state(int i2) {
                this.battery_state = i2;
            }

            public void setCardno(String str) {
                this.cardno = str;
            }

            public void setDev_type(int i2) {
                this.dev_type = i2;
            }

            public void setDev_type_name(String str) {
                this.dev_type_name = str;
            }

            public void setDoor_no(int i2) {
                this.door_no = i2;
            }

            public void setEkey(String str) {
                this.ekey = str;
            }

            public void setEncryption(int i2) {
                this.encryption = i2;
            }

            public void setEnd_date(String str) {
                this.end_date = str;
            }

            public void setFunction(String str) {
                this.function = str;
            }

            public void setNetwork(int i2) {
                this.network = i2;
            }

            public void setOpen_pwd(String str) {
                this.open_pwd = str;
            }

            public void setOpen_type(int i2) {
                this.open_type = i2;
            }

            public void setPrivilege(int i2) {
                this.privilege = i2;
            }

            public void setReader_mac(String str) {
                this.reader_mac = str;
            }

            public void setReader_sn(String str) {
                this.reader_sn = str;
            }

            public void setSection(int i2) {
                this.section = i2;
            }

            public void setSectionkey(String str) {
                this.sectionkey = str;
            }

            public void setStart_date(String str) {
                this.start_date = str;
            }

            public void setStart_floor(int i2) {
                this.start_floor = i2;
            }

            public void setUse_count(int i2) {
                this.use_count = i2;
            }

            public void setVerified(int i2) {
                this.verified = i2;
            }

            public void setWxapp_ekey(String str) {
                this.wxapp_ekey = str;
            }
        }

        public String getDbname_company() {
            return this.dbname_company;
        }

        public int getDev_id() {
            return this.dev_id;
        }

        public String getDev_mac() {
            return this.dev_mac;
        }

        public String getDev_sn() {
            return this.dev_sn;
        }

        public int getDoor_no() {
            return this.door_no;
        }

        public List<ReaderBean> getReader() {
            return this.reader;
        }

        public String getShow_name() {
            return this.show_name;
        }

        public void setDbname_company(String str) {
            this.dbname_company = str;
        }

        public void setDev_id(int i2) {
            this.dev_id = i2;
        }

        public void setDev_mac(String str) {
            this.dev_mac = str;
        }

        public void setDev_sn(String str) {
            this.dev_sn = str;
        }

        public void setDoor_no(int i2) {
            this.door_no = i2;
        }

        public void setReader(List<ReaderBean> list) {
            this.reader = list;
        }

        public void setShow_name(String str) {
            this.show_name = str;
        }
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getRet() {
        return this.ret;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRet(int i2) {
        this.ret = i2;
    }
}
