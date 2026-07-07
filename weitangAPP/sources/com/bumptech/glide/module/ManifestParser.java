package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    private static GlideModule parseModule(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object objNewInstance = cls.newInstance();
                if (objNewInstance instanceof GlideModule) {
                    return (GlideModule) objNewInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e4);
        }
    }

    public List<GlideModule> parse() {
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if (GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(parseModule(str));
                    }
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }
}
