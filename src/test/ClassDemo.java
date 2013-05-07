package test;

public class ClassDemo {

	public static void main(String[] args) {
		ClassDemo t = new ClassDemo();
		t.show("test.c");
	}

	void show(String name) {
		try {
			a show = (a) Class.forName(name).newInstance();
			show.aa();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
