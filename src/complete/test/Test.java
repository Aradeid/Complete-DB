package complete.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import complete.db.*;
import complete.types.*;

public class Test {
	public static void fillDB(Connection connection) throws SQLException {
		DBHandler.insertRegion(connection, "Wien");
		DBHandler.insertRegion(connection, "Niederoesterreich");
		DBHandler.insertRegion(connection, "Oberoesterreich");
		DBHandler.insertRegion(connection, "Salzburg");
		DBHandler.insertRegion(connection, "Burgenland");
		DBHandler.insertRegion(connection, "Steiermarkt");
		
		DBHandler.insertSticker(connection, "Lionel Messi");
		DBHandler.insertSticker(connection, "Cristiano Ronaldo");
		DBHandler.insertSticker(connection, "Luis Suarez");
		DBHandler.insertSticker(connection, "Diego Maradona");
		DBHandler.insertSticker(connection, "Zinedine Zidan");
		DBHandler.insertSticker(connection, "Harry Kane");
		DBHandler.insertSticker(connection, "Luka Modric");
		DBHandler.insertSticker(connection, "Robert Lewandowski");
		DBHandler.insertSticker(connection, "Eden Hazard");
		DBHandler.insertSticker(connection, "Sergio Ramoos");
		DBHandler.insertSticker(connection, "Paulo Dybala");
		DBHandler.insertSticker(connection, "Philippe Coutinho");
		DBHandler.insertSticker(connection, "Paul Pogba");
		
		DBHandler.insertUser(connection, "Jahn", DBHandler.findRegionByName(connection, "Salzburg").getID());
		DBHandler.insertUser(connection, "Peter", DBHandler.findRegionByName(connection, "Salzburg").getID());
		DBHandler.insertUser(connection, "Alex", DBHandler.findRegionByName(connection, "Wien").getID());
		DBHandler.insertUser(connection, "Sarah", DBHandler.findRegionByName(connection, "Wien").getID());
		DBHandler.insertUser(connection, "Leo", DBHandler.findRegionByName(connection, "Niederoesterreich").getID());
		DBHandler.insertUser(connection, "Stefan", DBHandler.findRegionByName(connection, "Niederoesterreich").getID());
		DBHandler.insertUser(connection, "Rudolph", DBHandler.findRegionByName(connection, "Oberoesterreich").getID());
		DBHandler.insertUser(connection, "Dominik", DBHandler.findRegionByName(connection, "Oberoesterreich").getID());
		DBHandler.insertUser(connection, "Lukas", DBHandler.findRegionByName(connection, "Oberoesterreich").getID());
		DBHandler.insertUser(connection, "Laura", DBHandler.findRegionByName(connection, "Oberoesterreich").getID());
		DBHandler.insertUser(connection, "Kevin", DBHandler.findRegionByName(connection, "Oberoesterreich").getID());
		DBHandler.insertUser(connection, "Hannes", DBHandler.findRegionByName(connection, "Burgenland").getID());
		DBHandler.insertUser(connection, "Eva", DBHandler.findRegionByName(connection, "Burgenland").getID());
		DBHandler.insertUser(connection, "Anna", DBHandler.findRegionByName(connection, "Steiermarkt").getID());
		DBHandler.insertUser(connection, "Maria", DBHandler.findRegionByName(connection, "Steiermarkt").getID());
		
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Jahn").getId(), DBHandler.findStickerByName(connection, "Zinedine Zidan").getId());
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Jahn").getId(), DBHandler.findStickerByName(connection, "Harry Kane").getId(), 3);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Jahn").getId(), DBHandler.findStickerByName(connection, "Luka Modric").getId(), 2);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Peter").getId(), DBHandler.findStickerByName(connection, "Harry Kane").getId());
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Peter").getId(), DBHandler.findStickerByName(connection, "Lionel Messi").getId());
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Alex").getId(), DBHandler.findStickerByName(connection, "Harry Kane").getId(), 3);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Sarah").getId(), DBHandler.findStickerByName(connection, "Robert Lewandowski").getId(), 2);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Leo").getId(), DBHandler.findStickerByName(connection, "Sergio Ramoos").getId(), 2);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Leo").getId(), DBHandler.findStickerByName(connection, "Diego Maradona").getId());
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Leo").getId(), DBHandler.findStickerByName(connection, "Paulo Dybala").getId(), 4);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Stefan").getId(), DBHandler.findStickerByName(connection, "Diego Maradona").getId(), 5);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Rudolph").getId(), DBHandler.findStickerByName(connection, "Diego Maradona").getId());
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Rudolph").getId(), DBHandler.findStickerByName(connection, "Harry Kane").getId(), 3);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Rudolph").getId(), DBHandler.findStickerByName(connection, "Lionel Messi").getId(), 5);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Rudolph").getId(), DBHandler.findStickerByName(connection, "Robert Lewandowski").getId(), 2);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Dominik").getId(), DBHandler.findStickerByName(connection, "Robert Lewandowski").getId(), 3);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Dominik").getId(), DBHandler.findStickerByName(connection, "Sergio Ramoos").getId(), 2);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Dominik").getId(), DBHandler.findStickerByName(connection, "Paulo Dybala").getId(), 2);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Lukas").getId(), DBHandler.findStickerByName(connection, "Sergio Ramoos").getId(), 2);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Lukas").getId(), DBHandler.findStickerByName(connection, "Diego Maradona").getId());
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Lukas").getId(), DBHandler.findStickerByName(connection, "Paulo Dybala").getId(), 4);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Lukas").getId(), DBHandler.findStickerByName(connection, "Philippe Coutinho").getId(), 6);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Laura").getId(), DBHandler.findStickerByName(connection, "Robert Lewandowski").getId(), 3);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Kevin").getId(), DBHandler.findStickerByName(connection, "Eden Hazard").getId(), 5);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Kevin").getId(), DBHandler.findStickerByName(connection, "Cristiano Ronaldo").getId(), 3);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Kevin").getId(), DBHandler.findStickerByName(connection, "Sergio Ramoos").getId(), 2);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Kevin").getId(), DBHandler.findStickerByName(connection, "Luis Suarez").getId());
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Hannes").getId(), DBHandler.findStickerByName(connection, "Luis Suarez").getId(), 3);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Eva").getId(), DBHandler.findStickerByName(connection, "Sergio Ramoos").getId());
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Eva").getId(), DBHandler.findStickerByName(connection, "Philippe Coutinho").getId());
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Anna").getId(), DBHandler.findStickerByName(connection, "Sergio Ramoos").getId(), 3);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Maria").getId(), DBHandler.findStickerByName(connection, "Paulo Dybala").getId(), 4);
		DBHandler.insertInventoryItem(connection, DBHandler.findUserByName(connection, "Maria").getId(), DBHandler.findStickerByName(connection, "Diego Maradona").getId(), 2);
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println();
		try (Connection db = DBHandler.getConnection()) {
			fillDB(db);
			
			System.out.println(DBHandler.findInventoryByUserAndSticker(db, DBHandler.findUserByName(db, "Laura").getId(), DBHandler.findStickerByName(db, "Robert Lewandowski").getId()).getAmount() == 3);
		}

	}

}
