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
<form:form action="/ctsp/update/${id}" modelAttribute="ctsp">
    <div class="form-group">
        <form:select path="idSP" class="form-control">
            <c:forEach items="${listSP}" var="sp">
                <option value="${sp.id}" ${sp.id == ctsp.idSP.id ? "selected" : ""}>
                        ${sp.ten}
                </option>
            </c:forEach>
        </form:select>
        <form:errors path="idSP" cssClass="text-danger" element="span"/>
    </div>
    <div class="form-group">
        <form:select path="idNsx" class="form-control">
            <c:forEach items="${listNsx}" var="sp">
                <option value="${sp.id}" ${sp.id == ctsp.idNsx.id ? "selected" : ""} >
                        ${sp.ten}
                </option>
            </c:forEach>
        </form:select>
        <form:errors path="idNsx" cssClass="text-danger" element="span"/>
    </div>
    <div class="form-group">
        <form:select path="idMauSac" class="form-control">
            <c:forEach items="${listMau}" var="sp">
                <option value="${sp.id}" ${sp.id == ctsp.idMauSac.id ? "selected" : ""}>
                        ${sp.ten}
                </option>
            </c:forEach>
        </form:select>
        <form:errors path="idMauSac" cssClass="text-danger" element="span"/>
    </div>
    <div class="form-group">
        <form:select path="idDong" class="form-control">
            <c:forEach items="${listDong}" var="sp">
                <option value="${sp.id}" ${sp.id == ctsp.idDong.id ? "selected" : ""}>
                        ${sp.ten}
                </option>
            </c:forEach>
        </form:select>
        <form:errors path="idDong" cssClass="text-danger" element="span"/>
    </div>
    <div class="form-group">
        <label>Năm bảo hành</label>
        <form:input path="namBh" class="form-control"/>
        <form:errors class="text-danger" element="span" path="namBh"/>
    </div>
    <div class="form-group">
        <label>Mô tả</label>
        <form:input path="moTa" class="form-control"/>
        <form:errors class="text-danger" element="span" path="moTa"/>
    </div>
    <div class="form-group">
        <label>Số lượng</label>
        <form:input path="soLuongTon" class="form-control"/>
        <form:errors class="text-danger" element="span" path="soLuongTon"/>
    </div>
    <div class="form-group">
        <label>Giá nhập</label>
        <form:input path="giaNhap" class="form-control"/>
        <form:errors class="text-danger" element="span" path="giaNhap"/>
    </div>
    <div class="form-group">
        <label>Giá bán</label>
        <form:input path="giaBan" class="form-control"/>
        <form:errors class="text-danger" element="span" path="giaBan"/>
    </div>
    <button type="submit" class="btn btn-success">Sửa</button>
</form:form>
</body>
</html>