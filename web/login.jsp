<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 3/8/2016
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="header.jsp" />

<%--<form method="POST" action="controller">
    <input type="hidden" name="command" value="login_command">

    <div>
        <input type="text" name="login_field" id="loginInput" placeholder="Логин">
    </div>

    <div>
        <input type="password" name="password" id="passwordInput" placeholder="Пароль">
    </div>

    <button type="submit">Войти</button>

    <c:if test="${not empty param['message']}">
        <p>invalid login or password</p>
    </c:if>
</form>--%>

<s:form action="login" method="post">
    <s:textfield name="login" label="Логин"/>
    <s:password name="password" label="Пароль"/>
    <s:submit value="Войти"/>
    <s:actionmessage/>
    <s:actionerror/>
</s:form>


<a href="registration.jsp">Зарегистрироваться</a>

<jsp:include page="footer.jsp" />
