import java.io.FileWriter;
import java.io.IOException;
public class WriteFile {
public static void main(String[] args) {
try (FileWriter fw = new FileWriter("student.txt")) {
fw.write("101,Aravind,78\n");
fw.write("102,Divya,91\n");
fw.write("103,Karthik,45\n");
System.out.println("File written successfully.");
} catch (IOException e) {
System.out.println("Error : " + e.getMessage());
}
}
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadFile {
public static void main(String[] args) {
try (BufferedReader br =
new BufferedReader(new FileReader("student.txt"))) {
String line;
System.out.println("ROLL NAME MARKS");
while ((line = br.readLine()) != null) {
String[] f = line.split(",");
System.out.printf("%-6s%-10s%s%n", f[0], f[1], f[2]);
}
} catch (IOException e) {
System.out.println("Error : " + e.getMessage());
}
}
}
