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


<div class="container">
    <h3>Посылки</h3>

    <ul class="collapsible" data-collapsible="expandable">
        <li ng-repeat="packagee in packages">
            <div class="collapsible-header">
                <div class="row item-header">
                    <span class="col offset-s1 s6"><b>Код отслеживания:</b> {{packagee.trackNumber}} </span>
                    <%--<span ng-if="{{package.deleted}}" class="col s3 offset-s1"><b>Статус:</b> Удалена </span>--%>
                    <span ng-if="{{package.deleted}} == false" class="col s3 offset-s1"><b>Статус:</b> {{packagee.status}} </span>
                    <i class="material-icons right">arrow_drop_down</i>
                </div>
            </div>
            <%--<div class="collapsible-body item">
                <div class="row">
                    <span class="col s6 offset-s1"><b>Тип посылки:</b> {{packagee.type}}</span>
                    <span class="col s3 offset-s1 package-align"><b>Дата:</b> {{packagee.date}}</span>

                    <a class="waves-effect waves-light btn col s1 dropdown-button"
                       data-activates='dropdown{{packagee.idPackage}}'><i class="material-icons">file_download</i></a>

                    <s:url action="downloadPackageDoc" var="xlsUrl">
                        <s:param name="doc_type">xls</s:param>
                        <s:param name="package_id">{{packagee.idPackage}}</s:param>
                    </s:url>

                    <s:url action="downloadPackageDoc" var="pdfUrl">
                        <s:param name="doc_type">pdf</s:param>
                        <s:param name="package_id">{{packagee.idPackage}}</s:param>
                    </s:url>

                    <s:url action="downloadPackageDoc" var="csvUrl">
                        <s:param name="doc_type">csv</s:param>
                        <s:param name="package_id">{{packagee.idPackage}}</s:param>
                    </s:url>

                    <ul id='dropdown{{packagee.idPackage}}' class='dropdown-content'>
                        <li>
                            <s:a href="%{xlsUrl}">XLS</s:a>
                        </li>
                        <li>
                            <s:a href="%{pdfUrl}">PDF</s:a>
                        </li>
                        <li>
                            <s:a href="%{csvUrl}">CSV</s:a>
                        </li>
                    </ul>

                </div>
                <div class="row">
                    <span class="col s6 offset-s1"><b>Отправитель:</b> {{packagee.senderName}}</span>
                    <span class="col s3 package-align"><b>Получатель:</b> {{packagee.getterUser.secondName}} {{packagee.getterUser.firstName}}</span>

                    <form ng-if="{{packagee.deleted == false}}" action="deletePackage.action" method="post">
                        <input type="hidden" name="packageId" value="{{packagee.idPackage}}">
                        <button type="submit" class="waves-effect waves-light btn col s1 red lighten-1">
                            <i class="material-icons">delete</i>
                        </button>
                    </form>
                </div>

                <div class="row">
                    <span class="col s6 offset-s1"><b>Почтовый индекс:</b> {{packagee.postIndex}}</span>
                    <span class="col s3 package-align"><b>Адрес:</b> {{packagee.address}} </span>

                    <c:if test="${(user.userRole == 'POST_MANAGER')}">
                        <c:forEach var="pack_id" items="${new_package_ids}">
                            <c:if test="${pack_id == packagee.idPackage}">
                                <a class="waves-effect waves-light btn col s1 dropdown-button"
                                   data-activates='managerdropdown${packagee.idPackage}'><i
                                        class="material-icons">check</i></a>

                                <s:url namespace="/managerr" action="prepareDataForAdvertisementCreation"
                                       var="addAdvertisementUrl">
                                    <s:param name="package_id">${packagee.idPackage}</s:param>
                                </s:url>

                                <s:url namespace="/managerr" action="rejectPackage" var="rejectPackUrl">
                                    <s:param name="package_id">${packagee.idPackage}</s:param>
                                </s:url>

                                <ul id='managerdropdown${packagee.idPackage}' class='dropdown-content'>
                                    <li>
                                        <s:a href="%{addAdvertisementUrl}">
                                            <i class="material-icons">check</i>
                                        </s:a>
                                    </li>
                                    <li>
                                        <s:a href="%{rejectPackUrl}">
                                            <i class="material-icons">close</i>
                                        </s:a>
                                    </li>
                                </ul>
                            </c:if>
                        </c:forEach>
                    </c:if>

                </div>

            </div>--%>
        </li>
    </ul>
</div>

