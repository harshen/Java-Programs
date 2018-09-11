class Robot {
	public void speak(String text) {
		System.out.println(text);
	}
	
	public void jump(int height) {
		System.out.println("Jumping: " + height);
	}
	
	public void move(String direction, double distance) {
		System.out.println("Moving " + distance + " metres in direction " + direction);
	}
}
public class App {
	public static void main(String[] args) {
		Robot sam = new Robot();
		sam.speak("Hi I'm Sam.");
		sam.jump(9);
		sam.move("West", 12.2);
		String greeting = "Hello there.";
		sam.speak(greeting);
		int value = 15;
		sam.jump(value);
	}
}
