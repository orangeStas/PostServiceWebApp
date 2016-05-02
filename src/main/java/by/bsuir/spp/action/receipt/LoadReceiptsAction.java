package by.bsuir.spp.action.receipt;

import by.bsuir.spp.bean.document.Receipt;
import by.bsuir.spp.dao.impl.MySqlReceiptDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoadReceiptsAction extends ActionSupport {
    private List<Receipt> receipts;

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    @Override
    public String execute() throws Exception {
        receipts = MySqlReceiptDao.getInstance().getAllReceipts();
        setReceipts(receipts);
        return SUCCESS;
    }
}
