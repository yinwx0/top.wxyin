package music.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/request/*")
@Slf4j
public class RequestServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求URL
        String uri = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        log.info(uri);
        log.info(String.valueOf(requestURL));

        int position = uri.lastIndexOf("/");
        String method = uri.substring(position + 1);
        switch (method){
            case  "demo1"-> {
                this.demo1(req,resp);
            }
            case  "demo2"-> {
                this.demo2(req,resp);
            }
            case  "demo3"-> {
                this.demo3(req,resp);
            }
            case  "demo4"-> {
                this.demo4(req,resp);
            }
            case  "demo5"-> {
                this.demo5(req,resp);
            }
            case  "demo6"-> {
                this.demo6(req,resp);
            }
            case  "demo7"-> {
                this.demo7(req,resp);
            }
            case  "demo8"-> {
                this.demo8(req,resp);
            }
            case  "demo9"-> {
                this.demo9(req,resp);
            }
            case  "demo10"-> {
                this.demo10(req,resp);
            }
        }
    }


    /**
     * HttpServletRequest 获取请求行数据
     * @param req   请求对象
     * @param resp  响应对象
     * @throws ServletException   servlet异常
     * @throws IOException        io异常
     */

    private void demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取请求的方式
        String method = req.getMethod();
        log.info(method);
        //获取 servlet 路径
        String servletPath = req.getServletPath();
        log.info(servletPath);
        //获取虚拟目录
        String contextPath = req.getContextPath();
        log.info(contextPath);
        //获取请求参数
        String queryString = req.getQueryString();
        if(queryString != null){
            log.info(queryString);
            //请求参数分割
            String[] s = queryString.split("&");
            log.info(s[0]);
            log.info(s[1]);
            ////二次分割
            String[] s1 = s[0].split("=");
            log.info(s1[0]);
            log.info(s1[1]);
            String[] s2 = s[1].split("=");
            log.info(s2[0]);
            log.info(s2[1]);
        }
        //获取请求URL
        log.info(contextPath);
        //获取协议及版本
        String protocol = req.getProtocol();
        log.info(protocol);
        //获取客户机的IP地址
        String remoteAddr = req.getRemoteAddr();
        log.info(remoteAddr);
    }
    private void demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //设置响应头的数据格式和编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //设置响应内容
        String Method = req.getContextPath();
        resp.getWriter().println("请求方式："+ Method+"<br/>");
    }

    private void demo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取请求头数据
        //1.获取请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        //2.遍历
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = req.getHeader(name);
            System.out.println(name + "---" + value);
        }
    }
    private void demo4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            //获取请求头数据:user-agent
            String agent=req.getHeader("user-agent");
            //判断agent的浏览器版本
            if(agent.contains("Chrome")){
                System.out.println("谷歌浏览器...");
            }else if(agent.contains("Firefox")){
                System.out.println("火狐浏览器...");
            }
    }
    private void demo5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取请求消息体--请求参数
        //1.获取字符流
        BufferedReader br = req.getReader();
        //2.读取数据
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
    private void demo6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //post 获取请求参数
        //根据参数名称获取参数值
        System.out.println("根据参数名称获取参数值");
        String username = req.getParameter("username");
        System.out.println(username);
        //根据参数名称获取参数值的数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        //获取所有请求的参数名称
        System.out.println("**********************");
        System.out.println("获取所有请求的参数名称");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = req.getParameter(name);
            System.out.println(value);
            System.out.println("----------------");
        }
        // 获取所有参数的map集合
        System.out.println("***********************");
        System.out.println("获取所有参数的map集合");
        Map<String, String[]> parameterMap = req.getParameterMap();
        //遍历
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("-----------------");
    }
    }
    private void demo7(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.设置请求的编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数username
        String username = req.getParameter("username");
        System.out.println(username);
    }
    private void demo8(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("demo8被访问了...");
        //存储数据到request域中
        req.setAttribute("msg", "hello");
        //转发到requestDemo9资源
        req.getRequestDispatcher("/requestDemo8").forward(req, resp);
        // ⽆法跨域转发
        //req.getRequestDispatcher("http://www.baidu.com").forward(req,resp);
    }
    private void demo9(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Object msg = req.getAttribute("msg");
        System.out.println(msg);
        System.out.println("demo9被访问了。。。");
    }
    private void demo10(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);
    }
}
