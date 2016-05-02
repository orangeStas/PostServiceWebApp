package by.bsuir.spp.action._package;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class PrepareDataForPackageCreationAction extends ActionSupport {

    private List<String> package_types = new ArrayList<>();
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<String> getPackage_types() {
        return package_types;
    }

    public void setPackage_types(List<String> package_types) {
        this.package_types = package_types;
    }

    @Override
    public String execute() throws Exception {
        package_types.add("Письмо");
        package_types.add("Бандероль");
        package_types.add("Крупногабаритная");

        setPackage_types(package_types);

        setUsers(MySqlUserDao.getInstance().getAllUsers());

        return SUCCESS;
    }
}

