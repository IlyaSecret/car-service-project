<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<h3>Information for clients</h3>
<br><br>
<security:authorize access="hasRole('USER')">
<input type="button" value="Salary" onclick="window.location.href = 'user_info'">
Only Clients
</security:authorize>
<br><br>
<security:authorize access="hasRole('ADMIN')">
<input type="button" value="Performance" onclick="window.location.href = 'admin_info'">
Only Admin
</security:authorize>
</body>
</html>