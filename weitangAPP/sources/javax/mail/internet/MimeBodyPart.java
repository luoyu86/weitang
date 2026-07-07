package javax.mail.internet;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.MessageRemovedIOException;
import com.sun.mail.util.MimeUtil;
import com.sun.mail.util.PropUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.EncodingAware;
import javax.mail.FolderClosedException;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.HeaderTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class MimeBodyPart extends BodyPart implements MimePart {
    public Object cachedContent;
    public byte[] content;
    public InputStream contentStream;
    public DataHandler dh;
    public InternetHeaders headers;
    private static final boolean setDefaultTextCharset = PropUtil.getBooleanSystemProperty("mail.mime.setdefaulttextcharset", true);
    private static final boolean setContentTypeFileName = PropUtil.getBooleanSystemProperty("mail.mime.setcontenttypefilename", true);
    private static final boolean encodeFileName = PropUtil.getBooleanSystemProperty("mail.mime.encodefilename", false);
    private static final boolean decodeFileName = PropUtil.getBooleanSystemProperty("mail.mime.decodefilename", false);
    private static final boolean ignoreMultipartEncoding = PropUtil.getBooleanSystemProperty("mail.mime.ignoremultipartencoding", true);
    private static final boolean allowutf8 = PropUtil.getBooleanSystemProperty("mail.mime.allowutf8", true);
    public static final boolean cacheMultipart = PropUtil.getBooleanSystemProperty("mail.mime.cachemultipart", true);

    public static class EncodedFileDataSource extends FileDataSource implements EncodingAware {
        private String contentType;
        private String encoding;

        public EncodedFileDataSource(File file, String str, String str2) {
            super(file);
            this.contentType = str;
            this.encoding = str2;
        }

        @Override // javax.activation.FileDataSource, javax.activation.DataSource
        public String getContentType() {
            String str = this.contentType;
            return str != null ? str : super.getContentType();
        }

        @Override // javax.mail.EncodingAware
        public String getEncoding() {
            return this.encoding;
        }
    }

    public static class MimePartDataHandler extends DataHandler {
        public MimePart part;

        public MimePartDataHandler(MimePart mimePart) {
            super(new MimePartDataSource(mimePart));
            this.part = mimePart;
        }

        public InputStream getContentStream() throws MessagingException {
            MimePart mimePart = this.part;
            if (mimePart instanceof MimeBodyPart) {
                return ((MimeBodyPart) mimePart).getContentStream();
            }
            if (mimePart instanceof MimeMessage) {
                return ((MimeMessage) mimePart).getContentStream();
            }
            return null;
        }

        public MimePart getPart() {
            return this.part;
        }
    }

    public MimeBodyPart() {
        this.headers = new InternetHeaders();
    }

    public static void invalidateContentHeaders(MimePart mimePart) throws MessagingException {
        mimePart.removeHeader("Content-Type");
        mimePart.removeHeader("Content-Transfer-Encoding");
    }

    public static String restrictEncoding(MimePart mimePart, String str) throws MessagingException {
        String contentType;
        if (!ignoreMultipartEncoding || str == null || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit") || str.equalsIgnoreCase("binary") || (contentType = mimePart.getContentType()) == null) {
            return str;
        }
        try {
            ContentType contentType2 = new ContentType(contentType);
            if (contentType2.match("multipart/*")) {
                return null;
            }
            if (contentType2.match("message/*")) {
                if (!PropUtil.getBooleanSystemProperty("mail.mime.allowencodedmessages", false)) {
                    return null;
                }
            }
        } catch (ParseException unused) {
        }
        return str;
    }

    public static void setEncoding(MimePart mimePart, String str) throws MessagingException {
        mimePart.setHeader("Content-Transfer-Encoding", str);
    }

    @Override // javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        this.headers.addHeader(str, str2);
    }

    public void addHeaderLine(String str) throws MessagingException {
        this.headers.addHeaderLine(str);
    }

    public void attachFile(File file) throws MessagingException, IOException {
        FileDataSource fileDataSource = new FileDataSource(file);
        setDataHandler(new DataHandler(fileDataSource));
        setFileName(fileDataSource.getName());
        setDisposition(Part.ATTACHMENT);
    }

    public Enumeration<String> getAllHeaderLines() throws MessagingException {
        return this.headers.getAllHeaderLines();
    }

    @Override // javax.mail.Part
    public Enumeration<Header> getAllHeaders() throws MessagingException {
        return this.headers.getAllHeaders();
    }

    @Override // javax.mail.Part
    public Object getContent() throws MessagingException, IOException {
        Object obj = this.cachedContent;
        if (obj != null) {
            return obj;
        }
        try {
            Object content = getDataHandler().getContent();
            if (cacheMultipart && (((content instanceof Multipart) || (content instanceof Message)) && (this.content != null || this.contentStream != null))) {
                this.cachedContent = content;
                if (content instanceof MimeMultipart) {
                    ((MimeMultipart) content).parse();
                }
            }
            return content;
        } catch (FolderClosedIOException e2) {
            throw new FolderClosedException(e2.getFolder(), e2.getMessage());
        } catch (MessageRemovedIOException e3) {
            throw new MessageRemovedException(e3.getMessage());
        }
    }

    public String getContentID() throws MessagingException {
        return getHeader("Content-Id", null);
    }

    @Override // javax.mail.internet.MimePart
    public String[] getContentLanguage() throws MessagingException {
        return getContentLanguage(this);
    }

    public String getContentMD5() throws MessagingException {
        return getHeader(HttpHeaders.CONTENT_MD5, null);
    }

    public InputStream getContentStream() throws MessagingException {
        Closeable closeable = this.contentStream;
        if (closeable != null) {
            return ((SharedInputStream) closeable).newStream(0L, -1L);
        }
        if (this.content != null) {
            return new ByteArrayInputStream(this.content);
        }
        throw new MessagingException("No MimeBodyPart content");
    }

    @Override // javax.mail.Part
    public String getContentType() throws MessagingException {
        String strCleanContentType = MimeUtil.cleanContentType(this, getHeader("Content-Type", null));
        return strCleanContentType == null ? "text/plain" : strCleanContentType;
    }

    @Override // javax.mail.Part
    public DataHandler getDataHandler() throws MessagingException {
        if (this.dh == null) {
            this.dh = new MimePartDataHandler(this);
        }
        return this.dh;
    }

    @Override // javax.mail.Part
    public String getDescription() throws MessagingException {
        return getDescription(this);
    }

    @Override // javax.mail.Part
    public String getDisposition() throws MessagingException {
        return getDisposition(this);
    }

    public String getEncoding() throws MessagingException {
        return getEncoding(this);
    }

    @Override // javax.mail.Part
    public String getFileName() throws MessagingException {
        return getFileName(this);
    }

    @Override // javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.Part
    public InputStream getInputStream() throws MessagingException, IOException {
        return getDataHandler().getInputStream();
    }

    @Override // javax.mail.Part
    public int getLineCount() throws MessagingException {
        return -1;
    }

    public Enumeration<String> getMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.Part
    public Enumeration<Header> getMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getMatchingHeaders(strArr);
    }

    public Enumeration<String> getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.Part
    public Enumeration<Header> getNonMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaders(strArr);
    }

    public InputStream getRawInputStream() throws MessagingException {
        return getContentStream();
    }

    @Override // javax.mail.Part
    public int getSize() throws MessagingException {
        byte[] bArr = this.content;
        if (bArr != null) {
            return bArr.length;
        }
        InputStream inputStream = this.contentStream;
        if (inputStream == null) {
            return -1;
        }
        try {
            int iAvailable = inputStream.available();
            if (iAvailable > 0) {
                return iAvailable;
            }
            return -1;
        } catch (IOException unused) {
            return -1;
        }
    }

    @Override // javax.mail.Part
    public boolean isMimeType(String str) throws MessagingException {
        return isMimeType(this, str);
    }

    @Override // javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        this.headers.removeHeader(str);
    }

    public void saveFile(File file) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        try {
            inputStream = getInputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 > 0) {
                    bufferedOutputStream.write(bArr, 0, i2);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            inputStream.close();
            try {
                bufferedOutputStream.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            if (bufferedOutputStream == null) {
                throw th;
            }
            try {
                bufferedOutputStream.close();
                throw th;
            } catch (IOException unused4) {
                throw th;
            }
        }
    }

    @Override // javax.mail.Part
    public void setContent(Object obj, String str) throws MessagingException {
        if (obj instanceof Multipart) {
            setContent((Multipart) obj);
        } else {
            setDataHandler(new DataHandler(obj, str));
        }
    }

    public void setContentID(String str) throws MessagingException {
        if (str == null) {
            removeHeader("Content-ID");
        } else {
            setHeader("Content-ID", str);
        }
    }

    @Override // javax.mail.internet.MimePart
    public void setContentLanguage(String[] strArr) throws MessagingException {
        setContentLanguage(this, strArr);
    }

    public void setContentMD5(String str) throws MessagingException {
        setHeader(HttpHeaders.CONTENT_MD5, str);
    }

    @Override // javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        this.dh = dataHandler;
        this.cachedContent = null;
        invalidateContentHeaders(this);
    }

    @Override // javax.mail.Part
    public void setDescription(String str) throws MessagingException {
        setDescription(str, null);
    }

    @Override // javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        setDisposition(this, str);
    }

    @Override // javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        setFileName(this, str);
    }

    @Override // javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        this.headers.setHeader(str, str2);
    }

    @Override // javax.mail.Part, javax.mail.internet.MimePart
    public void setText(String str) throws MessagingException {
        setText(str, null);
    }

    public void updateHeaders() throws MessagingException {
        updateHeaders(this);
        if (this.cachedContent != null) {
            this.dh = new DataHandler(this.cachedContent, getContentType());
            this.cachedContent = null;
            this.content = null;
            InputStream inputStream = this.contentStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            this.contentStream = null;
        }
    }

    @Override // javax.mail.Part
    public void writeTo(OutputStream outputStream) throws MessagingException, IOException {
        writeTo(this, outputStream, null);
    }

    public static String[] getContentLanguage(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Language", null);
        if (header == null) {
            return null;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(header, HeaderTokenizer.MIME);
        ArrayList arrayList = new ArrayList();
        while (true) {
            HeaderTokenizer.Token next = headerTokenizer.next();
            int type = next.getType();
            if (type == -4) {
                break;
            }
            if (type == -1) {
                arrayList.add(next.getValue());
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static String getDescription(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Description", null);
        if (header == null) {
            return null;
        }
        try {
            return MimeUtility.decodeText(MimeUtility.unfold(header));
        } catch (UnsupportedEncodingException unused) {
            return header;
        }
    }

    public static String getDisposition(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader(HttpHeaders.CONTENT_DISPOSITION, null);
        if (header == null) {
            return null;
        }
        return new ContentDisposition(header).getDisposition();
    }

    public static String getEncoding(MimePart mimePart) throws MessagingException {
        HeaderTokenizer.Token next;
        int type;
        String header = mimePart.getHeader("Content-Transfer-Encoding", null);
        if (header == null) {
            return null;
        }
        String strTrim = header.trim();
        if (strTrim.length() == 0) {
            return null;
        }
        if (strTrim.equalsIgnoreCase("7bit") || strTrim.equalsIgnoreCase("8bit") || strTrim.equalsIgnoreCase("quoted-printable") || strTrim.equalsIgnoreCase("binary") || strTrim.equalsIgnoreCase("base64")) {
            return strTrim;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(strTrim, HeaderTokenizer.MIME);
        do {
            next = headerTokenizer.next();
            type = next.getType();
            if (type == -4) {
                return strTrim;
            }
        } while (type != -1);
        return next.getValue();
    }

    public static String getFileName(MimePart mimePart) throws MessagingException {
        String strCleanContentType;
        String header = mimePart.getHeader(HttpHeaders.CONTENT_DISPOSITION, null);
        String parameter = header != null ? new ContentDisposition(header).getParameter("filename") : null;
        if (parameter == null && (strCleanContentType = MimeUtil.cleanContentType(mimePart, mimePart.getHeader("Content-Type", null))) != null) {
            try {
                parameter = new ContentType(strCleanContentType).getParameter("name");
            } catch (ParseException unused) {
            }
        }
        if (!decodeFileName || parameter == null) {
            return parameter;
        }
        try {
            return MimeUtility.decodeText(parameter);
        } catch (UnsupportedEncodingException e2) {
            throw new MessagingException("Can't decode filename", e2);
        }
    }

    public static boolean isMimeType(MimePart mimePart, String str) throws MessagingException {
        String contentType = mimePart.getContentType();
        try {
            return new ContentType(contentType).match(str);
        } catch (ParseException unused) {
            try {
                int iIndexOf = contentType.indexOf(59);
                if (iIndexOf > 0) {
                    return new ContentType(contentType.substring(0, iIndexOf)).match(str);
                }
            } catch (ParseException unused2) {
            }
            return contentType.equalsIgnoreCase(str);
        }
    }

    public static void setContentLanguage(MimePart mimePart, String[] strArr) throws MessagingException {
        StringBuilder sb = new StringBuilder(strArr[0]);
        int length = 18 + strArr[0].length();
        for (int i2 = 1; i2 < strArr.length; i2++) {
            sb.append(',');
            int i3 = length + 1;
            if (i3 > 76) {
                sb.append("\r\n\t");
                i3 = 8;
            }
            sb.append(strArr[i2]);
            length = i3 + strArr[i2].length();
        }
        mimePart.setHeader("Content-Language", sb.toString());
    }

    public static void setDisposition(MimePart mimePart, String str) throws MessagingException {
        if (str == null) {
            mimePart.removeHeader(HttpHeaders.CONTENT_DISPOSITION);
            return;
        }
        String header = mimePart.getHeader(HttpHeaders.CONTENT_DISPOSITION, null);
        if (header != null) {
            ContentDisposition contentDisposition = new ContentDisposition(header);
            contentDisposition.setDisposition(str);
            str = contentDisposition.toString();
        }
        mimePart.setHeader(HttpHeaders.CONTENT_DISPOSITION, str);
    }

    public static void setFileName(MimePart mimePart, String str) throws MessagingException {
        String strCleanContentType;
        boolean z = encodeFileName;
        if (z && str != null) {
            try {
                str = MimeUtility.encodeText(str);
            } catch (UnsupportedEncodingException e2) {
                throw new MessagingException("Can't encode filename", e2);
            }
        }
        String header = mimePart.getHeader(HttpHeaders.CONTENT_DISPOSITION, null);
        if (header == null) {
            header = Part.ATTACHMENT;
        }
        ContentDisposition contentDisposition = new ContentDisposition(header);
        String defaultMIMECharset = MimeUtility.getDefaultMIMECharset();
        ParameterList parameterList = contentDisposition.getParameterList();
        if (parameterList == null) {
            parameterList = new ParameterList();
            contentDisposition.setParameterList(parameterList);
        }
        if (z) {
            parameterList.setLiteral("filename", str);
        } else {
            parameterList.set("filename", str, defaultMIMECharset);
        }
        mimePart.setHeader(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
        if (!setContentTypeFileName || (strCleanContentType = MimeUtil.cleanContentType(mimePart, mimePart.getHeader("Content-Type", null))) == null) {
            return;
        }
        try {
            ContentType contentType = new ContentType(strCleanContentType);
            ParameterList parameterList2 = contentType.getParameterList();
            if (parameterList2 == null) {
                parameterList2 = new ParameterList();
                contentType.setParameterList(parameterList2);
            }
            if (z) {
                parameterList2.setLiteral("name", str);
            } else {
                parameterList2.set("name", str, defaultMIMECharset);
            }
            mimePart.setHeader("Content-Type", contentType.toString());
        } catch (ParseException unused) {
        }
    }

    public static void writeTo(MimePart mimePart, OutputStream outputStream, String[] strArr) throws MessagingException, IOException {
        LineOutputStream lineOutputStream = outputStream instanceof LineOutputStream ? (LineOutputStream) outputStream : new LineOutputStream(outputStream, allowutf8);
        Enumeration<String> nonMatchingHeaderLines = mimePart.getNonMatchingHeaderLines(strArr);
        while (nonMatchingHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln(nonMatchingHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        InputStream contentStream = null;
        try {
            DataHandler dataHandler = mimePart.getDataHandler();
            if (dataHandler instanceof MimePartDataHandler) {
                MimePartDataHandler mimePartDataHandler = (MimePartDataHandler) dataHandler;
                if (mimePartDataHandler.getPart().getEncoding() != null) {
                    contentStream = mimePartDataHandler.getContentStream();
                }
            }
            if (contentStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i2 = contentStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, i2);
                    }
                }
            } else {
                outputStream = MimeUtility.encode(outputStream, restrictEncoding(mimePart, mimePart.getEncoding()));
                mimePart.getDataHandler().writeTo(outputStream);
            }
            outputStream.flush();
        } finally {
            if (0 != 0) {
                contentStream.close();
            }
        }
    }

    @Override // javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        return this.headers.getHeader(str, str2);
    }

    public void setDescription(String str, String str2) throws MessagingException {
        setDescription(this, str, str2);
    }

    @Override // javax.mail.internet.MimePart
    public void setText(String str, String str2) throws MessagingException {
        setText(this, str, str2, "plain");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MimeBodyPart(InputStream inputStream) throws MessagingException {
        boolean z = inputStream instanceof ByteArrayInputStream;
        InputStream bufferedInputStream = inputStream;
        if (!z) {
            boolean z2 = inputStream instanceof BufferedInputStream;
            bufferedInputStream = inputStream;
            if (!z2) {
                boolean z3 = inputStream instanceof SharedInputStream;
                bufferedInputStream = inputStream;
                if (!z3) {
                    bufferedInputStream = new BufferedInputStream(inputStream);
                }
            }
        }
        this.headers = new InternetHeaders(bufferedInputStream);
        if (bufferedInputStream instanceof SharedInputStream) {
            SharedInputStream sharedInputStream = (SharedInputStream) bufferedInputStream;
            this.contentStream = sharedInputStream.newStream(sharedInputStream.getPosition(), -1L);
        } else {
            try {
                this.content = ASCIIUtility.getBytes(bufferedInputStream);
            } catch (IOException e2) {
                throw new MessagingException("Error reading input stream", e2);
            }
        }
    }

    public static void setDescription(MimePart mimePart, String str, String str2) throws MessagingException {
        if (str == null) {
            mimePart.removeHeader("Content-Description");
            return;
        }
        try {
            mimePart.setHeader("Content-Description", MimeUtility.fold(21, MimeUtility.encodeText(str, str2, null)));
        } catch (UnsupportedEncodingException e2) {
            throw new MessagingException("Encoding error", e2);
        }
    }

    @Override // javax.mail.internet.MimePart
    public void setText(String str, String str2, String str3) throws MessagingException {
        setText(this, str, str2, str3);
    }

    public static void setText(MimePart mimePart, String str, String str2, String str3) throws MessagingException {
        if (str2 == null) {
            str2 = MimeUtility.checkAscii(str) != 1 ? MimeUtility.getDefaultMIMECharset() : "us-ascii";
        }
        mimePart.setContent(str, "text/" + str3 + "; charset=" + MimeUtility.quote(str2, HeaderTokenizer.MIME));
    }

    @Override // javax.mail.Part
    public void setContent(Multipart multipart) throws MessagingException {
        setDataHandler(new DataHandler(multipart, multipart.getContentType()));
        multipart.setParent(this);
    }

    public void attachFile(String str) throws MessagingException, IOException {
        attachFile(new File(str));
    }

    public void attachFile(File file, String str, String str2) throws MessagingException, IOException {
        EncodedFileDataSource encodedFileDataSource = new EncodedFileDataSource(file, str, str2);
        setDataHandler(new DataHandler(encodedFileDataSource));
        setFileName(encodedFileDataSource.getName());
        setDisposition(Part.ATTACHMENT);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0090 A[Catch: IOException -> 0x0134, TryCatch #0 {IOException -> 0x0134, blocks: (B:5:0x000b, B:9:0x001a, B:11:0x0027, B:13:0x002b, B:24:0x004d, B:26:0x0051, B:32:0x008c, B:34:0x0090, B:37:0x009b, B:38:0x00a2, B:40:0x00a8, B:43:0x00ae, B:45:0x00b6, B:47:0x00bf, B:49:0x00c3, B:51:0x00cb, B:53:0x00d1, B:55:0x00d7, B:59:0x00e6, B:58:0x00e2, B:61:0x00ef, B:63:0x00f3, B:65:0x00fc, B:67:0x0109, B:69:0x010f, B:70:0x0117, B:73:0x011d, B:75:0x012c, B:74:0x0125, B:76:0x0130, B:27:0x0057, B:28:0x0082, B:16:0x0033, B:17:0x0038, B:19:0x003c, B:22:0x0044, B:23:0x0049, B:29:0x0083), top: B:81:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae A[Catch: IOException -> 0x0134, TryCatch #0 {IOException -> 0x0134, blocks: (B:5:0x000b, B:9:0x001a, B:11:0x0027, B:13:0x002b, B:24:0x004d, B:26:0x0051, B:32:0x008c, B:34:0x0090, B:37:0x009b, B:38:0x00a2, B:40:0x00a8, B:43:0x00ae, B:45:0x00b6, B:47:0x00bf, B:49:0x00c3, B:51:0x00cb, B:53:0x00d1, B:55:0x00d7, B:59:0x00e6, B:58:0x00e2, B:61:0x00ef, B:63:0x00f3, B:65:0x00fc, B:67:0x0109, B:69:0x010f, B:70:0x0117, B:73:0x011d, B:75:0x012c, B:74:0x0125, B:76:0x0130, B:27:0x0057, B:28:0x0082, B:16:0x0033, B:17:0x0038, B:19:0x003c, B:22:0x0044, B:23:0x0049, B:29:0x0083), top: B:81:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef A[Catch: IOException -> 0x0134, TryCatch #0 {IOException -> 0x0134, blocks: (B:5:0x000b, B:9:0x001a, B:11:0x0027, B:13:0x002b, B:24:0x004d, B:26:0x0051, B:32:0x008c, B:34:0x0090, B:37:0x009b, B:38:0x00a2, B:40:0x00a8, B:43:0x00ae, B:45:0x00b6, B:47:0x00bf, B:49:0x00c3, B:51:0x00cb, B:53:0x00d1, B:55:0x00d7, B:59:0x00e6, B:58:0x00e2, B:61:0x00ef, B:63:0x00f3, B:65:0x00fc, B:67:0x0109, B:69:0x010f, B:70:0x0117, B:73:0x011d, B:75:0x012c, B:74:0x0125, B:76:0x0130, B:27:0x0057, B:28:0x0082, B:16:0x0033, B:17:0x0038, B:19:0x003c, B:22:0x0044, B:23:0x0049, B:29:0x0083), top: B:81:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void updateHeaders(javax.mail.internet.MimePart r9) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeBodyPart.updateHeaders(javax.mail.internet.MimePart):void");
    }

    public void saveFile(String str) throws Throwable {
        saveFile(new File(str));
    }

    public void attachFile(String str, String str2, String str3) throws MessagingException, IOException {
        attachFile(new File(str), str2, str3);
    }

    public MimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        this.headers = internetHeaders;
        this.content = bArr;
    }
}
