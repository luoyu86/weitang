package androidx.databinding.adapters;

import android.util.SparseBooleanArray;
import android.widget.TableLayout;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TableLayoutBindingAdapter {
    private static final int MAX_COLUMNS = 20;
    private static Pattern sColumnPattern = Pattern.compile("\\s*,\\s*");

    private static SparseBooleanArray parseColumns(CharSequence charSequence) {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        if (charSequence == null) {
            return sparseBooleanArray;
        }
        for (String str : sColumnPattern.split(charSequence)) {
            try {
                int i2 = Integer.parseInt(str);
                if (i2 >= 0) {
                    sparseBooleanArray.put(i2, true);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return sparseBooleanArray;
    }

    @BindingAdapter({"android:collapseColumns"})
    public static void setCollapseColumns(TableLayout tableLayout, CharSequence charSequence) {
        SparseBooleanArray columns = parseColumns(charSequence);
        for (int i2 = 0; i2 < 20; i2++) {
            boolean z = columns.get(i2, false);
            if (z != tableLayout.isColumnCollapsed(i2)) {
                tableLayout.setColumnCollapsed(i2, z);
            }
        }
    }

    @BindingAdapter({"android:shrinkColumns"})
    public static void setShrinkColumns(TableLayout tableLayout, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && charSequence.charAt(0) == '*') {
            tableLayout.setShrinkAllColumns(true);
            return;
        }
        tableLayout.setShrinkAllColumns(false);
        SparseBooleanArray columns = parseColumns(charSequence);
        int size = columns.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = columns.keyAt(i2);
            boolean zValueAt = columns.valueAt(i2);
            if (zValueAt) {
                tableLayout.setColumnShrinkable(iKeyAt, zValueAt);
            }
        }
    }

    @BindingAdapter({"android:stretchColumns"})
    public static void setStretchColumns(TableLayout tableLayout, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && charSequence.charAt(0) == '*') {
            tableLayout.setStretchAllColumns(true);
            return;
        }
        tableLayout.setStretchAllColumns(false);
        SparseBooleanArray columns = parseColumns(charSequence);
        int size = columns.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = columns.keyAt(i2);
            boolean zValueAt = columns.valueAt(i2);
            if (zValueAt) {
                tableLayout.setColumnStretchable(iKeyAt, zValueAt);
            }
        }
    }
}
