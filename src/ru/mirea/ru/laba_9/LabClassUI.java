package ru.mirea.ru.laba_9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LabClassUI {
    public static void main(String[] args) {
        Student[] students = {new Student("Иван", "Иванов"), new Student("Николай", "Николаев"),
                new Student("Алексей", "Алексеев"), new Student("Дмитрий", "Медведь"),
                new Student("Ахмед", "Ахмедов")};
        Scanner cin = new Scanner(System.in);
        try {
            students[0].setCourse(cin.nextInt());
        }catch (InputMismatchException err){
            System.out.println("Введите корректное значение курса");
        }
        System.out.println(students[0]);
        students[0].setPast(LabClassDriver.pastTest());
        System.out.println(students[0]);
        System.out.println("Поиск студента в базе:");
        cin.nextLine();
        System.out.println("Имя: ");
        String name = "";
        String surname = "";
        try {
            name = cin.nextLine();
            if(name.length() == 0){
                throw new EmptyStringException("Пустоя строка");
            }
            System.out.println("Фамилия: ");
            surname = cin.nextLine();
            if(surname.length() == 0){
                throw new EmptyStringException("Пустоя строка");
            }
        }catch (EmptyStringException err){
            System.out.println("Пустоя строка");
        }
        findStudent(name, surname, students);        //Поиск студента
    }

    private static void findStudent(String name, String surname, Student [] students){
        boolean studentFunded = true;
        for (Student student : students) {
            if (student.getFirstName().equals(name) && student.getLastName().equals(surname)) {
                System.out.println(student);
                studentFunded = false;
            }
        }
        try {
            if(studentFunded){
                throw new StudentNotFoundException("Студент \'" + name + " " + surname + "\' не найден");
            }
        }catch (StudentNotFoundException err){
            System.out.println("Студент \'" + name + " " + surname + "\' не найден");
        }
    }
}
