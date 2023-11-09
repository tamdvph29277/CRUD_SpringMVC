<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Title</title>
</head>
<body class="">
<div class="mt-3 mb-3">
    <a href="/nhan-vien/hien-thi" class="btn btn-primary"> Hiển thị</a>
    <a href="/nhan-vien/view-add" class="btn btn-success ml-5"> Thêm </a>
</div>
<div>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>Mã</th>
            <th>Họ tên</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>SĐT</th>
            <th>Mât khẩu</th>
            <th>Của hàng</th>
            <th>Chức vụ</th>
            <th>Trạng thái</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="d" varStatus="i">
            <tr>
                <th>${i.index+1}</th>
                <td>${d.id}</td>
                <td>${d.ma}</td>
                <td>${d.ho} ${d.tenDem} ${d.ten}</td>
                <td>${d.gioiTinh}</td>
                <td>${d.ngaySinh}</td>
                <td>${d.diaChi}</td>
                <td>${d.sdt}</td>
                <td>${d.matKhau}</td>
                <td>${d.idCH.ten}</td>
                <td>${d.idCV.ten}</td>
                <td>${d.trangThai == 0 ? "Đang làm" : "Đã nghỉ"}</td>
                <td>
                    <a href="/nhan-vien/delete/${d.id}" class="btn btn-danger btn-sm">Xóa</a>
                    <a href="/nhan-vien/detail/${d.id}" class="btn btn-info btn-sm">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>