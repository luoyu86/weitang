package com.tom_roush.pdfbox.pdmodel.encryption;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSBoolean;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDEncryption implements COSObjectable {
    public static final int DEFAULT_LENGTH = 40;
    public static final String DEFAULT_NAME = "Standard";
    public static final int DEFAULT_VERSION = 0;
    public static final int VERSION0_UNDOCUMENTED_UNSUPPORTED = 0;
    public static final int VERSION1_40_BIT_ALGORITHM = 1;
    public static final int VERSION2_VARIABLE_LENGTH_ALGORITHM = 2;
    public static final int VERSION3_UNPUBLISHED_ALGORITHM = 3;
    public static final int VERSION4_SECURITY_HANDLER = 4;
    private final COSDictionary dictionary;
    private SecurityHandler securityHandler;

    public PDEncryption() {
        this.dictionary = new COSDictionary();
    }

    @Deprecated
    public COSDictionary getCOSDictionary() {
        return this.dictionary;
    }

    public PDCryptFilterDictionary getCryptFilterDictionary(COSName cOSName) {
        COSBase dictionaryObject = this.dictionary.getDictionaryObject(COSName.CF);
        if (!(dictionaryObject instanceof COSDictionary)) {
            return null;
        }
        COSBase dictionaryObject2 = ((COSDictionary) dictionaryObject).getDictionaryObject(cOSName);
        if (dictionaryObject2 instanceof COSDictionary) {
            return new PDCryptFilterDictionary((COSDictionary) dictionaryObject2);
        }
        return null;
    }

    public PDCryptFilterDictionary getDefaultCryptFilterDictionary() {
        return getCryptFilterDictionary(COSName.DEFAULT_CRYPT_FILTER);
    }

    public final String getFilter() {
        return this.dictionary.getNameAsString(COSName.FILTER);
    }

    public int getLength() {
        return this.dictionary.getInt(COSName.LENGTH, 40);
    }

    public byte[] getOwnerEncryptionKey() throws IOException {
        COSString cOSString = (COSString) this.dictionary.getDictionaryObject(COSName.OE);
        if (cOSString != null) {
            return cOSString.getBytes();
        }
        return null;
    }

    public byte[] getOwnerKey() throws IOException {
        COSString cOSString = (COSString) this.dictionary.getDictionaryObject(COSName.O);
        if (cOSString != null) {
            return cOSString.getBytes();
        }
        return null;
    }

    public int getPermissions() {
        return this.dictionary.getInt(COSName.P, 0);
    }

    public byte[] getPerms() throws IOException {
        COSString cOSString = (COSString) this.dictionary.getDictionaryObject(COSName.PERMS);
        if (cOSString != null) {
            return cOSString.getBytes();
        }
        return null;
    }

    public COSString getRecipientStringAt(int i2) {
        return (COSString) ((COSArray) this.dictionary.getItem(COSName.RECIPIENTS)).get(i2);
    }

    public int getRecipientsLength() {
        return ((COSArray) this.dictionary.getItem(COSName.RECIPIENTS)).size();
    }

    public int getRevision() {
        return this.dictionary.getInt(COSName.R, 0);
    }

    public SecurityHandler getSecurityHandler() throws IOException {
        SecurityHandler securityHandler = this.securityHandler;
        if (securityHandler != null) {
            return securityHandler;
        }
        throw new IOException("No security handler for filter " + getFilter());
    }

    public PDCryptFilterDictionary getStdCryptFilterDictionary() {
        return getCryptFilterDictionary(COSName.STD_CF);
    }

    public COSName getStreamFilterName() {
        COSName cOSName = (COSName) this.dictionary.getDictionaryObject(COSName.STM_F);
        return cOSName == null ? COSName.IDENTITY : cOSName;
    }

    public COSName getStringFilterName() {
        COSName cOSName = (COSName) this.dictionary.getDictionaryObject(COSName.STR_F);
        return cOSName == null ? COSName.IDENTITY : cOSName;
    }

    public String getSubFilter() {
        return this.dictionary.getNameAsString(COSName.SUB_FILTER);
    }

    public byte[] getUserEncryptionKey() throws IOException {
        COSString cOSString = (COSString) this.dictionary.getDictionaryObject(COSName.UE);
        if (cOSString != null) {
            return cOSString.getBytes();
        }
        return null;
    }

    public byte[] getUserKey() throws IOException {
        COSString cOSString = (COSString) this.dictionary.getDictionaryObject(COSName.U);
        if (cOSString != null) {
            return cOSString.getBytes();
        }
        return null;
    }

    public int getVersion() {
        return this.dictionary.getInt(COSName.V, 0);
    }

    public boolean hasSecurityHandler() {
        return this.securityHandler == null;
    }

    public boolean isEncryptMetaData() {
        COSBase dictionaryObject = this.dictionary.getDictionaryObject(COSName.ENCRYPT_META_DATA);
        if (dictionaryObject instanceof COSBoolean) {
            return ((COSBoolean) dictionaryObject).getValue();
        }
        return true;
    }

    public void removeV45filters() {
        this.dictionary.setItem(COSName.CF, (COSBase) null);
        this.dictionary.setItem(COSName.STM_F, (COSBase) null);
        this.dictionary.setItem(COSName.STR_F, (COSBase) null);
    }

    public void setCryptFilterDictionary(COSName cOSName, PDCryptFilterDictionary pDCryptFilterDictionary) {
        COSDictionary cOSDictionary = this.dictionary;
        COSName cOSName2 = COSName.CF;
        COSDictionary cOSDictionary2 = cOSDictionary.getCOSDictionary(cOSName2);
        if (cOSDictionary2 == null) {
            cOSDictionary2 = new COSDictionary();
            this.dictionary.setItem(cOSName2, (COSBase) cOSDictionary2);
        }
        cOSDictionary2.setDirect(true);
        cOSDictionary2.setItem(cOSName, (COSBase) pDCryptFilterDictionary.getCOSObject());
    }

    public void setDefaultCryptFilterDictionary(PDCryptFilterDictionary pDCryptFilterDictionary) {
        pDCryptFilterDictionary.getCOSObject().setDirect(true);
        setCryptFilterDictionary(COSName.DEFAULT_CRYPT_FILTER, pDCryptFilterDictionary);
    }

    public void setFilter(String str) {
        this.dictionary.setItem(COSName.FILTER, (COSBase) COSName.getPDFName(str));
    }

    public void setLength(int i2) {
        this.dictionary.setInt(COSName.LENGTH, i2);
    }

    public void setOwnerEncryptionKey(byte[] bArr) throws IOException {
        this.dictionary.setItem(COSName.OE, (COSBase) new COSString(bArr));
    }

    public void setOwnerKey(byte[] bArr) throws IOException {
        this.dictionary.setItem(COSName.O, (COSBase) new COSString(bArr));
    }

    public void setPermissions(int i2) {
        this.dictionary.setInt(COSName.P, i2);
    }

    public void setPerms(byte[] bArr) throws IOException {
        this.dictionary.setItem(COSName.PERMS, (COSBase) new COSString(bArr));
    }

    public void setRecipients(byte[][] bArr) throws IOException {
        COSArray cOSArray = new COSArray();
        for (byte[] bArr2 : bArr) {
            cOSArray.add((COSBase) new COSString(bArr2));
        }
        this.dictionary.setItem(COSName.RECIPIENTS, (COSBase) cOSArray);
        cOSArray.setDirect(true);
    }

    public void setRevision(int i2) {
        this.dictionary.setInt(COSName.R, i2);
    }

    public void setSecurityHandler(SecurityHandler securityHandler) {
        this.securityHandler = securityHandler;
    }

    public void setStdCryptFilterDictionary(PDCryptFilterDictionary pDCryptFilterDictionary) {
        pDCryptFilterDictionary.getCOSObject().setDirect(true);
        setCryptFilterDictionary(COSName.STD_CF, pDCryptFilterDictionary);
    }

    public void setStreamFilterName(COSName cOSName) {
        this.dictionary.setItem(COSName.STM_F, (COSBase) cOSName);
    }

    public void setStringFilterName(COSName cOSName) {
        this.dictionary.setItem(COSName.STR_F, (COSBase) cOSName);
    }

    public void setSubFilter(String str) {
        this.dictionary.setName(COSName.SUB_FILTER, str);
    }

    public void setUserEncryptionKey(byte[] bArr) throws IOException {
        this.dictionary.setItem(COSName.UE, (COSBase) new COSString(bArr));
    }

    public void setUserKey(byte[] bArr) throws IOException {
        this.dictionary.setItem(COSName.U, (COSBase) new COSString(bArr));
    }

    public void setVersion(int i2) {
        this.dictionary.setInt(COSName.V, i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.dictionary;
    }

    public PDEncryption(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
        this.securityHandler = SecurityHandlerFactory.INSTANCE.newSecurityHandlerForFilter(getFilter());
    }
}
