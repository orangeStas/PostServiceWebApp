<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
    function func1() {
        $.getJSON("/client/prepareDataForPackageCreation.action", function (res) {
            var address = document.getElementById('pack_address');
            var usersList = document.getElementById('getter');
            var selectedUser = usersList.options[usersList.selectedIndex].value;

            var ownUserId = "${user.id}";

            var arr = [];
            var obj = res['users'];
            console.log(obj);
            obj.forEach(function (item, i, obj) {
                var userId = item.id;
                if (userId != ownUserId) {
                    arr[i] = [];
                    arr[i][0] = item.id;
                    arr[i][1] = item.passport.address;
                }
            });

            console.log(arr);
            arr.forEach(function (item, i, arr) {
                if (item[0] == selectedUser) {
                    address.value = item[1];
                }
            });
        });
    }
</script>


<div class="container">
    <h3>Посылка</h3>

    <form ng-controller="AddPackageController" name="package_form" enctype="multipart/form-data" accept-charset="UTF-8"
          method="post">

        <div class="row">
            <div class="input-field col s6">
                <select class="browser-default" required size="1" name="package_type" ng-model="packageData.package_type">
                    <option value="Письмо">Письмо</option>
                    <option value="Бандероль">Бандероль</option>
                    <option value="Крупногабаритная">Крупногабаритная</option>
                </select>
                <label>Тип посылки</label>
            </div>

            <div class="input-field col s6">
                <select id="getter" class="browser-default" onchange="func1()" required size="1" ng-model="packageData.package_getter_name"  name="package_getter_name">
<%--                        <div ng-repeat="getter_user in users">
                            <div ng-switch="getter_user_id">
                                <div ng-switch-when="packagee.getterUser.id==getter_user.id">
                                    <option selected
                                            value="{{getter_user.id}}">{{getter_user.secondName}} {{getter_user.firstName}}</option>
                                </div>

                                <div ng-switch-default>
                                    <div ng-if="user.id != getter_user.id">
                                        <option value="{{getter_user.id}}">{{getter_user.secondName}} {{getter_user.firstName}}</option>
                                    </div>
                                </div>
                            </div>
                        </div>--%>
                    <option ng-repeat="getter_user in users" value="{{getter_user.id}}">{{getter_user.secondName}} {{getter_user.firstName}}</option>
                </select>
<%--
                <label>Получатель</label>
--%>
            </div>
        </div>

        <div class="row">

            <div class="input-field col s6">
                <input required type="text" id="pack_address" ng-model="packageData.package_address" value="{{packagee.address}}"
                       placeholder="г. Гродно, ул. Гастелло 17, кв. 1" maxlength="45" class="validate">
                <label for="pack_address">Адрес посылки</label>
            </div>

            <div class="input-field col s6">
                <input required type="number" min="1" ng-model="packageData.package_post_index" name="package_post_index" value="{{packagee.postIndex}}"
                       placeholder="33524"
                       maxlength="7" id="index" class="validate">
                <label for="index">Почтовый индекс</label>
            </div>
        </div>


        <div class="row right">
            <form>
                <button class="btn waves-effect waves-light light-blue lighten-1" type="submit" name="action"
                        onClick="history.go(-1);return true;">
                    <i class="material-icons">arrow_back</i>
                </button>
            </form>

            <div ng-if="user.userRole == 'ADMIN'">
                <div ng-if="packagee !== null">
                    <input type="hidden" name="package_id" value="{{packagee.idPackage}}">
                    <input type="hidden" name="command" value="update_package">
                    <button class="btn waves-effect waves-light" type="submit" name="action">
                        <i class="material-icons">check</i>
                    </button>
                </div>
            </div>

            <div ng-if="!packagee">
                <input type="hidden" name="command" value="add_package">
                <button class="btn waves-effect waves-light" ng-click="addPackage()" type="submit" name="action">
                    <i class="material-icons">check</i>
                </button>
            </div>
        </div>
    </form>
</div>
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

