package test;
public class ThreadExample1 extends Thread {
    public void run() { // overwrite Thread's run()
        System.out.println("Here is the starting point of Thread.");
        for (;;) { // infinite loop to print message
            System.out.println("User Created Thread");
            yield();
        }
    }
    public static void main(String[] argv) {
        Thread t = new ThreadExample1(); // �a��Thread���
        t.start(); // �_ʼ����t.run()
        for (;;) {
            System.out.println("Main Thread");
            yield();
        }
    }
}