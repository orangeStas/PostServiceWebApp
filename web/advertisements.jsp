<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 2/24/2016
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />


<div class="container">
    <h3>Извещения</h3>

    <ul class="collapsible" data-collapsible="expandable">
        <c:forEach var="advertisement" items="${advertisements}">
            <li>
                <div class="collapsible-header">
                    <div class="row item-header">
                        <span class="col offset-s1 s6"><b>Адрес:</b> ${advertisement.addressForGetting} </span>
                        <span class="col s3 offset-s1"><b>Тип посылки:</b> ${advertisement.postPackage.type} </span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </div>
                </div>
                <div class="collapsible-body item">
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Вес посылки:</b> ${advertisement.weight} </span>
                        <span class="col s3 package-align"><b>Стоимость:</b> ${advertisement.cost} </span>

                        <a class="waves-effect waves-light btn col s1 dropdown-button" data-activates='dropdown${advertisement.postPackage.idPackage}'><i class="material-icons">file_download</i></a>

                        <s:url action="downloadAdvertisementDoc" var="xlsUrl">
                            <s:param name="doc_type">xls</s:param>
                            <s:param name="package_id">${advertisement.postPackage.idPackage}</s:param>
                        </s:url>

                        <s:url action="downloadAdvertisementDoc" var="pdfUrl">
                            <s:param name="doc_type">pdf</s:param>
                            <s:param name="package_id">${advertisement.postPackage.idPackage}</s:param>
                        </s:url>

                        <s:url action="downloadAdvertisementDoc" var="csvUrl">
                            <s:param name="doc_type">csv</s:param>
                            <s:param name="package_id">${advertisement.postPackage.idPackage}</s:param>
                        </s:url>

                        <ul id='dropdown${advertisement.postPackage.idPackage}' class='dropdown-content'>
                            <li><s:a href="%{xlsUrl}">XLS</s:a></li>
                            <li><s:a href="%{pdfUrl}">PDF</s:a></li>
                            <li><s:a href="%{csvUrl}">CSV</s:a></li>
                        </ul>

                    </div>
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Номер паспорта:</b> ${advertisement.passport.passportNumber}</span>

                        <form action="deleteAdvertisement.action" method="get" enctype="multipart/form-data">
                            <input type="hidden" name="package_id" value="${advertisement.postPackage.idPackage}">
                            <button type="submit" class="waves-effect waves-light btn col s1 red lighten-1 right btn-align">
                                <i class="material-icons">delete</i>
                            </button>
                        </form>
                    </div>

                    <div class="row">

                        <form action="selectAdvertisement.action" method="get" enctype="multipart/form-data">
                            <input type="hidden" name="package_id" value="${advertisement.postPackage.idPackage}">
                            <button type="submit" class="waves-effect waves-light btn col s1 green lighten-1 right btn-align">
                                <i class="material-icons">mode_edit</i>
                            </button>
                        </form>
                    </div>

                </div>
            </li>
        </c:forEach>
    </ul>

</div>

<jsp:include page="footer.jsp" />