package hierachy;

public class Implements {
	public static void main(String[] args) {
		Dog.dd();
	}
}

interface Dog {
	void say();

	static void dd() {
		System.out.println("fsf");
	}
}

abstract class XDog implements Dog {

}

class XDogImpl extends XDog {

	@Override
	public void say() {
		// TODO Auto-generated method stub

	}

}
