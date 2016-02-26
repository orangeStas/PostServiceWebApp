package by.bsuir.spp.controller.command.impl.searchstatement;

import by.bsuir.spp.bean.document.SearchPackageStatement;
import by.bsuir.spp.controller.command.Command;
import by.bsuir.spp.controller.constant.JspPageName;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.SearchStatementDao;
import by.bsuir.spp.dao.impl.MySqlSearchStatementDao;
import by.bsuir.spp.exception.controller.command.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoadSearchStatementsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        SearchStatementDao searchStatementDao = MySqlSearchStatementDao.getInstance();

        List<SearchPackageStatement> statementList = searchStatementDao.getAllSearchStatements();

        request.setAttribute(RequestParameterName.SEARCH_STATEMENTS, statementList);

        return JspPageName.SEARCH_STATEMENTS;
    }
}