package util;

import entity.ClusterInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @ClassName: InsertInstance2DB
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/9/11 16:39
 * @Version: 1.0
 */
public class InsertInstance2DB {
    private static PreparedStatement PREPARED_STMT = null;
    static {
        // create a mysql database connection
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai";
        try {
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "123456");
            // the mysql insert statement
            String query = " insert into edge (create_time, i1, i2, i3, i4, i5)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PREPARED_STMT = conn.prepareStatement(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insert(ClusterInstance instance) {
        boolean res = false;
        try
        {
            PREPARED_STMT.setString (1, instance.getTimestamp());
            PREPARED_STMT.setDouble (2, instance.getI1());
            PREPARED_STMT.setDouble (3, instance.getI2());
            PREPARED_STMT.setDouble (4, instance.getI3());
            PREPARED_STMT.setDouble (5, instance.getI4());
            PREPARED_STMT.setDouble (6, instance.getI5());
            // execute the preparedstatement
            PREPARED_STMT.execute();

//            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
