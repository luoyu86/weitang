package com.bytedance.pangle.res;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.j;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PluginResources extends Resources {
    public String pluginPkg;

    public PluginResources(Resources resources, String str) {
        super(appendHostRes(resources), resources.getDisplayMetrics(), Zeus.getAppApplication().getResources().getConfiguration());
        this.pluginPkg = str;
    }

    public static AssetManager appendHostRes(Resources resources) {
        String strA = g.a(Zeus.getAppApplication());
        String strB = g.b(Zeus.getAppApplication());
        List<String> listB = j.b();
        a aVar = new a();
        AssetManager assets = resources.getAssets();
        AssetManager assets2 = Zeus.getAppApplication().getAssets();
        HashSet hashSet = new HashSet(j.a(assets));
        List<String> listA = j.a(assets2);
        for (String str : listB) {
            if (!hashSet.contains(str)) {
                assets = aVar.a(assets, str, true);
            }
        }
        for (String str2 : listA) {
            if (!isOtherPlugin(str2, strA, strB) && !hashSet.contains(str2) && !listB.contains(str2)) {
                assets = aVar.a(assets, str2, false);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_RESOURCES, "pluginAssets = " + j.b(assets));
        return assets;
    }

    private Resources.NotFoundException handleException(Resources.NotFoundException notFoundException) {
        return new Resources.NotFoundException(("Resources#Assets: " + j.b(getAssets())) + "," + notFoundException.getMessage());
    }

    private static boolean isOtherPlugin(String str, String str2, String str3) {
        String packageResourcePath = Zeus.getAppApplication().getPackageResourcePath();
        if (!TextUtils.isEmpty(str3)) {
            packageResourcePath = packageResourcePath.replaceFirst(str2, str3);
            str = str.replaceFirst(str2, str3);
        }
        ZeusLogger.d(ZeusLogger.TAG_RESOURCES, str + " " + packageResourcePath + " " + str2 + " " + str3);
        if (TextUtils.equals(str, packageResourcePath) || str.contains("/tinker/patch-")) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || !str.contains(str2)) {
            return !TextUtils.isEmpty(str3) && str.contains(str3);
        }
        return true;
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getAnimation(int i2) {
        try {
            return super.getAnimation(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i2) {
        try {
            return super.getBoolean(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) {
        try {
            return super.getColor(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i2) {
        try {
            return super.getColorStateList(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public float getDimension(int i2) {
        try {
            return super.getDimension(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i2) {
        try {
            return super.getDimensionPixelOffset(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i2) {
        try {
            return super.getDimensionPixelSize(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) {
        try {
            return super.getDrawable(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i2, int i3) {
        try {
            return super.getDrawableForDensity(i2, i3);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public float getFloat(int i2) {
        try {
            return super.getFloat(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public Typeface getFont(int i2) {
        try {
            return super.getFont(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public float getFraction(int i2, int i3, int i4) {
        try {
            return super.getFraction(i2, i3, i4);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public int[] getIntArray(int i2) {
        try {
            return super.getIntArray(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public int getInteger(int i2) {
        try {
            return super.getInteger(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getLayout(int i2) {
        try {
            return super.getLayout(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i2) {
        try {
            return super.getMovie(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getQuantityString(int i2, int i3, Object... objArr) {
        try {
            return super.getQuantityString(i2, i3, objArr);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence getQuantityText(int i2, int i3) {
        try {
            return super.getQuantityText(i2, i3);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i2) {
        try {
            return super.getResourceEntryName(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i2) {
        try {
            return super.getResourceName(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i2) {
        try {
            return super.getResourcePackageName(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i2) {
        try {
            return super.getResourceTypeName(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getString(int i2) {
        try {
            return super.getString(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String[] getStringArray(int i2) {
        try {
            return super.getStringArray(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence getText(int i2) {
        try {
            return super.getText(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence[] getTextArray(int i2) {
        try {
            return super.getTextArray(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z) {
        try {
            super.getValue(i2, typedValue, z);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) {
        try {
            super.getValueForDensity(i2, i3, typedValue, z);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getXml(int i2) {
        try {
            return super.getXml(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public TypedArray obtainTypedArray(int i2) {
        try {
            return super.obtainTypedArray(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public InputStream openRawResource(int i2) {
        try {
            return super.openRawResource(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i2) {
        try {
            return super.openRawResourceFd(i2);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i2, @Nullable Resources.Theme theme) {
        try {
            return super.getColor(i2, theme);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i2, @Nullable Resources.Theme theme) {
        try {
            return super.getColorStateList(i2, theme);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2, @Nullable Resources.Theme theme) {
        try {
            return super.getDrawable(i2, theme);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i2, int i3, @Nullable Resources.Theme theme) {
        try {
            return super.getDrawableForDensity(i2, i3, theme);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getQuantityString(int i2, int i3) {
        try {
            return super.getQuantityString(i2, i3);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getString(int i2, Object... objArr) {
        try {
            return super.getString(i2, objArr);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2, CharSequence charSequence) {
        try {
            return super.getText(i2, charSequence);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) {
        try {
            super.getValue(str, typedValue, z);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public InputStream openRawResource(int i2, TypedValue typedValue) {
        try {
            return super.openRawResource(i2, typedValue);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }
}
