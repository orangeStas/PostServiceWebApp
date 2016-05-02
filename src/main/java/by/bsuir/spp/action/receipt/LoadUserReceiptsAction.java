package by.bsuir.spp.action.receipt;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.Receipt;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.ReceiptDao;
import by.bsuir.spp.dao.impl.MySqlReceiptDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoadUserReceiptsAction extends ActionSupport {
    private List<Receipt> receipts;

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    @Override
    public String execute() throws Exception {
        int userId = ((User) ActionContext.getContext().getSession().get(RequestParameterName.USER)).getId();
        ReceiptDao receiptDao = MySqlReceiptDao.getInstance();
        List<Receipt> receiptList = receiptDao.getUserReceipts(userId);
        setReceipts(receiptList);

        return SUCCESS;
    }
}
