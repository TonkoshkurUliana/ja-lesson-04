<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<link rel="stylesheet" href="style/login.css">
<link rel="stylesheet" href="style/index.css">
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <form action="login" method="post">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="login" required>
        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <button type="submit"><b>Login</b></button>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
