package by.bsuir.spp.action.searchstatement;

import by.bsuir.spp.bean.document.SearchPackageStatement;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.SearchStatementDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlSearchStatementDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoadSearchStatementsAction extends ActionSupport {
    private List<SearchPackageStatement> search_statements;

    public List<SearchPackageStatement> getSearch_statements() {
        return search_statements;
    }

    public void setSearch_statements(List<SearchPackageStatement> search_statements) {
        this.search_statements = search_statements;
    }

    @Override
    public String execute() throws Exception {
        SearchStatementDao searchStatementDao = MySqlSearchStatementDao.getInstance();
        PackageDao packageDao = MySqlPackageDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();

        search_statements = searchStatementDao.getAllSearchStatements();

        for (SearchPackageStatement statement : search_statements) {
            statement.setPassport(passportDao.read(statement.getPassport().getPassportId()));
            statement.setPostPackage(packageDao.read(statement.getPostPackage().getIdPackage()));
        }

        setSearch_statements(search_statements);

        return SUCCESS;
    }
}
