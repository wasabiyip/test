package test;

public class PersonTest {
    public static void main(String[] args) {
//        IPerson proxy = new IPersonProxy(new IPersonImpl());
    	 IPerson proxy = new CPersonProxy();
        proxy.eating();
        proxy.sleep();
        
//        String a= "hi h2 2i3h 4h2";
//        String [] b= a.split(" ");
//        for (int i=0;i<b.length;i++)
//        System.out.print(b[i]+"\n");
    }
}