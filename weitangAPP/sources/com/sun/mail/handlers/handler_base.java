package com.sun.mail.handlers;

import java.io.IOException;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;

/* JADX INFO: loaded from: classes2.dex */
public abstract class handler_base implements DataContentHandler {
    public Object getData(ActivationDataFlavor activationDataFlavor, DataSource dataSource) throws IOException {
        return getContent(dataSource);
    }

    public abstract ActivationDataFlavor[] getDataFlavors();

    @Override // javax.activation.DataContentHandler
    public Object getTransferData(ActivationDataFlavor activationDataFlavor, DataSource dataSource) throws IOException {
        ActivationDataFlavor[] dataFlavors = getDataFlavors();
        for (int i2 = 0; i2 < dataFlavors.length; i2++) {
            if (dataFlavors[i2].equals(activationDataFlavor)) {
                return getData(dataFlavors[i2], dataSource);
            }
        }
        return null;
    }

    @Override // javax.activation.DataContentHandler
    public ActivationDataFlavor[] getTransferDataFlavors() {
        return (ActivationDataFlavor[]) getDataFlavors().clone();
    }
}
