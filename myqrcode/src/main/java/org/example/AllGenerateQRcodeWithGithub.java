package org.example;

import com.github.hui.quick.plugin.qrcode.wrapper.QrCodeGenWrapper;
import com.github.hui.quick.plugin.qrcode.wrapper.QrCodeOptions;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.http.HttpClient;
@WebServlet({"/generateWithQrCode1","/generateWithQrCode2","/generateWithQrCode3","/generateWithQrCode4","/generateWithQrCode5","/generateWithQrCode6"})
@MultipartConfig(fileSizeThreshold = 1024,
        maxFileSize = 1024 * 1024 * 80,
        maxRequestSize = 1024 * 1024 * 100)

public class AllGenerateQRcodeWithGithub extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/generateWithQrCode1".equals(servletPath))
        {
            dogenerate1(request,response);
        } else if ("/generateWithQrCode2".equals(servletPath)) {
            dogenerate2(request,response);
        }else if("/generateWithQrCode3".equals(servletPath))
        {
            dogenerate3(request,response);
        }else if("/generateWithQrCode4".equals(servletPath))
        {
            dogenerate4(request,response);
        }else if("/generateWithQrCode5".equals(servletPath))
        {
            dogenerate5(request,response);
        }else if("/generateWithQrCode6".equals(servletPath))
        {
            dogenerate6(request,response);
        }
    }

    private void dogenerate6(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取文本内容
            String url = request.getParameter("url");

            // 生成图片填充二维码
            BufferedImage image = QrCodeGenWrapper.of(url)
                    .setErrorCorrection(ErrorCorrectionLevel.H) // 设置二维码的错误纠正级别
                    .setDrawStyle(QrCodeOptions.DrawStyle.IMAGE) // 绘制二维码时采用图片填充
                    .addImg(1, 1, request.getPart("logo").getInputStream()) // 添加图片
                    .asBufferedImage();

            // 将二维码图片响应到浏览器
            ImageIO.write(image, "gif", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dogenerate5(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取文本内容
            String url = request.getParameter("url");

            // 生成特殊形状的二维码
            BufferedImage image = QrCodeGenWrapper.of(url)
                    .setDrawEnableScale(true) // 启用二维码绘制时的缩放功能
                    .setDrawStyle(QrCodeOptions.DrawStyle.DIAMOND) // 指定绘制样式采用钻石
                    .asBufferedImage();

            // 将二维码图片响应到浏览器
            ImageIO.write(image, "gif", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dogenerate4(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取文本内容
            String url = request.getParameter("url");

            // 生成带有背景图的二维码
            BufferedImage image = QrCodeGenWrapper.of(url)
                    .setBgImg(request.getPart("logo").getInputStream())
                    .setBgOpacity(0.7F)
                    .asBufferedImage();

            // 将二维码图片响应到浏览器
            ImageIO.write(image, "gif", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dogenerate3(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取文本内容
            String url = request.getParameter("url");

            // 生成彩色二维码
            BufferedImage image = QrCodeGenWrapper.of(url)
                    .setDrawPreColor(Color.BLUE)
                    .asBufferedImage();

            // 将二维码图片响应到浏览器
            ImageIO.write(image, "gif", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dogenerate2(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取文本内容
            String url = request.getParameter("url");

            // 生成带有logo的黑白二维码
            BufferedImage image = QrCodeGenWrapper.of(url)
                    .setErrorCorrection(ErrorCorrectionLevel.H) // 设置二维码的错误纠正级别
                    .setLogo(request.getPart("logo").getInputStream())
                    .setLogoRate(7) // 设置logo图片与二维码之间的比例，7表示logo的宽度等于二维码的1/7
                    .setLogoStyle(QrCodeOptions.LogoStyle.ROUND) // 设置logo图片的样式。将logo的边框形状设置为圆形
                    .asBufferedImage();


            // 将二维码图片响应到浏览器
            ImageIO.write(image, "gif", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dogenerate1(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取文本内容
            String url = request.getParameter("url");

            // 生成黑白的二维码
            BufferedImage image = QrCodeGenWrapper.of(url)
                    .asBufferedImage();

            // 将二维码图片响应到浏览器
            ImageIO.write(image, "gif", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
