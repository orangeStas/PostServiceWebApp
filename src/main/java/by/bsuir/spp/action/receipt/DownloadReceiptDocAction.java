package by.bsuir.spp.action.receipt;

import by.bsuir.spp.bean.document.Receipt;
import by.bsuir.spp.dao.ReceiptDao;
import by.bsuir.spp.dao.impl.MySqlReceiptDao;
import by.bsuir.spp.documentgenerator.DocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.CsvDocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.PdfDocumentGenerator;
import by.bsuir.spp.documentgenerator.impl.XlsDocumentGenerator;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

public class DownloadReceiptDocAction extends ActionSupport {
    private String doc_type;
    private String receipt_id;

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(String receipt_id) {
        this.receipt_id = receipt_id;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        int idReceipt = Integer.parseInt(getReceipt_id());
        ReceiptDao receiptDao = MySqlReceiptDao.getInstance();
        Receipt receipt = receiptDao.read(idReceipt);

        String fileName = URLEncoder.encode("Receipt_" + receipt.getClientName(), "UTF-8");

        String docType = getDoc_type();
        DocumentGenerator documentGenerator;
        switch (docType) {
            case "pdf": {
                fileName += ".pdf";
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                PdfDocumentGenerator pdfDocumentGenerator = (PdfDocumentGenerator) PdfDocumentGenerator.getInstance();
                pdfDocumentGenerator.setIMAGE_BACK(request.getServletContext().getRealPath("/image/background.jpg"));
                pdfDocumentGenerator.generateReceipt(receipt, response.getOutputStream());
                break;
            }
            case "xls": {
                fileName += ".xls";
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                documentGenerator = XlsDocumentGenerator.getInstance();
                documentGenerator.generateReceipt(receipt, response.getOutputStream());
                break;
            }
            case "csv": {
                fileName += ".csv";
                response.setContentType("text/csv");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                documentGenerator = CsvDocumentGenerator.getInstance();
                documentGenerator.generateReceipt(receipt, response.getOutputStream());
                break;
            }
        }

        return INPUT;
    }
}
