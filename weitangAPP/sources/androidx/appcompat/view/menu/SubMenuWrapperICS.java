package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    public SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        getWrappedObject().clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return getMenuItemWrapper(getWrappedObject().getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        getWrappedObject().setHeaderIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        getWrappedObject().setHeaderTitle(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        getWrappedObject().setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        getWrappedObject().setIcon(i2);
        return this;
    }

    @Override // androidx.appcompat.view.menu.BaseWrapper
    public SupportSubMenu getWrappedObject() {
        return (SupportSubMenu) this.mWrappedObject;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        getWrappedObject().setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        getWrappedObject().setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        getWrappedObject().setIcon(drawable);
        return this;
    }
}
