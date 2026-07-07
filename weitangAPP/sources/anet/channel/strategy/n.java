package anet.channel.strategy;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class n implements Comparator<File> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }
}
