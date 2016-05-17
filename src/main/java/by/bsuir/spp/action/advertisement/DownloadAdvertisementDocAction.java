package by.bsuir.spp.action.advertisement;

import by.bsuir.spp.bean.Passport;
import by.bsuir.spp.bean.User;
import by.bsuir.spp.bean.document.Advertisement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.AdvertisementDao;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.PassportDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlAdvertisementDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlPassportDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import by.bsuir.spp.documentgenerator.DocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.CsvDocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.PdfDocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.XlsDocumentGenerator;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

public class DownloadAdvertisementDocAction extends ActionSupport {
    private String doc_type;
    private String package_id;

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        AdvertisementDao advertisementDao = MySqlAdvertisementDao.getInstance();
        PackageDao packageDao = MySqlPackageDao.getInstance();
        PassportDao passportDao = MySqlPassportDao.getInstance();
        UserDao userDao = MySqlUserDao.getInstance();

        int idPackageOfAdvertisement = Integer.parseInt(request.getParameter(RequestParameterName.PACKAGE_ID));
        String docType = request.getParameter(RequestParameterName.DOC_TYPE);

        by.bsuir.spp.bean.document.Package packagee = packageDao.read(
                Integer.parseInt(request.getParameter(RequestParameterName.PACKAGE_ID)));
        User user = userDao.read(packagee.getGetterUser().getId());
        packagee.setGetterUser(user);
        Passport passport = passportDao.read(packagee.getPassportId());
        Advertisement advertisement = advertisementDao.read(idPackageOfAdvertisement);
        advertisement.setPassport(passport);
        advertisement.setPostPackage(packagee);

        String fileName = URLEncoder.encode("Advertisement_" + advertisement.getPostPackage().getGetterUser().getSecondName(), "UTF-8");

        DocumentGenerator documentGenerator;
        switch (docType) {
            case "pdf" : {
                fileName += ".pdf";
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                PdfDocumentGenerator pdfDocumentGenerator = (PdfDocumentGenerator) PdfDocumentGenerator.getInstance();
                pdfDocumentGenerator.setIMAGE_BACK(request.getServletContext().getRealPath("/image/background.jpg"));
                pdfDocumentGenerator.generateAdvertisement(advertisement, response.getOutputStream());
                break;
            }
            case "xls" : {
                fileName += ".xls";
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                documentGenerator = XlsDocumentGenerator.getInstance();
                documentGenerator.generateAdvertisement(advertisement, response.getOutputStream());
                break;
            }
            case "csv" : {
                fileName += ".csv";
                response.setContentType("text/csv");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                documentGenerator = CsvDocumentGenerator.getInstance();
                documentGenerator.generateAdvertisement(advertisement, response.getOutputStream());
                break;
            }
        }

        return INPUT;

    }
}
