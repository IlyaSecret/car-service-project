<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h3>Information for all</h3>
<br><br>
<security:authorize access="hasRole('USER')">
    <input type="button" value="Client" onclick="window.location.href = 'user_info'">
    Only Clients
</security:authorize>
<br><br>
<security:authorize access="hasRole('ADMIN')">
    <input type="button" value="Admin" onclick="window.location.href = 'admin_info'">
    Only Admins
</security:authorize>
</body>
</html>
