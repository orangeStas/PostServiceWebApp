<%@ page import="by.bsuir.spp.dao.impl.MySqlPackageDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Кирилл
  Date: 4/26/2016
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="nav-wrapper blue darken-1">
    <a href="" data-activates="slide-out" class="button-collapse show-on-large"><i class="material-icons">menu</i></a>
    <a href="home.jsp" class="brand-logo">ПАШТОВЫ СЕРВИС</a>

    <div class="row right">
        <a href="logout.action" class="waves-effect waves-light btn red lighten-1"><i class="material-icons auth">power_settings_new</i></a>
    </div>

    <ul id="slide-out" class="side-nav">
        <li class="user-name blue darken-1">${user.firstName} ${user.secondName} </li>

        <%
            int countNewPackages = MySqlPackageDao.getInstance().getNewPackageIds().size();
        %>

        <c:choose>
            <c:when test="${user.userRole == 'ADMIN'}">

                <li><a href="<s:url action="loadPackages" namespace="/admin"/>">Посылки</a></li>
                <li><a href="<s:url action="loadUsers" namespace="/admin"/> ">Пользователи</a></li>
                <li><a href="<s:url action="loadReceipts" namespace="/admin"/> ">Квитанции</a></li>
                <li><a href="<s:url action="loadAdvertisements" namespace="/admin"/> ">Извещения</a></li>
                <li><a href="<s:url action="loadSearchStatements" namespace="/admin"/> ">Поиск посылки</a></li>
                <li><a href="<s:url action="loadPrepaymentBooks" namespace="/admin"/> ">Авансовые книжки</a></li>

            </c:when>

            <c:when test="${user.userRole == 'POST_MANAGER'}">

                <li><a href="<s:url action="loadPackages" namespace="/managerr"/>">Посылки <b><%out.print(countNewPackages);%></b></a></li>
                <li><a href="<s:url action="loadAdvertisements" namespace="/managerr"/>">Извещения</a></li>
                <li><a href="<s:url action="loadSearchStatements" namespace="/managerr"/>">Поиск посылки</a></li>
                <li><a href="<s:url action="loadPrepaymentBooks" namespace="/managerr"/>">Авансовые книжки</a></li>

            </c:when>

            <c:when test="${user.userRole == 'CLIENT'}">

                <li><a href="<s:url action="loadUserPackages" namespace="/client"/>">Посылки</a></li>
                <li><a href="<s:url action="loadUserReceipts" namespace="/client"/>">Квитанции</a></li>
                <li><a href="<s:url action="loadUserAdvertisements" namespace="/client"/>">Извещения</a></li>
                <li><a href="<s:url action="loadUserSearchStatements" namespace="/client"/>">Поиск посылки</a></li>
                <li><a href="<s:url action="loadUserPrepaymentBooksAction" namespace="/client"/>">Авансовые книжки</a></li>

            </c:when>
        </c:choose>

    </ul>

</nav>