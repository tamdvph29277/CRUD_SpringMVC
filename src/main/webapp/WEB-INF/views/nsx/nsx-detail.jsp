<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Title</title>
</head>
<body class="container">
<form:form action="/nsx/update/${id}" modelAttribute="nsx">
    <div class="form-group">
        <label>mã</label>
        <form:input path="ma" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ma"/>
    </div>
    <div class="form-group">
        <label>tên</label>
        <form:input path="ten" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ten"/>
    </div>
    <button type="submit" class="btn btn-success">Sửa</button>
</form:form>
</body>
</html>