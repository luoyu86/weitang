package org.android.spdy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tom_roush.fontbox.ttf.OpenTypeScript;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class SoInstallMgrSdk {
    private static final String ARMEABI = "armeabi";
    private static final int EventID_SO_INIT = 21033;
    public static final String LOGTAG = "INIT_SO";
    private static final String MIPS = "mips";
    private static final String X86 = "x86";
    public static Context mContext;

    private static String _cpuType() {
        String str_getFieldReflectively = _getFieldReflectively(new Build(), "CPU_ABI");
        if (str_getFieldReflectively == null || str_getFieldReflectively.length() == 0 || str_getFieldReflectively.equals(OpenTypeScript.UNKNOWN)) {
            str_getFieldReflectively = ARMEABI;
        }
        return str_getFieldReflectively.toLowerCase();
    }

    private static String _getFieldReflectively(Build build, String str) {
        try {
            return Build.class.getField(str).get(build).toString();
        } catch (Exception unused) {
            return OpenTypeScript.UNKNOWN;
        }
    }

    public static boolean _loadUnzipSo(String str, int i2, ClassLoader classLoader) {
        try {
            if (isExist(str, i2)) {
                if (classLoader == null) {
                    System.load(_targetSoFile(str, i2));
                } else {
                    Runtime runtime = Runtime.getRuntime();
                    Method declaredMethod = Runtime.class.getDeclaredMethod("load", String.class, ClassLoader.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(runtime, _targetSoFile(str, i2), classLoader);
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
            return false;
        } catch (Error e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static String _targetSoFile(String str, int i2) {
        Context context = mContext;
        if (context == null) {
            return "";
        }
        String path = "/data/data/" + context.getPackageName() + "/files";
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            path = filesDir.getPath();
        }
        return path + "/lib" + str + "bk" + i2 + ".so";
    }

    public static void init(Context context) {
        mContext = context;
    }

    public static boolean initSo(String str, int i2) {
        return initSo(str, i2, null);
    }

    public static boolean isExist(String str, int i2) {
        return new File(_targetSoFile(str, i2)).exists();
    }

    public static void removeSoIfExit(String str, int i2) {
        File file = new File(_targetSoFile(str, i2));
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean unZipSelectedFiles(String str, int i2, ClassLoader classLoader) throws Throwable {
        Context context;
        FileChannel fileChannel;
        FileOutputStream fileOutputStreamOpenFileOutput;
        String str2 = "lib/armeabi/lib" + str + ".so";
        try {
            context = mContext;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (context == null) {
            return false;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        ZipFile zipFile = new ZipFile(applicationInfo != null ? applicationInfo.sourceDir : "");
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            String name = zipEntryNextElement.getName();
            if (!name.contains("..") && !name.contains("\\") && !name.contains("%")) {
                if (zipEntryNextElement.getName().startsWith(str2)) {
                    InputStream inputStream = null;
                    FileChannel channel = null;
                    try {
                        removeSoIfExit(str, i2);
                        InputStream inputStream2 = zipFile.getInputStream(zipEntryNextElement);
                        try {
                            fileOutputStreamOpenFileOutput = context.openFileOutput("lib" + str + "bk" + i2 + ".so", 0);
                        } catch (Throwable th) {
                            th = th;
                            fileChannel = null;
                            fileOutputStreamOpenFileOutput = null;
                        }
                        try {
                            channel = fileOutputStreamOpenFileOutput.getChannel();
                            byte[] bArr = new byte[1024];
                            int i3 = 0;
                            while (true) {
                                int i4 = inputStream2.read(bArr);
                                if (i4 > 0) {
                                    channel.write(ByteBuffer.wrap(bArr, 0, i4));
                                    i3 += i4;
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            }
                            inputStream2.close();
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            zipFile.close();
                            if (i3 > 0) {
                                return _loadUnzipSo(str, i2, classLoader);
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            fileChannel = channel;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (fileOutputStreamOpenFileOutput != null) {
                                try {
                                    fileOutputStreamOpenFileOutput.close();
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                            }
                            zipFile.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileChannel = null;
                        fileOutputStreamOpenFileOutput = null;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static boolean initSo(String str, int i2, ClassLoader classLoader) {
        boolean z = true;
        try {
            if (classLoader == null) {
                System.loadLibrary(str);
            } else {
                Runtime runtime = Runtime.getRuntime();
                Method declaredMethod = Runtime.class.getDeclaredMethod("loadLibrary", String.class, ClassLoader.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(runtime, str, classLoader);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            z = false;
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
            z = false;
        } catch (Error e4) {
            e4.printStackTrace();
            z = false;
        }
        if (!z) {
            try {
                if (isExist(str, i2)) {
                    boolean z_loadUnzipSo = _loadUnzipSo(str, i2, classLoader);
                    if (z_loadUnzipSo) {
                        return z_loadUnzipSo;
                    }
                    removeSoIfExit(str, i2);
                }
                String str_cpuType = _cpuType();
                if (!str_cpuType.equalsIgnoreCase(MIPS) && !str_cpuType.equalsIgnoreCase(X86)) {
                    try {
                        return unZipSelectedFiles(str, i2, classLoader);
                    } catch (ZipException e5) {
                        e5.printStackTrace();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
            } catch (Error e7) {
                e7.printStackTrace();
                return false;
            } catch (Exception e8) {
                e8.printStackTrace();
                return false;
            } catch (UnsatisfiedLinkError e9) {
                e9.printStackTrace();
                return false;
            }
        }
        return z;
    }
}
