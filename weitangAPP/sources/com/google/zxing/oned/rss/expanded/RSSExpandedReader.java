package com.google.zxing.oned.rss.expanded;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import com.qq.e.comm.adevent.AdEventType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int[][] FINDER_PATTERN_SEQUENCES;
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int LONGEST_SEQUENCE_SIZE;
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, AdEventType.VIDEO_PAUSE};
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, BaseTransientBottomBar.ANIMATION_FADE_DURATION, 118, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, 7, 21, 63}, new int[]{189, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION, 13, 39, 117, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, AdEventType.VIDEO_INIT, AdEventType.VIDEO_STOP}, new int[]{193, 157, 49, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, 19, 57, 171, 91}, new int[]{62, 186, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 197, 169, 85, 44, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID}, new int[]{185, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 188, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, AdEventType.VIDEO_RESUME, 187, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL, 206, 196, TTAdConstant.IMAGE_MODE_LIVE}, new int[]{76, 17, 51, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FUNNEL_TYPE, 37, 111, 122, 155}, new int[]{43, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA, 176, 106, 107, 110, 119, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH}, new int[]{16, 48, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, 10, 30, 90, 59, 177}, new int[]{109, 116, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 200, 178, 112, 125, 164}, new int[]{70, AdEventType.VIDEO_READY, AdEventType.VIDEO_CLICKED, AdEventType.VIDEO_START, 184, 130, 179, 115}, new int[]{TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, 191, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_QUICK_APP_MODEL, 31, 93, 68, AdEventType.VIDEO_PAUSE, 190}, new int[]{TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, AdEventType.VIDEO_ERROR, 199, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION}, new int[]{103, 98, 83, 38, 114, 131, 182, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_LOG_EXTRA, 194, 160, 58, 174, 100, 89}};
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final int[] startEnd = new int[2];
    private final int[] currentSequence = new int[LONGEST_SEQUENCE_SIZE];

    static {
        int[][] iArr = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
        FINDER_PATTERN_SEQUENCES = iArr;
        LONGEST_SEQUENCE_SIZE = iArr[iArr.length - 1].length;
    }

    private void adjustOddEvenCounts(int i2) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        int iCount = AbstractRSSReader.count(getOddCounts());
        int iCount2 = AbstractRSSReader.count(getEvenCounts());
        int i3 = (iCount + iCount2) - i2;
        boolean z4 = true;
        boolean z5 = (iCount & 1) == 1;
        boolean z6 = (iCount2 & 1) == 0;
        if (iCount > 13) {
            z = false;
            z2 = true;
        } else {
            z = iCount < 4;
            z2 = false;
        }
        if (iCount2 > 13) {
            z3 = true;
        } else {
            z = iCount2 < 4;
            z3 = false;
        }
        if (i3 == 1) {
            if (z5) {
                if (z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z4 = z;
                z2 = true;
            } else {
                if (!z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z4 = z;
                z3 = true;
            }
        } else if (i3 == -1) {
            if (z5) {
                if (z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else {
                if (!z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z4 = z;
                z = true;
            }
        } else {
            if (i3 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (z5) {
                if (!z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (iCount >= iCount2) {
                    z4 = z;
                    z = true;
                    z2 = true;
                }
                z3 = true;
            } else {
                if (z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z4 = z;
            }
        }
        if (z4) {
            if (z2) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z2) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z) {
            if (z3) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z3) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private boolean checkChecksum() {
        ExpandedPair expandedPair = this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        int checksumPortion = expandedPair.getRightChar().getChecksumPortion();
        int i2 = 2;
        for (int i3 = 1; i3 < this.pairs.size(); i3++) {
            ExpandedPair expandedPair2 = this.pairs.get(i3);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            i2++;
            DataCharacter rightChar = expandedPair2.getRightChar();
            if (rightChar != null) {
                checksumPortion += rightChar.getChecksumPortion();
                i2++;
            }
        }
        return ((i2 + (-4)) * AdEventType.VIDEO_LOADING) + (checksumPortion % AdEventType.VIDEO_LOADING) == leftChar.getValue();
    }

    private boolean checkPairSequence(List<ExpandedPair> list, FinderPattern finderPattern) throws NotFoundException {
        boolean z;
        int size = list.size() + 1;
        if (size > this.currentSequence.length) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.currentSequence[i2] = list.get(i2).getFinderPattern().getValue();
        }
        this.currentSequence[size - 1] = finderPattern.getValue();
        for (int[] iArr : FINDER_PATTERN_SEQUENCES) {
            if (iArr.length >= size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        z = true;
                        break;
                    }
                    if (this.currentSequence[i3] != iArr[i3]) {
                        z = false;
                        break;
                    }
                    i3++;
                }
                if (z) {
                    return size == iArr.length;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static Result constructResult(List<ExpandedPair> list) throws NotFoundException {
        String information = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
        return new Result(information, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i2) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i2 < 0) {
            i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
        }
        boolean z = list.size() % 2 != 0;
        boolean z2 = false;
        while (i2 < size) {
            z2 = !bitArray.get(i2);
            if (!z2) {
                break;
            } else {
                i2++;
            }
        }
        boolean z3 = z2;
        int i3 = 0;
        int i4 = i2;
        while (i2 < size) {
            if (bitArray.get(i2) ^ z3) {
                decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = i4;
                        iArr[1] = i2;
                        return;
                    }
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i4 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                decodeFinderCounters[i3] = 1;
                z3 = !z3;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getNextSecondBar(BitArray bitArray, int i2) {
        return bitArray.get(i2) ? bitArray.getNextSet(bitArray.getNextUnset(i2)) : bitArray.getNextUnset(bitArray.getNextSet(i2));
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        return (finderPattern.getValue() == 0 && z && z2) ? false : true;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.startEnd[0] - 1;
            while (i6 >= 0 && !bitArray.get(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.startEnd;
            i5 = iArr[0] - i7;
            i3 = iArr[1];
            i4 = i7;
        } else {
            int[] iArr2 = this.startEnd;
            int i8 = iArr2[0];
            int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i3 = nextUnset;
            i4 = i8;
            i5 = nextUnset - this.startEnd[1];
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i5;
        try {
            return new FinderPattern(AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i4, i3}, i4, i3, i2);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    public DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z2) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            int i2 = 0;
            for (int length = dataCharacterCounters.length - 1; i2 < length; length--) {
                int i3 = dataCharacterCounters[i2];
                dataCharacterCounters[i2] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i3;
                i2++;
            }
        }
        float fCount = AbstractRSSReader.count(dataCharacterCounters) / 17;
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i4 = 0; i4 < dataCharacterCounters.length; i4++) {
            float f2 = (dataCharacterCounters[i4] * 1.0f) / fCount;
            int i5 = (int) (0.5f + f2);
            if (i5 < 1) {
                i5 = 1;
            } else if (i5 > 8) {
                i5 = 8;
            }
            int i6 = i4 >> 1;
            if ((i4 & 1) == 0) {
                oddCounts[i6] = i5;
                oddRoundingErrors[i6] = f2 - i5;
            } else {
                evenCounts[i6] = i5;
                evenRoundingErrors[i6] = f2 - i5;
            }
        }
        adjustOddEvenCounts(17);
        int value = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i7 = 0;
        int i8 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i7 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
            }
            i8 += oddCounts[length2];
        }
        int i9 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i9 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
            }
            int i10 = evenCounts[length3];
        }
        int i11 = i7 + i9;
        if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = (13 - i8) / 2;
        int i13 = SYMBOL_WIDEST[i12];
        return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i13, true) * EVEN_TOTAL_SUBSET[i12]) + RSSUtils.getRSSvalue(evenCounts, 9 - i13, false) + GSUM[i12], i11);
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        reset();
        decodeRow2pairs(i2, bitArray);
        return constructResult(this.pairs);
    }

    public List<ExpandedPair> decodeRow2pairs(int i2, BitArray bitArray) throws NotFoundException {
        while (true) {
            ExpandedPair expandedPairRetrieveNextPair = retrieveNextPair(bitArray, this.pairs, i2);
            this.pairs.add(expandedPairRetrieveNextPair);
            if (expandedPairRetrieveNextPair.mayBeLast()) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                if (expandedPairRetrieveNextPair.mustBeLast()) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.pairs.clear();
    }

    public ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i2) throws NotFoundException {
        FinderPattern foundFinderPattern;
        DataCharacter dataCharacterDecodeDataCharacter;
        boolean z = list.size() % 2 == 0;
        int nextSecondBar = -1;
        boolean z2 = true;
        do {
            findNextPair(bitArray, list, nextSecondBar);
            foundFinderPattern = parseFoundFinderPattern(bitArray, i2, z);
            if (foundFinderPattern == null) {
                nextSecondBar = getNextSecondBar(bitArray, this.startEnd[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        boolean zCheckPairSequence = checkPairSequence(list, foundFinderPattern);
        DataCharacter dataCharacterDecodeDataCharacter2 = decodeDataCharacter(bitArray, foundFinderPattern, z, true);
        try {
            dataCharacterDecodeDataCharacter = decodeDataCharacter(bitArray, foundFinderPattern, z, false);
        } catch (NotFoundException e2) {
            if (!zCheckPairSequence) {
                throw e2;
            }
            dataCharacterDecodeDataCharacter = null;
        }
        return new ExpandedPair(dataCharacterDecodeDataCharacter2, dataCharacterDecodeDataCharacter, foundFinderPattern, zCheckPairSequence);
    }
}
