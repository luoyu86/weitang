package com.bumptech.glide;

import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface DownloadOptions {
    FutureTarget<File> downloadOnly(int i2, int i3);

    <Y extends Target<File>> Y downloadOnly(Y y);
}
