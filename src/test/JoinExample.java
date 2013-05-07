package test;
public class JoinExample extends Thread {
    String myId;
    public JoinExample(String id) {
        myId = id;
    }
    public void run() { // overwrite Thread's run()
	for (int i=0; i < 500; i++) {
            System.out.println(myId+" Thread");
        }
    }
    public static void main(String[] argv) {
        Thread t1 = new JoinExample("T1"); // 產生Thread物件
        Thread t2 = new JoinExample("T2"); // 產生Thread物件
        t1.start(); // 開始執行t1.run()
        t2.start();
        try {
            t1.join(); // 等待t1結束
            System.out.println("t1 join");
            t2.join(); // 等待t2結束
            System.out.println("t2 join");
        } catch (InterruptedException e) {}
        for (int i=0;i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}

