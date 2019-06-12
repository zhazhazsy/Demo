package user;

public class mune2 {
    private String muneid;
    private String munename;
    private String price;
    private String amount;
    private String number;

    public mune2(String muneid,String munename,String price,String amount,String number){
        this.muneid=muneid;
        this.munename=munename;
        this.price=price;
        this.amount=amount;
        this.number=number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMuneid() {
        return muneid;
    }

    public void setMuneid(String muneid) {
        this.muneid = muneid;
    }

    public String getMunename() {
        return munename;
    }

    public void setMunename(String munename) {
        this.munename = munename;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}