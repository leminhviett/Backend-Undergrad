// <========================================== Simple factory ==============================================>
// bad one
class Client {
	public Object createObj(String condition) {
		if (condition == condition1) {
			return ConcreteObject1
		} else if (condition == condition2) {
			return ConcreteObject2
		} else if (condition == condition3) {
			return ConcreteObject3
		}
	}

	public void processObj(Object object) {
		object.cut()
		object.pack()
		//...
	}
}

// instead of writing above code, we put all the creation logic into a class.
// So when another client wants to create object, it can use this factory class. 
// We just decouple the Client from the object creation logic
abstract class FactoryObject {
	public FactoryObject create(String condition) {
		if (condition == condition1) {
			return ConcreteObject1
		} else if (condition == condition2) {
			return ConcreteObject2
		} else if (condition == condition3) {
			return ConcreteObject3
		}
	}
}

class Client {
	FactoryObject factory

	public Object createObj(condition) {
		factory.create(condition)
	}

	public void processObj(Object object) {
		object.cut()
		object.pack()
		//...
	}
}


// <========================================== Factory Method ==============================================>
abstract class Product {

}

abstract class Factory {
	// product creation - factory method
	public Product create(condition) {}

	// product management
	public float getProductPrice() {}
}

class ProductA extends Product{}
class ProductB extends Product{}

class FactoryA extends Factory{
	int basePrice = 100
	float tax = 0.15

	public Product create(condition) {
		if (condition) return new ProductA();
		else return null
	}

	public float getProductPrice() {
		return basePrice*(1 + tax)
	}
}

class FactoryB extends Factory{
	int basePrice = 150
	float tax = 0.25

	public Product create(condition) {
		if (!condition) return new ProductB();
		else return null
	}

	public float getProductPrice() {
		return basePrice*(1 + tax)
	}
}

// let say client is a store
class Client {
	Factory factory = new FactoryA()
	Product product = factory.create(condition)
	System.out.print("Price of product: " + factory.getProductPrice())
}

// <========================================== Abstract Factory ==============================================>
abstract class Factory {
	// product creation - factory method
	public ProductA createProductA(condition) {}
	public ProductB createProductB(condition) {}
	public ProductC createProductC(condition) {}

}

class Factory1 extends Factory {
	public Product createProductA(condition) {}
	public Product createProductB(condition) {}
	public Product createProductC(condition) {}
}

class Creator {
	ProductA productA;
	ProductB productB;
	ProductC productC;

	// passed by composition
	public Creator(Fatory factory) {
		this.productA = factory.createProductA()
		this.productB = factory.createProductB()
		this.productC = factory.createProductC()

	}

	public String getAll() {
		// return all prods
	}

}

class Client {
	Creator creator = new Creator(new Factory1())
	creator.getAll()
}

abstract class ProductA
abstract class ProductB
abstract class ProductC


