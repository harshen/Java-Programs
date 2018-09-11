
public class Car extends Machine {
	public void wipeWindShield() {
		System.out.println("Wiping Windshield");
	}

	@Override
	public void start() {
		System.out.println("Car started.");
	}
	
	public void showInfo() {
		System.out.println("Car name: " + name);
	}
	
	/*public void start() {
		System.out.println("Car started.");
	}*/
}
