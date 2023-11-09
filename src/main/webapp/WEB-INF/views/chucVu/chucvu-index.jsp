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
    <a href="/chuc-vu/hien-thi" class="btn btn-primary"> Hiển thị</a>
    <a href="/chuc-vu/view-add" class="btn btn-success ml-5"> Thêm </a>
</div>
<form action="/chuc-vu/search" method="get">
    <label>Tìm kiếm:</label>
    <input type="text" name="ten">
    <button type="submit">Tìm kiếm</button>
</form>
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
        <c:forEach items="${list}" var="cv" varStatus="i">
            <tr>
                <th>${i.index+1}</th>
                <td>${cv.id}</td>
                <td>${cv.ma}</td>
                <td>${cv.ten}</td>
                <td>
                    <a href="/chuc-vu/delete/${cv.id}" class="btn btn-danger btn-sm">Xóa</a>
                    <a href="/chuc-vu/detail/${cv.id}" class="btn btn-info btn-sm">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--<div class="d-flex justify-content-center mt-5">--%>
<%--    <c:forEach begin="1" end="${totalPages}" varStatus="loop">--%>
<%--            <a class="page-link" href="/chuc-vu/hien-thi?num=${loop.index - 1}">${loop.index - 1}</a>--%>
<%--    </c:forEach>--%>
<%--</div>--%>
<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <c:if test="${next > 0}">
                    <a class="page-link" href="/chuc-vu/hien-thi?num=${next - 1}">Previous</a>
                </c:if>
            </li>
            <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                <li class="page-item"><a class="page-link"
                                         href="/chuc-vu/hien-thi?num=${loop.index - 1}">${loop.index}</a></li>
            </c:forEach>
            <li class="page-item">
                <c:if test="${!chucVuPage.last && next < totalPages - 1}">
                    <a class="page-link" href="/chuc-vu/hien-thi?num=${next + 1}">Next</a>
                </c:if>
            </li>
        </ul>
    </nav>
</div>

</body>
</html>