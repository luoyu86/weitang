package com.tom_roush.pdfbox.pdmodel;

import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import com.tom_roush.pdfbox.pdmodel.font.PDFont;
import com.tom_roush.pdfbox.pdmodel.font.PDFontFactory;
import com.tom_roush.pdfbox.pdmodel.graphics.PDXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import com.tom_roush.pdfbox.pdmodel.graphics.form.PDFormXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDImageXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import com.tom_roush.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern;
import com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading;
import com.tom_roush.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class PDResources implements COSObjectable {
    private final ResourceCache cache;
    private final Map<COSName, SoftReference<PDFont>> directFontCache;
    private final COSDictionary resources;

    public PDResources() {
        this.directFontCache = new HashMap();
        this.resources = new COSDictionary();
        this.cache = null;
    }

    private COSName createKey(COSName cOSName, String str) {
        String str2;
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        if (cOSDictionary == null) {
            return COSName.getPDFName(str + 1);
        }
        int size = cOSDictionary.keySet().size();
        do {
            size++;
            str2 = str + size;
        } while (cOSDictionary.containsKey(str2));
        return COSName.getPDFName(str2);
    }

    private COSBase get(COSName cOSName, COSName cOSName2) {
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        if (cOSDictionary == null) {
            return null;
        }
        return cOSDictionary.getDictionaryObject(cOSName2);
    }

    private COSObject getIndirect(COSName cOSName, COSName cOSName2) {
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        if (cOSDictionary == null) {
            return null;
        }
        COSBase item = cOSDictionary.getItem(cOSName2);
        if (item instanceof COSObject) {
            return (COSObject) item;
        }
        return null;
    }

    private Iterable<COSName> getNames(COSName cOSName) {
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        return cOSDictionary == null ? Collections.emptySet() : cOSDictionary.keySet();
    }

    private boolean isAllowedCache(PDXObject pDXObject) {
        if (!(pDXObject instanceof PDImageXObject)) {
            return true;
        }
        COSBase dictionaryObject = pDXObject.getCOSObject().getDictionaryObject(COSName.COLORSPACE);
        if (!(dictionaryObject instanceof COSName)) {
            return true;
        }
        COSName cOSName = (COSName) dictionaryObject;
        if (cOSName.equals(COSName.DEVICECMYK) && hasColorSpace(COSName.DEFAULT_CMYK)) {
            return false;
        }
        if (cOSName.equals(COSName.DEVICERGB) && hasColorSpace(COSName.DEFAULT_RGB)) {
            return false;
        }
        return ((cOSName.equals(COSName.DEVICEGRAY) && hasColorSpace(COSName.DEFAULT_GRAY)) || hasColorSpace(cOSName)) ? false : true;
    }

    private void put(COSName cOSName, COSName cOSName2, COSObjectable cOSObjectable) {
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        if (cOSDictionary == null) {
            cOSDictionary = new COSDictionary();
            this.resources.setItem(cOSName, (COSBase) cOSDictionary);
        }
        cOSDictionary.setItem(cOSName2, cOSObjectable);
    }

    public COSName add(PDFont pDFont) {
        return add(COSName.FONT, "F", pDFont);
    }

    public PDColorSpace getColorSpace(COSName cOSName) throws IOException {
        return getColorSpace(cOSName, false);
    }

    public Iterable<COSName> getColorSpaceNames() {
        return getNames(COSName.COLORSPACE);
    }

    public PDExtendedGraphicsState getExtGState(COSName cOSName) {
        PDExtendedGraphicsState extGState;
        COSName cOSName2 = COSName.EXT_G_STATE;
        COSObject indirect = getIndirect(cOSName2, cOSName);
        ResourceCache resourceCache = this.cache;
        if (resourceCache != null && indirect != null && (extGState = resourceCache.getExtGState(indirect)) != null) {
            return extGState;
        }
        COSBase cOSBase = get(cOSName2, cOSName);
        PDExtendedGraphicsState pDExtendedGraphicsState = cOSBase instanceof COSDictionary ? new PDExtendedGraphicsState((COSDictionary) cOSBase) : null;
        ResourceCache resourceCache2 = this.cache;
        if (resourceCache2 != null && indirect != null) {
            resourceCache2.put(indirect, pDExtendedGraphicsState);
        }
        return pDExtendedGraphicsState;
    }

    public Iterable<COSName> getExtGStateNames() {
        return getNames(COSName.EXT_G_STATE);
    }

    public PDFont getFont(COSName cOSName) throws IOException {
        SoftReference<PDFont> softReference;
        PDFont pDFont;
        COSName cOSName2 = COSName.FONT;
        COSObject indirect = getIndirect(cOSName2, cOSName);
        ResourceCache resourceCache = this.cache;
        if (resourceCache != null && indirect != null) {
            PDFont font = resourceCache.getFont(indirect);
            if (font != null) {
                return font;
            }
        } else if (indirect == null && (softReference = this.directFontCache.get(cOSName)) != null && (pDFont = softReference.get()) != null) {
            return pDFont;
        }
        COSBase cOSBase = get(cOSName2, cOSName);
        PDFont pDFontCreateFont = cOSBase instanceof COSDictionary ? PDFontFactory.createFont((COSDictionary) cOSBase, this.cache) : null;
        ResourceCache resourceCache2 = this.cache;
        if (resourceCache2 != null && indirect != null) {
            resourceCache2.put(indirect, pDFontCreateFont);
        } else if (indirect == null) {
            this.directFontCache.put(cOSName, new SoftReference<>(pDFontCreateFont));
        }
        return pDFontCreateFont;
    }

    public Iterable<COSName> getFontNames() {
        return getNames(COSName.FONT);
    }

    public PDAbstractPattern getPattern(COSName cOSName) throws IOException {
        PDAbstractPattern pattern;
        COSName cOSName2 = COSName.PATTERN;
        COSObject indirect = getIndirect(cOSName2, cOSName);
        ResourceCache resourceCache = this.cache;
        if (resourceCache != null && indirect != null && (pattern = resourceCache.getPattern(indirect)) != null) {
            return pattern;
        }
        COSBase cOSBase = get(cOSName2, cOSName);
        PDAbstractPattern pDAbstractPatternCreate = cOSBase instanceof COSDictionary ? PDAbstractPattern.create((COSDictionary) cOSBase, getResourceCache()) : null;
        ResourceCache resourceCache2 = this.cache;
        if (resourceCache2 != null && indirect != null) {
            resourceCache2.put(indirect, pDAbstractPatternCreate);
        }
        return pDAbstractPatternCreate;
    }

    public Iterable<COSName> getPatternNames() {
        return getNames(COSName.PATTERN);
    }

    public PDPropertyList getProperties(COSName cOSName) {
        PDPropertyList properties;
        COSName cOSName2 = COSName.PROPERTIES;
        COSObject indirect = getIndirect(cOSName2, cOSName);
        ResourceCache resourceCache = this.cache;
        if (resourceCache != null && indirect != null && (properties = resourceCache.getProperties(indirect)) != null) {
            return properties;
        }
        COSBase cOSBase = get(cOSName2, cOSName);
        PDPropertyList pDPropertyListCreate = cOSBase instanceof COSDictionary ? PDPropertyList.create((COSDictionary) cOSBase) : null;
        ResourceCache resourceCache2 = this.cache;
        if (resourceCache2 != null && indirect != null) {
            resourceCache2.put(indirect, pDPropertyListCreate);
        }
        return pDPropertyListCreate;
    }

    public Iterable<COSName> getPropertiesNames() {
        return getNames(COSName.PROPERTIES);
    }

    public ResourceCache getResourceCache() {
        return this.cache;
    }

    public PDShading getShading(COSName cOSName) throws IOException {
        PDShading shading;
        COSName cOSName2 = COSName.SHADING;
        COSObject indirect = getIndirect(cOSName2, cOSName);
        ResourceCache resourceCache = this.cache;
        if (resourceCache != null && indirect != null && (shading = resourceCache.getShading(indirect)) != null) {
            return shading;
        }
        COSBase cOSBase = get(cOSName2, cOSName);
        PDShading pDShadingCreate = cOSBase instanceof COSDictionary ? PDShading.create((COSDictionary) cOSBase) : null;
        ResourceCache resourceCache2 = this.cache;
        if (resourceCache2 != null && indirect != null) {
            resourceCache2.put(indirect, pDShadingCreate);
        }
        return pDShadingCreate;
    }

    public Iterable<COSName> getShadingNames() {
        return getNames(COSName.SHADING);
    }

    public PDXObject getXObject(COSName cOSName) throws IOException {
        PDXObject xObject;
        COSName cOSName2 = COSName.XOBJECT;
        COSObject indirect = getIndirect(cOSName2, cOSName);
        ResourceCache resourceCache = this.cache;
        if (resourceCache != null && indirect != null && (xObject = resourceCache.getXObject(indirect)) != null) {
            return xObject;
        }
        COSBase cOSBase = get(cOSName2, cOSName);
        PDXObject pDXObjectCreateXObject = cOSBase == null ? null : cOSBase instanceof COSObject ? PDXObject.createXObject(((COSObject) cOSBase).getObject(), this) : PDXObject.createXObject(cOSBase, this);
        if (this.cache != null && indirect != null && isAllowedCache(pDXObjectCreateXObject)) {
            this.cache.put(indirect, pDXObjectCreateXObject);
        }
        return pDXObjectCreateXObject;
    }

    public Iterable<COSName> getXObjectNames() {
        return getNames(COSName.XOBJECT);
    }

    public boolean hasColorSpace(COSName cOSName) {
        return get(COSName.COLORSPACE, cOSName) != null;
    }

    public boolean isImageXObject(COSName cOSName) {
        COSBase object = get(COSName.XOBJECT, cOSName);
        if (object == null) {
            return false;
        }
        if (object instanceof COSObject) {
            object = ((COSObject) object).getObject();
        }
        if (object instanceof COSStream) {
            return COSName.IMAGE.equals(((COSStream) object).getCOSName(COSName.SUBTYPE));
        }
        return false;
    }

    public COSName add(PDColorSpace pDColorSpace) {
        return add(COSName.COLORSPACE, OperatorName.NON_STROKING_COLORSPACE, pDColorSpace);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.resources;
    }

    public PDColorSpace getColorSpace(COSName cOSName, boolean z) throws IOException {
        PDColorSpace colorSpace;
        COSName cOSName2 = COSName.COLORSPACE;
        COSObject indirect = getIndirect(cOSName2, cOSName);
        ResourceCache resourceCache = this.cache;
        if (resourceCache != null && indirect != null && (colorSpace = resourceCache.getColorSpace(indirect)) != null) {
            return colorSpace;
        }
        COSBase cOSBase = get(cOSName2, cOSName);
        PDColorSpace pDColorSpaceCreate = cOSBase != null ? PDColorSpace.create(cOSBase, this, z) : PDColorSpace.create(cOSName, this, z);
        ResourceCache resourceCache2 = this.cache;
        if (resourceCache2 != null && indirect != null) {
            resourceCache2.put(indirect, pDColorSpaceCreate);
        }
        return pDColorSpaceCreate;
    }

    public COSName add(PDExtendedGraphicsState pDExtendedGraphicsState) {
        return add(COSName.EXT_G_STATE, OperatorName.SET_GRAPHICS_STATE_PARAMS, pDExtendedGraphicsState);
    }

    public COSName add(PDShading pDShading) {
        return add(COSName.SHADING, OperatorName.SHADING_FILL, pDShading);
    }

    public PDResources(COSDictionary cOSDictionary) {
        this.directFontCache = new HashMap();
        if (cOSDictionary != null) {
            this.resources = cOSDictionary;
            this.cache = null;
            return;
        }
        throw new IllegalArgumentException("resourceDictionary is null");
    }

    public COSName add(PDAbstractPattern pDAbstractPattern) {
        return add(COSName.PATTERN, "p", pDAbstractPattern);
    }

    public void put(COSName cOSName, PDFont pDFont) {
        put(COSName.FONT, cOSName, pDFont);
    }

    public COSName add(PDPropertyList pDPropertyList) {
        if (pDPropertyList instanceof PDOptionalContentGroup) {
            return add(COSName.PROPERTIES, "oc", pDPropertyList);
        }
        return add(COSName.PROPERTIES, "Prop", pDPropertyList);
    }

    public void put(COSName cOSName, PDColorSpace pDColorSpace) {
        put(COSName.COLORSPACE, cOSName, pDColorSpace);
    }

    public void put(COSName cOSName, PDExtendedGraphicsState pDExtendedGraphicsState) {
        put(COSName.EXT_G_STATE, cOSName, pDExtendedGraphicsState);
    }

    public void put(COSName cOSName, PDShading pDShading) {
        put(COSName.SHADING, cOSName, pDShading);
    }

    public COSName add(PDImageXObject pDImageXObject) {
        return add(COSName.XOBJECT, "Im", pDImageXObject);
    }

    public void put(COSName cOSName, PDAbstractPattern pDAbstractPattern) {
        put(COSName.PATTERN, cOSName, pDAbstractPattern);
    }

    public PDResources(COSDictionary cOSDictionary, ResourceCache resourceCache) {
        this.directFontCache = new HashMap();
        if (cOSDictionary != null) {
            this.resources = cOSDictionary;
            this.cache = resourceCache;
            return;
        }
        throw new IllegalArgumentException("resourceDictionary is null");
    }

    public COSName add(PDFormXObject pDFormXObject) {
        return add(COSName.XOBJECT, StandardStructureTypes.FORM, pDFormXObject);
    }

    public void put(COSName cOSName, PDPropertyList pDPropertyList) {
        put(COSName.PROPERTIES, cOSName, pDPropertyList);
    }

    public COSName add(PDXObject pDXObject, String str) {
        return add(COSName.XOBJECT, str, pDXObject);
    }

    public void put(COSName cOSName, PDXObject pDXObject) {
        put(COSName.XOBJECT, cOSName, pDXObject);
    }

    private COSName add(COSName cOSName, String str, COSObjectable cOSObjectable) {
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        if (cOSDictionary != null && cOSDictionary.containsValue(cOSObjectable.getCOSObject())) {
            return cOSDictionary.getKeyForValue(cOSObjectable.getCOSObject());
        }
        if (cOSDictionary != null && COSName.FONT.equals(cOSName)) {
            for (Map.Entry<COSName, COSBase> entry : cOSDictionary.entrySet()) {
                if ((entry.getValue() instanceof COSObject) && cOSObjectable.getCOSObject() == ((COSObject) entry.getValue()).getObject()) {
                    return entry.getKey();
                }
            }
        }
        COSName cOSNameCreateKey = createKey(cOSName, str);
        put(cOSName, cOSNameCreateKey, cOSObjectable);
        return cOSNameCreateKey;
    }
}
