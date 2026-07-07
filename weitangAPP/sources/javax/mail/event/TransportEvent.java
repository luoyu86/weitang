package javax.mail.event;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Transport;

/* JADX INFO: loaded from: classes2.dex */
public class TransportEvent extends MailEvent {
    public static final int MESSAGE_DELIVERED = 1;
    public static final int MESSAGE_NOT_DELIVERED = 2;
    public static final int MESSAGE_PARTIALLY_DELIVERED = 3;
    private static final long serialVersionUID = -4729852364684273073L;
    public transient Address[] invalid;
    public transient Message msg;
    public int type;
    public transient Address[] validSent;
    public transient Address[] validUnsent;

    public TransportEvent(Transport transport, int i2, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        super(transport);
        this.type = i2;
        this.validSent = addressArr;
        this.validUnsent = addressArr2;
        this.invalid = addressArr3;
        this.msg = message;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        int i2 = this.type;
        if (i2 == 1) {
            ((TransportListener) obj).messageDelivered(this);
        } else if (i2 == 2) {
            ((TransportListener) obj).messageNotDelivered(this);
        } else {
            ((TransportListener) obj).messagePartiallyDelivered(this);
        }
    }

    public Address[] getInvalidAddresses() {
        return this.invalid;
    }

    public Message getMessage() {
        return this.msg;
    }

    public int getType() {
        return this.type;
    }

    public Address[] getValidSentAddresses() {
        return this.validSent;
    }

    public Address[] getValidUnsentAddresses() {
        return this.validUnsent;
    }
}
