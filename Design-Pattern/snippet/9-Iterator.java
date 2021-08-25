public class ObjectA {
	List[] items;

	public Iterator createIterator() {
		return new ObjectA_Iterator(List[] items);
	}
}

interface Iterator {
	boolean hasNext()
	Item next()
}

public class ObjectA_Iterator extends Iterator {
	int idx = 0;

	public ObjectA_Iterator(List[] items) {
		this.items = items;
	}

	public Item next() {
		return this.items[this.idx ++];
	}

	public boolean hasNext() {
		return this.idx < this.items.length;
	}
}


public class Client {
	ObjectA obj;

	public void list_all_items(){
		iterator = obj.createIterator();

		while iterator.hasNext() {
			print(iterator.next())
		}
	}
}


// =================================

public abstract class Component {
	String name;

	public void addChild(Component comp) {
		throw Exception("UnsupportedOperationException");
	};
	public List[Component] getChild() {
		throw Exception("UnsupportedOperationException");
	};

	public String getDesc() return this.name;
}



public class Node extends Component {
	Component comp;

	public String getDesc() {
		return "Node: " + comp.getDesc();
	}
}


public class ConcreteComponent extends Component {
	List[Component] comps;
	String ListName;

	public void addChild(Component comp) {
		comps.add(comp)
	}
	public List[Component] getChild() {
		return this.comp;
	}

	public String getDesc() {

		String s
		for Component ele : this.comps {
			s += ele.getDesc()
		}
		return "List: " + this.ListName + s;
	}
}