package by.bsuir.spp.action.advertisement;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.UserType;
import by.bsuir.spp.bean.document.Advertisement;
import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.AdvertisementDao;
import by.bsuir.spp.dao.impl.MySqlAdvertisementDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAdvertisementAction extends ActionSupport {
    private String package_id;

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    @Override
    public String execute() throws Exception {
        int idPackageForAdvertisement = Integer.parseInt(getPackage_id());

        AdvertisementDao advertisementDao = MySqlAdvertisementDao.getInstance();
        Advertisement advertisement = new Advertisement();
        by.bsuir.spp.bean.document.Package packagee = new Package();
        packagee.setIdPackage(idPackageForAdvertisement);
        advertisement.setPostPackage(packagee);
        advertisementDao.delete(advertisement);

        UserType userType = ((User) ActionContext.getContext().getSession().get(RequestParameterName.USER)).getUserRole();

        switch (userType) {
            case CLIENT: {
                return "client";
            }
            case ADMIN: {
                return "admin";
            }
            default:
            {
                return "manager";
            }
        }

    }
}
