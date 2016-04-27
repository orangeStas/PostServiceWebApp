package by.bsuir.spp.action._package;

import by.bsuir.spp.bean.Comment;
import by.bsuir.spp.bean.document.Package;
import by.bsuir.spp.dao.PackageCommentDao;
import by.bsuir.spp.dao.PackageDao;
import by.bsuir.spp.dao.UserDao;
import by.bsuir.spp.dao.impl.MySqlPackageCommentDao;
import by.bsuir.spp.dao.impl.MySqlPackageDao;
import by.bsuir.spp.dao.impl.MySqlUserDao;
import by.bsuir.spp.exception.dao.DaoException;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class SelectPackageAction extends ActionSupport {

    private List<Comment> comments;
    private by.bsuir.spp.bean.document.Package packagee;

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    private String packageId;


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public by.bsuir.spp.bean.document.Package getPackagee() {
        return packagee;
    }

    public void setPackagee(Package packagee) {
        this.packagee = packagee;
    }


    @Override
    public String execute() throws Exception {
        PackageDao packageDao = MySqlPackageDao.getInstance();
        UserDao userDao = MySqlUserDao.getInstance();
        PackageCommentDao packageCommentDao = MySqlPackageCommentDao.getInstance();

        try {
            setComments(packageCommentDao.getCommentsForPackage(Integer.parseInt(getPackageId())));
            setPackagee(packageDao.read(Integer.parseInt(getPackageId())));
        } catch (DaoException e) {
            return ERROR;
        }

        return SUCCESS;
    }
}
