package com.tom_roush.pdfbox.filter;

import com.tom_roush.fontbox.ttf.GlyfCompositeComp;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class CCITTFaxDecoderStream extends FilterInputStream {
    public static final Node EOL;
    public static final Node FILL;
    public static final int VALUE_EOL = -2000;
    public static final int VALUE_FILL = -1000;
    public static final int VALUE_HMODE = -4000;
    public static final int VALUE_PASSMODE = -3000;
    public static final Tree blackRunTree;
    public static final Tree codeTree;
    public static final Tree eolOnlyTree;
    public static final Tree whiteRunTree;
    public int buffer;
    public int bufferPos;
    private int[] changesCurrentRow;
    private int changesCurrentRowCount;
    private int[] changesReferenceRow;
    private int changesReferenceRowCount;
    private final int columns;
    private int decodedLength;
    private int decodedPos;
    private final byte[] decodedRow;
    private int lastChangingElement;
    private final boolean optionByteAligned;
    private final boolean optionG32D;
    private final boolean optionG3Fill;
    private final boolean optionUncompressed;
    private final int type;
    public static final short[][] BLACK_CODES = {new short[]{2, 3}, new short[]{2, 3}, new short[]{2, 3}, new short[]{3}, new short[]{4, 5}, new short[]{4, 5, 7}, new short[]{4, 7}, new short[]{24}, new short[]{23, 24, 55, 8, 15}, new short[]{23, 24, 40, 55, 103, 104, 108, 8, 12, 13}, new short[]{18, 19, 20, 21, 22, 23, 28, 29, 30, 31, 36, 39, 40, 43, 44, 51, 52, 53, 55, 56, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 200, 201, 202, 203, 204, 205, 210, 211, 212, 213, 214, 215, 218, 219}, new short[]{74, 75, 76, 77, 82, 83, 84, 85, 90, 91, 100, 101, 108, 109, 114, 115, 116, 117, 118, 119}};
    public static final short[][] BLACK_RUN_LENGTHS = {new short[]{3, 2}, new short[]{1, 4}, new short[]{6, 5}, new short[]{7}, new short[]{9, 8}, new short[]{10, 11, 12}, new short[]{13, 14}, new short[]{15}, new short[]{16, 17, 0, 18, 64}, new short[]{24, 25, 23, 22, 19, 20, 21, 1792, 1856, 1920}, new short[]{1984, 2048, 2112, 2176, 2240, 2304, 2368, 2432, 2496, 2560, 52, 55, 56, 59, 60, 320, 384, 448, 53, 54, 50, 51, 44, 45, 46, 47, 57, 58, 61, 256, 48, 49, 62, 63, 30, 31, 32, 33, 40, 41, GlyfCompositeComp.WE_HAVE_A_TWO_BY_TWO, 192, 26, 27, 28, 29, 34, 35, 36, 37, 38, 39, 42, 43}, new short[]{640, 704, 768, 832, 1280, 1344, 1408, 1472, 1536, 1600, 1664, 1728, 512, 576, 896, 960, 1024, 1088, 1152, 1216}};
    public static final short[][] WHITE_CODES = {new short[]{7, 8, 11, 12, 14, 15}, new short[]{18, 19, 20, 27, 7, 8}, new short[]{23, 24, 42, 43, 3, 52, 53, 7, 8}, new short[]{19, 23, 24, 36, 39, 40, 43, 3, 55, 4, 8, 12}, new short[]{18, 19, 20, 21, 22, 23, 26, 27, 2, 36, 37, 40, 41, 42, 43, 44, 45, 3, 50, 51, 52, 53, 54, 55, 4, 74, 75, 5, 82, 83, 84, 85, 88, 89, 90, 91, 100, 101, 103, 104, 10, 11}, new short[]{152, 153, 154, 155, 204, 205, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219}, new short[0], new short[]{8, 12, 13}, new short[]{18, 19, 20, 21, 22, 23, 28, 29, 30, 31}};
    public static final short[][] WHITE_RUN_LENGTHS = {new short[]{2, 3, 4, 5, 6, 7}, new short[]{GlyfCompositeComp.WE_HAVE_A_TWO_BY_TWO, 8, 9, 64, 10, 11}, new short[]{192, 1664, 16, 17, 13, 14, 15, 1, 12}, new short[]{26, 21, 28, 27, 18, 24, 25, 22, 256, 23, 20, 19}, new short[]{33, 34, 35, 36, 37, 38, 31, 32, 29, 53, 54, 39, 40, 41, 42, 43, 44, 30, 61, 62, 63, 0, 320, 384, 45, 59, 60, 46, 49, 50, 51, 52, 55, 56, 57, 58, 448, 512, 640, 576, 47, 48}, new short[]{1472, 1536, 1600, 1728, 704, 768, 832, 896, 960, 1024, 1088, 1152, 1216, 1280, 1344, 1408}, new short[0], new short[]{1792, 1856, 1920}, new short[]{1984, 2048, 2112, 2176, 2240, 2304, 2368, 2432, 2496, 2560}};

    public static final class Node {
        public boolean canBeFill;
        public boolean isLeaf;
        public Node left;
        public Node right;
        public int value;

        private Node() {
            this.canBeFill = false;
            this.isLeaf = false;
        }

        public void set(boolean z, Node node) {
            if (z) {
                this.right = node;
            } else {
                this.left = node;
            }
        }

        public String toString() {
            return "[leaf=" + this.isLeaf + ", value=" + this.value + ", canBeFill=" + this.canBeFill + "]";
        }

        public Node walk(boolean z) {
            return z ? this.right : this.left;
        }
    }

    static {
        Node node = new Node();
        EOL = node;
        node.isLeaf = true;
        node.value = -2000;
        Node node2 = new Node();
        FILL = node2;
        node2.value = -1000;
        node2.left = node2;
        node2.right = node;
        Tree tree = new Tree();
        eolOnlyTree = tree;
        try {
            tree.fill(12, 0, node2);
            tree.fill(12, 1, node);
            blackRunTree = new Tree();
            for (int i2 = 0; i2 < BLACK_CODES.length; i2++) {
                try {
                    int i3 = 0;
                    while (true) {
                        short[][] sArr = BLACK_CODES;
                        if (i3 < sArr[i2].length) {
                            blackRunTree.fill(i2 + 2, sArr[i2][i3], BLACK_RUN_LENGTHS[i2][i3]);
                            i3++;
                        }
                    }
                } catch (IOException e2) {
                    throw new AssertionError(e2);
                }
            }
            Tree tree2 = blackRunTree;
            tree2.fill(12, 0, FILL);
            tree2.fill(12, 1, EOL);
            whiteRunTree = new Tree();
            for (int i4 = 0; i4 < WHITE_CODES.length; i4++) {
                try {
                    int i5 = 0;
                    while (true) {
                        short[][] sArr2 = WHITE_CODES;
                        if (i5 < sArr2[i4].length) {
                            whiteRunTree.fill(i4 + 4, sArr2[i4][i5], WHITE_RUN_LENGTHS[i4][i5]);
                            i5++;
                        }
                    }
                } catch (IOException e3) {
                    throw new AssertionError(e3);
                }
            }
            Tree tree3 = whiteRunTree;
            tree3.fill(12, 0, FILL);
            tree3.fill(12, 1, EOL);
            Tree tree4 = new Tree();
            codeTree = tree4;
            try {
                tree4.fill(4, 1, -3000);
                tree4.fill(3, 1, VALUE_HMODE);
                tree4.fill(1, 1, 0);
                tree4.fill(3, 3, 1);
                tree4.fill(6, 3, 2);
                tree4.fill(7, 3, 3);
                tree4.fill(3, 2, -1);
                tree4.fill(6, 2, -2);
                tree4.fill(7, 2, -3);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }

    public CCITTFaxDecoderStream(InputStream inputStream, int i2, int i3, long j, boolean z) {
        super(inputStream);
        this.lastChangingElement = 0;
        this.buffer = -1;
        this.bufferPos = -1;
        this.columns = i2;
        this.type = i3;
        this.decodedRow = new byte[(i2 + 7) / 8];
        int i4 = i2 + 2;
        this.changesReferenceRow = new int[i4];
        this.changesCurrentRow = new int[i4];
        if (i3 == 2) {
            this.optionByteAligned = z;
            this.optionG32D = false;
            this.optionG3Fill = false;
            this.optionUncompressed = false;
            return;
        }
        if (i3 == 3) {
            this.optionByteAligned = z;
            this.optionG32D = (1 & j) != 0;
            this.optionG3Fill = (4 & j) != 0;
            this.optionUncompressed = (j & 2) != 0;
            return;
        }
        if (i3 != 4) {
            throw new IllegalArgumentException("Illegal parameter: " + i3);
        }
        this.optionByteAligned = z;
        this.optionG32D = false;
        this.optionG3Fill = false;
        this.optionUncompressed = (j & 2) != 0;
    }

    private void decode1D() throws IOException {
        int iDecodeRun = 0;
        this.changesCurrentRowCount = 0;
        boolean z = true;
        do {
            iDecodeRun += z ? decodeRun(whiteRunTree) : decodeRun(blackRunTree);
            int[] iArr = this.changesCurrentRow;
            int i2 = this.changesCurrentRowCount;
            this.changesCurrentRowCount = i2 + 1;
            iArr[i2] = iDecodeRun;
            z = !z;
        } while (iDecodeRun < this.columns);
    }

    private void decode2D() throws IOException {
        int i2;
        int i3;
        this.changesReferenceRowCount = this.changesCurrentRowCount;
        int[] iArr = this.changesCurrentRow;
        this.changesCurrentRow = this.changesReferenceRow;
        this.changesReferenceRow = iArr;
        int iDecodeRun = 0;
        this.changesCurrentRowCount = 0;
        boolean z = true;
        while (iDecodeRun < this.columns) {
            Node nodeWalk = codeTree.root;
            while (true) {
                nodeWalk = nodeWalk.walk(readBit());
                if (nodeWalk != null) {
                    if (nodeWalk.isLeaf) {
                        int i4 = nodeWalk.value;
                        if (i4 == -4000) {
                            int iDecodeRun2 = iDecodeRun + decodeRun(z ? whiteRunTree : blackRunTree);
                            int[] iArr2 = this.changesCurrentRow;
                            int i5 = this.changesCurrentRowCount;
                            this.changesCurrentRowCount = i5 + 1;
                            iArr2[i5] = iDecodeRun2;
                            iDecodeRun = iDecodeRun2 + decodeRun(z ? blackRunTree : whiteRunTree);
                            int[] iArr3 = this.changesCurrentRow;
                            int i6 = this.changesCurrentRowCount;
                            this.changesCurrentRowCount = i6 + 1;
                            iArr3[i6] = iDecodeRun;
                        } else if (i4 != -3000) {
                            int nextChangingElement = getNextChangingElement(iDecodeRun, z);
                            if (nextChangingElement >= this.changesReferenceRowCount || nextChangingElement == -1) {
                                i2 = this.columns;
                                i3 = nodeWalk.value;
                            } else {
                                i2 = this.changesReferenceRow[nextChangingElement];
                                i3 = nodeWalk.value;
                            }
                            iDecodeRun = i2 + i3;
                            int[] iArr4 = this.changesCurrentRow;
                            int i7 = this.changesCurrentRowCount;
                            iArr4[i7] = iDecodeRun;
                            this.changesCurrentRowCount = i7 + 1;
                            z = !z;
                        } else {
                            int nextChangingElement2 = getNextChangingElement(iDecodeRun, z) + 1;
                            iDecodeRun = nextChangingElement2 >= this.changesReferenceRowCount ? this.columns : this.changesReferenceRow[nextChangingElement2];
                        }
                    }
                }
            }
        }
    }

    private void decodeRow() throws IOException {
        int i2;
        int i3 = this.type;
        if (i3 == 2) {
            decodeRowType2();
        } else if (i3 == 3) {
            decodeRowType4();
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("Illegal parameter: " + this.type);
            }
            decodeRowType6();
        }
        this.lastChangingElement = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = true;
        while (true) {
            int i6 = this.changesCurrentRowCount;
            if (i4 > i6) {
                break;
            }
            int i7 = this.columns;
            int i8 = i4 != i6 ? this.changesCurrentRow[i4] : i7;
            if (i8 <= i7) {
                i7 = i8;
            }
            int i9 = i5 / 8;
            while (true) {
                i2 = i5 % 8;
                if (i2 == 0 || i7 - i5 <= 0) {
                    break;
                }
                byte[] bArr = this.decodedRow;
                bArr[i9] = (byte) ((z ? 0 : 1 << (7 - i2)) | bArr[i9]);
                i5++;
            }
            if (i2 == 0) {
                i9 = i5 / 8;
                byte b2 = (byte) (z ? 0 : 255);
                while (i7 - i5 > 7) {
                    this.decodedRow[i9] = b2;
                    i5 += 8;
                    i9++;
                }
            }
            while (i7 - i5 > 0) {
                int i10 = i5 % 8;
                if (i10 == 0) {
                    this.decodedRow[i9] = 0;
                }
                byte[] bArr2 = this.decodedRow;
                bArr2[i9] = (byte) ((z ? 0 : 1 << (7 - i10)) | bArr2[i9]);
                i5++;
            }
            z = !z;
            i4++;
        }
        if (i5 == this.columns) {
            this.decodedLength = (i5 + 7) / 8;
            return;
        }
        throw new IOException("Sum of run-lengths does not equal scan line width: " + i5 + " > " + this.columns);
    }

    private void decodeRowType2() throws IOException {
        if (this.optionByteAligned) {
            resetBuffer();
        }
        decode1D();
    }

    private void decodeRowType4() throws IOException {
        if (this.optionByteAligned) {
            resetBuffer();
        }
        loop0: while (true) {
            Node nodeWalk = eolOnlyTree.root;
            do {
                nodeWalk = nodeWalk.walk(readBit());
                if (nodeWalk == null) {
                    break;
                }
            } while (!nodeWalk.isLeaf);
            if (this.optionG32D || readBit()) {
                decode1D();
            } else {
                decode2D();
                return;
            }
        }
        if (this.optionG32D) {
        }
        decode1D();
    }

    private void decodeRowType6() throws IOException {
        if (this.optionByteAligned) {
            resetBuffer();
        }
        decode2D();
    }

    private int decodeRun(Tree tree) throws IOException {
        Node nodeWalk = tree.root;
        int i2 = 0;
        while (true) {
            nodeWalk = nodeWalk.walk(readBit());
            if (nodeWalk == null) {
                throw new IOException("Unknown code in Huffman RLE stream");
            }
            if (nodeWalk.isLeaf) {
                int i3 = nodeWalk.value;
                i2 += i3;
                if (i3 < 64) {
                    return i3 >= 0 ? i2 : this.columns;
                }
                nodeWalk = tree.root;
            }
        }
    }

    private void fetch() throws IOException {
        if (this.decodedPos >= this.decodedLength) {
            this.decodedLength = 0;
            try {
                decodeRow();
            } catch (EOFException e2) {
                if (this.decodedLength != 0) {
                    throw e2;
                }
                this.decodedLength = -1;
            } catch (ArrayIndexOutOfBoundsException e3) {
                throw new IOException("Malformed CCITT stream", e3);
            }
            this.decodedPos = 0;
        }
    }

    private int getNextChangingElement(int i2, boolean z) {
        int i3 = (this.lastChangingElement & (-2)) + (!z ? 1 : 0);
        if (i3 > 2) {
            i3 -= 2;
        }
        if (i2 == 0) {
            return i3;
        }
        while (i3 < this.changesReferenceRowCount) {
            if (i2 < this.changesReferenceRow[i3]) {
                this.lastChangingElement = i3;
                return i3;
            }
            i3 += 2;
        }
        return -1;
    }

    private boolean readBit() throws IOException {
        int i2 = this.bufferPos;
        if (i2 < 0 || i2 > 7) {
            int i3 = ((FilterInputStream) this).in.read();
            this.buffer = i3;
            if (i3 == -1) {
                throw new EOFException("Unexpected end of Huffman RLE stream");
            }
            this.bufferPos = 0;
        }
        int i4 = this.buffer;
        boolean z = (i4 & 128) != 0;
        this.buffer = i4 << 1;
        this.bufferPos++;
        return z;
    }

    private void resetBuffer() {
        this.bufferPos = -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = this.decodedLength;
        if (i2 < 0) {
            return 0;
        }
        if (this.decodedPos >= i2) {
            fetch();
            if (this.decodedLength < 0) {
                return 0;
            }
        }
        byte[] bArr = this.decodedRow;
        int i3 = this.decodedPos;
        this.decodedPos = i3 + 1;
        return bArr[i3] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        int i2 = this.decodedLength;
        if (i2 < 0) {
            return -1L;
        }
        if (this.decodedPos >= i2) {
            fetch();
            if (this.decodedLength < 0) {
                return -1L;
            }
        }
        int iMin = (int) Math.min(this.decodedLength - this.decodedPos, j);
        this.decodedPos += iMin;
        return iMin;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.decodedLength;
        if (i4 < 0) {
            Arrays.fill(bArr, i2, i2 + i3, (byte) 0);
            return i3;
        }
        if (this.decodedPos >= i4) {
            fetch();
            if (this.decodedLength < 0) {
                Arrays.fill(bArr, i2, i2 + i3, (byte) 0);
                return i3;
            }
        }
        int iMin = Math.min(this.decodedLength - this.decodedPos, i3);
        System.arraycopy(this.decodedRow, this.decodedPos, bArr, i2, iMin);
        this.decodedPos += iMin;
        return iMin;
    }

    public static final class Tree {
        public final Node root;

        private Tree() {
            this.root = new Node();
        }

        public void fill(int i2, int i3, int i4) throws IOException {
            Node node = this.root;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i2 - 1;
                boolean z = ((i3 >> (i6 - i5)) & 1) == 1;
                Node nodeWalk = node.walk(z);
                if (nodeWalk == null) {
                    nodeWalk = new Node();
                    if (i5 == i6) {
                        nodeWalk.value = i4;
                        nodeWalk.isLeaf = true;
                    }
                    if (i3 == 0) {
                        nodeWalk.canBeFill = true;
                    }
                    node.set(z, nodeWalk);
                } else if (nodeWalk.isLeaf) {
                    throw new IOException("node is leaf, no other following");
                }
                node = nodeWalk;
            }
        }

        public void fill(int i2, int i3, Node node) throws IOException {
            Node node2 = this.root;
            int i4 = 0;
            while (i4 < i2) {
                int i5 = i2 - 1;
                boolean z = ((i3 >> (i5 - i4)) & 1) == 1;
                Node nodeWalk = node2.walk(z);
                if (nodeWalk == null) {
                    Node node3 = i4 == i5 ? node : new Node();
                    if (i3 == 0) {
                        node3.canBeFill = true;
                    }
                    node2.set(z, node3);
                    node2 = node3;
                } else {
                    if (nodeWalk.isLeaf) {
                        throw new IOException("node is leaf, no other following");
                    }
                    node2 = nodeWalk;
                }
                i4++;
            }
        }
    }
}
