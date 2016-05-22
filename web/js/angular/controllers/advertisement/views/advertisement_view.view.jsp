<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 2/24/2016
  Time: 9:15 PM
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

    <h3>Извещение</h3>

    <form ng-controller="UpdateAdvertisementController" enctype="multipart/form-data" accept-charset="UTF-8"
          method="post">

        <div class="row">
            <div ng-model="advertisement.postPackage.senderName" class="col s4">
                <b>Отправитель:</b> {{advertisement.postPackage.senderName}}
            </div>

            <div class="col s4">
                <b>Получатель:</b> {{advertisement.postPackage.getterUser.secondName}}
                {{advertisement.postPackage.getterUser.firstName}}
            </div>

            <div class="col s4">
                <b>Дата отправления:</b> {{advertisement.postPackage.date}}
            </div>
        </div>

        <div class="row">
            <div class="input-field col s4">
                <input type="text" id="package_address" ng-model="advertisement.addressForGetting" class="validate" required name="package_address"
                       value="{{advertisement.addressForGetting}}"/>
                <label for="package_address">Адрес доставки</label>
            </div>

            <div class="input-field col s4">
                <input type="number" ng-model="advertisement.weight" id="weight" min="1" class="validate" required name="weight"
                       value="{{advertisement.weight}}" maxlength="10"/>
                <label for="weight">Вес</label>
            </div>

            <div class="input-field col s4">
                <input type="number" ng-model="advertisement.cost" id="cost" min="1" class="validate" required name="cost"
                       value="{{advertisement.cost}}" maxlength="10">
                <label for="cost">Стоимость доставки</label>
            </div>
        </div>

        <div class="row right">

            <a href="/admin/loadAdvertisements.action" class="btn waves-effect waves-light light-blue lighten-1"><i class="material-icons">arrow_back</i></a>

            <input type="hidden" ng-model="advertisement.postPackage.idPackage" value="{{advertisement.postPackage.idPackage}}">
            <button class="btn waves-effect waves-light" ng-click="updateAdvertisement()" type="submit" name="action">
                <i class="material-icons">check</i>
            </button>
        </div>
    </form>

</div>
