// bad one
abstract class Duck {
	public class Duck() {}

	// actions that vary between different types of duck
	public void fly()
	public void quack()

	// action that stays the same between different types of duck
	public void display() // simply, print out this is Duck
}

class Duck1 extends Duck {
	public class Duck1() {}

	// have to overrid these varied actions
	public void fly()
	public void quack()
}



// strategy pattern
abstract class Duck {
	// interface
	private IFly flyBehaviour
	private IQuack quackBehaviour

	public class Duck(flyBehaviour, quackBehaviour) {
		// ...
		// init each behaviour
	}

	// actions that vary between different types of duck
	public void fly() {flyBehaviour.fly()}
	public void quack() {quackBehaviour.fly()}

	// action that stays the same between different types of duck
	public void display()
}

class Duck1 extends Duck {
	public class Duck1(flyBehaviour, quackBehaviour) {

	}

	// don't have to override these varied actions anymore
}