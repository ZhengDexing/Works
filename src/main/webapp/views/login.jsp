<%--
  Created by IntelliJ IDEA.
  User: 57015
  Date: 2018/4/19
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet">
    <style>@media print {
        #ghostery-purple-box {
            display: none !important
        }
    }</style>
</head>

<body class="text-center" style="margin-top: 0px;">
    <form class="form-signin" action="${pageContext.request.contextPath}/login">
        <h1 class="h3 mb-3 font-weight-normal">登录</h1>
        <label for="inputEmail" class="sr-only">邮箱地址</label>
        <input id="inputEmail" class="form-control" placeholder="邮箱地址" name="email" required="" autofocus=""
               type="email">
        <label for="inputPassword" class="sr-only">密码</label>
        <input id="inputPassword" class="form-control" placeholder="密码" name="password" required="" type="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <a href="" style="margin-left: 200px;">忘记密码</a>

        <p class="mt-5 mb-3 text-muted">© 20151260102 郑德星 2017-2018</p>
    </form>


<script id="wappalyzer" src="${pageContext.request.contextPath}/resources/js/inject.js"></script>
</body>
</html>