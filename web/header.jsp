<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 4/22/2016
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/styles.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="utf-8">
</head>

<body>

<div class="wrapper">
    <nav class="nav-wrapper blue darken-1">
        <a href="#" data-activates="slide-out" class="button-collapse show-on-large"><i class="material-icons">menu</i></a>
        <a href="#" class="brand-logo">ПАШТОВЫ СЕРВИС</a>

        <div class="row right">
            <a href="#" class="waves-effect waves-light btn"><i class="material-icons auth">input</i></a>
            <a href="#" class="waves-effect waves-light btn deep-orange lighten-1"><i class="material-icons auth">person_add</i></a>
        </div>

        <ul id="slide-out" class="side-nav">
            <li class="user-name blue darken-1">Кирилл Цивако</li>
            <li class="active"><a href="#">Профиль</a></li>
            <li><a href="#">Посылки</a></li>
            <li><a href="#">Квитанции</a></li>
            <li><a href="#">Поиск посылки</a></li>
            <li><a href="#">Авансовая книжка</a></li>
        </ul>

    </nav>