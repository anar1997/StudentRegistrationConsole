/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import util.MenuUtil;
import util.inputUtil;

/**
 *
 * @author anarq
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int menu = 0;
        while (true) {
            menu = inputUtil.requireNumber("what do you want?"
                    + "\n1.Register Student"
                    + "\n2.Show all students"
                    + "\n3.find student"
                    + "\n4.update student");
            MenuUtil.processMenu(menu);
        }
    }
}
