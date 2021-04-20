package persist;

import java.util.List;

import model.Author;


public interface IDatabase {
	public List<Author> findAllAuthors();
	public int getRoom();
	public void setRoom(int room);
	public List<String> getLog();
	List<String> addLog(String line);
}
