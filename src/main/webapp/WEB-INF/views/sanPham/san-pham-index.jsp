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
<div class="mt-3 mb-3">
    <a href="/san-pham/hien-thi" class="btn btn-primary"> Hiển thị</a>
    <a href="/san-pham/view-add" class="btn btn-success ml-5"> Thêm </a>
</div>
<div>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="d" varStatus="i">
            <tr>
                <th>${i.index+1}</th>
                <td>${d.id}</td>
                <td>${d.ma}</td>
                <td>${d.ten}</td>
                <td>
                    <a href="/san-pham/delete/${d.id}" class="btn btn-danger btn-sm">Xóa</a>
                    <a href="/san-pham/detail/${d.id}" class="btn btn-info btn-sm">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>