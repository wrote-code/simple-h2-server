package com.wrotecode.h2.simpleh2server;

import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.Server;

import java.sql.SQLException;

public class H2Server {
    public static void main(String[] args) throws SQLException {
        String user = "admin";
        String password = "123456";
        String database = "account";
        if (args.length >= 2) {
            user = args[0];
            password = args[1];
        }
        if (args.length >= 3) {
            database = args[2];
        }
        String url = String.format("jdbc:h2:./%s;AUTO_SERVER=TRUE;", database);
        JdbcConnectionPool pool = JdbcConnectionPool.create(url, user, password);
        System.out.println("连接池创建完成");
        Server.startWebServer(pool.getConnection());
        System.out.println("服务器启动完成，打开浏览器");
    }
}
