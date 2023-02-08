<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<link rel="stylesheet" href="style/registration.css">
<link rel="stylesheet" href="style/index.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <form action="registration" method="post">

        <label ><b>First Name :</b></label>
        <input type="text" name="firstName">
        <br>
        <label ><b>Last Name :</b></label>
        <input type="text" name="lastName">
        <br>
        <label><b>Email :</b></label>
        <input type="email" name="email" required>
        <br>
        <label><b>Password : </b></label>
        <input type="password" name="password" required>
        <br>
        <button type="submit"><b>SUBMIT</b></button>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include><script>
</script>


</body>
</html>
