package c.e.b.c.d;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    private static final String PAY_BILL = "bill";
    private static final String PAY_FIRST_BILL = "firstBill";
    private static final String PAY_ORDER_BILL = "order";
    private static final String PAY_RENT_BILL = "rentBill";
    private static final String PAY_RESERVE_BILL = "reserve";
    private String primaryKey;
    private String type = PAY_BILL;

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getType() {
        return this.type;
    }

    public boolean isPayBill() {
        return PAY_BILL.equals(this.type);
    }

    public boolean isPayFirstBill() {
        return PAY_FIRST_BILL.equals(this.type);
    }

    public boolean isPayOrderBill() {
        return PAY_ORDER_BILL.equals(this.type);
    }

    public boolean isPayRentBill() {
        return PAY_RENT_BILL.equals(this.type);
    }

    public boolean isPayReserveBill() {
        return PAY_RESERVE_BILL.equals(this.type);
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
