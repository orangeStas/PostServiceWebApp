package by.bsuir.spp.action._package;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoadUserPackagesAction extends ActionSupport {
    private List<Package> packages;

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    @Override
    public String execute() throws Exception {
        int passportId = ((User)ActionContext.getContext().getSession().get(RequestParameterName.USER)).getPassport().getPassportId();
        PackageDao packageDao = MySqlPackageDao.getInstance();
        UserDao userDao = MySqlUserDao.getInstance();
        packages = packageDao.getPackagesByPassportId(passportId);
        for (Package pack : packages) {
            pack.setGetterUser(userDao.read(pack.getGetterUser().getId()));
        }

        setPackages(packages);

        return SUCCESS;
    }
}
