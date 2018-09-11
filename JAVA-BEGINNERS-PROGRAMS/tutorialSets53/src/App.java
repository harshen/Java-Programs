import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
	public static void main(String[] args) {
		// Set<String> set1 = new HashSet<String>();
		// Set<String> set2 = new LinkedHashSet<String>();
		Set<String> set3 = new TreeSet<String>();
		if (set3.isEmpty()) {
			System.out.println("Set is empty at start.");
		}

		set3.add("dog");
		set3.add("cat");
		set3.add("mouse");
		set3.add("snake");
		set3.add("bear");

		if (set3.isEmpty()) {
			System.out.println("Set is empty after adding (no!).");
		}

		set3.add("mouse");

		System.out.println(set3);

		for (String element : set3) {
			System.out.println(element);
		}

		if (set3.contains("aardvark")) {
			System.out.println("Contains aardvark");
		}

		if (set3.contains("cat")) {
			System.out.println("Contains cat");
		}

		Set<String> set4 = new TreeSet<String>();
		set4.add("dog");
		set4.add("cat");
		set4.add("giraffe");
		set4.add("monkey");
		set4.add("ant");

		Set<String> intersection = new HashSet<String>(set3);
		intersection.retainAll(set4);
		System.out.println(intersection);

		Set<String> difference = new HashSet<String>(set4);
		difference.removeAll(set3);
		System.out.println(difference);
	}
}
