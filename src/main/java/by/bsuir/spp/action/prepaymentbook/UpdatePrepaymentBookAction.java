package by.bsuir.spp.action.prepaymentbook;

import by.bsuir.spp.bean.document.PrepaymentBookStatement;
import by.bsuir.spp.dao.PrepaymentBookDao;
import by.bsuir.spp.dao.impl.MySqlPrepaymentBookDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatePrepaymentBookAction extends ActionSupport {


    private PrepaymentBookStatement prepaymentBook;

    public PrepaymentBookStatement getPrepaymentBook() {
        return prepaymentBook;
    }

    public void setPrepaymentBook(PrepaymentBookStatement prepaymentBook) {
        this.prepaymentBook = prepaymentBook;
    }

    @Override
    public String execute() throws Exception {
        PrepaymentBookStatement prepaymentBookStatement = getPrepaymentBook();

        PrepaymentBookDao prepaymentBookDao = MySqlPrepaymentBookDao.getInstance();
        try {
            prepaymentBookDao.update(prepaymentBookStatement);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }
}
