<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

<div class="container">
    <h3>Оплата</h3>

    <h4>Информация о платеже:</h4>
    <table>
        <tr>
            <td><b>Имя плательщика:</b></td>
            <td>${receipt.clientName}</td>

            <td><b>Сервис:</b></td>
            <td>${receipt.serviceName}</td>
        </tr>
        <tr>
            <td><b>Данные для оплаты:</b></td>
            <td>${receipt.paymentData}</td>

            <td><b>Дата:</b></td>
            <td>${receipt.date}</td>
        </tr>

        <tr>
            <td><b>Сумма:</b></td>
            <td>${receipt.cost}</td>
        </tr>
    </table>

    <hr>

    <h4>Введите данные вашей кредитной карты:</h4>

    <form action="payment.action" method="get" enctype="multipart/form-data">
        <input type="hidden" name="command" value="payment_command">

        <div class="row">

            <div class="input-field col s4">
                <input name="card_number" type="text" required placeholder="1234 4321 2341 2134" pattern="  \b(?:3[47]\d{2}([\s-]?)\d{6}\1\d|(?:(?:4\d|5[1-5]|65)\d{2}|6011)([\s-]?)\d{4}\2\d{4}\2)\d{4}\b" class="validate" id="cardNumber">
                <label for="cardNumber">Номер карты</label>
            </div>

            <div class="input-field col s4">
                <input name="expire_date" type="text" required placeholder="08/19" pattern="^[0-1][1-9]/[0-9][0-9]$" class="validate" id="expire_date">
                <label for="expire_date">Срок действия (месяц/год)</label>
            </div>

            <div class="input-field col s4">
                <input name="cvc" type="text" required placeholder="231" pattern="^[0-9][0-9][0-9]$" class="validate" id="cvc">
                <label for="cvc">CVC (на обратной стороне карты)</label>
            </div>

        </div>

        <div class="row right">
            <button class="btn waves-effect waves-light" type="submit" name="action">
                <i class="material-icons">check</i>
            </button>
        </div>
    </form>

</div>

<jsp:include page="footer.jsp" />