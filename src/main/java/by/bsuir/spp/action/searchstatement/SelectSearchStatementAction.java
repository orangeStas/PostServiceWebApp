package by.bsuir.spp.action.searchstatement;

import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.bean.document.SearchPackageStatement;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.SearchStatementDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlSearchStatementDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SelectSearchStatementAction extends ActionSupport {
    private String search_statement_id;
    private SearchPackageStatement search_statement;

    private List<Package> packages;

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public SearchPackageStatement getSearch_statement() {
        return search_statement;
    }

    public void setSearch_statement(SearchPackageStatement search_statement) {
        this.search_statement = search_statement;
    }

    public String getSearch_statement_id() {
        return search_statement_id;
    }

    public void setSearch_statement_id(String search_statement_id) {
        this.search_statement_id = search_statement_id;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        int statementId = Integer.parseInt(request.getParameter("statement_id"));
        SearchStatementDao searchStatementDao = MySqlSearchStatementDao.getInstance();
        PackageDao packageDao = MySqlPackageDao.getInstance();

        SearchPackageStatement searchPackageStatement = searchStatementDao.read(statementId);
        searchPackageStatement.setPostPackage(packageDao.read(searchPackageStatement.getPostPackage().getIdPackage()));
        setPackages(packageDao.getAllPackages());

        setSearch_statement(searchPackageStatement);

        return SUCCESS;
    }
}
