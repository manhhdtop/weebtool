<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title }</title>

    <!-- Custom fonts for this template-->
    <link rel="icon" href="/resource/icon/favicon.png">
    <link href="/resource/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resource/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="/resource/css/admin.css" rel="stylesheet">
    <link href="/resource/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="/resource/css/showLoading.css"/>

</head>

<body class="bg-gradient-primary">
<div class="container">
    <!-- Outer Row -->
    <div class="row justify-content-center">
        <div class="col-xl-6 col-lg-6 col-md-8">
            <div class="col-lg-12" style="padding: 10% 15%">
                <a href="/backend/"><img class="img-fluid" alt="Logo"
                                         src="/resource/img/logo.png"></a>
            </div>
            <div class="card o-hidden border-0 shadow-lg">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="col-lg-12">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                            </div>
                            <form name="loginForm" class="user" method="post">
                                <div class="form-group">
                                    <label id="loginError" class="input-error text-danger"></label>
                                    <label id="loginSuccess" class="input-success text-success"></label>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user"
                                           id="username" placeholder="Username..."> <label
                                        id="usernameError" class="input-error"></label>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control form-control-user"
                                           id="password" placeholder="Password..."> <label
                                        id="passwordError" class="input-error"></label>
                                </div>
                                <button id="login" type="submit" data-spinner-type=""
                                        data-spinner-text="Đang đăng nhập..."
                                        class="btn btn-primary btn-user btn-block">Đăng nhập
                                </button>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Quên mật khẩu?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="register.html">Tạo tài khoản!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="/resource/js/jquery.min.js"></script>
<script src="/resource/js/jquery-cookie.js"></script>
<script src="/resource/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/resource/js/jquery.easing.min.js"></script>
<script type="text/javascript"
        src="/resource/js/jquery.showLoading.min.js"></script>
<!-- Custom scripts for all pages-->
<script src="/resource/js/login.js"></script>

</body>

</html>
