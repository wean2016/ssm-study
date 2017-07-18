<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/7/17
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <form action="testConversionServiceConverer" method="post">
        <%-- 格式为 lastname-email-gender-department.id --%>
        <%-- 例子： GG-gg@wean2016.cn-0-105 --%>
        Employee: <input type="text" name="employee">
        <input type="submit">
    </form>

    <br><br>
    <%--
        1. WHY 使用 form 标签
        可以更快速地开发处表单页面，而且可以更方便地进行表单回显
    --%>
    <form:form action="/emp" method="post" modelAttribute="employee">
        <%--path 属性对应 html 表单标签的 name 属性值--%>
        <c:if test="${employee.id == null }">
            <!-- path 属性对应 html 表单标签的 name 属性值 -->
            LastName: <form:input path="lastName"/>
            <form:errors path="lastName"/>
        </c:if>
        <c:if test="${employee.id != null }">
            <form:hidden path="id"/>
            <input type="hidden" name="_method" value="PUT"/>
            <%-- 对于 _method 不能使用 form:hidden 标签, 因为 modelAttribute 对应的 bean 中没有 _method 这个属性 --%>
            <%--
            <form:hidden path="_method" value="PUT"/>
            --%>
        </c:if>
        <br>
        Email: <form:input path="email"/> <br>
        <form:errors path="email"/>
        <%
            Map<Integer,String> genders = new HashMap<Integer, String>();
            genders.put(1,"Female");
            genders.put(0,"Male");

            request.setAttribute("genders", genders);
        %>
        Gender: <form:radiobuttons path="gender" items="${genders}"/> <br>
        Departments: <form:select path="department.id" items="${departments}"
                                  itemLabel="departmentName" itemValue="id"/> <br>
        Birth: <form:input path="birth"/>
        <form:errors path="birth"/>
        <br>
        Salary: <form:input path="salary"/>
        <form:errors path="salary"/>
        <br>
        <input type="submit">
    </form:form>
</body>
</html>
