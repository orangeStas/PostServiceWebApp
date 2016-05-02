package by.bsuir.spp.action.receipt;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.Receipt;
import by.bsuir.spp.controller.constant.RequestParameterName;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Date;

public class AddReceiptAction extends ActionSupport implements ModelDriven<Receipt> {

    private Receipt receipt = new Receipt();

    @Override
    public String execute() throws Exception {
        receipt = getModel();
        receipt.setUserId(((User) ActionContext.getContext().getSession().get(RequestParameterName.USER)).getId());
        receipt.setDate(new Date());

        ActionContext.getContext().getSession().put(RequestParameterName.RECEIPT, receipt);

        return SUCCESS;

    }

    @Override
    public Receipt getModel() {
        return receipt;
    }
}
