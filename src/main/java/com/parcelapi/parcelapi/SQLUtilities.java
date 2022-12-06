package com.parcelapi.parcelapi;
import java.sql.*;

public class SQLUtilities {
        public static final String url ="jdbc:sqlserver://LAPTOP-PB27B2LT\\SQLEXPRESS;databaseName=ParcelMessenger";
        public static Connection connection;
        public static final String username = "sa";
        public static final String password = "Password123#";

        public SQLUtilities(){}

        public static boolean Connect(){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url,username,password);
                return true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }
        public static boolean Disconnect(){
            try {
                connection.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        public static int ExecuteNonQuery(PreparedStatement preparedStatement){
            try {
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            }
        }
        public static ResultSet ExecuteQuery(PreparedStatement preparedStatement){
            try {
                return preparedStatement.executeQuery();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
}
