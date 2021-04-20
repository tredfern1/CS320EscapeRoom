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
	public String getMapInventory();
	public void addToMapInventory(String item, String Coordinate);
	public void removeFromMapInventory(String item);
	
	//log functions
	public List<String> getLog();
	List<String> addLog(String line);
	
	//functions for the x/y of the player
	public Coordinate getCoordinate();
	public void setCoordinate();
}
