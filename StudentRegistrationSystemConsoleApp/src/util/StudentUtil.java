/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import beans.Config;
import beans.Student;

/**
 *
 * @author anarq
 */
public class StudentUtil {

    public static Student fillStudent() {
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        String className = MenuUtil.requireClassname();
        int age = MenuUtil.requireAge();
        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void PrintAllRegistrationStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            System.out.println((i + 1) + "." + st.getFullInfo());
        }
    }

    public static void registerStudents() {
        int count = inputUtil.requireNumber("nece telebe qeydiyyatdan kecireceksiniz?");
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + "register");
            Config.students[i] = StudentUtil.fillStudent();
        }
        MenuUtil.SuccessOppMessage();
        StudentUtil.PrintAllRegistrationStudents();
    }

    public static void FindStudentandPrint() {
        String text = inputUtil.requireText("type name, surname or class");
        Student[] result = findStudents(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getFullInfo());
        }
    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }

        }
        Student[] result = new Student[count];

        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found] = st;
                found++;
            }
        }
        return result;
    }

    public static void updateStudentWithNewObject() {
        StudentUtil.PrintAllRegistrationStudents();
        int i = inputUtil.requireNumber("necenci adamda deyisiklik etmek isteyirsiniz?");
        System.out.println("yeni melumatlari daxil edin:");
        Student s = StudentUtil.fillStudent();
        Config.students[i - 1] = s;
    }

    public static void updateStudentWithSameObject() {
        StudentUtil.PrintAllRegistrationStudents();
        int i = inputUtil.requireNumber("necenci adamda deyisiklik etmek isteyirsiniz?");
        System.out.println("yeni melumatlari daxil edin:");
        Student selectedStudent = Config.students[i - 1];
        String changeParams = inputUtil.requireText("neleri deyismek isteyirsiniz, 'name','surname','age'");
        if (changeParams.contains("'name'")) {
            selectedStudent.setName(MenuUtil.requireName());
        }
        if (changeParams.contains("'surname'")) {
            selectedStudent.setSurname(MenuUtil.requireSurname());
        }
        if (changeParams.contains("'age'")) {
            selectedStudent.setAge(MenuUtil.requireAge());
        }
        if (changeParams.contains("'classname'")) {
            selectedStudent.setClassName(MenuUtil.requireClassname());
        }
    }

    public static void updateStudentWithSplit() {
        StudentUtil.PrintAllRegistrationStudents();
        int index = inputUtil.requireNumber("necenci adamda deyisiklik etmek isteyirsiniz?");
        System.out.println("yeni melumatlari daxil edin:");
        Student selectedStudent = Config.students[index - 1];
        String changeParams = inputUtil.requireText("neleri deyismek isteyirsiniz, name,surname,age");
        String[] parametrs = changeParams.split(",");
        for (int i = 0; i < parametrs.length; i++) {
            String param = parametrs[i];
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(MenuUtil.requireName());
            }
            if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(MenuUtil.requireSurname());
            }
            if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(MenuUtil.requireAge());
            }
            if (param.equalsIgnoreCase("class")) {
                selectedStudent.setClassName(MenuUtil.requireClassname());
            }
        }

    }
}
