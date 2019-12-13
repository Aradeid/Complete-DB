package complete.types;

public class Offer {
	private int id;
	private User offeringUser;
	private Sticker offeredSticker;
	private int offeredAmount;
	
	public Offer(int id, User user, Sticker sticker, int amount) {
		this.id = id;
		this.offeringUser = user;
		this.offeredSticker = sticker;
		this.offeredAmount = amount;
	}
	public Offer(int id, User user, Sticker sticker) {
		this(id, user, sticker, 1);
	}
	public int getId() {
		return id;
	}
	public User getUser() {
		return offeringUser;
	}
	public Sticker getSticker() {
		return offeredSticker;
	}
	public int getAmount() {
		return offeredAmount;
	}
	public String toString() {
		return String.format("%d: (%s), (%s), %d", id, offeringUser.toString(), offeredSticker.toString(), offeredAmount);
	}
	public void print() {
		System.out.println(this.toString());
	}
}
