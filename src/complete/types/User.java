package complete.types;

public class User {
	private int id;
	private String username;
	private Region region;
	public User(int id, String username, Region region) {
		this.id = id;
		this.username = username;
		this.region = region;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public Region getRegion() {
		return region;
	}
	public String toString() {
		return String.format("%d: %s, (%s)", id, username, region.toString());
	}
	public void print() {
		System.out.println(this.toString());
	}
}
