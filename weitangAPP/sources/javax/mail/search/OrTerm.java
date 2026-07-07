package javax.mail.search;

import javax.mail.Message;

/* JADX INFO: loaded from: classes2.dex */
public final class OrTerm extends SearchTerm {
    private static final long serialVersionUID = 5380534067523646936L;
    private SearchTerm[] terms;

    public OrTerm(SearchTerm searchTerm, SearchTerm searchTerm2) {
        this.terms = new SearchTerm[]{searchTerm, searchTerm2};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OrTerm)) {
            return false;
        }
        OrTerm orTerm = (OrTerm) obj;
        if (orTerm.terms.length != this.terms.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            SearchTerm[] searchTermArr = this.terms;
            if (i2 >= searchTermArr.length) {
                return true;
            }
            if (!searchTermArr[i2].equals(orTerm.terms[i2])) {
                return false;
            }
            i2++;
        }
    }

    public SearchTerm[] getTerms() {
        return (SearchTerm[]) this.terms.clone();
    }

    public int hashCode() {
        int i2 = 0;
        int iHashCode = 0;
        while (true) {
            SearchTerm[] searchTermArr = this.terms;
            if (i2 >= searchTermArr.length) {
                return iHashCode;
            }
            iHashCode += searchTermArr[i2].hashCode();
            i2++;
        }
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        int i2 = 0;
        while (true) {
            SearchTerm[] searchTermArr = this.terms;
            if (i2 >= searchTermArr.length) {
                return false;
            }
            if (searchTermArr[i2].match(message)) {
                return true;
            }
            i2++;
        }
    }

    public OrTerm(SearchTerm[] searchTermArr) {
        this.terms = new SearchTerm[searchTermArr.length];
        for (int i2 = 0; i2 < searchTermArr.length; i2++) {
            this.terms[i2] = searchTermArr[i2];
        }
    }
}
