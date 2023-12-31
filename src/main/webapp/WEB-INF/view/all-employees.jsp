<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>All employees</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="emp" items="${allEmps}">
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <c:url var="delete" value="/deleteEmp">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td><input type="button" value="update"
                       onclick="window.location.href='${updateButton}'">
                <input type="button" value="delete"
                       onclick="window.location.href='${delete}'">
            </td>

        </tr>
    </c:forEach>
</table>

<input type="button" value="add" onclick="window.location.href='addNewEmployee'">
</body>
</html>