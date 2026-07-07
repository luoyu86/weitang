package com.chinavisionary.microtang.main.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NavigationVo extends BaseVo {
    private String time;
    private List<a> trafficList;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7369b;

        public String getName() {
            return this.f7369b;
        }

        public int getType() {
            return this.f7368a;
        }

        public void setName(String str) {
            this.f7369b = str;
        }

        public void setType(int i2) {
            this.f7368a = i2;
        }
    }

    public String getTime() {
        return this.time;
    }

    public List<a> getTrafficList() {
        return this.trafficList;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setTrafficList(List<a> list) {
        this.trafficList = list;
    }
}
