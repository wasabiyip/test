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
        Thread t1 = new JoinExample("T1"); // �a��Thread���
        Thread t2 = new JoinExample("T2"); // �a��Thread���
        t1.start(); // �_ʼ����t1.run()
        t2.start();
        try {
            t1.join(); // �ȴ�t1�Y��
            System.out.println("t1 join");
            t2.join(); // �ȴ�t2�Y��
            System.out.println("t2 join");
        } catch (InterruptedException e) {}
        for (int i=0;i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}

