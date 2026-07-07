package com.tianmu.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuQuickAppLinkUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f12342a = Pattern.compile("(thefatherofsalmon|hybrid\\.vivo\\.com|hapjs\\.org|statres\\.quickapp\\.cn|hap://|hwfastapp://|fastappjump-drcn|fastapprouter|com\\.vivo\\.hybrid|rpkkuai\\.com|qallzmx\\.quicklyopen\\.com|hnquick://|hnquickapp://)");

    public static boolean isFilterQuickAppLink(String str) {
        Pattern pattern;
        if (TextUtils.isEmpty(str) || (pattern = f12342a) == null) {
            return false;
        }
        return pattern.matcher(str).find();
    }
}
