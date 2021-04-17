package controller;

import java.util.ArrayList;
import java.util.List;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;
import model.Author;

public class AllAuthorsQuery {

	private IDatabase db = null;

	public AllAuthorsQuery() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public ArrayList<Author> getAllAuthors() {
		
		// get the list of (Author, Book) pairs from DB
		List<Author> authorList = db.findAllAuthors();
		ArrayList<Author> authors = null;
		
		if (authorList.isEmpty()) {
			System.out.println("No authors found in library");
			return null;
		}
		else {
			authors = new ArrayList<Author>();
			for (Author author : authorList) {
				authors.add(author);
			}			
		}
		// return authors for this title
		return authors;
	}
}
