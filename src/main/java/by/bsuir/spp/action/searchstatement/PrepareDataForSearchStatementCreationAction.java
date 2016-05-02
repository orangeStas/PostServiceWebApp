package by.bsuir.spp.action.searchstatement;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class PrepareDataForSearchStatementCreationAction extends ActionSupport {
    private List<Package> packages;

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    @Override
    public String execute() throws Exception {
        setPackages(MySqlPackageDao.getInstance().
                getPackagesByPassportId(
                        ((User) ActionContext.getContext().getSession().
                                get(RequestParameterName.USER)).
                                getPassport().getPassportId()));

        return SUCCESS;
    }
}
