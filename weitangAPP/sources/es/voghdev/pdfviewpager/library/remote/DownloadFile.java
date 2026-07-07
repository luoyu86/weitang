package es.voghdev.pdfviewpager.library.remote;

/* JADX INFO: loaded from: classes2.dex */
public interface DownloadFile {

    public interface Listener {
        void onFailure(Exception exc);

        void onProgressUpdate(int i2, int i3);

        void onSuccess(String str, String str2);
    }

    void download(String str, String str2);
}
