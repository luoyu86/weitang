package anet.channel;

/* JADX INFO: loaded from: classes.dex */
public interface IAuth {

    public interface AuthCallback {
        void onAuthFail(int i2, String str);

        void onAuthSuccess();
    }

    void auth(Session session, AuthCallback authCallback);
}
