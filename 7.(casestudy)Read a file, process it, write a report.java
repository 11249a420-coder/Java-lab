import java.io.*;

public class ResultReport {
    public static void main(String[] args) {
        int pass = 0, fail = 0, total = 0, n = 0;
        int highest = -1;
        String topper = "";

        try (BufferedReader br = new BufferedReader(
                 new FileReader("student.txt"));
             PrintWriter pw = new PrintWriter("result.txt")) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] f = line.split(",");
                int m = Integer.parseInt(f[2].trim());

                total += m;
                n++;

                if (m > highest) {
                    highest = m;
                    topper = f[1].trim();
                }

                if (m >= 50) {
                    pass++;
                    pw.println(f[1] + " PASS");
                } else {
                    fail++;
                    pw.println(f[1] + " FAIL");
                }
            }

            pw.println("Passed : " + pass);
            pw.println("Failed : " + fail);

            if (n > 0) {
                pw.printf("Average : %.2f%n", (double) total / n);
                pw.println("Topper : " + topper);
                pw.println("Highest Marks : " + highest);
            }

            System.out.println("result.txt created. Passed "
                + pass + ", failed " + fail);
            System.out.println("Topper: " + topper);

        } catch (IOException e) {
            System.out.println("File error : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid marks in file.");
        }
    }
}
