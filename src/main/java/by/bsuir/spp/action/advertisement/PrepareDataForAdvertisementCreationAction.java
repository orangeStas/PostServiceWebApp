package by.bsuir.spp.action.advertisement;

import by.bsuir.spp.bean.Passport;
import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class PrepareDataForAdvertisementCreationAction extends ActionSupport {

    private String package_id;

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    private Passport passport;
    private Package packagee;
    private List<Integer> passport_ids;
    private List<Integer> package_ids;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Package getPackagee() {
        return packagee;
    }

    public void setPackagee(Package packagee) {
        this.packagee = packagee;
    }

    public List<Integer> getPassport_ids() {
        return passport_ids;
    }

    public void setPassport_ids(List<Integer> passport_ids) {
        this.passport_ids = passport_ids;
    }

    public List<Integer> getPackage_ids() {
        return package_ids;
    }

    public void setPackage_ids(List<Integer> package_ids) {
        this.package_ids = package_ids;
    }

    @Override
    public String execute() throws Exception {
        PackageDao packageDao = MySqlPackageDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();
        UserDao userDao = MySqlUserDao.getInstance();

        List<Integer> packageIds = packageDao.getPackageIds();
        List<Integer> passportIds = passportDao.getIdPassports();

        Package packagee = packageDao.read(Integer.parseInt(getPackage_id()));
        User user = userDao.read(packagee.getGetterUser().getId());
        packagee.setGetterUser(user);
        Passport passport = passportDao.read(packagee.getPassportId());

        setPassport(passport);
        setPackagee(packagee);
        setPassport_ids(passportIds);
        setPackage_ids(packageIds);
        setPackage_id(getPackage_id());

        return SUCCESS;

    }
}
