package by.bsuir.spp.controller.command.impl.searchstatement;

import by.bsuir.spp.bean.document.SearchPackageStatement;
import by.bsuir.spp.controller.command.Command;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.SearchStatementDao;
import by.bsuir.spp.dao.impl.MySqlSearchStatementDao;
import by.bsuir.spp.exception.controller.command.CommandException;
import by.bsuir.spp.exception.dao.DaoException;

import javax.servlet.http.HttpServletRequest;

public class DeleteSearchStatementCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int statementId = Integer.parseInt(request.getParameter(RequestParameterName.SEARCH_STATEMENT_ID));
        SearchStatementDao searchStatementDao = MySqlSearchStatementDao.getInstance();
        SearchPackageStatement searchPackageStatement = new SearchPackageStatement();
        searchPackageStatement.setId(statementId);
        try {
            searchStatementDao.delete(searchPackageStatement);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return new LoadSearchStatementsCommand().execute(request);
    }
}