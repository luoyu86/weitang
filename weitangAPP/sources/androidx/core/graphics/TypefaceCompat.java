package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompat {
    private static final String TAG = "TypefaceCompat";
    private static final LruCache<String, Typeface> sTypefaceCache;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (i2 >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else if (i2 >= 24 && TypefaceCompatApi24Impl.isUsable()) {
            sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
        } else if (i2 >= 21) {
            sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
        } else {
            sTypefaceCompatImpl = new TypefaceCompatBaseImpl();
        }
        sTypefaceCache = new LruCache<>(16);
    }

    private TypefaceCompat() {
    }

    @Nullable
    public static Typeface createFromFontInfo(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i2);
    }

    @Nullable
    public static Typeface createFromResourcesFamilyXml(@NonNull Context context, @NonNull FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, @NonNull Resources resources, int i2, int i3, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        Typeface typefaceCreateFromFontFamilyFilesResourceEntry;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            boolean z2 = false;
            if (!z ? fontCallback == null : providerResourceEntry.getFetchStrategy() == 0) {
                z2 = true;
            }
            typefaceCreateFromFontFamilyFilesResourceEntry = FontsContractCompat.getFontSync(context, providerResourceEntry.getRequest(), fontCallback, handler, z2, z ? providerResourceEntry.getTimeout() : -1, i3);
        } else {
            typefaceCreateFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i3);
            if (fontCallback != null) {
                if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
                    fontCallback.callbackSuccessAsync(typefaceCreateFromFontFamilyFilesResourceEntry, handler);
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
            sTypefaceCache.put(createResourceUid(resources, i2, i3), typefaceCreateFromFontFamilyFilesResourceEntry);
        }
        return typefaceCreateFromFontFamilyFilesResourceEntry;
    }

    @Nullable
    public static Typeface createFromResourcesFontFile(@NonNull Context context, @NonNull Resources resources, int i2, String str, int i3) {
        Typeface typefaceCreateFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i2, str, i3);
        if (typefaceCreateFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources, i2, i3), typefaceCreateFromResourcesFontFile);
        }
        return typefaceCreateFromResourcesFontFile;
    }

    private static String createResourceUid(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
    }

    @Nullable
    public static Typeface findFromCache(@NonNull Resources resources, int i2, int i3) {
        return sTypefaceCache.get(createResourceUid(resources, i2, i3));
    }
}
