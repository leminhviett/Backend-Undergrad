abstract class Component {
	// i.e method
	public int getWeight()
}

abstract class Decorator extends Component{
	public Decorator(Component comp)
	public int getWeight()
}


class ComponentType1 extends Component{
	public int getWeight() return 100;
}

class DecoratorType1 extends Decorator {
	int extra_w = 50

	public DecoratorType1(ComponentType1 comp)
	public int getWeight() {
		return comp.getWeight() + extra_w;
	}
}
