package by.bsuir.spp.interceptor;

import by.bsuir.spp.bean.User;
import by.bsuir.spp.controller.constant.RequestParameterName;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.TextParseUtil;

import java.util.*;

public class RolesInterceptor extends AbstractInterceptor {

    private Map<String, Set> roleActions = Collections.emptyMap();

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        final String actionName = actionInvocation.getProxy().getActionName();
        Map session = actionInvocation.getInvocationContext().getSession();

        User user = (User) session.get(RequestParameterName.USER);

        if (acceptRights(user, actionName)) {
            return actionInvocation.invoke();
        }
        else {
            return Action.LOGIN;
        }
    }

    public void setRoleActions(String roleActionsParam) {
        StringTokenizer stringTokenizer = new StringTokenizer(roleActionsParam, ";");
        roleActions = new HashMap<>(stringTokenizer.countTokens());

        while (stringTokenizer.hasMoreTokens()) {
            String[] roleActionArray = stringTokenizer.nextToken().trim().split(":");
            if (roleActionArray.length == 2) {
                String role = roleActionArray[0];
                Set actions = TextParseUtil.commaDelimitedStringToSet(roleActionArray[1]);
                roleActions.put(role, actions);
            }
        }
    }

    private boolean acceptRights(User user, String actionName) {
        if (roleActions.containsKey("*") && roleActions.get("*").contains(actionName)) {
            return true;
        }

        if (user != null) {
            String userRole = user.getUserRole().toString().toLowerCase();

            if (roleActions.containsKey(userRole) &&
                    roleActions.get(userRole).contains(actionName)) {
                return true;
            }
        }

        return false;
    }


}
