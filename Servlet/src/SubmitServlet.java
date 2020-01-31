import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class SubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String data = request.getParameter("data");
        JSONObject json = JSONObject.fromObject(data);
        System.out.println("服务端接收到的数据是：" + data);
        try {
            System.out.println("转换为JSON对象之后是：" + json);
            Hero hero = (Hero) JSONObject.toBean(json, Hero.class);
            System.out.println("转换为Hero对象之后是：" + hero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 