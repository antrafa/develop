class Animal {
	private String name;
	Animal(){

	}
	Animal(String name){
		System.out.println("Inside Animal's constructor");
		this.name = name;
	}
}

class Dog extends Animal {
	Dog(){
		System.out.println("Inside Dog's constructor");
	}
	public static void main(String[] args) {
		Dog d = new Dog();
	}
}