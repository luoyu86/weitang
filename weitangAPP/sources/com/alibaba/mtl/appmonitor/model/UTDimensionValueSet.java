package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class UTDimensionValueSet extends DimensionValueSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<LogField> f4517a = new HashSet<LogField>() { // from class: com.alibaba.mtl.appmonitor.model.UTDimensionValueSet.1
        {
            add(LogField.PAGE);
            add(LogField.ARG1);
            add(LogField.ARG2);
            add(LogField.ARG3);
            add(LogField.ARGS);
        }
    };

    public static UTDimensionValueSet create(Map<String, String> map) {
        return (UTDimensionValueSet) a.a().a(UTDimensionValueSet.class, map);
    }

    @Override // com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        super.clean();
    }

    @Override // com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        super.fill(objArr);
    }

    public Integer getEventId() {
        int iA;
        String str;
        Map<String, String> map = this.map;
        if (map == null || (str = map.get(LogField.EVENTID.toString())) == null) {
            iA = 0;
        } else {
            try {
                iA = com.alibaba.mtl.appmonitor.f.a.a(str);
            } catch (NumberFormatException unused) {
                iA = 0;
            }
        }
        return Integer.valueOf(iA);
    }
}
