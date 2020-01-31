import java.sql.*;

public class test1 {
    public static void main(String[] args) {
        //Statement执行
        Connection connection = null;
        Statement statement = null;
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取数据库连接对象
            String url = "jdbc:mysql://localhost:3306/min_mall1?characterEncoding=utf8&" +
                    "useSSL=false&serverTimezone=UTC";
            connection = DriverManager.getConnection(url, "root", "123123");
            //创建statement执行sql语句
            statement = connection.createStatement();
            String sql = "select * from 商品列表";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("gid"); //直接根据字段名获取
                String name = resultSet.getString(2); //第二列
                System.out.println("id=" + id + ", name=" + name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
