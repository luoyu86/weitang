package com.sun.mail.util.logging;

import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;
import javax.activation.DataHandler;
import javax.activation.FileTypeMap;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessageContext;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Service;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;

/* JADX INFO: loaded from: classes2.dex */
public class MailHandler extends Handler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MIN_HEADER_SIZE = 1024;
    private volatile Filter[] attachmentFilters;
    private Formatter[] attachmentFormatters;
    private Formatter[] attachmentNames;
    private Authenticator auth;
    private int capacity;
    private Comparator<? super LogRecord> comparator;
    private FileTypeMap contentTypes;
    private LogRecord[] data;
    private String encoding;
    private volatile Filter filter;
    private Formatter formatter;
    private boolean isWriting;
    private Properties mailProps;
    private int[] matched;
    private Filter pushFilter;
    private Level pushLevel;
    private volatile boolean sealed;
    private Session session;
    private int size;
    private Formatter subjectFormatter;
    private static final Filter[] EMPTY_FILTERS = new Filter[0];
    private static final Formatter[] EMPTY_FORMATTERS = new Formatter[0];
    private static final int offValue = Level.OFF.intValue();
    private static final PrivilegedAction<Object> MAILHANDLER_LOADER = new GetAndSetContext(MailHandler.class);
    private static final ThreadLocal<Integer> MUTEX = new ThreadLocal<>();
    private static final Integer MUTEX_PUBLISH = -2;
    private static final Integer MUTEX_REPORT = -4;
    private static final Integer MUTEX_LINKAGE = -8;
    private volatile Level logLevel = Level.ALL;
    private volatile ErrorManager errorManager = defaultErrorManager();

    public static final class DefaultAuthenticator extends Authenticator {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String pass;

        private DefaultAuthenticator(String str) {
            this.pass = str;
        }

        public static Authenticator of(String str) {
            return new DefaultAuthenticator(str);
        }

        @Override // javax.mail.Authenticator
        public final PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(getDefaultUserName(), this.pass);
        }
    }

    public static final class GetAndSetContext implements PrivilegedAction<Object> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final Object NOT_MODIFIED = GetAndSetContext.class;
        private final Object source;

        public GetAndSetContext(Object obj) {
            this.source = obj;
        }

        @Override // java.security.PrivilegedAction
        public final Object run() {
            Thread threadCurrentThread = Thread.currentThread();
            ClassLoader contextClassLoader = threadCurrentThread.getContextClassLoader();
            Object obj = this.source;
            ClassLoader classLoader = obj == null ? null : obj instanceof ClassLoader ? (ClassLoader) obj : obj instanceof Class ? ((Class) obj).getClassLoader() : obj instanceof Thread ? ((Thread) obj).getContextClassLoader() : obj.getClass().getClassLoader();
            if (contextClassLoader == classLoader) {
                return NOT_MODIFIED;
            }
            threadCurrentThread.setContextClassLoader(classLoader);
            return contextClassLoader;
        }
    }

    public static final class TailNameFormatter extends Formatter {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String name;

        private TailNameFormatter(String str) {
            this.name = str;
        }

        public static Formatter of(String str) {
            return new TailNameFormatter(str);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof TailNameFormatter) {
                return this.name.equals(((TailNameFormatter) obj).name);
            }
            return false;
        }

        @Override // java.util.logging.Formatter
        public final String format(LogRecord logRecord) {
            return "";
        }

        @Override // java.util.logging.Formatter
        public final String getTail(Handler handler) {
            return this.name;
        }

        public final int hashCode() {
            return TailNameFormatter.class.hashCode() + this.name.hashCode();
        }

        public final String toString() {
            return this.name;
        }
    }

    public MailHandler() {
        init(null);
        this.sealed = true;
        checkAccess();
    }

    private boolean alignAttachmentFilters() {
        int length = this.attachmentFormatters.length;
        int length2 = this.attachmentFilters.length;
        if (length2 != length) {
            this.attachmentFilters = (Filter[]) Arrays.copyOf(this.attachmentFilters, length, Filter[].class);
            clearMatches(length2);
            z = length2 != 0;
            Filter filter = this.filter;
            if (filter != null) {
                while (length2 < length) {
                    this.attachmentFilters[length2] = filter;
                    length2++;
                }
            }
        }
        if (length == 0) {
            this.attachmentFilters = emptyFilterArray();
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean alignAttachmentNames() {
        /*
            r5 = this;
            java.util.logging.Formatter[] r0 = r5.attachmentFormatters
            int r0 = r0.length
            java.util.logging.Formatter[] r1 = r5.attachmentNames
            int r2 = r1.length
            r3 = 0
            if (r2 == r0) goto L17
            java.lang.Class<java.util.logging.Formatter[]> r4 = java.util.logging.Formatter[].class
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r0, r4)
            java.util.logging.Formatter[] r1 = (java.util.logging.Formatter[]) r1
            r5.attachmentNames = r1
            if (r2 == 0) goto L17
            r1 = 1
            goto L18
        L17:
            r1 = 0
        L18:
            if (r0 != 0) goto L21
            java.util.logging.Formatter[] r0 = emptyFormatterArray()
            r5.attachmentNames = r0
            goto L3a
        L21:
            if (r3 >= r0) goto L3a
            java.util.logging.Formatter[] r2 = r5.attachmentNames
            r4 = r2[r3]
            if (r4 != 0) goto L37
            java.util.logging.Formatter[] r4 = r5.attachmentFormatters
            r4 = r4[r3]
            java.lang.String r4 = r5.toString(r4)
            java.util.logging.Formatter r4 = com.sun.mail.util.logging.MailHandler.TailNameFormatter.of(r4)
            r2[r3] = r4
        L37:
            int r3 = r3 + 1
            goto L21
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.MailHandler.alignAttachmentNames():boolean");
    }

    private boolean allowRestrictedHeaders() {
        return LogManagerProperties.hasLogManager();
    }

    private void appendContentLang(MimePart mimePart, Locale locale) {
        try {
            String languageTag = LogManagerProperties.toLanguageTag(locale);
            if (languageTag.length() != 0) {
                String header = mimePart.getHeader("Content-Language", null);
                if (isEmpty(header)) {
                    mimePart.setHeader("Content-Language", languageTag);
                    return;
                }
                if (header.equalsIgnoreCase(languageTag)) {
                    return;
                }
                String strConcat = ",".concat(languageTag);
                int iIndexOf = 0;
                do {
                    iIndexOf = header.indexOf(strConcat, iIndexOf);
                    if (iIndexOf <= -1 || (iIndexOf = iIndexOf + strConcat.length()) == header.length()) {
                        break;
                    }
                } while (header.charAt(iIndexOf) != ',');
                if (iIndexOf < 0) {
                    int iLastIndexOf = header.lastIndexOf("\r\n\t");
                    mimePart.setHeader("Content-Language", (iLastIndexOf < 0 ? header.length() + 20 : (header.length() - iLastIndexOf) + 8) + strConcat.length() > 76 ? header.concat("\r\n\t".concat(strConcat)) : header.concat(strConcat));
                }
            }
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private void appendFileName(Part part, String str) {
        if (str == null) {
            reportNullError(5);
        } else if (str.length() > 0) {
            appendFileName0(part, str);
        }
    }

    private void appendFileName0(Part part, String str) {
        try {
            String strReplaceAll = str.replaceAll("[\\x00-\\x1F\\x7F]+", "");
            String fileName = part.getFileName();
            if (fileName != null) {
                strReplaceAll = fileName.concat(strReplaceAll);
            }
            part.setFileName(strReplaceAll);
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private void appendSubject(Message message, String str) {
        if (str == null) {
            reportNullError(5);
        } else if (str.length() > 0) {
            appendSubject0(message, str);
        }
    }

    private void appendSubject0(Message message, String str) {
        try {
            String strReplaceAll = str.replaceAll("[\\x00-\\x1F\\x7F]+", "");
            String encodingName = getEncodingName();
            String subject = message.getSubject();
            MimeMessage mimeMessage = (MimeMessage) message;
            if (subject != null) {
                strReplaceAll = subject.concat(strReplaceAll);
            }
            mimeMessage.setSubject(strReplaceAll, MimeUtility.mimeCharset(encodingName));
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private static String atIndexMsg(int i2) {
        return "At index: " + i2 + '.';
    }

    private static MessagingException attach(MessagingException messagingException, Exception exc) {
        if (exc != null && !messagingException.setNextException(exc)) {
            if (exc instanceof MessagingException) {
                MessagingException messagingException2 = (MessagingException) exc;
                if (messagingException2.setNextException(messagingException)) {
                    return messagingException2;
                }
            }
            if (exc != messagingException) {
                messagingException.addSuppressed(exc);
            }
        }
        return messagingException;
    }

    private static RuntimeException attachmentMismatch(String str) {
        return new IndexOutOfBoundsException(str);
    }

    private void checkAccess() {
        if (this.sealed) {
            LogManagerProperties.checkLogManagerAccess();
        }
    }

    private void clearMatches(int i2) {
        for (int i3 = 0; i3 < this.size; i3++) {
            int[] iArr = this.matched;
            if (iArr[i3] >= i2) {
                iArr[i3] = MUTEX_PUBLISH.intValue();
            }
        }
    }

    private String contentWithEncoding(String str, String str2) {
        try {
            ContentType contentType = new ContentType(str);
            contentType.setParameter("charset", MimeUtility.mimeCharset(str2));
            String string = contentType.toString();
            return !isEmpty(string) ? string : str;
        } catch (MessagingException e2) {
            reportError(str, e2, 5);
            return str;
        }
    }

    private MimeBodyPart createBodyPart() throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDisposition(Part.INLINE);
        mimeBodyPart.setDescription(descriptionFrom(getFormatter(), getFilter(), this.subjectFormatter));
        setAcceptLang(mimeBodyPart);
        return mimeBodyPart;
    }

    private static Formatter createSimpleFormatter() {
        return (Formatter) Formatter.class.cast(new SimpleFormatter());
    }

    private ErrorManager defaultErrorManager() {
        ErrorManager errorManager;
        try {
            errorManager = super.getErrorManager();
        } catch (LinkageError | RuntimeException unused) {
            errorManager = null;
        }
        return errorManager == null ? new ErrorManager() : errorManager;
    }

    private String descriptionFrom(Comparator<?> comparator, Level level, Filter filter) {
        StringBuilder sb = new StringBuilder();
        sb.append("Sorted using ");
        sb.append(comparator == null ? "no comparator" : comparator.getClass().getName());
        sb.append(", pushed when ");
        sb.append(level.getName());
        sb.append(", and ");
        sb.append(filter == null ? "no push filter" : filter.getClass().getName());
        sb.append('.');
        return sb.toString();
    }

    private static Filter[] emptyFilterArray() {
        return EMPTY_FILTERS;
    }

    private static Formatter[] emptyFormatterArray() {
        return EMPTY_FORMATTERS;
    }

    private void envelopeFor(Message message, boolean z) {
        setAcceptLang(message);
        setFrom(message);
        Message.RecipientType recipientType = Message.RecipientType.TO;
        if (!setRecipient(message, "mail.to", recipientType)) {
            setDefaultRecipient(message, recipientType);
        }
        setRecipient(message, "mail.cc", Message.RecipientType.CC);
        setRecipient(message, "mail.bcc", Message.RecipientType.BCC);
        setReplyTo(message);
        setSender(message);
        setMailer(message);
        setAutoSubmitted(message);
        if (z) {
            setPriority(message);
        }
        try {
            message.setSentDate(new Date());
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private String format(Formatter formatter, LogRecord logRecord) {
        try {
            return formatter.format(logRecord);
        } catch (RuntimeException e2) {
            reportError(e2.getMessage(), e2, 5);
            return "";
        }
    }

    private Object getAndSetContextClassLoader(Object obj) {
        if (obj != GetAndSetContext.NOT_MODIFIED) {
            try {
                return AccessController.doPrivileged(obj instanceof PrivilegedAction ? (PrivilegedAction) obj : new GetAndSetContext(obj));
            } catch (SecurityException unused) {
            }
        }
        return GetAndSetContext.NOT_MODIFIED;
    }

    private String getClassId(Formatter formatter) {
        return formatter instanceof TailNameFormatter ? String.class.getName() : formatter.getClass().getName();
    }

    private String getContentType(String str) {
        String contentType = this.contentTypes.getContentType(str);
        if (OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE.equalsIgnoreCase(contentType)) {
            return null;
        }
        return contentType;
    }

    private String getEncodingName() {
        String encoding = getEncoding();
        return encoding == null ? MimeUtility.getDefaultJavaCharset() : encoding;
    }

    private String getLocalHost(Service service) {
        try {
            return LogManagerProperties.getLocalHost(service);
        } catch (Exception e2) {
            reportError(service.toString(), e2, 4);
            return null;
        } catch (LinkageError | NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    private int getMatchedPart() {
        Integer num = MUTEX.get();
        if (num == null || num.intValue() >= readOnlyAttachmentFilters().length) {
            num = MUTEX_PUBLISH;
        }
        return num.intValue();
    }

    private Session getSession(Message message) {
        Objects.requireNonNull(message);
        return new MessageContext(message).getSession();
    }

    private void grow() {
        LogRecord[] logRecordArr = this.data;
        int length = logRecordArr.length;
        int i2 = (length >> 1) + length + 1;
        int i3 = this.capacity;
        if (i2 > i3 || i2 < length) {
            i2 = i3;
        }
        this.data = (LogRecord[]) Arrays.copyOf(logRecordArr, i2, LogRecord[].class);
        this.matched = Arrays.copyOf(this.matched, i2);
    }

    private static boolean hasValue(String str) {
        return (isEmpty(str) || "null".equalsIgnoreCase(str)) ? false : true;
    }

    private String head(Formatter formatter) {
        try {
            return formatter.getHead(this);
        } catch (RuntimeException e2) {
            reportError(e2.getMessage(), e2, 5);
            return "";
        }
    }

    private synchronized void init(Properties properties) {
        String name = getClass().getName();
        this.mailProps = new Properties();
        Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
        try {
            this.contentTypes = FileTypeMap.getDefaultFileTypeMap();
            getAndSetContextClassLoader(andSetContextClassLoader);
            initErrorManager(name);
            initLevel(name);
            initFilter(name);
            initCapacity(name);
            initAuthenticator(name);
            initEncoding(name);
            initFormatter(name);
            initComparator(name);
            initPushLevel(name);
            initPushFilter(name);
            initSubject(name);
            initAttachmentFormaters(name);
            initAttachmentFilters(name);
            initAttachmentNames(name);
            if (properties == null && LogManagerProperties.fromLogManager(name.concat(".verify")) != null) {
                verifySettings(initSession());
            }
            intern();
        } catch (Throwable th) {
            getAndSetContextClassLoader(andSetContextClassLoader);
            throw th;
        }
    }

    private void initAttachmentFilters(String str) {
        String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".attachment.filters"));
        if (isEmpty(strFromLogManager)) {
            this.attachmentFilters = emptyFilterArray();
            alignAttachmentFilters();
            return;
        }
        String[] strArrSplit = strFromLogManager.split(",");
        int length = strArrSplit.length;
        Filter[] filterArr = new Filter[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArrSplit[i2] = strArrSplit[i2].trim();
            if (!"null".equalsIgnoreCase(strArrSplit[i2])) {
                try {
                    filterArr[i2] = LogManagerProperties.newFilter(strArrSplit[i2]);
                } catch (SecurityException e2) {
                    throw e2;
                } catch (Exception e3) {
                    reportError(e3.getMessage(), e3, 4);
                }
            }
        }
        this.attachmentFilters = filterArr;
        if (alignAttachmentFilters()) {
            reportError("Attachment filters.", attachmentMismatch("Length mismatch."), 4);
        }
    }

    private void initAttachmentFormaters(String str) {
        String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".attachment.formatters"));
        if (isEmpty(strFromLogManager)) {
            this.attachmentFormatters = emptyFormatterArray();
            return;
        }
        String[] strArrSplit = strFromLogManager.split(",");
        Formatter[] formatterArrEmptyFormatterArray = strArrSplit.length == 0 ? emptyFormatterArray() : new Formatter[strArrSplit.length];
        for (int i2 = 0; i2 < formatterArrEmptyFormatterArray.length; i2++) {
            strArrSplit[i2] = strArrSplit[i2].trim();
            if ("null".equalsIgnoreCase(strArrSplit[i2])) {
                reportError("Attachment formatter.", new NullPointerException(atIndexMsg(i2)), 4);
                formatterArrEmptyFormatterArray[i2] = createSimpleFormatter();
            } else {
                try {
                    formatterArrEmptyFormatterArray[i2] = LogManagerProperties.newFormatter(strArrSplit[i2]);
                    if (formatterArrEmptyFormatterArray[i2] instanceof TailNameFormatter) {
                        reportError("Attachment formatter.", new ClassNotFoundException(formatterArrEmptyFormatterArray[i2].toString()), 4);
                        formatterArrEmptyFormatterArray[i2] = createSimpleFormatter();
                    }
                } catch (SecurityException e2) {
                    throw e2;
                } catch (Exception e3) {
                    reportError(e3.getMessage(), e3, 4);
                    formatterArrEmptyFormatterArray[i2] = createSimpleFormatter();
                }
            }
        }
        this.attachmentFormatters = formatterArrEmptyFormatterArray;
    }

    private void initAttachmentNames(String str) {
        String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".attachment.names"));
        if (isEmpty(strFromLogManager)) {
            this.attachmentNames = emptyFormatterArray();
            alignAttachmentNames();
            return;
        }
        String[] strArrSplit = strFromLogManager.split(",");
        int length = strArrSplit.length;
        Formatter[] formatterArr = new Formatter[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArrSplit[i2] = strArrSplit[i2].trim();
            if ("null".equalsIgnoreCase(strArrSplit[i2])) {
                reportError("Attachment names.", new NullPointerException(atIndexMsg(i2)), 4);
            } else {
                try {
                    try {
                        formatterArr[i2] = LogManagerProperties.newFormatter(strArrSplit[i2]);
                    } catch (ClassCastException | ClassNotFoundException unused) {
                        formatterArr[i2] = TailNameFormatter.of(strArrSplit[i2]);
                    }
                } catch (SecurityException e2) {
                    throw e2;
                } catch (Exception e3) {
                    reportError(e3.getMessage(), e3, 4);
                }
            }
        }
        this.attachmentNames = formatterArr;
        if (alignAttachmentNames()) {
            reportError("Attachment names.", attachmentMismatch("Length mismatch."), 4);
        }
    }

    private void initAuthenticator(String str) {
        String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".authenticator"));
        if (strFromLogManager == null || "null".equalsIgnoreCase(strFromLogManager)) {
            return;
        }
        if (strFromLogManager.length() == 0) {
            this.auth = DefaultAuthenticator.of(strFromLogManager);
            return;
        }
        try {
            this.auth = (Authenticator) LogManagerProperties.newObjectFrom(strFromLogManager, Authenticator.class);
        } catch (ClassCastException | ClassNotFoundException unused) {
            this.auth = DefaultAuthenticator.of(strFromLogManager);
        } catch (SecurityException e2) {
            throw e2;
        } catch (Exception e3) {
            reportError(e3.getMessage(), e3, 4);
        }
    }

    private void initCapacity(String str) {
        try {
            String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".capacity"));
            if (strFromLogManager != null) {
                setCapacity0(Integer.parseInt(strFromLogManager));
            } else {
                setCapacity0(1000);
            }
        } catch (SecurityException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            reportError(e3.getMessage(), e3, 4);
        }
        if (this.capacity <= 0) {
            this.capacity = 1000;
        }
        LogRecord[] logRecordArr = new LogRecord[1];
        this.data = logRecordArr;
        this.matched = new int[logRecordArr.length];
    }

    private void initComparator(String str) {
        try {
            String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".comparator"));
            String strFromLogManager2 = LogManagerProperties.fromLogManager(str.concat(".comparator.reverse"));
            if (!hasValue(strFromLogManager)) {
                if (!isEmpty(strFromLogManager2)) {
                    throw new IllegalArgumentException("No comparator to reverse.");
                }
            } else {
                this.comparator = LogManagerProperties.newComparator(strFromLogManager);
                if (Boolean.parseBoolean(strFromLogManager2)) {
                    this.comparator = LogManagerProperties.reverseOrder(this.comparator);
                }
            }
        } catch (SecurityException e2) {
            throw e2;
        } catch (Exception e3) {
            reportError(e3.getMessage(), e3, 4);
        }
    }

    private void initEncoding(String str) {
        try {
            String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".encoding"));
            if (strFromLogManager != null) {
                setEncoding0(strFromLogManager);
            }
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            reportError(e.getMessage(), e, 4);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            reportError(e.getMessage(), e, 4);
        }
    }

    private void initErrorManager(String str) {
        try {
            String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".errorManager"));
            if (strFromLogManager != null) {
                setErrorManager0(LogManagerProperties.newErrorManager(strFromLogManager));
            }
        } catch (SecurityException e2) {
            throw e2;
        } catch (Exception e3) {
            reportError(e3.getMessage(), e3, 4);
        }
    }

    private void initFilter(String str) {
        try {
            String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".filter"));
            if (hasValue(strFromLogManager)) {
                this.filter = LogManagerProperties.newFilter(strFromLogManager);
            }
        } catch (SecurityException e2) {
            throw e2;
        } catch (Exception e3) {
            reportError(e3.getMessage(), e3, 4);
        }
    }

    private void initFormatter(String str) {
        try {
            String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".formatter"));
            if (hasValue(strFromLogManager)) {
                Formatter formatterNewFormatter = LogManagerProperties.newFormatter(strFromLogManager);
                if (formatterNewFormatter instanceof TailNameFormatter) {
                    this.formatter = createSimpleFormatter();
                } else {
                    this.formatter = formatterNewFormatter;
                }
            } else {
                this.formatter = createSimpleFormatter();
            }
        } catch (SecurityException e2) {
            throw e2;
        } catch (Exception e3) {
            reportError(e3.getMessage(), e3, 4);
            this.formatter = createSimpleFormatter();
        }
    }

    private void initLevel(String str) {
        try {
            String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".level"));
            if (strFromLogManager != null) {
                this.logLevel = Level.parse(strFromLogManager);
            } else {
                this.logLevel = Level.WARNING;
            }
        } catch (SecurityException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            reportError(e3.getMessage(), e3, 4);
            this.logLevel = Level.WARNING;
        }
    }

    private void initPushFilter(String str) {
        try {
            String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".pushFilter"));
            if (hasValue(strFromLogManager)) {
                this.pushFilter = LogManagerProperties.newFilter(strFromLogManager);
            }
        } catch (SecurityException e2) {
            throw e2;
        } catch (Exception e3) {
            reportError(e3.getMessage(), e3, 4);
        }
    }

    private void initPushLevel(String str) {
        try {
            String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".pushLevel"));
            if (strFromLogManager != null) {
                this.pushLevel = Level.parse(strFromLogManager);
            }
        } catch (RuntimeException e2) {
            reportError(e2.getMessage(), e2, 4);
        }
        if (this.pushLevel == null) {
            this.pushLevel = Level.OFF;
        }
    }

    private Session initSession() {
        Session session = Session.getInstance(new LogManagerProperties(this.mailProps, getClass().getName()), this.auth);
        this.session = session;
        return session;
    }

    private void initSubject(String str) {
        String strFromLogManager = LogManagerProperties.fromLogManager(str.concat(".subject"));
        if (strFromLogManager == null) {
            strFromLogManager = "com.sun.mail.util.logging.CollectorFormatter";
        }
        if (!hasValue(strFromLogManager)) {
            this.subjectFormatter = TailNameFormatter.of(strFromLogManager);
            return;
        }
        try {
            this.subjectFormatter = LogManagerProperties.newFormatter(strFromLogManager);
        } catch (ClassCastException | ClassNotFoundException unused) {
            this.subjectFormatter = TailNameFormatter.of(strFromLogManager);
        } catch (SecurityException e2) {
            throw e2;
        } catch (Exception e3) {
            this.subjectFormatter = TailNameFormatter.of(strFromLogManager);
            reportError(e3.getMessage(), e3, 4);
        }
    }

    private void intern() {
        try {
            Map<Object, Object> map = new HashMap<>();
            try {
                intern(map, this.errorManager);
            } catch (SecurityException e2) {
                reportError(e2.getMessage(), e2, 4);
            }
            try {
                Object obj = this.filter;
                Object objIntern = intern(map, obj);
                if (objIntern != obj && (objIntern instanceof Filter)) {
                    this.filter = (Filter) objIntern;
                }
                Object obj2 = this.formatter;
                Object objIntern2 = intern(map, obj2);
                if (objIntern2 != obj2 && (objIntern2 instanceof Formatter)) {
                    this.formatter = (Formatter) objIntern2;
                }
            } catch (SecurityException e3) {
                reportError(e3.getMessage(), e3, 4);
            }
            Object obj3 = this.subjectFormatter;
            Object objIntern3 = intern(map, obj3);
            if (objIntern3 != obj3 && (objIntern3 instanceof Formatter)) {
                this.subjectFormatter = (Formatter) objIntern3;
            }
            Object obj4 = this.pushFilter;
            Object objIntern4 = intern(map, obj4);
            if (objIntern4 != obj4 && (objIntern4 instanceof Filter)) {
                this.pushFilter = (Filter) objIntern4;
            }
            int i2 = 0;
            while (true) {
                Object[] objArr = this.attachmentFormatters;
                if (i2 >= objArr.length) {
                    return;
                }
                Object obj5 = objArr[i2];
                Object objIntern5 = intern(map, obj5);
                if (objIntern5 != obj5 && (objIntern5 instanceof Formatter)) {
                    this.attachmentFormatters[i2] = (Formatter) objIntern5;
                }
                Object obj6 = this.attachmentFilters[i2];
                Object objIntern6 = intern(map, obj6);
                if (objIntern6 != obj6 && (objIntern6 instanceof Filter)) {
                    this.attachmentFilters[i2] = (Filter) objIntern6;
                }
                Object obj7 = this.attachmentNames[i2];
                Object objIntern7 = intern(map, obj7);
                if (objIntern7 != obj7 && (objIntern7 instanceof Formatter)) {
                    this.attachmentNames[i2] = (Formatter) objIntern7;
                }
                i2++;
            }
        } catch (Exception e4) {
            reportError(e4.getMessage(), e4, 4);
        } catch (LinkageError e5) {
            reportError(e5.getMessage(), new InvocationTargetException(e5), 4);
        }
    }

    private boolean isAttachmentLoggable(LogRecord logRecord) {
        Filter[] onlyAttachmentFilters = readOnlyAttachmentFilters();
        for (int i2 = 0; i2 < onlyAttachmentFilters.length; i2++) {
            Filter filter = onlyAttachmentFilters[i2];
            if (filter == null || filter.isLoggable(logRecord)) {
                setMatchedPart(i2);
                return true;
            }
        }
        return false;
    }

    private static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private boolean isPushable(LogRecord logRecord) {
        int iIntValue = getPushLevel().intValue();
        if (iIntValue == offValue || logRecord.getLevel().intValue() < iIntValue) {
            return false;
        }
        Filter pushFilter = getPushFilter();
        if (pushFilter == null) {
            return true;
        }
        int matchedPart = getMatchedPart();
        if (!(matchedPart == -1 && getFilter() == pushFilter) && (matchedPart < 0 || this.attachmentFilters[matchedPart] != pushFilter)) {
            return pushFilter.isLoggable(logRecord);
        }
        return true;
    }

    private Locale localeFor(LogRecord logRecord) {
        ResourceBundle resourceBundle = logRecord.getResourceBundle();
        if (resourceBundle == null) {
            return null;
        }
        Locale locale = resourceBundle.getLocale();
        return (locale == null || isEmpty(locale.getLanguage())) ? Locale.getDefault() : locale;
    }

    private void publish0(LogRecord logRecord) {
        Message messageWriteLogRecords;
        boolean zIsPushable;
        synchronized (this) {
            int i2 = this.size;
            if (i2 == this.data.length && i2 < this.capacity) {
                grow();
            }
            int i3 = this.size;
            messageWriteLogRecords = null;
            if (i3 < this.data.length) {
                this.matched[i3] = getMatchedPart();
                LogRecord[] logRecordArr = this.data;
                int i4 = this.size;
                logRecordArr[i4] = logRecord;
                this.size = i4 + 1;
                zIsPushable = isPushable(logRecord);
                if (zIsPushable || this.size >= this.capacity) {
                    messageWriteLogRecords = writeLogRecords(1);
                }
            } else {
                zIsPushable = false;
            }
        }
        if (messageWriteLogRecords != null) {
            send(messageWriteLogRecords, zIsPushable, 1);
        }
    }

    private Filter[] readOnlyAttachmentFilters() {
        return this.attachmentFilters;
    }

    private void releaseMutex() {
        MUTEX.remove();
    }

    private void reportFilterError(LogRecord logRecord) {
        Formatter formatterCreateSimpleFormatter = createSimpleFormatter();
        reportError("Log record " + logRecord.getSequenceNumber() + " was filtered from all message parts.  " + head(formatterCreateSimpleFormatter) + format(formatterCreateSimpleFormatter, logRecord) + tail(formatterCreateSimpleFormatter, ""), new IllegalArgumentException(getFilter() + ", " + Arrays.asList(readOnlyAttachmentFilters())), 5);
    }

    private void reportLinkageError(Throwable th, int i2) {
        if (th == null) {
            throw new NullPointerException(String.valueOf(i2));
        }
        ThreadLocal<Integer> threadLocal = MUTEX;
        Integer num = threadLocal.get();
        if (num == null || num.intValue() > MUTEX_LINKAGE.intValue()) {
            threadLocal.set(MUTEX_LINKAGE);
            try {
                Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                if (num != null) {
                    threadLocal.set(num);
                } else {
                    threadLocal.remove();
                }
            } catch (LinkageError | RuntimeException unused) {
                if (num != null) {
                    MUTEX.set(num);
                } else {
                    MUTEX.remove();
                }
            } catch (Throwable th2) {
                if (num != null) {
                    MUTEX.set(num);
                } else {
                    MUTEX.remove();
                }
                throw th2;
            }
        }
    }

    private void reportNonDiscriminating(Object obj, Object obj2) {
        reportError("Non discriminating equals implementation.", new IllegalArgumentException(obj.getClass().getName() + " should not be equal to " + obj2.getClass().getName()), 4);
    }

    private void reportNonSymmetric(Object obj, Object obj2) {
        reportError("Non symmetric equals implementation.", new IllegalArgumentException(obj.getClass().getName() + " is not equal to " + obj2.getClass().getName()), 4);
    }

    private void reportNullError(int i2) {
        reportError("null", new NullPointerException(), i2);
    }

    private void reportUnPublishedError(LogRecord logRecord) {
        String str;
        ThreadLocal<Integer> threadLocal = MUTEX;
        Integer num = threadLocal.get();
        if (num == null || num.intValue() > MUTEX_REPORT.intValue()) {
            threadLocal.set(MUTEX_REPORT);
            if (logRecord != null) {
                try {
                    Formatter formatterCreateSimpleFormatter = createSimpleFormatter();
                    str = "Log record " + logRecord.getSequenceNumber() + " was not published. " + head(formatterCreateSimpleFormatter) + format(formatterCreateSimpleFormatter, logRecord) + tail(formatterCreateSimpleFormatter, "");
                } catch (Throwable th) {
                    if (num != null) {
                        MUTEX.set(num);
                    } else {
                        MUTEX.remove();
                    }
                    throw th;
                }
            } else {
                str = null;
            }
            reportError(str, new IllegalStateException("Recursive publish detected by thread " + Thread.currentThread()), 1);
            if (num != null) {
                threadLocal.set(num);
            } else {
                threadLocal.remove();
            }
        }
    }

    private void reportUnexpectedSend(MimeMessage mimeMessage, String str, Exception exc) {
        Exception messagingException = new MessagingException("An empty message was sent.", exc);
        setErrorContent(mimeMessage, str, messagingException);
        reportError(mimeMessage, messagingException, 4);
    }

    private void reset() {
        int i2 = this.size;
        LogRecord[] logRecordArr = this.data;
        if (i2 < logRecordArr.length) {
            Arrays.fill(logRecordArr, 0, i2, (Object) null);
        } else {
            Arrays.fill(logRecordArr, (Object) null);
        }
        this.size = 0;
    }

    private void saveChangesNoContent(Message message, String str) {
        if (message != null) {
            try {
                try {
                    message.saveChanges();
                } catch (RuntimeException | MessagingException e2) {
                    reportError(str, e2, 5);
                }
            } catch (NullPointerException e3) {
                try {
                    if (message.getHeader("Content-Transfer-Encoding") != null) {
                        throw e3;
                    }
                    message.setHeader("Content-Transfer-Encoding", "base64");
                    message.saveChanges();
                } catch (RuntimeException | MessagingException e4) {
                    if (e4 != e3) {
                        e4.addSuppressed(e3);
                    }
                    throw e4;
                }
            }
        }
    }

    private void send(Message message, boolean z, int i2) {
        try {
            envelopeFor(message, z);
            Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
            try {
                Transport.send(message);
                getAndSetContextClassLoader(andSetContextClassLoader);
            } catch (Throwable th) {
                getAndSetContextClassLoader(andSetContextClassLoader);
                throw th;
            }
        } catch (RuntimeException e2) {
            reportError(message, e2, i2);
        } catch (Exception e3) {
            reportError(message, e3, i2);
        }
    }

    private void setAcceptLang(Part part) {
        try {
            String languageTag = LogManagerProperties.toLanguageTag(Locale.getDefault());
            if (languageTag.length() != 0) {
                part.setHeader("Accept-Language", languageTag);
            }
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private void setAuthenticator0(Authenticator authenticator) throws Throwable {
        Session sessionUpdateSession;
        checkAccess();
        synchronized (this) {
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            this.auth = authenticator;
            sessionUpdateSession = updateSession();
        }
        verifySettings(sessionUpdateSession);
    }

    private void setAutoSubmitted(Message message) {
        if (allowRestrictedHeaders()) {
            try {
                message.setHeader("auto-submitted", "auto-generated");
            } catch (MessagingException e2) {
                reportError(e2.getMessage(), e2, 5);
            }
        }
    }

    private synchronized void setCapacity0(int i2) {
        checkAccess();
        if (i2 <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        if (this.isWriting) {
            throw new IllegalStateException();
        }
        if (this.capacity < 0) {
            this.capacity = -i2;
        } else {
            this.capacity = i2;
        }
    }

    private void setContent(MimePart mimePart, CharSequence charSequence, String str) throws MessagingException {
        String encodingName = getEncodingName();
        if (str == null || "text/plain".equalsIgnoreCase(str)) {
            mimePart.setText(charSequence.toString(), MimeUtility.mimeCharset(encodingName));
            return;
        }
        try {
            mimePart.setDataHandler(new DataHandler(new ByteArrayDataSource(charSequence.toString(), contentWithEncoding(str, encodingName))));
        } catch (IOException e2) {
            reportError(e2.getMessage(), e2, 5);
            mimePart.setText(charSequence.toString(), encodingName);
        }
    }

    private void setDefaultFrom(Message message) {
        try {
            message.setFrom();
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private void setDefaultRecipient(Message message, Message.RecipientType recipientType) {
        try {
            InternetAddress localAddress = InternetAddress.getLocalAddress(getSession(message));
            if (localAddress != null) {
                message.setRecipient(recipientType, localAddress);
                return;
            }
            MimeMessage mimeMessage = new MimeMessage(getSession(message));
            mimeMessage.setFrom();
            Address[] from = mimeMessage.getFrom();
            if (from.length <= 0) {
                throw new MessagingException("No local address.");
            }
            message.setRecipients(recipientType, from);
        } catch (RuntimeException | MessagingException e2) {
            reportError("Unable to compute a default recipient.", e2, 5);
        }
    }

    private void setEncoding0(String str) throws UnsupportedEncodingException {
        if (str != null) {
            try {
                if (!Charset.isSupported(str)) {
                    throw new UnsupportedEncodingException(str);
                }
            } catch (IllegalCharsetNameException unused) {
                throw new UnsupportedEncodingException(str);
            }
        }
        synchronized (this) {
            this.encoding = str;
        }
    }

    private void setErrorContent(MimeMessage mimeMessage, String str, Throwable th) {
        MimeBodyPart mimeBodyPartCreateBodyPart;
        String strDescriptionFrom;
        String classId;
        try {
            synchronized (this) {
                mimeBodyPartCreateBodyPart = createBodyPart();
                strDescriptionFrom = descriptionFrom(this.comparator, this.pushLevel, this.pushFilter);
                classId = getClassId(this.subjectFormatter);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Formatted using ");
            sb.append(th == null ? Throwable.class.getName() : th.getClass().getName());
            sb.append(", filtered with ");
            sb.append(str);
            sb.append(", and named by ");
            sb.append(classId);
            sb.append('.');
            mimeBodyPartCreateBodyPart.setDescription(sb.toString());
            setContent(mimeBodyPartCreateBodyPart, toMsgString(th), "text/plain");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(mimeBodyPartCreateBodyPart);
            mimeMessage.setContent(mimeMultipart);
            mimeMessage.setDescription(strDescriptionFrom);
            setAcceptLang(mimeMessage);
            mimeMessage.saveChanges();
        } catch (RuntimeException | MessagingException e2) {
            reportError("Unable to create body.", e2, 4);
        }
    }

    private void setErrorManager0(ErrorManager errorManager) {
        Objects.requireNonNull(errorManager);
        try {
            synchronized (this) {
                this.errorManager = errorManager;
                super.setErrorManager(errorManager);
            }
        } catch (LinkageError | RuntimeException unused) {
        }
    }

    private void setFrom(Message message) {
        String property = getSession(message).getProperty("mail.from");
        if (property == null) {
            setDefaultFrom(message);
            return;
        }
        try {
            InternetAddress[] internetAddressArr = InternetAddress.parse(property, false);
            if (internetAddressArr.length > 0) {
                if (internetAddressArr.length == 1) {
                    message.setFrom(internetAddressArr[0]);
                } else {
                    message.addFrom(internetAddressArr);
                }
            }
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
            setDefaultFrom(message);
        }
    }

    private void setIncompleteCopy(Message message) {
        try {
            message.setHeader("Incomplete-Copy", "");
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private void setMailProperties0(Properties properties) throws Throwable {
        Session sessionUpdateSession;
        checkAccess();
        Properties properties2 = (Properties) properties.clone();
        synchronized (this) {
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            this.mailProps = properties2;
            sessionUpdateSession = updateSession();
        }
        verifySettings(sessionUpdateSession);
    }

    private void setMailer(Message message) {
        String strReplaceAll;
        String strFold;
        try {
            Class<?> cls = getClass();
            if (cls == MailHandler.class) {
                strFold = MailHandler.class.getName();
            } else {
                try {
                    strReplaceAll = MimeUtility.encodeText(cls.getName());
                } catch (UnsupportedEncodingException e2) {
                    reportError(e2.getMessage(), e2, 5);
                    strReplaceAll = cls.getName().replaceAll("[^\\x00-\\x7F]", "\u001a");
                }
                strFold = MimeUtility.fold(10, MailHandler.class.getName() + " using the " + strReplaceAll + " extension.");
            }
            message.setHeader("X-Mailer", strFold);
        } catch (MessagingException e3) {
            reportError(e3.getMessage(), e3, 5);
        }
    }

    private void setMatchedPart(int i2) {
        Integer num = MUTEX_PUBLISH;
        ThreadLocal<Integer> threadLocal = MUTEX;
        if (num.equals(threadLocal.get())) {
            threadLocal.set(Integer.valueOf(i2));
        }
    }

    private void setPriority(Message message) {
        try {
            message.setHeader("Importance", "High");
            message.setHeader("Priority", "urgent");
            message.setHeader("X-Priority", "2");
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private boolean setRecipient(Message message, String str, Message.RecipientType recipientType) {
        String property = getSession(message).getProperty(str);
        boolean z = property != null;
        if (!isEmpty(property)) {
            try {
                InternetAddress[] internetAddressArr = InternetAddress.parse(property, false);
                if (internetAddressArr.length > 0) {
                    message.setRecipients(recipientType, internetAddressArr);
                }
            } catch (MessagingException e2) {
                reportError(e2.getMessage(), e2, 5);
            }
        }
        return z;
    }

    private void setReplyTo(Message message) {
        String property = getSession(message).getProperty("mail.reply.to");
        if (isEmpty(property)) {
            return;
        }
        try {
            InternetAddress[] internetAddressArr = InternetAddress.parse(property, false);
            if (internetAddressArr.length > 0) {
                message.setReplyTo(internetAddressArr);
            }
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private void setSender(Message message) {
        String property = getSession(message).getProperty("mail.sender");
        if (isEmpty(property)) {
            return;
        }
        try {
            InternetAddress[] internetAddressArr = InternetAddress.parse(property, false);
            if (internetAddressArr.length > 0) {
                ((MimeMessage) message).setSender(internetAddressArr[0]);
                if (internetAddressArr.length > 1) {
                    reportError("Ignoring other senders.", tooManyAddresses(internetAddressArr, 1), 5);
                }
            }
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private void sort() {
        Comparator<? super LogRecord> comparator = this.comparator;
        if (comparator != null) {
            try {
                int i2 = this.size;
                if (i2 != 1) {
                    Arrays.sort(this.data, 0, i2, comparator);
                    return;
                }
                LogRecord[] logRecordArr = this.data;
                if (comparator.compare(logRecordArr[0], logRecordArr[0]) != 0) {
                    throw new IllegalArgumentException(this.comparator.getClass().getName());
                }
            } catch (RuntimeException e2) {
                reportError(e2.getMessage(), e2, 5);
            }
        }
    }

    private String tail(Formatter formatter, String str) {
        try {
            return formatter.getTail(this);
        } catch (RuntimeException e2) {
            reportError(e2.getMessage(), e2, 5);
            return str;
        }
    }

    private String toMsgString(Throwable th) {
        if (th == null) {
            return "null";
        }
        String encodingName = getEncodingName();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, encodingName);
            try {
                PrintWriter printWriter = new PrintWriter(outputStreamWriter);
                try {
                    printWriter.println(th.getMessage());
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    printWriter.close();
                    outputStreamWriter.close();
                    return byteArrayOutputStream.toString(encodingName);
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    outputStreamWriter.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (RuntimeException e2) {
            return th.toString() + ' ' + e2.toString();
        } catch (Exception e3) {
            return th.toString() + ' ' + e3.toString();
        }
    }

    private String toRawString(Message message) throws MessagingException, IOException {
        if (message == null) {
            return null;
        }
        Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(message.getSize() + 1024, 1024));
            message.writeTo(byteArrayOutputStream);
            return byteArrayOutputStream.toString("UTF-8");
        } finally {
            getAndSetContextClassLoader(andSetContextClassLoader);
        }
    }

    private String toString(Formatter formatter) {
        String string = formatter.toString();
        return !isEmpty(string) ? string : getClassId(formatter);
    }

    private AddressException tooManyAddresses(Address[] addressArr, int i2) {
        return new AddressException(Arrays.asList(addressArr).subList(i2, addressArr.length).toString());
    }

    private boolean tryMutex() {
        ThreadLocal<Integer> threadLocal = MUTEX;
        if (threadLocal.get() != null) {
            return false;
        }
        threadLocal.set(MUTEX_PUBLISH);
        return true;
    }

    private Session updateSession() {
        if (this.mailProps.getProperty("verify") != null) {
            return initSession();
        }
        this.session = null;
        return null;
    }

    private static void verifyAddresses(Address[] addressArr) throws AddressException {
        if (addressArr != null) {
            for (Address address : addressArr) {
                if (address instanceof InternetAddress) {
                    ((InternetAddress) address).validate();
                }
            }
        }
    }

    private static InetAddress verifyHost(String str) throws IOException {
        InetAddress localHost = isEmpty(str) ? InetAddress.getLocalHost() : InetAddress.getByName(str);
        if (localHost.getCanonicalHostName().length() != 0) {
            return localHost;
        }
        throw new UnknownHostException();
    }

    private static void verifyProperties(Session session, String str) {
        session.getProperty("mail.from");
        session.getProperty("mail." + str + ".from");
        session.getProperty("mail.dsn.ret");
        session.getProperty("mail." + str + ".dsn.ret");
        session.getProperty("mail.dsn.notify");
        session.getProperty("mail." + str + ".dsn.notify");
        session.getProperty("mail." + str + ".port");
        session.getProperty("mail.user");
        session.getProperty("mail." + str + ".user");
        session.getProperty("mail." + str + ".localport");
    }

    private void verifySettings(Session session) throws Throwable {
        if (session != null) {
            try {
                Object objPut = session.getProperties().put("verify", "");
                if (objPut instanceof String) {
                    String str = (String) objPut;
                    if (hasValue(str)) {
                        verifySettings0(session, str);
                    }
                } else if (objPut != null) {
                    verifySettings0(session, objPut.getClass().toString());
                }
            } catch (LinkageError e2) {
                reportLinkageError(e2, 4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0239 A[Catch: Exception -> 0x0397, RuntimeException -> 0x03a0, TryCatch #9 {Exception -> 0x0397, blocks: (B:32:0x00da, B:34:0x00e0, B:36:0x00e3, B:41:0x00ee, B:43:0x00f1, B:51:0x0117, B:53:0x0120, B:56:0x012a, B:58:0x0155, B:60:0x0161, B:62:0x0181, B:64:0x01b5, B:66:0x01bd, B:68:0x01cb, B:70:0x01d4, B:71:0x01d9, B:125:0x0267, B:127:0x026f, B:129:0x0277, B:131:0x027f, B:132:0x0283, B:138:0x0295, B:149:0x02fb, B:158:0x0308, B:155:0x0303, B:156:0x0306, B:159:0x0313, B:161:0x0316, B:163:0x0325, B:164:0x032b, B:166:0x0335, B:168:0x0338, B:169:0x033c, B:171:0x033f, B:173:0x0347, B:174:0x034a, B:175:0x036a, B:177:0x036d, B:178:0x0375, B:179:0x0381, B:180:0x0382, B:181:0x0389, B:137:0x028a, B:76:0x01e1, B:63:0x019c, B:59:0x015c, B:77:0x01ee, B:83:0x0201, B:87:0x0208, B:89:0x0210, B:123:0x025f, B:90:0x0214, B:107:0x0233, B:109:0x0239, B:112:0x0242, B:114:0x0248, B:116:0x024b, B:117:0x0251, B:119:0x0257, B:121:0x025a, B:100:0x022a, B:104:0x0230, B:44:0x00fd, B:45:0x0107, B:39:0x00e8, B:48:0x010a, B:50:0x0114, B:188:0x0393, B:189:0x0396), top: B:208:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x025f A[Catch: Exception -> 0x0397, RuntimeException -> 0x03a0, TryCatch #9 {Exception -> 0x0397, blocks: (B:32:0x00da, B:34:0x00e0, B:36:0x00e3, B:41:0x00ee, B:43:0x00f1, B:51:0x0117, B:53:0x0120, B:56:0x012a, B:58:0x0155, B:60:0x0161, B:62:0x0181, B:64:0x01b5, B:66:0x01bd, B:68:0x01cb, B:70:0x01d4, B:71:0x01d9, B:125:0x0267, B:127:0x026f, B:129:0x0277, B:131:0x027f, B:132:0x0283, B:138:0x0295, B:149:0x02fb, B:158:0x0308, B:155:0x0303, B:156:0x0306, B:159:0x0313, B:161:0x0316, B:163:0x0325, B:164:0x032b, B:166:0x0335, B:168:0x0338, B:169:0x033c, B:171:0x033f, B:173:0x0347, B:174:0x034a, B:175:0x036a, B:177:0x036d, B:178:0x0375, B:179:0x0381, B:180:0x0382, B:181:0x0389, B:137:0x028a, B:76:0x01e1, B:63:0x019c, B:59:0x015c, B:77:0x01ee, B:83:0x0201, B:87:0x0208, B:89:0x0210, B:123:0x025f, B:90:0x0214, B:107:0x0233, B:109:0x0239, B:112:0x0242, B:114:0x0248, B:116:0x024b, B:117:0x0251, B:119:0x0257, B:121:0x025a, B:100:0x022a, B:104:0x0230, B:44:0x00fd, B:45:0x0107, B:39:0x00e8, B:48:0x010a, B:50:0x0114, B:188:0x0393, B:189:0x0396), top: B:208:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0316 A[Catch: Exception -> 0x0397, RuntimeException -> 0x03a0, TryCatch #9 {Exception -> 0x0397, blocks: (B:32:0x00da, B:34:0x00e0, B:36:0x00e3, B:41:0x00ee, B:43:0x00f1, B:51:0x0117, B:53:0x0120, B:56:0x012a, B:58:0x0155, B:60:0x0161, B:62:0x0181, B:64:0x01b5, B:66:0x01bd, B:68:0x01cb, B:70:0x01d4, B:71:0x01d9, B:125:0x0267, B:127:0x026f, B:129:0x0277, B:131:0x027f, B:132:0x0283, B:138:0x0295, B:149:0x02fb, B:158:0x0308, B:155:0x0303, B:156:0x0306, B:159:0x0313, B:161:0x0316, B:163:0x0325, B:164:0x032b, B:166:0x0335, B:168:0x0338, B:169:0x033c, B:171:0x033f, B:173:0x0347, B:174:0x034a, B:175:0x036a, B:177:0x036d, B:178:0x0375, B:179:0x0381, B:180:0x0382, B:181:0x0389, B:137:0x028a, B:76:0x01e1, B:63:0x019c, B:59:0x015c, B:77:0x01ee, B:83:0x0201, B:87:0x0208, B:89:0x0210, B:123:0x025f, B:90:0x0214, B:107:0x0233, B:109:0x0239, B:112:0x0242, B:114:0x0248, B:116:0x024b, B:117:0x0251, B:119:0x0257, B:121:0x025a, B:100:0x022a, B:104:0x0230, B:44:0x00fd, B:45:0x0107, B:39:0x00e8, B:48:0x010a, B:50:0x0114, B:188:0x0393, B:189:0x0396), top: B:208:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0382 A[Catch: Exception -> 0x0397, RuntimeException -> 0x03a0, TryCatch #9 {Exception -> 0x0397, blocks: (B:32:0x00da, B:34:0x00e0, B:36:0x00e3, B:41:0x00ee, B:43:0x00f1, B:51:0x0117, B:53:0x0120, B:56:0x012a, B:58:0x0155, B:60:0x0161, B:62:0x0181, B:64:0x01b5, B:66:0x01bd, B:68:0x01cb, B:70:0x01d4, B:71:0x01d9, B:125:0x0267, B:127:0x026f, B:129:0x0277, B:131:0x027f, B:132:0x0283, B:138:0x0295, B:149:0x02fb, B:158:0x0308, B:155:0x0303, B:156:0x0306, B:159:0x0313, B:161:0x0316, B:163:0x0325, B:164:0x032b, B:166:0x0335, B:168:0x0338, B:169:0x033c, B:171:0x033f, B:173:0x0347, B:174:0x034a, B:175:0x036a, B:177:0x036d, B:178:0x0375, B:179:0x0381, B:180:0x0382, B:181:0x0389, B:137:0x028a, B:76:0x01e1, B:63:0x019c, B:59:0x015c, B:77:0x01ee, B:83:0x0201, B:87:0x0208, B:89:0x0210, B:123:0x025f, B:90:0x0214, B:107:0x0233, B:109:0x0239, B:112:0x0242, B:114:0x0248, B:116:0x024b, B:117:0x0251, B:119:0x0257, B:121:0x025a, B:100:0x022a, B:104:0x0230, B:44:0x00fd, B:45:0x0107, B:39:0x00e8, B:48:0x010a, B:50:0x0114, B:188:0x0393, B:189:0x0396), top: B:208:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x026f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void verifySettings0(javax.mail.Session r17, java.lang.String r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 940
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.MailHandler.verifySettings0(javax.mail.Session, java.lang.String):void");
    }

    private Message writeLogRecords(int i2) {
        try {
        } catch (RuntimeException e2) {
            reportError(e2.getMessage(), e2, i2);
            return null;
        } catch (Exception e3) {
            reportError(e3.getMessage(), e3, i2);
            return null;
        }
        synchronized (this) {
            if (this.size <= 0 || this.isWriting) {
                return null;
            }
            this.isWriting = true;
            try {
                return writeLogRecords0();
            } finally {
                this.isWriting = false;
                if (this.size > 0) {
                    reset();
                }
            }
            reportError(e2.getMessage(), e2, i2);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Message writeLogRecords0() throws Exception {
        MimePart mimePartCreateBodyPart;
        StringBuilder sb;
        Filter filter;
        boolean z;
        sort();
        if (this.session == null) {
            initSession();
        }
        MimeMessage mimeMessage = new MimeMessage(this.session);
        int length = this.attachmentFormatters.length;
        MimeBodyPart[] mimeBodyPartArr = new MimeBodyPart[length];
        StringBuilder[] sbArr = new StringBuilder[length];
        if (length == 0) {
            mimeMessage.setDescription(descriptionFrom(getFormatter(), getFilter(), this.subjectFormatter));
            mimePartCreateBodyPart = mimeMessage;
        } else {
            mimeMessage.setDescription(descriptionFrom(this.comparator, this.pushLevel, this.pushFilter));
            mimePartCreateBodyPart = createBodyPart();
        }
        appendSubject(mimeMessage, head(this.subjectFormatter));
        Formatter formatter = getFormatter();
        Filter filter2 = getFilter();
        LogRecord logRecord = null;
        StringBuilder sb2 = null;
        Object obj = null;
        int i2 = 0;
        while (i2 < this.size) {
            int i3 = this.matched[i2];
            LogRecord[] logRecordArr = this.data;
            LogRecord logRecord2 = logRecordArr[i2];
            logRecordArr[i2] = logRecord;
            Locale localeLocaleFor = localeFor(logRecord2);
            appendSubject(mimeMessage, format(this.subjectFormatter, logRecord2));
            if (filter2 == null || i3 == -1 || length == 0 || (i3 < -1 && filter2.isLoggable(logRecord2))) {
                if (sb2 == null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(head(formatter));
                    sb2 = sb3;
                }
                sb2.append(format(formatter, logRecord2));
                if (localeLocaleFor != null && !localeLocaleFor.equals(obj)) {
                    appendContentLang(mimePartCreateBodyPart, localeLocaleFor);
                }
                filter = filter2;
                z = true;
            } else {
                z = false;
                filter = null;
            }
            Filter filter3 = filter2;
            Filter filter4 = filter;
            int i4 = 0;
            while (i4 < length) {
                StringBuilder sb4 = sb2;
                Filter filter5 = this.attachmentFilters[i4];
                if (filter5 == null || filter4 == filter5 || i3 == i4 || (i3 < i4 && filter5.isLoggable(logRecord2))) {
                    if (filter4 == null && filter5 != null) {
                        filter4 = filter5;
                    }
                    if (mimeBodyPartArr[i4] == null) {
                        mimeBodyPartArr[i4] = createBodyPart(i4);
                        sbArr[i4] = new StringBuilder();
                        sbArr[i4].append(head(this.attachmentFormatters[i4]));
                        appendFileName(mimeBodyPartArr[i4], head(this.attachmentNames[i4]));
                    }
                    appendFileName(mimeBodyPartArr[i4], format(this.attachmentNames[i4], logRecord2));
                    sbArr[i4].append(format(this.attachmentFormatters[i4], logRecord2));
                    if (localeLocaleFor != null && !localeLocaleFor.equals(obj)) {
                        appendContentLang(mimeBodyPartArr[i4], localeLocaleFor);
                    }
                    z = true;
                }
                i4++;
                sb2 = sb4;
            }
            StringBuilder sb5 = sb2;
            if (!z) {
                reportFilterError(logRecord2);
            } else if (mimePartCreateBodyPart != mimeMessage && localeLocaleFor != null && !localeLocaleFor.equals(obj)) {
                appendContentLang(mimeMessage, localeLocaleFor);
            }
            i2++;
            obj = localeLocaleFor;
            filter2 = filter3;
            sb2 = sb5;
            logRecord = null;
        }
        this.size = 0;
        for (int i5 = length - 1; i5 >= 0; i5--) {
            if (mimeBodyPartArr[i5] != null) {
                appendFileName(mimeBodyPartArr[i5], tail(this.attachmentNames[i5], NotificationCompat.CATEGORY_ERROR));
                sbArr[i5].append(tail(this.attachmentFormatters[i5], ""));
                if (sbArr[i5].length() > 0) {
                    String fileName = mimeBodyPartArr[i5].getFileName();
                    if (isEmpty(fileName)) {
                        fileName = toString(this.attachmentFormatters[i5]);
                        mimeBodyPartArr[i5].setFileName(fileName);
                    }
                    setContent(mimeBodyPartArr[i5], sbArr[i5], getContentType(fileName));
                    sb = null;
                } else {
                    setIncompleteCopy(mimeMessage);
                    sb = null;
                    mimeBodyPartArr[i5] = null;
                }
                sbArr[i5] = sb;
            }
        }
        if (sb2 != null) {
            sb2.append(tail(formatter, ""));
        } else {
            sb2 = new StringBuilder(0);
        }
        appendSubject(mimeMessage, tail(this.subjectFormatter, ""));
        String strContentTypeOf = contentTypeOf(sb2);
        String strContentTypeOf2 = contentTypeOf(formatter);
        if (strContentTypeOf2 != null) {
            strContentTypeOf = strContentTypeOf2;
        }
        setContent(mimePartCreateBodyPart, sb2, strContentTypeOf);
        if (mimePartCreateBodyPart != mimeMessage) {
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart((BodyPart) mimePartCreateBodyPart);
            for (int i6 = 0; i6 < length; i6++) {
                if (mimeBodyPartArr[i6] != null) {
                    mimeMultipart.addBodyPart(mimeBodyPartArr[i6]);
                }
            }
            mimeMessage.setContent(mimeMultipart);
        }
        return mimeMessage;
    }

    @Override // java.util.logging.Handler
    public void close() {
        Message messageWriteLogRecords;
        try {
            checkAccess();
            synchronized (this) {
                try {
                    messageWriteLogRecords = writeLogRecords(3);
                    this.logLevel = Level.OFF;
                    int i2 = this.capacity;
                    if (i2 > 0) {
                        this.capacity = -i2;
                    }
                    if (this.size == 0 && this.data.length != 1) {
                        LogRecord[] logRecordArr = new LogRecord[1];
                        this.data = logRecordArr;
                        this.matched = new int[logRecordArr.length];
                    }
                } catch (Throwable th) {
                    this.logLevel = Level.OFF;
                    if (this.capacity > 0) {
                        this.capacity = -this.capacity;
                    }
                    if (this.size == 0 && this.data.length != 1) {
                        LogRecord[] logRecordArr2 = new LogRecord[1];
                        this.data = logRecordArr2;
                        this.matched = new int[logRecordArr2.length];
                    }
                    throw th;
                }
            }
            if (messageWriteLogRecords != null) {
                send(messageWriteLogRecords, false, 3);
            }
        } catch (LinkageError e2) {
            reportLinkageError(e2, 3);
        }
    }

    public final String contentTypeOf(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return null;
        }
        if (charSequence.length() > 25) {
            charSequence = charSequence.subSequence(0, 25);
        }
        try {
            return URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(charSequence.toString().getBytes(getEncodingName())));
        } catch (IOException e2) {
            reportError(e2.getMessage(), e2, 5);
            return null;
        }
    }

    @Override // java.util.logging.Handler
    public void flush() {
        push(false, 2);
    }

    public final Filter[] getAttachmentFilters() {
        return (Filter[]) readOnlyAttachmentFilters().clone();
    }

    public final Formatter[] getAttachmentFormatters() {
        Formatter[] formatterArr;
        synchronized (this) {
            formatterArr = this.attachmentFormatters;
        }
        return (Formatter[]) formatterArr.clone();
    }

    public final Formatter[] getAttachmentNames() {
        Formatter[] formatterArr;
        synchronized (this) {
            formatterArr = this.attachmentNames;
        }
        return (Formatter[]) formatterArr.clone();
    }

    public final synchronized Authenticator getAuthenticator() {
        checkAccess();
        return this.auth;
    }

    public final synchronized int getCapacity() {
        return Math.abs(this.capacity);
    }

    public final synchronized Comparator<? super LogRecord> getComparator() {
        return this.comparator;
    }

    @Override // java.util.logging.Handler
    public synchronized String getEncoding() {
        return this.encoding;
    }

    @Override // java.util.logging.Handler
    public ErrorManager getErrorManager() {
        checkAccess();
        return this.errorManager;
    }

    @Override // java.util.logging.Handler
    public Filter getFilter() {
        return this.filter;
    }

    @Override // java.util.logging.Handler
    public synchronized Formatter getFormatter() {
        return this.formatter;
    }

    @Override // java.util.logging.Handler
    public Level getLevel() {
        return this.logLevel;
    }

    public final Properties getMailProperties() {
        Properties properties;
        checkAccess();
        synchronized (this) {
            properties = this.mailProps;
        }
        return (Properties) properties.clone();
    }

    public final synchronized Filter getPushFilter() {
        return this.pushFilter;
    }

    public final synchronized Level getPushLevel() {
        return this.pushLevel;
    }

    public final synchronized Formatter getSubject() {
        return this.subjectFormatter;
    }

    @Override // java.util.logging.Handler
    public boolean isLoggable(LogRecord logRecord) {
        int iIntValue;
        if (logRecord == null || logRecord.getLevel().intValue() < (iIntValue = getLevel().intValue()) || iIntValue == offValue) {
            return false;
        }
        Filter filter = getFilter();
        if (filter != null && !filter.isLoggable(logRecord)) {
            return isAttachmentLoggable(logRecord);
        }
        setMatchedPart(-1);
        return true;
    }

    public final boolean isMissingContent(Message message, Throwable th) {
        Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
        try {
            try {
                message.writeTo(new ByteArrayOutputStream(1024));
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                String message2 = e3.getMessage();
                if (!isEmpty(message2)) {
                    int i2 = 0;
                    while (th != null) {
                        if (e3.getClass() == th.getClass() && message2.equals(th.getMessage())) {
                            getAndSetContextClassLoader(andSetContextClassLoader);
                            return true;
                        }
                        Throwable cause = th.getCause();
                        th = (cause == null && (th instanceof MessagingException)) ? ((MessagingException) th).getNextException() : cause;
                        i2++;
                        if (i2 == 65536) {
                            break;
                        }
                    }
                }
            }
            getAndSetContextClassLoader(andSetContextClassLoader);
            return false;
        } catch (Throwable th2) {
            getAndSetContextClassLoader(andSetContextClassLoader);
            throw th2;
        }
    }

    public void postConstruct() {
    }

    public void preDestroy() {
        push(false, 3);
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        if (!tryMutex()) {
            reportUnPublishedError(logRecord);
            return;
        }
        try {
            try {
                if (isLoggable(logRecord)) {
                    if (logRecord != null) {
                        logRecord.getSourceMethodName();
                        publish0(logRecord);
                    } else {
                        reportNullError(1);
                    }
                }
            } catch (LinkageError e2) {
                reportLinkageError(e2, 1);
            }
        } finally {
            releaseMutex();
        }
    }

    public void push() {
        push(true, 2);
    }

    @Override // java.util.logging.Handler
    public void reportError(String str, Exception exc, int i2) {
        try {
            if (str != null) {
                this.errorManager.error(Level.SEVERE.getName().concat(": ").concat(str), exc, i2);
            } else {
                this.errorManager.error(null, exc, i2);
            }
        } catch (LinkageError | RuntimeException e2) {
            reportLinkageError(e2, i2);
        }
    }

    public final void setAttachmentFilters(Filter... filterArr) {
        checkAccess();
        Filter[] filterArrEmptyFilterArray = filterArr.length == 0 ? emptyFilterArray() : (Filter[]) Arrays.copyOf(filterArr, filterArr.length, Filter[].class);
        synchronized (this) {
            Formatter[] formatterArr = this.attachmentFormatters;
            if (formatterArr.length != filterArrEmptyFilterArray.length) {
                throw attachmentMismatch(formatterArr.length, filterArrEmptyFilterArray.length);
            }
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            if (this.size != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= filterArrEmptyFilterArray.length) {
                        break;
                    }
                    if (filterArrEmptyFilterArray[i2] != this.attachmentFilters[i2]) {
                        clearMatches(i2);
                        break;
                    }
                    i2++;
                }
            }
            this.attachmentFilters = filterArrEmptyFilterArray;
        }
    }

    public final void setAttachmentFormatters(Formatter... formatterArr) {
        Formatter[] formatterArrEmptyFormatterArray;
        checkAccess();
        if (formatterArr.length == 0) {
            formatterArrEmptyFormatterArray = emptyFormatterArray();
        } else {
            formatterArrEmptyFormatterArray = (Formatter[]) Arrays.copyOf(formatterArr, formatterArr.length, Formatter[].class);
            for (int i2 = 0; i2 < formatterArrEmptyFormatterArray.length; i2++) {
                if (formatterArrEmptyFormatterArray[i2] == null) {
                    throw new NullPointerException(atIndexMsg(i2));
                }
            }
        }
        synchronized (this) {
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            this.attachmentFormatters = formatterArrEmptyFormatterArray;
            alignAttachmentFilters();
            alignAttachmentNames();
        }
    }

    public final void setAttachmentNames(String... strArr) {
        checkAccess();
        Formatter[] formatterArrEmptyFormatterArray = strArr.length == 0 ? emptyFormatterArray() : new Formatter[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (str == null) {
                throw new NullPointerException(atIndexMsg(i2));
            }
            if (str.length() <= 0) {
                throw new IllegalArgumentException(atIndexMsg(i2));
            }
            formatterArrEmptyFormatterArray[i2] = TailNameFormatter.of(str);
        }
        synchronized (this) {
            Formatter[] formatterArr = this.attachmentFormatters;
            if (formatterArr.length != strArr.length) {
                throw attachmentMismatch(formatterArr.length, strArr.length);
            }
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            this.attachmentNames = formatterArrEmptyFormatterArray;
        }
    }

    public final void setAuthenticator(Authenticator authenticator) throws Throwable {
        setAuthenticator0(authenticator);
    }

    public final synchronized void setComparator(Comparator<? super LogRecord> comparator) {
        checkAccess();
        if (this.isWriting) {
            throw new IllegalStateException();
        }
        this.comparator = comparator;
    }

    @Override // java.util.logging.Handler
    public void setEncoding(String str) throws UnsupportedEncodingException {
        checkAccess();
        setEncoding0(str);
    }

    @Override // java.util.logging.Handler
    public void setErrorManager(ErrorManager errorManager) {
        checkAccess();
        setErrorManager0(errorManager);
    }

    @Override // java.util.logging.Handler
    public void setFilter(Filter filter) {
        checkAccess();
        synchronized (this) {
            if (filter != this.filter) {
                clearMatches(-1);
            }
            this.filter = filter;
        }
    }

    @Override // java.util.logging.Handler
    public synchronized void setFormatter(Formatter formatter) throws SecurityException {
        checkAccess();
        if (formatter == null) {
            throw new NullPointerException();
        }
        this.formatter = formatter;
    }

    @Override // java.util.logging.Handler
    public void setLevel(Level level) {
        Objects.requireNonNull(level);
        checkAccess();
        synchronized (this) {
            if (this.capacity > 0) {
                this.logLevel = level;
            }
        }
    }

    public final void setMailProperties(Properties properties) throws Throwable {
        setMailProperties0(properties);
    }

    public final synchronized void setPushFilter(Filter filter) {
        checkAccess();
        if (this.isWriting) {
            throw new IllegalStateException();
        }
        this.pushFilter = filter;
    }

    public final synchronized void setPushLevel(Level level) {
        checkAccess();
        if (level == null) {
            throw new NullPointerException();
        }
        if (this.isWriting) {
            throw new IllegalStateException();
        }
        this.pushLevel = level;
    }

    public final void setSubject(String str) {
        if (str != null) {
            setSubject(TailNameFormatter.of(str));
        } else {
            checkAccess();
            throw null;
        }
    }

    private static RuntimeException attachmentMismatch(int i2, int i3) {
        return attachmentMismatch("Attachments mismatched, expected " + i2 + " but given " + i3 + '.');
    }

    private void push(boolean z, int i2) {
        try {
            if (!tryMutex()) {
                reportUnPublishedError(null);
                return;
            }
            try {
                Message messageWriteLogRecords = writeLogRecords(i2);
                if (messageWriteLogRecords != null) {
                    send(messageWriteLogRecords, z, i2);
                }
            } catch (LinkageError e2) {
                reportLinkageError(e2, i2);
            }
        } finally {
            releaseMutex();
        }
    }

    public final void setAuthenticator(char... cArr) throws Throwable {
        if (cArr == null) {
            setAuthenticator0(null);
        } else {
            setAuthenticator0(DefaultAuthenticator.of(new String(cArr)));
        }
    }

    private String descriptionFrom(Formatter formatter, Filter filter, Formatter formatter2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Formatted using ");
        sb.append(getClassId(formatter));
        sb.append(", filtered with ");
        sb.append(filter == null ? "no filter" : filter.getClass().getName());
        sb.append(", and named by ");
        sb.append(getClassId(formatter2));
        sb.append('.');
        return sb.toString();
    }

    public final void setSubject(Formatter formatter) {
        checkAccess();
        Objects.requireNonNull(formatter);
        synchronized (this) {
            if (!this.isWriting) {
                this.subjectFormatter = formatter;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private void reportError(Message message, Exception exc, int i2) {
        try {
            try {
                this.errorManager.error(toRawString(message), exc, i2);
            } catch (RuntimeException e2) {
                reportError(toMsgString(e2), exc, i2);
            } catch (Exception e3) {
                reportError(toMsgString(e3), exc, i2);
            }
        } catch (LinkageError e4) {
            reportLinkageError(e4, i2);
        }
    }

    public MailHandler(int i2) {
        init(null);
        this.sealed = true;
        setCapacity0(i2);
    }

    private MimeBodyPart createBodyPart(int i2) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDisposition(Part.ATTACHMENT);
        mimeBodyPart.setDescription(descriptionFrom(this.attachmentFormatters[i2], this.attachmentFilters[i2], this.attachmentNames[i2]));
        setAcceptLang(mimeBodyPart);
        return mimeBodyPart;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        r7 = r7.getSuperclass();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String contentTypeOf(java.util.logging.Formatter r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L67
            java.lang.Class r0 = r7.getClass()
            java.lang.String r0 = r0.getName()
            java.lang.String r0 = r6.getContentType(r0)
            if (r0 == 0) goto L11
            return r0
        L11:
            java.lang.Class r7 = r7.getClass()
        L15:
            java.lang.Class<java.util.logging.Formatter> r0 = java.util.logging.Formatter.class
            if (r7 == r0) goto L67
            java.lang.String r0 = r7.getSimpleName()     // Catch: java.lang.InternalError -> L1e
            goto L22
        L1e:
            java.lang.String r0 = r7.getName()
        L22:
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r1)
            r1 = 36
            int r1 = r0.indexOf(r1)
            r2 = 1
            int r1 = r1 + r2
        L30:
            java.lang.String r3 = "ml"
            int r1 = r0.indexOf(r3, r1)
            r3 = -1
            if (r1 <= r3) goto L62
            if (r1 <= 0) goto L5f
            int r3 = r1 + (-1)
            char r4 = r0.charAt(r3)
            r5 = 120(0x78, float:1.68E-43)
            if (r4 != r5) goto L48
            java.lang.String r7 = "application/xml"
            return r7
        L48:
            if (r1 <= r2) goto L5f
            int r4 = r1 + (-2)
            char r4 = r0.charAt(r4)
            r5 = 104(0x68, float:1.46E-43)
            if (r4 != r5) goto L5f
            char r3 = r0.charAt(r3)
            r4 = 116(0x74, float:1.63E-43)
            if (r3 != r4) goto L5f
            java.lang.String r7 = "text/html"
            return r7
        L5f:
            int r1 = r1 + 2
            goto L30
        L62:
            java.lang.Class r7 = r7.getSuperclass()
            goto L15
        L67:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.MailHandler.contentTypeOf(java.util.logging.Formatter):java.lang.String");
    }

    public MailHandler(Properties properties) throws Throwable {
        Objects.requireNonNull(properties);
        init(properties);
        this.sealed = true;
        setMailProperties0(properties);
    }

    public final void setAttachmentNames(Formatter... formatterArr) {
        Formatter[] formatterArrEmptyFormatterArray;
        checkAccess();
        if (formatterArr.length == 0) {
            formatterArrEmptyFormatterArray = emptyFormatterArray();
        } else {
            formatterArrEmptyFormatterArray = (Formatter[]) Arrays.copyOf(formatterArr, formatterArr.length, Formatter[].class);
        }
        for (int i2 = 0; i2 < formatterArrEmptyFormatterArray.length; i2++) {
            if (formatterArrEmptyFormatterArray[i2] == null) {
                throw new NullPointerException(atIndexMsg(i2));
            }
        }
        synchronized (this) {
            Formatter[] formatterArr2 = this.attachmentFormatters;
            if (formatterArr2.length == formatterArrEmptyFormatterArray.length) {
                if (!this.isWriting) {
                    this.attachmentNames = formatterArrEmptyFormatterArray;
                } else {
                    throw new IllegalStateException();
                }
            } else {
                throw attachmentMismatch(formatterArr2.length, formatterArrEmptyFormatterArray.length);
            }
        }
    }

    private Object intern(Map<Object, Object> map, Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Object objNewInstance = obj.getClass().getName().equals(TailNameFormatter.class.getName()) ? obj : obj.getClass().getConstructor(new Class[0]).newInstance(new Object[0]);
        if (objNewInstance.getClass() != obj.getClass()) {
            return obj;
        }
        Object obj2 = map.get(objNewInstance);
        if (obj2 == null) {
            boolean zEquals = objNewInstance.equals(obj);
            boolean zEquals2 = obj.equals(objNewInstance);
            if (!zEquals || !zEquals2) {
                if (zEquals == zEquals2) {
                    return obj;
                }
                reportNonSymmetric(obj, objNewInstance);
                return obj;
            }
            Object objPut = map.put(obj, obj);
            if (objPut == null) {
                return obj;
            }
            reportNonDiscriminating(objNewInstance, objPut);
            Object objRemove = map.remove(objNewInstance);
            if (objRemove == obj) {
                return obj;
            }
            reportNonDiscriminating(objNewInstance, objRemove);
            map.clear();
            return obj;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj2;
        }
        reportNonDiscriminating(obj, obj2);
        return obj;
    }
}
