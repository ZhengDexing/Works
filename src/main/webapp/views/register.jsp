<%--
  Created by IntelliJ IDEA.
  User: 57015
  Date: 2018/4/19
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet">
    <style>@media print {#ghostery-purple-box {display:none !important}}</style></head>
<body>
<div class="col-md-8 order-md-1">
    <h1 class="h3 mb-3 font-weight-normal">注册</h1>
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="nickname" class="col-sm-2 control-label">昵称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nickname" name="nickname" placeholder="请输入昵称">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">邮箱</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name="email" id="email" placeholder="请输入邮箱地址">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <label for="password2" class="col-sm-2 control-label">确认密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password2" placeholder="请确认密码">
            </div>
        </div>
        <div class="col-md-5 mb-3">
            <label for="role">角色</label>
            <select class="custom-select d-block w-100" id="role" name="role" required="">
                <option value="0">个人用户</option>
                <option value="1">企业用户</option>
            </select>
            <div class="invalid-feedback">
                请选择角色
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary btn-lg btn-block">注册</button>
            </div>
        </div>
    </form>

</div>
<script id="wappalyzer" src="${pageContext.request.contextPath}/resources/js/inject.js"></script>
</body>
</html>
