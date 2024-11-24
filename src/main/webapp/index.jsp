<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>CRM System</title>
    <link href="styles.css" rel="stylesheet">
</head>
<body>

   <center> <h1>Welcome to the CRM System</h1></center>
    <div class="form-container">
    <h2>LOGIN</h2>
    <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
            <input type="text" id="email" name="email" placeholder="Enter your Email" required class="box">
            <br>
            <input type="password" id="password" name="password" placeholder="Enter your Password"required class="box">
            <br>
             <input type="submit" name="submit" value="Login" class="btn">
            <p>Don't have an account? <a href="register.jsp">Register now</a></p>
        </form>
</body>
</html>

