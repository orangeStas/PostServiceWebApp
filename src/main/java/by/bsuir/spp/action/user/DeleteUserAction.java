package by.bsuir.spp.action.user;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteUserAction extends ActionSupport {
    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String execute() throws Exception {
        int userId = Integer.parseInt(getUser_id());
        User user = new User();
        user.setId(userId);
        UserDao userDao = MySqlUserDao.getInstance();

        try {
            userDao.delete(user);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }
}
