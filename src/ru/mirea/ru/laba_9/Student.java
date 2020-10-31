package ru.mirea.ru.laba_9;

public class Student {
    private String firstName = "None";
    private String lastName = "None";
    private int course = 0;
    private boolean past = false;

    public Student(String firstName, String lastName, int course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setPast(boolean past) {
        this.past = past;
    }

    public void setCourse(int course) {
        if ((course > 0) && (course < 5)) {
            this.course = course;
        }
        else {
            System.out.println("Курс введён не правильно (1-4)");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Имя: " + firstName +
                "\nФамилия: " + lastName  +
                "\nКурс: " + course +
                "\nПрава: " + (this.past?"Одобрено":"Не одобрено");
    }
}
