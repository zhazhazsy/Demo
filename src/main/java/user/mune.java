package user;

public class mune {
    private String muneid;
    private String munename;
    private String price;
    private String amount;

    public mune(String muneid,String munename,String price,String amount){
        this.muneid=muneid;
        this.munename=munename;
        this.price=price;
        this.amount=amount;
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
