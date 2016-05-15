package by.bsuir.spp.action.user;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;

public class UpdateUserAction extends ActionSupport {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        UserDao userDao = MySqlUserDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();
        try {
            passportDao.update(getUser().getPassport());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        try {
            userDao.update(getUser());
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    private String getRequestParam(HttpServletRequest request, String parameterName){
        return request.getParameter(parameterName);
    }
}
