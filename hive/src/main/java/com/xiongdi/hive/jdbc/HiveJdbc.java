package com.xiongdi.hive.jdbc;

import java.sql.*;

public class HiveJdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //①加载驱动 ,这行可以省略
        //Class.forName("org.apache.hive.jdbc.HiveDriver");

        //②创建连接
        Connection connection = DriverManager.getConnection("jdbc:hive2://hadoop1:10000", "root", "123456");

        // ③准备SQL
        String sql="select * from default.person";

        // ④预编译sql
        PreparedStatement ps = connection.prepareStatement(sql);

        // ⑤执行sql
        ResultSet resultSet = ps.executeQuery();

        while(resultSet.next()) {

            System.out.println("name:"+resultSet.getString("name")+"---->age:"+
                    resultSet.getInt("age"));

        }

    }
}
