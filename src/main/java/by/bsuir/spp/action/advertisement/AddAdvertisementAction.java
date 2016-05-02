package by.bsuir.spp.action.advertisement;

import by.bsuir.spp.bean.Passport;
import by.bsuir.spp.bean.document.Advertisement;
import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.AdvertisementDao;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlAdvertisementDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class AddAdvertisementAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        AdvertisementDao advertisementDao = MySqlAdvertisementDao.getInstance();
        PackageDao packageDao = MySqlPackageDao.getInstance();
        UserDao userDao = MySqlUserDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();

        Advertisement advertisement = new Advertisement();
        advertisement.setCost(Integer.parseInt(request.getParameter(RequestParameterName.COST)));
        advertisement.setAddressForGetting(request.getParameter(RequestParameterName.PACKAGE_ADDRESS));
        advertisement.setWeight(Integer.parseInt(request.getParameter(RequestParameterName.WEIGHT)));

        int packageId = Integer.parseInt(request.getParameter(RequestParameterName.PACKAGE_ID));
        Package packagee = null;
        Passport passport = null;
        try {
            packagee = packageDao.read(packageId);
            passport = passportDao.read(userDao.read(packagee.getGetterUser().getId()).getPassport().getPassportId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        advertisement.setPassport(passport);
        advertisement.setPostPackage(packagee);

        try {
            advertisementDao.create(advertisement);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        packageDao.deleteNewPackage(packageId);
        packageDao.updateStatus(packageId, "принято");

        return SUCCESS;
    }

    private String getRequestParam(HttpServletRequest request, String parameterName) {
        return request.getParameter(parameterName);
    }
}
