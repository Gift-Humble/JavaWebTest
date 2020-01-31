import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("First Filter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String ip = request.getRemoteAddr(); //浏览器所处于的客户机的IP地址
        String url = request.getRequestURL().toString();//浏览器发出请求时的完整URL

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String date = sdf.format(d);
//        System.out.println(request.getParameter("name"));
//        request.setCharacterEncoding("UTF-8");
        System.out.println(date + " " + ip + "访问了" + url);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
