<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 2/21/2016
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

<div class="container">
    <h3>Пользователи</h3>

    <ul class="collapsible" data-collapsible="expandable">
        <c:forEach var="userr" items="${users}">
            <li>
                <div class="collapsible-header">
                    <div class="row item-header">
                        <span class="col offset-s1 s6"><b>Логин:</b> ${userr.login} </span>
                        <span class="col s3 offset-s1"><b>Роль:</b> ${userr.userRole} </span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </div>
                </div>
                <div class="collapsible-body item">
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Пароль:</b> ${userr.password} </span>
                        <span class="col s3 offset-s1 package-align"><b>E-mail:</b> ${userr.email} </span>

                        <c:choose>
                            <c:when test="${(userr.userRole == 'ADMIN')}">
                                <c:if test="${admins_count > 1}">
                                    <form action="deleteUser.action" enctype="multipart/form-data" method="get">
                                        <input type="hidden" name="user_id" value="${userr.id}">
                                        <button type="submit" class="waves-effect waves-light btn col s1 red lighten-1">
                                            <i class="material-icons">delete</i>
                                        </button>
                                    </form>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <form action="deleteUser.action" enctype="multipart/form-data" method="get">
                                    <input type="hidden" name="user_id" value="${userr.id}">
                                    <button type="submit" class="waves-effect waves-light btn col s1 red lighten-1">
                                        <i class="material-icons">delete</i>
                                    </button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Имя:</b> ${userr.secondName} ${userr.firstName} ${userr.middleName} </span>
                        <span class="col s3 package-align"><b>Паспорт:</b> ${userr.passport.passportNumber} </span>

                        <form action="selectUser.action" enctype="multipart/form-data" method="get">
                            <input type="hidden" name="user_id" value="${userr.id}">
                            <button type="submit" class="waves-effect waves-light btn col s1 green lighten-1">
                                <i class="material-icons">mode_edit</i>
                            </button>
                        </form>
                    </div>

                    <div class="row">
                        <span class="col s6 offset-s1"><b>Адрес:</b> ${userr.passport.address} </span>
                    </div>

                </div>
            </li>
        </c:forEach>
    </ul>

</div>

<jsp:include page="footer.jsp" />