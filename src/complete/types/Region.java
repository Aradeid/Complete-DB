package complete.types;

public class Region {
	private int id;
	private String name;
	
	public Region(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void print() {
		System.out.println(String.format("%d: %s", id, name));
	}
}
