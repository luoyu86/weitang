package com.tom_roush.pdfbox.pdmodel.interactive.form;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSDictionary;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PDFieldTree implements Iterable<PDField> {
    private final PDAcroForm acroForm;

    public static final class FieldIterator implements Iterator<PDField> {
        private final Queue<PDField> queue;
        private final Set<COSDictionary> set;

        private void enqueueKids(PDField pDField) {
            this.queue.add(pDField);
            this.set.add(pDField.getCOSObject());
            if (pDField instanceof PDNonTerminalField) {
                for (PDField pDField2 : ((PDNonTerminalField) pDField).getChildren()) {
                    if (this.set.contains(pDField2.getCOSObject())) {
                        Log.e("PdfBox-Android", "Child of field '" + pDField.getFullyQualifiedName() + "' already exists elsewhere, ignored to avoid recursion");
                    } else {
                        enqueueKids(pDField2);
                    }
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private FieldIterator(PDAcroForm pDAcroForm) {
            this.queue = new ArrayDeque();
            this.set = Collections.newSetFromMap(new IdentityHashMap());
            Iterator<PDField> it = pDAcroForm.getFields().iterator();
            while (it.hasNext()) {
                enqueueKids(it.next());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public PDField next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }
    }

    public PDFieldTree(PDAcroForm pDAcroForm) {
        if (pDAcroForm == null) {
            throw new IllegalArgumentException("root cannot be null");
        }
        this.acroForm = pDAcroForm;
    }

    @Override // java.lang.Iterable
    public Iterator<PDField> iterator() {
        return new FieldIterator(this.acroForm);
    }
}
