package com.scsvmv.fee;

class Student {
    public String name;
    public String course;

    public Student(String n, String c) {
        name = n;
        course = c;
    }
}

class FeeRule {
    public static double fee(String course) {
        if (course.equals("BE"))
            return 75000;

        if (course.equals("ME"))
            return 60000;

        return 40000;
    }
}

class FeeReport {
    public static void print(Student[] students) {
        double total = 0;

        for (Student x : students) {
            double f = FeeRule.fee(x.course);

            System.out.printf("%-8s %-5s %10.2f%n",
                    x.name, x.course, f);

            total = total + f;
        }

        System.out.printf("Total fee = %.2f%n", total);
    }
}

public class FeeApp {
    public static void main(String[] args) {

        Student[] s = {
            new Student("Meena", "BE"),
            new Student("Ravi", "ME"),
            new Student("Anu", "BSc")
        };

        FeeReport.print(s);
    }
}
