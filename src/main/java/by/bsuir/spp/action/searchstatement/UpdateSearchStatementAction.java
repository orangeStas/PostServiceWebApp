package by.bsuir.spp.action.searchstatement;

import by.bsuir.spp.bean.Passport;
import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.UserType;
import by.bsuir.spp.bean.document.SearchPackageStatement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.SearchStatementDao;
import by.bsuir.spp.dao.impl.MySqlSearchStatementDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateSearchStatementAction extends ActionSupport {

    private SearchPackageStatement searchStatement;

    public SearchPackageStatement getSearchStatement() {
        return searchStatement;
    }

    public void setSearchStatement(SearchPackageStatement searchStatement) {
        this.searchStatement = searchStatement;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        SearchPackageStatement packageStatement = getSearchStatement();

        SearchStatementDao searchStatementDao = MySqlSearchStatementDao.getInstance();
        try {
            searchStatementDao.update(packageStatement);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        UserType userType = ((User) ActionContext.getContext().getSession().get(RequestParameterName.USER)).getUserRole();

        switch (userType) {
            case ADMIN: {
                return "admin";
            }
            default:
            {
                return "manager";
            }
        }
    }

    private SearchPackageStatement getStatement(HttpServletRequest request) throws ParseException {
        SearchPackageStatement packageStatement = new SearchPackageStatement();
        packageStatement.setPostManagerName(request.getParameter(RequestParameterName.POST_MANAGER_NAME));
        try {
            packageStatement.setCurrentDate(new SimpleDateFormat("dd MMMM, yyyy").parse(request.getParameter(RequestParameterName.DATE)));
        } catch (ParseException e) {
            packageStatement.setCurrentDate(new SimpleDateFormat("yyyy-dd-mm").parse(request.getParameter(RequestParameterName.DATE)));
        }
        packageStatement.setPetitionContent(request.getParameter(RequestParameterName.PETITION_CONTENT));
        packageStatement.setAddress(request.getParameter(RequestParameterName.SEARCH_STATEMENT_ADDRESS));
        packageStatement.setPhoneNumber(request.getParameter(RequestParameterName.PHONE_NUMBER));

        Passport passport = new Passport();
        passport.setPassportId(Integer.parseInt(request.getParameter(RequestParameterName.PASSPORT_ID)));
        packageStatement.setPassport(passport);

        by.bsuir.spp.bean.document.Package packagee = new by.bsuir.spp.bean.document.Package();
        packagee.setIdPackage(Integer.parseInt(request.getParameter(RequestParameterName.PACKAGE_ID)));
        packageStatement.setPostPackage(packagee);

        packageStatement.setId(Integer.parseInt(request.getParameter(RequestParameterName.SEARCH_STATEMENT_ID)));

        return packageStatement;
    }
}
