package test;

public class TestOuter implements Outer.say {
	   public static void main(String [] args){
           Outer outer=new Outer();
           Outer.Inner inner=outer.new Inner();
           inner.doStuff();
           TestOuter test=new TestOuter();
           test.saysomething("hi");
           
    }


	@Override
	public void saysomething(String something) {
		// TODO Auto-generated method stub
		System.out.print(something);
		int a;
		System.out.print((a=3));
		
	}
}
