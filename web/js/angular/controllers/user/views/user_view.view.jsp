<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 2/21/2016
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <h3>Пользователь</h3>

    <form ng-controller="UpdateUserController" enctype="multipart/form-data" accept-charset="UTF-8" method="post">

        <input type="hidden" ng-model="userr.id" name="user_id" value="{{userr.id}}">
        <input type="hidden" name="userr.passport.passportId" value="{{userr.passport.passportId}}">

        <div class="row">
            <div class="input-field col s6">
                <input required name="login_field" ng-model="userr.login"  value="{{userr.login}}" id="login_field" type="text" class="validate">
                <label for="login_field">Логин</label>
            </div>

            <div class="input-field col s6">
                <input required name="sec_name" ng-model="userr.secondName" value="{{userr.secondName}}" placeholder="Иванов" maxlength="15" id="sec_name" type="text" class="validate">
                <label for="sec_name">Фамилия</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input required name="first_name" ng-model="userr.firstName" value="{{userr.firstName}}" placeholder="Иван" maxlength="15" id="first_name" type="text" class="validate">
                <label for="first_name">Имя</label>
            </div>

            <div class="input-field col s6">
                <input required name="middle_name" ng-model="userr.middleName" value="{{userr.middleName}}" placeholder="Иванович" maxlength="15" id="middle_name" type="text" class="validate">
                <label for="middle_name">Отчество</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="email" value="{{userr.email}}" ng-model="userr.email" required maxlength="50" name="email" placeholder="user@gmail.com" id="email" class="validate">
                <label for="email">E-mail</label>
            </div>

            <div class="input-field col s6">
                <input type="tel" pattern="(\+?\d[- .]*){7,13}" ng-model="userr.phone" value="{{userr.phone}}" required maxlength="50" name="phone" placeholder="+375292847037" id="phone" class="validate">
                <label for="phone">Номер телефона</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="text" required name="passport_number" ng-model="userr.passport.passportNumber" value="{{userr.passport.passportNumber}}" id="passport_number" class="validate">
                <label for="passport_number">Номер паспорта</label>
            </div>

            <div class="input-field col s6">
                <input type="text" required name="address" ng-model="userr.passport.address" value="{{userr.passport.address}}" placeholder="г. Гродно, ул. Гастелло 17, кв. 1" maxlength="45" id="address" class="validate">
                <label for="address">Адрес</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="text" required name="institution" ng-model="userr.passport.issuingInstitution" value="{{userr.passport.issuingInstitution}}" placeholder="Октябрьский РОВД г. Гродно" maxlength="45" id="institution" class="validate">
                <label for="institution">Выдан</label>
            </div>

            <div class="input-field col s6">
                <input type="date" required name="issuing_date" ng-model="userr.passport.issueDate" value="05-09-2016" id="issuing_date" class="datepicker">
                <label for="issuing_date">Действителен до</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <div ng-if="userr.userRole == 'ADMIN'">
                    <div ng-if="admins_count > 1">
                        <select class="browser-default" id="role" required size="1" ng-options="x for x in user_roles" ng-model="userr.userRole"></select>
                    </div>
                    <div ng-if="admins_count <= 1">
                        <select ng-model="userData.user_role" class="browser-default" id="role" required size="1" >
                            <option value="userr.userRole">{{userr.userRole}}</option>
                        </select>
                    </div>
                </div>

                <div ng-if="userr.userRole != 'ADMIN'">
                    <div ng-if="admins_count > 1">
                        <select class="browser-default" id="role" required size="1" ng-options="x for x in user_roles" ng-model="userr.userRole"></select>
                    </div>
                </div>

<%--                <c:choose>
                    <c:when test="${userr.userRole == 'ADMIN'}">
                        <c:if test="${admins_count > 1}">
                            <select id="role" required size="1" name="user_role">
                                <c:forEach var="role" items="${user_roles}">
                                    <c:choose>
                                        <c:when test="${userr.userRole==role}">
                                            <option selected>${role}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option>${role}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </c:if>
                        <c:if test="${admins_count <= 1}">
                            <p id="role">ADMIN</p>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <select id="role" required size="1" name="user_role">
                            <c:forEach var="role" items="${user_roles}">
                                <c:choose>
                                    <c:when test="${userr.userRole==role}">
                                        <option selected>${role}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${role}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </c:otherwise>
                </c:choose>--%>

                <%--<label for="role">Уровень доступа</label>--%>
            </div>
        </div>

        <div class="row right">

            <a href="/admin/loadUsers.action" class="btn waves-effect waves-light light-blue lighten-1"><i class="material-icons">arrow_back</i></a>

            <button class="btn waves-effect waves-light" ng-click="updateUser()" type="submit" name="action">
                <i class="material-icons">check</i>
            </button>

        </div>
    </form>
</div>
