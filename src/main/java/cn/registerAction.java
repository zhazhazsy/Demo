package cn;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import user.user;

public class registerAction extends ActionSupport implements ModelDriven<user> {
    private user user = new user();
    public user getModel() {
        return user;
    }
    public String execute(){
        String result = null;
        result = goRegister.addQueryByID(user.getId(),user.getPwd(),user.getName(),user.getSex(),user.getPhone(),user.getAdd());
        if(result=="dd"){
            return "registerSuccess";
        }else{
            return "registerError";
        }
    }
}
