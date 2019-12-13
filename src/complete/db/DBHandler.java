package complete.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import swe4.util.Utility;
import complete.types.*;

public class DBHandler {
	public static Connection getConnection() throws SQLException {
		final String dbName = "CompleteDB";
		final String connectionString = "jdbc:mysql://localhost:3306/" + dbName + "?autoReconnect=true&useSSL=false";
		final String pwd = "";
		final String user = "root";

		System.out.println("  Connecting to '" + connectionString + "' as '" + user + "' ... ");

		final long start = Utility.startTiming();
		Connection connection = DriverManager.getConnection(connectionString, user, pwd); // ToDo
		final double time = Utility.stopTiming(start);

		System.out.printf("  Time to connect: %05.3f s.%n", time);
		return connection;
	}
	
	// Region Controller
	private static List<Region> getResultRegionSet(Connection connection, ResultSet resultSet) throws SQLException { // connection exists as parameter purely for consistency
		int count = 0; // for debugging
		List<Region> list = new ArrayList<Region>();

		if (resultSet != null) {
			while (resultSet.next()) {
				Region region = new Region(resultSet.getInt("regionid"), resultSet.getString("regionname"));
				list.add(region);
				++count;
			}
		}
		return list;
	}
	public static void insertRegion(Connection connection, String regionName) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("INSERT INTO Regions (regionname) VALUES ('%s')", regionName));
			}
		}
	}
	public static void deleteRegionById(Connection connection, int id) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("DELETE FROM Regions WHERE regionid=%d", id));
			}
		}
	}
	public static Region findRegionById(Connection connection, int id) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Regions WHERE regionid=%d", id))) {
					List<Region> list = getResultRegionSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list.get(0);
					}
			}
		}
		return null;
	}
	public static Region findRegionByName(Connection connection, String regionName) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Regions WHERE regionname='%s'", regionName))) {
					List<Region> list = getResultRegionSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list.get(0);
					}
			}
		}
		return null;
	}
	public static List<Region> getRegions(Connection connection) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Regions")) {
					List<Region> list = getResultRegionSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list;
					}
			}
		}
		return null;
	}
	
	// Sticker Controller
	private static List<Sticker> getResultStickerSet(Connection connection, ResultSet resultSet) throws SQLException { // connection exists as parameter purely for consistency
		int count = 0; // for debugging
		List<Sticker> list = new ArrayList<Sticker>();

		if (resultSet != null) {
			while (resultSet.next()) {
				Sticker sticker = new Sticker(resultSet.getInt("stickerid"), resultSet.getString("stickername"));
				list.add(sticker);
				++count;
			}
		}
		return list;
	}
	public static void insertSticker(Connection connection, String stickerName) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("INSERT INTO Stickers (stickername) VALUES ('%s')", stickerName));
			}
		}
	}
	public static void deleteStickerById(Connection connection, int id) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("DELETE FROM Stickers WHERE stickerid=%d", id));
			}
		}
	}
	public static Sticker findStickerById(Connection connection, int id) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Stickers WHERE stickerid=%d", id))) {
					List<Sticker> list = getResultStickerSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list.get(0);
					}
			}
		}
		return null;
	}
	public static Sticker findStickerByName(Connection connection, String stickerName) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Stickers WHERE stickername='%s'", stickerName))) {
					List<Sticker> list = getResultStickerSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list.get(0);
					}
			}
		}
		return null;
	}
	public static List<Sticker> getStickers(Connection connection) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Stickers")) {
					List<Sticker> list = getResultStickerSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list;
					}
			}
		}
		return null;
	}
	
	// User Controller
	private static List<User> getResultUserSet(Connection connection, ResultSet resultSet) throws SQLException {
		int count = 0; // for debugging
		List<User> list = new ArrayList<User>();

		if (resultSet != null) {
			while (resultSet.next()) {
				User user = new User(resultSet.getInt("userid"), resultSet.getString("username"), findRegionById(connection, resultSet.getInt("regionid")));
				
				list.add(user);
				++count;
			}
		}
		return list;
	}
	public static void insertUser(Connection connection, String username, int regionID) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format(
						"INSERT INTO Users (username, regionID) VALUES ('%s', %d)",
						username, regionID));
			}
		}
	}
	public static void deleteUserById(Connection connection, int id) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("DELETE FROM Users WHERE id=%d", id));
			}
		}
	}
	public static User findUserById(Connection connection, int id) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Users WHERE userid=%d", id))) {
					List<User> list = getResultUserSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list.get(0);
					}
			}
		}
		return null;
	}
	public static User findUserByName(Connection connection, String username) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Users WHERE username='%s'", username))) {
					List<User> list = getResultUserSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list.get(0);
					}
			}
		}
		return null;
	}
	public static List<User> findUserByRegion(Connection connection, int regionID) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Users WHERE regionid=%d", regionID))) {
					List<User> list = getResultUserSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list;
					}
			}
		}
		return null;
	}
	public static List<User> findUserByRegion(Connection connection, Region region) throws SQLException {
		return findUserByRegion(connection, region.getID());
	}
	public static List<User> getUsers(Connection connection) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Users")) {
					List<User> list = getResultUserSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list;
					}
			}
		}
		return null;
	}
	
	// Offer Controller
	private static List<Offer> getResultOfferSet(Connection connection, ResultSet resultSet) throws SQLException {
		int count = 0; // for debugging
		List<Offer> list = new ArrayList<Offer>();

		if (resultSet != null) {
			while (resultSet.next()) {
				Offer offer = new Offer(resultSet.getInt("offerid"), findUserById(connection, resultSet.getInt("offeringuser")), findStickerById(connection, resultSet.getInt("offeredsticker")), resultSet.getInt("offeredamount"));
				list.add(offer);
				++count;
			}
		}
		return list;
	}
	public static void insertOffer(Connection connection, int offeringUser, int offeredSticker, int offeredAmount) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("INSERT INTO Offers (offeringuser, offeredsticker, offeredamount) VALUES (%d, %d, %d)", offeringUser, offeredSticker, offeredAmount));
			}
		}
	}
	public static void deleteOfferById(Connection connection, int id) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("DELETE FROM Offers WHERE offerid=%d", id));
			}
		}
	}
	public static Offer findOfferById(Connection connection, int id) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Offers WHERE offerid=%d", id))) {
					List<Offer> list = getResultOfferSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list.get(0);
					}
			}
		}
		return null;
	}
	public static List<Offer> findOfferByUser(Connection connection, int userId) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Offers WHERE offeringuser=%d", userId))) {
					List<Offer> list = getResultOfferSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list;
					}
			}
		}
		return null;
	}
	public static List<Offer> findOfferByUser(Connection connection, User user) throws SQLException {
		return findOfferByUser(connection, user.getId());
	}
	public static List<Offer> findOfferBySticker(Connection connection, int stickerId) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Offers WHERE offeredsticker=%d", stickerId))) {
					List<Offer> list = getResultOfferSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list;
					}
			}
		}
		return null;
	}
	public static List<Offer> findOfferBySticker(Connection connection, Sticker sticker) throws SQLException {
		return findOfferByUser(connection, sticker.getId());
	}
	public static List<Offer> listOffers(Connection connection) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Offers")) {
					List<Offer> list = getResultOfferSet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list;
					}
			}
		}
		return null;
	}
	
	// User Inventory Controller
	private static List<UserInventory> getResultInventorySet(Connection connection, ResultSet resultSet) throws SQLException {
		int count = 0; // for debugging
		List<UserInventory> list = new ArrayList<UserInventory>();

		if (resultSet != null) {
			while (resultSet.next()) {
				UserInventory ui = new UserInventory(findUserById(connection, resultSet.getInt("userid")), findStickerById(connection, resultSet.getInt("stickerid")), resultSet.getInt("amount"));
				list.add(ui);
				++count;
			}
		}
		return list;
	}
	public static void insertInventoryItem(Connection connection, int userId, int stickerId, int amount) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("INSERT INTO UserInventory (userid, stickerid, amount) VALUES (%d, %d, %d)", userId, stickerId, amount));
			}
		}
	}
	public static void insertInventoryItem(Connection connection, int userId, int stickerId) throws SQLException {
		insertInventoryItem(connection, userId, stickerId, 1);
	}
	// updates amount of given userId and stickerId pair
	public static void updateInventoryItem(Connection connection, int userId, int stickerId, int amount) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("UPDATE UserInventory SET amount = %d WHERE userid = %d AND stickerid = %d", amount, userId, stickerId));
			}
		}
	}
	public static void deleteInventoryItem(Connection connection, int userId, int stickerId) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("DELETE FROM UserInventory WHERE userid = %d AND stickerid = %d", userId, stickerId));
			}
		}
	}
	public static void clearInventoryForUser(Connection connection, int userId) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("DELETE FROM UserInventory WHERE userid = %d", userId));
			}
		}
	}
	public static List<UserInventory> findInventoryByUser(Connection connection, int userId) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM UserInventory WHERE userid=%d", userId))) {
					List<UserInventory> list = getResultInventorySet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list;
					}
			}
		}
		return null;
	}
	public static List<UserInventory> findInventoryByUser(Connection connection, User user) throws SQLException {
		return findInventoryByUser(connection, user.getId());
	}
	public static List<UserInventory> findInventoryBySticker(Connection connection, int stickerId) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM UserInventory WHERE stickerid=%d", stickerId))) {
					List<UserInventory> list = getResultInventorySet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list;
					}
			}
		}
		return null;
	}
	public static List<Offer> findnventoryBySticker(Connection connection, Sticker sticker) throws SQLException {
		return findOfferBySticker(connection, sticker.getId());
	}
	public static UserInventory findInventoryByUserAndSticker(Connection connection, int userId, int stickerId) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM UserInventory WHERE userid=%d AND stickerid=%d", userId, stickerId))) {
					List<UserInventory> list = getResultInventorySet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list.get(0);
					}
			}
		}
		return null;
	}
	public static List<UserInventory> listUserInventory(Connection connection) throws SQLException {
		if (connection != null) {
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM UserInventory")) {
					List<UserInventory> list = getResultInventorySet(connection, resultSet);
					if (list.size() <= 0) {
						return null;
					} else {
						return list;
					}
			}
		}
		return null;
	}
}
