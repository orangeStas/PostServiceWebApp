<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
<script>$('.collapsible').collapsible();</script>

<div class="container">
    <h3>Пользователи</h3>

    <div ng-repeat="userr in users">
        <ul class="collapsible" data-collapsible="expandable">
            <li>
                <div class="collapsible-header">
                    <div class="row item-header">
                        <span class="col offset-s1 s6"><b>Логин:</b> {{userr.login}} </span>
                        <span class="col s3 offset-s1"><b>Роль:</b> {{userr.userRole}} </span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </div>
                </div>
                <div class="collapsible-body item">
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Пароль:</b> {{userr.password}} </span>
                        <span class="col s3 offset-s1 package-align"><b>E-mail:</b> {{userr.email}} </span>

                        <div ng-switch="userr.userRole">
                            <div ng-switch-when="'ADMIN'">
                                <div ng-if="admins_count > 1">
                                    <form action="deleteUser.action" enctype="multipart/form-data" method="get">
                                        <input type="hidden" name="user_id" value="{{userr.id}}">
                                        <button type="submit" class="waves-effect waves-light btn col s1 red lighten-1">
                                            <i class="material-icons">delete</i>
                                        </button>
                                    </form>
                                </div>
                            </div>
                            <div ng-switch-default>
                                <form action="deleteUser.action" enctype="multipart/form-data" method="get">
                                    <input type="hidden" name="user_id" value="{{userr.id}}">
                                    <button type="submit" class="waves-effect waves-light btn col s1 red lighten-1">
                                        <i class="material-icons">delete</i>
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <span class="col s6 offset-s1"><b>Имя:</b> {{userr.secondName}} {{userr.firstName}} {{userr.middleName}} </span>
                        <span class="col s3 package-align"><b>Паспорт:</b> {{userr.passport.passportNumber}} </span>

                        <%--<form action="/admin/selectUser.action/{{userr.id}}" enctype="multipart/form-data" method="get">
                            <button type="submit" class="waves-effect waves-light btn col s1 green lighten-1">
                                <i class="material-icons">mode_edit</i>
                            </button>
                        </form>--%>
                        <a href="/admin/selectUser.action/{{userr.id}}" class="waves-effect waves-light btn col s1 green lighten-1"> <i class="material-icons">mode_edit</i></a>
                    </div>

                    <div class="row">
                        <span class="col s6 offset-s1"><b>Адрес:</b> {{userr.passport.address}} </span>
                    </div>

                </div>
            </li>
        </ul>
    </div>
</div>