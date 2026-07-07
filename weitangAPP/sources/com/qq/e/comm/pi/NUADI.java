package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface NUADI {
    String getAdNetWorkName();

    void loadData(int i2);

    void loadData(int i2, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i2);

    void setMinVideoDuration(int i2);

    void setVastClassName(String str);
}
