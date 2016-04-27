<%--
  Created by IntelliJ IDEA.
  User: Кирилл
  Date: 2/21/2016
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Посылки</title>
</head>
<body>
<h1>Список посылок</h1>
<c:choose>
    <c:when test="${user.userRole == 'ADMIN'}">
        <a href="home_admin.jsp">домой</a>
    </c:when>
    <c:otherwise>
        <form action="home_manager.jsp">
            <input type="submit" value="домой">
        </form>
    </c:otherwise>
</c:choose>

<table align="center" border="2">
    <tr>
        <th>Тип посылки</th>
        <th>Дата</th>
        <th>Отправитель</th>
        <th>Получатель</th>
        <th>Адрес</th>
        <th>Почтовый индекс</th>
        <th>Статус</th>
    </tr>

    <s:iterator value="packages">
    <tr>
        <td><s:property value="type"/></td>
        <td><s:property value="date"/></td>
        <td><s:property value="senderName"/></td>
        <td><s:property value="getterUser.secondName"/> <s:property value="getterUser.firstName"/></td>
        <td><s:property value="address"/></td>
        <td><s:property value="postIndex"/></td>
        <td><s:property value="status"/></td>
        <td>
            <s:url id="selectPack" action="selectPackage" namespace="/admin">
                <s:param name="packageId" value="%{idPackage}"></s:param>
            </s:url>
            <s:a href="%{selectPack}">просмотреть</s:a>

            <s:if test="%{deleted == true}">
                <p>удалена</p>
            </s:if>
            <s:else>
                <s:url id="deletePack" action="deletePackage" namespace="/admin">
                    <s:param name="packageId" value="%{idPackage}"></s:param>
                </s:url>
                <s:a href="%{deletePack}">удалить</s:a>
            </s:else>

            <c:if test="${(user.userRole == 'POST_MANAGER')}">
                <c:forEach var="pack_id" items="${new_package_ids}">
                    <c:if test="${pack_id == packagee.idPackage}">
                        <form action="controller" enctype="multipart/form-data" method="get">
                            <input type="hidden" name="command" value="PREPARE_DATA_FOR_CREATION_ADVERTISEMENT">
                            <input type="hidden" name="package_id" value="${packagee.idPackage}">
                            <input type="submit" value="создать извещение">
                        </form>

                        <form action="controller" enctype="multipart/form-data" method="get">
                            <input type="hidden" name="command" value="reject_package">
                            <input type="hidden" name="package_id" value="${packagee.idPackage}">
                            <input type="submit" value="отклонить">
                        </form>
                    </c:if>
                </c:forEach>
            </c:if>
        </td>
    </tr>
    </s:iterator>
</table>

</body>
</html>