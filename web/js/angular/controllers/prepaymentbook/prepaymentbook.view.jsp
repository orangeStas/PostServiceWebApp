<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="container">

    <h3>Заявления на восстановление авансовых книг</h3>

    <div ng-repeat="book in prepayment_books">
        <ul class="collapsible" data-collapsible="expandable">
            <li>
                <div class="collapsible-header">
                    <div class="row item-header">
                        <span class="col offset-s1 s5"><b>Организация:</b> {{book.organizationHeadName}} </span>
                        <span class="col s4 offset-s1"><b>Средства на счету:</b> {{book.unpaidCost}} </span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </div>
                </div>
                <div class="collapsible-body item">
                    <div class="row">
                        <span class="col s5 offset-s1"><b>Имя клиента:</b> {{book.clientName}}</span>
                        <span class="col s4 offset-s1 package-align"><b>Номер клиента:</b> {{book.clientNumber}}</span>

                        <a class="waves-effect waves-light btn col s1 dropdown-button"
                           data-activates='dropdown{{book.statementNumber}}'><i class="material-icons">file_download</i></a>

                        <ul id='dropdown{{book.statementNumber}}' class='dropdown-content'>
                            <li>
                                <a href="/downloadPrepaymentBookDoc.action?doc_type=xls&prepayment_book_number={{book.statementNumber}}" target="_self">XLS</a>
                            </li>
                            <li>
                                <a href="/downloadPrepaymentBookDoc.action?doc_type=pdf&prepayment_book_number={{book.statementNumber}}" target="_self">PDF</a>
                            </li>
                            <li>
                                <a href="/downloadPrepaymentBookDoc.action?doc_type=csv&prepayment_book_number={{book.statementNumber}}" target="_self">CSV</a>
                            </li>
                        </ul>

                    </div>
                    <div class="row">
                        <span class="col s5 offset-s1"><b>Бухгалтер:</b> {{book.bookkeeperName}}</span>
                        <span class="col s4 package-align"><b>Дата:</b> {{book.date}} </span>

                        <a href="/admin/deletePrepaymentBook.action/{{book.statementNumber}}" class="waves-effect waves-light btn col s1 red lighten-1">
                            <i class="material-icons">delete</i>
                        </a>
                    </div>

                    <div class="row">
<%--                            <input type="hidden" name="prepayment_book_number" value="{{book.statementNumber}}">--%>
                            <%--<button type="submit"
                                    class="waves-effect waves-light btn col s1 green right btn-align lighten-1">
                                <i class="material-icons">mode_edit</i>
                            </button>--%>
                            <a href="/selectPrepaymentBook.action/{{book.statementNumber}}" class="waves-effect waves-light btn col s1 offset-s11 green lighten-1" style="margin-left: 89.7%"><i class="material-icons">mode_edit</i></a>
                    </div>

                </div>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
<script>$('.collapsible').collapsible();</script>