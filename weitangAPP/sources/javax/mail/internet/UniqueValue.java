package javax.mail.internet;

import java.util.concurrent.atomic.AtomicInteger;
import javax.mail.Session;

/* JADX INFO: loaded from: classes2.dex */
public class UniqueValue {
    private static AtomicInteger id = new AtomicInteger();

    public static String getUniqueBoundaryValue() {
        StringBuilder sb = new StringBuilder();
        long jHashCode = sb.hashCode();
        sb.append("----=_Part_");
        sb.append(id.getAndIncrement());
        sb.append("_");
        sb.append(jHashCode);
        sb.append('.');
        sb.append(System.currentTimeMillis());
        return sb.toString();
    }

    public static String getUniqueMessageIDValue(Session session) {
        InternetAddress localAddress = InternetAddress.getLocalAddress(session);
        String address = localAddress != null ? localAddress.getAddress() : "jakartamailuser@localhost";
        int iLastIndexOf = address.lastIndexOf(64);
        if (iLastIndexOf >= 0) {
            address = address.substring(iLastIndexOf);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sb.hashCode());
        sb.append('.');
        sb.append(id.getAndIncrement());
        sb.append('.');
        sb.append(System.currentTimeMillis());
        sb.append(address);
        return sb.toString();
    }
}
