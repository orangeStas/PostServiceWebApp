package by.bsuir.spp.action.prepaymentbook;

import by.bsuir.spp.bean.document.PrepaymentBookStatement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.impl.MySqlPrepaymentBookDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class SelectPrepaymentBookAction extends ActionSupport {
    private String prepayment_book_number;

    private PrepaymentBookStatement prepayment_book;

    public PrepaymentBookStatement getPrepayment_book() {
        return prepayment_book;
    }

    public void setPrepayment_book(PrepaymentBookStatement prepayment_book) {
        this.prepayment_book = prepayment_book;
    }

    public String getPrepayment_book_number() {
        return prepayment_book_number;
    }

    public void setPrepayment_book_number(String prepayment_book_number) {
        this.prepayment_book_number = prepayment_book_number;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        int bookNumber = Integer.parseInt(request.getParameter(RequestParameterName.PREPAYMENT_BOOK_NUMBER));
        setPrepayment_book(MySqlPrepaymentBookDao.getInstance().read(bookNumber));
        return SUCCESS;
    }
}
