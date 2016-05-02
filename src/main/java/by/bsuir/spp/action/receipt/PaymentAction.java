package by.bsuir.spp.action.receipt;

import by.bsuir.spp.bean.document.Receipt;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.ReceiptDao;
import by.bsuir.spp.dao.impl.MySqlReceiptDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport{
    @Override
    public String execute() throws Exception {
        Receipt receipt = (Receipt) ActionContext.getContext().getSession().get(RequestParameterName.RECEIPT);
        ReceiptDao receiptDao = MySqlReceiptDao.getInstance();
        receiptDao.create(receipt);
        ActionContext.getContext().getSession().remove(RequestParameterName.RECEIPT);

        return SUCCESS;
    }
}
