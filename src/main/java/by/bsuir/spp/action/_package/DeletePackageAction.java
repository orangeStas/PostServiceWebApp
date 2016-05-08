package by.bsuir.spp.action._package;

import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePackageAction extends ActionSupport {
    private String packageId;

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Override
    public String execute() throws Exception {
        by.bsuir.spp.bean.document.Package myPackage = new by.bsuir.spp.bean.document.Package();
        myPackage.setIdPackage(Integer.parseInt(getPackageId()));

        PackageDao packageDao = MySqlPackageDao.getInstance();

        try {
            packageDao.delete(myPackage);
        } catch (DaoException e) {
            return ERROR;
        }

        return SUCCESS;
    }
}