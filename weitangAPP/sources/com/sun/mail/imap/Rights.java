package com.sun.mail.imap;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class Rights implements Cloneable {
    private boolean[] rights;

    public static final class Right {
        public char right;
        private static Right[] cache = new Right[128];
        public static final Right LOOKUP = getInstance('l');
        public static final Right READ = getInstance('r');
        public static final Right KEEP_SEEN = getInstance('s');
        public static final Right WRITE = getInstance('w');
        public static final Right INSERT = getInstance('i');
        public static final Right POST = getInstance('p');
        public static final Right CREATE = getInstance('c');
        public static final Right DELETE = getInstance('d');
        public static final Right ADMINISTER = getInstance('a');

        private Right(char c2) {
            if (c2 >= 128) {
                throw new IllegalArgumentException("Right must be ASCII");
            }
            this.right = c2;
        }

        public static synchronized Right getInstance(char c2) {
            if (c2 >= 128) {
                throw new IllegalArgumentException("Right must be ASCII");
            }
            Right[] rightArr = cache;
            if (rightArr[c2] == null) {
                rightArr[c2] = new Right(c2);
            }
            return cache[c2];
        }

        public String toString() {
            return String.valueOf(this.right);
        }
    }

    public Rights() {
        this.rights = new boolean[128];
    }

    public void add(Right right) {
        this.rights[right.right] = true;
    }

    public Object clone() {
        Rights rights = null;
        try {
            Rights rights2 = (Rights) super.clone();
            try {
                boolean[] zArr = new boolean[128];
                rights2.rights = zArr;
                boolean[] zArr2 = this.rights;
                System.arraycopy(zArr2, 0, zArr, 0, zArr2.length);
                return rights2;
            } catch (CloneNotSupportedException unused) {
                rights = rights2;
                return rights;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public boolean contains(Right right) {
        return this.rights[right.right];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rights)) {
            return false;
        }
        Rights rights = (Rights) obj;
        int i2 = 0;
        while (true) {
            boolean[] zArr = rights.rights;
            if (i2 >= zArr.length) {
                return true;
            }
            if (zArr[i2] != this.rights[i2]) {
                return false;
            }
            i2++;
        }
    }

    public Right[] getRights() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.rights;
            if (i2 >= zArr.length) {
                return (Right[]) arrayList.toArray(new Right[arrayList.size()]);
            }
            if (zArr[i2]) {
                arrayList.add(Right.getInstance((char) i2));
            }
            i2++;
        }
    }

    public int hashCode() {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean[] zArr = this.rights;
            if (i2 >= zArr.length) {
                return i3;
            }
            if (zArr[i2]) {
                i3++;
            }
            i2++;
        }
    }

    public void remove(Right right) {
        this.rights[right.right] = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.rights;
            if (i2 >= zArr.length) {
                return sb.toString();
            }
            if (zArr[i2]) {
                sb.append((char) i2);
            }
            i2++;
        }
    }

    public void add(Rights rights) {
        int i2 = 0;
        while (true) {
            boolean[] zArr = rights.rights;
            if (i2 >= zArr.length) {
                return;
            }
            if (zArr[i2]) {
                this.rights[i2] = true;
            }
            i2++;
        }
    }

    public boolean contains(Rights rights) {
        int i2 = 0;
        while (true) {
            boolean[] zArr = rights.rights;
            if (i2 >= zArr.length) {
                return true;
            }
            if (zArr[i2] && !this.rights[i2]) {
                return false;
            }
            i2++;
        }
    }

    public void remove(Rights rights) {
        int i2 = 0;
        while (true) {
            boolean[] zArr = rights.rights;
            if (i2 >= zArr.length) {
                return;
            }
            if (zArr[i2]) {
                this.rights[i2] = false;
            }
            i2++;
        }
    }

    public Rights(Rights rights) {
        boolean[] zArr = new boolean[128];
        this.rights = zArr;
        System.arraycopy(rights.rights, 0, zArr, 0, zArr.length);
    }

    public Rights(String str) {
        this.rights = new boolean[128];
        for (int i2 = 0; i2 < str.length(); i2++) {
            add(Right.getInstance(str.charAt(i2)));
        }
    }

    public Rights(Right right) {
        boolean[] zArr = new boolean[128];
        this.rights = zArr;
        zArr[right.right] = true;
    }
}
