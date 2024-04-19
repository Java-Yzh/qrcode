package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/generateWithLogo")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100)
public class GenerateQRcodeWithLogo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String url = request.getParameter("url");
            Map map = new HashMap();
            map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            map.put(EncodeHintType.CHARACTER_SET, "utf-8");
            map.put(EncodeHintType.MARGIN, 1);
            MultiFormatWriter writer = new MultiFormatWriter();
            BitMatrix bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, 300, 300, map);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();

            // 生成二维码图片
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }

            // 给二维码添加logo

            // 第一部分：将logo缩放
            // 获取logo图片
            Part logoPart = request.getPart("logo");
            InputStream inputStream = logoPart.getInputStream();
            Image logoImage = ImageIO.read(inputStream);
            // 对获取到的logo图片进行缩放
            int logoWidth = logoImage.getWidth(null);
            int logoHeight = logoImage.getHeight(null);
            if (logoWidth > 60) {
                logoWidth = 60;
            }
            if (logoHeight > 60) {
                logoHeight = 60;
            }
            // 这一行代码非常重要，全靠它来进行缩放了。
            // 使用平滑缩放算法对原始的logo图像进行缩放得到一个全新的图像。
            Image scaledLogo = logoImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);

            // 第二部分：将缩放后的logo画到黑白二维码上
            // 获取一个2D的画笔
            Graphics2D graphics2D = image.createGraphics();
            // 指定从哪里开始画，也就是指定开始的坐标x, y
            int x = (300 - logoWidth) / 2;
            int y = (300 - logoHeight) / 2;
            // 将缩放之后的logo画上去
            graphics2D.drawImage(scaledLogo, x, y, null);
            // 创建一个具有指定位置、宽度、高度和圆角半径的圆角矩形，这个圆角矩形是用来绘制边框的。
            Shape shape = new RoundRectangle2D.Float(x,y,logoWidth,logoHeight,10,10);
            // 使用一个宽度为4像素的基本笔触
            graphics2D.setStroke(new BasicStroke(4f));
            // 给logo画圆角矩形
            graphics2D.draw(shape);
            // 释放画笔
            graphics2D.dispose();

            // 将二维码图片响应到浏览器
            ImageIO.write(image, "png", response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

