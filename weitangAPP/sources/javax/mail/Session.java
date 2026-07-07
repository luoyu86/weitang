package javax.mail;

import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.u.i;
import com.sun.mail.util.DefaultProvider;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.MailLogger;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.StringTokenizer;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import javax.mail.Provider;

/* JADX INFO: loaded from: classes2.dex */
public final class Session {
    private static final String confDir;
    private static Session defaultSession;
    private final Authenticator authenticator;
    private boolean debug;
    private MailLogger logger;
    private PrintStream out;
    private final Properties props;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final EventQueue f14926q;
    private final Hashtable<URLName, PasswordAuthentication> authTable = new Hashtable<>();
    private final List<Provider> providers = new ArrayList();
    private final Map<String, Provider> providersByProtocol = new HashMap();
    private final Map<String, Provider> providersByClassName = new HashMap();
    private final Properties addressMap = new Properties();

    static {
        String str;
        try {
            str = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: javax.mail.Session.1
                @Override // java.security.PrivilegedAction
                public String run() {
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

    private Session(Properties properties, Authenticator authenticator) throws Throwable {
        this.debug = false;
        this.props = properties;
        this.authenticator = authenticator;
        if (Boolean.valueOf(properties.getProperty("mail.debug")).booleanValue()) {
            this.debug = true;
        }
        initLogger();
        this.logger.log(Level.CONFIG, "Jakarta Mail version {0}", Version.version);
        Class cls = authenticator != null ? authenticator.getClass() : Session.class;
        loadProviders(cls);
        loadAddressMap(cls);
        this.f14926q = new EventQueue((Executor) properties.get("mail.event.executor"));
    }

    public static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: javax.mail.Session.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                try {
                    return Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused) {
                    return null;
                }
            }
        });
    }

    public static synchronized Session getDefaultInstance(Properties properties, Authenticator authenticator) {
        Session session = defaultSession;
        if (session == null) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkSetFactory();
            }
            defaultSession = new Session(properties, authenticator);
        } else {
            Authenticator authenticator2 = session.authenticator;
            if (authenticator2 != authenticator && (authenticator2 == null || authenticator == null || authenticator2.getClass().getClassLoader() != authenticator.getClass().getClassLoader())) {
                throw new SecurityException("Access to default session denied");
            }
        }
        return defaultSession;
    }

    public static Session getInstance(Properties properties, Authenticator authenticator) {
        return new Session(properties, authenticator);
    }

    private static InputStream getResourceAsStream(final Class<?> cls, final String str) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<InputStream>() { // from class: javax.mail.Session.5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public InputStream run() throws IOException {
                    try {
                        return cls.getResourceAsStream(str);
                    } catch (RuntimeException e2) {
                        IOException iOException = new IOException("ClassLoader.getResourceAsStream failed");
                        iOException.initCause(e2);
                        throw iOException;
                    }
                }
            });
        } catch (PrivilegedActionException e2) {
            throw ((IOException) e2.getException());
        }
    }

    private static URL[] getResources(final ClassLoader classLoader, final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction<URL[]>() { // from class: javax.mail.Session.6
            @Override // java.security.PrivilegedAction
            public URL[] run() {
                URL[] urlArr = null;
                try {
                    ArrayList list = Collections.list(classLoader.getResources(str));
                    if (list.isEmpty()) {
                        return null;
                    }
                    urlArr = new URL[list.size()];
                    list.toArray(urlArr);
                    return urlArr;
                } catch (IOException | SecurityException unused) {
                    return urlArr;
                }
            }
        });
    }

    private <T extends Service> T getService(Provider provider, URLName uRLName, Class<T> cls) throws NoSuchProviderException {
        if (provider == null) {
            throw new NoSuchProviderException("null");
        }
        if (uRLName == null) {
            uRLName = new URLName(provider.getProtocol(), null, -1, null, null, null);
        }
        Authenticator authenticator = this.authenticator;
        ClassLoader classLoader = authenticator != null ? authenticator.getClass().getClassLoader() : Session.class.getClassLoader();
        Class<?> cls2 = null;
        try {
            try {
                ClassLoader contextClassLoader = getContextClassLoader();
                if (contextClassLoader != null) {
                    try {
                        cls2 = Class.forName(provider.getClassName(), false, contextClassLoader);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                if (cls2 == null || !cls.isAssignableFrom(cls2)) {
                    cls2 = Class.forName(provider.getClassName(), false, classLoader);
                }
                if (!cls.isAssignableFrom(cls2)) {
                    throw new ClassCastException(cls.getName() + " " + cls2.getName());
                }
            } catch (Exception e2) {
                this.logger.log(Level.FINE, "Exception loading provider", (Throwable) e2);
                throw new NoSuchProviderException(provider.getProtocol());
            }
        } catch (Exception unused2) {
            cls2 = Class.forName(provider.getClassName());
            if (!cls.isAssignableFrom(cls2)) {
                throw new ClassCastException(cls.getName() + " " + cls2.getName());
            }
        }
        try {
            return cls.cast(cls2.getConstructor(Session.class, URLName.class).newInstance(this, uRLName));
        } catch (Exception e3) {
            this.logger.log(Level.FINE, "Exception loading provider", (Throwable) e3);
            throw new NoSuchProviderException(provider.getProtocol());
        }
    }

    private static URL[] getSystemResources(final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction<URL[]>() { // from class: javax.mail.Session.7
            @Override // java.security.PrivilegedAction
            public URL[] run() {
                URL[] urlArr = null;
                try {
                    ArrayList list = Collections.list(ClassLoader.getSystemResources(str));
                    if (list.isEmpty()) {
                        return null;
                    }
                    urlArr = new URL[list.size()];
                    list.toArray(urlArr);
                    return urlArr;
                } catch (IOException | SecurityException unused) {
                    return urlArr;
                }
            }
        });
    }

    private final synchronized void initLogger() {
        this.logger = new MailLogger(getClass(), "DEBUG", this.debug, getDebugOut());
    }

    private void loadAddressMap(Class<?> cls) throws Throwable {
        StreamLoader streamLoader = new StreamLoader() { // from class: javax.mail.Session.3
            @Override // javax.mail.StreamLoader
            public void load(InputStream inputStream) throws IOException {
                Session.this.addressMap.load(inputStream);
            }
        };
        loadResource("/META-INF/javamail.default.address.map", cls, streamLoader, true);
        loadAllResources("META-INF/javamail.address.map", cls, streamLoader);
        try {
            String str = confDir;
            if (str != null) {
                loadFile(str + "javamail.address.map", streamLoader);
            }
        } catch (SecurityException unused) {
        }
        if (this.addressMap.isEmpty()) {
            this.logger.config("failed to load address map, using defaults");
            this.addressMap.put("rfc822", "smtp");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadAllResources(java.lang.String r11, java.lang.Class<?> r12, javax.mail.StreamLoader r13) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "Exception loading resource"
            r1 = 0
            java.lang.ClassLoader r2 = getContextClassLoader()     // Catch: java.lang.Exception -> L8a
            if (r2 != 0) goto Ld
            java.lang.ClassLoader r2 = r12.getClassLoader()     // Catch: java.lang.Exception -> L8a
        Ld:
            if (r2 == 0) goto L14
            java.net.URL[] r2 = getResources(r2, r11)     // Catch: java.lang.Exception -> L8a
            goto L18
        L14:
            java.net.URL[] r2 = getSystemResources(r11)     // Catch: java.lang.Exception -> L8a
        L18:
            if (r2 == 0) goto L88
            r3 = 0
            r4 = 0
        L1c:
            int r5 = r2.length     // Catch: java.lang.Exception -> L86
            if (r3 >= r5) goto L93
            r5 = r2[r3]     // Catch: java.lang.Exception -> L86
            r6 = 0
            com.sun.mail.util.MailLogger r7 = r10.logger     // Catch: java.lang.Exception -> L86
            java.util.logging.Level r8 = java.util.logging.Level.CONFIG     // Catch: java.lang.Exception -> L86
            java.lang.String r9 = "URL {0}"
            r7.log(r8, r9, r5)     // Catch: java.lang.Exception -> L86
            r7 = 1
            java.io.InputStream r6 = openStream(r5)     // Catch: java.lang.Throwable -> L54 java.lang.SecurityException -> L56 java.io.IOException -> L63 java.io.FileNotFoundException -> L80
            if (r6 == 0) goto L47
            r13.load(r6)     // Catch: java.lang.Throwable -> L54 java.lang.SecurityException -> L56 java.io.IOException -> L63 java.io.FileNotFoundException -> L80
            com.sun.mail.util.MailLogger r4 = r10.logger     // Catch: java.lang.Throwable -> L3e java.lang.SecurityException -> L41 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            java.lang.String r9 = "successfully loaded resource: {0}"
            r4.log(r8, r9, r5)     // Catch: java.lang.Throwable -> L3e java.lang.SecurityException -> L41 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r4 = 1
            goto L4e
        L3e:
            r2 = move-exception
            r4 = 1
            goto L7a
        L41:
            r4 = move-exception
            goto L59
        L43:
            r4 = move-exception
            goto L66
        L45:
            r4 = 1
            goto L80
        L47:
            com.sun.mail.util.MailLogger r7 = r10.logger     // Catch: java.lang.Throwable -> L54 java.lang.SecurityException -> L56 java.io.IOException -> L63 java.io.FileNotFoundException -> L80
            java.lang.String r9 = "not loading resource: {0}"
            r7.log(r8, r9, r5)     // Catch: java.lang.Throwable -> L54 java.lang.SecurityException -> L56 java.io.IOException -> L63 java.io.FileNotFoundException -> L80
        L4e:
            if (r6 == 0) goto L83
        L50:
            r6.close()     // Catch: java.io.IOException -> L83 java.lang.Exception -> L86
            goto L83
        L54:
            r2 = move-exception
            goto L7a
        L56:
            r5 = move-exception
            r7 = r4
            r4 = r5
        L59:
            com.sun.mail.util.MailLogger r5 = r10.logger     // Catch: java.lang.Throwable -> L78
            java.util.logging.Level r8 = java.util.logging.Level.CONFIG     // Catch: java.lang.Throwable -> L78
            r5.log(r8, r0, r4)     // Catch: java.lang.Throwable -> L78
            if (r6 == 0) goto L76
            goto L6f
        L63:
            r5 = move-exception
            r7 = r4
            r4 = r5
        L66:
            com.sun.mail.util.MailLogger r5 = r10.logger     // Catch: java.lang.Throwable -> L78
            java.util.logging.Level r8 = java.util.logging.Level.CONFIG     // Catch: java.lang.Throwable -> L78
            r5.log(r8, r0, r4)     // Catch: java.lang.Throwable -> L78
            if (r6 == 0) goto L76
        L6f:
            r6.close()     // Catch: java.lang.Exception -> L73 java.io.IOException -> L76
            goto L76
        L73:
            r2 = move-exception
            r4 = r7
            goto L8c
        L76:
            r4 = r7
            goto L83
        L78:
            r2 = move-exception
            r4 = r7
        L7a:
            if (r6 == 0) goto L7f
            r6.close()     // Catch: java.io.IOException -> L7f java.lang.Exception -> L86
        L7f:
            throw r2     // Catch: java.lang.Exception -> L86
        L80:
            if (r6 == 0) goto L83
            goto L50
        L83:
            int r3 = r3 + 1
            goto L1c
        L86:
            r2 = move-exception
            goto L8c
        L88:
            r4 = 0
            goto L93
        L8a:
            r2 = move-exception
            r4 = 0
        L8c:
            com.sun.mail.util.MailLogger r3 = r10.logger
            java.util.logging.Level r5 = java.util.logging.Level.CONFIG
            r3.log(r5, r0, r2)
        L93:
            if (r4 != 0) goto La9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "/"
            r0.append(r2)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r10.loadResource(r11, r12, r13, r1)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.loadAllResources(java.lang.String, java.lang.Class, javax.mail.StreamLoader):void");
    }

    private void loadFile(String str, StreamLoader streamLoader) throws Throwable {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
                    try {
                        streamLoader.load(bufferedInputStream2);
                        this.logger.log(Level.CONFIG, "successfully loaded file: {0}", str);
                        bufferedInputStream2.close();
                    } catch (FileNotFoundException unused) {
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream == null) {
                            return;
                        }
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        bufferedInputStream = bufferedInputStream2;
                        MailLogger mailLogger = this.logger;
                        Level level = Level.CONFIG;
                        if (mailLogger.isLoggable(level)) {
                            this.logger.log(level, "not loading file: " + str, (Throwable) e);
                        }
                        if (bufferedInputStream == null) {
                            return;
                        }
                        bufferedInputStream.close();
                    } catch (SecurityException e3) {
                        e = e3;
                        bufferedInputStream = bufferedInputStream2;
                        MailLogger mailLogger2 = this.logger;
                        Level level2 = Level.CONFIG;
                        if (mailLogger2.isLoggable(level2)) {
                            this.logger.log(level2, "not loading file: " + str, (Throwable) e);
                        }
                        if (bufferedInputStream == null) {
                            return;
                        }
                        bufferedInputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused3) {
                } catch (IOException e4) {
                    e = e4;
                } catch (SecurityException e5) {
                    e = e5;
                }
            } catch (IOException unused4) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void loadProviders(Class<?> cls) throws Throwable {
        StreamLoader streamLoader = new StreamLoader() { // from class: javax.mail.Session.2
            @Override // javax.mail.StreamLoader
            public void load(InputStream inputStream) throws IOException {
                Session.this.loadProvidersFromStream(inputStream);
            }
        };
        try {
            String str = confDir;
            if (str != null) {
                loadFile(str + "javamail.providers", streamLoader);
            }
        } catch (SecurityException unused) {
        }
        for (Provider provider : ServiceLoader.load(Provider.class)) {
            if (!provider.getClass().isAnnotationPresent(DefaultProvider.class)) {
                addProvider(provider);
            }
        }
        loadAllResources("META-INF/javamail.providers", cls, streamLoader);
        loadResource("/META-INF/javamail.default.providers", cls, streamLoader, false);
        for (Provider provider2 : ServiceLoader.load(Provider.class)) {
            if (provider2.getClass().isAnnotationPresent(DefaultProvider.class)) {
                addProvider(provider2);
            }
        }
        if (this.providers.size() == 0) {
            this.logger.config("failed to load any providers, using defaults");
            Provider.Type type = Provider.Type.STORE;
            addProvider(new Provider(type, "imap", "com.sun.mail.imap.IMAPStore", "Oracle", Version.version));
            addProvider(new Provider(type, "imaps", "com.sun.mail.imap.IMAPSSLStore", "Oracle", Version.version));
            addProvider(new Provider(type, "pop3", "com.sun.mail.pop3.POP3Store", "Oracle", Version.version));
            addProvider(new Provider(type, "pop3s", "com.sun.mail.pop3.POP3SSLStore", "Oracle", Version.version));
            Provider.Type type2 = Provider.Type.TRANSPORT;
            addProvider(new Provider(type2, "smtp", "com.sun.mail.smtp.SMTPTransport", "Oracle", Version.version));
            addProvider(new Provider(type2, "smtps", "com.sun.mail.smtp.SMTPSSLTransport", "Oracle", Version.version));
        }
        if (this.logger.isLoggable(Level.CONFIG)) {
            this.logger.config("Tables of loaded providers");
            this.logger.config("Providers Listed By Class Name: " + this.providersByClassName.toString());
            this.logger.config("Providers Listed By Protocol: " + this.providersByProtocol.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadProvidersFromStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return;
        }
        LineInputStream lineInputStream = new LineInputStream(inputStream);
        while (true) {
            String line = lineInputStream.readLine();
            if (line == null) {
                return;
            }
            if (!line.startsWith("#") && line.trim().length() != 0) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, i.f5697b);
                Provider.Type type = null;
                String strSubstring = null;
                String strSubstring2 = null;
                String strSubstring3 = null;
                String strSubstring4 = null;
                while (stringTokenizer.hasMoreTokens()) {
                    String strTrim = stringTokenizer.nextToken().trim();
                    int iIndexOf = strTrim.indexOf("=");
                    if (strTrim.startsWith("protocol=")) {
                        strSubstring = strTrim.substring(iIndexOf + 1);
                    } else if (strTrim.startsWith("type=")) {
                        String strSubstring5 = strTrim.substring(iIndexOf + 1);
                        if (strSubstring5.equalsIgnoreCase("store")) {
                            type = Provider.Type.STORE;
                        } else if (strSubstring5.equalsIgnoreCase(NotificationCompat.CATEGORY_TRANSPORT)) {
                            type = Provider.Type.TRANSPORT;
                        }
                    } else if (strTrim.startsWith("class=")) {
                        strSubstring2 = strTrim.substring(iIndexOf + 1);
                    } else if (strTrim.startsWith("vendor=")) {
                        strSubstring3 = strTrim.substring(iIndexOf + 1);
                    } else if (strTrim.startsWith("version=")) {
                        strSubstring4 = strTrim.substring(iIndexOf + 1);
                    }
                }
                if (type == null || strSubstring == null || strSubstring2 == null || strSubstring.length() <= 0 || strSubstring2.length() <= 0) {
                    this.logger.log(Level.CONFIG, "Bad provider entry: {0}", line);
                } else {
                    addProvider(new Provider(type, strSubstring, strSubstring2, strSubstring3, strSubstring4));
                }
            }
        }
    }

    private void loadResource(String str, Class<?> cls, StreamLoader streamLoader, boolean z) {
        InputStream resourceAsStream = null;
        try {
            try {
                resourceAsStream = getResourceAsStream(cls, str);
                if (resourceAsStream != null) {
                    streamLoader.load(resourceAsStream);
                    this.logger.log(Level.CONFIG, "successfully loaded resource: {0}", str);
                } else if (z) {
                    this.logger.log(Level.WARNING, "expected resource not found: {0}", str);
                }
                if (resourceAsStream == null) {
                    return;
                }
            } catch (IOException e2) {
                this.logger.log(Level.CONFIG, "Exception loading resource", (Throwable) e2);
                if (0 == 0) {
                    return;
                }
            } catch (SecurityException e3) {
                this.logger.log(Level.CONFIG, "Exception loading resource", (Throwable) e3);
                if (0 == 0) {
                    return;
                }
            }
            try {
                resourceAsStream.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    resourceAsStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    private static InputStream openStream(final URL url) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<InputStream>() { // from class: javax.mail.Session.8
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public InputStream run() throws IOException {
                    return url.openStream();
                }
            });
        } catch (PrivilegedActionException e2) {
            throw ((IOException) e2.getException());
        }
    }

    public synchronized void addProvider(Provider provider) {
        this.providers.add(provider);
        this.providersByClassName.put(provider.getClassName(), provider);
        if (!this.providersByProtocol.containsKey(provider.getProtocol())) {
            this.providersByProtocol.put(provider.getProtocol(), provider);
        }
    }

    public synchronized boolean getDebug() {
        return this.debug;
    }

    public synchronized PrintStream getDebugOut() {
        PrintStream printStream = this.out;
        if (printStream != null) {
            return printStream;
        }
        return System.out;
    }

    public EventQueue getEventQueue() {
        return this.f14926q;
    }

    public Folder getFolder(URLName uRLName) throws MessagingException {
        Store store = getStore(uRLName);
        store.connect();
        return store.getFolder(uRLName);
    }

    public PasswordAuthentication getPasswordAuthentication(URLName uRLName) {
        return this.authTable.get(uRLName);
    }

    public Properties getProperties() {
        return this.props;
    }

    public String getProperty(String str) {
        return this.props.getProperty(str);
    }

    public synchronized Provider getProvider(String str) throws NoSuchProviderException {
        if (str != null) {
            if (str.length() > 0) {
                Provider provider = null;
                String property = this.props.getProperty("mail." + str + ".class");
                if (property != null) {
                    if (this.logger.isLoggable(Level.FINE)) {
                        this.logger.fine("mail." + str + ".class property exists and points to " + property);
                    }
                    provider = this.providersByClassName.get(property);
                }
                if (provider != null) {
                    return provider;
                }
                Provider provider2 = this.providersByProtocol.get(str);
                if (provider2 == null) {
                    throw new NoSuchProviderException("No provider for " + str);
                }
                if (this.logger.isLoggable(Level.FINE)) {
                    this.logger.fine("getProvider() returning " + provider2.toString());
                }
                return provider2;
            }
        }
        throw new NoSuchProviderException("Invalid protocol: null");
    }

    public synchronized Provider[] getProviders() {
        Provider[] providerArr;
        providerArr = new Provider[this.providers.size()];
        this.providers.toArray(providerArr);
        return providerArr;
    }

    public Store getStore() throws NoSuchProviderException {
        return getStore(getProperty("mail.store.protocol"));
    }

    public Transport getTransport() throws NoSuchProviderException {
        String property = getProperty("mail.transport.protocol");
        if (property != null) {
            return getTransport(property);
        }
        String str = (String) this.addressMap.get("rfc822");
        return str != null ? getTransport(str) : getTransport("smtp");
    }

    public PasswordAuthentication requestPasswordAuthentication(InetAddress inetAddress, int i2, String str, String str2, String str3) {
        Authenticator authenticator = this.authenticator;
        if (authenticator != null) {
            return authenticator.requestPasswordAuthentication(inetAddress, i2, str, str2, str3);
        }
        return null;
    }

    public synchronized void setDebug(boolean z) {
        this.debug = z;
        initLogger();
        this.logger.log(Level.CONFIG, "setDebug: Jakarta Mail version {0}", Version.version);
    }

    public synchronized void setDebugOut(PrintStream printStream) {
        this.out = printStream;
        initLogger();
    }

    public void setPasswordAuthentication(URLName uRLName, PasswordAuthentication passwordAuthentication) {
        if (passwordAuthentication == null) {
            this.authTable.remove(uRLName);
        } else {
            this.authTable.put(uRLName, passwordAuthentication);
        }
    }

    public synchronized void setProtocolForAddress(String str, String str2) {
        if (str2 == null) {
            this.addressMap.remove(str);
        } else {
            this.addressMap.put(str, str2);
        }
    }

    public synchronized void setProvider(Provider provider) throws NoSuchProviderException {
        if (provider == null) {
            throw new NoSuchProviderException("Can't set null provider");
        }
        this.providersByProtocol.put(provider.getProtocol(), provider);
        this.providersByClassName.put(provider.getClassName(), provider);
        this.props.put("mail." + provider.getProtocol() + ".class", provider.getClassName());
    }

    public static Session getInstance(Properties properties) {
        return new Session(properties, null);
    }

    public Store getStore(String str) throws NoSuchProviderException {
        return getStore(new URLName(str, null, -1, null, null, null));
    }

    public Store getStore(URLName uRLName) throws NoSuchProviderException {
        return getStore(getProvider(uRLName.getProtocol()), uRLName);
    }

    public Store getStore(Provider provider) throws NoSuchProviderException {
        return getStore(provider, null);
    }

    public Transport getTransport(String str) throws NoSuchProviderException {
        return getTransport(new URLName(str, null, -1, null, null, null));
    }

    private Store getStore(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider != null && provider.getType() == Provider.Type.STORE) {
            return (Store) getService(provider, uRLName, Store.class);
        }
        throw new NoSuchProviderException("invalid provider");
    }

    public Transport getTransport(URLName uRLName) throws NoSuchProviderException {
        return getTransport(getProvider(uRLName.getProtocol()), uRLName);
    }

    public static Session getDefaultInstance(Properties properties) {
        return getDefaultInstance(properties, null);
    }

    public Transport getTransport(Provider provider) throws NoSuchProviderException {
        return getTransport(provider, null);
    }

    public Transport getTransport(Address address) throws NoSuchProviderException {
        String property = getProperty("mail.transport.protocol." + address.getType());
        if (property != null) {
            return getTransport(property);
        }
        String str = (String) this.addressMap.get(address.getType());
        if (str != null) {
            return getTransport(str);
        }
        throw new NoSuchProviderException("No provider for Address type: " + address.getType());
    }

    private Transport getTransport(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider != null && provider.getType() == Provider.Type.TRANSPORT) {
            return (Transport) getService(provider, uRLName, Transport.class);
        }
        throw new NoSuchProviderException("invalid provider");
    }
}
