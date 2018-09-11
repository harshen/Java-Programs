class Plant {
	public final static int ID = 7;
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getData() {
		String data = "some stuff " + calculateGrowthForecast();
		return data;
	}
	
	private int calculateGrowthForecast() {
		return 9;
	}
}

public class App {
public static void main(String[] args) {
	Plant plant1 = new Plant();
	System.out.println(plant1.getData());
	plant1.setName("George");
	System.out.println(plant1.getName());
}
}
