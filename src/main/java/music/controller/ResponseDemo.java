package music.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/response/*")
public class ResponseDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        int position = uri.lastIndexOf("/");
        String method = uri.substring(position + 1);
        switch (method) {
            case "demo1" -> {
                this.demo1(req, resp);
            }
            case "demo2" -> {
                this.demo2(req, resp);
            }
            case "demo3" -> {
                this.demo3(req, resp);
            }
            case "demo4" -> {
                this.demo4(req, resp);
            }
            case "demo5" -> {
                this.demo5(req, resp);
            }

        }
    }


    private void demo1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("ResponseDemo1........");
        //访问/responseDemo1，会自动跳转到/responseDemo2资源
        // 1. 设置状态码为302
        resp.setStatus(302);
        // 2. 设置响应头location
        resp.setHeader("location", "/response/demo2");
        req.setAttribute("msg", "response");
        //动态获取虚拟目录
        String contextPath = req.getContextPath();
        //简单的重定向方法
        //resp.sendRedirect(contextPath+"/responseDemo2");
        //重定向可以跨域访问
        resp.sendRedirect("https://www.baidu.cn");
    }

    private void demo2(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("responseDemo2被访问...");
        Object msg = req.getAttribute("msg");
        System.out.println(msg);
    }

    private void demo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转发
        req.getRequestDispatcher("demo2").forward(req, resp);
    }

    private void demo4(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
        resp.setCharacterEncoding("utf-8");
        // 告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
        resp.setHeader("content-type", "text/html;charset=utf-8");
        // 简单形式设置编码
        resp.setContentType("text/html;charset=utf-8");
        // 1.获取字符输出流
        PrintWriter pw = resp.getWriter();
        //2.输出数据
        // pw.write("<h1>hello response</h1>");
        pw.write("你好 response");
    }

    private void demo5(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        //1.获取字节输出流
        ServletOutputStream sos=resp.getOutputStream();
        // 2.输出数据
        sos.write("你好".getBytes(StandardCharsets.UTF_8));
    }
}
