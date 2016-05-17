package by.bsuir.spp.action.prepaymentbook;

import by.bsuir.spp.bean.document.PrepaymentBookStatement;
import by.bsuir.spp.controller.constant.RequestParameterName;
import by.bsuir.spp.dao.PrepaymentBookDao;
import by.bsuir.spp.dao.impl.MySqlPrepaymentBookDao;
import by.bsuir.spp.documentgenerator.DocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.CsvDocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.PdfDocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.XlsDocumentGenerator;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

public class DownloadPrepaymentBookDocAction extends ActionSupport {
    private String doc_type;
    private String prepayment_book_number;


    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        int bookNumber = Integer.parseInt(request.getParameter("prepayment_book_number"));
        PrepaymentBookDao prepaymentBookDao = MySqlPrepaymentBookDao.getInstance();
        PrepaymentBookStatement prepaymentBookStatement = prepaymentBookDao.read(bookNumber);
        String fileName = URLEncoder.encode("PrepaymentBook_" + prepaymentBookStatement.getClientName(), "UTF-8");

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
                pdfDocumentGenerator.generatePrepaymentBook(prepaymentBookStatement, response.getOutputStream());
                break;
            }
            case "xls": {
                fileName += ".xls";
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                documentGenerator = XlsDocumentGenerator.getInstance();
                documentGenerator.generatePrepaymentBook(prepaymentBookStatement, response.getOutputStream());
                break;
            }
            case "csv": {
                fileName += ".csv";
                response.setContentType("text/csv");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                documentGenerator = CsvDocumentGenerator.getInstance();
                documentGenerator.generatePrepaymentBook(prepaymentBookStatement, response.getOutputStream());
                break;
            }
        }

        return INPUT;
    }
}
