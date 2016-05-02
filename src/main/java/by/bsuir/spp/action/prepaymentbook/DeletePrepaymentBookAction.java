package by.bsuir.spp.action.prepaymentbook;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.UserType;
import by.bsuir.spp.bean.document.PrepaymentBookStatement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PrepaymentBookDao;
import by.bsuir.spp.dao.impl.MySqlPrepaymentBookDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePrepaymentBookAction extends ActionSupport {
    private String prepayment_book_number;

    public String getPrepayment_book_number() {
        return prepayment_book_number;
    }

    public void setPrepayment_book_number(String prepayment_book_number) {
        this.prepayment_book_number = prepayment_book_number;
    }


    @Override
    public String execute() throws Exception {
        int bookId = Integer.parseInt(getPrepayment_book_number());
        PrepaymentBookDao prepaymentBookDao = MySqlPrepaymentBookDao.getInstance();
        PrepaymentBookStatement bookStatement = new PrepaymentBookStatement();
        bookStatement.setStatementNumber(bookId);
        try {
            prepaymentBookDao.delete(bookStatement);
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
}
