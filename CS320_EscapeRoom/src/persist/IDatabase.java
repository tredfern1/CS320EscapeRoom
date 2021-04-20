package persist;

import java.util.List;

import model.Author;


public interface IDatabase {
	public List<Author> findAllAuthors();
	public int getRoom();
	public void setRoom(int room);
	public String getPlayerInv();
	public void addItemToPlayerInv(String item);
	public void removeItemFromPlayerInv(String item);
	public String getActions();
	public void addAction(String action);
	public void removeAction(String action);
	public String getMapInventory();
	public void addToMapInventory(String item, String Coordinate);
	

	public List<String> getLog();
	public List<String> addLog(String line);

}
