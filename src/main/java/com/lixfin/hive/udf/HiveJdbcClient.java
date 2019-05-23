package com.lixfin.hive.udf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class HiveJdbcClient {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String HIVE_SERVER2 = "jdbc:hive2://nn01.xxx.com:2181,nn02.xxx.com:2181,rm01.xxx.com:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2";


    public static void main(String[] args) {

        try {
            Class.forName(driverName);

            Properties properties = new Properties();
            properties.setProperty("user", "someuser");
            properties.setProperty("password", "somepassword");


         

            Connection con = DriverManager.getConnection(HIVE_SERVER2, "someuser", "somepassword");

            System.out.println("Got the connection");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

    }
}
