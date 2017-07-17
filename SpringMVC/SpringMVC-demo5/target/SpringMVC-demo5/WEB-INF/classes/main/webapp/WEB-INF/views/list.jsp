<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/7/17
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>

    <script type="text/javascript" src="/scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var href = $(this).attr("href");
                $("form").attr("action", href).submit();
                return false;
            })
        })
    </script>
</head>
<body>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE" />
    </form>

    <c:if test="${empty requestScope.employees }>">
        没有任何员工信息
    </c:if>
    <c:if test="${!empty requestScope.employees}">
        <table>
            <tr>
                <th>ID</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Department</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${requestScope.employees}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.gender == 0 ? 'female' : 'Male'}</td>
                    <td>${emp.department.departmentName}</td>
                    <td><a href="/emp/${emp.id}">Edit</a></td>
                    <td><a class="delete" href="emp/${emp.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br><br>

    <a href="/emp">add new emp</a>
</body>
</html>
