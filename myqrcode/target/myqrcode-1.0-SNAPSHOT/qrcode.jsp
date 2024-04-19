<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>生成二维码</title>
</head>
<body>
<form action="/myqrcode/generateWithLogo" method="post" enctype="multipart/form-data">
    请输入文本内容：<input type="text" name="url"><br>
    请选择图片：<input type="file" name="logo"><br>
    <input type="submit" value="生成二维码">
</form>
</body>
</html>

