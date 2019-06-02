package user;

public class person {
    private String phone;
    private String add;
    private String name;
    public person(String phone,String add,String name){
        this.phone=phone;
        this.add=add;
        this.name=name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
