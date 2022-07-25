/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author anarq
 */
public class MenuUtil {

    public static void processMenu(int selectMenu) {//mellim switch ile edib
        if (selectMenu == 1) {
            StudentUtil.registerStudents();
        } else if (selectMenu == 2) {
            StudentUtil.PrintAllRegistrationStudents();
        } else if (selectMenu == 3) {
            StudentUtil.FindStudentandPrint();
        } else if (selectMenu == 4) {
            StudentUtil.updateStudentWithNewObject();
        }
    }

    public static String requireName() {
        return inputUtil.requireText("enter name");
    }

    public static String requireSurname() {
        return inputUtil.requireText("enter Surname");
    }

    public static String requireClassname() {
        return inputUtil.requireText("enter classname");
    }

    public static int requireAge() {
        return inputUtil.requireNumber("enter age");
    }

    public static void SuccessOppMessage() {
        System.out.println("Operation completed succesfully");
    }
}
