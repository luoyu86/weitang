package com.chinavisionary.core.weight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DrawableRes;
import c.e.a.d.c0.d;
import c.e.a.d.x;
import com.chinavisionary.core.R;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.makeramen.roundedimageview.RoundedImageView;
import java.io.File;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class CoreRoundedImageView extends RoundedImageView {
    public int r;
    public int s;
    public String t;
    public StringBuilder u;

    public CoreRoundedImageView(Context context) {
        super(context);
        this.r = 300;
        this.s = 300;
        this.u = new StringBuilder(6);
        j();
    }

    public int getPicHeight() {
        return Math.max(this.s, View.MeasureSpec.getSize(getMeasuredHeight()));
    }

    public int getPicWidth() {
        return Math.max(this.r, View.MeasureSpec.getSize(getMeasuredWidth()));
    }

    public String getUrl() {
        return this.t;
    }

    public final String h(String str) {
        Uri uri = Uri.parse(str);
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (this.u.length() != 0) {
            StringBuilder sb = this.u;
            sb.delete(0, sb.length());
        }
        this.u.append(str);
        String host = uri.getHost();
        if (host != null && host.contains("aliyuncs.com")) {
            if (queryParameterNames == null || queryParameterNames.isEmpty()) {
                StringBuilder sb2 = this.u;
                sb2.append("?x-oss-process=image/resize,m_lfit,h_");
                sb2.append(getPicHeight());
                sb2.append(",w_");
                sb2.append(getPicWidth());
            } else {
                StringBuilder sb3 = this.u;
                sb3.append("&x-oss-process=image/resize,m_lfit,h_");
                sb3.append(getPicHeight());
                sb3.append(",w_");
                sb3.append(getPicWidth());
            }
        }
        return this.u.toString();
    }

    public final String i(ResourceVo resourceVo) {
        if (resourceVo != null) {
            return resourceVo.getUrl();
        }
        return null;
    }

    public final void j() {
    }

    public final boolean k(String str) {
        if (!x.isNotNull(str)) {
            return false;
        }
        boolean z = str.indexOf("http") != 0;
        if (x.isNumeric(str)) {
            return false;
        }
        return z;
    }

    public final boolean l(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void loadAliImageToUrl(String str) {
        if (x.isNullStr(str)) {
            recyclerImage();
        } else if (k(str)) {
            loadImageToFile(new File(str));
        } else if (l(str)) {
            try {
                loadImageToResId(Integer.parseInt(str));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                loadImageToResId(R.drawable.ic_default);
            }
        } else {
            m(h(str));
        }
        this.t = str;
    }

    public void loadImageToFile(File file) {
        this.t = file != null ? file.getAbsolutePath() : null;
        d.getInstance().displayFile(file, this);
    }

    @SuppressLint({"ResourceType"})
    public void loadImageToResId(@DrawableRes int i2) {
        if (i2 > 0) {
            d.getInstance().display(i2, this);
        } else {
            loadImageToResId(R.drawable.ic_default);
        }
    }

    public void loadImageToResourceVo(ResourceVo resourceVo) {
        loadImageToResourceVo(resourceVo, false);
    }

    public void loadImageToUrl(String str) {
        this.t = str;
        if (x.isNullStr(str)) {
            recyclerImage();
            return;
        }
        if (k(str)) {
            loadImageToFile(new File(str));
            return;
        }
        if (!l(str)) {
            m(str);
            return;
        }
        try {
            loadImageToResId(Integer.parseInt(str));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            loadImageToResId(R.drawable.ic_default);
        }
    }

    public final void m(String str) {
        try {
            d.getInstance().display(str, this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void recyclerImage() {
        d.getInstance().recyclerImageView(this);
        setImageResource(R.drawable.ic_default);
    }

    public void setPicHeight(int i2) {
        this.s = i2;
    }

    public void setPicWidth(int i2) {
        this.r = i2;
    }

    public void loadImageToResourceVo(ResourceVo resourceVo, boolean z) {
        if (z) {
            loadAliImageToUrl(i(resourceVo));
        } else {
            loadImageToUrl(i(resourceVo));
        }
    }

    public CoreRoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = 300;
        this.s = 300;
        this.u = new StringBuilder(6);
        j();
    }

    public CoreRoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = 300;
        this.s = 300;
        this.u = new StringBuilder(6);
        j();
    }

    public void loadImageToUrl(String str, @DrawableRes int i2) {
        this.t = str;
        if (x.isNotNull(str)) {
            if (k(str)) {
                loadImageToFile(new File(str));
                return;
            }
            if (l(str)) {
                try {
                    loadImageToResId(Integer.parseInt(str));
                    return;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    loadImageToResId(i2);
                    return;
                }
            }
            m(str);
            return;
        }
        recyclerImage();
        loadImageToResId(i2);
    }

    public void loadImageToUrl(String str, boolean z) {
        this.t = str;
        if (z) {
            m(str);
        } else {
            recyclerImage();
        }
    }
}
