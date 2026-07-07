package c.e.a.b.a.g;

import com.chinavisionary.core.photo.photopicker.entity.Photo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<Photo> f1102f = new ArrayList<>();

    public void addPhoto(int i2, String str) {
        this.f1102f.add(new Photo(i2, str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        String str = this.f1099c;
        String str2 = ((b) obj).f1099c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public String getCoverPath() {
        return this.f1098b;
    }

    public long getDateAdded() {
        return this.f1101e;
    }

    public String getId() {
        return this.f1097a;
    }

    public String getName() {
        return this.f1099c;
    }

    public List<String> getPhotoPaths() {
        ArrayList arrayList = new ArrayList(this.f1102f.size());
        Iterator<Photo> it = this.f1102f.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPath());
        }
        return arrayList;
    }

    public ArrayList<Photo> getPhotos() {
        return this.f1102f;
    }

    public int hashCode() {
        String str = this.f1099c;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isSelected() {
        return this.f1100d;
    }

    public void setCoverPath(String str) {
        this.f1098b = str;
    }

    public void setDateAdded(long j) {
        this.f1101e = j;
    }

    public void setId(String str) {
        this.f1097a = str;
    }

    public void setName(String str) {
        this.f1099c = str;
    }

    public void setPhotos(ArrayList<Photo> arrayList) {
        this.f1102f = arrayList;
    }

    public void setSelected(boolean z) {
        this.f1100d = z;
    }
}
