package a.a;

import anet.channel.request.BodyEntry;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface k {
    void addHeader(String str, String str2);

    String getBizId();

    BodyEntry getBodyEntry();

    @Deprecated
    b getBodyHandler();

    String getCharset();

    int getConnectTimeout();

    Map<String, String> getExtProperties();

    String getExtProperty(String str);

    boolean getFollowRedirects();

    List<a> getHeaders();

    a[] getHeaders(String str);

    String getMethod();

    List<j> getParams();

    int getReadTimeout();

    int getRetryTime();

    String getSeqNo();

    @Deprecated
    URI getURI();

    @Deprecated
    URL getURL();

    String getUrlString();

    @Deprecated
    boolean isCookieEnabled();

    void removeHeader(a aVar);

    @Deprecated
    void setBizId(int i2);

    void setBizId(String str);

    void setBodyEntry(BodyEntry bodyEntry);

    @Deprecated
    void setBodyHandler(b bVar);

    void setCharset(String str);

    void setConnectTimeout(int i2);

    @Deprecated
    void setCookieEnabled(boolean z);

    void setExtProperty(String str, String str2);

    void setFollowRedirects(boolean z);

    void setHeader(a aVar);

    void setHeaders(List<a> list);

    void setMethod(String str);

    void setParams(List<j> list);

    void setReadTimeout(int i2);

    void setRetryTime(int i2);

    void setSeqNo(String str);

    @Deprecated
    void setUri(URI uri);
}
