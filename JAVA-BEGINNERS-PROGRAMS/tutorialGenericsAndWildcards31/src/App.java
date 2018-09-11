import java.util.ArrayList;

class Machine {

	@Override
	public String toString() {
		return "I am a machine.";
	}
	
	public void start() {
		System.out.println("Machine starting.");
	}

}

class Camera extends Machine {
	
	@Override
	public String toString() {
		return "I am a camera.";
	}
	
	public void snap() {
		System.out.println("snap!");
	}
	
}

public class App {
	public static void main(String[] args) {
		/*
		 * ArrayList<String> list = new ArrayList<String>(); 
		 * list.add("one");
		 * list.add("two"); 
		 * showList(list);
		 */

		ArrayList<Machine> list1 = new ArrayList<Machine>();
		list1.add(new Machine());
		list1.add(new Machine());
		
		ArrayList<Camera> list2 = new ArrayList<Camera>();
		list2.add(new Camera());
		list2.add(new Camera());
		
		showList(list2);
		showList2(list1);
		showList3(list1);
	}

	/*
	 * public static void showList(ArrayList<String> list) { 
	 * 	for(String value: list) { 
	 * 		System.out.println(value); 
	 * 	} 
	 * }
	 */

	/*public static void showList(ArrayList<Machine> list) {
		for (Machine value : list) {
			System.out.println(value);
		}
	}*/
	
	public static void showList(ArrayList<? extends Machine> list) {
		for(Machine value: list) {
			System.out.println(value);
		}
	}
	
	public static void showList2(ArrayList<? super Camera> list) {
		for(Object value: list) {
			System.out.println(value);
		}
	}
	
	public static void showList3(ArrayList<?> list) {
		for(Object value: list) {
			System.out.println(value);
		}
	}

}
