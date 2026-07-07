package com.tom_roush.pdfbox.pdmodel.font.encoding;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.chinavisionary.microtang.life.vo.SubmitLifeOrderVo;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.qq.e.comm.adevent.AdEventType;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import com.tom_roush.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

/* JADX INFO: loaded from: classes2.dex */
public class StandardEncoding extends Encoding {
    private static final Object[][] STANDARD_ENCODING_TABLE = {new Object[]{65, "A"}, new Object[]{Integer.valueOf(HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION), "AE"}, new Object[]{66, "B"}, new Object[]{67, "C"}, new Object[]{68, "D"}, new Object[]{69, "E"}, new Object[]{70, "F"}, new Object[]{71, OperatorName.STROKING_COLOR_GRAY}, new Object[]{72, StandardStructureTypes.H}, new Object[]{73, "I"}, new Object[]{74, OperatorName.SET_LINE_CAPSTYLE}, new Object[]{75, OperatorName.STROKING_COLOR_CMYK}, new Object[]{76, "L"}, new Object[]{232, "Lslash"}, new Object[]{77, OperatorName.SET_LINE_MITERLIMIT}, new Object[]{78, "N"}, new Object[]{79, PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE}, new Object[]{234, "OE"}, new Object[]{Integer.valueOf(SubmitLifeOrderVo.ITEM_TYPE_INFO), "Oslash"}, new Object[]{80, "P"}, new Object[]{81, OperatorName.RESTORE}, new Object[]{82, "R"}, new Object[]{83, "S"}, new Object[]{84, PDNumberFormatDictionary.FRACTIONAL_DISPLAY_TRUNCATE}, new Object[]{85, PDBorderStyleDictionary.STYLE_UNDERLINE}, new Object[]{86, "V"}, new Object[]{87, "W"}, new Object[]{88, "X"}, new Object[]{89, "Y"}, new Object[]{90, "Z"}, new Object[]{97, PDPageLabelRange.STYLE_LETTERS_LOWER}, new Object[]{194, "acute"}, new Object[]{Integer.valueOf(SubmitLifeOrderVo.ITEM_TYPE_CB), "ae"}, new Object[]{38, "ampersand"}, new Object[]{94, "asciicircum"}, new Object[]{126, "asciitilde"}, new Object[]{42, "asterisk"}, new Object[]{64, "at"}, new Object[]{98, OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE}, new Object[]{92, "backslash"}, new Object[]{Integer.valueOf(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH), "bar"}, new Object[]{123, "braceleft"}, new Object[]{125, "braceright"}, new Object[]{91, "bracketleft"}, new Object[]{93, "bracketright"}, new Object[]{198, "breve"}, new Object[]{183, "bullet"}, new Object[]{99, OperatorName.CURVE_TO}, new Object[]{Integer.valueOf(AdEventType.VIDEO_ERROR), "caron"}, new Object[]{Integer.valueOf(AdEventType.VIDEO_RESUME), "cedilla"}, new Object[]{162, "cent"}, new Object[]{195, "circumflex"}, new Object[]{58, "colon"}, new Object[]{44, "comma"}, new Object[]{168, "currency"}, new Object[]{100, OperatorName.SET_LINE_DASHPATTERN}, new Object[]{178, "dagger"}, new Object[]{179, "daggerdbl"}, new Object[]{200, "dieresis"}, new Object[]{36, "dollar"}, new Object[]{199, "dotaccent"}, new Object[]{Integer.valueOf(SubmitLifeOrderVo.ITEM_TYPE_EDT), "dotlessi"}, new Object[]{101, "e"}, new Object[]{56, "eight"}, new Object[]{188, "ellipsis"}, new Object[]{Integer.valueOf(AdEventType.VIDEO_CLICKED), "emdash"}, new Object[]{177, "endash"}, new Object[]{61, "equal"}, new Object[]{33, "exclam"}, new Object[]{161, "exclamdown"}, new Object[]{102, OperatorName.FILL_NON_ZERO}, new Object[]{174, "fi"}, new Object[]{53, "five"}, new Object[]{Integer.valueOf(HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION), "fl"}, new Object[]{Integer.valueOf(TTAdConstant.IMAGE_MODE_LIVE), "florin"}, new Object[]{52, "four"}, new Object[]{164, "fraction"}, new Object[]{103, OperatorName.NON_STROKING_GRAY}, new Object[]{251, "germandbls"}, new Object[]{193, "grave"}, new Object[]{62, "greater"}, new Object[]{171, "guillemotleft"}, new Object[]{187, "guillemotright"}, new Object[]{172, "guilsinglleft"}, new Object[]{173, "guilsinglright"}, new Object[]{104, OperatorName.CLOSE_PATH}, new Object[]{Integer.valueOf(AdEventType.VIDEO_STOP), "hungarumlaut"}, new Object[]{45, "hyphen"}, new Object[]{105, OperatorName.SET_FLATNESS}, new Object[]{106, OperatorName.SET_LINE_JOINSTYLE}, new Object[]{107, OperatorName.NON_STROKING_CMYK}, new Object[]{108, OperatorName.LINE_TO}, new Object[]{60, "less"}, new Object[]{248, "lslash"}, new Object[]{109, OperatorName.MOVE_TO}, new Object[]{197, "macron"}, new Object[]{110, OperatorName.ENDPATH}, new Object[]{57, "nine"}, new Object[]{35, "numbersign"}, new Object[]{111, "o"}, new Object[]{250, "oe"}, new Object[]{206, "ogonek"}, new Object[]{49, "one"}, new Object[]{227, "ordfeminine"}, new Object[]{235, "ordmasculine"}, new Object[]{249, "oslash"}, new Object[]{112, "p"}, new Object[]{182, "paragraph"}, new Object[]{40, "parenleft"}, new Object[]{41, "parenright"}, new Object[]{37, "percent"}, new Object[]{46, "period"}, new Object[]{Integer.valueOf(BaseTransientBottomBar.ANIMATION_FADE_DURATION), "periodcentered"}, new Object[]{189, "perthousand"}, new Object[]{43, "plus"}, new Object[]{113, OperatorName.SAVE}, new Object[]{63, "question"}, new Object[]{191, "questiondown"}, new Object[]{34, "quotedbl"}, new Object[]{185, "quotedblbase"}, new Object[]{170, "quotedblleft"}, new Object[]{186, "quotedblright"}, new Object[]{96, "quoteleft"}, new Object[]{39, "quoteright"}, new Object[]{184, "quotesinglbase"}, new Object[]{169, "quotesingle"}, new Object[]{114, PDPageLabelRange.STYLE_ROMAN_LOWER}, new Object[]{Integer.valueOf(AdEventType.VIDEO_START), "ring"}, new Object[]{115, OperatorName.CLOSE_AND_STROKE}, new Object[]{167, "section"}, new Object[]{59, "semicolon"}, new Object[]{55, "seven"}, new Object[]{54, "six"}, new Object[]{47, "slash"}, new Object[]{32, "space"}, new Object[]{163, "sterling"}, new Object[]{116, DispatchConstants.TIMESTAMP}, new Object[]{51, "three"}, new Object[]{196, "tilde"}, new Object[]{50, "two"}, new Object[]{117, "u"}, new Object[]{95, "underscore"}, new Object[]{118, "v"}, new Object[]{119, OperatorName.SET_LINE_WIDTH}, new Object[]{120, "x"}, new Object[]{Integer.valueOf(TTDownloadField.CALL_DOWNLOAD_MODEL_DISTINCT_DIR), OperatorName.CURVE_TO_REPLICATE_FINAL_POINT}, new Object[]{165, "yen"}, new Object[]{122, "z"}, new Object[]{48, "zero"}};
    public static final StandardEncoding INSTANCE = new StandardEncoding();

    public StandardEncoding() {
        for (Object[] objArr : STANDARD_ENCODING_TABLE) {
            add(((Integer) objArr[0]).intValue(), objArr[1].toString());
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSBase getCOSObject() {
        return COSName.STANDARD_ENCODING;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.encoding.Encoding
    public String getEncodingName() {
        return "StandardEncoding";
    }
}
