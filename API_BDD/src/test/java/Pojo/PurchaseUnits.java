package Pojo;

public class PurchaseUnits {
    private Amount amount ;

    public PurchaseUnits(String currency_code,String currency_value) {
        this.amount = new Amount(currency_code,currency_value);
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
