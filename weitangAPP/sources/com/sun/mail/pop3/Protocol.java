package com.sun.mail.pop3;

import androidx.appcompat.widget.ActivityChooserView;
import com.alipay.sdk.m.u.h;
import com.sun.mail.auth.Ntlm;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class Protocol {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CRLF = "\r\n";
    private static final int POP3_PORT = 110;
    private static final int SLOP = 128;
    private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String apopChallenge;
    private String defaultAuthenticationMechanisms;
    private String host;
    private BufferedReader input;
    private String localHostName;
    private MailLogger logger;
    private boolean noauthdebug;
    private PrintWriter output;
    private boolean pipelining;
    private String prefix;
    private Properties props;
    private Socket socket;
    private TraceInputStream traceInput;
    private MailLogger traceLogger;
    private TraceOutputStream traceOutput;
    private boolean traceSuspended;
    private Map<String, String> capabilities = null;
    private Map<String, Authenticator> authenticators = new HashMap();

    public abstract class Authenticator {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean enabled;
        private final String mech;
        public Response resp;

        public Authenticator(Protocol protocol, String str) {
            this(str, true);
        }

        public boolean authenticate(String str, String str2, String str3, String str4) throws IOException {
            String str5;
            str5 = "succeeded";
            try {
                try {
                    String initialResponse = getInitialResponse(str, str2, str3, str4);
                    if (Protocol.this.noauthdebug && Protocol.this.isTracing()) {
                        Protocol.this.logger.fine("AUTH " + this.mech + " command trace suppressed");
                        Protocol.this.suspendTracing();
                    }
                    runAuthenticationCommand("AUTH " + this.mech, initialResponse);
                    if (this.resp.cont) {
                        doAuth(str, str2, str3, str4);
                    }
                    if (Protocol.this.noauthdebug && Protocol.this.isTracing()) {
                        MailLogger mailLogger = Protocol.this.logger;
                        StringBuilder sb = new StringBuilder();
                        sb.append("AUTH ");
                        sb.append(this.mech);
                        sb.append(" ");
                        sb.append(this.resp.ok ? "succeeded" : h.j);
                        mailLogger.fine(sb.toString());
                    }
                    Protocol.this.resumeTracing();
                    if (this.resp.ok) {
                        return true;
                    }
                    Protocol.this.close();
                    String str6 = this.resp.data;
                    throw new EOFException(str6 != null ? str6 : "authentication failed");
                } catch (IOException e2) {
                    Protocol.this.logger.log(Level.FINE, "AUTH " + this.mech + " failed", (Throwable) e2);
                    if (Protocol.this.noauthdebug && Protocol.this.isTracing()) {
                        MailLogger mailLogger2 = Protocol.this.logger;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AUTH ");
                        sb2.append(this.mech);
                        sb2.append(" ");
                        str5 = this.resp.ok ? "succeeded" : h.j;
                        sb2.append(str5);
                        mailLogger2.fine(sb2.toString());
                    }
                    Protocol.this.resumeTracing();
                    if (!this.resp.ok) {
                        Protocol.this.close();
                        String str7 = this.resp.data;
                        throw new EOFException(str7 != null ? str7 : "authentication failed");
                    }
                    return true;
                } catch (Throwable th) {
                    Protocol.this.logger.log(Level.FINE, "AUTH " + this.mech + " failed", (Throwable) th);
                    if (Protocol.this.noauthdebug && Protocol.this.isTracing()) {
                        MailLogger mailLogger3 = Protocol.this.logger;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("AUTH ");
                        sb3.append(this.mech);
                        sb3.append(" ");
                        str5 = this.resp.ok ? "succeeded" : h.j;
                        sb3.append(str5);
                        mailLogger3.fine(sb3.toString());
                    }
                    Protocol.this.resumeTracing();
                    if (!this.resp.ok) {
                        Protocol.this.close();
                        if (th instanceof Error) {
                            throw th;
                        }
                        if (!(th instanceof Exception)) {
                            String str8 = this.resp.data;
                            throw new EOFException(str8 != null ? str8 : "authentication failed");
                        }
                        String str9 = this.resp.data;
                        EOFException eOFException = new EOFException(str9 != null ? str9 : "authentication failed");
                        eOFException.initCause(th);
                        throw eOFException;
                    }
                    return true;
                }
            } catch (Throwable th2) {
                if (Protocol.this.noauthdebug && Protocol.this.isTracing()) {
                    MailLogger mailLogger4 = Protocol.this.logger;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("AUTH ");
                    sb4.append(this.mech);
                    sb4.append(" ");
                    if (!this.resp.ok) {
                        str5 = h.j;
                    }
                    sb4.append(str5);
                    mailLogger4.fine(sb4.toString());
                }
                Protocol.this.resumeTracing();
                if (this.resp.ok) {
                    throw th2;
                }
                Protocol.this.close();
                String str10 = this.resp.data;
                throw new EOFException(str10 != null ? str10 : "authentication failed");
            }
        }

        public abstract void doAuth(String str, String str2, String str3, String str4) throws IOException;

        public boolean enabled() {
            return this.enabled;
        }

        public String getInitialResponse(String str, String str2, String str3, String str4) throws IOException {
            return null;
        }

        public String getMechanism() {
            return this.mech;
        }

        public void runAuthenticationCommand(String str, String str2) throws IOException {
            if (Protocol.this.logger.isLoggable(Level.FINE)) {
                Protocol.this.logger.fine(str + " using one line authentication format");
            }
            if (str2 == null) {
                this.resp = Protocol.this.simpleCommand(str);
                return;
            }
            Protocol protocol = Protocol.this;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            if (str2.length() == 0) {
                str2 = "=";
            }
            sb.append(str2);
            this.resp = protocol.simpleCommand(sb.toString());
        }

        public Authenticator(String str, boolean z) {
            this.mech = str.toUpperCase(Locale.ENGLISH);
            this.enabled = z;
        }
    }

    public class LoginAuthenticator extends Authenticator {
        public LoginAuthenticator() {
            super(Protocol.this, "LOGIN");
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        public boolean authenticate(String str, String str2, String str3, String str4) throws IOException {
            String strLogin = Protocol.this.login(str3, str4);
            if (strLogin == null) {
                return true;
            }
            throw new EOFException(strLogin);
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        public void doAuth(String str, String str2, String str3, String str4) throws IOException {
            throw new EOFException("LOGIN asked for more");
        }
    }

    public class NtlmAuthenticator extends Authenticator {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private Ntlm ntlm;

        public NtlmAuthenticator() {
            super(Protocol.this, "NTLM");
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        public void doAuth(String str, String str2, String str3, String str4) throws IOException {
            this.resp = Protocol.this.simpleCommand(this.ntlm.generateType3Msg(this.resp.data.substring(4).trim()));
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        public String getInitialResponse(String str, String str2, String str3, String str4) throws IOException {
            this.ntlm = new Ntlm(Protocol.this.props.getProperty(Protocol.this.prefix + ".auth.ntlm.domain"), Protocol.this.getLocalHost(), str3, str4, Protocol.this.logger);
            return this.ntlm.generateType1Msg(PropUtil.getIntProperty(Protocol.this.props, Protocol.this.prefix + ".auth.ntlm.flags", 0), PropUtil.getBooleanProperty(Protocol.this.props, Protocol.this.prefix + ".auth.ntlm.v2", true));
        }
    }

    public class OAuth2Authenticator extends Authenticator {
        public OAuth2Authenticator() {
            super("XOAUTH2", false);
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        public void doAuth(String str, String str2, String str3, String str4) throws IOException {
            String str5 = this.resp.data;
            throw new EOFException("OAUTH2 authentication failed: " + (str5 != null ? new String(BASE64DecoderStream.decode(str5.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8) : ""));
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        public String getInitialResponse(String str, String str2, String str3, String str4) throws IOException {
            return ASCIIUtility.toString(BASE64EncoderStream.encode(("user=" + str3 + "\u0001auth=Bearer " + str4 + "\u0001\u0001").getBytes(StandardCharsets.UTF_8)));
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        public void runAuthenticationCommand(String str, String str2) throws IOException {
            Protocol protocol = Protocol.this;
            if (!Boolean.valueOf(protocol.getBoolProp(protocol.props, Protocol.this.prefix + ".auth.xoauth2.two.line.authentication.format")).booleanValue()) {
                super.runAuthenticationCommand(str, str2);
                return;
            }
            if (Protocol.this.logger.isLoggable(Level.FINE)) {
                Protocol.this.logger.fine(str + " using two line authentication format");
            }
            Protocol protocol2 = Protocol.this;
            if (str2.length() == 0) {
                str2 = "=";
            }
            this.resp = protocol2.twoLinesCommand(str, str2);
        }
    }

    public class PlainAuthenticator extends Authenticator {
        public PlainAuthenticator() {
            super(Protocol.this, "PLAIN");
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        public void doAuth(String str, String str2, String str3, String str4) throws IOException {
            throw new EOFException("PLAIN asked for more");
        }

        @Override // com.sun.mail.pop3.Protocol.Authenticator
        public String getInitialResponse(String str, String str2, String str3, String str4) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (str2 != null) {
                bASE64EncoderStream.write(str2.getBytes(StandardCharsets.UTF_8));
            }
            bASE64EncoderStream.write(0);
            bASE64EncoderStream.write(str3.getBytes(StandardCharsets.UTF_8));
            bASE64EncoderStream.write(0);
            bASE64EncoderStream.write(str4.getBytes(StandardCharsets.UTF_8));
            bASE64EncoderStream.flush();
            return ASCIIUtility.toString(byteArrayOutputStream.toByteArray());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Protocol(java.lang.String r10, int r11, com.sun.mail.util.MailLogger r12, java.util.Properties r13, java.lang.String r14, boolean r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.Protocol.<init>(java.lang.String, int, com.sun.mail.util.MailLogger, java.util.Properties, java.lang.String, boolean):void");
    }

    private void batchCommandContinue(String str) {
    }

    private void batchCommandEnd() {
    }

    private void batchCommandStart(String str) {
    }

    private static IOException cleanupAndThrow(Socket socket, IOException iOException) {
        try {
            socket.close();
        } catch (Throwable th) {
            if (!isRecoverable(th)) {
                th.addSuppressed(iOException);
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw new RuntimeException("unexpected exception", th);
            }
            iOException.addSuppressed(th);
        }
        return iOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean getBoolProp(Properties properties, String str) {
        boolean booleanProperty;
        booleanProperty = PropUtil.getBooleanProperty(properties, str, false);
        if (this.logger.isLoggable(Level.CONFIG)) {
            this.logger.config(str + ": " + booleanProperty);
        }
        return booleanProperty;
    }

    private String getDigest(String str) {
        try {
            return toHex(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest((this.apopChallenge + str).getBytes("iso-8859-1")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String getLocalHost() {
        Socket socket;
        try {
            String str = this.localHostName;
            if (str == null || str.length() == 0) {
                InetAddress localHost = InetAddress.getLocalHost();
                String canonicalHostName = localHost.getCanonicalHostName();
                this.localHostName = canonicalHostName;
                if (canonicalHostName == null) {
                    this.localHostName = "[" + localHost.getHostAddress() + "]";
                }
            }
        } catch (UnknownHostException unused) {
        }
        String str2 = this.localHostName;
        if ((str2 == null || str2.length() <= 0) && (socket = this.socket) != null && socket.isBound()) {
            InetAddress localAddress = this.socket.getLocalAddress();
            String canonicalHostName2 = localAddress.getCanonicalHostName();
            this.localHostName = canonicalHostName2;
            if (canonicalHostName2 == null) {
                this.localHostName = "[" + localAddress.getHostAddress() + "]";
            }
        }
        return this.localHostName;
    }

    private void initStreams() throws IOException {
        boolean booleanProperty = PropUtil.getBooleanProperty(this.props, "mail.debug.quote", false);
        TraceInputStream traceInputStream = new TraceInputStream(this.socket.getInputStream(), this.traceLogger);
        this.traceInput = traceInputStream;
        traceInputStream.setQuote(booleanProperty);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.socket.getOutputStream(), this.traceLogger);
        this.traceOutput = traceOutputStream;
        traceOutputStream.setQuote(booleanProperty);
        this.input = new BufferedReader(new InputStreamReader(this.traceInput, "iso-8859-1"));
        this.output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.traceOutput, "iso-8859-1")));
    }

    private static boolean isRecoverable(Throwable th) {
        return (th instanceof Exception) || (th instanceof LinkageError);
    }

    private void issueCommand(String str) throws IOException {
        if (this.socket == null) {
            throw new IOException("Folder is closed");
        }
        if (str != null) {
            this.output.print(str + "\r\n");
            this.output.flush();
        }
    }

    private Response multilineCommand(String str, int i2) throws IOException {
        multilineCommandStart(str);
        issueCommand(str);
        Response response = readResponse();
        if (!response.ok) {
            multilineCommandEnd();
            return response;
        }
        response.bytes = readMultilineResponse(i2);
        multilineCommandEnd();
        return response;
    }

    private void multilineCommandEnd() {
    }

    private void multilineCommandStart(String str) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        r2 = r3.input.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.InputStream readMultilineResponse(int r4) throws java.io.IOException {
        /*
            r3 = this;
            com.sun.mail.util.SharedByteArrayOutputStream r0 = new com.sun.mail.util.SharedByteArrayOutputStream
            r0.<init>(r4)
            r4 = 10
            r1 = 10
        L9:
            java.io.BufferedReader r2 = r3.input     // Catch: java.io.InterruptedIOException -> L3c
            int r2 = r2.read()     // Catch: java.io.InterruptedIOException -> L3c
            if (r2 < 0) goto L2d
            if (r1 != r4) goto L28
            r1 = 46
            if (r2 != r1) goto L28
            java.io.BufferedReader r1 = r3.input     // Catch: java.io.InterruptedIOException -> L3c
            int r1 = r1.read()     // Catch: java.io.InterruptedIOException -> L3c
            r2 = 13
            if (r1 != r2) goto L29
            java.io.BufferedReader r4 = r3.input     // Catch: java.io.InterruptedIOException -> L3c
            int r2 = r4.read()     // Catch: java.io.InterruptedIOException -> L3c
            goto L2d
        L28:
            r1 = r2
        L29:
            r0.write(r1)     // Catch: java.io.InterruptedIOException -> L3c
            goto L9
        L2d:
            if (r2 < 0) goto L34
            java.io.InputStream r4 = r0.toStream()
            return r4
        L34:
            java.io.EOFException r4 = new java.io.EOFException
            java.lang.String r0 = "EOF on socket"
            r4.<init>(r0)
            throw r4
        L3c:
            r4 = move-exception
            java.net.Socket r0 = r3.socket     // Catch: java.io.IOException -> L42
            r0.close()     // Catch: java.io.IOException -> L42
        L42:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.Protocol.readMultilineResponse(int):java.io.InputStream");
    }

    private Response readResponse() throws IOException {
        try {
            String line = this.input.readLine();
            if (line == null) {
                this.traceLogger.finest("<EOF>");
                throw new EOFException("EOF on socket");
            }
            Response response = new Response();
            if (line.startsWith("+OK")) {
                response.ok = true;
            } else if (line.startsWith("+ ")) {
                response.ok = true;
                response.cont = true;
            } else {
                if (!line.startsWith("-ERR")) {
                    throw new IOException("Unexpected response: " + line);
                }
                response.ok = false;
            }
            int iIndexOf = line.indexOf(32);
            if (iIndexOf >= 0) {
                response.data = line.substring(iIndexOf + 1);
            }
            return response;
        } catch (InterruptedIOException e2) {
            try {
                this.socket.close();
            } catch (IOException unused) {
            }
            throw new EOFException(e2.getMessage());
        } catch (SocketException e3) {
            try {
                this.socket.close();
            } catch (IOException unused2) {
            }
            throw new EOFException(e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeTracing() {
        if (this.traceLogger.isLoggable(Level.FINEST)) {
            this.traceInput.setTrace(true);
            this.traceOutput.setTrace(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response simpleCommand(String str) throws IOException {
        simpleCommandStart(str);
        issueCommand(str);
        Response response = readResponse();
        simpleCommandEnd();
        return response;
    }

    private void simpleCommandEnd() {
    }

    private void simpleCommandStart(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void suspendTracing() {
        if (this.traceLogger.isLoggable(Level.FINEST)) {
            this.traceInput.setTrace(false);
            this.traceOutput.setTrace(false);
        }
    }

    private static String toHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = b2 & 255;
            int i4 = i2 + 1;
            char[] cArr2 = digits;
            cArr[i2] = cArr2[i3 >> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response twoLinesCommand(String str, String str2) throws IOException {
        String str3 = str + " " + str2;
        batchCommandStart(str3);
        simpleCommand(str);
        batchCommandContinue(str3);
        Response responseSimpleCommand = simpleCommand(str2);
        batchCommandEnd();
        return responseSimpleCommand;
    }

    public synchronized String authenticate(String str, String str2, String str3, String str4, String str5) {
        Authenticator authenticator = this.authenticators.get(str.toUpperCase(Locale.ENGLISH));
        if (authenticator == null) {
            return "No such authentication mechanism: " + str;
        }
        try {
            if (authenticator.authenticate(str2, str3, str4, str5)) {
                return null;
            }
            return "login failed";
        } catch (IOException e2) {
            return e2.getMessage();
        }
    }

    public synchronized InputStream capa() throws IOException {
        Response responseMultilineCommand = multilineCommand("CAPA", 128);
        if (!responseMultilineCommand.ok) {
            return null;
        }
        return responseMultilineCommand.bytes;
    }

    public void close() {
        try {
            Socket socket = this.socket;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.socket = null;
            this.input = null;
            this.output = null;
            throw th;
        }
        this.socket = null;
        this.input = null;
        this.output = null;
    }

    public synchronized boolean dele(int i2) throws IOException {
        return simpleCommand("DELE " + i2).ok;
    }

    public void finalize() throws Throwable {
        try {
            if (this.socket != null) {
                quit();
            }
        } finally {
            super.finalize();
        }
    }

    public synchronized Map<String, String> getCapabilities() {
        return this.capabilities;
    }

    public String getDefaultMechanisms() {
        return this.defaultAuthenticationMechanisms;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean hasCapability(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.capabilities     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L13
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L16
            java.lang.String r3 = r3.toUpperCase(r1)     // Catch: java.lang.Throwable -> L16
            boolean r3 = r0.containsKey(r3)     // Catch: java.lang.Throwable -> L16
            if (r3 == 0) goto L13
            r3 = 1
            goto L14
        L13:
            r3 = 0
        L14:
            monitor-exit(r2)
            return r3
        L16:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.Protocol.hasCapability(java.lang.String):boolean");
    }

    public boolean isMechanismEnabled(String str) {
        Authenticator authenticator = this.authenticators.get(str.toUpperCase(Locale.ENGLISH));
        return authenticator != null && authenticator.enabled();
    }

    public synchronized boolean isSSL() {
        return this.socket instanceof SSLSocket;
    }

    public boolean isTracing() {
        return this.traceLogger.isLoggable(Level.FINEST);
    }

    public synchronized int list(int i2) throws IOException {
        int i3;
        Response responseSimpleCommand = simpleCommand("LIST " + i2);
        i3 = -1;
        if (responseSimpleCommand.ok && responseSimpleCommand.data != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(responseSimpleCommand.data);
                stringTokenizer.nextToken();
                i3 = Integer.parseInt(stringTokenizer.nextToken());
            } catch (RuntimeException unused) {
            }
        }
        return i3;
    }

    public synchronized String login(String str, String str2) throws IOException {
        Response responseSimpleCommand;
        boolean z = this.pipelining && (this.socket instanceof SSLSocket);
        try {
            if (this.noauthdebug && isTracing()) {
                this.logger.fine("authentication command trace suppressed");
                suspendTracing();
            }
            String digest = this.apopChallenge != null ? getDigest(str2) : null;
            if (this.apopChallenge != null && digest != null) {
                responseSimpleCommand = simpleCommand("APOP " + str + " " + digest);
            } else if (z) {
                String str3 = "USER " + str;
                batchCommandStart(str3);
                issueCommand(str3);
                String str4 = "PASS " + str2;
                batchCommandContinue(str4);
                issueCommand(str4);
                Response response = readResponse();
                if (!response.ok) {
                    String str5 = response.data;
                    if (str5 == null) {
                        str5 = "USER command failed";
                    }
                    readResponse();
                    batchCommandEnd();
                    return str5;
                }
                responseSimpleCommand = readResponse();
                batchCommandEnd();
            } else {
                Response responseSimpleCommand2 = simpleCommand("USER " + str);
                if (!responseSimpleCommand2.ok) {
                    String str6 = responseSimpleCommand2.data;
                    if (str6 == null) {
                        str6 = "USER command failed";
                    }
                    return str6;
                }
                responseSimpleCommand = simpleCommand("PASS " + str2);
            }
            if (this.noauthdebug && isTracing()) {
                this.logger.log(Level.FINE, "authentication command {0}", responseSimpleCommand.ok ? "succeeded" : h.j);
            }
            if (responseSimpleCommand.ok) {
                return null;
            }
            String str7 = responseSimpleCommand.data;
            if (str7 == null) {
                str7 = "login failed";
            }
            return str7;
        } finally {
            resumeTracing();
        }
    }

    public synchronized boolean noop() throws IOException {
        return simpleCommand("NOOP").ok;
    }

    public synchronized boolean quit() throws IOException {
        try {
        } finally {
            close();
        }
        return simpleCommand("QUIT").ok;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.io.InputStream retr(int r6, int r7) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.Protocol.retr(int, int):java.io.InputStream");
    }

    public synchronized boolean rset() throws IOException {
        return simpleCommand("RSET").ok;
    }

    public synchronized void setCapabilities(InputStream inputStream) {
        BufferedReader bufferedReader = null;
        if (inputStream == null) {
            this.capabilities = null;
            return;
        }
        this.capabilities = new HashMap(10);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "us-ascii"));
        } catch (UnsupportedEncodingException unused) {
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    int iIndexOf = line.indexOf(32);
                    this.capabilities.put((iIndexOf > 0 ? line.substring(0, iIndexOf) : line).toUpperCase(Locale.ENGLISH), line);
                }
            } catch (IOException unused2) {
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
            try {
                break;
            } catch (IOException unused4) {
            }
        }
        inputStream.close();
    }

    public synchronized Status stat() throws IOException {
        Status status;
        Response responseSimpleCommand = simpleCommand("STAT");
        status = new Status();
        if (!responseSimpleCommand.ok) {
            throw new IOException("STAT command failed: " + responseSimpleCommand.data);
        }
        if (responseSimpleCommand.data != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(responseSimpleCommand.data);
                status.total = Integer.parseInt(stringTokenizer.nextToken());
                status.size = Integer.parseInt(stringTokenizer.nextToken());
            } catch (RuntimeException unused) {
            }
        }
        return status;
    }

    public synchronized boolean stls() throws IOException {
        if (this.socket instanceof SSLSocket) {
            return true;
        }
        Response responseSimpleCommand = simpleCommand("STLS");
        if (responseSimpleCommand.ok) {
            try {
                this.socket = SocketFetcher.startTLS(this.socket, this.host, this.props, this.prefix);
                initStreams();
            } catch (IOException e2) {
                try {
                    this.socket.close();
                    this.socket = null;
                    this.input = null;
                    this.output = null;
                    IOException iOException = new IOException("Could not convert socket to TLS");
                    iOException.initCause(e2);
                    throw iOException;
                } catch (Throwable th) {
                    this.socket = null;
                    this.input = null;
                    this.output = null;
                    throw th;
                }
            }
        }
        return responseSimpleCommand.ok;
    }

    public synchronized boolean supportsAuthentication(String str) {
        if (str.equals("LOGIN")) {
            return true;
        }
        Map<String, String> map = this.capabilities;
        if (map == null) {
            return false;
        }
        String str2 = map.get("SASL");
        if (str2 == null) {
            return false;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        while (stringTokenizer.hasMoreTokens()) {
            if (stringTokenizer.nextToken().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean supportsMechanism(String str) {
        return this.authenticators.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    public synchronized InputStream top(int i2, int i3) throws IOException {
        return multilineCommand("TOP " + i2 + " " + i3, 0).bytes;
    }

    public synchronized String uidl(int i2) throws IOException {
        Response responseSimpleCommand = simpleCommand("UIDL " + i2);
        if (!responseSimpleCommand.ok) {
            return null;
        }
        int iIndexOf = responseSimpleCommand.data.indexOf(32);
        if (iIndexOf <= 0) {
            return null;
        }
        return responseSimpleCommand.data.substring(iIndexOf + 1);
    }

    public synchronized InputStream list() throws IOException {
        return multilineCommand("LIST", 128).bytes;
    }

    public synchronized boolean uidl(String[] strArr) throws IOException {
        int i2;
        Response responseMultilineCommand = multilineCommand("UIDL", strArr.length * 15);
        if (!responseMultilineCommand.ok) {
            return false;
        }
        LineInputStream lineInputStream = new LineInputStream(responseMultilineCommand.bytes);
        while (true) {
            String line = lineInputStream.readLine();
            if (line != null) {
                int iIndexOf = line.indexOf(32);
                if (iIndexOf >= 1 && iIndexOf < line.length() && (i2 = Integer.parseInt(line.substring(0, iIndexOf))) > 0 && i2 <= strArr.length) {
                    strArr[i2 - 1] = line.substring(iIndexOf + 1);
                }
            } else {
                try {
                    break;
                } catch (IOException unused) {
                }
            }
        }
        responseMultilineCommand.bytes.close();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
    
        r2 = r5.input.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean retr(int r6, java.io.OutputStream r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r0.<init>()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r1 = "RETR "
            r0.append(r1)     // Catch: java.lang.Throwable -> L8f
            r0.append(r6)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L8f
            r5.multilineCommandStart(r6)     // Catch: java.lang.Throwable -> L8f
            r5.issueCommand(r6)     // Catch: java.lang.Throwable -> L8f
            com.sun.mail.pop3.Response r6 = r5.readResponse()     // Catch: java.lang.Throwable -> L8f
            boolean r6 = r6.ok     // Catch: java.lang.Throwable -> L8f
            if (r6 != 0) goto L26
            r5.multilineCommandEnd()     // Catch: java.lang.Throwable -> L8f
            r6 = 0
            monitor-exit(r5)
            return r6
        L26:
            r6 = 0
            r0 = 10
            r1 = 10
        L2b:
            java.io.BufferedReader r2 = r5.input     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            int r2 = r2.read()     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            if (r2 < 0) goto L67
            if (r1 != r0) goto L4a
            r1 = 46
            if (r2 != r1) goto L4a
            java.io.BufferedReader r1 = r5.input     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            int r1 = r1.read()     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            r2 = 13
            if (r1 != r2) goto L4b
            java.io.BufferedReader r7 = r5.input     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            int r2 = r7.read()     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            goto L67
        L4a:
            r1 = r2
        L4b:
            if (r6 != 0) goto L2b
            r7.write(r1)     // Catch: java.lang.RuntimeException -> L51 java.io.IOException -> L5c java.lang.Throwable -> L8f
            goto L2b
        L51:
            r6 = move-exception
            com.sun.mail.util.MailLogger r2 = r5.logger     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            java.util.logging.Level r3 = java.util.logging.Level.FINE     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            java.lang.String r4 = "exception while streaming"
            r2.log(r3, r4, r6)     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            goto L2b
        L5c:
            r6 = move-exception
            com.sun.mail.util.MailLogger r2 = r5.logger     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            java.util.logging.Level r3 = java.util.logging.Level.FINE     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            java.lang.String r4 = "exception while streaming"
            r2.log(r3, r4, r6)     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            goto L2b
        L67:
            if (r2 < 0) goto L80
            if (r6 == 0) goto L7a
            boolean r7 = r6 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L8f
            if (r7 != 0) goto L77
            boolean r7 = r6 instanceof java.lang.RuntimeException     // Catch: java.lang.Throwable -> L8f
            if (r7 != 0) goto L74
            goto L7a
        L74:
            java.lang.RuntimeException r6 = (java.lang.RuntimeException) r6     // Catch: java.lang.Throwable -> L8f
            throw r6     // Catch: java.lang.Throwable -> L8f
        L77:
            java.io.IOException r6 = (java.io.IOException) r6     // Catch: java.lang.Throwable -> L8f
            throw r6     // Catch: java.lang.Throwable -> L8f
        L7a:
            r5.multilineCommandEnd()     // Catch: java.lang.Throwable -> L8f
            r6 = 1
            monitor-exit(r5)
            return r6
        L80:
            java.io.EOFException r6 = new java.io.EOFException     // Catch: java.lang.Throwable -> L8f
            java.lang.String r7 = "EOF on socket"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L8f
            throw r6     // Catch: java.lang.Throwable -> L8f
        L88:
            r6 = move-exception
            java.net.Socket r7 = r5.socket     // Catch: java.io.IOException -> L8e java.lang.Throwable -> L8f
            r7.close()     // Catch: java.io.IOException -> L8e java.lang.Throwable -> L8f
        L8e:
            throw r6     // Catch: java.lang.Throwable -> L8f
        L8f:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.Protocol.retr(int, java.io.OutputStream):boolean");
    }
}
