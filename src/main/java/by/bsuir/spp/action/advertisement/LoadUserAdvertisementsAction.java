package by.bsuir.spp.action.advertisement;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.Advertisement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.AdvertisementDao;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.impl.MySqlAdvertisementDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoadUserAdvertisementsAction extends ActionSupport {
    private List<Advertisement> advertisements;

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public String execute() throws Exception {
        AdvertisementDao advertisementDao = MySqlAdvertisementDao.getInstance();
        PackageDao packageDao = MySqlPackageDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();
        int passportId = ((User) ActionContext.getContext().getSession().get(RequestParameterName.USER)).getPassport().getPassportId();
        advertisements = advertisementDao.getAdvertisementsByPassportId(passportId);

        for (Advertisement advertisement : advertisements) {
            advertisement.setPostPackage(packageDao.read(advertisement.getPostPackage().getIdPackage()));
            advertisement.setPassport(passportDao.read(advertisement.getPassport().getPassportId()));
        }

        setAdvertisements(advertisements);

        return SUCCESS;
    }
}
