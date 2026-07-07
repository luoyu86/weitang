package c.e.c.o0.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import c.e.a.d.x;
import c.e.b.c.d.f;
import c.e.b.c.d.o;
import com.chinavisionary.microtang.R;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IWXAPI f1806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1807b;

    public a(Context context) {
        this.f1807b = context;
        this.f1806a = WXAPIFactory.createWXAPI(context, "wx566d59045c104e04", false);
    }

    public final String a(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    public byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 60, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArray;
    }

    public Bitmap getBitmapToUrl(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String shared(o oVar, int i2) {
        if (oVar == null || oVar.getData() == null) {
            return null;
        }
        String type = oVar.getType();
        if ("text".equals(type)) {
            sharedText(oVar, i2);
        }
        if ("image".equals(type)) {
            sharedImg(oVar, i2);
        }
        if (o.WEBPAGE_TYPE.equals(type)) {
            sharedWebPage(oVar, i2);
        }
        if (!o.VIDEO_TYPE.equals(type)) {
            return null;
        }
        sharedWebPage(oVar, i2);
        return null;
    }

    public String sharedImg(o oVar, int i2) {
        if (oVar == null) {
            return x.getString(R.string.tip_shared_data_is_empty);
        }
        f data = oVar.getData();
        if (data == null) {
            return x.getString(R.string.tip_shared_data_is_empty);
        }
        String imageData = data.getImageData();
        if (!x.isNotNull(imageData)) {
            return x.getString(R.string.tip_shared_img_is_empty);
        }
        byte[] bArrDecode = Base64.decode(imageData, 0);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        WXImageObject wXImageObject = new WXImageObject(bitmapDecodeByteArray);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, 50, 50, true);
        bitmapDecodeByteArray.recycle();
        wXMediaMessage.thumbData = bmpToByteArray(bitmapCreateScaledBitmap, false);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = a("img");
        req.message = wXMediaMessage;
        req.scene = i2;
        req.userOpenId = "wx566d59045c104e04";
        this.f1806a.sendReq(req);
        return null;
    }

    public String sharedText(o oVar, int i2) {
        if (oVar == null) {
            return x.getString(R.string.tip_shared_data_is_empty);
        }
        f data = oVar.getData();
        if (data == null) {
            return x.getString(R.string.tip_shared_data_is_empty);
        }
        String text = data.getText();
        if (!x.isNotNull(text)) {
            return x.getString(R.string.tip_shared_url_is_empty);
        }
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = text;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = x.getNotNullStr(data.getDescription(), text);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = a("text");
        req.message = wXMediaMessage;
        req.scene = i2;
        this.f1806a.sendReq(req);
        return null;
    }

    public String sharedWebPage(o oVar, int i2) {
        if (oVar == null) {
            return x.getString(R.string.tip_shared_data_is_empty);
        }
        f data = oVar.getData();
        if (data == null) {
            return x.getString(R.string.tip_shared_data_is_empty);
        }
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        if (!x.isNotNull(data.getWebpageUrl())) {
            return x.getString(R.string.tip_shared_url_is_empty);
        }
        wXWebpageObject.webpageUrl = data.getWebpageUrl();
        wXMediaMessage.title = x.getNotNullStr(data.getTitle(), x.getString(R.string.app_name));
        wXMediaMessage.description = x.getNotNullStr(data.getDescription(), x.getString(R.string.title_webpage_shared));
        if (oVar.getBitmap() == null) {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.f1807b.getResources(), R.mipmap.ic_wt_pay);
            if (bitmapDecodeResource != null) {
                wXMediaMessage.thumbData = bmpToByteArray(Bitmap.createScaledBitmap(bitmapDecodeResource, 50, 50, true), false);
            }
        } else {
            wXMediaMessage.thumbData = bmpToByteArray(oVar.getBitmap(), false);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = a(o.WEBPAGE_TYPE);
        req.message = wXMediaMessage;
        req.scene = i2;
        req.userOpenId = "wx566d59045c104e04";
        this.f1806a.sendReq(req);
        return null;
    }
}
