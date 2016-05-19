<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 2/25/2016
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
<script>
    $(document).ready(function () {
        $(".button-collapse").sideNav();
        $('select').material_select();
        $('.parallax').parallax();
        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15 // Creates a dropdown of 15 years to control year
        });
    });
</script>
<div class="container">
    <h3>Заявление о восстановлении авансовой книжки</h3>

    <form ng-controller="UpdatePrepaymentBookController" method="post" enctype="multipart/form-data" accept-charset="UTF-8">

        <div class="row">
            <div class="input-field col s6">

                <input type="text" ng-model="prepayment_book.clientName" required name="client_name"
                       value="{{prepayment_book.clientName}}"
                       placeholder="Полищук Д.А." maxlength="45" id="client_name" class="validate">
                <label for="client_name">Имя клиента</label>
            </div>

            <div class="input-field col s6">
                <input required ng-model="prepayment_book.clientNumber" name="client_number"
                       value="{{prepayment_book.clientNumber}}" placeholder="28"
                       maxlength="7" id="client_number" type="text" class="validate">
                <label for="client_number">Номер клиента</label>
            </div>
        </div>

        <div class="row">

            <div class="input-field col s6">
                <input required name="date" ng-model="prepayment_book.date" value="{{prepayment_book.date}}" id="date" type="date"
                       class="datepicker">
                <label for="date">Дата</label>
            </div>


            <input type="hidden" ng-model="prepayment_book.passportId" id="passport_id" name="passport_id"
                   value="{{prepayment_book.passportId}}"
                   class="validate">

            <div class="input-field col s6">
                <input type="number" min="1" ng-model="prepayment_book.unpaidCost" required name="unpaid_cost"
                       value="{{prepayment_book.unpaidCost}}"
                       placeholder="50000" maxlength="10" id="unpaid_cost" class="validate">
                <label for="unpaid_cost">Сумма на счету</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input required name="organization_head_name" ng-model="prepayment_book.organizationHeadName"
                       value="{{prepayment_book.organizationHeadName}}"
                       placeholder="Стасюкевич С.Ю." maxlength="45" id="organization_head_name" type="text"
                       class="validate">
                <label for="organization_head_name">Глава организации</label>
            </div>

            <div class="input-field col s6">
                <input required name="bookkeeper_name" ng-model="prepayment_book.bookkeeperName"
                       value="{{prepayment_book.bookkeeperName}}"
                       placeholder="Цивако К.А." maxlength="45" id="bookkeeper_name" type="text" class="validate">
                <label for="bookkeeper_name">Бухгалтер</label>
            </div>
        </div>

        <div class="row right">

            <a href="/admin/loadPrepaymentBooks.action" class="btn waves-effect waves-light light-blue lighten-1"><i class="material-icons">arrow_back</i></a>

            <input type="hidden" ng-model="prepayment_book.statementNumber" readonly name="prepayment_book_number"
                   value="{{prepayment_book.statementNumber}}">
            <button class="btn waves-effect waves-light" ng-click="updatePrepaymentBook()" type="submit" name="action">
                <i class="material-icons">check</i>
            </button>

        </div>

    </form>

</div>