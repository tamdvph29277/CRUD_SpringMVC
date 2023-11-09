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
<form:form action="/nhan-vien/update/${id}" modelAttribute="nhanVien">
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
    <div class="form-group">
        <label>tenDem</label>
        <form:input path="tenDem" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ten"/>
    </div>
    <div class="form-group">
        <label>Họ</label>
        <form:input path="ho" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ten"/>
    </div>
    <div class="form-group">
        <label>Giới tính</label>
        <form:input path="gioiTinh" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ten"/>
    </div>
    <div class="form-group">
        <label>Ngày sinh</label>
        <form:input path="ngaySinh" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ten"/>
    </div>
    <div class="form-group">
        <label>Địa chỉ</label>
        <form:input path="diaChi" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ten"/>
    </div>
    <div class="form-group">
        <label>SĐT</label>
        <form:input path="sdt" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ten"/>
    </div>
    <div class="form-group">
        <label>Mật khẩu</label>
        <form:input path="matKhau" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ten"/>
    </div>
    <div class="form-group">
        <label>Của hàng</label>
        <form:select path="idCH" class="form-control">
            <c:forEach items="${listCH}" var="ch">
                <option value="${ch.id}" ${ch.id == nhanVien.idCH.id ? "selected" : ""} > ${ch.ten}</option>
            </c:forEach>
        </form:select>
        <form:errors class="text-danger" element="span" path="ten"/>
    </div>
    <div class="form-group">
        <label>Chức vụ</label>
        <form:select path="idCV" class="form-control">
            <c:forEach items="${listCV}" var="ch">
                <option value="${ch.id}" ${ch.id == nhanVien.idCV.id ? "selected" : ""}> ${ch.ten}</option>
            </c:forEach>
        </form:select>
        <form:errors class="text-danger" element="span" path="ten"/>
    </div>

    <div class="form-group">
        <label>Trạng thái</label>
        <div class="form-check">
            <form:radiobutton cssClass="form-check-input" path="trangThai" value="0" checked="true"/>
            <label class="form-check-label">Đang làm</label>
        </div>
        <div class="form-check">
            <form:radiobutton cssClass="form-check-input" path="trangThai" value="1"/>
            <label class="form-check-label">Đã nghỉ</label>
        </div>
    </div>
    <button class="btn btn-success">Sửa</button>
</form:form>
</body>
</html>