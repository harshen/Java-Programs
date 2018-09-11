package world;

class Something {
	
}

public class Plant {
	// Bad practice
	public String name;

	// Acceptable practice --- it's final.
	public final static int ID = 9;

	private String type;

	protected String size;

	int height;

	public Plant() {
		this.name = "Freedy";
		this.type = "Plant";
		this.size = "medium";
		this.height = 8;
	}
}
