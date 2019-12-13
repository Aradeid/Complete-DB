package complete.types;

// object of a Many-To-Many relationship table
// explains which user has how many of which sticker
public class UserInventory {
	private User user;
	private Sticker sticker;
	private int amount;
	public UserInventory(User user, Sticker sticker, int amount) {
		this.user = user;
		this.sticker = sticker;
		this.amount = amount;
	}
	public User getUser() {
		return this.user;
	}
	public Sticker getSticker() {
		return this.sticker;
	}
	public int getAmount() {
		return this.amount;
	}
}
