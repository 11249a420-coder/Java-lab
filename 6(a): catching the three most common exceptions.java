public class PredefinedDemo {
public static void main(String[] args) {
try {
int[] a = new int[3];
a[5] = 10;
} catch (ArrayIndexOutOfBoundsException e) {
System.out.println("Array error : index " + e.getMessage());
}

Page 27 of 62

SCSVMV University | Department of Computer Science and Engineering | Java Programming Laboratory

try {
int x = 10 / 0;
} catch (ArithmeticException e) {
System.out.println("Math error : " + e.getMessage());
}
try {
String s = null;
System.out.println(s.length());
} catch (NullPointerException e) {
System.out.println("Null error : the object was never created");
} finally {
System.out.println("finally : always runs");
}
System.out.println("Program continued normally.");
}
}
