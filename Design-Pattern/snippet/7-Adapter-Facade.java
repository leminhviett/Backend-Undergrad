interface Target{
	public void request()
}

public class Adaptee {
	public void request_do_in_another_way()

}

public class Adapter implements Target {
	Adaptee adaptee;

	// constructor sets adaptee

	public void request() {
		// do some other thing to adapt new behaviours

		adaptee.request_do_in_another_way()
	}
}

// ===================================


public class Group1 {
	public void action1()
	public void action2()
	public void action3()

}

public class Group2 {
	public void action1()
	public void action2()
	public void action3()
}

public class Client {
	Group2 g2;
	Group1 g1;

	public void doSth() {
		g1.action1()
		g2.action2();
	}
}