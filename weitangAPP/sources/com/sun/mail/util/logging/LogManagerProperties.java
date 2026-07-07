package com.sun.mail.util.logging;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectStreamException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.LoggingPermission;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: loaded from: classes2.dex */
public final class LogManagerProperties extends Properties {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object LOG_MANAGER;
    private static final Method LR_GET_INSTANT;
    private static final Method LR_GET_LONG_TID;
    private static volatile String[] REFLECT_NAMES = null;
    private static final Method ZDT_OF_INSTANT;
    private static final Method ZI_SYSTEM_DEFAULT;
    private static final long serialVersionUID = -2239983349056806252L;
    private final String prefix;

    /* JADX WARN: Removed duplicated region for block: B:56:0x00b4 A[PHI: r0 r3 r4
  0x00b4: PHI (r0v8 java.lang.reflect.Method) = 
  (r0v5 java.lang.reflect.Method)
  (r0v6 java.lang.reflect.Method)
  (r0v7 java.lang.reflect.Method)
  (r0v22 java.lang.reflect.Method)
 binds: [B:44:0x009d, B:49:0x00a7, B:54:0x00b1, B:16:0x0068] A[DONT_GENERATE, DONT_INLINE]
  0x00b4: PHI (r3v8 java.lang.reflect.Method) = 
  (r3v5 java.lang.reflect.Method)
  (r3v6 java.lang.reflect.Method)
  (r3v7 java.lang.reflect.Method)
  (r3v10 java.lang.reflect.Method)
 binds: [B:44:0x009d, B:49:0x00a7, B:54:0x00b1, B:16:0x0068] A[DONT_GENERATE, DONT_INLINE]
  0x00b4: PHI (r4v7 java.lang.reflect.Method) = 
  (r4v4 java.lang.reflect.Method)
  (r4v5 java.lang.reflect.Method)
  (r4v6 java.lang.reflect.Method)
  (r4v16 java.lang.reflect.Method)
 binds: [B:44:0x009d, B:49:0x00a7, B:54:0x00b1, B:16:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b6  */
    static {
        /*
            java.lang.String r0 = "java.time.ZoneId"
            java.lang.Class<com.sun.mail.util.logging.LogManagerProperties> r1 = com.sun.mail.util.logging.LogManagerProperties.class
            r1 = 0
            r2 = 0
            java.lang.Class<java.util.logging.LogRecord> r3 = java.util.logging.LogRecord.class
            java.lang.String r4 = "getLongThreadID"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L11
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L11
            goto L12
        L11:
            r3 = r2
        L12:
            com.sun.mail.util.logging.LogManagerProperties.LR_GET_LONG_TID = r3
            java.lang.Class<java.util.logging.LogRecord> r3 = java.util.logging.LogRecord.class
            java.lang.String r4 = "getInstant"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L92 java.lang.LinkageError -> L96 java.lang.Exception -> La0 java.lang.RuntimeException -> Laa
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L92 java.lang.LinkageError -> L96 java.lang.Exception -> La0 java.lang.RuntimeException -> Laa
            java.lang.Class r4 = findClass(r0)     // Catch: java.lang.Throwable -> L84 java.lang.LinkageError -> L89 java.lang.Exception -> L8c java.lang.RuntimeException -> L8f
            java.lang.String r5 = "systemDefault"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L84 java.lang.LinkageError -> L89 java.lang.Exception -> L8c java.lang.RuntimeException -> L8f
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch: java.lang.Throwable -> L84 java.lang.LinkageError -> L89 java.lang.Exception -> L8c java.lang.RuntimeException -> L8f
            int r5 = r4.getModifiers()     // Catch: java.lang.Throwable -> L7b java.lang.LinkageError -> L7e java.lang.Exception -> L80 java.lang.RuntimeException -> L82
            boolean r5 = java.lang.reflect.Modifier.isStatic(r5)     // Catch: java.lang.Throwable -> L7b java.lang.LinkageError -> L7e java.lang.Exception -> L80 java.lang.RuntimeException -> L82
            if (r5 == 0) goto L78
            java.lang.String r5 = "java.time.ZonedDateTime"
            java.lang.Class r5 = findClass(r5)     // Catch: java.lang.Throwable -> L7b java.lang.LinkageError -> L7e java.lang.Exception -> L80 java.lang.RuntimeException -> L82
            java.lang.String r6 = "ofInstant"
            r7 = 2
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch: java.lang.Throwable -> L7b java.lang.LinkageError -> L7e java.lang.Exception -> L80 java.lang.RuntimeException -> L82
            java.lang.String r8 = "java.time.Instant"
            java.lang.Class r8 = findClass(r8)     // Catch: java.lang.Throwable -> L7b java.lang.LinkageError -> L7e java.lang.Exception -> L80 java.lang.RuntimeException -> L82
            r7[r1] = r8     // Catch: java.lang.Throwable -> L7b java.lang.LinkageError -> L7e java.lang.Exception -> L80 java.lang.RuntimeException -> L82
            r1 = 1
            java.lang.Class r0 = findClass(r0)     // Catch: java.lang.Throwable -> L7b java.lang.LinkageError -> L7e java.lang.Exception -> L80 java.lang.RuntimeException -> L82
            r7[r1] = r0     // Catch: java.lang.Throwable -> L7b java.lang.LinkageError -> L7e java.lang.Exception -> L80 java.lang.RuntimeException -> L82
            java.lang.reflect.Method r0 = r5.getMethod(r6, r7)     // Catch: java.lang.Throwable -> L7b java.lang.LinkageError -> L7e java.lang.Exception -> L80 java.lang.RuntimeException -> L82
            int r1 = r0.getModifiers()     // Catch: java.lang.Throwable -> L6f java.lang.LinkageError -> L71 java.lang.Exception -> L73 java.lang.RuntimeException -> L75
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)     // Catch: java.lang.Throwable -> L6f java.lang.LinkageError -> L71 java.lang.Exception -> L73 java.lang.RuntimeException -> L75
            if (r1 == 0) goto L6c
            java.lang.Class<java.lang.Comparable> r1 = java.lang.Comparable.class
            java.lang.Class r5 = r0.getReturnType()     // Catch: java.lang.Throwable -> L6f java.lang.LinkageError -> L71 java.lang.Exception -> L73 java.lang.RuntimeException -> L75
            boolean r1 = r1.isAssignableFrom(r5)     // Catch: java.lang.Throwable -> L6f java.lang.LinkageError -> L71 java.lang.Exception -> L73 java.lang.RuntimeException -> L75
            if (r1 == 0) goto L6c
            if (r3 == 0) goto Lb6
            goto Lb4
        L6c:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch: java.lang.Throwable -> L7b java.lang.LinkageError -> L7e java.lang.Exception -> L80 java.lang.RuntimeException -> L82
            throw r2     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L80 java.lang.RuntimeException -> L82
        L6f:
            r1 = move-exception
            goto L87
        L71:
            goto L99
        L73:
            goto La3
        L75:
            goto Lad
        L78:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch: java.lang.Throwable -> L84 java.lang.LinkageError -> L89 java.lang.Exception -> L8c java.lang.RuntimeException -> L8f
            throw r2     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L8c java.lang.RuntimeException -> L8f
        L7b:
            r1 = move-exception
            r0 = r2
            goto L87
        L7e:
            r0 = r2
            goto L99
        L80:
            r0 = r2
            goto La3
        L82:
            r0 = r2
            goto Lad
        L84:
            r1 = move-exception
            r0 = r2
            r4 = r0
        L87:
            r2 = r3
            goto L95
        L89:
            r0 = r2
            r4 = r0
            goto L99
        L8c:
            r0 = r2
            r4 = r0
            goto La3
        L8f:
            r0 = r2
            r4 = r0
            goto Lad
        L92:
            r1 = move-exception
            r0 = r2
            r4 = r0
        L95:
            throw r1
        L96:
            r0 = r2
            r3 = r0
            r4 = r3
        L99:
            if (r3 == 0) goto Lb6
            if (r4 == 0) goto Lb6
            if (r0 != 0) goto Lb4
            goto Lb6
        La0:
            r0 = r2
            r3 = r0
            r4 = r3
        La3:
            if (r3 == 0) goto Lb6
            if (r4 == 0) goto Lb6
            if (r0 != 0) goto Lb4
            goto Lb6
        Laa:
            r0 = r2
            r3 = r0
            r4 = r3
        Lad:
            if (r3 == 0) goto Lb6
            if (r4 == 0) goto Lb6
            if (r0 != 0) goto Lb4
            goto Lb6
        Lb4:
            r2 = r3
            goto Lb8
        Lb6:
            r0 = r2
            r4 = r0
        Lb8:
            com.sun.mail.util.logging.LogManagerProperties.LR_GET_INSTANT = r2
            com.sun.mail.util.logging.LogManagerProperties.ZI_SYSTEM_DEFAULT = r4
            com.sun.mail.util.logging.LogManagerProperties.ZDT_OF_INSTANT = r0
            java.lang.Object r0 = loadLogManager()
            com.sun.mail.util.logging.LogManagerProperties.LOG_MANAGER = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.LogManagerProperties.<clinit>():void");
    }

    public LogManagerProperties(Properties properties, String str) {
        super(properties);
        if (properties == null || str == null) {
            throw null;
        }
        this.prefix = str;
    }

    public static void checkLogManagerAccess() {
        Object obj = LOG_MANAGER;
        boolean z = false;
        if (obj != null) {
            try {
                if (obj instanceof LogManager) {
                    z = true;
                    ((LogManager) obj).checkAccess();
                }
            } catch (LinkageError | RuntimeException unused) {
            } catch (SecurityException e2) {
                if (z) {
                    throw e2;
                }
            }
        }
        if (z) {
            return;
        }
        checkLoggingAccess();
    }

    private static void checkLoggingAccess() {
        SecurityManager securityManager;
        Logger logger = Logger.getLogger("global");
        boolean z = false;
        try {
            if (Logger.class == logger.getClass()) {
                logger.removeHandler(null);
                z = true;
            }
        } catch (NullPointerException unused) {
        }
        if (z || (securityManager = System.getSecurityManager()) == null) {
            return;
        }
        securityManager.checkPermission(new LoggingPermission("control", null));
    }

    private Properties exportCopy(Properties properties) {
        Thread.holdsLock(this);
        Properties properties2 = new Properties(properties);
        properties2.putAll(this);
        return properties2;
    }

    private static Class<?> findClass(String str) throws ClassNotFoundException {
        ClassLoader[] classLoaders = getClassLoaders();
        if (classLoaders[0] == null) {
            return tryLoad(str, classLoaders[1]);
        }
        try {
            return Class.forName(str, false, classLoaders[0]);
        } catch (ClassNotFoundException unused) {
            return tryLoad(str, classLoaders[1]);
        }
    }

    public static String fromLogManager(String str) {
        Objects.requireNonNull(str);
        Object obj = LOG_MANAGER;
        try {
            if (obj instanceof Properties) {
                return ((Properties) obj).getProperty(str);
            }
        } catch (RuntimeException unused) {
        }
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof LogManager) {
                return ((LogManager) obj).getProperty(str);
            }
            return null;
        } catch (LinkageError | RuntimeException unused2) {
            return null;
        }
    }

    private static ClassLoader[] getClassLoaders() {
        return (ClassLoader[]) AccessController.doPrivileged(new PrivilegedAction<ClassLoader[]>() { // from class: com.sun.mail.util.logging.LogManagerProperties.1
            @Override // java.security.PrivilegedAction
            public ClassLoader[] run() {
                ClassLoader[] classLoaderArr = new ClassLoader[2];
                try {
                    classLoaderArr[0] = ClassLoader.getSystemClassLoader();
                } catch (SecurityException unused) {
                    classLoaderArr[0] = null;
                }
                try {
                    classLoaderArr[1] = Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused2) {
                    classLoaderArr[1] = null;
                }
                return classLoaderArr;
            }
        });
    }

    public static String getLocalHost(Object obj) throws Exception {
        try {
            Method method = obj.getClass().getMethod("getLocalHost", new Class[0]);
            if (Modifier.isStatic(method.getModifiers()) || method.getReturnType() != String.class) {
                throw new NoSuchMethodException(method.toString());
            }
            return (String) method.invoke(obj, new Object[0]);
        } catch (ExceptionInInitializerError e2) {
            throw wrapOrThrow(e2);
        } catch (InvocationTargetException e3) {
            throw paramOrError(e3);
        }
    }

    public static Long getLongThreadID(LogRecord logRecord) {
        Objects.requireNonNull(logRecord);
        Method method = LR_GET_LONG_TID;
        if (method == null) {
            return null;
        }
        try {
            return (Long) method.invoke(logRecord, new Object[0]);
        } catch (RuntimeException | Exception unused) {
            return null;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new UndeclaredThrowableException(e2);
        }
    }

    public static Comparable<?> getZonedDateTime(LogRecord logRecord) {
        Objects.requireNonNull(logRecord);
        Method method = ZDT_OF_INSTANT;
        if (method != null) {
            try {
                return (Comparable) method.invoke(null, LR_GET_INSTANT.invoke(logRecord, new Object[0]), ZI_SYSTEM_DEFAULT.invoke(null, new Object[0]));
            } catch (RuntimeException | Exception unused) {
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new UndeclaredThrowableException(e2);
            }
        }
        return null;
    }

    public static boolean hasLogManager() {
        Object obj = LOG_MANAGER;
        return (obj == null || (obj instanceof Properties)) ? false : true;
    }

    public static boolean isReflectionClass(String str) throws Exception {
        String[] strArrReflectionClassNames = REFLECT_NAMES;
        if (strArrReflectionClassNames == null) {
            strArrReflectionClassNames = reflectionClassNames();
            REFLECT_NAMES = strArrReflectionClassNames;
        }
        for (String str2 : strArrReflectionClassNames) {
            if (str.equals(str2)) {
                return true;
            }
        }
        findClass(str);
        return false;
    }

    public static boolean isStaticUtilityClass(String str) throws Exception {
        Class<?> clsFindClass = findClass(str);
        if (clsFindClass == Object.class) {
            return false;
        }
        Method[] methods = clsFindClass.getMethods();
        if (methods.length == 0) {
            return false;
        }
        for (Method method : methods) {
            if (method.getDeclaringClass() != Object.class && !Modifier.isStatic(method.getModifiers())) {
                return false;
            }
        }
        return true;
    }

    private static Object loadLogManager() {
        try {
            return LogManager.getLogManager();
        } catch (LinkageError unused) {
            return readConfiguration();
        } catch (RuntimeException unused2) {
            return readConfiguration();
        }
    }

    public static Comparator<? super LogRecord> newComparator(String str) throws Exception {
        return (Comparator) newObjectFrom(str, Comparator.class);
    }

    public static ErrorManager newErrorManager(String str) throws Exception {
        return (ErrorManager) newObjectFrom(str, ErrorManager.class);
    }

    public static Filter newFilter(String str) throws Exception {
        return (Filter) newObjectFrom(str, Filter.class);
    }

    public static Formatter newFormatter(String str) throws Exception {
        return (Formatter) newObjectFrom(str, Formatter.class);
    }

    public static <T> T newObjectFrom(String str, Class<T> cls) throws Exception {
        try {
            Class<?> clsFindClass = findClass(str);
            if (cls.isAssignableFrom(clsFindClass)) {
                try {
                    return cls.cast(clsFindClass.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (InvocationTargetException e2) {
                    throw paramOrError(e2);
                }
            }
            throw new ClassCastException(clsFindClass.getName() + " cannot be cast to " + cls.getName());
        } catch (ExceptionInInitializerError e3) {
            throw wrapOrThrow(e3);
        } catch (NoClassDefFoundError e4) {
            throw new ClassNotFoundException(e4.toString(), e4);
        }
    }

    private static Exception paramOrError(InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause == null || (!(cause instanceof VirtualMachineError) && !(cause instanceof ThreadDeath))) {
            return invocationTargetException;
        }
        throw ((Error) cause);
    }

    public static long parseDurationToMillis(CharSequence charSequence) throws Exception {
        Objects.requireNonNull(charSequence);
        try {
            Class<?> clsFindClass = findClass("java.time.Duration");
            Method method = clsFindClass.getMethod("parse", CharSequence.class);
            if (!clsFindClass.isAssignableFrom(method.getReturnType()) || !Modifier.isStatic(method.getModifiers())) {
                throw new NoSuchMethodException(method.toString());
            }
            Method method2 = clsFindClass.getMethod("toMillis", new Class[0]);
            if (!Long.TYPE.isAssignableFrom(method2.getReturnType()) || Modifier.isStatic(method2.getModifiers())) {
                throw new NoSuchMethodException(method2.toString());
            }
            return ((Long) method2.invoke(method.invoke(null, charSequence), new Object[0])).longValue();
        } catch (ExceptionInInitializerError e2) {
            throw wrapOrThrow(e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof ArithmeticException) {
                throw ((ArithmeticException) cause);
            }
            throw paramOrError(e3);
        }
    }

    private Object preWrite(Object obj) {
        return get(obj);
    }

    private static Properties readConfiguration() {
        Properties properties = new Properties();
        try {
            String property = System.getProperty("java.util.logging.config.file");
            if (property != null) {
                FileInputStream fileInputStream = new FileInputStream(new File(property).getCanonicalFile());
                try {
                    properties.load(fileInputStream);
                    fileInputStream.close();
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        } catch (RuntimeException | Exception | LinkageError unused) {
        }
        return properties;
    }

    private static String[] reflectionClassNames() throws Exception {
        try {
            HashSet hashSet = new HashSet();
            Throwable th = (Throwable) Throwable.class.getConstructor(new Class[0]).newInstance(new Object[0]);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (LogManagerProperties.class.getName().equals(stackTraceElement.getClassName())) {
                    break;
                }
                hashSet.add(stackTraceElement.getClassName());
            }
            Throwable.class.getMethod("fillInStackTrace", new Class[0]).invoke(th, new Object[0]);
            for (StackTraceElement stackTraceElement2 : th.getStackTrace()) {
                if (LogManagerProperties.class.getName().equals(stackTraceElement2.getClassName())) {
                    break;
                }
                hashSet.add(stackTraceElement2.getClassName());
            }
            return (String[]) hashSet.toArray(new String[hashSet.size()]);
        } catch (InvocationTargetException e2) {
            throw paramOrError(e2);
        }
    }

    public static <T> Comparator<T> reverseOrder(Comparator<T> comparator) {
        Objects.requireNonNull(comparator);
        Comparator<T> comparator2 = null;
        try {
            try {
                Method method = comparator.getClass().getMethod("reversed", new Class[0]);
                if (!Modifier.isStatic(method.getModifiers()) && Comparator.class.isAssignableFrom(method.getReturnType())) {
                    try {
                        comparator2 = (Comparator) method.invoke(comparator, new Object[0]);
                    } catch (ExceptionInInitializerError e2) {
                        throw wrapOrThrow(e2);
                    }
                }
            } catch (ReflectiveOperationException | RuntimeException unused) {
            }
        } catch (InvocationTargetException e3) {
            paramOrError(e3);
        }
        return comparator2 == null ? Collections.reverseOrder(comparator) : comparator2;
    }

    public static String toLanguageTag(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        char[] cArr = new char[language.length() + country.length() + variant.length() + 2];
        int length = language.length();
        language.getChars(0, length, cArr, 0);
        if (country.length() != 0 || (language.length() != 0 && variant.length() != 0)) {
            cArr[length] = Soundex.SILENT_MARKER;
            int i2 = length + 1;
            country.getChars(0, country.length(), cArr, i2);
            length = i2 + country.length();
        }
        if (variant.length() != 0 && (language.length() != 0 || country.length() != 0)) {
            cArr[length] = Soundex.SILENT_MARKER;
            int i3 = length + 1;
            variant.getChars(0, variant.length(), cArr, i3);
            length = i3 + variant.length();
        }
        return String.valueOf(cArr, 0, length);
    }

    private static Class<?> tryLoad(String str, ClassLoader classLoader) throws ClassNotFoundException {
        return classLoader != null ? Class.forName(str, false, classLoader) : Class.forName(str);
    }

    private static InvocationTargetException wrapOrThrow(ExceptionInInitializerError exceptionInInitializerError) {
        if (exceptionInInitializerError.getCause() instanceof Error) {
            throw exceptionInInitializerError;
        }
        return new InvocationTargetException(exceptionInInitializerError);
    }

    private synchronized Object writeReplace() throws ObjectStreamException {
        return exportCopy((Properties) ((Properties) this).defaults.clone());
    }

    @Override // java.util.Hashtable
    public synchronized Object clone() {
        return exportCopy(((Properties) this).defaults);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized boolean containsKey(Object obj) {
        boolean z;
        boolean z2 = true;
        z = (obj instanceof String) && getProperty((String) obj) != null;
        if (!z) {
            if (!((Properties) this).defaults.containsKey(obj)) {
                if (!super.containsKey(obj)) {
                    z2 = false;
                }
            }
            z = z2;
        }
        return z;
    }

    @Override // java.util.Hashtable, java.util.Map
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Properties) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object get(Object obj) {
        Object property;
        property = obj instanceof String ? getProperty((String) obj) : null;
        if (property == null && (property = ((Properties) this).defaults.get(obj)) == null && !((Properties) this).defaults.containsKey(obj)) {
            property = super.get(obj);
        }
        return property;
    }

    @Override // java.util.Properties
    public synchronized String getProperty(String str) {
        String property;
        property = ((Properties) this).defaults.getProperty(str);
        if (property == null) {
            if (str.length() > 0) {
                property = fromLogManager(this.prefix + '.' + str);
            }
            if (property == null) {
                property = fromLogManager(str);
            }
            if (property != null) {
                super.put(str, property);
            } else {
                Object obj = super.get(str);
                property = obj instanceof String ? (String) obj : null;
            }
        }
        return property;
    }

    @Override // java.util.Hashtable, java.util.Map
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.Properties
    public Enumeration<?> propertyNames() {
        return super.propertyNames();
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object put(Object obj, Object obj2) {
        if (!(obj instanceof String) || !(obj2 instanceof String)) {
            return super.put(obj, obj2);
        }
        Object objPreWrite = preWrite(obj);
        Object objPut = super.put(obj, obj2);
        if (objPut != null) {
            objPreWrite = objPut;
        }
        return objPreWrite;
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object remove(Object obj) {
        Object objPreWrite;
        objPreWrite = preWrite(obj);
        Object objRemove = super.remove(obj);
        if (objRemove != null) {
            objPreWrite = objRemove;
        }
        return objPreWrite;
    }

    @Override // java.util.Properties
    public Object setProperty(String str, String str2) {
        return put(str, str2);
    }

    @Override // java.util.Properties
    public String getProperty(String str, String str2) {
        String property = getProperty(str);
        return property == null ? str2 : property;
    }
}
