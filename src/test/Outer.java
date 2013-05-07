package test;

public class Outer{
    private int size=10;
    public class Inner{
          public void doStuff(){
                  System.out.println(++size);
          }
    }
    public abstract class Inner2{
    	public  void dostuff2(){}
    }
    public static interface say {
    	public void saysomething(String something);
    }
    

}

