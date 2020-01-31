import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HeroListServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hero> heros = new HeroDAO().list();
        req.setAttribute("heros", heros);
        req.getRequestDispatcher("listHero.jsp").forward(req, resp);
    }
}
