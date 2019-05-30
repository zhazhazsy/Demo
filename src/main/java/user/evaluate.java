package user;

public class evaluate {
    private String id;
    private String message;
    private String tou;
    public evaluate(String id,String message,String tou){
        this.id=id;
        this.message=message;
        this.tou=tou;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTou() {
        return tou;
    }

    public void setTou(String tou) {
        this.tou = tou;
    }
}
