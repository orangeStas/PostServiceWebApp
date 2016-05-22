<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="container">
    <h3>Заявления поиска посылки</h3>

    <div ng-repeat="statement in search_statements">
        <ul class="collapsible" data-collapsible="expandable">
            <li>
                <div class="collapsible-header">
                    <div class="row item-header">
                        <span class="col offset-s1 s6"><b>Посылка:</b> {{statement.postPackage.type}} - {{statement.postPackage.date}} </span>
                        <span class="col s3 offset-s1"><b>Дата:</b> {{statement.currentDate}} </span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </div>
                </div>
                <div class="collapsible-body item">
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Содержание заявления:</b> {{statement.petitionContent}} </span>
                        <span class="col s3 offset-s1 package-align"><b>Паспорт:</b> {{statement.passport.passportNumber}} </span>

                        <a class="waves-effect waves-light btn col s1 dropdown-button"
                           data-activates='dropdown{{statement.id}}'><i class="material-icons">file_download</i></a>

                        <ul id='dropdown{{statement.id}}' class='dropdown-content'>
                            <li>
                                <a href="/downloadSearchStatementDoc.action?search_statement_id={{statement.id}}&doc_type=xls" target="_self">XLS</a>
                            </li>
                            <li>
                                <a href="/downloadSearchStatementDoc.action?search_statement_id={{statement.id}}&doc_type=csv" target="_self">CSV</a>
                            </li>
                            <li>
                                <a href="/downloadSearchStatementDoc.action?search_statement_id={{statement.id}}&doc_type=pdf" target="_self">PDF</a>
                            </li>
                        </ul>

                    </div>
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Адрес:</b> {{statement.address}} </span>
                        <span class="col s3 package-align"><b>Телефон:</b> {{statement.phoneNumber}} </span>

                        <a href="/admin/deleteSearchStatement.action/{{statement.id}}" class="waves-effect waves-light btn col s1 red lighten-1">
                            <i class="material-icons">delete</i>
                        </a>
                    </div>

                    <div class="row">
                        <span class="col s6 offset-s1"><b>Менеджер:</b> {{statement.postManagerName}} </span>
                        <a href="/admin/selectSearchStatement.action/{{statement.id}}"
                           class="waves-effect waves-light btn col s1 green right btn-align" style="margin-right: 1.9%">
                            <i class="material-icons">mode_edit</i>
                        </a>
                    </div>

                </div>
            </li>
        </ul>
    </div>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
<script>$('.collapsible').collapsible();</script>
