package javax.mail.event;

/* JADX INFO: loaded from: classes2.dex */
public class ConnectionEvent extends MailEvent {
    public static final int CLOSED = 3;
    public static final int DISCONNECTED = 2;
    public static final int OPENED = 1;
    private static final long serialVersionUID = -1855480171284792957L;
    public int type;

    public ConnectionEvent(Object obj, int i2) {
        super(obj);
        this.type = i2;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        int i2 = this.type;
        if (i2 == 1) {
            ((ConnectionListener) obj).opened(this);
        } else if (i2 == 2) {
            ((ConnectionListener) obj).disconnected(this);
        } else if (i2 == 3) {
            ((ConnectionListener) obj).closed(this);
        }
    }

    public int getType() {
        return this.type;
    }
}
