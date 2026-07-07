package com.chinavisionary.core.app.mail;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MailBo extends BaseVo {
    private String mailServerHost = "";
    private String mailServerPort = "";
    private String fromAddress = "";
    private String password = "";
    private ArrayList<String> toAddress = new ArrayList<>();
    private ArrayList<String> ccAddress = new ArrayList<>();
    private ArrayList<String> bccAddress = new ArrayList<>();
    private String subject = "";
    private String content = "";
    private ArrayList<File> attachFiles = new ArrayList<>();
    private Boolean openSSL = Boolean.FALSE;
    private String sslFactory = "javax.net.ssl.SSLSocketFactory";

    public ArrayList<File> getAttachFiles() {
        return this.attachFiles;
    }

    public ArrayList<String> getBccAddress() {
        return this.bccAddress;
    }

    public ArrayList<String> getCcAddress() {
        return this.ccAddress;
    }

    public String getContent() {
        return this.content;
    }

    public String getFromAddress() {
        return this.fromAddress;
    }

    public String getMailServerHost() {
        return this.mailServerHost;
    }

    public String getMailServerPort() {
        return this.mailServerPort;
    }

    public Boolean getOpenSSL() {
        return this.openSSL;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSslFactory() {
        return this.sslFactory;
    }

    public String getSubject() {
        return this.subject;
    }

    public ArrayList<String> getToAddress() {
        return this.toAddress;
    }

    public void setAttachFiles(ArrayList<File> arrayList) {
        this.attachFiles = arrayList;
    }

    public void setBccAddress(ArrayList<String> arrayList) {
        this.bccAddress = arrayList;
    }

    public void setCcAddress(ArrayList<String> arrayList) {
        this.ccAddress = arrayList;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFromAddress(String str) {
        this.fromAddress = str;
    }

    public void setMailServerHost(String str) {
        this.mailServerHost = str;
    }

    public void setMailServerPort(String str) {
        this.mailServerPort = str;
    }

    public void setOpenSSL(Boolean bool) {
        this.openSSL = bool;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSslFactory(String str) {
        this.sslFactory = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setToAddress(ArrayList<String> arrayList) {
        this.toAddress = arrayList;
    }
}
