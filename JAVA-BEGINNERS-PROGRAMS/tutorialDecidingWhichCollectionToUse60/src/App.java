import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class App {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new TreeSet<String>();
		Set<String> set3 = new LinkedHashSet<String>();
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new TreeMap<String, String>();
		Map<String, String> map3 = new LinkedHashMap<String, String>();
		SortedSet<String> set4 = new TreeSet<String>();
		SortedMap<String, String> map4 = new TreeMap<String, String>();
	}
}
