package by.bsuir.spp.action;

import by.bsuir.spp.bean.Passport;
import by.bsuir.spp.bean.User;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegistrationAction extends ActionSupport {

    private static final String SALT = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";


    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        UserDao userDao = MySqlUserDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();

        Passport passport = new Passport();

        passport.setPassportNumber(getRequestParam(request, RequestParameterName.PASSPORT_NUMBER));
        passport.setAddress(getRequestParam(request, RequestParameterName.PASSPORT_ADDRESS));
        try {
            passport.setIssueDate(new SimpleDateFormat("dd MMMM, yyyy").parse(request.getParameter(RequestParameterName.ISSUING_DATE)) );
        } catch (ParseException e) {

        }

        passport.setIssuingInstitution(getRequestParam(request, RequestParameterName.INSTITUTION));

        try {

            User user = new User();

            user.setFirstName(getRequestParam(request, RequestParameterName.FIRST_NAME));
            user.setLogin(getRequestParam(request, RequestParameterName.LOGIN_FIELD));
            user.setPassword(DigestUtils.md5Hex(getRequestParam(request, RequestParameterName.PASSWORD) + SALT));
            user.setSecondName(getRequestParam(request, RequestParameterName.SEC_NAME));
            user.setMiddleName(getRequestParam(request, RequestParameterName.MIDDLE_NAME));
            user.setEmail(getRequestParam(request, RequestParameterName.EMAIL));
            user.setPhone(getRequestParam(request, RequestParameterName.PHONE));

            if (!validateParams(request)) {
                request.getSession().setAttribute(RequestParameterName.USER, user);
                request.getSession().setAttribute(RequestParameterName.PASSPORT, passport);
                return ERROR;
            }
            int passportId = passportDao.create(passport);
            passport.setPassportId(passportId);
            user.setPassport(passport);


            if (!userDao.checkLogin(user.getLogin())) {
                request.getSession().setAttribute(RequestParameterName.USER, user);
                request.getSession().setAttribute(RequestParameterName.PASSPORT, passport);
                return ERROR;
            } else {
                int userId = userDao.create(user);
                user.setId(userId);
                request.getSession().removeAttribute(RequestParameterName.USER);
                request.getSession().removeAttribute(RequestParameterName.PASSPORT);
                return SUCCESS;
            }
        } catch (Exception e) {
            return ERROR;
        }

    }

    private boolean validateParams(HttpServletRequest request)
    {

        if (getRequestParam(request, RequestParameterName.LOGIN_FIELD).equals("") ||
                getRequestParam(request, RequestParameterName.PASSWORD).equals("") ||
                getRequestParam(request, RequestParameterName.FIRST_NAME).equals("") ||
                getRequestParam(request, RequestParameterName.SEC_NAME).equals("") ||
                getRequestParam(request, RequestParameterName.MIDDLE_NAME).equals("") ||
                getRequestParam(request, RequestParameterName.PASSPORT_NUMBER).equals("") ||
                getRequestParam(request, RequestParameterName.PASSPORT_ADDRESS).equals("") ||
                getRequestParam(request, RequestParameterName.INSTITUTION).equals("") ||
                getRequestParam(request, RequestParameterName.ISSUING_DATE).equals("") ||
                getRequestParam(request, RequestParameterName.PHONE).equals("") ||
                getRequestParam(request, RequestParameterName.EMAIL).equals(""))
        {
            return false;
        }

        if (getRequestParam(request, RequestParameterName.LOGIN_FIELD).length() > 45 ||
                getRequestParam(request, RequestParameterName.PASSWORD).length() > 45 ||
                getRequestParam(request, RequestParameterName.FIRST_NAME).length() > 45 ||
                getRequestParam(request, RequestParameterName.SEC_NAME).length() > 45 ||
                getRequestParam(request, RequestParameterName.MIDDLE_NAME).length() > 45 ||
                getRequestParam(request, RequestParameterName.PASSPORT_NUMBER).length() > 45 ||
                getRequestParam(request, RequestParameterName.PASSPORT_ADDRESS).length() > 45 ||
                getRequestParam(request, RequestParameterName.INSTITUTION).length() > 200)
        {
            return false;
        }

        try {
            new SimpleDateFormat("dd MMMM, yyyy").parse(request.getParameter(RequestParameterName.ISSUING_DATE));
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    private String getRequestParam(HttpServletRequest request, String parameterName) {
        return request.getParameter(parameterName);
    }


}
