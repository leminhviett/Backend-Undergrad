abstract class Subject {
	List<Observer> observers;

	// get, set data ...

	public void addObserver(Observer obj)
	public void removeObserver(Observer obj)

	public void notifyObservers() {
		for obs : observers {
			// call update method of observer class
			obs.update()
		}
	}
}

abstract class Observer {
	Subject Subject
	int data // data that observer needed

	public void update() {
		// by calling this, observers always get the latest data
		this.data = Subject.getData()

		// then, call func to process the new data
	}
}

// the rest is simple
class Subject1 extends Subject 
class Observer1 extends Observer
