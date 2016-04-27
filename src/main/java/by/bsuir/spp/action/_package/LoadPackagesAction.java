package by.bsuir.spp.action._package;

import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoadPackagesAction extends ActionSupport {

    private List<Package> packages;

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    @Override
    public String execute() throws Exception {
        packages = MySqlPackageDao.getInstance().getAllPackages();
        setPackages(packages);
        return SUCCESS;
    }
}
