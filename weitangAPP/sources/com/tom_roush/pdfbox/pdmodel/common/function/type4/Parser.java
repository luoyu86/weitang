package com.tom_roush.pdfbox.pdmodel.common.function.type4;

/* JADX INFO: loaded from: classes2.dex */
public final class Parser {

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$tom_roush$pdfbox$pdmodel$common$function$type4$Parser$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$tom_roush$pdfbox$pdmodel$common$function$type4$Parser$State = iArr;
            try {
                iArr[State.NEWLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tom_roush$pdfbox$pdmodel$common$function$type4$Parser$State[State.WHITESPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tom_roush$pdfbox$pdmodel$common$function$type4$Parser$State[State.COMMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static abstract class AbstractSyntaxHandler implements SyntaxHandler {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser.SyntaxHandler
        public void comment(CharSequence charSequence) {
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser.SyntaxHandler
        public void newLine(CharSequence charSequence) {
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser.SyntaxHandler
        public void whitespace(CharSequence charSequence) {
        }
    }

    public enum State {
        NEWLINE,
        WHITESPACE,
        COMMENT,
        TOKEN
    }

    public interface SyntaxHandler {
        void comment(CharSequence charSequence);

        void newLine(CharSequence charSequence);

        void token(CharSequence charSequence);

        void whitespace(CharSequence charSequence);
    }

    public static final class Tokenizer {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final char CR = '\r';
        private static final char EOT = 4;
        private static final char FF = '\f';
        private static final char LF = '\n';
        private static final char NUL = 0;
        private static final char SPACE = ' ';
        private static final char TAB = '\t';
        private final StringBuilder buffer;
        private final SyntaxHandler handler;
        private int index;
        private final CharSequence input;
        private State state;

        public /* synthetic */ Tokenizer(CharSequence charSequence, SyntaxHandler syntaxHandler, AnonymousClass1 anonymousClass1) {
            this(charSequence, syntaxHandler);
        }

        private char currentChar() {
            return this.input.charAt(this.index);
        }

        private boolean hasMore() {
            return this.index < this.input.length();
        }

        private char nextChar() {
            this.index++;
            return !hasMore() ? EOT : currentChar();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser.State nextState() {
            /*
                r2 = this;
                char r0 = r2.currentChar()
                if (r0 == 0) goto L2d
                r1 = 32
                if (r0 == r1) goto L2d
                r1 = 37
                if (r0 == r1) goto L28
                r1 = 9
                if (r0 == r1) goto L2d
                r1 = 10
                if (r0 == r1) goto L23
                r1 = 12
                if (r0 == r1) goto L23
                r1 = 13
                if (r0 == r1) goto L23
                com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser$State r0 = com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser.State.TOKEN
                r2.state = r0
                goto L31
            L23:
                com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser$State r0 = com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser.State.NEWLINE
                r2.state = r0
                goto L31
            L28:
                com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser$State r0 = com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser.State.COMMENT
                r2.state = r0
                goto L31
            L2d:
                com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser$State r0 = com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser.State.WHITESPACE
                r2.state = r0
            L31:
                com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser$State r0 = r2.state
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer.nextState():com.tom_roush.pdfbox.pdmodel.common.function.type4.Parser$State");
        }

        private char peek() {
            return this.index < this.input.length() + (-1) ? this.input.charAt(this.index + 1) : EOT;
        }

        private void scanComment() {
            char cNextChar;
            this.buffer.append(currentChar());
            while (hasMore() && (cNextChar = nextChar()) != '\n' && cNextChar != '\f' && cNextChar != '\r') {
                this.buffer.append(cNextChar);
            }
            this.handler.comment(this.buffer);
        }

        private void scanNewLine() {
            char cCurrentChar = currentChar();
            this.buffer.append(cCurrentChar);
            if (cCurrentChar == '\r' && peek() == '\n') {
                this.buffer.append(nextChar());
            }
            this.handler.newLine(this.buffer);
            nextChar();
        }

        private void scanToken() {
            char cNextChar;
            char cCurrentChar = currentChar();
            this.buffer.append(cCurrentChar);
            if (cCurrentChar == '{' || cCurrentChar == '}') {
                this.handler.token(this.buffer);
                nextChar();
                return;
            }
            while (hasMore() && (cNextChar = nextChar()) != 0 && cNextChar != 4 && cNextChar != ' ' && cNextChar != '{' && cNextChar != '}' && cNextChar != '\t' && cNextChar != '\n' && cNextChar != '\f' && cNextChar != '\r') {
                this.buffer.append(cNextChar);
            }
            this.handler.token(this.buffer);
        }

        private void scanWhitespace() {
            char cNextChar;
            this.buffer.append(currentChar());
            while (hasMore() && ((cNextChar = nextChar()) == 0 || cNextChar == '\t' || cNextChar == ' ')) {
                this.buffer.append(cNextChar);
            }
            this.handler.whitespace(this.buffer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tokenize() {
            while (hasMore()) {
                this.buffer.setLength(0);
                nextState();
                int i2 = AnonymousClass1.$SwitchMap$com$tom_roush$pdfbox$pdmodel$common$function$type4$Parser$State[this.state.ordinal()];
                if (i2 == 1) {
                    scanNewLine();
                } else if (i2 == 2) {
                    scanWhitespace();
                } else if (i2 != 3) {
                    scanToken();
                } else {
                    scanComment();
                }
            }
        }

        private Tokenizer(CharSequence charSequence, SyntaxHandler syntaxHandler) {
            this.state = State.WHITESPACE;
            this.buffer = new StringBuilder();
            this.input = charSequence;
            this.handler = syntaxHandler;
        }
    }

    private Parser() {
    }

    public static void parse(CharSequence charSequence, SyntaxHandler syntaxHandler) {
        new Tokenizer(charSequence, syntaxHandler, null).tokenize();
    }
}
