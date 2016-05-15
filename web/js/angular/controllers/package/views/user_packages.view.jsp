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
<%@ taglib prefix="s" uri="/struts-tags" %>


<div class="container">
    <h3>Мои посылки</h3>

    <a href="<s:url action="prepareDataForPackageCreation" namespace="/client"/>"
       class="btn waves-effect waves-light"><i class="material-icons">add</i></a>


    <div ng-repeat="packagee in packages">
        <ul class="collapsible" data-collapsible="expandable">
            <li>
                <div class="collapsible-header">
                    <div class="row item-header">
                        <span class="col offset-s1 s6"><b>Код отслеживания:</b> {{packagee.trackNumber}} </span>
                        <%--<span ng-if="{{package.deleted}}" class="col s3 offset-s1"><b>Статус:</b> Удалена </span>--%>
                        <span class="col s3 offset-s1"><b>Статус: </b>{{packagee.deleted ? 'Удалена' : packagee.status}}</span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </div>
                </div>
                <div class="collapsible-body item">
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Тип посылки:</b> {{packagee.type}}</span>
                        <span class="col s3 offset-s1 package-align"><b>Дата:</b> {{packagee.date}}</span>

                        <a class="waves-effect waves-light btn col s1 dropdown-button"
                           data-activates='dropdown{{packagee.idPackage}}'><i
                                class="material-icons">file_download</i></a>

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
                    </div>
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Почтовый индекс:</b> {{packagee.postIndex}}</span>
                        <span class="col s3 package-align"><b>Адрес:</b> {{packagee.address}} </span>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
<script>$('.collapsible').collapsible();</script>
