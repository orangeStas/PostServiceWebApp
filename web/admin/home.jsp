<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 3/8/2016
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html ng-app="app">
<head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/styles.css"/>" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="utf-8">

    <s:url var="ctxUrl" forceAddSchemeHostAndPort="true" includeContext="true" value="/" namespace="/" ></s:url>
    <base href="<s:property value="ctxUrl"/>">

    <title>Паштовы сервис</title>
</head>
<body>

<div class="wrapper" style="background-image: url(/image/blurred3.jpg); background-size: 100%">

    <jsp:include page="/menu.jsp"/>
    <div ng-view></div>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
        <script src="<s:url value="/js/lib/angular/angular.min.js" />"></script>
        <script src="<s:url value="/js/lib/angular/angular-route.min.js" />"></script>
        <script src="<s:url value="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-cookies.js" />"></script>
        <script src="<s:url value="/js/angular/app.js" />"></script>
        <script src="<s:url value="/js/angular/services/services.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/receipt/receipt.service.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/package/package.service.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/prepaymentbook/prepaymentbook.service.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/user/user.service.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/searchstatement/searchstatement.service.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/advertisement/advertisement.service.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/receipt/receipt.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/receipt/delete_receipt.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/package/controllers/package.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/package/controllers/download.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/package/controllers/delete_package.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/searchstatement/controllers/searchstatement.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/searchstatement/controllers/selectstatement.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/searchstatement/controllers/updatesearchstatement.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/searchstatement/controllers/delete_search_statement.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/advertisement/advertisement.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/prepaymentbook/controllers/prepaymentbook.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/prepaymentbook/controllers/delete_book.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/prepaymentbook/controllers/selectprepaymentbook.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/prepaymentbook/controllers/update_prepayment_book.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/user/controllers/user.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/user/controllers/select_user.controller.js" />"></script>
        <script src="<s:url value="/js/angular/controllers/user/controllers/update_user.controller.js" />"></script>
        <script src="<s:url value="/js/angular/logout.controller.js" />"></script>
    <jsp:include page="/footer.jsp"/>
