package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.PropUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.MultipartDataSource;

/* JADX INFO: loaded from: classes2.dex */
public class MimeMultipart extends Multipart {
    public boolean allowEmpty;
    public boolean complete;
    public DataSource ds;
    public boolean ignoreExistingBoundaryParameter;
    public boolean ignoreMissingBoundaryParameter;
    public boolean ignoreMissingEndBoundary;
    public boolean parsed;
    public String preamble;

    public MimeMultipart() {
        this("mixed");
    }

    private static boolean allDashes(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) != '-') {
                return false;
            }
        }
        return true;
    }

    private MimeBodyPart createMimeBodyPartIs(InputStream inputStream) throws MessagingException {
        try {
            return createMimeBodyPart(inputStream);
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private static int readFully(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        while (i3 > 0) {
            int i5 = inputStream.read(bArr, i2, i3);
            if (i5 <= 0) {
                break;
            }
            i2 += i5;
            i4 += i5;
            i3 -= i5;
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }

    private void skipFully(InputStream inputStream, long j) throws IOException {
        while (j > 0) {
            long jSkip = inputStream.skip(j);
            if (jSkip <= 0) {
                throw new EOFException("can't skip");
            }
            j -= jSkip;
        }
    }

    @Override // javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart);
    }

    public InternetHeaders createInternetHeaders(InputStream inputStream) throws MessagingException {
        return new InternetHeaders(inputStream);
    }

    public MimeBodyPart createMimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        return new MimeBodyPart(internetHeaders, bArr);
    }

    @Override // javax.mail.Multipart
    public synchronized BodyPart getBodyPart(int i2) throws MessagingException {
        parse();
        return super.getBodyPart(i2);
    }

    @Override // javax.mail.Multipart
    public synchronized int getCount() throws MessagingException {
        parse();
        return super.getCount();
    }

    public synchronized String getPreamble() throws MessagingException {
        parse();
        return this.preamble;
    }

    public void initializeProperties() {
        this.ignoreMissingEndBoundary = PropUtil.getBooleanSystemProperty("mail.mime.multipart.ignoremissingendboundary", true);
        this.ignoreMissingBoundaryParameter = PropUtil.getBooleanSystemProperty("mail.mime.multipart.ignoremissingboundaryparameter", true);
        this.ignoreExistingBoundaryParameter = PropUtil.getBooleanSystemProperty("mail.mime.multipart.ignoreexistingboundaryparameter", false);
        this.allowEmpty = PropUtil.getBooleanSystemProperty("mail.mime.multipart.allowempty", false);
    }

    public synchronized boolean isComplete() throws MessagingException {
        parse();
        return this.complete;
    }

    /* JADX WARN: Code restructure failed: missing block: B:174:0x0261, code lost:
    
        r26 = r4;
        r4 = r17;
        r8 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0344, code lost:
    
        r2.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x006e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void parse() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instruction units count: 871
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parse():void");
    }

    @Override // javax.mail.Multipart
    public boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        return super.removeBodyPart(bodyPart);
    }

    public synchronized void setPreamble(String str) throws MessagingException {
        this.preamble = str;
    }

    public synchronized void setSubType(String str) throws MessagingException {
        ContentType contentType = new ContentType(this.contentType);
        contentType.setSubType(str);
        this.contentType = contentType.toString();
    }

    public synchronized void updateHeaders() throws MessagingException {
        parse();
        for (int i2 = 0; i2 < this.parts.size(); i2++) {
            ((MimeBodyPart) this.parts.elementAt(i2)).updateHeaders();
        }
    }

    @Override // javax.mail.Multipart
    public synchronized void writeTo(OutputStream outputStream) throws MessagingException, IOException {
        parse();
        String str = "--" + new ContentType(this.contentType).getParameter("boundary");
        LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
        String str2 = this.preamble;
        if (str2 != null) {
            byte[] bytes = ASCIIUtility.getBytes(str2);
            lineOutputStream.write(bytes);
            if (bytes.length > 0 && bytes[bytes.length - 1] != 13 && bytes[bytes.length - 1] != 10) {
                lineOutputStream.writeln();
            }
        }
        if (this.parts.size() != 0) {
            for (int i2 = 0; i2 < this.parts.size(); i2++) {
                lineOutputStream.writeln(str);
                ((MimeBodyPart) this.parts.elementAt(i2)).writeTo(outputStream);
                lineOutputStream.writeln();
            }
        } else {
            if (!this.allowEmpty) {
                throw new MessagingException("Empty multipart: " + this.contentType);
            }
            lineOutputStream.writeln(str);
            lineOutputStream.writeln();
        }
        lineOutputStream.writeln(str + "--");
    }

    public MimeMultipart(String str) {
        this.ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        this.ignoreMissingEndBoundary = true;
        this.ignoreMissingBoundaryParameter = true;
        this.ignoreExistingBoundaryParameter = false;
        this.allowEmpty = false;
        String uniqueBoundaryValue = UniqueValue.getUniqueBoundaryValue();
        ContentType contentType = new ContentType("multipart", str, null);
        contentType.setParameter("boundary", uniqueBoundaryValue);
        this.contentType = contentType.toString();
        initializeProperties();
    }

    public MimeBodyPart createMimeBodyPart(InputStream inputStream) throws MessagingException {
        return new MimeBodyPart(inputStream);
    }

    public synchronized BodyPart getBodyPart(String str) throws MessagingException {
        parse();
        int count = getCount();
        for (int i2 = 0; i2 < count; i2++) {
            MimeBodyPart mimeBodyPart = (MimeBodyPart) getBodyPart(i2);
            String contentID = mimeBodyPart.getContentID();
            if (contentID != null && contentID.equals(str)) {
                return mimeBodyPart;
            }
        }
        return null;
    }

    @Override // javax.mail.Multipart
    public void removeBodyPart(int i2) throws MessagingException {
        parse();
        super.removeBodyPart(i2);
    }

    @Override // javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart, int i2) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart, i2);
    }

    public MimeMultipart(BodyPart... bodyPartArr) throws MessagingException {
        this();
        for (BodyPart bodyPart : bodyPartArr) {
            super.addBodyPart(bodyPart);
        }
    }

    public MimeMultipart(String str, BodyPart... bodyPartArr) throws MessagingException {
        this(str);
        for (BodyPart bodyPart : bodyPartArr) {
            super.addBodyPart(bodyPart);
        }
    }

    public MimeMultipart(DataSource dataSource) throws MessagingException {
        this.ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        this.ignoreMissingEndBoundary = true;
        this.ignoreMissingBoundaryParameter = true;
        this.ignoreExistingBoundaryParameter = false;
        this.allowEmpty = false;
        if (dataSource instanceof MessageAware) {
            setParent(((MessageAware) dataSource).getMessageContext().getPart());
        }
        if (dataSource instanceof MultipartDataSource) {
            setMultipartDataSource((MultipartDataSource) dataSource);
            return;
        }
        this.parsed = false;
        this.ds = dataSource;
        this.contentType = dataSource.getContentType();
    }
}
