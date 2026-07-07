package com.tianmu.apilib.utils;

import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.c.n.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class QuickAppLinkUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f10799a = Pattern.compile("(thefatherofsalmon|hybrid\\.vivo\\.com|hapjs\\.org|statres\\.quickapp\\.cn|hap://|hwfastapp://|fastappjump-drcn|fastapprouter|com\\.vivo\\.hybrid|rpkkuai\\.com|qallzmx\\.quicklyopen\\.com|hnquick://|hnquickapp://)");

    private static boolean a() {
        com.tianmu.c.i.i iVarD = n.D().d();
        if (iVarD != null) {
            return iVarD.j();
        }
        return false;
    }

    public static boolean isFilterQuickAppLink(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.tianmu.c.i.i iVarD = n.D().d();
        List<String> listA = iVarD != null ? a(iVarD.f()) : null;
        if (listA == null || listA.size() <= 0) {
            return f10799a.matcher(str).find();
        }
        Iterator<String> it = listA.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void reportAppLink(List<String> list) {
        if (TianmuSDK.getInstance().getContext() != null && a()) {
            com.tianmu.h.a.a(list);
        }
    }

    private static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String strOptString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
        }
        return arrayList;
    }
}
