package c.e.b.c.d;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    private String right;
    private boolean isBack = true;
    private boolean isTransparent = false;
    private String titleColor = "#000000";
    private String rightColor = "#3384fe";
    private String backgroundColor = "#ffffff";
    private String rightButtonText = "";

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getRight() {
        return this.right;
    }

    public String getRightButtonText() {
        return this.rightButtonText;
    }

    public String getRightColor() {
        return this.rightColor;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    public boolean isBack() {
        return this.isBack;
    }

    public boolean isTransparent() {
        return this.isTransparent;
    }

    public void setBack(boolean z) {
        this.isBack = z;
    }

    public void setBackgroundColor(String str) {
        this.backgroundColor = str;
    }

    public void setRight(String str) {
        this.right = str;
    }

    public void setRightButtonText(String str) {
        this.rightButtonText = str;
    }

    public void setRightColor(String str) {
        this.rightColor = str;
    }

    public void setTitleColor(String str) {
        this.titleColor = str;
    }

    public void setTransparent(boolean z) {
        this.isTransparent = z;
    }
}
