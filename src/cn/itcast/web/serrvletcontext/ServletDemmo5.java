package cn.itcast.web.serrvletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletDemo5")
public class ServletDemmo5 extends HttpServlet {
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

        //获取服务器路径
        String a = servletContext2.getRealPath("./src/a.txt");//src目录下资源访问
        System.out.println(a);
        //File file=new File(realPath);

        String b = servletContext2.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(b);

        String c = servletContext2.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下资源访问
        System.out.println(c);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
