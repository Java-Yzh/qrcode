<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>生成二维码</title>
</head>
<body>
<h1>生成黑白二维码</h1>
<form action="/myqrcode/generateWithQrCode1" method="post" enctype="multipart/form-data">
  请输入文本内容：<input type="text" name="url"><br>
  请选择图片：<input type="file" name="logo"><br>
  <input type="submit" value="生成二维码">
</form>
<h1>生成带logo的黑白二维码</h1>
<form action="/myqrcode/generateWithQrCode2" method="post" enctype="multipart/form-data">
  请输入文本内容：<input type="text" name="url"><br>
  请选择图片：<input type="file" name="logo"><br>
  <input type="submit" value="生成二维码">
</form>
<h1>生成彩色二维码</h1>
<form action="/myqrcode/generateWithQrCode3" method="post" enctype="multipart/form-data">
  请输入文本内容：<input type="text" name="url"><br>
  请选择图片：<input type="file" name="logo"><br>
  <input type="submit" value="生成二维码">
</form>
<h1>生成带背景图的二维码</h1>
<form action="/myqrcode/generateWithQrCode4" method="post" enctype="multipart/form-data">
  请输入文本内容：<input type="text" name="url"><br>
  请选择图片：<input type="file" name="logo"><br>
  <input type="submit" value="生成二维码">
</form>
<h1>生成特殊形状二维码</h1>
<form action="/myqrcode/generateWithQrCode5" method="post" enctype="multipart/form-data">
  请输入文本内容：<input type="text" name="url"><br>
  请选择图片：<input type="file" name="logo"><br>
  <input type="submit" value="生成二维码">
</form>
<h1>生成图片填充的二维码</h1>
<form action="/myqrcode/generateWithQrCode6" method="post" enctype="multipart/form-data">
  请输入文本内容：<input type="text" name="url"><br>
  请选择图片：<input type="file" name="logo"><br>
  <input type="submit" value="生成二维码">
</form>
</body>
</html>

