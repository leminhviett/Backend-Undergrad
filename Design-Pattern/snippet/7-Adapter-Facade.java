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