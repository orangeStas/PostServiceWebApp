package by.bsuir.spp.action;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.controller.constant.JspPageName;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User> {

    private User user = new User();
    private Map<String, Object> session = null;
    private String url;
    private static final String SALT = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String execute() throws Exception {
        UserDao userDao = MySqlUserDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();
        user = getModel();
        user.setPassword(DigestUtils.md5Hex(user.getPassword() + SALT));

        User loggedUser = userDao.checkUser(user);

        if (loggedUser != null) {
            loggedUser.setPassport(passportDao.read(loggedUser.getPassport().getPassportId()));
            switch (loggedUser.getUserRole()) {
                case ADMIN: {
                    setUrl(JspPageName.HOME_ADMIN_PAGE);
                    break;
                }
                case CLIENT: {
                    setUrl(JspPageName.HOME_PAGE);
                    break;
                }

                case POST_MANAGER: {
                    setUrl(JspPageName.HOME_MANAGER_PAGE);
                    //page = new GetNewPackagesCommand().execute(request);
                    break;
                }
            }
            session.put(RequestParameterName.USER, loggedUser);
            return "redirect";
        }
        else {
            addActionError("Invalid login or pass");
            return INPUT;
        }
    }

    @Override
    public User getModel() {
        return user;
    }



    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
