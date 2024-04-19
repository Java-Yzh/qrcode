<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>使用java语言生成二维码</title>
  </head>
  <body>
  <h1>使用google的zxing库生成普通的黑白的二维码</h1>
  <hr />
  请输入文本内容：<input type="text" id="url"/><button onclick="generateQRcode()">生成二维码</button><br>
  <img id="qrcodeImg">
  <script>
    function generateQRcode()
    {
      //获取url
      let url = document.getElementById("url").value
      // 设置ing的src属性
      let qrcodeimg = document.getElementById("qrcodeImg")
      qrcodeimg.src = "/myqrcode/generate?url=" + url
    }
  </script>
  </body>
</html>
