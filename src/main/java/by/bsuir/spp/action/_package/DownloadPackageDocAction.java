package by.bsuir.spp.action._package;

import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import by.bsuir.spp.documentgenerator.DocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.CsvDocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.PdfDocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.XlsDocumentGenerator;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

public class DownloadPackageDocAction extends ActionSupport {
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
        int packageId = Integer.parseInt(getPackage_id());
        PackageDao packageDao = MySqlPackageDao.getInstance();
        UserDao userDao = MySqlUserDao.getInstance();
        by.bsuir.spp.bean.document.Package myPackage = null;

        try {
            myPackage = packageDao.read(packageId);
            myPackage.setGetterUser(userDao.read(myPackage.getGetterUser().getId()));
        } catch (DaoException e) {
            e.printStackTrace();
        }

        String fileName = "Package_" + myPackage.getSenderName();
        fileName = URLEncoder.encode(fileName, "UTF-8");

        String docType = getDoc_type();

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        DocumentGenerator documentGenerator;
        switch (docType) {
            case "pdf" : {
                fileName += ".pdf";
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                PdfDocumentGenerator pdfDocumentGenerator = (PdfDocumentGenerator) PdfDocumentGenerator.getInstance();
                pdfDocumentGenerator.setIMAGE_BACK(request.getServletContext().getRealPath("/image/background.jpg"));
                pdfDocumentGenerator.generatePackage(myPackage, response.getOutputStream());
                break;
            }
            case "xls" : {
                fileName += ".xls";
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                documentGenerator = XlsDocumentGenerator.getInstance();
                documentGenerator.generatePackage(myPackage, response.getOutputStream());
                break;
            }
            case "csv" : {
                fileName += ".csv";
                response.setContentType("text/csv");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                documentGenerator = CsvDocumentGenerator.getInstance();
                documentGenerator.generatePackage(myPackage, response.getOutputStream());
                break;
            }
        }

        return INPUT;
    }
}
