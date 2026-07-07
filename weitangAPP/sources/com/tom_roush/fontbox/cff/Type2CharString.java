package com.tom_roush.fontbox.cff;

import com.tom_roush.fontbox.type1.Type1CharStringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Type2CharString extends Type1CharString {
    private float defWidthX;
    private final int gid;
    private float nominalWidthX;
    private int pathCount;
    private final List<Object> type2sequence;

    public Type2CharString(Type1CharStringReader type1CharStringReader, String str, String str2, int i2, List<Object> list, int i3, int i4) {
        super(type1CharStringReader, str, str2);
        this.defWidthX = 0.0f;
        this.nominalWidthX = 0.0f;
        this.pathCount = 0;
        this.gid = i2;
        this.type2sequence = list;
        this.defWidthX = i3;
        this.nominalWidthX = i4;
        convertType1ToType2(list);
    }

    private void addCommand(List<Number> list, CharStringCommand charStringCommand) {
        this.type1Sequence.addAll(list);
        this.type1Sequence.add(charStringCommand);
    }

    private void addCommandList(List<List<Number>> list, CharStringCommand charStringCommand) {
        Iterator<List<Number>> it = list.iterator();
        while (it.hasNext()) {
            addCommand(it.next(), charStringCommand);
        }
    }

    private List<Number> clearStack(List<Number> list, boolean z) {
        if (!this.type1Sequence.isEmpty()) {
            return list;
        }
        if (z) {
            addCommand(Arrays.asList(Float.valueOf(0.0f), Float.valueOf(list.get(0).floatValue() + this.nominalWidthX)), new CharStringCommand(13));
            return list.subList(1, list.size());
        }
        addCommand(Arrays.asList(Float.valueOf(0.0f), Float.valueOf(this.defWidthX)), new CharStringCommand(13));
        return list;
    }

    private void closeCharString2Path() {
        CharStringCommand charStringCommand;
        if (this.pathCount > 0) {
            charStringCommand = (CharStringCommand) this.type1Sequence.get(r0.size() - 1);
        } else {
            charStringCommand = null;
        }
        CharStringCommand charStringCommand2 = new CharStringCommand(9);
        if (charStringCommand == null || charStringCommand2.equals(charStringCommand)) {
            return;
        }
        addCommand(Collections.emptyList(), charStringCommand2);
    }

    private void convertType1ToType2(List<Object> list) {
        this.type1Sequence = new ArrayList();
        this.pathCount = 0;
        new CharStringHandler() { // from class: com.tom_roush.fontbox.cff.Type2CharString.1
            @Override // com.tom_roush.fontbox.cff.CharStringHandler
            public List<Number> handleCommand(List<Number> list2, CharStringCommand charStringCommand) {
                return Type2CharString.this.handleCommand(list2, charStringCommand);
            }
        }.handleSequence(list);
    }

    private void drawAlternatingCurve(List<Number> list, boolean z) {
        while (true) {
            int i2 = 4;
            if (list.size() < 4) {
                return;
            }
            boolean z2 = list.size() == 5;
            if (z) {
                Number[] numberArr = new Number[6];
                numberArr[0] = list.get(0);
                numberArr[1] = 0;
                numberArr[2] = list.get(1);
                numberArr[3] = list.get(2);
                numberArr[4] = z2 ? list.get(4) : 0;
                numberArr[5] = list.get(3);
                addCommand(Arrays.asList(numberArr), new CharStringCommand(8));
            } else {
                Number[] numberArr2 = new Number[6];
                numberArr2[0] = 0;
                numberArr2[1] = list.get(0);
                numberArr2[2] = list.get(1);
                numberArr2[3] = list.get(2);
                numberArr2[4] = list.get(3);
                numberArr2[5] = z2 ? list.get(4) : 0;
                addCommand(Arrays.asList(numberArr2), new CharStringCommand(8));
            }
            if (z2) {
                i2 = 5;
            }
            list = list.subList(i2, list.size());
            z = !z;
        }
    }

    private void drawAlternatingLine(List<Number> list, boolean z) {
        while (!list.isEmpty()) {
            addCommand(list.subList(0, 1), new CharStringCommand(z ? 6 : 7));
            list = list.subList(1, list.size());
            z = !z;
        }
    }

    private void drawCurve(List<Number> list, boolean z) {
        while (true) {
            int i2 = 4;
            if (list.size() < 4) {
                return;
            }
            int i3 = list.size() % 4 == 1 ? 1 : 0;
            if (z) {
                Number[] numberArr = new Number[6];
                numberArr[0] = list.get(i3);
                numberArr[1] = i3 != 0 ? list.get(0) : 0;
                numberArr[2] = list.get(i3 != 0 ? 2 : 1);
                numberArr[3] = list.get(i3 != 0 ? 3 : 2);
                numberArr[4] = list.get(i3 != 0 ? 4 : 3);
                numberArr[5] = 0;
                addCommand(Arrays.asList(numberArr), new CharStringCommand(8));
            } else {
                Number[] numberArr2 = new Number[6];
                numberArr2[0] = i3 != 0 ? list.get(0) : 0;
                numberArr2[1] = list.get(i3);
                numberArr2[2] = list.get(i3 != 0 ? 2 : 1);
                numberArr2[3] = list.get(i3 != 0 ? 3 : 2);
                numberArr2[4] = 0;
                numberArr2[5] = list.get(i3 != 0 ? 4 : 3);
                addCommand(Arrays.asList(numberArr2), new CharStringCommand(8));
            }
            if (i3 != 0) {
                i2 = 5;
            }
            list = list.subList(i2, list.size());
        }
    }

    private void expandStemHints(List<Number> list, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Number> handleCommand(List<Number> list, CharStringCommand charStringCommand) {
        this.commandCount++;
        String str = CharStringCommand.TYPE2_VOCABULARY.get(charStringCommand.getKey());
        if ("hstem".equals(str)) {
            expandStemHints(clearStack(list, list.size() % 2 != 0), true);
            return null;
        }
        if ("vstem".equals(str)) {
            expandStemHints(clearStack(list, list.size() % 2 != 0), false);
            return null;
        }
        if ("vmoveto".equals(str)) {
            List<Number> listClearStack = clearStack(list, list.size() > 1);
            markPath();
            addCommand(listClearStack, charStringCommand);
            return null;
        }
        if ("rlineto".equals(str)) {
            addCommandList(split(list, 2), charStringCommand);
            return null;
        }
        if ("hlineto".equals(str)) {
            drawAlternatingLine(list, true);
            return null;
        }
        if ("vlineto".equals(str)) {
            drawAlternatingLine(list, false);
            return null;
        }
        if ("rrcurveto".equals(str)) {
            addCommandList(split(list, 6), charStringCommand);
            return null;
        }
        if ("endchar".equals(str)) {
            if (list.size() != 5 && list.size() != 1) {
                z = false;
            }
            List<Number> listClearStack2 = clearStack(list, z);
            closeCharString2Path();
            if (listClearStack2.size() != 4) {
                addCommand(listClearStack2, charStringCommand);
                return null;
            }
            listClearStack2.add(0, 0);
            addCommand(listClearStack2, new CharStringCommand(12, 6));
            return null;
        }
        if ("rmoveto".equals(str)) {
            List<Number> listClearStack3 = clearStack(list, list.size() > 2);
            markPath();
            addCommand(listClearStack3, charStringCommand);
            return null;
        }
        if ("hmoveto".equals(str)) {
            List<Number> listClearStack4 = clearStack(list, list.size() > 1);
            markPath();
            addCommand(listClearStack4, charStringCommand);
            return null;
        }
        if ("vhcurveto".equals(str)) {
            drawAlternatingCurve(list, false);
            return null;
        }
        if ("hvcurveto".equals(str)) {
            drawAlternatingCurve(list, true);
            return null;
        }
        if ("hflex".equals(str)) {
            addCommandList(Arrays.asList(Arrays.asList(list.get(0), 0, list.get(1), list.get(2), list.get(3), 0), Arrays.asList(list.get(4), 0, list.get(5), Float.valueOf(-list.get(2).floatValue()), list.get(6), 0)), new CharStringCommand(8));
            return null;
        }
        if ("flex".equals(str)) {
            addCommandList(Arrays.asList(list.subList(0, 6), list.subList(6, 12)), new CharStringCommand(8));
            return null;
        }
        if ("hflex1".equals(str)) {
            addCommandList(Arrays.asList(Arrays.asList(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), 0), Arrays.asList(list.get(5), 0, list.get(6), list.get(7), list.get(8), 0)), new CharStringCommand(8));
            return null;
        }
        if ("flex1".equals(str)) {
            int iIntValue = 0;
            int iIntValue2 = 0;
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = i2 * 2;
                iIntValue += list.get(i3).intValue();
                iIntValue2 += list.get(i3 + 1).intValue();
            }
            List<Number> listSubList = list.subList(0, 6);
            Number[] numberArr = new Number[6];
            numberArr[0] = list.get(6);
            numberArr[1] = list.get(7);
            numberArr[2] = list.get(8);
            numberArr[3] = list.get(9);
            numberArr[4] = Math.abs(iIntValue) > Math.abs(iIntValue2) ? list.get(10) : Integer.valueOf(-iIntValue);
            numberArr[5] = Math.abs(iIntValue) > Math.abs(iIntValue2) ? Integer.valueOf(-iIntValue2) : list.get(10);
            addCommandList(Arrays.asList(listSubList, Arrays.asList(numberArr)), new CharStringCommand(8));
            return null;
        }
        if ("hstemhm".equals(str)) {
            expandStemHints(clearStack(list, list.size() % 2 != 0), true);
            return null;
        }
        if ("hintmask".equals(str) || "cntrmask".equals(str)) {
            List<Number> listClearStack5 = clearStack(list, list.size() % 2 != 0);
            if (listClearStack5.isEmpty()) {
                return null;
            }
            expandStemHints(listClearStack5, false);
            return null;
        }
        if ("vstemhm".equals(str)) {
            expandStemHints(clearStack(list, list.size() % 2 != 0), false);
            return null;
        }
        if ("rcurveline".equals(str)) {
            if (list.size() < 2) {
                return null;
            }
            addCommandList(split(list.subList(0, list.size() - 2), 6), new CharStringCommand(8));
            addCommand(list.subList(list.size() - 2, list.size()), new CharStringCommand(5));
            return null;
        }
        if ("rlinecurve".equals(str)) {
            if (list.size() < 6) {
                return null;
            }
            addCommandList(split(list.subList(0, list.size() - 6), 2), new CharStringCommand(5));
            addCommand(list.subList(list.size() - 6, list.size()), new CharStringCommand(8));
            return null;
        }
        if ("vvcurveto".equals(str)) {
            drawCurve(list, false);
            return null;
        }
        if ("hhcurveto".equals(str)) {
            drawCurve(list, true);
            return null;
        }
        addCommand(list, charStringCommand);
        return null;
    }

    private void markPath() {
        if (this.pathCount > 0) {
            closeCharString2Path();
        }
        this.pathCount++;
    }

    private static <E> List<List<E>> split(List<E> list, int i2) {
        int size = list.size() / i2;
        ArrayList arrayList = new ArrayList(size);
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 * i2;
            i3++;
            arrayList.add(list.subList(i4, i3 * i2));
        }
        return arrayList;
    }

    public int getGID() {
        return this.gid;
    }

    public List<Object> getType2Sequence() {
        return this.type2sequence;
    }
}
