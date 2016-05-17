<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 2/25/2016
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
<script>$('.collapsible').collapsible();</script>
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
    <h3>Заявление поиска посылки</h3>

    <form ng-controller="UpdateSearchStatementController" enctype="multipart/form-data" accept-charset="UTF-8" method="post"
          enctype="multipart/form-data" accept-charset="UTF-8">

        <div class="row">
            <div class="input-field col s12">
                    <textarea id="petition_content" ng-model="search_statement.petitionContent"
                              class="materialize-textarea" required name="petition_content"
                              placeholder="Утеряна посылка">{{search_statement.petitionContent}}</textarea>
                <label for="petition_content">Содержание завления</label>
            </div>
        </div>

        <div class="row">

            <div class="input-field col s6">
                <input required type="text" ng-model="search_statement.postManagerName" name="post_manager_name"
                       value="{{search_statement.postManagerName}}"
                       placeholder="Стасюкевич С.Ю." maxlength="45" id="post_manager_name" class="validate">
                <label for="post_manager_name">Менеджер</label>
            </div>

            <div class="input-field col s6">
                <input required type="text" ng-model="search_statement.address" name="search_statement.address"
                       value="{{search_statement.address}}"
                       placeholder="г. Гродно, ул. Гастелло 17, кв. 1" maxlength="45"
                       id="search_statement_address" class="validate">

                <label for="search_statement_address">Адрес</label>
            </div>

        </div>

        <div class="row">
            <div class="input-field col s6">
                <input required type="text" ng-model="search_statement.phoneNumber" name="phone_number"
                       value="{{search_statement.phoneNumber}}"
                       placeholder="375291234567" maxlength="13" id="phone_number" class="validate">
                <label for="phone_number">Телефон</label>
            </div>

            <div class="input-field col s6">
                <input required type="date" ng-model="search_statement.currentDate" name="date"
                       value="{{search_statement.currentDate}}" id="date"
                       class="datepicker">
                <label for="date">Дата</label>
            </div>

        </div>

        <input type="hidden" readonly ng-model="search_statement.passport.passportId" name="passport_id" value="{{search_statement.passport.passportId}}">
        <input type="hidden" ng-model="search_statement.postPackage.idPackage" name="package_id" value="{{search_statement.postPackage.idPackage}}">

        <div class="row right">

            <a href="/loadSearchStatements.action" class="btn waves-effect waves-light light-blue lighten-1"><i class="material-icons">arrow_back</i></a>

            <button class="btn waves-effect waves-light" ng-click="updateSearchStatement()" type="submit" name="action">
                <i class="material-icons">check</i>
            </button>
        </div>
    </form>
</div>

