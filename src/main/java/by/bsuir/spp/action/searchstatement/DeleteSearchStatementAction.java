package by.bsuir.spp.action.searchstatement;

import by.bsuir.spp.bean.document.SearchPackageStatement;
import by.bsuir.spp.dao.SearchStatementDao;
import by.bsuir.spp.dao.impl.MySqlSearchStatementDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteSearchStatementAction extends ActionSupport {
    private String search_statement_id;

    public String getSearch_statement_id() {
        return search_statement_id;
    }

    public void setSearch_statement_id(String search_statement_id) {
        this.search_statement_id = search_statement_id;
    }

    @Override
    public String execute() throws Exception {
        int statementId = Integer.parseInt(getSearch_statement_id());
        SearchStatementDao searchStatementDao = MySqlSearchStatementDao.getInstance();
        SearchPackageStatement searchPackageStatement = new SearchPackageStatement();
        searchPackageStatement.setId(statementId);
        try {
            searchStatementDao.delete(searchPackageStatement);
        } catch (DaoException e) {
            e.printStackTrace();
        }


        return SUCCESS;

    }
}
