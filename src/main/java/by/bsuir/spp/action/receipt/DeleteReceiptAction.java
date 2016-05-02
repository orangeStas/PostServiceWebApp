package by.bsuir.spp.action.receipt;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.UserType;
import by.bsuir.spp.bean.document.Receipt;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.ReceiptDao;
import by.bsuir.spp.dao.impl.MySqlReceiptDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionContext;
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

        UserType userType = ((User) ActionContext.getContext().getSession().get(RequestParameterName.USER)).getUserRole();

        switch (userType) {
            case ADMIN: {
                return "admin";
            }
            default: {
                return "client";
            }
        }
    }
}
