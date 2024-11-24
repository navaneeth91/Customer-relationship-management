<%@ page import="com.crm.model.Customer" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Customers</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
    <style>

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table th, table td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        table th {
            background: #007bff;
            color: #ffffff;
        }

        table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        table tr:hover {
            background-color: #f1f1f1;
        }

        .actions a {
            text-decoration: none;
            margin: 0 5px;
            border-radius: 4px;
            font-size: 1.2rem;
            color: #000;
        }

        .actions .update-icon {
            color: #28a745;
        }

        .actions .delete-icon {
            color: #dc3545;
        }

        .actions a:hover {
            opacity: 0.8;
        }
        </style>
</head>
<body>
    <center><h1>Customer List</h1></center>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th colspan="2">Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Customer> customers = (List<Customer>) request.getAttribute("customers");
                for (Customer customer : customers) {
            %>
                <tr>
                    <td><%= customer.getId() %></td>
                    <td><%= customer.getName() %></td>
                    <td><%= customer.getEmail() %></td>
                    <td><%= customer.getPhone() %></td>
                    <td><%= customer.getAddress() %></td>
                    <td>
                        <div class="actions">
                           <a href="UpdateCustomerServlet?id=<%= customer.getId() %>" class="update-icon" title="Update">
                                 <i class="fas fa-edit"></i>
                             </a>
                             </div>
                     </td>
                     <td>
                          <div class="actions">
                           <a href="DeleteCustomerServlet?id=<%= customer.getId() %>" class="delete-icon" title="Delete" onclick="return confirm('Are you sure you want to delete this customer?');">
                                 <i class="fas fa-trash"></i>
                           </a>
                            </div>

                     </td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
