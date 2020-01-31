import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAOTest {
    public HeroDAOTest() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/min_mall1?characterEncoding=utf8&" +
                "useSSL=false&serverTimezone=UTC", "root", "123123");
    }

    public List<Hero> list() {
        return list(0, Short.MAX_VALUE);
    }

    private List<Hero> list(int start, int count) {
        List<Hero> heros = new ArrayList<Hero>();
        String sql = "select * from 商品列表 order by gid desc limit ?,?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                hero.id = id;
                hero.name = name;
                heros.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }

    public static void main(String[] args) {
        List<Hero> heros = new HeroDAO().list();
        System.out.println(heros);
    }
}
