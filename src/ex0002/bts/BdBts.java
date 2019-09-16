/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex0002.bts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class BdBts {
    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String CONN_STRING = 
            "jdbc:mysql://localhost:3306/?user=root&password=root&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static Statement st;
    
    
    public void db(){
        try {
            //загружаем драйвер в память
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load driver for MySQL!");
            return;
        }
        //подключение к MySQL (установка соединения)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection to DB!" +
                    ex.getMessage());
            return;
        }
       
        try {
            Statement st = conn.createStatement();
//            st.executeUpdate("CREATE DATABASE dbBTS");
            st.executeUpdate("USE dbBTS");
//            st.executeUpdate("ALTER TABLE tasks ADD COLUMN task varchar (64) AFTER project");
//            st.executeUpdate("CREATE TABLE tasks (project varchar (64), task varchar (64), topic varchar (64), type varchar (32), priority varchar (32), name  varchar (32), description varchar (256))");
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
        }
    
    public void createTask(){
        try {
            //загружаем драйвер в память
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load driver for MySQL!");
            return;
        }
        
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название проекта");
        String project = in.nextLine();
        System.out.println("Введите название задачи");
        String task = in.nextLine();        
        System.out.println("Введите тему");
        String  topic= in.nextLine();
        System.out.println("Введите тип");
        String type = in.nextLine();
        System.out.println("Введите приоритет");
        String  priority= in.nextLine();
        System.out.println("Введите имя испонителя");
        String name = in.nextLine();
        System.out.println("Введите описание");
        String  description= in.nextLine();
        String query01 = "SELECT * FROM tasks ORDER BY project";
        String query02 = "INSERT INTO tasks (project, task, topic, type, priority, name, description) VALUES ('" + project + "', '" + task + "', '"+ topic + "', '" + type + "', '"+ priority + "', '" + name + "', '" + description +"'"+")";

        
        //подключение к MySQL (установка соединения)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection to DB!" +
                    ex.getMessage());
            return;
        }
       
        try{
        st=conn.createStatement();
        st.executeUpdate("USE dbBTS");        
        st.executeUpdate(query02);
        ResultSet rs = st.executeQuery(query01);
        while(rs.next())
            System.out.println(rs.getString("project")+" "+ rs.getString("task")+" "+ rs.getString("topic")+" "+ rs.getString("type")+" "+ rs.getString("priority")+" "+ rs.getString("name")+" "+ rs.getString("description"));

        st.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            }        
        
    
        }
    
    
        public void deleteTask(){
        try {
            //загружаем драйвер в память
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load driver for MySQL!");
            return;
        }
        
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите название проекта, в котором нужно удалить задачу");
        String project = in.nextLine();
        System.out.println("Введите название удаляемой задачи");
        String task = in.nextLine();        
        String query01 = "SELECT * FROM tasks ORDER BY project";
        String query02 = "DELETE FROM tasks WHERE project = "+ "'" + project +"'" + " AND task = "+ "'" + task +"'";
//        String query02 = "DELETE FROM tasks WHERE project = "+ "'" + project +"'";
        
        //подключение к MySQL (установка соединения)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection to DB!" +
                    ex.getMessage());
            return;
        }
       
        try{
        st=conn.createStatement();
        st.executeUpdate("USE dbBTS");        
        st.executeUpdate(query02);
        ResultSet rs = st.executeQuery(query01);
        while(rs.next())
            System.out.println(rs.getString("project")+" "+ rs.getString("task")+" "+ rs.getString("topic")+" "+ rs.getString("type")+" "+ rs.getString("priority")+" "+ rs.getString("name")+" "+ rs.getString("description"));

        st.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            }        
        
    
        }
    
    
        public void deleteProject(){
        try {
            //загружаем драйвер в память
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load driver for MySQL!");
            return;
        }
        
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите удаляемого проекта");
        String project = in.nextLine();
//        System.out.println("Введите название удаляемой задачи");
//        String task = in.nextLine();        
        String query01 = "SELECT * FROM tasks ORDER BY project";
//        String query02 = "DELETE FROM tasks WHERE project = "+ "'" + project +"'" + " AND task = "+ "'" + task +"'";
        String query02 = "DELETE FROM tasks WHERE project = "+ "'" + project +"'";
        
        //подключение к MySQL (установка соединения)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection to DB!" +
                    ex.getMessage());
            return;
        }
       
        try{
        st=conn.createStatement();
        st.executeUpdate("USE dbBTS");        
        st.executeUpdate(query02);
        ResultSet rs = st.executeQuery(query01);
        while(rs.next())
            System.out.println(rs.getString("project")+" "+ rs.getString("task")+" "+ rs.getString("topic")+" "+ rs.getString("type")+" "+ rs.getString("priority")+" "+ rs.getString("name")+" "+ rs.getString("description"));

        st.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            }        
        
    
        }
        public void queryAllUsers(){
        try {
            //загружаем драйвер в память
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load driver for MySQL!");
            return;
        }
        
     
    //    String query01 = "SELECT * FROM tasks ORDER BY project";
        String query02 = "SELECT * FROM tasks";
        
        //подключение к MySQL (установка соединения)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection to DB!" +
                    ex.getMessage());
            return;
        }
       
        try{
        st=conn.createStatement();
        st.executeQuery("USE dbBTS");        
        st.executeQuery(query02);
        ResultSet rs = st.executeQuery(query02);
        while(rs.next())
            System.out.println(rs.getString("name"));

        st.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            }        
        
    
        }
        public void queryAllProjects(){
        try {
            //загружаем драйвер в память
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load driver for MySQL!");
            return;
        }
        
     
    //    String query01 = "SELECT * FROM tasks ORDER BY project";
        String query02 = "SELECT * FROM tasks";
        
        //подключение к MySQL (установка соединения)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection to DB!" +
                    ex.getMessage());
            return;
        }
       
        try{
        st=conn.createStatement();
        st.executeQuery("USE dbBTS");        
        st.executeQuery(query02);
        ResultSet rs = st.executeQuery(query02);
        while(rs.next())
            System.out.println(rs.getString("project"));

        st.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            }        
        
    
        }

        public void queryTasksInProject(){
        try {
            //загружаем драйвер в память
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load driver for MySQL!");
            return;
        }
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите название проекта");
        String project = in.nextLine();
     
    //    String query01 = "SELECT * FROM tasks ORDER BY project";
        String query02 = "SELECT * FROM tasks WHERE project='" + project+ "'";
        
        //подключение к MySQL (установка соединения)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection to DB!" +
                    ex.getMessage());
            return;
        }
       
        try{
        st=conn.createStatement();
        st.executeQuery("USE dbBTS");        
        st.executeQuery(query02);
        ResultSet rs = st.executeQuery(query02);
         System.out.println("\nСписок всех задач в проекте "+project);
        while(rs.next())
            System.out.println(rs.getString("task"));

        st.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            }        
        
    
        }

        public void queryTasksByName(){
        try {
            //загружаем драйвер в память
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load driver for MySQL!");
            return;
        }
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите имя исполнителя");
        String name = in.nextLine();
     
        String query02 = "SELECT * FROM tasks WHERE name='" + name+ "'";
        
        //подключение к MySQL (установка соединения)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection to DB!" +
                    ex.getMessage());
            return;
        }
       
        try{
        st=conn.createStatement();
        st.executeQuery("USE dbBTS");        
        st.executeQuery(query02);
        ResultSet rs = st.executeQuery(query02);
         System.out.println("\nСписок всех задач исполнителя "+name);
        while(rs.next())
            System.out.println(rs.getString("task"));

        st.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            }        
        
    
        }        
        
}
