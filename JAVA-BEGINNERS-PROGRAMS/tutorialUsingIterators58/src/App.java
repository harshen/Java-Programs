import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class App {
	public static void main(String[] args) {
		LinkedList<String> animals = new LinkedList<String>();
		animals.add("fox");
		animals.add("cat");
		animals.add("dog");
		animals.add("rabbit");

		Iterator<String> it = animals.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println(value);
			if (value.equals("cat")) {
				it.remove();
			}
		}
		System.out.println();
		ListIterator<String> li = animals.listIterator();
		while (li.hasNext()) {
			String value = li.next();
			
			if (value.equals("dog")) {
				li.add("mouse");
				System.out.println(value);
				value = li.previous();
			} else {
				System.out.println(value);
			}
			
		}
		System.out.println();
		for (String animal : animals) {
			System.out.println(animal);
		}
	}
}
