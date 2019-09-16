/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex0002.bts;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Menu {
    private final Scanner scanner;
    public Menu(Scanner scanner){
        this.scanner=scanner;
    }
    
    private void printMenu(){
        System.out.println("\nМеню:");
        System.out.println("1. Создать новую базу данных");
        System.out.println("2. Создать файл для работы в базе данных");
        System.out.println("3. Создать задачу");
        System.out.println("4. Удалить задачу");
        System.out.println("5. Удалить проект");
        System.out.println("6. Сделать запрос");
        System.out.println("7. Выход из приложения\n");

    }
        private void printMenu2(){
        System.out.println("\nВыберите интересующий запрос:");
        System.out.println("1. Получить список всех пользователей");
        System.out.println("2. Получить список всех проектов");
        System.out.println("3. Получить список всех задач в проекте");
        System.out.println("4. Получить список всех задач, назначенных на конкретного исполнителя");
        System.out.println("5. Возврат в предущее меню");

    }
    
    public void start(){
        if(this.scanner!=null){
            int choice;
            do{
                printMenu();
                System.out.println("Выберите пункт меню");
                choice = this.scanner.nextInt();
                BdBts bd = new BdBts();

                switch (choice) {                   
                    case 1:
                        bd.createDb();
                        break;
                    case 2:
                        bd.createTable();
                        break;
                    case 3:
                        bd.createTask();
                        break;
                    case 4:
                        bd.deleteTask();
                        break;            
                    case 5:
                        bd.deleteProject();
                        break;                 
                    case 6:
                        int choice2;
                        do{
                            printMenu2();
                            choice2=this.scanner.nextInt();
                            BdBts bd2 = new BdBts();                         
                            switch (choice2){
                                case 1:
                                    System.out.println("\nСписок всех пользователей:");
                                    bd2.queryAllUsers();
                                    break;
                                case 2:
                                    System.out.println("\nСписок всех проектов указанной базы данных:");
                                    bd2.queryAllProjects();
                                    break;                                    
                                case 3:
                                    bd2.queryTasksInProject();
                                    break;    
                                case 4:
                                    bd2.queryTasksByName();
                                    break;
                                case 5:
                                    System.out.println("\nВозврат к предыдущему меню");
                                default:
                                    if(choice==5){}
                                else System.out.println("Вы ввели несуществующий пункт меню...\n");                                    
                            }
                        
                        }while (choice2 !=5);
                        break;
                    case 7:
                        System.out.println("\nЗавершение программы...");
                    default:
                        if(choice==7){
                        //    System.out.println("");
                        }
                        else System.out.println("Вы ввели несуществующий пункт меню...\n");
                }             
            }while (choice !=7);  
        }
    }
    
}
