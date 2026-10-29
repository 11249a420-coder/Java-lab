// Ex 5(a): the two ways of creating a thread
class First extends Thread {
 public void run() {
 for (int i = 1; i <= 3; i++)
 System.out.println("Thread A : " + i);
 }
}
class Second implements Runnable {
 public void run() {
 for (int i = 1; i <= 3; i++)
 System.out.println("Thread B : " + i);
 }
}
public class ThreadDemo {
 public static void main(String[] args) {
 First a = new First();
 Thread b = new Thread(new Second());
 a.start();
 b.start();
 }
Page 23 of 62
SCSVMV University | Department of Computer Science and Engineering | Java Programming Laboratory
}
