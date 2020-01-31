import net.sf.json.JSONObject;

public class test1 {
    public static void main(String[] args) {
        String data = "{\"name\":\"lin\",\"hp\":\"121212\"}";

        JSONObject json = JSONObject.fromObject(data);

        System.out.println("转换为JSON对象之后是：" + json);

        Hero hero = (Hero) JSONObject.toBean(json, Hero.class);
        System.out.println("转换为Hero对象之后是：" + hero);
    }
}
