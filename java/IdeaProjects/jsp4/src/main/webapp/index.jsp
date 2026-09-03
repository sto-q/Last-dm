<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>文件上传与下载</title>
</head>
<%--使用form表单进行文件上传的时候必须要设置enctype属性，这个属性值必须为"multipart/form-data"--%>
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="text" name="name">
    <input type="file" name="uploadFile">
    <input type="submit" value="上传">
</form>
<body>

</body>
</html>