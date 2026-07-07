package c.e.a.b.a.i;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.chinavisionary.core.photo.photopicker.camera.CameraActivity;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1104b;

    public a(Context context) {
        this.f1104b = context;
    }

    public final File a() throws IOException {
        String str = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date()) + ".jpg";
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        if (!externalStoragePublicDirectory.exists() && !externalStoragePublicDirectory.mkdir()) {
            Log.e("TAG", "Throwing Errors....");
            throw new IOException();
        }
        File file = new File(externalStoragePublicDirectory, str);
        this.f1103a = file.getAbsolutePath();
        return file;
    }

    public Intent dispatchTakePictureIntent() throws IOException {
        File fileA;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(this.f1104b.getPackageManager()) != null && (fileA = a()) != null) {
            intent.putExtra("output", Uri.fromFile(fileA));
        }
        return intent;
    }

    public void galleryAddPic() {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        if (TextUtils.isEmpty(this.f1103a)) {
            return;
        }
        intent.setData(Uri.fromFile(new File(this.f1103a)));
        this.f1104b.sendBroadcast(intent);
    }

    public String getCurrentPhotoPath() {
        return this.f1103a;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("mCurrentPhotoPath")) {
            return;
        }
        this.f1103a = bundle.getString("mCurrentPhotoPath");
    }

    public void onSaveInstanceState(Bundle bundle) {
        String str;
        if (bundle == null || (str = this.f1103a) == null) {
            return;
        }
        bundle.putString("mCurrentPhotoPath", str);
    }

    public Intent dispatchTakePictureIntent(Context context) throws IOException {
        return new Intent(context, (Class<?>) CameraActivity.class);
    }
}
