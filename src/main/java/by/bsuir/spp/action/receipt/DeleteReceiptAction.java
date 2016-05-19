package by.bsuir.spp.action.receipt;

import by.bsuir.spp.bean.document.Receipt;
import by.bsuir.spp.dao.ReceiptDao;
import by.bsuir.spp.dao.impl.MySqlReceiptDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteReceiptAction extends ActionSupport {
    private String receipt_id;

    public String getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(String receipt_id) {
        this.receipt_id = receipt_id;
    }

    @Override
    public String execute() throws Exception {
        int idReceipt = Integer.parseInt(getReceipt_id());
        ReceiptDao receiptDao = MySqlReceiptDao.getInstance();
        Receipt receipt = new Receipt();
        receipt.setReceiptId(idReceipt);
        try {
            receiptDao.delete(receipt);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return "admin";
    }
}
