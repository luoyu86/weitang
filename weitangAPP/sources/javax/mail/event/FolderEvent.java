package javax.mail.event;

import javax.mail.Folder;

/* JADX INFO: loaded from: classes2.dex */
public class FolderEvent extends MailEvent {
    public static final int CREATED = 1;
    public static final int DELETED = 2;
    public static final int RENAMED = 3;
    private static final long serialVersionUID = 5278131310563694307L;
    public transient Folder folder;
    public transient Folder newFolder;
    public int type;

    public FolderEvent(Object obj, Folder folder, int i2) {
        this(obj, folder, folder, i2);
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        int i2 = this.type;
        if (i2 == 1) {
            ((FolderListener) obj).folderCreated(this);
        } else if (i2 == 2) {
            ((FolderListener) obj).folderDeleted(this);
        } else if (i2 == 3) {
            ((FolderListener) obj).folderRenamed(this);
        }
    }

    public Folder getFolder() {
        return this.folder;
    }

    public Folder getNewFolder() {
        return this.newFolder;
    }

    public int getType() {
        return this.type;
    }

    public FolderEvent(Object obj, Folder folder, Folder folder2, int i2) {
        super(obj);
        this.folder = folder;
        this.newFolder = folder2;
        this.type = i2;
    }
}
