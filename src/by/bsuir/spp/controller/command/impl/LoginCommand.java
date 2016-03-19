package by.bsuir.spp.controller.command.impl;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.controller.command.Command;
import by.bsuir.spp.controller.constant.JspPageName;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import by.bsuir.spp.exception.controller.command.CommandException;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        String page;

        if (validateParams(request)) {
            UserDao userDao = MySqlUserDao.getInstance();

            String login = request.getParameter(RequestParameterName.LOGIN_FIELD);
            String password = DigestUtils.md5Hex(request.getParameter(RequestParameterName.PASSWORD));

            User user = new User();
            user.setLogin(login);
            user.setPassword(password);

            User loggedUser = userDao.checkUser(user);

            if (loggedUser == null) {
                return JspPageName.LOGIN_PAGE + "?" + RequestParameterName.MESSAGE + "=invalid";
            }
            else {
                switch (loggedUser.getUserRole()) {
                    case ADMIN: {
                        page = JspPageName.HOME_ADMIN_PAGE;
                        break;
                    }
                    case CLIENT: {
                        page = JspPageName.HOME_PAGE;
                        break;
                    }

                    case POST_MANAGER: {
                        page = JspPageName.HOME_MANAGER_PAGE;
                        break;
                    }
                    default: {
                        page = JspPageName.HOME_PAGE;
                    }
                }

                request.getSession().setAttribute(RequestParameterName.USER, loggedUser);
            }
        }
        else {
            page = JspPageName.LOGIN_PAGE + "?" + RequestParameterName.MESSAGE + "=invalid";
        }



        return page;
    }

    private boolean validateParams(HttpServletRequest request) {
        String login = request.getParameter(RequestParameterName.LOGIN_FIELD);
        String password = DigestUtils.md5Hex(request.getParameter(RequestParameterName.PASSWORD));

        boolean idValid = true;

        if (login != null && password != null) {
            if (login.length() > 45) {
                idValid = false;
            }
            if (password.length() > 45) {
                idValid = false;
            }
        }
        else {
            idValid = false;
        }

        return idValid;
    }
}
