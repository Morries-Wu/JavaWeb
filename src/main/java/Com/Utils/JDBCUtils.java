package Com.Utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    static Properties properties = null;
    static DataSource ds = null;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/jdbc.properties"));
            //1、创建了一个指定参数的数据库连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection() throws Exception {
        //从数据库连接池中获取可用的连接对象
        return ds.getConnection();
    }

    public static void main(String[] args) throws Exception {
        getconnection();
    }


    public static void close(ResultSet set, Statement statement, Connection con) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

}
