package com.bytedance.pangle.log;

import androidx.annotation.Keep;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface IZeusReporter {
    void report(String str, JSONObject jSONObject);
}
