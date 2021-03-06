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


<nav class="nav-wrapper blue darken-1">
    <a href="/login.jsp" class="brand-logo">ПАШТОВЫ СЕРВИС</a>

    <div class="row right">
        <a href="/login.jsp" class="waves-effect waves-light btn"><i class="material-icons auth">input</i></a>
        <a href="/registration.jsp" class="waves-effect waves-light btn deep-orange lighten-1"><i class="material-icons auth">person_add</i></a>
    </div>
</nav>

<div class="row container">
    <h3>Авторизация</h3>

    <%--<s:form cssClass="col s12 login" action="login" method="post">
        <s:textfield name="login" label="Логин"/>
        <s:password name="password" label="Пароль"/>
        <s:submit value="Войти"/>
        <s:actionmessage/>
        <s:actionerror/>
    </s:form>--%>
    <form class="col s12 login" method="POST" action="login.action">

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix register">email</i>
                <input type="text" class="validate" name="login" id="loginInput">
                <label for="loginInput">Login</label>
            </div>

            <div class="input-field col s6">
                <i class="material-icons prefix register">vpn_key</i>
                <input type="password" class="validate" name="password" id="passwordInput">
                <label for="passwordInput">Пароль</label>
            </div>
        </div>
        <div class="row">
            <button class="right btn waves-effect waves-light" type="submit" name="action">
                <i class="material-icons">check</i>
            </button>
        </div>

    </form> <!-- End register form -->

</div>

<jsp:include page="footer.jsp" />
