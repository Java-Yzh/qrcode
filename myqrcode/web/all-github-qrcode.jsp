<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>生成二维码</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
  <h1>生成黑白二维码</h1>
  <form action="/myqrcode/generateWithQrCode1" method="post" enctype="multipart/form-data">
    <label for="text1">请输入文本内容：</label>
    <input type="text" id="text1" name="url">
    <label for="file1">请选择图片：</label>
    <input type="file" id="file1" name="logo">
    <input type="submit" value="生成二维码">
  </form>

  <h1>生成带logo的黑白二维码</h1>
  <form action="/myqrcode/generateWithQrCode2" method="post" enctype="multipart/form-data">
    <label for="text2">请输入文本内容：</label>
    <input type="text" id="text2" name="url">
    <label for="file2">请选择图片：</label>
    <input type="file" id="file2" name="logo">
    <input type="submit" value="生成二维码">
  </form>

  <h1>生成彩色二维码</h1>
  <form action="/myqrcode/generateWithQrCode3" method="post" enctype="multipart/form-data">
    <label for="text3">请输入文本内容：</label>
    <input type="text" id="text3" name="url">
    <label for="file3">请选择图片：</label>
    <input type="file" id="file3" name="logo">
    <input type="submit" value="生成二维码">
  </form>

  <h1>生成带背景图的二维码</h1>
  <form action="/myqrcode/generateWithQrCode4" method="post" enctype="multipart/form-data">
    <label for="text4">请输入文本内容：</label>
    <input type="text" id="text4" name="url">
    <label for="file4">请选择图片：</label>
    <input type="file" id="file4" name="logo">
    <input type="submit" value="生成二维码">
  </form>

  <h1>生成特殊形状二维码</h1>
  <form action="/myqrcode/generateWithQrCode5" method="post" enctype="multipart/form-data">
    <label for="text5">请输入文本内容：</label>
    <input type="text" id="text5" name="url">
    <label for="file5">请选择图片：</label>
    <input type="file" id="file5" name="logo">
    <input type="submit" value="生成二维码">
  </form>

  <h1>生成图片填充的二维码</h1>
  <form action="/myqrcode/generateWithQrCode6" method="post" enctype="multipart/form-data">
    <label for="text6">请输入文本内容：</label>
    <input type="text" id="text6" name="url">
    <label for="file6">请选择图片：</label>
    <input type="file" id="file6" name="logo">
    <input type="submit" value="生成二维码">
  </form>
</div>
</body>
</html>