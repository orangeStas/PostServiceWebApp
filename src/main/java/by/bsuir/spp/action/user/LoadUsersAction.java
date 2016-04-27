package by.bsuir.spp.action.user;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.UserType;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoadUsersAction extends ActionSupport {

    private List<User> users;

    private int admins_count;

    public int getAdmins_count() {
        return admins_count;
    }

    public void setAdmins_count(int admins_count) {
        this.admins_count = admins_count;
    }

    public List<User> getUsers() {
        return users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String execute() throws Exception {
        UserDao userDao = MySqlUserDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();
        users = userDao.getAllUsers();

        for (User user : users) {
            try {
                user.setPassport(passportDao.read(user.getPassport().getPassportId()));
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }

        setUsers(users);

        setAdmins_count(getAdminsCount(users));

        return SUCCESS;
    }

    private int getAdminsCount(List<User> users) {
        int count = 0;

        for (User user : users) {
            if (user.getUserRole() == UserType.ADMIN) {
                count++;
            }
        }

        return count;
    }
}
