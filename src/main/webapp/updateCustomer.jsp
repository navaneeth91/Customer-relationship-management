<%@ page import="com.crm.model.Customer" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #007bff;
            margin-top: 20px;
        }

        .form-container {
            max-width: 600px;
            margin: 20px auto;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 20px 30px;
        }

        .form-container label {
            font-weight: bold;
            color: #333;
        }

        .form-container input[type="text"],
        .form-container input[type="email"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }

        .form-container button {
            width: 100%;
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 12px;
            font-size: 16px;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-container button:hover {
            background-color: #0056b3;
        }

        .form-container input:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }
    </style>
</head>
<body>
    <h1>Update Customer</h1>
    <div class="form-container">
        <form action="UpdateCustomerServlet" method="post">
            <input type="hidden" name="id" value="<%= customer.getId() %>">

            <label for="name">Name:</label>
            <input type="text" name="name" id="name" value="<%= customer.getName() %>" required>

            <label for="email">Email:</label>
            <input type="email" name="email" id="email" value="<%= customer.getEmail() %>" required>

            <label for="phone">Phone:</label>
            <input type="text" name="phone" id="phone" value="<%= customer.getPhone() %>" required>

            <label for="address">Address:</label>
            <input type="text" name="address" id="address" value="<%= customer.getAddress() %>" required>

            <button type="submit">Update</button>
        </form>
    </div>
</body>
</html>
