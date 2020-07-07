package cn.itcast.web.serrvlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//获取流对象之前设置默认编码ISO-8859-1设置为GBK
        response.setCharacterEncoding("GBK");

        //高速浏览器，服务器发送的编码，建议浏览器使用的编码
        response.setHeader("content-type","text/html;charset=gbk");
         
        //简单的形式来设置编码
        response.setContentType("text/html;charset=gbk");*/

        //获取字符输出流
        ServletOutputStream sos = response.getOutputStream();

        //输出数据
        sos.write("你好".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
