package persist;

import java.util.List;

import model.Author;


public interface IDatabase {
	public List<Author> findAllAuthors();	
}
