package c.e.a.a.f;

import com.chinavisionary.core.app.mail.MailBo;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static MimeMessage a(MailBo mailBo) {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", mailBo.getMailServerHost());
        properties.setProperty("mail.smtp.port", mailBo.getMailServerPort());
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.ssl.enable", mailBo.getOpenSSL() + "");
        if (mailBo.getOpenSSL().booleanValue()) {
            properties.setProperty("mail.smtp.socketFactory.class", mailBo.getSslFactory());
        }
        MimeMessage mimeMessage = new MimeMessage(Session.getDefaultInstance(properties, new b(mailBo.getFromAddress(), mailBo.getPassword())));
        try {
            mimeMessage.setFrom(new InternetAddress(mailBo.getFromAddress()));
            mimeMessage.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(mailBo.getToAddress().get(0))});
            mimeMessage.setSubject(mailBo.getSubject());
            MimeMultipart mimeMultipart = new MimeMultipart();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(mailBo.getContent(), "text/html;charset=UTF-8");
            mimeMultipart.addBodyPart(mimeBodyPart);
            mimeMultipart.setSubType("mixed");
            mimeMessage.setContent(mimeMultipart);
            mimeMessage.saveChanges();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return mimeMessage;
    }

    public static /* synthetic */ void b(MailBo mailBo, d dVar) {
        try {
            Transport.send(a(mailBo));
            dVar.onSuccess();
        } catch (Exception e2) {
            e2.printStackTrace();
            dVar.onError(e2);
        }
    }

    public static void sendMail(final MailBo mailBo, final d dVar) {
        new Thread(new Runnable() { // from class: c.e.a.a.f.a
            @Override // java.lang.Runnable
            public final void run() {
                c.b(mailBo, dVar);
            }
        }).start();
    }
}
