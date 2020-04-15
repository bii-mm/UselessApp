package br.mack.ps2.persistencia;
import java.sql.*;
public class MySQLConnection {
    String url = "jdbc:mysql://192.168.99.100:32771/uselessApp";
    String user = "root";
    String psw = "root";

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,psw);
        }catch (final Exception er){
            er.printStackTrace();
            return null;
        }
    }
}
