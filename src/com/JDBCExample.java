package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

 
public class JDBCExample {
  public static void main(String[] args) {
    Statement statement = null;
    Connection connection = null;
    /*
     * Here we will learn to Create Table in DB using JDBC Statements in Oracle and MySQL DB
     */
//    String tableCreateQuery = "CREATE TABLE TBL_Department_1420100 (dept_id NUMBER(4) PRIMARY KEY, dept_name Varchar2(30) unique, dept_owner Varchar2(30) unique)";
    String insertQuery = "INSERT INTO TBL_Department_1420100 (dept_id, dept_name) VALUES (1, TBU);";
    String tableCreateQuery = "CREATE TABLE TBL_Student_1420100 ( student_id NUMBER(4) PRIMARY KEY, dept_id NUMBER(4), student_name Varchar2(10), student_address Varchar2(10), student_contact Varchar2(10), FOREIGN KEY (dept_id) REFERENCES TBL_Department_1420100(dept_id))";
    // String insertQuery = "INSERT INTO TBL_Student_1420100 (student_id, dept_id, student_name) VALUES (1, 1, Chakri);";
//    Scanner scanner = new Scanner(System.in);
//    System.out
//        .println("Please provide below details to connect Oracle Database");
//    System.out.println("Enter Database");
//    String dbName = scanner.next();
//    System.out.println("Enter UserName");
//    String userName = scanner.next();
//    System.out.println("Enter Password");
//    String password = scanner.next();
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      connection = DriverManager.getConnection(
          "jdbc:oracle:thin:@localhost:1521:" + "xe", "system",
          "system");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    if (connection != null) {
      System.out.println("nSuccessfullly connected to Oracle DB");
      try {
        statement = connection.createStatement();
        System.out.println("Create Table Query :"+insertQuery);
        statement.execute(insertQuery);
        System.out.println("Inserted Successfully");
      } catch (SQLException e) {
        e.printStackTrace();
    	  //System.out.println("Error!");
      }
    } else {
      System.out.println("nFailed to connect to Oracle DB");
    }
  }
}