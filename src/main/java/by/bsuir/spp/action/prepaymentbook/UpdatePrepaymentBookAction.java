package by.bsuir.spp.action.prepaymentbook;

import by.bsuir.spp.bean.document.PrepaymentBookStatement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PrepaymentBookDao;
import by.bsuir.spp.dao.impl.MySqlPrepaymentBookDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdatePrepaymentBookAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        PrepaymentBookStatement prepaymentBookStatement = new PrepaymentBookStatement();
        prepaymentBookStatement.setPassportId(Integer.parseInt(request.getParameter(RequestParameterName.PASSPORT_ID)));
        prepaymentBookStatement.setBookkeeperName(request.getParameter(RequestParameterName.BOOKKEEPER_NAME));
        prepaymentBookStatement.setClientName(request.getParameter(RequestParameterName.CLIENT_NAME));
        prepaymentBookStatement.setClientNumber(Integer.parseInt(request.getParameter(RequestParameterName.CLIENT_NUMBER)));
        try {
            prepaymentBookStatement.setDate(new SimpleDateFormat("dd MMMM, yyyy").parse(request.getParameter(RequestParameterName.DATE)));
        } catch (ParseException e) {
            prepaymentBookStatement.setDate(new SimpleDateFormat("yyyy-dd-mm").parse(request.getParameter(RequestParameterName.DATE)));
        }

        prepaymentBookStatement.setUnpaidCost(Integer.parseInt(request.getParameter(RequestParameterName.UNPAID_COST)));
        prepaymentBookStatement.setOrganizationHeadName(request.getParameter(RequestParameterName.ORGANIZATION_HEAD_NAME));
        prepaymentBookStatement.setStatementNumber(Integer.parseInt(request.getParameter(RequestParameterName.PREPAYMENT_BOOK_NUMBER)));

        PrepaymentBookDao prepaymentBookDao = MySqlPrepaymentBookDao.getInstance();
        try {
            prepaymentBookDao.update(prepaymentBookStatement);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }
}
