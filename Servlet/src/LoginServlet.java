import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //对提交的数据编码
        String name = req.getParameter("name");
        String password = req.getParameter("password");
//        System.out.println(name);
        String html = null;
        if (name.equals("guest") && password.equals("123")) {
//            html = "<div style='color:green'>成功</div>";
            req.getRequestDispatcher("success.html").forward(req,resp); //服务端跳转
        } else {
//            html = "<div style='color:red'>失败</div>";
            resp.sendRedirect("fail.html"); //客户端跳转
        }
//        resp.setContentType("text/html; charset=UTF-8"); //对响应的数据编码
//        PrintWriter pw = resp.getWriter();
//        pw.println(html);
    }
}
