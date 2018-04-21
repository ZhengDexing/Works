<%--
  Created by IntelliJ IDEA.
  User: 57015
  Date: 2018/4/19
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<h1 align="center">注册成功，3秒钟跳转到登陆页面。。。。</h1>
<script type="text/javascript">
    onload=function(){
        setTimeout(go, 3000);
    };
    function go(){
        location.href="${pageContext.request.contextPath}/login";
    }
</script>
</body>
</html>
