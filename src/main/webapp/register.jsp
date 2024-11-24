<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>CRM- REGISTER</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<center> <h1>Welcome to the CRM System</h1></center>
   <div class="form-container">
      <form action="<%=request.getContextPath()%>/RegisterServlet" method="post">
         <h3>register now</h3>
         <input type="text" name="name" placeholder="Enter your name" required class="box">
         <input type="email" name="email" placeholder="Enter your email" required class="box">
         <input type="text" name="address" placeholder="Enter your Address" required class="box">
         <input type="text" name="mobile" placeholder="Enter your mobile number" required class="box">
         <input type="password" name="password" placeholder="Enter your password" required class="box">
         <input type="password" name="cpassword" placeholder="Confirm your password" required class="box">
         <select name="user_type" class="box">
            <option value="">Select Role</option>
            <option value="Customer">Customer</option>
            <option value="Employee">Employee</option>
         </select>
         <input type="submit" name="submit" value="register now" class="btn">
         <p>Already have an account? <a href="index.jsp">Login now</a></p>
      </form>
   </div>
</body>
</html>
