package javax.activation;

import com.alibaba.android.arouter.utils.Consts;
import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MimeTypeFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class MimetypesFileTypeMap extends FileTypeMap {
    private static final int PROG = 0;
    private static final String confDir;
    private static final String defaultType = "application/octet-stream";
    private MimeTypeFile[] DB;

    static {
        String str;
        try {
            str = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.activation.MimetypesFileTypeMap.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    String property = System.getProperty("java.home");
                    StringBuilder sb = new StringBuilder();
                    sb.append(property);
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append("conf");
                    String string = sb.toString();
                    if (new File(string).exists()) {
                        return string + str2;
                    }
                    return property + str2 + "lib" + str2;
                }
            });
        } catch (Exception unused) {
            str = null;
        }
        confDir = str;
    }

    public MimetypesFileTypeMap() throws Throwable {
        Vector vector = new Vector(5);
        vector.addElement(null);
        LogSupport.log("MimetypesFileTypeMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                MimeTypeFile mimeTypeFileLoadFile = loadFile(property + File.separator + ".mime.types");
                if (mimeTypeFileLoadFile != null) {
                    vector.addElement(mimeTypeFileLoadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        LogSupport.log("MimetypesFileTypeMap: load SYS");
        try {
            String str = confDir;
            if (str != null) {
                MimeTypeFile mimeTypeFileLoadFile2 = loadFile(str + "mime.types");
                if (mimeTypeFileLoadFile2 != null) {
                    vector.addElement(mimeTypeFileLoadFile2);
                }
            }
        } catch (SecurityException unused2) {
        }
        LogSupport.log("MimetypesFileTypeMap: load JAR");
        loadAllResources(vector, "META-INF/mime.types");
        LogSupport.log("MimetypesFileTypeMap: load DEF");
        MimeTypeFile mimeTypeFileLoadResource = loadResource("/META-INF/mimetypes.default");
        if (mimeTypeFileLoadResource != null) {
            vector.addElement(mimeTypeFileLoadResource);
        }
        MimeTypeFile[] mimeTypeFileArr = new MimeTypeFile[vector.size()];
        this.DB = mimeTypeFileArr;
        vector.copyInto(mimeTypeFileArr);
    }

    private void loadAllResources(Vector vector, String str) throws Throwable {
        int i2 = 0;
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            URL[] resources = contextClassLoader != null ? SecuritySupport.getResources(contextClassLoader, str) : SecuritySupport.getSystemResources(str);
            if (resources != null) {
                if (LogSupport.isLoggable()) {
                    LogSupport.log("MimetypesFileTypeMap: getResources");
                }
                int i3 = 0;
                while (i2 < resources.length) {
                    try {
                        URL url = resources[i2];
                        InputStream inputStreamOpenStream = null;
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("MimetypesFileTypeMap: URL " + url);
                        }
                        try {
                            try {
                                inputStreamOpenStream = SecuritySupport.openStream(url);
                                if (inputStreamOpenStream != null) {
                                    vector.addElement(new MimeTypeFile(inputStreamOpenStream));
                                    try {
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MimetypesFileTypeMap: successfully loaded mime types from URL: " + url);
                                        }
                                        i3 = 1;
                                    } catch (IOException e2) {
                                        e = e2;
                                        i3 = 1;
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MimetypesFileTypeMap: can't load " + url, e);
                                        }
                                        if (inputStreamOpenStream != null) {
                                        }
                                        i2++;
                                    } catch (SecurityException e3) {
                                        e = e3;
                                        i3 = 1;
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MimetypesFileTypeMap: can't load " + url, e);
                                        }
                                        if (inputStreamOpenStream == null) {
                                            i2++;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        i3 = 1;
                                        if (inputStreamOpenStream != null) {
                                            try {
                                                inputStreamOpenStream.close();
                                            } catch (IOException unused) {
                                            }
                                        }
                                        throw th;
                                    }
                                } else if (LogSupport.isLoggable()) {
                                    LogSupport.log("MimetypesFileTypeMap: not loading mime types from URL: " + url);
                                }
                            } catch (IOException e4) {
                                e = e4;
                            } catch (SecurityException e5) {
                                e = e5;
                            }
                            if (inputStreamOpenStream != null) {
                                try {
                                    inputStreamOpenStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            i2++;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i2 = i3;
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("MimetypesFileTypeMap: can't load " + str, e);
                        }
                    }
                }
                i2 = i3;
            }
        } catch (Exception e7) {
            e = e7;
        }
        if (i2 == 0) {
            LogSupport.log("MimetypesFileTypeMap: !anyLoaded");
            MimeTypeFile mimeTypeFileLoadResource = loadResource("/" + str);
            if (mimeTypeFileLoadResource != null) {
                vector.addElement(mimeTypeFileLoadResource);
            }
        }
    }

    private MimeTypeFile loadFile(String str) {
        try {
            return new MimeTypeFile(str);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0092: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:38:0x0092 */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004c A[EXC_TOP_SPLITTER, PHI: r2
  0x004c: PHI (r2v5 java.io.InputStream) = (r2v3 java.io.InputStream), (r2v4 java.io.InputStream), (r2v7 java.io.InputStream) binds: [B:28:0x0072, B:34:0x008d, B:13:0x004a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sun.activation.registries.MimeTypeFile loadResource(java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "MimetypesFileTypeMap: can't load "
            r1 = 0
            java.lang.Class r2 = r6.getClass()     // Catch: java.lang.Throwable -> L54 java.lang.SecurityException -> L56 java.io.IOException -> L73
            java.io.InputStream r2 = javax.activation.SecuritySupport.getResourceAsStream(r2, r7)     // Catch: java.lang.Throwable -> L54 java.lang.SecurityException -> L56 java.io.IOException -> L73
            if (r2 == 0) goto L30
            com.sun.activation.registries.MimeTypeFile r3 = new com.sun.activation.registries.MimeTypeFile     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            r3.<init>(r2)     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            if (r4 == 0) goto L2c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            r4.<init>()     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            java.lang.String r5 = "MimetypesFileTypeMap: successfully loaded mime types file: "
            r4.append(r5)     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            r4.append(r7)     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            java.lang.String r4 = r4.toString()     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            com.sun.activation.registries.LogSupport.log(r4)     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
        L2c:
            r2.close()     // Catch: java.io.IOException -> L2f
        L2f:
            return r3
        L30:
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            if (r3 == 0) goto L4a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            r3.<init>()     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            java.lang.String r4 = "MimetypesFileTypeMap: not loading mime types file: "
            r3.append(r4)     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            r3.append(r7)     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            java.lang.String r3 = r3.toString()     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
            com.sun.activation.registries.LogSupport.log(r3)     // Catch: java.lang.SecurityException -> L50 java.io.IOException -> L52 java.lang.Throwable -> L91
        L4a:
            if (r2 == 0) goto L90
        L4c:
            r2.close()     // Catch: java.io.IOException -> L90
            goto L90
        L50:
            r3 = move-exception
            goto L58
        L52:
            r3 = move-exception
            goto L75
        L54:
            r7 = move-exception
            goto L93
        L56:
            r3 = move-exception
            r2 = r1
        L58:
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch: java.lang.Throwable -> L91
            if (r4 == 0) goto L70
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91
            r4.<init>()     // Catch: java.lang.Throwable -> L91
            r4.append(r0)     // Catch: java.lang.Throwable -> L91
            r4.append(r7)     // Catch: java.lang.Throwable -> L91
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L91
            com.sun.activation.registries.LogSupport.log(r7, r3)     // Catch: java.lang.Throwable -> L91
        L70:
            if (r2 == 0) goto L90
            goto L4c
        L73:
            r3 = move-exception
            r2 = r1
        L75:
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch: java.lang.Throwable -> L91
            if (r4 == 0) goto L8d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91
            r4.<init>()     // Catch: java.lang.Throwable -> L91
            r4.append(r0)     // Catch: java.lang.Throwable -> L91
            r4.append(r7)     // Catch: java.lang.Throwable -> L91
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L91
            com.sun.activation.registries.LogSupport.log(r7, r3)     // Catch: java.lang.Throwable -> L91
        L8d:
            if (r2 == 0) goto L90
            goto L4c
        L90:
            return r1
        L91:
            r7 = move-exception
            r1 = r2
        L93:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.io.IOException -> L98
        L98:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadResource(java.lang.String):com.sun.activation.registries.MimeTypeFile");
    }

    public synchronized void addMimeTypes(String str) {
        MimeTypeFile[] mimeTypeFileArr = this.DB;
        if (mimeTypeFileArr[0] == null) {
            mimeTypeFileArr[0] = new MimeTypeFile();
        }
        this.DB[0].appendToRegistry(str);
    }

    @Override // javax.activation.FileTypeMap
    public String getContentType(File file) {
        return getContentType(file.getName());
    }

    @Override // javax.activation.FileTypeMap
    public synchronized String getContentType(String str) {
        String mIMETypeString;
        int iLastIndexOf = str.lastIndexOf(Consts.DOT);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String strSubstring = str.substring(iLastIndexOf + 1);
        if (strSubstring.length() == 0) {
            return "application/octet-stream";
        }
        int i2 = 0;
        while (true) {
            MimeTypeFile[] mimeTypeFileArr = this.DB;
            if (i2 >= mimeTypeFileArr.length) {
                return "application/octet-stream";
            }
            if (mimeTypeFileArr[i2] != null && (mIMETypeString = mimeTypeFileArr[i2].getMIMETypeString(strSubstring)) != null) {
                return mIMETypeString;
            }
            i2++;
        }
    }

    public MimetypesFileTypeMap(String str) throws IOException {
        this();
        this.DB[0] = new MimeTypeFile(str);
    }

    public MimetypesFileTypeMap(InputStream inputStream) {
        this();
        try {
            this.DB[0] = new MimeTypeFile(inputStream);
        } catch (IOException unused) {
        }
    }
}
