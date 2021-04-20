package persist;

import java.util.List;

import model.Author;


public interface IDatabase {
	public List<Author> findAllAuthors();
	public int getRoom();
	public void setRoom(int room);
	public String getPlayerInventory();
	public void addtoPlayerInventory(String item);
	public String getMapInventory();
	public void addToMapInventory(String item);
	
}
