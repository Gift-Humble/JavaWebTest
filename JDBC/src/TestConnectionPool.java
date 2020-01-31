import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionPool {
    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPool(3);
        for (int i = 0; i < 9; i++) {
            new WorkingThread("working thread" + i, cp).start();
        }
    }
}

class WorkingThread extends Thread {
    private ConnectionPool cp;

    public WorkingThread(String name, ConnectionPool cp) {
        super(name);
        this.cp = cp;
    }

    public void run() {
        Connection c = cp.getConnection();
        System.out.println(this.getName() + ":\t 获取了一根连接，并开始工作");
        try (Statement st = c.createStatement()) {
            //模拟耗时1秒的数据库SQL语句
            Thread.sleep(1000);
            st.execute("select * from 商品列表");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}
