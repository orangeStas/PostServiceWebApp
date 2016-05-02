package by.bsuir.spp.action.prepaymentbook;

import by.bsuir.spp.bean.document.PrepaymentBookStatement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PrepaymentBookDao;
import by.bsuir.spp.dao.impl.MySqlPrepaymentBookDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class AddPrepaymentBookAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        PrepaymentBookDao prepaymentBookDao = MySqlPrepaymentBookDao.getInstance();


        PrepaymentBookStatement prepaymentBookStatement = new PrepaymentBookStatement();
        prepaymentBookStatement.setPassportId(Integer.parseInt(request.getParameter(RequestParameterName.PASSPORT_ID)));
        prepaymentBookStatement.setBookkeeperName(request.getParameter(RequestParameterName.BOOKKEEPER_NAME));
        prepaymentBookStatement.setClientName(request.getParameter(RequestParameterName.CLIENT_NAME));
        prepaymentBookStatement.setClientNumber(Integer.parseInt(request.getParameter(RequestParameterName.CLIENT_NUMBER)));
        prepaymentBookStatement.setDate(new Date());

        prepaymentBookStatement.setUnpaidCost(Integer.parseInt(request.getParameter(RequestParameterName.UNPAID_COST)));
        prepaymentBookStatement.setOrganizationHeadName(request.getParameter(RequestParameterName.ORGANIZATION_HEAD_NAME));

        prepaymentBookDao.create(prepaymentBookStatement);


        return SUCCESS;
    }
}
