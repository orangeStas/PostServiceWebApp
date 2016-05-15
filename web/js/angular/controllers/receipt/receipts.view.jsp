<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="container">
    <h3>Квитанции</h3>

    <div ng-repeat="receipt in receipts">
        <ul class="collapsible" data-collapsible="expandable">
            <li>
                <div class="collapsible-header">
                    <div class="row item-header">
                        <span class="col offset-s1 s6"><b>Имя плательщика:</b> {{receipt.clientName}} </span>
                        <span class="col s3 offset-s1"><b>Стоимость:</b> {{receipt.cost}} </span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </div>
                </div>
                <div class="collapsible-body item">
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Данные опдаты:</b> {{receipt.paymentData}} </span>
                        <span class="col s3 offset-s1 package-align"><b>Услуга:</b> {{receipt.serviceName}} </span>

                        <a class="waves-effect waves-light btn col s1 dropdown-button"
                           data-activates='dropdown{{receipt.receiptId}}'><i
                                class="material-icons">file_download</i></a>

                        <ul id='dropdown{{receipt.receiptId}}' class='dropdown-content'>
                            <li>
                                <a href="downloadReceiptDoc.action?receipt_id={{receipt.receiptId}}&doc_type=xls">XLS</a>
                            </li>
                            <li>
                                <a href="downloadReceiptDoc.action?receipt_id={{receipt.receiptId}}&doc_type=csv">CSV</a>
                            </li>
                            <li>
                                <a href="downloadReceiptDoc.action?receipt_id={{receipt.receiptId}}&doc_type=pdf">PDF</a>
                            </li>
                        </ul>

                    </div>
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Дата:</b> {{receipt.date}} </span>

                        <form action="deleteReceipt.action" enctype="multipart/form-data" method="get">
                            <input type="hidden" name="receipt_id" value="{{receipt.receiptId}}">
                            <button type="submit"
                                    class="waves-effect waves-light btn col s1 red lighten-1 right btn-align">
                                <i class="material-icons">delete</i>
                            </button>
                        </form>
                    </div>

                </div>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
<script>$('.collapsible').collapsible();</script>

