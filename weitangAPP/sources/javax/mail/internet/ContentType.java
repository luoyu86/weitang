package javax.mail.internet;

import javax.mail.internet.HeaderTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class ContentType {
    private ParameterList list;
    private String primaryType;
    private String subType;

    public ContentType() {
    }

    public String getBaseType() {
        if (this.primaryType == null || this.subType == null) {
            return "";
        }
        return this.primaryType + '/' + this.subType;
    }

    public String getParameter(String str) {
        ParameterList parameterList = this.list;
        if (parameterList == null) {
            return null;
        }
        return parameterList.get(str);
    }

    public ParameterList getParameterList() {
        return this.list;
    }

    public String getPrimaryType() {
        return this.primaryType;
    }

    public String getSubType() {
        return this.subType;
    }

    public boolean match(ContentType contentType) {
        String str;
        if (!(this.primaryType == null && contentType.getPrimaryType() == null) && ((str = this.primaryType) == null || !str.equalsIgnoreCase(contentType.getPrimaryType()))) {
            return false;
        }
        String subType = contentType.getSubType();
        String str2 = this.subType;
        if ((str2 != null && str2.startsWith("*")) || (subType != null && subType.startsWith("*"))) {
            return true;
        }
        String str3 = this.subType;
        return (str3 == null && subType == null) || (str3 != null && str3.equalsIgnoreCase(subType));
    }

    public void setParameter(String str, String str2) {
        if (this.list == null) {
            this.list = new ParameterList();
        }
        this.list.set(str, str2);
    }

    public void setParameterList(ParameterList parameterList) {
        this.list = parameterList;
    }

    public void setPrimaryType(String str) {
        this.primaryType = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public String toString() {
        if (this.primaryType == null || this.subType == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.primaryType);
        sb.append('/');
        sb.append(this.subType);
        ParameterList parameterList = this.list;
        if (parameterList != null) {
            sb.append(parameterList.toString(sb.length() + 14));
        }
        return sb.toString();
    }

    public ContentType(String str, String str2, ParameterList parameterList) {
        this.primaryType = str;
        this.subType = str2;
        this.list = parameterList;
    }

    public ContentType(String str) throws ParseException {
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(str, HeaderTokenizer.MIME);
        HeaderTokenizer.Token next = headerTokenizer.next();
        if (next.getType() == -1) {
            this.primaryType = next.getValue();
            HeaderTokenizer.Token next2 = headerTokenizer.next();
            if (((char) next2.getType()) == '/') {
                HeaderTokenizer.Token next3 = headerTokenizer.next();
                if (next3.getType() == -1) {
                    this.subType = next3.getValue();
                    String remainder = headerTokenizer.getRemainder();
                    if (remainder != null) {
                        this.list = new ParameterList(remainder);
                        return;
                    }
                    return;
                }
                throw new ParseException("In Content-Type string <" + str + ">, expected MIME subtype, got " + next3.getValue());
            }
            throw new ParseException("In Content-Type string <" + str + ">, expected '/', got " + next2.getValue());
        }
        throw new ParseException("In Content-Type string <" + str + ">, expected MIME type, got " + next.getValue());
    }

    public boolean match(String str) {
        try {
            return match(new ContentType(str));
        } catch (ParseException unused) {
            return false;
        }
    }
}
