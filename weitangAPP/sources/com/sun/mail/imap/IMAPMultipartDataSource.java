package com.sun.mail.imap;

import com.alibaba.android.arouter.utils.Consts;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import java.util.ArrayList;
import java.util.List;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.MultipartDataSource;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimePartDataSource;

/* JADX INFO: loaded from: classes2.dex */
public class IMAPMultipartDataSource extends MimePartDataSource implements MultipartDataSource {
    private List<IMAPBodyPart> parts;

    public IMAPMultipartDataSource(MimePart mimePart, BODYSTRUCTURE[] bodystructureArr, String str, IMAPMessage iMAPMessage) {
        super(mimePart);
        this.parts = new ArrayList(bodystructureArr.length);
        for (int i2 = 0; i2 < bodystructureArr.length; i2++) {
            this.parts.add(new IMAPBodyPart(bodystructureArr[i2], str == null ? Integer.toString(i2 + 1) : str + Consts.DOT + Integer.toString(i2 + 1), iMAPMessage));
        }
    }

    @Override // javax.mail.MultipartDataSource
    public BodyPart getBodyPart(int i2) throws MessagingException {
        return this.parts.get(i2);
    }

    @Override // javax.mail.MultipartDataSource
    public int getCount() {
        return this.parts.size();
    }
}
