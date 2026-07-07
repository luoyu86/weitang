package com.alibaba.sdk.android.oss;

import anet.channel.util.HttpConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ClientConfiguration {
    private static final int DEFAULT_MAX_RETRIES = 2;
    private String ipWithHeader;
    private String mUserAgentMark;
    private String proxyHost;
    private int proxyPort;
    private int maxConcurrentRequest = 5;
    private int socketTimeout = 60000;
    private int connectionTimeout = 60000;
    private long max_log_size = 5242880;
    private int maxErrorRetry = 2;
    private List<String> customCnameExcludeList = new ArrayList();
    private boolean httpDnsEnable = true;
    private boolean checkCRC64 = false;

    public static ClientConfiguration getDefaultConf() {
        return new ClientConfiguration();
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public List<String> getCustomCnameExcludeList() {
        return Collections.unmodifiableList(this.customCnameExcludeList);
    }

    public String getCustomUserMark() {
        return this.mUserAgentMark;
    }

    public String getIpWithHeader() {
        return this.ipWithHeader;
    }

    public int getMaxConcurrentRequest() {
        return this.maxConcurrentRequest;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public long getMaxLogSize() {
        return this.max_log_size;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public boolean isCheckCRC64() {
        return this.checkCRC64;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public void setCheckCRC64(boolean z) {
        this.checkCRC64 = z;
    }

    public void setConnectionTimeout(int i2) {
        this.connectionTimeout = i2;
    }

    public void setCustomCnameExcludeList(List<String> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("cname exclude list should not be null.");
        }
        this.customCnameExcludeList.clear();
        for (String str : list) {
            if (str.contains(HttpConstant.SCHEME_SPLIT)) {
                this.customCnameExcludeList.add(str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3));
            } else {
                this.customCnameExcludeList.add(str);
            }
        }
    }

    public void setHttpDnsEnable(boolean z) {
        this.httpDnsEnable = z;
    }

    public void setIpWithHeader(String str) {
        this.ipWithHeader = str;
    }

    public void setMaxConcurrentRequest(int i2) {
        this.maxConcurrentRequest = i2;
    }

    public void setMaxErrorRetry(int i2) {
        this.maxErrorRetry = i2;
    }

    public void setMaxLogSize(long j) {
        this.max_log_size = j;
    }

    public void setProxyHost(String str) {
        this.proxyHost = str;
    }

    public void setProxyPort(int i2) {
        this.proxyPort = i2;
    }

    public void setSocketTimeout(int i2) {
        this.socketTimeout = i2;
    }

    public void setUserAgentMark(String str) {
        this.mUserAgentMark = str;
    }
}
