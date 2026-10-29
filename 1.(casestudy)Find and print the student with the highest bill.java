class Boarder {
    String name;
    int days;

    Boarder(String n, int d) {
        name = n;
        days = d;
    }

    double bill() {
        return days * 85.0;
    }
}

public class MessBill {
    public static void main(String[] args) {

        Boarder[] list = {
            new Boarder("Aravind", 28),
            new Boarder("Divya", 30),
            new Boarder("Karthik", 25)
        };

        double total = 0;
        Boarder highest = list[0];

        System.out.println("NAME DAYS BILL");

        for (Boarder b : list) {
            System.out.printf("%-10s %4d %8.2f%n",
                    b.name, b.days, b.bill());

            total = total + b.bill();

            if (b.bill() > highest.bill()) {
                highest = b;
            }
        }

        System.out.printf("Total collection = Rs. %.2f%n", total);

        System.out.printf("Highest bill: %s - Rs. %.2f%n",
                highest.name, highest.bill());
    }
}
