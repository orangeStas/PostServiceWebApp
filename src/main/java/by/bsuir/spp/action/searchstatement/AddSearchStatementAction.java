package by.bsuir.spp.action.searchstatement;

import by.bsuir.spp.bean.Passport;
import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.bean.document.SearchPackageStatement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.SearchStatementDao;
import by.bsuir.spp.dao.impl.MySqlSearchStatementDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class AddSearchStatementAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        SearchPackageStatement packageStatement = getStatement(request);

        SearchStatementDao searchStatementDao = MySqlSearchStatementDao.getInstance();

        try {
            searchStatementDao.create(packageStatement);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    private SearchPackageStatement getStatement(HttpServletRequest request) {
        SearchPackageStatement packageStatement = new SearchPackageStatement();
        packageStatement.setPostManagerName(request.getParameter(RequestParameterName.POST_MANAGER_NAME));

        packageStatement.setCurrentDate(new Date());

        packageStatement.setPetitionContent(request.getParameter(RequestParameterName.PETITION_CONTENT));
        packageStatement.setAddress(request.getParameter(RequestParameterName.SEARCH_STATEMENT_ADDRESS));
        packageStatement.setPhoneNumber(request.getParameter(RequestParameterName.PHONE_NUMBER));

        Passport passport = new Passport();
        passport.setPassportId(Integer.parseInt(request.getParameter(RequestParameterName.PASSPORT_ID)));
        packageStatement.setPassport(passport);

        by.bsuir.spp.bean.document.Package packagee = new Package();
        packagee.setIdPackage(Integer.parseInt(request.getParameter(RequestParameterName.PACKAGE_ID)));
        packageStatement.setPostPackage(packagee);

        return packageStatement;
    }
}
