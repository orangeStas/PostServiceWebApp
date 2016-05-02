package by.bsuir.spp.action.searchstatement;

import by.bsuir.spp.bean.document.SearchPackageStatement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.SearchStatementDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlSearchStatementDao;
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

public class DownloadSearchStatementDocAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        int statementId = Integer.parseInt(request.getParameter(RequestParameterName.SEARCH_STATEMENT_ID));

        SearchStatementDao searchStatementDao = MySqlSearchStatementDao.getInstance();
        UserDao userDao = MySqlUserDao.getInstance();
        PackageDao packageDao = MySqlPackageDao.getInstance();

        SearchPackageStatement searchPackageStatement = searchStatementDao.read(statementId);
        searchPackageStatement.setPostPackage(packageDao.read(searchPackageStatement.getPostPackage().getIdPackage()));
        searchPackageStatement.getPostPackage().setGetterUser(userDao.read(searchPackageStatement.getPostPackage().getGetterUser().getId()));

        String fileName = URLEncoder.encode("Search_Pack_" + searchPackageStatement.getPostPackage().getType() + "_" +
                searchPackageStatement.getPostPackage().getSenderName(), "UTF-8");

        String docType = request.getParameter(RequestParameterName.DOC_TYPE);
        DocumentGenerator documentGenerator;
        switch (docType) {
            case "pdf": {
                fileName += ".pdf";
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                PdfDocumentGenerator pdfDocumentGenerator = (PdfDocumentGenerator) PdfDocumentGenerator.getInstance();
                pdfDocumentGenerator.setIMAGE_BACK(request.getServletContext().getRealPath("/image/background.jpg"));
                pdfDocumentGenerator.generateSearchStatement(searchPackageStatement, response.getOutputStream());
                break;
            }
            case "xls": {
                fileName += ".xls";
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                documentGenerator = XlsDocumentGenerator.getInstance();
                documentGenerator.generateSearchStatement(searchPackageStatement, response.getOutputStream());
                break;
            }
            case "csv": {
                fileName += ".csv";
                response.setContentType("text/csv");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                documentGenerator = CsvDocumentGenerator.getInstance();
                documentGenerator.generateSearchStatement(searchPackageStatement, response.getOutputStream());
                break;
            }
        }

        return INPUT;

    }
}
