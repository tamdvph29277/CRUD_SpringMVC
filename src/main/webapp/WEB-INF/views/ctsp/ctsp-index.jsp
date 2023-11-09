<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="mt-3 mb-3 d-flex justify-content-center">
    <a href="/ctsp/hien-thi" class="btn btn-primary"> Hiển thị</a>
    <a href="/ctsp/view-add" class="btn btn-success ml-5"> Thêm </a>
</div>
<div>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>NSX</th>
            <th>Màu sắc</th>
            <th>Loại</th>
            <th>Năm bảo hành</th>
            <th>Mô tả</th>
            <th>Số lượng</th>
            <th>Giá nhập</th>
            <th>Giá bán</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="d" varStatus="i">
            <tr>
                <th>${i.index+1}</th>
                <td>${d.id}</td>
                <td>${d.idSP.ten}</td>
                <td>${d.idNsx.ten}</td>
                <td>${d.idMauSac.ten}</td>
                <td>${d.idDong.ten}</td>
                <td>${d.namBh}</td>
                <td>${d.moTa}</td>
                <td>${d.soLuongTon}</td>
                <td>${d.giaNhap}</td>
                <td>${d.giaBan}</td>
                <td>
                    <a href="/ctsp/delete/${d.id}" onclick="return confirm('Có thật sự muốn xóa ???')"
                       class="btn btn-danger btn-sm">Xóa</a>
                    <a href="/ctsp/detail/${d.id}" class="btn btn-info btn-sm">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
