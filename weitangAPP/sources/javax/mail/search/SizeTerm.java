package javax.mail.search;

import javax.mail.Message;

/* JADX INFO: loaded from: classes2.dex */
public final class SizeTerm extends IntegerComparisonTerm {
    private static final long serialVersionUID = -2556219451005103709L;

    public SizeTerm(int i2, int i3) {
        super(i2, i3);
    }

    @Override // javax.mail.search.IntegerComparisonTerm, javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        if (obj instanceof SizeTerm) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            int size = message.getSize();
            if (size == -1) {
                return false;
            }
            return super.match(size);
        } catch (Exception unused) {
            return false;
        }
    }
}
