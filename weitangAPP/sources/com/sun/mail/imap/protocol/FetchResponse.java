package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.util.ASCIIUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FetchResponse extends IMAPResponse {
    private static final char[] HEADER = {'.', 'H', 'E', 'A', 'D', 'E', 'R'};
    private static final char[] TEXT = {'.', 'T', 'E', 'X', 'T'};
    private Map<String, Object> extensionItems;
    private final FetchItem[] fitems;
    private Item[] items;

    public FetchResponse(Protocol protocol) throws ProtocolException, IOException {
        super(protocol);
        this.fitems = null;
        parse();
    }

    public static <T extends Item> List<T> getItems(Response[] responseArr, int i2, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (responseArr == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < responseArr.length; i3++) {
            if (responseArr[i3] != null && (responseArr[i3] instanceof FetchResponse) && ((FetchResponse) responseArr[i3]).getNumber() == i2) {
                FetchResponse fetchResponse = (FetchResponse) responseArr[i3];
                int i4 = 0;
                while (true) {
                    Item[] itemArr = fetchResponse.items;
                    if (i4 < itemArr.length) {
                        if (cls.isInstance(itemArr[i4])) {
                            arrayList.add(cls.cast(fetchResponse.items[i4]));
                        }
                        i4++;
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean match(char[] cArr) {
        int length = cArr.length;
        int i2 = this.index;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            int i5 = i3 + 1;
            if (Character.toUpperCase((char) this.buffer[i2]) != cArr[i3]) {
                return false;
            }
            i3 = i5;
            i2 = i4;
        }
        this.index += length;
        return true;
    }

    private String next20() {
        int i2 = this.index;
        int i3 = i2 + 20;
        int i4 = this.size;
        if (i3 > i4) {
            return ASCIIUtility.toString(this.buffer, i2, i4);
        }
        StringBuilder sb = new StringBuilder();
        byte[] bArr = this.buffer;
        int i5 = this.index;
        sb.append(ASCIIUtility.toString(bArr, i5, i5 + 20));
        sb.append("...");
        return sb.toString();
    }

    private void parse() throws ParsingException {
        if (!isNextNonSpace('(')) {
            throw new ParsingException("error in FETCH parsing, missing '(' at index " + this.index);
        }
        ArrayList arrayList = new ArrayList();
        skipSpaces();
        while (this.index < this.size) {
            Item item = parseItem();
            if (item != null) {
                arrayList.add(item);
            } else if (!parseExtensionItem()) {
                throw new ParsingException("error in FETCH parsing, unrecognized item at index " + this.index + ", starts with \"" + next20() + "\"");
            }
            if (isNextNonSpace(')')) {
                this.items = (Item[]) arrayList.toArray(new Item[arrayList.size()]);
                return;
            }
        }
        throw new ParsingException("error in FETCH parsing, ran off end of buffer, size " + this.size);
    }

    private boolean parseExtensionItem() throws ParsingException {
        if (this.fitems == null) {
            return false;
        }
        int i2 = 0;
        while (true) {
            FetchItem[] fetchItemArr = this.fitems;
            if (i2 >= fetchItemArr.length) {
                return false;
            }
            if (match(fetchItemArr[i2].getName())) {
                if (this.extensionItems == null) {
                    this.extensionItems = new HashMap();
                }
                this.extensionItems.put(this.fitems[i2].getName(), this.fitems[i2].parseItem(this));
                return true;
            }
            i2++;
        }
    }

    private Item parseItem() throws ParsingException {
        byte b2 = this.buffer[this.index];
        if (b2 != 66) {
            if (b2 != 73) {
                if (b2 != 77) {
                    if (b2 != 82) {
                        if (b2 != 85) {
                            if (b2 != 98) {
                                if (b2 != 105) {
                                    if (b2 != 109) {
                                        if (b2 != 114) {
                                            if (b2 != 117) {
                                                if (b2 != 69) {
                                                    if (b2 != 70) {
                                                        if (b2 != 101) {
                                                            if (b2 != 102) {
                                                                return null;
                                                            }
                                                        }
                                                    }
                                                    if (match(FLAGS.name)) {
                                                        return new FLAGS(this);
                                                    }
                                                    return null;
                                                }
                                                if (match(ENVELOPE.name)) {
                                                    return new ENVELOPE(this);
                                                }
                                                return null;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (match(UID.name)) {
                            return new UID(this);
                        }
                        return null;
                    }
                    if (match(RFC822SIZE.name)) {
                        return new RFC822SIZE(this);
                    }
                    if (!match(RFC822DATA.name)) {
                        return null;
                    }
                    boolean z = false;
                    if (match(HEADER)) {
                        z = true;
                    } else {
                        match(TEXT);
                    }
                    return new RFC822DATA(this, z);
                }
                if (match(MODSEQ.name)) {
                    return new MODSEQ(this);
                }
                return null;
            }
            if (match(INTERNALDATE.name)) {
                return new INTERNALDATE(this);
            }
            return null;
        }
        if (match(BODYSTRUCTURE.name)) {
            return new BODYSTRUCTURE(this);
        }
        if (match(BODY.name)) {
            return this.buffer[this.index] == 91 ? new BODY(this) : new BODYSTRUCTURE(this);
        }
        return null;
    }

    public Map<String, Object> getExtensionItems() {
        return this.extensionItems;
    }

    public Item getItem(int i2) {
        return this.items[i2];
    }

    public int getItemCount() {
        return this.items.length;
    }

    public <T extends Item> T getItem(Class<T> cls) {
        int i2 = 0;
        while (true) {
            Item[] itemArr = this.items;
            if (i2 >= itemArr.length) {
                return null;
            }
            if (cls.isInstance(itemArr[i2])) {
                return cls.cast(this.items[i2]);
            }
            i2++;
        }
    }

    public FetchResponse(IMAPResponse iMAPResponse) throws ProtocolException, IOException {
        this(iMAPResponse, null);
    }

    public FetchResponse(IMAPResponse iMAPResponse, FetchItem[] fetchItemArr) throws ProtocolException, IOException {
        super(iMAPResponse);
        this.fitems = fetchItemArr;
        parse();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T extends com.sun.mail.imap.protocol.Item> T getItem(com.sun.mail.iap.Response[] r7, int r8, java.lang.Class<T> r9) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            r1 = 0
            r2 = 0
        L6:
            int r3 = r7.length
            if (r2 >= r3) goto L41
            r3 = r7[r2]
            if (r3 == 0) goto L3e
            r3 = r7[r2]
            boolean r3 = r3 instanceof com.sun.mail.imap.protocol.FetchResponse
            if (r3 == 0) goto L3e
            r3 = r7[r2]
            com.sun.mail.imap.protocol.FetchResponse r3 = (com.sun.mail.imap.protocol.FetchResponse) r3
            int r3 = r3.getNumber()
            if (r3 == r8) goto L1e
            goto L3e
        L1e:
            r3 = r7[r2]
            com.sun.mail.imap.protocol.FetchResponse r3 = (com.sun.mail.imap.protocol.FetchResponse) r3
            r4 = 0
        L23:
            com.sun.mail.imap.protocol.Item[] r5 = r3.items
            int r6 = r5.length
            if (r4 >= r6) goto L3e
            r5 = r5[r4]
            boolean r5 = r9.isInstance(r5)
            if (r5 == 0) goto L3b
            com.sun.mail.imap.protocol.Item[] r7 = r3.items
            r7 = r7[r4]
            java.lang.Object r7 = r9.cast(r7)
            com.sun.mail.imap.protocol.Item r7 = (com.sun.mail.imap.protocol.Item) r7
            return r7
        L3b:
            int r4 = r4 + 1
            goto L23
        L3e:
            int r2 = r2 + 1
            goto L6
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.FetchResponse.getItem(com.sun.mail.iap.Response[], int, java.lang.Class):com.sun.mail.imap.protocol.Item");
    }

    private boolean match(String str) {
        int length = str.length();
        int i2 = this.index;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            int i5 = i3 + 1;
            if (Character.toUpperCase((char) this.buffer[i2]) != str.charAt(i3)) {
                return false;
            }
            i3 = i5;
            i2 = i4;
        }
        this.index += length;
        return true;
    }
}
