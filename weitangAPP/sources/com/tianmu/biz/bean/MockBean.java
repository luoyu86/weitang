package com.tianmu.biz.bean;

/* JADX INFO: loaded from: classes2.dex */
public class MockBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Header f10830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MockData f10831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MockLog f10832c;

    public static class Header {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f10833a;

        public boolean isxTmSt() {
            return this.f10833a;
        }

        public void setxTmSt(boolean z) {
            this.f10833a = z;
        }
    }

    public static class MockData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f10834a;

        public boolean isAd() {
            return this.f10834a;
        }

        public void setAd(boolean z) {
            this.f10834a = z;
        }
    }

    public static class MockLog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f10835a;

        public boolean isShowImportantLog() {
            return this.f10835a;
        }

        public void setShowImportantLog(boolean z) {
            this.f10835a = z;
        }
    }

    public Header getHeader() {
        return this.f10830a;
    }

    public MockLog getLog() {
        return this.f10832c;
    }

    public MockData getMockData() {
        return this.f10831b;
    }

    public void setHeader(Header header) {
        this.f10830a = header;
    }

    public void setLog(MockLog mockLog) {
        this.f10832c = mockLog;
    }

    public void setMockData(MockData mockData) {
        this.f10831b = mockData;
    }
}
