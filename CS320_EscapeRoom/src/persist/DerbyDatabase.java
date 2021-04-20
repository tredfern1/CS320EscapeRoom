package persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Author;



public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;
	
	// transaction that retrieves all Authors in Library
	@Override
	public List<Author> findAllAuthors() {
		return executeTransaction(new Transaction<List<Author>>() {
			@Override
			public List<Author> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from authors " +
							" order by lastname asc, firstname asc"
					);
					
					List<Author> result = new ArrayList<Author>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						Author author = new Author();
						loadAuthor(author, resultSet, 1);
						
						result.add(author);
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No authors were found in the database");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	@Override
	public int getRoom() {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from room "
					);
					
					int result = 0;
					
					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						System.out.println("TEST");
						result = resultSet.getInt("roomNumber");
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No int found");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	@Override
	public void setRoom(int room) {
		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"UPDATE room SET roomNumber = ?"
					);
					stmt.setString(1, String.valueOf(room));
					stmt.execute();
					
					
					stmt = conn.prepareStatement("select * from room");
					resultSet = stmt.executeQuery();
					
					//Test to see if this actually works
					while(resultSet.next())
					{
						System.out.println("Test that Room changed");
						System.out.println("ROOM: " + resultSet.getInt("roomNumber"));
					}

					return 1;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	public String getMapInventory() {
		
		
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {

					
					stmt = conn.prepareStatement("select * from mapInventory");
					resultSet = stmt.executeQuery();
					
					String result = null;
					
					//Test to see if this actually works
					while(resultSet.next())
					{
						result = result + resultSet;

					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
		
	}
		
	/*
	stmt = conn.prepareStatement(
			"UPDATE room" +
			"SET roomNumber = ?"
	);
	*/
	//DO NOT CHANGE THIS STUFF BELOW
	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	// TODO: Here is where you name and specify the location of your Derby SQL database
	// TODO: Change it here and in SQLDemo.java under CS320_LibraryExample_Lab06->edu.ycp.cs320.sqldemo
	// TODO: DO NOT PUT THE DB IN THE SAME FOLDER AS YOUR PROJECT - that will cause conflicts later w/Git
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:library.db;create=true");		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	// retrieves Author information from query result set
	private void loadAuthor(Author author, ResultSet resultSet, int index) throws SQLException {
		author.setAuthorId(resultSet.getInt(index++));
		author.setLastname(resultSet.getString(index++));
		author.setFirstname(resultSet.getString(index++));
	}
	
	//  creates the Authors TABLE
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;		
				PreparedStatement stmt2 = null;	
				PreparedStatement stmt3 = null;
				
				try {
					
					stmt2 = conn.prepareStatement(
							"create table room (" +
							"	roomNumber int" +
							")"
						);	
					stmt2.executeUpdate();
						
					System.out.println("Room table created");
					
					stmt1 = conn.prepareStatement(
						"create table authors (" +
						"	author_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	lastname varchar(40)," +
						"	firstname varchar(40)" +
						")"
					);	
					stmt1.executeUpdate();
					
					System.out.println("Authors table created");
					
					//statement to create the map inventory table
					stmt3 = conn.prepareStatement(
							"create table mapInventory ("+
							" spotid int,"+
							" item varchar(40))"
							
							);
					
					stmt3.executeUpdate();
										
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<Author> authorList;
				
				//list for the map inventory
				List<String> mapInv;
				//TEST OF INT
				int room = 0;
				
				try {
					authorList     = InitialData.getAuthors();
					room = InitialData.getRoom();
					mapInv = InitialData.getMapInventory();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}
				
				PreparedStatement insertAuthor     = null;
				PreparedStatement insertRoom     = null;
				PreparedStatement testRoom = null;
				PreparedStatement mapInventory = null;

				try {
					// must completely populate Authors table before populating BookAuthors table because of primary keys
					insertAuthor = conn.prepareStatement("insert into authors (lastname, firstname) values (?, ?)");
					for (Author author : authorList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertAuthor.setString(1, author.getLastname());
						insertAuthor.setString(2, author.getFirstname());
						insertAuthor.addBatch();
					}
					insertAuthor.executeBatch();
					
					System.out.println("Authors table populated");		
					
					insertRoom = conn.prepareStatement("insert into room (roomNumber) VALUES (?)");
					insertRoom.setString(1, String.valueOf(room));
					insertRoom.execute();
					System.out.println("Room table populated");	
					//Test to print out the room
					
					ResultSet resultSet = null;
					testRoom = conn.prepareStatement("select * from room");
					resultSet = testRoom.executeQuery();
					
					//Test to see if this actually works
					while(resultSet.next())
					{
						System.out.println("ITS NOT EMPTY");
						System.out.println("ROOM: " + resultSet.getInt("roomNumber"));
					}
					
					for(String item : mapInv) {
						System.out.println(item);
						
					mapInventory = conn.prepareStatement("insert into mapInventory (spotid,item) VALUES (?,?)")	;
					mapInventory.setString(1, item.substring(0, 2));
					mapInventory.setString(2, item.substring(3));
					mapInventory.addBatch();
					
					}
					mapInventory.executeBatch();
					
					System.out.println("mapInventory table populated");	
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertAuthor);
					DBUtil.closeQuietly(insertRoom);
					DBUtil.closeQuietly(testRoom);
					DBUtil.closeQuietly(mapInventory);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Library DB successfully initialized!");
	}
}
