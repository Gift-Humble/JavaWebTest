import java.sql.*;

public class test2 {
    public static void main(String[] args) {
        //preparedStatement预编译
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/min_mall1?characterEncoding=utf8&" +
                    "useSSL=false&serverTimezone=UTC";
            connection = DriverManager.getConnection(url, "root", "123123");
            String sql = "select * from 商品列表 where gid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "42");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //只能查出一个
                System.out.println(resultSet.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
