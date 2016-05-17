package by.bsuir.spp.action._package;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoadPackagesAction extends ActionSupport {

    private List<Package> packages;
    private List<Integer> new_package_ids;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getNew_package_ids() {
        return new_package_ids;
    }

    public void setNew_package_ids(List<Integer> new_package_ids) {
        this.new_package_ids = new_package_ids;
    }

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
        setUser((User) ActionContext.getContext().getSession().get(RequestParameterName.USER));
        new_package_ids = MySqlPackageDao.getInstance().getNewPackageIds();
        setNew_package_ids(new_package_ids);

        return SUCCESS;
    }
}
