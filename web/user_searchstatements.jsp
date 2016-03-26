<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 2/25/2016
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Заявления</title>
</head>
<body>

<form action="home.jsp">
  <input type="submit" value="домой">
</form>
<h1>Завяления поиска посылки</h1>
<table align="center" border="2">
  <tr>
    <th>Содержание завления</th>
    <th>Адресс</th>
    <th>Телефон</th>
    <th>Менеджер</th>
    <th>Дата</th>
  </tr>
  <c:forEach var="statement" items="${search_statements}">
    <tr>
      <td>${statement.petitionContent}</td>
      <td>${statement.address}</td>
      <td>${statement.phoneNumber}</td>
      <td>${statement.postManagerName}</td>
      <td>${statement.currentDate}</td>
      <td>
        <form action="controller" enctype="multipart/form-data" method="get">
          <input type="hidden" name="command" value="select_search_statement">
          <input type="hidden" name="search_statement_id" value="${statement.id}">
          <input type="submit" value="просмотреть">
        </form>
<%--        <form action="controller" enctype="multipart/form-data" method="post">
          <input type="hidden" name="command" value="delete_search_statement">
          <input type="hidden" name="search_statement_id" value="${statement.id}">
          <input type="submit" value="delete">
        </form>--%>
      </td>
    </tr>
  </c:forEach>
</table>

<form action="controller" enctype="multipart/form-data" method="get">
  <input type="hidden" name="command" value="prepare_data_for_creation_search_statement">
  <input type="submit" value="оформить новое заявление">
</form>
</body>
</html>
