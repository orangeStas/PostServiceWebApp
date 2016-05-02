package by.bsuir.spp.action.searchstatement;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.SearchPackageStatement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.SearchStatementDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlSearchStatementDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoadUserSearchStatementsAction extends ActionSupport {
    private List<SearchPackageStatement> search_statements;

    public List<SearchPackageStatement> getSearch_statements() {
        return search_statements;
    }

    public void setSearch_statements(List<SearchPackageStatement> search_statements) {
        this.search_statements = search_statements;
    }

    @Override
    public String execute() throws Exception {
        int passportId = ((User) ActionContext.getContext().getSession().get(RequestParameterName.USER)).getPassport().getPassportId();
        SearchStatementDao searchStatementDao = MySqlSearchStatementDao.getInstance();
        List<SearchPackageStatement> statementList = searchStatementDao.getSearchStatementByPassportId(passportId);
        PackageDao packageDao = MySqlPackageDao.getInstance();
        for (SearchPackageStatement packageStatement : statementList) {
            packageStatement.setPostPackage(packageDao.read(packageStatement.getPostPackage().getIdPackage()));
        }

        setSearch_statements(statementList);

        return SUCCESS;
    }
}
