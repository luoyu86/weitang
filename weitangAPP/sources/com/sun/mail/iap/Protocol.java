package com.sun.mail.iap;

import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import com.tom_roush.pdfbox.pdfparser.BaseParser;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public class Protocol {
    private final List<ResponseHandler> handlers;
    public String host;
    private volatile ResponseInputStream input;
    private String localHostName;
    public MailLogger logger;
    private volatile DataOutputStream output;
    public String prefix;
    public Properties props;
    public boolean quote;
    private Socket socket;
    private int tagCounter;
    private final String tagPrefix;
    private volatile long timestamp;
    private TraceInputStream traceInput;
    public MailLogger traceLogger;
    private TraceOutputStream traceOutput;
    public static final AtomicInteger tagNum = new AtomicInteger();
    private static final byte[] CRLF = {BaseParser.ASCII_CR, 10};

    public Protocol(String str, int i2, Properties properties, String str2, boolean z, MailLogger mailLogger) throws ProtocolException, IOException {
        this.tagCounter = 0;
        this.handlers = new CopyOnWriteArrayList();
        this.tagPrefix = computePrefix(properties, str2);
        try {
            this.host = str;
            this.props = properties;
            this.prefix = str2;
            this.logger = mailLogger;
            this.traceLogger = mailLogger.getSubLogger("protocol", null);
            this.socket = SocketFetcher.getSocket(str, i2, properties, str2, z);
            this.quote = PropUtil.getBooleanProperty(properties, "mail.debug.quote", false);
            initStreams();
            processGreeting(readResponse());
            this.timestamp = System.currentTimeMillis();
        } catch (Throwable th) {
            disconnect();
            throw th;
        }
    }

    private void commandEnd() {
    }

    private void commandStart(String str) {
    }

    private String computePrefix(Properties properties, String str) {
        String str2;
        if (PropUtil.getBooleanProperty(properties, str + ".reusetagprefix", false)) {
            return "A";
        }
        int andIncrement = tagNum.getAndIncrement() % 18278;
        if (andIncrement < 26) {
            return new String(new char[]{(char) (andIncrement + 65)});
        }
        if (andIncrement < 702) {
            int i2 = andIncrement - 26;
            str2 = new String(new char[]{(char) ((i2 / 26) + 65), (char) ((i2 % 26) + 65)});
        } else {
            int i3 = andIncrement - 702;
            str2 = new String(new char[]{(char) ((i3 / 676) + 65), (char) (((i3 % 676) / 26) + 65), (char) ((i3 % 26) + 65)});
        }
        return str2;
    }

    private static SocketChannel findSocketChannel(Socket socket) {
        SocketChannel channel;
        for (Class<?> superclass = socket.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField("socket");
                declaredField.setAccessible(true);
                channel = ((Socket) declaredField.get(socket)).getChannel();
            } catch (Exception unused) {
            }
            if (channel != null) {
                return channel;
            }
        }
        for (Class<?> superclass2 = socket.getClass(); superclass2 != Object.class; superclass2 = superclass2.getSuperclass()) {
            try {
                for (Field field : superclass2.getDeclaredFields()) {
                    if (Socket.class.isAssignableFrom(field.getType())) {
                        try {
                            field.setAccessible(true);
                            SocketChannel channel2 = ((Socket) field.get(socket)).getChannel();
                            if (channel2 != null) {
                                return channel2;
                            }
                        } catch (Exception unused2) {
                            continue;
                        }
                    }
                }
            } catch (Exception unused3) {
            }
        }
        return null;
    }

    private void initStreams() throws IOException {
        TraceInputStream traceInputStream = new TraceInputStream(this.socket.getInputStream(), this.traceLogger);
        this.traceInput = traceInputStream;
        traceInputStream.setQuote(this.quote);
        this.input = new ResponseInputStream(this.traceInput);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.socket.getOutputStream(), this.traceLogger);
        this.traceOutput = traceOutputStream;
        traceOutputStream.setQuote(this.quote);
        this.output = new DataOutputStream(new BufferedOutputStream(this.traceOutput));
    }

    public void addResponseHandler(ResponseHandler responseHandler) {
        this.handlers.add(responseHandler);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b A[Catch: all -> 0x0072, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000c, B:14:0x0026, B:15:0x002a, B:18:0x0032, B:20:0x003b, B:29:0x005b, B:30:0x005e, B:24:0x0047, B:27:0x0054, B:8:0x0012, B:10:0x001b), top: B:36:0x0001, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.sun.mail.iap.Response[] command(java.lang.String r8, com.sun.mail.iap.Argument r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.commandStart(r8)     // Catch: java.lang.Throwable -> L72
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L72
            r0.<init>()     // Catch: java.lang.Throwable -> L72
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r8 = r7.writeCommand(r8, r9)     // Catch: java.lang.Exception -> L11 com.sun.mail.iap.LiteralException -> L1a java.lang.Throwable -> L72
            goto L24
        L11:
            r8 = move-exception
            com.sun.mail.iap.Response r8 = com.sun.mail.iap.Response.byeResponse(r8)     // Catch: java.lang.Throwable -> L72
            r0.add(r8)     // Catch: java.lang.Throwable -> L72
            goto L22
        L1a:
            r8 = move-exception
            com.sun.mail.iap.Response r8 = r8.getResponse()     // Catch: java.lang.Throwable -> L72
            r0.add(r8)     // Catch: java.lang.Throwable -> L72
        L22:
            r8 = r2
        L23:
            r1 = 1
        L24:
            if (r1 != 0) goto L59
            com.sun.mail.iap.Response r9 = r7.readResponse()     // Catch: com.sun.mail.iap.ProtocolException -> L46 java.io.IOException -> L51 java.lang.Throwable -> L72
            boolean r4 = r9.isBYE()     // Catch: java.lang.Throwable -> L72
            if (r4 == 0) goto L32
            r2 = r9
            goto L24
        L32:
            r0.add(r9)     // Catch: java.lang.Throwable -> L72
            boolean r4 = r9.isTagged()     // Catch: java.lang.Throwable -> L72
            if (r4 == 0) goto L24
            java.lang.String r9 = r9.getTag()     // Catch: java.lang.Throwable -> L72
            boolean r9 = r9.equals(r8)     // Catch: java.lang.Throwable -> L72
            if (r9 == 0) goto L24
            goto L23
        L46:
            r9 = move-exception
            com.sun.mail.util.MailLogger r4 = r7.logger     // Catch: java.lang.Throwable -> L72
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch: java.lang.Throwable -> L72
            java.lang.String r6 = "ignoring bad response"
            r4.log(r5, r6, r9)     // Catch: java.lang.Throwable -> L72
            goto L24
        L51:
            r8 = move-exception
            if (r2 != 0) goto L59
            com.sun.mail.iap.Response r8 = com.sun.mail.iap.Response.byeResponse(r8)     // Catch: java.lang.Throwable -> L72
            r2 = r8
        L59:
            if (r2 == 0) goto L5e
            r0.add(r2)     // Catch: java.lang.Throwable -> L72
        L5e:
            int r8 = r0.size()     // Catch: java.lang.Throwable -> L72
            com.sun.mail.iap.Response[] r8 = new com.sun.mail.iap.Response[r8]     // Catch: java.lang.Throwable -> L72
            r0.toArray(r8)     // Catch: java.lang.Throwable -> L72
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L72
            r7.timestamp = r0     // Catch: java.lang.Throwable -> L72
            r7.commandEnd()     // Catch: java.lang.Throwable -> L72
            monitor-exit(r7)
            return r8
        L72:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.iap.Protocol.command(java.lang.String, com.sun.mail.iap.Argument):com.sun.mail.iap.Response[]");
    }

    public synchronized void disconnect() {
        Socket socket = this.socket;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
            this.socket = null;
        }
    }

    public void finalize() throws Throwable {
        try {
            disconnect();
        } finally {
            super.finalize();
        }
    }

    public SocketChannel getChannel() {
        SocketChannel channel = this.socket.getChannel();
        if (channel != null) {
            return channel;
        }
        Socket socket = this.socket;
        return socket instanceof SSLSocket ? findSocketChannel(socket) : channel;
    }

    public InetAddress getInetAddress() {
        return this.socket.getInetAddress();
    }

    public ResponseInputStream getInputStream() {
        return this.input;
    }

    public synchronized String getLocalHost() {
        Socket socket;
        String str = this.localHostName;
        if (str == null || str.length() <= 0) {
            this.localHostName = this.props.getProperty(this.prefix + ".localhost");
        }
        String str2 = this.localHostName;
        if (str2 == null || str2.length() <= 0) {
            this.localHostName = this.props.getProperty(this.prefix + ".localaddress");
        }
        try {
            String str3 = this.localHostName;
            if (str3 == null || str3.length() <= 0) {
                InetAddress localHost = InetAddress.getLocalHost();
                String canonicalHostName = localHost.getCanonicalHostName();
                this.localHostName = canonicalHostName;
                if (canonicalHostName == null) {
                    this.localHostName = "[" + localHost.getHostAddress() + "]";
                }
            }
        } catch (UnknownHostException unused) {
        }
        String str4 = this.localHostName;
        if ((str4 == null || str4.length() <= 0) && (socket = this.socket) != null && socket.isBound()) {
            InetAddress localAddress = this.socket.getLocalAddress();
            String canonicalHostName2 = localAddress.getCanonicalHostName();
            this.localHostName = canonicalHostName2;
            if (canonicalHostName2 == null) {
                this.localHostName = "[" + localAddress.getHostAddress() + "]";
            }
        }
        return this.localHostName;
    }

    public SocketAddress getLocalSocketAddress() {
        return this.socket.getLocalSocketAddress();
    }

    public OutputStream getOutputStream() {
        return this.output;
    }

    public ByteArray getResponseBuffer() {
        return null;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void handleResult(Response response) throws ProtocolException {
        if (response.isOK()) {
            return;
        }
        if (response.isNO()) {
            throw new CommandFailedException(response);
        }
        if (response.isBAD()) {
            throw new BadCommandException(response);
        }
        if (response.isBYE()) {
            disconnect();
            throw new ConnectionException(this, response);
        }
    }

    public boolean hasResponse() {
        try {
            return this.input.available() > 0;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean isSSL() {
        return this.socket instanceof SSLSocket;
    }

    public boolean isTracing() {
        return this.traceLogger.isLoggable(Level.FINEST);
    }

    public void notifyResponseHandlers(Response[] responseArr) {
        if (this.handlers.isEmpty()) {
            return;
        }
        for (Response response : responseArr) {
            if (response != null) {
                for (ResponseHandler responseHandler : this.handlers) {
                    if (responseHandler != null) {
                        responseHandler.handleResponse(response);
                    }
                }
            }
        }
    }

    public void processGreeting(Response response) throws ProtocolException {
        if (response.isBYE()) {
            throw new ConnectionException(this, response);
        }
    }

    public Response readResponse() throws ProtocolException, IOException {
        return new Response(this);
    }

    public void removeResponseHandler(ResponseHandler responseHandler) {
        this.handlers.remove(responseHandler);
    }

    public void resumeTracing() {
        if (this.traceLogger.isLoggable(Level.FINEST)) {
            this.traceInput.setTrace(true);
            this.traceOutput.setTrace(true);
        }
    }

    public void simpleCommand(String str, Argument argument) throws ProtocolException {
        Response[] responseArrCommand = command(str, argument);
        notifyResponseHandlers(responseArrCommand);
        handleResult(responseArrCommand[responseArrCommand.length - 1]);
    }

    public synchronized void startCompression(String str) throws ProtocolException, IOException {
        simpleCommand(str, null);
        TraceInputStream traceInputStream = new TraceInputStream(new InflaterInputStream(this.socket.getInputStream(), new Inflater(true)), this.traceLogger);
        this.traceInput = traceInputStream;
        traceInputStream.setQuote(this.quote);
        this.input = new ResponseInputStream(this.traceInput);
        int intProperty = PropUtil.getIntProperty(this.props, this.prefix + ".compress.level", -1);
        int intProperty2 = PropUtil.getIntProperty(this.props, this.prefix + ".compress.strategy", 0);
        MailLogger mailLogger = this.logger;
        Level level = Level.FINE;
        if (mailLogger.isLoggable(level)) {
            this.logger.log(level, "Creating Deflater with compression level {0} and strategy {1}", Integer.valueOf(intProperty), Integer.valueOf(intProperty2));
        }
        Deflater deflater = new Deflater(-1, true);
        try {
            deflater.setLevel(intProperty);
        } catch (IllegalArgumentException e2) {
            this.logger.log(Level.FINE, "Ignoring bad compression level", (Throwable) e2);
        }
        try {
            deflater.setStrategy(intProperty2);
        } catch (IllegalArgumentException e3) {
            this.logger.log(Level.FINE, "Ignoring bad compression strategy", (Throwable) e3);
        }
        TraceOutputStream traceOutputStream = new TraceOutputStream(new DeflaterOutputStream(this.socket.getOutputStream(), deflater, true), this.traceLogger);
        this.traceOutput = traceOutputStream;
        traceOutputStream.setQuote(this.quote);
        this.output = new DataOutputStream(new BufferedOutputStream(this.traceOutput));
    }

    public synchronized void startTLS(String str) throws ProtocolException, IOException {
        if (this.socket instanceof SSLSocket) {
            return;
        }
        simpleCommand(str, null);
        this.socket = SocketFetcher.startTLS(this.socket, this.host, this.props, this.prefix);
        initStreams();
    }

    public synchronized boolean supportsNonSyncLiterals() {
        return false;
    }

    public boolean supportsUtf8() {
        return false;
    }

    public void suspendTracing() {
        if (this.traceLogger.isLoggable(Level.FINEST)) {
            this.traceInput.setTrace(false);
            this.traceOutput.setTrace(false);
        }
    }

    public String writeCommand(String str, Argument argument) throws ProtocolException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tagPrefix);
        int i2 = this.tagCounter;
        this.tagCounter = i2 + 1;
        sb.append(Integer.toString(i2));
        String string = sb.toString();
        this.output.writeBytes(string + " " + str);
        if (argument != null) {
            this.output.write(32);
            argument.write(this);
        }
        this.output.write(CRLF);
        this.output.flush();
        return string;
    }

    public Protocol(InputStream inputStream, PrintStream printStream, Properties properties, boolean z) throws IOException {
        this.tagCounter = 0;
        this.handlers = new CopyOnWriteArrayList();
        this.host = "localhost";
        this.props = properties;
        this.quote = false;
        this.tagPrefix = computePrefix(properties, "mail.imap");
        MailLogger mailLogger = new MailLogger(getClass(), "DEBUG", z, System.out);
        this.logger = mailLogger;
        this.traceLogger = mailLogger.getSubLogger("protocol", null);
        TraceInputStream traceInputStream = new TraceInputStream(inputStream, this.traceLogger);
        this.traceInput = traceInputStream;
        traceInputStream.setQuote(this.quote);
        this.input = new ResponseInputStream(this.traceInput);
        TraceOutputStream traceOutputStream = new TraceOutputStream(printStream, this.traceLogger);
        this.traceOutput = traceOutputStream;
        traceOutputStream.setQuote(this.quote);
        this.output = new DataOutputStream(new BufferedOutputStream(this.traceOutput));
        this.timestamp = System.currentTimeMillis();
    }
}
