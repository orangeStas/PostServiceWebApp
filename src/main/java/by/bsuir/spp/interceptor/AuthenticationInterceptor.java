package by.bsuir.spp.interceptor;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.controller.constant.RequestParameterName;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.StrutsStatics;

import java.util.Map;

public class AuthenticationInterceptor extends AbstractInterceptor implements StrutsStatics {

    private static final long serialVersionUID = -213L;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
        User user = (User) sessionAttributes.get(RequestParameterName.USER);

        if (user == null) {
            return Action.LOGIN;
        }
        else {
            Action action = (Action) actionInvocation.getAction();
            if (action instanceof UserAware) {
                ((UserAware) action).setUser(user);
            }
            return actionInvocation.invoke();
        }
    }
}
