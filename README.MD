## Description
This is a part of a Java application which allows exchange of football stickers between users. Specifically this is the part that operates the database.
Initially created as part of a university assignment, I now use it to showacase that I indeed do have some knowledge of Java programming.

## Disclaimer
At the time of writing this program I did not know of OR-mapping, and even if I did, writing the database in this particular way was part of the requirement.

## Documentation
The classes reflected in the database are all used under the namespace *complete.types*. These classes are: *Region*, *Sticker*, *User*, *Offer*, and *UserInventory* (an M-to-N relationship between *User* and *Sticker*.

Handling the database is done via an appropriately names *DBHandler* class. Each table in the database with a method *DBHandler*.*method*+*type*, where *type* is one of the names in *complete.types* and *method* is one of the following:
- insert
- delete
- find - pretty much a “SELECT … WHERE …” - with every object being accessable by ID, or name (if one exists).
- get - pretty much a “SELECT ALL”

When an object is requested from the database, all its references are returned with it. Instead of just returning a *regionId*, the whole *region* object is returned in an attribute. This was the most efficient method given this circumstances, and does not reflect my programming style as a whole.
Each implemented method is fairly simple, but as seen in the Test section, with a combination of these, all data can be accessed and manipulated.
