<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传功能案例解析</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/upload" method="post" enctype="multipart/form-data">
		<div><lable>商品名称：</lable><input type="text" name="productName"></div>
		<div><lable>商品图片：</lable><input type="file" name="productImag"></div> 
		<div><input type="submit" value="上传文件"><label><span style="color:red">${msg }</span></label></div>
	</form>
</body>
</html>