package org.github.caishijun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

@RestController
public class DerbyJDBCTestController {

    static {
        try {
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Class.forName("org.apache.derby.jdbc.AutoloadedDriver");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/testDerbyClient")
    public String testDerbyClient(){
        //String url = "jdbc:derby:mydb;create=true";
        //String url = "'jdbc:derby://localhost:1527/E:/db-derby-10.14.2.0-bin/bin/mydb;create=true'";
        String url = "jdbc:derby://localhost:1527/mydb;create=true";
        String result = null;
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();
            //statement.execute("drop table test_user");
            statement.execute("create table test_user(id int ,account varchar(5),name varchar(5),password varchar(16),role_id int)");
            statement.execute("insert into test_user values(2, 'admin', 'zz', 'caishijun' ,1)");
            ResultSet resultSet = statement.executeQuery("select * from test_user");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
            conn.close();
            statement.close();
            resultSet.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return (new Date()).toString();
    }

    @RequestMapping("/testDerbyEmbedded")
    public String testDerbyEmbedded(){
        String url = "jdbc:derby:mydb;create=true";
        String result = null;
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();
            statement.execute("drop table test_user");
            statement.execute("create table test_user(id int ,account varchar(5),name varchar(5),password varchar(16),role_id int)");
            statement.execute("insert into test_user values(2, 'admin', 'zz', 'caishijun' ,1)");
            ResultSet resultSet = statement.executeQuery("select * from test_user");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
            conn.close();
            statement.close();
            resultSet.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return (new Date()).toString();
    }

}
