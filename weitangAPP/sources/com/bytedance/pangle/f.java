package com.bytedance.pangle;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextThemeWrapper;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class f extends ContextThemeWrapper {
    private File mCacheDir;
    private File mCodeCacheDir;
    private File mDataDir;
    private File mExternalCacheDir;
    private File mFilesDir;
    private File mNoBackupFilesDir;
    private File mObbDir;
    private final Object mSync;

    public f() {
        this.mSync = new Object();
    }

    private static File ensurePrivateDirExists(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File makeFilename(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private String makeSubName(String str) {
        return getPluginDirName() + "_" + str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (getPluginDirName() == null) {
            return super.databaseList();
        }
        String[] strArrDatabaseList = super.databaseList();
        int length = strArrDatabaseList.length;
        boolean[] zArr = new boolean[length];
        int i2 = 0;
        for (int i3 = 0; i3 < strArrDatabaseList.length; i3++) {
            if (strArrDatabaseList[i3].startsWith(getPluginDirName())) {
                zArr[i3] = true;
                i2++;
            } else {
                zArr[i3] = false;
            }
        }
        String[] strArr = new String[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (zArr[i5]) {
                strArr[i4] = strArrDatabaseList[i5];
                i4++;
            }
        }
        return strArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        return getPluginDirName() == null ? super.deleteDatabase(str) : super.deleteDatabase(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return makeFilename(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        return getPluginDirName() == null ? super.deleteSharedPreferences(str) : super.deleteSharedPreferences(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File fileEnsurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mCacheDir == null) {
                this.mCacheDir = new File(super.getCacheDir(), getPluginDirName());
            }
            fileEnsurePrivateDirExists = ensurePrivateDirExists(this.mCacheDir);
        }
        return fileEnsurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File fileEnsurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mCodeCacheDir == null) {
                this.mCodeCacheDir = new File(super.getCodeCacheDir(), getPluginDirName());
            }
            fileEnsurePrivateDirExists = ensurePrivateDirExists(this.mCodeCacheDir);
        }
        return fileEnsurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File fileEnsurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getDataDir();
        }
        synchronized (this.mSync) {
            if (this.mDataDir == null) {
                this.mDataDir = new File(getHostDataDir(), getPluginDirName());
            }
            fileEnsurePrivateDirExists = ensurePrivateDirExists(this.mDataDir);
        }
        return fileEnsurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        return getPluginDirName() == null ? super.getDatabasePath(str) : super.getDatabasePath(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i2) {
        return (i2 != 0 || getPluginDirName() == null) ? super.getDir(str, i2) : ensurePrivateDirExists(new File(super.getDir(str, i2), getPluginDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File fileEnsurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mExternalCacheDir == null) {
                this.mExternalCacheDir = new File(super.getExternalCacheDir(), getPluginDirName());
            }
            fileEnsurePrivateDirExists = ensurePrivateDirExists(this.mExternalCacheDir);
        }
        return fileEnsurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (getPluginDirName() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i2 = 0; i2 < externalCacheDirs.length; i2++) {
            fileArr[i2] = ensurePrivateDirExists(new File(externalCacheDirs[i2], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        return getPluginDirName() == null ? super.getExternalFilesDir(str) : ensurePrivateDirExists(new File(super.getExternalFilesDir(str), getPluginDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (getPluginDirName() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i2 = 0; i2 < externalFilesDirs.length; i2++) {
            fileArr[i2] = ensurePrivateDirExists(new File(externalFilesDirs[i2], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (getPluginDirName() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i2 = 0; i2 < externalMediaDirs.length; i2++) {
            fileArr[i2] = ensurePrivateDirExists(new File(externalMediaDirs[i2], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File fileEnsurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getFilesDir();
        }
        synchronized (this.mSync) {
            if (this.mFilesDir == null) {
                this.mFilesDir = new File(super.getFilesDir(), getPluginDirName());
            }
            fileEnsurePrivateDirExists = ensurePrivateDirExists(this.mFilesDir);
        }
        return fileEnsurePrivateDirExists;
    }

    public File getHostDataDir() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File fileEnsurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.mSync) {
            if (this.mNoBackupFilesDir == null) {
                this.mNoBackupFilesDir = new File(super.getNoBackupFilesDir(), getPluginDirName());
            }
            fileEnsurePrivateDirExists = ensurePrivateDirExists(this.mNoBackupFilesDir);
        }
        return fileEnsurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File fileEnsurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getObbDir();
        }
        synchronized (this.mSync) {
            if (this.mObbDir == null) {
                this.mObbDir = new File(super.getObbDir(), getPluginDirName());
            }
            fileEnsurePrivateDirExists = ensurePrivateDirExists(this.mObbDir);
        }
        return fileEnsurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (getPluginDirName() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i2 = 0; i2 < obbDirs.length; i2++) {
            fileArr[i2] = ensurePrivateDirExists(new File(obbDirs[i2], getPluginDirName()));
        }
        return fileArr;
    }

    public String getPluginDirName() {
        return "pangle_" + getPluginPkg();
    }

    public String getPluginPkg() {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        return (i2 != 0 || getPluginDirName() == null) ? super.getSharedPreferences(str, i2) : super.getSharedPreferences(makeSubName(str), i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (getPluginDirName() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) {
        return getPluginDirName() == null ? super.openFileInput(str) : new FileInputStream(makeFilename(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i2) {
        return (i2 != 0 || getPluginDirName() == null) ? super.openFileOutput(str, i2) : new FileOutputStream(makeFilename(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        return (i2 != 0 || getPluginDirName() == null) ? super.openOrCreateDatabase(str, i2, cursorFactory) : super.openOrCreateDatabase(makeSubName(str), i2, cursorFactory);
    }

    public f(Context context, int i2) {
        super(context, i2);
        this.mSync = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i2 == 0 && getPluginDirName() != null) {
            return super.openOrCreateDatabase(makeSubName(str), i2, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(str, i2, cursorFactory, databaseErrorHandler);
    }

    @RequiresApi(api = 23)
    public f(Context context, Resources.Theme theme) {
        super(context, theme);
        this.mSync = new Object();
    }
}
