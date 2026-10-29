// Case Study 4: abstract parent + four pay rules

abstract class Emp {
    String name;
    double basic;

    Emp(String n, double b) {
        name = n;
        basic = b;
    }

    abstract double pay();
}

class Manager extends Emp {
    Manager(String n, double b) {
        super(n, b);
    }

    double pay() {
        return basic + 0.40 * basic;
    }
}

class Engineer extends Emp {
    Engineer(String n, double b) {
        super(n, b);
    }

    double pay() {
        return basic + 0.20 * basic;
    }
}

class Intern extends Emp {
    Intern(String n, double b) {
        super(n, b);
    }

    double pay() {
        return basic;
    }
}

class Driver extends Emp {
    Driver(String n, double b) {
        super(n, b);
    }

    double pay() {
        return basic + 3000;
    }
}

public class SalarySlip {
    public static void main(String[] args) {

        Emp[] e = {
            new Manager("Meena", 50000),
            new Engineer("Ravi", 40000),
            new Intern("Anu", 12000),
            new Driver("Kumar", 25000)
        };

        for (Emp x : e)
            System.out.printf("%-8s %10.2f%n", x.name, x.pay());
    }
}
