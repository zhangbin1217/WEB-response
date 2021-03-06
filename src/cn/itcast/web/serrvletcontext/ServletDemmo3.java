package cn.itcast.web.serrvletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletDemo3")
public class ServletDemmo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * servlet对象获取
         *  1.获取MIME type
         *  2.域对象，共享数据
         *  3.获取文件的真实(服务器)路径
         *
         */
        //通过HttpServlet获取
        ServletContext servletContext2 = this.getServletContext();

        //保存数据
        servletContext2.setAttribute("msg","haha");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
