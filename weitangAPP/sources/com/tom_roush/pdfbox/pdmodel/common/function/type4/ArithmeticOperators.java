package com.tom_roush.pdfbox.pdmodel.common.function.type4;

import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public class ArithmeticOperators {

    public static class Abs implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Number numberPopNumber = executionContext.popNumber();
            if (numberPopNumber instanceof Integer) {
                executionContext.getStack().push(Integer.valueOf(Math.abs(numberPopNumber.intValue())));
            } else {
                executionContext.getStack().push(Float.valueOf(Math.abs(numberPopNumber.floatValue())));
            }
        }
    }

    public static class Add implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Number numberPopNumber = executionContext.popNumber();
            Number numberPopNumber2 = executionContext.popNumber();
            if (!(numberPopNumber2 instanceof Integer) || !(numberPopNumber instanceof Integer)) {
                executionContext.getStack().push(Float.valueOf(numberPopNumber2.floatValue() + numberPopNumber.floatValue()));
                return;
            }
            long jLongValue = numberPopNumber2.longValue() + numberPopNumber.longValue();
            if (jLongValue < -2147483648L || jLongValue > 2147483647L) {
                executionContext.getStack().push(Float.valueOf(jLongValue));
            } else {
                executionContext.getStack().push(Integer.valueOf((int) jLongValue));
            }
        }
    }

    public static class Atan implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            float degrees = ((float) Math.toDegrees((float) Math.atan2(executionContext.popReal(), executionContext.popReal()))) % 360.0f;
            if (degrees < 0.0f) {
                degrees += 360.0f;
            }
            executionContext.getStack().push(Float.valueOf(degrees));
        }
    }

    public static class Ceiling implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Number numberPopNumber = executionContext.popNumber();
            if (numberPopNumber instanceof Integer) {
                executionContext.getStack().push(numberPopNumber);
            } else {
                executionContext.getStack().push(Float.valueOf((float) Math.ceil(numberPopNumber.doubleValue())));
            }
        }
    }

    public static class Cos implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf((float) Math.cos(Math.toRadians(executionContext.popReal()))));
        }
    }

    public static class Cvi implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Integer.valueOf(executionContext.popNumber().intValue()));
        }
    }

    public static class Cvr implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf(executionContext.popNumber().floatValue()));
        }
    }

    public static class Div implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Number numberPopNumber = executionContext.popNumber();
            executionContext.getStack().push(Float.valueOf(executionContext.popNumber().floatValue() / numberPopNumber.floatValue()));
        }
    }

    public static class Exp implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf((float) Math.pow(executionContext.popNumber().doubleValue(), executionContext.popNumber().doubleValue())));
        }
    }

    public static class Floor implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Number numberPopNumber = executionContext.popNumber();
            if (numberPopNumber instanceof Integer) {
                executionContext.getStack().push(numberPopNumber);
            } else {
                executionContext.getStack().push(Float.valueOf((float) Math.floor(numberPopNumber.doubleValue())));
            }
        }
    }

    public static class IDiv implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            int iPopInt = executionContext.popInt();
            executionContext.getStack().push(Integer.valueOf(executionContext.popInt() / iPopInt));
        }
    }

    public static class Ln implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf((float) Math.log(executionContext.popNumber().doubleValue())));
        }
    }

    public static class Log implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf((float) Math.log10(executionContext.popNumber().doubleValue())));
        }
    }

    public static class Mod implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            int iPopInt = executionContext.popInt();
            executionContext.getStack().push(Integer.valueOf(executionContext.popInt() % iPopInt));
        }
    }

    public static class Mul implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Number numberPopNumber = executionContext.popNumber();
            Number numberPopNumber2 = executionContext.popNumber();
            if (!(numberPopNumber2 instanceof Integer) || !(numberPopNumber instanceof Integer)) {
                executionContext.getStack().push(Float.valueOf((float) (numberPopNumber2.doubleValue() * numberPopNumber.doubleValue())));
                return;
            }
            long jLongValue = numberPopNumber2.longValue() * numberPopNumber.longValue();
            if (jLongValue < -2147483648L || jLongValue > 2147483647L) {
                executionContext.getStack().push(Float.valueOf(jLongValue));
            } else {
                executionContext.getStack().push(Integer.valueOf((int) jLongValue));
            }
        }
    }

    public static class Neg implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Number numberPopNumber = executionContext.popNumber();
            if (!(numberPopNumber instanceof Integer)) {
                executionContext.getStack().push(Float.valueOf(-numberPopNumber.floatValue()));
            } else if (numberPopNumber.intValue() == Integer.MIN_VALUE) {
                executionContext.getStack().push(Float.valueOf(-numberPopNumber.floatValue()));
            } else {
                executionContext.getStack().push(Integer.valueOf(-numberPopNumber.intValue()));
            }
        }
    }

    public static class Round implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Number numberPopNumber = executionContext.popNumber();
            if (numberPopNumber instanceof Integer) {
                executionContext.getStack().push(Integer.valueOf(numberPopNumber.intValue()));
            } else {
                executionContext.getStack().push(Float.valueOf(Math.round(numberPopNumber.doubleValue())));
            }
        }
    }

    public static class Sin implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf((float) Math.sin(Math.toRadians(executionContext.popReal()))));
        }
    }

    public static class Sqrt implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            float fPopReal = executionContext.popReal();
            if (fPopReal < 0.0f) {
                throw new IllegalArgumentException("argument must be nonnegative");
            }
            executionContext.getStack().push(Float.valueOf((float) Math.sqrt(fPopReal)));
        }
    }

    public static class Sub implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            Number numberPopNumber = executionContext.popNumber();
            Number numberPopNumber2 = executionContext.popNumber();
            if (!(numberPopNumber2 instanceof Integer) || !(numberPopNumber instanceof Integer)) {
                stack.push(Float.valueOf(numberPopNumber2.floatValue() - numberPopNumber.floatValue()));
                return;
            }
            long jLongValue = numberPopNumber2.longValue() - numberPopNumber.longValue();
            if (jLongValue < -2147483648L || jLongValue > 2147483647L) {
                stack.push(Float.valueOf(jLongValue));
            } else {
                stack.push(Integer.valueOf((int) jLongValue));
            }
        }
    }

    public static class Truncate implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Number numberPopNumber = executionContext.popNumber();
            if (numberPopNumber instanceof Integer) {
                executionContext.getStack().push(Integer.valueOf(numberPopNumber.intValue()));
            } else {
                executionContext.getStack().push(Float.valueOf((int) numberPopNumber.floatValue()));
            }
        }
    }

    private ArithmeticOperators() {
    }
}
