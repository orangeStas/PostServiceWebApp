package by.bsuir.spp.action.advertisement;

import by.bsuir.spp.bean.document.Advertisement;
import by.bsuir.spp.dao.AdvertisementDao;
import by.bsuir.spp.dao.impl.MySqlAdvertisementDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class UpdateAdvertisementAction extends ActionSupport{

    private Advertisement advertisement;

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public String execute() throws Exception {
        AdvertisementDao advertisementDao = MySqlAdvertisementDao.getInstance();
        HttpServletRequest request = ServletActionContext.getRequest();

        Advertisement advertisement = getAdvertisement();
/*        advertisement.setCost(Integer.parseInt(request.getParameter(RequestParameterName.COST)));
        advertisement.setAddressForGetting(request.getParameter(RequestParameterName.PACKAGE_ADDRESS));
        advertisement.setWeight(Integer.parseInt(request.getParameter(RequestParameterName.WEIGHT)));
        by.bsuir.spp.bean.document.Package packagee = new Package();
        packagee.setIdPackage(Integer.parseInt(request.getParameter(RequestParameterName.PACKAGE_ID)));
        Passport passport = new Passport();
        passport.setPassportId(Integer.parseInt(request.getParameter(RequestParameterName.PASSPORT_ID)));
        advertisement.setPassport(passport);
        advertisement.setPostPackage(packagee);*/

        try {
            advertisementDao.update(advertisement);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }
}
