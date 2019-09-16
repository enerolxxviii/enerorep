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
    
    
    public void createDb(){
        try {
            //загружаем драйвер в память
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load driver for MySQL!");
            return;
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название новой базы данных");
        String bdName = in.nextLine();
        String query00 = "CREATE DATABASE "+bdName;
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
            st.executeUpdate(query00);
            System.out.println("\nСоздана новая база данных "+bdName+".");
            st.close();    
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
        }

    public void createTable(){
        try {
            //загружаем драйвер в память
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load driver for MySQL!");
            return;
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название нужной базы данных");
        String bdName = in.nextLine();
        System.out.println("Введите название нового рабочего файла");
        String table = in.nextLine();
        String query00 = "USE "+bdName;
        String query01 = "CREATE TABLE "+table+" (project varchar (64), task varchar (64), topic varchar (64), type varchar (32), priority varchar (32), name  varchar (32), description varchar (256))";
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
            st.executeUpdate(query00);
            st.executeUpdate(query01);
            System.out.println("\nВ базе данных "+bdName+" cоздан новый рабочий файл "+table+".");
            st.close();    
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
        System.out.println("Введите название базы данных, c которой Вы хотите работать.");
        String bdName = in.nextLine(); 
        System.out.println("Введите название нужного рабочего файла.");
        String tableName = in.nextLine();
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
        System.out.println("Введите имя исполнителя");
        String name = in.nextLine();
        System.out.println("Введите описание");
        String  description= in.nextLine();
        String query00 = "USE "+bdName;
        String query01 = "SELECT * FROM "+tableName+" ORDER BY project";
        String query02 = "INSERT INTO "+tableName+" (project, task, topic, type, priority, name, description) VALUES ('" + project + "', '" + task + "', '"+ topic + "', '" + type + "', '"+ priority + "', '" + name + "', '" + description +"'"+")";     
        
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
        st.executeUpdate(query00);        
        st.executeUpdate(query02);
        ResultSet rs = st.executeQuery(query01);
        System.out.println("\nЗадача "+task+" проекта "+project+" в файл "+tableName + " базы данных "+bdName+ " введена со следующими атрибутами:");
        System.out.println("Тема: "+topic+"; Тип: "+type+"; Приоритет: "+priority+"; Исполнитель: "+name+"; Описание: "+description);
        // проверка работоспособности программы
        //while(rs.next())
         //   System.out.println(rs.getString("project")+" "+ rs.getString("task")+" "+ rs.getString("topic")+" "+ rs.getString("type")+" "+ rs.getString("priority")+" "+ rs.getString("name")+" "+ rs.getString("description"));

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
        System.out.println("Введите название базы данных, в которой Вы хотите работать.");
        String bdName = in.nextLine();  
        System.out.println("Введите название нужного рабочего файла.");
        String tableName = in.nextLine();
        System.out.println("Введите название проекта, в котором нужно удалить задачу");
        String project = in.nextLine();
        System.out.println("Введите название удаляемой задачи");
        String task = in.nextLine();  
        String query00 = "USE "+bdName;
        String query01 = "SELECT * FROM "+tableName+" ORDER BY project";
        String query02 = "DELETE FROM "+tableName+" WHERE project = "+ "'" + project +"'" + " AND task = "+ "'" + task +"'";


        
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
        st.executeUpdate(query00);        
        st.executeUpdate(query02);
        ResultSet rs = st.executeQuery(query01);
        System.out.println("\nЗадача "+task+" из проекта "+project+" файла "+tableName +" базы данных "+bdName+ " удалена.");
        // проверка работоспособности программы
        //while(rs.next())
        //    System.out.println(rs.getString("project")+" "+ rs.getString("task")+" "+ rs.getString("topic")+" "+ rs.getString("type")+" "+ rs.getString("priority")+" "+ rs.getString("name")+" "+ rs.getString("description"));

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
        System.out.println("Введите название базы данных, в которой Вы хотите работать.");
        String bdName = in.nextLine();
        System.out.println("Введите название нужного рабочего файла.");
        String tableName = in.nextLine();
        System.out.println("Введите название удаляемого проекта");
        String project = in.nextLine();
        String query00 = "USE "+bdName;
        String query01 = "SELECT * FROM "+tableName+" ORDER BY project";
        String query02 = "DELETE FROM "+tableName+" WHERE project = "+ "'" + project +"'";
        
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
        st.executeUpdate(query00);        
        st.executeUpdate(query02);
        ResultSet rs = st.executeQuery(query01);
        System.out.println("\nПроект " +project+" из файла"+tableName +" базы данных "+bdName+ " удален со всеми задачами.");
        // проверка работоспособности программы
       // while(rs.next())
       //     System.out.println(rs.getString("project")+" "+ rs.getString("task")+" "+ rs.getString("topic")+" "+ rs.getString("type")+" "+ rs.getString("priority")+" "+ rs.getString("name")+" "+ rs.getString("description"));

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
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название базы данных, в которой Вы хотите работать.");
        String bdName = in.nextLine();
        System.out.println("Введите название нужного рабочего файла.");
        String tableName = in.nextLine();        
        String query00 = "USE "+bdName;
    //    String query01 = "SELECT * FROM tasks ORDER BY project";
        String query02 = "SELECT * FROM "+tableName;
        
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
        st.executeQuery(query00);        
        st.executeQuery(query02);
        ResultSet rs = st.executeQuery(query02);
        System.out.println("\nИмена пользователей файла "+tableName+" базы данных "+bdName+ ":");
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
        
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название базы данных, в которой Вы хотите работать.");
        String bdName = in.nextLine();
        System.out.println("Введите название нужного рабочего файла.");
        String tableName = in.nextLine();
        String query00 = "USE "+bdName;        
    //    String query01 = "SELECT * FROM tasks ORDER BY project";
        String query02 = "SELECT * FROM "+tableName;
        
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
        st.executeQuery(query00);        
        st.executeQuery(query02);
        ResultSet rs = st.executeQuery(query02);
        System.out.println("\nСписок всех проектов файла "+tableName+" из базы данных "+bdName+ ":");
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
        System.out.println("Введите название базы данных, в которой Вы хотите работать.");
        String bdName = in.nextLine();
        System.out.println("Введите название нужного рабочего файла.");
        String tableName = in.nextLine();
        System.out.println("Введите название проекта");
        String project = in.nextLine();
        String query00 = "USE "+bdName;      
    //    String query01 = "SELECT * FROM tasks ORDER BY project";
        String query02 = "SELECT * FROM "+tableName+" WHERE project='" + project+ "'";
        
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
        st.executeQuery(query00);        
        st.executeQuery(query02);
        ResultSet rs = st.executeQuery(query02);
        System.out.println("\nСписок всех задач в проекте "+project+" из Файла "+tableName+" базы данных "+bdName+ ":");
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
        System.out.println("Введите название базы данных, в которой Вы хотите работать.");
        String bdName = in.nextLine();
        System.out.println("Введите название нужного рабочего файла.");
        String tableName = in.nextLine();
        System.out.println("Введите имя исполнителя");
        String name = in.nextLine();
        String query00 = "USE "+bdName;      
        String query02 = "SELECT * FROM "+tableName+" WHERE name='" + name+ "'";
        
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
        st.executeQuery(query00);        
        st.executeQuery(query02);
        ResultSet rs = st.executeQuery(query02);
        System.out.println("\nБаза данных "+bdName+ " Рабочий файл "+tableName+". Список всех задач исполнителя "+name+":");
        while(rs.next())
           System.out.println(rs.getString("task"));

        st.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            }        
        
    
        }
        
}
