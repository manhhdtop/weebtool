<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>${title}</title>
    <link rel="icon" href="/resource/icon/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resource/css/bootstrap.min.css">
    <!-- animate CSS -->
    <link rel="stylesheet" href="/resource/css/animate.css">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="/resource/css/owl.carousel.min.css">
    <!-- themify CSS -->
    <link rel="stylesheet" href="/resource/css/themify-icons.css">
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="/resource/css/flaticon.css">
    <!-- slick CSS -->
    <link rel="stylesheet" href="/resource/css/slick.css">
    <!-- magnific-popup CSS -->
    <link rel="stylesheet" href="/resource/css/magnific-popup.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="/resource/css/all.min.css">
    <!-- style CSS -->
    <link rel="stylesheet" href="/resource/css/style.css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
</head>

<body>
<!--::menu part start::-->
<header class="main_menu home_menu">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="/"> <img class="logo-img"
                                                           src="/resource/img/logo.png" alt="logo">
                    </a>
                    <button class="navbar-toggler" type="button"
                            data-toggle="collapse" data-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse main-menu-item"
                         id="navbarNav">
                        <ul class="navbar-nav">
                            <c:forEach var="menu" items="${menus }">
                                <c:choose>
                                    <c:when test="${empty menu.child }">
                                        <li class="nav-item"><a class="nav-link"
                                                                href="/${menu.slug }"> ${menu.name } </a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="nav-item dropdown"><a
                                                class="nav-link dropdown-toggle" href="/${menu.slug }">
                                                ${menu.name } </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                                <c:forEach var="child" items="${menu.child }">
                                                    <a class="dropdown-item" href="/${child.slug }">${child.name }</a>
                                                </c:forEach>
                                            </div>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</header>
<!--::menu part end::-->