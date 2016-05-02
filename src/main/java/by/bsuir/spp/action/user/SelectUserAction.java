package by.bsuir.spp.action.user;

import by.bsuir.spp.bean.Passport;
import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.UserType;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class SelectUserAction extends ActionSupport {
    private User userr;
    private int admins_count;
    private String user_id;
    private List<Passport> passports;
    private UserType[] user_roles;

    public List<Passport> getPassports() {
        return passports;
    }

    public void setPassports(List<Passport> passports) {
        this.passports = passports;
    }

    public UserType[] getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(UserType[] user_roles) {
        this.user_roles = user_roles;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public User getUserr() {
        return userr;
    }

    public void setUserr(User userr) {
        this.userr = userr;
    }

    public int getAdmins_count() {
        return admins_count;
    }

    public void setAdmins_count(int admins_count) {
        this.admins_count = admins_count;
    }

    @Override
    public String execute() throws Exception {
        UserDao userDao = MySqlUserDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();

        int userId = Integer.parseInt(getUser_id());

        User user = null;

        try {
            user = userDao.read(userId);
            user.setPassport(passportDao.read(user.getPassport().getPassportId()));
        } catch (DaoException e) {
            e.printStackTrace();
        }

        List<Passport> passports = passportDao.getAllPassports();

        setPassports(passports);
        setUser_roles(UserType.values());
        setUserr(user);
        setAdmins_count(getAdminsCount(userDao.getAllUsers()));

        return SUCCESS;
    }

    private Integer getAdminsCount(List<User> users) {
        int count = 0;

        for (User user : users) {
            if (user.getUserRole() == UserType.ADMIN) {
                count++;
            }
        }

        return count;
    }
}
