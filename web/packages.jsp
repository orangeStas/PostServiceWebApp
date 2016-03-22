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
<html>
<head>
    <title></title>
</head>
<body>


    <form action="../home_admin.jsp">
        <input type="submit" value="home">
    </form>

  <table align="center" border="2">
    <tr>
      <th>Type</th>
      <th>Date</th>
      <th>Sender Name</th>
      <th>Getter Name</th>
      <th>Address</th>
      <th>Post Index</th>
      <th>Barcode</th>
    </tr>

    <c:forEach var="packagee" items="${packages}">
    <tr>
      <td>${packagee.type}</td>
      <td>${packagee.date}</td>
      <td>${packagee.senderName}</td>
      <td>${packagee.getterUser.secondName} ${packagee.getterUser.firstName}</td>
      <td>${packagee.address}</td>
      <td>${packagee.postIndex}</td>
      <td>${packagee.barCode}</td>
      <td>
        <form action="controller" enctype="multipart/form-data" method="post">
          <input type="hidden" name="command" value="PREPARE_DATA_FOR_CREATION_PACKAGE">
          <input type="hidden" name="package_id" value="${packagee.idPackage}">
          <input type="submit" value="open">
        </form>
        <form action="controller" enctype="multipart/form-data" method="post">
          <input type="hidden" name="command" value="delete_package">
          <input type="hidden" name="package_id" value="${packagee.idPackage}">
          <input type="submit" value="delete">
        </form>
      </td>
    </tr>
    </c:forEach>
  </table>

</body>
</html>
