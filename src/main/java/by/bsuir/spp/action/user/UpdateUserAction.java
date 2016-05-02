package by.bsuir.spp.action.user;

import by.bsuir.spp.bean.Passport;
import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.UserType;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateUserAction extends ActionSupport {
    @Override
    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();

        User user = new User();

        user.setId(Integer.parseInt(request.getParameter(RequestParameterName.USER_ID)));
        user.setLogin(request.getParameter(RequestParameterName.LOGIN_FIELD));
        user.setFirstName(request.getParameter(RequestParameterName.FIRST_NAME));
        user.setSecondName(request.getParameter(RequestParameterName.SEC_NAME));
        user.setMiddleName(request.getParameter(RequestParameterName.MIDDLE_NAME));
        user.setUserRole(UserType.valueOf(request.getParameter(RequestParameterName.USER_ROLE).toUpperCase()));

        user.setEmail(getRequestParam(request, RequestParameterName.EMAIL));
        user.setPhone(getRequestParam(request, RequestParameterName.PHONE));

        Passport passport = new Passport();
        passport.setPassportId(Integer.parseInt(request.getParameter(RequestParameterName.PASSPORT_ID)));

        user.setPassport(passport);

        UserDao userDao = MySqlUserDao.getInstance();

        passport.setPassportId(Integer.parseInt(request.getParameter(RequestParameterName.PASSPORT_ID)));
        passport.setPassportNumber(request.getParameter(RequestParameterName.PASSPORT_NUMBER));
        passport.setAddress(request.getParameter(RequestParameterName.PASSPORT_ADDRESS));
        passport.setIssuingInstitution(request.getParameter(RequestParameterName.INSTITUTION));
        try {
            passport.setIssueDate(new SimpleDateFormat("dd MMMM, yyyy").parse(request.getParameter(RequestParameterName.ISSUING_DATE)));
        } catch (ParseException e) {
            passport.setIssueDate(new SimpleDateFormat("yyyy-dd-mm").parse(request.getParameter(RequestParameterName.ISSUING_DATE)));
        }

        PassportDao passportDao = MySqlPassportDao.getInstance();
        try {
            passportDao.update(passport);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        try {
            userDao.update(user);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    private String getRequestParam(HttpServletRequest request, String parameterName){
        return request.getParameter(parameterName);
    }
}
