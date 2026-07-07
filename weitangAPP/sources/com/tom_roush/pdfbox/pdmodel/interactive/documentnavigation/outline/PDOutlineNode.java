package com.tom_roush.pdfbox.pdmodel.interactive.documentnavigation.outline;

import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.PDDictionaryWrapper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDOutlineNode extends PDDictionaryWrapper {
    public PDOutlineNode() {
    }

    private void append(PDOutlineItem pDOutlineItem) {
        pDOutlineItem.setParent(this);
        if (hasChildren()) {
            PDOutlineItem lastChild = getLastChild();
            lastChild.setNextSibling(pDOutlineItem);
            pDOutlineItem.setPreviousSibling(lastChild);
        } else {
            setFirstChild(pDOutlineItem);
        }
        setLastChild(pDOutlineItem);
    }

    private void prepend(PDOutlineItem pDOutlineItem) {
        pDOutlineItem.setParent(this);
        if (hasChildren()) {
            PDOutlineItem firstChild = getFirstChild();
            pDOutlineItem.setNextSibling(firstChild);
            firstChild.setPreviousSibling(pDOutlineItem);
        } else {
            setLastChild(pDOutlineItem);
        }
        setFirstChild(pDOutlineItem);
    }

    private void switchNodeCount() {
        int i2 = -getOpenCount();
        setOpenCount(i2);
        updateParentOpenCount(i2);
    }

    public void addFirst(PDOutlineItem pDOutlineItem) {
        requireSingleNode(pDOutlineItem);
        prepend(pDOutlineItem);
        updateParentOpenCountForAddedChild(pDOutlineItem);
    }

    public void addLast(PDOutlineItem pDOutlineItem) {
        requireSingleNode(pDOutlineItem);
        append(pDOutlineItem);
        updateParentOpenCountForAddedChild(pDOutlineItem);
    }

    public Iterable<PDOutlineItem> children() {
        return new Iterable<PDOutlineItem>() { // from class: com.tom_roush.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode.1
            @Override // java.lang.Iterable
            public Iterator<PDOutlineItem> iterator() {
                return new PDOutlineItemIterator(PDOutlineNode.this.getFirstChild());
            }
        };
    }

    public void closeNode() {
        if (isNodeOpen()) {
            switchNodeCount();
        }
    }

    public PDOutlineItem getFirstChild() {
        return getOutlineItem(COSName.FIRST);
    }

    public PDOutlineItem getLastChild() {
        return getOutlineItem(COSName.LAST);
    }

    public int getOpenCount() {
        return getCOSObject().getInt(COSName.COUNT, 0);
    }

    public PDOutlineItem getOutlineItem(COSName cOSName) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(cOSName);
        if (dictionaryObject instanceof COSDictionary) {
            return new PDOutlineItem((COSDictionary) dictionaryObject);
        }
        return null;
    }

    public PDOutlineNode getParent() {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(COSName.PARENT);
        if (!(dictionaryObject instanceof COSDictionary)) {
            return null;
        }
        COSDictionary cOSDictionary = (COSDictionary) dictionaryObject;
        return COSName.OUTLINES.equals(cOSDictionary.getCOSName(COSName.TYPE)) ? new PDDocumentOutline(cOSDictionary) : new PDOutlineItem(cOSDictionary);
    }

    public boolean hasChildren() {
        return getCOSObject().getCOSDictionary(COSName.FIRST) != null;
    }

    public boolean isNodeOpen() {
        return getOpenCount() > 0;
    }

    public void openNode() {
        if (isNodeOpen()) {
            return;
        }
        switchNodeCount();
    }

    public void requireSingleNode(PDOutlineItem pDOutlineItem) {
        if (pDOutlineItem.getNextSibling() != null || pDOutlineItem.getPreviousSibling() != null) {
            throw new IllegalArgumentException("A single node with no siblings is required");
        }
    }

    public void setFirstChild(PDOutlineNode pDOutlineNode) {
        getCOSObject().setItem(COSName.FIRST, pDOutlineNode);
    }

    public void setLastChild(PDOutlineNode pDOutlineNode) {
        getCOSObject().setItem(COSName.LAST, pDOutlineNode);
    }

    public void setOpenCount(int i2) {
        getCOSObject().setInt(COSName.COUNT, i2);
    }

    public void setParent(PDOutlineNode pDOutlineNode) {
        getCOSObject().setItem(COSName.PARENT, pDOutlineNode);
    }

    public void updateParentOpenCount(int i2) {
        PDOutlineNode parent = getParent();
        if (parent != null) {
            if (!parent.isNodeOpen()) {
                parent.setOpenCount(parent.getOpenCount() - i2);
            } else {
                parent.setOpenCount(parent.getOpenCount() + i2);
                parent.updateParentOpenCount(i2);
            }
        }
    }

    public void updateParentOpenCountForAddedChild(PDOutlineItem pDOutlineItem) {
        pDOutlineItem.updateParentOpenCount(pDOutlineItem.isNodeOpen() ? 1 + pDOutlineItem.getOpenCount() : 1);
    }

    public PDOutlineNode(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
