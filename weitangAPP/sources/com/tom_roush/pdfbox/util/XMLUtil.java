package com.tom_roush.pdfbox.util;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes2.dex */
public final class XMLUtil {
    private XMLUtil() {
    }

    public static String getNodeValue(Element element) {
        StringBuilder sb = new StringBuilder();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            Node nodeItem = childNodes.item(i2);
            if (nodeItem instanceof Text) {
                sb.append(nodeItem.getNodeValue());
            }
        }
        return sb.toString();
    }

    public static Document parse(InputStream inputStream) throws IOException {
        return parse(inputStream, false);
    }

    public static Document parse(InputStream inputStream, boolean z) throws IOException {
        try {
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            documentBuilderFactoryNewInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            documentBuilderFactoryNewInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            documentBuilderFactoryNewInstance.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            documentBuilderFactoryNewInstance.setXIncludeAware(false);
            documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
            documentBuilderFactoryNewInstance.setNamespaceAware(z);
            return documentBuilderFactoryNewInstance.newDocumentBuilder().parse(inputStream);
        } catch (FactoryConfigurationError e2) {
            throw new IOException(e2.getMessage(), e2);
        } catch (ParserConfigurationException e3) {
            throw new IOException(e3.getMessage(), e3);
        } catch (SAXException e4) {
            throw new IOException(e4.getMessage(), e4);
        }
    }
}
