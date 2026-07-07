package com.chinavisionary.core.photo.photopicker.utils;

import android.content.Context;
import android.provider.MediaStore;
import androidx.loader.content.CursorLoader;

/* JADX INFO: loaded from: classes.dex */
public class PhotoDirectoryLoader extends CursorLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f6610a;

    public PhotoDirectoryLoader(Context context, boolean z) {
        super(context);
        String[] strArr = {"_id", "_data", "bucket_id", "bucket_display_name", "date_added"};
        this.f6610a = strArr;
        setProjection(strArr);
        setUri(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        setSortOrder("date_added DESC");
        StringBuilder sb = new StringBuilder();
        sb.append("mime_type=? or mime_type=? or mime_type=? ");
        sb.append(z ? "or mime_type=?" : "");
        setSelection(sb.toString());
        setSelectionArgs(z ? new String[]{"image/jpeg", "image/png", "image/jpg", "image/gif"} : new String[]{"image/jpeg", "image/png", "image/jpg"});
    }
}
