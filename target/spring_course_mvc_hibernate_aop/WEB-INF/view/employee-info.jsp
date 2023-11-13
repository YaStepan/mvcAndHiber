<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<form:form action="saveEmp" modelAttribute="emp">
    <form:hidden path="id"/>
    <h2>Insert new employee:</h2>
    <div>Name:<form:input path="name"/></div>
    <div>Surname:<form:input path="surname"/></div>
    <div>Salary:<form:input path="salary"/></div>
    <div>Department:<form:input path="department"/></div>
    <input type="submit" value="Send info">
</form:form>
</body>
</html>