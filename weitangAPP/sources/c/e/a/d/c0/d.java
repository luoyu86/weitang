package c.e.a.d.c0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import c.e.a.d.q;
import c.e.a.d.x;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chinavisionary.core.R;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f1193a;

    public static synchronized d getInstance() {
        if (f1193a == null) {
            synchronized (d.class) {
                if (f1193a == null) {
                    f1193a = new d();
                }
            }
        }
        return f1193a;
    }

    public void display(String str, ImageView imageView) {
        if (x.isNotNull(str) && str.startsWith("http")) {
            DrawableRequestBuilder<String> drawableRequestBuilderDiskCacheStrategy = Glide.with(imageView.getContext()).load(str).dontAnimate().diskCacheStrategy(DiskCacheStrategy.ALL);
            int i2 = R.drawable.ic_default;
            drawableRequestBuilderDiskCacheStrategy.placeholder(i2).error(i2).into(imageView);
        } else if (x.isNotNull(str)) {
            displayFile(new File(str), imageView);
        }
    }

    public void displayFile(File file, ImageView imageView, int i2, int i3) {
        DrawableRequestBuilder<File> drawableRequestBuilderDiskCacheStrategy = Glide.with(imageView.getContext()).load(file).thumbnail(0.2f).animate(R.anim.image_fade_in).override(i2, i3).diskCacheStrategy(DiskCacheStrategy.ALL);
        int i4 = R.drawable.ic_default;
        drawableRequestBuilderDiskCacheStrategy.placeholder(i4).error(i4).into(imageView);
    }

    public void displayGif(File file, ImageView imageView) {
        q.d(d.class.getSimpleName(), "displayGif");
        DrawableTypeRequest<File> drawableTypeRequestLoad = Glide.with(imageView.getContext()).load(file);
        int i2 = R.drawable.ic_default;
        drawableTypeRequestLoad.placeholder(i2).error(i2).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
    }

    public String getUrlToResourceVo(ResourceVo resourceVo) {
        if (resourceVo != null) {
            return resourceVo.getUrl();
        }
        return null;
    }

    public void loadRoundImage(Context context, String str, ImageView imageView, int i2) {
        DrawableRequestBuilder<String> drawableRequestBuilderDiskCacheStrategy = Glide.with(imageView.getContext()).load(str).transform(new c(context, i2)).diskCacheStrategy(DiskCacheStrategy.ALL);
        int i3 = R.drawable.ic_default;
        drawableRequestBuilderDiskCacheStrategy.placeholder(i3).error(i3).into(imageView);
    }

    public void recyclerCache(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).onDestroy();
        Glide.get(activity).clearMemory();
    }

    public void recyclerImageView(ImageView imageView) {
        Bitmap bitmap;
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                bitmap.isRecycled();
            }
            imageView.setImageBitmap(null);
            imageView.setImageDrawable(null);
            imageView.setBackground(null);
        }
    }

    public void startLoadImage(Context context) {
        Glide.with(context).resumeRequestsRecursive();
    }

    public void stopLoadImage(Context context) {
        Glide.with(context).pauseRequestsRecursive();
    }

    public void loadRoundImage(Context context, File file, ImageView imageView, int i2) {
        DrawableRequestBuilder<File> drawableRequestBuilderDiskCacheStrategy = Glide.with(imageView.getContext()).load(file).transform(new c(context, i2)).diskCacheStrategy(DiskCacheStrategy.ALL);
        int i3 = R.drawable.ic_default;
        drawableRequestBuilderDiskCacheStrategy.placeholder(i3).error(i3).into(imageView);
    }

    public void displayFile(File file, ImageView imageView) {
        DrawableRequestBuilder<File> drawableRequestBuilderDiskCacheStrategy = Glide.with(imageView.getContext()).load(file).thumbnail(0.2f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.ALL);
        int i2 = R.drawable.ic_default;
        drawableRequestBuilderDiskCacheStrategy.placeholder(i2).error(i2).into(imageView);
    }

    public void display(String str, ImageView imageView, int i2, int i3) {
        if (x.isNotNull(str) && str.startsWith("http")) {
            DrawableRequestBuilder<String> drawableRequestBuilderDiskCacheStrategy = Glide.with(imageView.getContext()).load(str).dontAnimate().override(i2, i3).diskCacheStrategy(DiskCacheStrategy.ALL);
            int i4 = R.drawable.ic_default;
            drawableRequestBuilderDiskCacheStrategy.placeholder(i4).error(i4).into(imageView);
            return;
        }
        displayFile(new File(str), imageView, i2, i3);
    }

    public void display(String str, ImageView imageView, @DrawableRes int i2) {
        Glide.with(imageView.getContext()).load(str).dontAnimate().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(i2).error(i2).into(imageView);
    }

    public void display(@DrawableRes int i2, ImageView imageView) {
        DrawableRequestBuilder<Integer> drawableRequestBuilderDiskCacheStrategy = Glide.with(imageView.getContext()).load(Integer.valueOf(i2)).dontAnimate().diskCacheStrategy(DiskCacheStrategy.ALL);
        int i3 = R.drawable.ic_default;
        drawableRequestBuilderDiskCacheStrategy.placeholder(i3).error(i3).into(imageView);
    }

    public void display(@DrawableRes int i2, ImageView imageView, int i3, int i4) {
        DrawableRequestBuilder<Integer> drawableRequestBuilderDiskCacheStrategy = Glide.with(imageView.getContext()).load(Integer.valueOf(i2)).override(i3, i4).dontAnimate().diskCacheStrategy(DiskCacheStrategy.ALL);
        int i5 = R.drawable.ic_default;
        drawableRequestBuilderDiskCacheStrategy.placeholder(i5).error(i5).into(imageView);
    }

    public void display(File file, ImageView imageView) {
        String name = file.getName();
        if (!name.contains(".gif") && !name.contains(".GIF")) {
            Glide.with(imageView.getContext()).load(file).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        } else {
            displayGif(file, imageView);
        }
    }
}
