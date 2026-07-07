package c.e.b.c.d;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class i extends c {
    public static final int FIRST_ROOM_TYPE = 10;
    public static final int FOOD_FEE_TYPE = 18;
    public static final int H5_FEE_TYPE = 20;
    public static final int INCREMENT_FEE_TYPE = 17;
    public static final int KEEP_RENT_ROOM_TYPE = 12;
    public static final int ORDER_TYPE = 21;
    public static final int PRE_ORDER_ROOM_TYPE = 16;
    public static final int PRODUCT_FEE_TYPE = 19;
    public static final int RECHARGE_ELECTRIC_TYPE = 5;
    public static final int RECHARGE_WALLET_TYPE = 7;
    public static final int RECHARGE_WATER_TYPE = 4;
    private String extJson;
    private boolean hasRentBill;
    private boolean isBill;
    private boolean isRetryPay;
    private int lateDay;
    private BigDecimal lateFee;
    private String payCode;
    private String price;
    private String primaryKey;
    private int resStrId;
    private boolean srcToH5;
    private String title;
    private int type;

    public String getExtJson() {
        return this.extJson;
    }

    public int getLateDay() {
        return this.lateDay;
    }

    public BigDecimal getLateFee() {
        return this.lateFee;
    }

    public String getPayCode() {
        return this.payCode;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public int getResStrId() {
        return this.resStrId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean isBill() {
        return this.isBill;
    }

    public boolean isHasRentBill() {
        return this.hasRentBill;
    }

    public boolean isRetryPay() {
        return this.isRetryPay;
    }

    public boolean isSrcToH5() {
        return this.srcToH5;
    }

    public void setBill(boolean z) {
        this.isBill = z;
    }

    public void setExtJson(String str) {
        this.extJson = str;
    }

    public void setHasRentBill(boolean z) {
        this.hasRentBill = z;
    }

    public void setLateDay(int i2) {
        this.lateDay = i2;
    }

    public void setLateFee(BigDecimal bigDecimal) {
        this.lateFee = bigDecimal;
    }

    public void setPayCode(String str) {
        this.payCode = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setResStrId(int i2) {
        this.resStrId = i2;
    }

    public void setRetryPay(boolean z) {
        this.isRetryPay = z;
    }

    public void setSrcToH5(boolean z) {
        this.srcToH5 = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
