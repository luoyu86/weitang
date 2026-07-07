package com.sun.mail.imap;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.MessagingException;

/* JADX INFO: loaded from: classes2.dex */
public class IMAPInputStream extends InputStream {
    private static final int slop = 64;
    private int blksize;
    private byte[] buf;
    private int bufcount;
    private int bufpos;
    private boolean lastBuffer;
    private int max;
    private IMAPMessage msg;
    private boolean peek;
    private int pos = 0;
    private ByteArray readbuf;
    private String section;

    public IMAPInputStream(IMAPMessage iMAPMessage, String str, int i2, boolean z) {
        this.msg = iMAPMessage;
        this.section = str;
        this.max = i2;
        this.peek = z;
        this.blksize = iMAPMessage.getFetchBlockSize();
    }

    private void checkSeen() {
        if (this.peek) {
            return;
        }
        try {
            Folder folder = this.msg.getFolder();
            if (folder == null || folder.getMode() == 1) {
                return;
            }
            IMAPMessage iMAPMessage = this.msg;
            Flags.Flag flag = Flags.Flag.SEEN;
            if (iMAPMessage.isSet(flag)) {
                return;
            }
            this.msg.setFlag(flag, true);
        } catch (MessagingException unused) {
        }
    }

    private void fill() throws IOException {
        int i2;
        int i3;
        BODY bodyPeekBody;
        int i4;
        ByteArray byteArray;
        if (this.lastBuffer || ((i2 = this.max) != -1 && this.pos >= i2)) {
            if (this.pos == 0) {
                checkSeen();
            }
            this.readbuf = null;
            return;
        }
        if (this.readbuf == null) {
            this.readbuf = new ByteArray(this.blksize + 64);
        }
        synchronized (this.msg.getMessageCacheLock()) {
            try {
                try {
                    IMAPProtocol protocol = this.msg.getProtocol();
                    if (this.msg.isExpunged()) {
                        throw new MessageRemovedIOException("No content for expunged message");
                    }
                    int sequenceNumber = this.msg.getSequenceNumber();
                    i3 = this.blksize;
                    int i5 = this.max;
                    if (i5 != -1) {
                        int i6 = this.pos;
                        if (i6 + i3 > i5) {
                            i3 = i5 - i6;
                        }
                    }
                    bodyPeekBody = this.peek ? protocol.peekBody(sequenceNumber, this.section, this.pos, i3, this.readbuf) : protocol.fetchBody(sequenceNumber, this.section, this.pos, i3, this.readbuf);
                    i4 = 0;
                    i4 = 0;
                    if (bodyPeekBody == null || (byteArray = bodyPeekBody.getByteArray()) == null) {
                        forceCheckExpunged();
                        byteArray = new ByteArray(0);
                    }
                } catch (FolderClosedException e2) {
                    throw new FolderClosedIOException(e2.getFolder(), e2.getMessage());
                }
            } catch (ProtocolException e3) {
                forceCheckExpunged();
                throw new IOException(e3.getMessage());
            }
        }
        if (this.pos == 0) {
            checkSeen();
        }
        this.buf = byteArray.getBytes();
        this.bufpos = byteArray.getStart();
        int count = byteArray.getCount();
        int origin = bodyPeekBody != null ? bodyPeekBody.getOrigin() : this.pos;
        if (origin < 0) {
            if (this.pos == 0) {
                this.lastBuffer = count != i3;
                i4 = count;
            } else {
                this.lastBuffer = true;
            }
        } else if (origin == this.pos) {
            this.lastBuffer = count < i3;
            i4 = count;
        } else {
            this.lastBuffer = true;
        }
        this.bufcount = this.bufpos + i4;
        this.pos += i4;
    }

    private void forceCheckExpunged() throws MessageRemovedIOException, FolderClosedIOException {
        synchronized (this.msg.getMessageCacheLock()) {
            try {
                try {
                    this.msg.getProtocol().noop();
                } catch (ProtocolException unused) {
                } catch (FolderClosedException e2) {
                    throw new FolderClosedIOException(e2.getFolder(), e2.getMessage());
                }
            } catch (ConnectionException e3) {
                throw new FolderClosedIOException(this.msg.getFolder(), e3.getMessage());
            }
        }
        if (this.msg.isExpunged()) {
            throw new MessageRemovedIOException();
        }
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        return this.bufcount - this.bufpos;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.bufpos >= this.bufcount) {
            fill();
            if (this.bufpos >= this.bufcount) {
                return -1;
            }
        }
        byte[] bArr = this.buf;
        int i2 = this.bufpos;
        this.bufpos = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.bufcount - this.bufpos;
        if (i4 <= 0) {
            fill();
            i4 = this.bufcount - this.bufpos;
            if (i4 <= 0) {
                return -1;
            }
        }
        if (i4 < i3) {
            i3 = i4;
        }
        System.arraycopy(this.buf, this.bufpos, bArr, i2, i3);
        this.bufpos += i3;
        return i3;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
