package com.sun.mail.imap;

import com.sun.mail.util.MailLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import javax.mail.Message;

/* JADX INFO: loaded from: classes2.dex */
public class MessageCache {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int SLOP = 64;
    private IMAPFolder folder;
    private MailLogger logger;
    private IMAPMessage[] messages;
    private int[] seqnums;
    private int size;

    public MessageCache(IMAPFolder iMAPFolder, IMAPStore iMAPStore, int i2) {
        this.folder = iMAPFolder;
        MailLogger subLogger = iMAPFolder.logger.getSubLogger("messagecache", "DEBUG IMAP MC", iMAPStore.getMessageCacheDebug());
        this.logger = subLogger;
        if (subLogger.isLoggable(Level.CONFIG)) {
            this.logger.config("create cache of size " + i2);
        }
        ensureCapacity(i2, 1);
    }

    private void ensureCapacity(int i2, int i3) {
        IMAPMessage[] iMAPMessageArr = this.messages;
        if (iMAPMessageArr == null) {
            this.messages = new IMAPMessage[i2 + 64];
        } else if (iMAPMessageArr.length < i2) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("expand capacity to " + i2);
            }
            int i4 = i2 + 64;
            IMAPMessage[] iMAPMessageArr2 = new IMAPMessage[i4];
            IMAPMessage[] iMAPMessageArr3 = this.messages;
            System.arraycopy(iMAPMessageArr3, 0, iMAPMessageArr2, 0, iMAPMessageArr3.length);
            this.messages = iMAPMessageArr2;
            int[] iArr = this.seqnums;
            if (iArr != null) {
                int[] iArr2 = new int[i4];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                int i5 = this.size;
                while (i5 < i4) {
                    iArr2[i5] = i3;
                    i5++;
                    i3++;
                }
                this.seqnums = iArr2;
                if (this.logger.isLoggable(Level.FINE)) {
                    this.logger.fine("message " + i2 + " has sequence number " + this.seqnums[i2 - 1]);
                }
            }
        } else if (i2 < this.size) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("shrink capacity to " + i2);
            }
            for (int i6 = i2 + 1; i6 <= this.size; i6++) {
                int i7 = i6 - 1;
                this.messages[i7] = null;
                int[] iArr3 = this.seqnums;
                if (iArr3 != null) {
                    iArr3[i7] = -1;
                }
            }
        }
        this.size = i2;
    }

    private int msgnumOf(int i2) {
        if (this.seqnums == null) {
            return i2;
        }
        if (i2 < 1) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("bad seqnum " + i2);
            }
            return -1;
        }
        for (int i3 = i2; i3 <= this.size; i3++) {
            int[] iArr = this.seqnums;
            int i4 = i3 - 1;
            if (iArr[i4] == i2) {
                return i3;
            }
            if (iArr[i4] > i2) {
                break;
            }
        }
        return -1;
    }

    private void shrink(int i2, int i3) {
        this.size = i2 - 1;
        MailLogger mailLogger = this.logger;
        Level level = Level.FINE;
        if (mailLogger.isLoggable(level)) {
            this.logger.fine("size now " + this.size);
        }
        int i4 = this.size;
        if (i4 == 0) {
            this.messages = null;
            this.seqnums = null;
            return;
        }
        if (i4 > 64 && i4 < this.messages.length / 2) {
            this.logger.fine("reallocate array");
            int i5 = this.size;
            IMAPMessage[] iMAPMessageArr = new IMAPMessage[i5 + 64];
            System.arraycopy(this.messages, 0, iMAPMessageArr, 0, i5);
            this.messages = iMAPMessageArr;
            int[] iArr = this.seqnums;
            if (iArr != null) {
                int i6 = this.size;
                int[] iArr2 = new int[i6 + 64];
                System.arraycopy(iArr, 0, iArr2, 0, i6);
                this.seqnums = iArr2;
                return;
            }
            return;
        }
        if (this.logger.isLoggable(level)) {
            this.logger.fine("clean " + i2 + " to " + i3);
        }
        while (i2 < i3) {
            int i7 = i2 - 1;
            this.messages[i7] = null;
            int[] iArr3 = this.seqnums;
            if (iArr3 != null) {
                iArr3[i7] = 0;
            }
            i2++;
        }
    }

    public void addMessages(int i2, int i3) {
        if (this.logger.isLoggable(Level.FINE)) {
            this.logger.fine("add " + i2 + " messages");
        }
        ensureCapacity(this.size + i2, i3);
    }

    public void expungeMessage(int i2) {
        int iMsgnumOf = msgnumOf(i2);
        if (iMsgnumOf < 0) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("expunge no seqnum " + i2);
                return;
            }
            return;
        }
        int i3 = iMsgnumOf - 1;
        IMAPMessage iMAPMessage = this.messages[i3];
        if (iMAPMessage != null) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("expunge existing " + iMsgnumOf);
            }
            iMAPMessage.setExpunged(true);
        }
        int[] iArr = this.seqnums;
        if (iArr == null) {
            this.logger.fine("create seqnums array");
            this.seqnums = new int[this.messages.length];
            for (int i4 = 1; i4 < iMsgnumOf; i4++) {
                this.seqnums[i4 - 1] = i4;
            }
            this.seqnums[i3] = 0;
            int i5 = iMsgnumOf + 1;
            while (true) {
                int[] iArr2 = this.seqnums;
                if (i5 > iArr2.length) {
                    return;
                }
                int i6 = i5 - 1;
                iArr2[i6] = i6;
                i5++;
            }
        } else {
            iArr[i3] = 0;
            int i7 = iMsgnumOf + 1;
            while (true) {
                int[] iArr3 = this.seqnums;
                if (i7 > iArr3.length) {
                    return;
                }
                int i8 = i7 - 1;
                if (iArr3[i8] > 0) {
                    iArr3[i8] = iArr3[i8] - 1;
                }
                i7++;
            }
        }
    }

    public IMAPMessage getMessage(int i2) {
        if (i2 < 1 || i2 > this.size) {
            throw new ArrayIndexOutOfBoundsException("message number (" + i2 + ") out of bounds (" + this.size + ")");
        }
        int i3 = i2 - 1;
        IMAPMessage iMAPMessageNewIMAPMessage = this.messages[i3];
        if (iMAPMessageNewIMAPMessage == null) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("create message number " + i2);
            }
            iMAPMessageNewIMAPMessage = this.folder.newIMAPMessage(i2);
            this.messages[i3] = iMAPMessageNewIMAPMessage;
            if (seqnumOf(i2) <= 0) {
                this.logger.fine("it's expunged!");
                iMAPMessageNewIMAPMessage.setExpunged(true);
            }
        }
        return iMAPMessageNewIMAPMessage;
    }

    public IMAPMessage getMessageBySeqnum(int i2) {
        int iMsgnumOf = msgnumOf(i2);
        if (iMsgnumOf >= 0) {
            return getMessage(iMsgnumOf);
        }
        if (!this.logger.isLoggable(Level.FINE)) {
            return null;
        }
        this.logger.fine("no message seqnum " + i2);
        return null;
    }

    public IMAPMessage[] removeExpungedMessages() {
        this.logger.fine("remove expunged messages");
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 1;
        while (i2 <= this.size) {
            if (seqnumOf(i2) <= 0) {
                arrayList.add(getMessage(i2));
            } else {
                if (i3 != i2) {
                    IMAPMessage[] iMAPMessageArr = this.messages;
                    int i4 = i3 - 1;
                    iMAPMessageArr[i4] = iMAPMessageArr[i2 - 1];
                    if (iMAPMessageArr[i4] != null) {
                        iMAPMessageArr[i4].setMessageNumber(i3);
                    }
                }
                i3++;
            }
            i2++;
        }
        this.seqnums = null;
        shrink(i3, i2);
        int size = arrayList.size();
        IMAPMessage[] iMAPMessageArr2 = new IMAPMessage[size];
        if (this.logger.isLoggable(Level.FINE)) {
            this.logger.fine("return " + size);
        }
        arrayList.toArray(iMAPMessageArr2);
        return iMAPMessageArr2;
    }

    public int seqnumOf(int i2) {
        if (this.seqnums == null) {
            return i2;
        }
        if (this.logger.isLoggable(Level.FINE)) {
            this.logger.fine("msgnum " + i2 + " is seqnum " + this.seqnums[i2 - 1]);
        }
        return this.seqnums[i2 - 1];
    }

    public int size() {
        return this.size;
    }

    public MessageCache(int i2, boolean z) {
        this.folder = null;
        MailLogger mailLogger = new MailLogger(getClass(), "messagecache", "DEBUG IMAP MC", z, System.out);
        this.logger = mailLogger;
        if (mailLogger.isLoggable(Level.CONFIG)) {
            this.logger.config("create DEBUG cache of size " + i2);
        }
        ensureCapacity(i2, 1);
    }

    public IMAPMessage[] removeExpungedMessages(Message[] messageArr) {
        this.logger.fine("remove expunged messages");
        ArrayList arrayList = new ArrayList();
        int length = messageArr.length;
        int[] iArr = new int[length];
        boolean z = false;
        for (int i2 = 0; i2 < messageArr.length; i2++) {
            iArr[i2] = messageArr[i2].getMessageNumber();
        }
        Arrays.sort(iArr);
        int i3 = 0;
        int i4 = 1;
        int i5 = 1;
        while (i4 <= this.size) {
            if (i3 < length && i4 == iArr[i3] && seqnumOf(i4) <= 0) {
                arrayList.add(getMessage(i4));
                while (i3 < length && iArr[i3] <= i4) {
                    i3++;
                }
            } else {
                if (i5 != i4) {
                    IMAPMessage[] iMAPMessageArr = this.messages;
                    int i6 = i5 - 1;
                    int i7 = i4 - 1;
                    iMAPMessageArr[i6] = iMAPMessageArr[i7];
                    if (iMAPMessageArr[i6] != null) {
                        iMAPMessageArr[i6].setMessageNumber(i5);
                    }
                    int[] iArr2 = this.seqnums;
                    if (iArr2 != null) {
                        iArr2[i6] = iArr2[i7];
                    }
                }
                int[] iArr3 = this.seqnums;
                if (iArr3 != null && iArr3[i5 - 1] != i5) {
                    z = true;
                }
                i5++;
            }
            i4++;
        }
        if (!z) {
            this.seqnums = null;
        }
        shrink(i5, i4);
        int size = arrayList.size();
        IMAPMessage[] iMAPMessageArr2 = new IMAPMessage[size];
        if (this.logger.isLoggable(Level.FINE)) {
            this.logger.fine("return " + size);
        }
        arrayList.toArray(iMAPMessageArr2);
        return iMAPMessageArr2;
    }
}
