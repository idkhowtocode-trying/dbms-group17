package controller;
import java.io.*;
import java.io.Console.*;
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
public class DataBase {
    public static void connection() throws SQLException, IOException{
        Console console = System.console();
        System.out.print("Enter your username: "); // type "22104071d" with double quotation
        String username = console.readLine();
        System.out.print("Enter your password: "); // c05E0cb674D.
        char [] password = console.readPassword();
        String pwd = String.valueOf(password);

        // Connections
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        OracleConnection conn =
                (OracleConnection)DriverManager.getConnection(
                        "jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms",username,pwd);

        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("SELECT EMPNO, ENAME, JOB FROM EMP");
        while (rset.next())
        {
            System.out.println(rset.getInt(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3));
        }
        System.out.println();
        conn.close();
    }
}
