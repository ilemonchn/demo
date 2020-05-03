package com.cnicg.lemon.demo.jdbc;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyJdbc {
    public static void main(String[] args) throws Exception{
//        Class.forName("com.mysql.jdbc.Driver");
        String sql = "CREATE TABLE IF NOT EXISTS board (id BIGINT PRIMARY KEY)";
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("654321");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/order01?useUnicode=true&characterEncoding=utf8&useSSL=false");
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
        boolean result = preparedStatement.execute();
        System.out.println(result);

        ResultSet resultSet = preparedStatement.getResultSet();
        System.out.println(resultSet);

    }
}
