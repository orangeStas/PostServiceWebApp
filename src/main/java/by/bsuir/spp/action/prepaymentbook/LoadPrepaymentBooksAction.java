package by.bsuir.spp.action.prepaymentbook;

import by.bsuir.spp.bean.document.PrepaymentBookStatement;
import by.bsuir.spp.dao.PrepaymentBookDao;
import by.bsuir.spp.dao.impl.MySqlPrepaymentBookDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoadPrepaymentBooksAction extends ActionSupport {

    private List<PrepaymentBookStatement> prepayment_books;

    public List<PrepaymentBookStatement> getPrepayment_books() {
        return prepayment_books;
    }

    public void setPrepayment_books(List<PrepaymentBookStatement> prepayment_books) {
        this.prepayment_books = prepayment_books;
    }

    @Override
    public String execute() throws Exception {
        PrepaymentBookDao prepaymentBookDao = MySqlPrepaymentBookDao.getInstance();

        prepayment_books = prepaymentBookDao.getAllPrepaymentBooks();
        setPrepayment_books(prepayment_books);

        return SUCCESS;
    }
}
