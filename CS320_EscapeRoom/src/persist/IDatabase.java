package persist;

import java.util.List;

import model.Author;
import model.Coordinate;


public interface IDatabase {
	public List<Author> findAllAuthors();
	public int getRoom();
	public void setRoom(int room);

	public String getPlayerInventory();
	public void addtoPlayerInventory(String item);
	
	//functions for the map inventory

	public String getPlayerInv();
	public void addItemToPlayerInv(String item);
	public void removeItemFromPlayerInv(String item);
	public String getActions();
	public void addAction(String action);
	public void removeAction(String action);

	public String getMapInventory();
	public void addToMapInventory(String item, String Coordinate);
	public void removeFromMapInventory(String item);
	
	//log functions
	public List<String> getLog();


	
	//functions for the x/y of the player
	public int getCoordinateX();
	public int getCoordinateY();
	public void setCoordinate(Coordinate coord);

	public List<String> addLog(String line);


}
