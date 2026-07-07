package c.k.a.c;

import com.lzy.imagepicker.bean.ImageItem;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable {
    public ImageItem cover;
    public ArrayList<ImageItem> images;
    public String name;
    public String path;

    public boolean equals(Object obj) {
        try {
            a aVar = (a) obj;
            if (this.path.equalsIgnoreCase(aVar.path)) {
                if (this.name.equalsIgnoreCase(aVar.name)) {
                    return true;
                }
            }
            return false;
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            return super.equals(obj);
        }
    }
}
