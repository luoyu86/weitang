package javax.activation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class MimeType implements Externalizable {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
    private MimeTypeParameterList parameters;
    private String primaryType;
    private String subType;

    public MimeType() {
        this.primaryType = "application";
        this.subType = "*";
        this.parameters = new MimeTypeParameterList();
    }

    private static boolean isTokenChar(char c2) {
        return c2 > ' ' && c2 < 127 && TSPECIALS.indexOf(c2) < 0;
    }

    private boolean isValidToken(String str) {
        int length = str.length();
        if (length <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (!isTokenChar(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    private void parse(String str) throws MimeTypeParseException {
        int iIndexOf = str.indexOf(47);
        int iIndexOf2 = str.indexOf(59);
        if (iIndexOf < 0 && iIndexOf2 < 0) {
            throw new MimeTypeParseException("Unable to find a sub type.");
        }
        if (iIndexOf < 0 && iIndexOf2 >= 0) {
            throw new MimeTypeParseException("Unable to find a sub type.");
        }
        if (iIndexOf >= 0 && iIndexOf2 < 0) {
            String strTrim = str.substring(0, iIndexOf).trim();
            Locale locale = Locale.ENGLISH;
            this.primaryType = strTrim.toLowerCase(locale);
            this.subType = str.substring(iIndexOf + 1).trim().toLowerCase(locale);
            this.parameters = new MimeTypeParameterList();
        } else {
            if (iIndexOf >= iIndexOf2) {
                throw new MimeTypeParseException("Unable to find a sub type.");
            }
            String strTrim2 = str.substring(0, iIndexOf).trim();
            Locale locale2 = Locale.ENGLISH;
            this.primaryType = strTrim2.toLowerCase(locale2);
            this.subType = str.substring(iIndexOf + 1, iIndexOf2).trim().toLowerCase(locale2);
            this.parameters = new MimeTypeParameterList(str.substring(iIndexOf2));
        }
        if (!isValidToken(this.primaryType)) {
            throw new MimeTypeParseException("Primary type is invalid.");
        }
        if (!isValidToken(this.subType)) {
            throw new MimeTypeParseException("Sub type is invalid.");
        }
    }

    public String getBaseType() {
        return this.primaryType + "/" + this.subType;
    }

    public String getParameter(String str) {
        return this.parameters.get(str);
    }

    public MimeTypeParameterList getParameters() {
        return this.parameters;
    }

    public String getPrimaryType() {
        return this.primaryType;
    }

    public String getSubType() {
        return this.subType;
    }

    public boolean match(MimeType mimeType) {
        return this.primaryType.equals(mimeType.getPrimaryType()) && (this.subType.equals("*") || mimeType.getSubType().equals("*") || this.subType.equals(mimeType.getSubType()));
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        try {
            parse(objectInput.readUTF());
        } catch (MimeTypeParseException e2) {
            throw new IOException(e2.toString());
        }
    }

    public void removeParameter(String str) {
        this.parameters.remove(str);
    }

    public void setParameter(String str, String str2) {
        this.parameters.set(str, str2);
    }

    public void setPrimaryType(String str) throws MimeTypeParseException {
        if (!isValidToken(this.primaryType)) {
            throw new MimeTypeParseException("Primary type is invalid.");
        }
        this.primaryType = str.toLowerCase(Locale.ENGLISH);
    }

    public void setSubType(String str) throws MimeTypeParseException {
        if (!isValidToken(this.subType)) {
            throw new MimeTypeParseException("Sub type is invalid.");
        }
        this.subType = str.toLowerCase(Locale.ENGLISH);
    }

    public String toString() {
        return getBaseType() + this.parameters.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(toString());
        objectOutput.flush();
    }

    public MimeType(String str) throws MimeTypeParseException {
        parse(str);
    }

    public boolean match(String str) throws MimeTypeParseException {
        return match(new MimeType(str));
    }

    public MimeType(String str, String str2) throws MimeTypeParseException {
        if (isValidToken(str)) {
            Locale locale = Locale.ENGLISH;
            this.primaryType = str.toLowerCase(locale);
            if (isValidToken(str2)) {
                this.subType = str2.toLowerCase(locale);
                this.parameters = new MimeTypeParameterList();
                return;
            }
            throw new MimeTypeParseException("Sub type is invalid.");
        }
        throw new MimeTypeParseException("Primary type is invalid.");
    }
}
