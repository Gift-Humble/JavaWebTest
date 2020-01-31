import java.sql.*;

public class test3 {
    public static void main(String[] args) {
        //execute和executeUpdate不同点
        //1、executeUpdate不能查询
        // 2、execute返回true or false  executeUpdate返回影响条数
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
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
            System.out.println(statement.execute(sql));

            String sql2 = "insert into 店铺收藏表 values(null,?,?)";
            preparedStatement = connection.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, 5);
            preparedStatement.execute(); //执行插入语句sql2
            ResultSet rs = preparedStatement.getGeneratedKeys(); //获取自增id
            if (rs.next()) {
                System.out.println(rs.getInt(1));
            }
//            System.out.println(statement.executeUpdate(sql));
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
