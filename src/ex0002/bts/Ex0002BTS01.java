/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex0002.bts;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Ex0002BTS01 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
//        BdBts bd = new BdBts();
//        bd.db();
        new Menu(new Scanner(System.in)).start();
    }
    
}
