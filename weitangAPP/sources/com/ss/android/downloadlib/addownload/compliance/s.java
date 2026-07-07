package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.bl;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.network.q;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s extends com.ss.android.socialbase.downloader.q.p<Long, Bitmap> {
    private final Map<Long, SoftReference<ok>> ok;

    public static class a {
        private static s ok = new s();
    }

    public interface ok {
        void ok(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(int i2, int i3, BitmapFactory.Options options) {
        int i4 = options.outWidth;
        if (i4 > i2 || options.outHeight > i3) {
            return Math.min(Math.round(i4 / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }

    private s() {
        super(8, 8);
        this.ok = new HashMap();
    }

    public static s ok() {
        return a.ok;
    }

    public void ok(long j, @NonNull ok okVar) {
        if (get(Long.valueOf(j)) != null) {
            okVar.ok(get(Long.valueOf(j)));
        } else {
            this.ok.put(Long.valueOf(j), new SoftReference<>(okVar));
        }
    }

    public void ok(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<ok> softReferenceRemove = this.ok.remove(Long.valueOf(j));
            if (softReferenceRemove == null || softReferenceRemove.get() == null) {
                return;
            }
            softReferenceRemove.get().ok(get(Long.valueOf(j)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            h.ok(12, j2);
        } else {
            com.ss.android.downloadlib.h.bl.ok((bl.ok<Object, R>) new bl.ok<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.s.2
                @Override // com.ss.android.downloadlib.h.bl.ok
                public Object ok(Object obj) throws Throwable {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    q qVarOk;
                    try {
                        qVarOk = com.ss.android.socialbase.downloader.downloader.bl.ok(true, 0, str, null);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        com.ss.android.socialbase.downloader.q.kf.ok(bufferedInputStream);
                        throw th;
                    }
                    if (qVarOk == null) {
                        com.ss.android.socialbase.downloader.q.kf.ok(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(qVarOk.ok());
                    try {
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i2 = options.outWidth;
                            int i3 = options.outHeight;
                            int iOk = j.ok(r.getContext(), 60.0f);
                            options.inSampleSize = s.a(iOk, iOk, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i2));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i3));
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(bitmapDecodeStream == null ? -1 : bitmapDecodeStream.getByteCount()));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            com.ss.android.downloadlib.s.ok.ok().ok("ttd_pref_monitor", jSONObject, j2);
                            s.this.put(Long.valueOf(j), bitmapDecodeStream);
                            com.ss.android.socialbase.downloader.q.kf.ok(bufferedInputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            com.ss.android.socialbase.downloader.q.kf.ok(bufferedInputStream);
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        com.ss.android.downloadlib.n.bl.ok().ok(e, "BitmapCache loadBitmap");
                        com.ss.android.socialbase.downloader.q.kf.ok(bufferedInputStream);
                    }
                    return null;
                    com.ss.android.downloadlib.n.bl.ok().ok(e, "BitmapCache loadBitmap");
                    com.ss.android.socialbase.downloader.q.kf.ok(bufferedInputStream);
                    return null;
                }
            }, (Object) null).ok(new bl.ok<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.s.1
                @Override // com.ss.android.downloadlib.h.bl.ok
                public Object ok(Object obj) {
                    SoftReference softReference = (SoftReference) s.this.ok.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((ok) softReference.get()).ok(s.this.get(Long.valueOf(j)));
                    return null;
                }
            }).ok();
        }
    }
}
