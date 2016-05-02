package by.bsuir.spp.action._package;

import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import com.opensymphony.xwork2.ActionSupport;

public class RejectPackageAction extends ActionSupport {

    private String package_id;

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    @Override
    public String execute() throws Exception {
        PackageDao packageDao = MySqlPackageDao.getInstance();
        int packageId = Integer.parseInt(getPackage_id());
        packageDao.updateStatus(packageId, "отклонено");
        packageDao.deleteNewPackage(packageId);
        return SUCCESS;
    }
}
