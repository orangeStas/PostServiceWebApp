package by.bsuir.spp.action._package;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

public class AddPackageAction extends ActionSupport {
    private String package_type;
    private String package_sender_name;
    private  String package_getter_name;
    private String package_address;
    private String package_post_index;

    public String getPackage_type() {
        return package_type;
    }

    public void setPackage_type(String package_type) {
        this.package_type = package_type;
    }

    public String getPackage_sender_name() {
        return package_sender_name;
    }

    public void setPackage_sender_name(String package_sender_name) {
        this.package_sender_name = package_sender_name;
    }

    public String getPackage_getter_name() {
        return package_getter_name;
    }

    public void setPackage_getter_name(String package_getter_name) {
        this.package_getter_name = package_getter_name;
    }

    public String getPackage_address() {
        return package_address;
    }

    public void setPackage_address(String package_address) {
        this.package_address = package_address;
    }

    public String getPackage_post_index() {
        return package_post_index;
    }

    public void setPackage_post_index(String package_post_index) {
        this.package_post_index = package_post_index;
    }

    @Override
    public String execute() throws Exception {
        Package myPackage = new Package();
        myPackage.setType(getPackage_type());
        myPackage.setDate(new Date());
        myPackage.setSenderName(package_sender_name);
        myPackage.setGetterUser(new User(){{
            setId(Integer.parseInt(getPackage_getter_name()));
        }});
        myPackage.setAddress(getPackage_address());
        myPackage.setPassportId(((User) ActionContext.getContext().getSession().get(RequestParameterName.USER)).getPassport().getPassportId());
        myPackage.setPostIndex(Integer.parseInt(getPackage_post_index()));

        PackageDao packageDao = MySqlPackageDao.getInstance();
        int packId = packageDao.create(myPackage);

        packageDao.addPackageToNewPackages(packId);

        return SUCCESS;
    }
}
