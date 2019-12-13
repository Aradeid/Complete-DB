package complete.types;

public class Sticker {
	private int id;
	private String name;
	// private String team; // to be added at a later update
	
	public Sticker(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public boolean equals(Sticker s) {
		return (this.id == s.id);
	}
	public String toString() {
		return String.format("%d: %s", id, name);
	}
	public void print() {
		System.out.println(this.toString());
	}
}
