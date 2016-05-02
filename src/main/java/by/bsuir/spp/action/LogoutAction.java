package by.bsuir.spp.action;

import by.bsuir.spp.controller.constant.RequestParameterName;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LogoutAction extends ActionSupport implements SessionAware {
    private Map<String,Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {
        session.remove(RequestParameterName.USER);

        return SUCCESS;
    }
}
