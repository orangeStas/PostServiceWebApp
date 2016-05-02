package by.bsuir.spp.action.advertisement;

import by.bsuir.spp.bean.Passport;
import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.Advertisement;
import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.dao.AdvertisementDao;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlAdvertisementDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import com.opensymphony.xwork2.ActionSupport;

public class SelectAdvertisementAction extends ActionSupport {
    private Passport passport;
    private Advertisement advertisement;
    private Package packagee;
    private String package_id;

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public Package getPackagee() {
        return packagee;
    }

    public void setPackagee(Package packagee) {
        this.packagee = packagee;
    }

    @Override
    public String execute() throws Exception {
        AdvertisementDao advertisementDao = MySqlAdvertisementDao.getInstance();
        PackageDao packageDao = MySqlPackageDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();
        UserDao userDao = MySqlUserDao.getInstance();

        int idPackageOfAdvertisement = Integer.parseInt(getPackage_id());

        by.bsuir.spp.bean.document.Package packagee = packageDao.read(idPackageOfAdvertisement);
        User user = userDao.read(packagee.getGetterUser().getId());
        packagee.setGetterUser(user);
        Passport passport = passportDao.read(packagee.getPassportId());
        Advertisement advertisement = advertisementDao.read(idPackageOfAdvertisement);
        setPassport(passport);
        setPackagee(packagee);
        setAdvertisement(advertisement);

        return SUCCESS;
    }
}
