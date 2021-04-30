package persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Coordinate;
import model.Hidden;



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
	
	
	@Override
	public void restartGame() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"TRUNCATE TABLE log"
					);
				    stmt.executeUpdate();
				    
				    stmt = conn.prepareStatement(
							"TRUNCATE TABLE hidden"
					);
				    stmt.executeUpdate();
				    
				    stmt = conn.prepareStatement(
							"TRUNCATE TABLE actions"
					);
				    stmt.executeUpdate();
				    
				    stmt = conn.prepareStatement(
							"TRUNCATE TABLE room"
					);
				    stmt.executeUpdate();
				    
				    stmt = conn.prepareStatement(
							"TRUNCATE TABLE mapInventory"
					);
				    stmt.executeUpdate();
				    
				    stmt = conn.prepareStatement(
							"TRUNCATE TABLE playerInventory"
					);
				    stmt.executeUpdate();
				    
				    stmt = conn.prepareStatement(
							"TRUNCATE TABLE playerCoordinate"
					);
				    stmt.executeUpdate();
					// check if any authors were found
					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	@Override
	public List<String> getLog() {
		return executeTransaction(new Transaction<List<String>>() {
			@Override
			public List<String> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from log "
					);
					
					List<String> result = new ArrayList<String>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						result.add(resultSet.getString("logs"));
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No logs were found in the database");
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
	public List<String> addLog(String line) {
		return executeTransaction(new Transaction<List<String>>() {
			@Override
			public List<String> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"INSERT INTO log VALUES (?)"
					);
					stmt.setString(1, line);
					List<String> result = new ArrayList<String>();
					
					stmt.executeUpdate();

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
	

	//returns the player's inventory as a string, with items separated by " "
	@Override
	public String getPlayerInv() {
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"SELECT * FROM playerInventory"
					);
					
					String result = "";
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						//System.out.println(resultSet.getString("item"));
						result = result + resultSet.getString("item") + " ";
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No items in the player's inventory were found in the database");
					}
					System.out.println("result in the DB for items: " + result);

					return result;
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
					
					String result = "";
					
					//Test to see if this actually works
					while(resultSet.next())
					{
						result = result + resultSet.getString("spotid") + resultSet.getString("item");
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
	public void addItemToPlayerInv(String item) {
		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"INSERT INTO playerInventory (item) " +
							"VALUES (?)"
					);
					stmt.setString(1, item);
					
					stmt.executeUpdate();
					
					return 1;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	@Override
	public void removeItemFromPlayerInv(String item) {

		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"DELETE FROM playerInventory WHERE item = ?"
					);
					stmt.setString(1, item);
					
					stmt.executeUpdate();
					
					return 1;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	//TODO: You are here
	@Override
	public void updatePlayerInv(String inv) {
		
		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				
				List<String> invList = new ArrayList<String>();
				String[] temp = inv.split(" ");
				invList = Arrays.asList(temp);
				
				ResultSet resultSet = null;
		
				try {
					stmt1 = conn.prepareStatement(
							"DROP TABLE playerInventory"
					);
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							"CREATE TABLE playerInventory ("
							+ "item varchar(40)"
							+ ")"
					);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement("INSERT INTO playerInventory (item) VALUES (?)");
					for (String item : invList) {
						stmt3.setString(1, item);
						stmt3.addBatch();
					}
					stmt3.executeBatch();
					
					//System.out.println("Updated actions successfully. New actions: " + actions);
					return 1;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
				}
			}
		});
	}
	
	@Override
	public String getActions() {
		
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"SELECT * FROM actions"
					);
					
					String result = "";
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						//System.out.println(resultSet.getString("item"));
						result = result + resultSet.getString("action") + " ";
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No actions were found in the database");
					}
					System.out.println("result in the DB for actions: " + result);

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});

	}
	
	@Override
	public void addAction(String action) {
		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"INSERT INTO actions (action) " +
							"VALUES (?)"
					);
					stmt.setString(1, action);
					
					stmt.executeUpdate();
					
					return 1;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	@Override
	public void removeAction(String action) {
		
		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
		
				try {
					stmt = conn.prepareStatement(
							"DELETE FROM actions WHERE action = ?"
							);
					stmt.setString(1, action);
			
					stmt.executeUpdate();
			
					return 1;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	@Override
	public void updateActions(String actions) {
		
		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				
				List<String> actionsList = new ArrayList<String>();
				String[] temp = actions.split(" ");
				actionsList = Arrays.asList(temp);
				
				ResultSet resultSet = null;
		
				try {
					stmt1 = conn.prepareStatement(
							"DROP TABLE actions"
					);
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							"CREATE TABLE actions ("
							+ "action varchar(40)"
							+ ")"
					);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement("INSERT INTO actions (action) VALUES (?)");
					for (String action : actionsList) {
						stmt3.setString(1, action);
						stmt3.addBatch();
					}
					stmt3.executeBatch();
					
					//System.out.println("Updated actions successfully. New actions: " + actions);
					return 1;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
				}
			}
		});
	}
	
	public void addToMapInventory(String item, String coordinate) {
		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"insert into mapInventory(mapInventory.spotid, mapInventory.item) "
							+ "values (?,?)"
					);
					stmt.setString(1, String.valueOf(coordinate));
					stmt.setString(2, String.valueOf(item));
					stmt.execute();
					

					return 1;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}
	
	public void removeFromMapInventory(String item) {
		
		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"delete from mapInventory where "
							+"item = ?"
					);
					
					stmt.setString(1, String.valueOf(item));
					stmt.execute();
					

					return 1;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}
	

	
	public void setMapInventory(String mapInventory) {
	
		executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				String[] temp = mapInventory.split(" ");
				List<String> newMapInventory = new ArrayList<String>();
				newMapInventory = Arrays.asList(temp);
				
				try {
					stmt = conn.prepareStatement(
							"delete from mapInventory"
					);
					stmt.executeUpdate();
					
					stmt = conn.prepareStatement("insert into mapInventory "
							+ "(spotid, item) values (?,?) ");
					int i = 0;
					for(String item: newMapInventory) {
						if(!item.contentEquals("") && !item.contentEquals(" ")) {
							System.out.println(i + " : " + item);
							stmt.setString(1, item.substring(0,3));
							stmt.setString(2, item.substring(3) + " ");
							stmt.addBatch();
							i++;
						}
					}
					
					stmt.executeBatch();

					return mapInventory;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}

	

	public int getCoordinateX() {
		
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				int result = 0;
				
				try {
					stmt = conn.prepareStatement(
							"select x from playerCoordinate"
							
					);
					
					resultSet = stmt.executeQuery();
					
					while(resultSet.next()) {
						result = resultSet.getInt("x");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
		
		
	}

	public int getCoordinateY() {
		
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				int result = 0;
				
				try {
					stmt = conn.prepareStatement(
							"select y from playerCoordinate"
							
					);
					
					resultSet = stmt.executeQuery();
					
					while(resultSet.next()) {
						result = resultSet.getInt("y");
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
	public void setCoordinate(Coordinate coord) {
		
		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"UPDATE playerCoordinate SET x = ?, y = ? "
					);
					stmt.setInt(1, coord.getX());
					stmt.setInt(2, coord.getY());
					stmt.executeUpdate();
				
					return 1;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}
	
	public int getHiddenStatus(String item) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				 
				int result = 0;
				
				try {
					stmt = conn.prepareStatement(
							"select status from hidden "+
							"where item = ?"
							
					);
					
					stmt.setString(1, item);
					
					resultSet = stmt.executeQuery();
					
					while(resultSet.next()) {
						result = resultSet.getInt("status");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}
	
	public void setHiddenStatus(String item) {
		
		executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"UPDATE hidden "
							+"set status = 1 "
							+"where item = ?"
					);
					stmt.setString(1, item);
			
					stmt.executeUpdate();
				
					return 1;
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
	
	//  creates the Authors TABLE
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;		

				PreparedStatement stmt2 = null;	
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;	
				PreparedStatement stmt6 = null;	
	
				try {
					
					//create table for hiding items
					stmt1 = conn.prepareStatement(
							"create table hidden "+
							"(item varchar(50), status int)"
							);
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							"create table room (" +
							"	roomNumber int" +
							")"
						);	
					stmt2.executeUpdate();
						
					System.out.println("Room table created");
					
					
					//creates the table for the player's inventory
					stmt3 = conn.prepareStatement(
						"CREATE TABLE playerInventory ("
						+ "item varchar(40)"
						+ ")"
					);
					stmt3.executeUpdate();
					
					stmt4 = conn.prepareStatement(
						"CREATE TABLE actions ("
						+ "action varchar(40)"
						+ ")"
					);
					stmt4.executeUpdate();
					
					System.out.println("All tables created");
					

					//statement to create the map inventory table
					stmt6 = conn.prepareStatement(
							"create table mapInventory ("+
							" spotid varchar(500),"+
							" item varchar(5000))"
							
							);
					
					stmt6.executeUpdate();

					stmt5 = conn.prepareStatement(
							"create table log (" +
							"	logs varchar(1000)" +
							")"
						);	
					
					stmt5.executeUpdate();			
					
					System.out.println("Logs table created");

					
					stmt3 = conn.prepareStatement("create table playerCoordinate"
							+ "(x int, y int)");
					
					stmt3.executeUpdate();
										
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
					DBUtil.closeQuietly(stmt5);
					DBUtil.closeQuietly(stmt6);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<String> playerInv;
				List<String> actions;

				//list for the map inventory
				List<String> mapInv;

				List<String> logList;
				
				List<Hidden> hiddenList;
				
				//coordinate for the player coord
				Coordinate coord;

				//TEST OF INT
				int room = 0;
				
				try {
					logList = InitialData.getLog();
					room = InitialData.getRoom();
					playerInv = InitialData.getplayerInventory();
					actions = InitialData.getActions();
					mapInv = InitialData.getMapInventory();
					coord = InitialData.getCoordinate();
					hiddenList = InitialData.getHidden();

				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}
				
				PreparedStatement insertAuthor   = null;
				PreparedStatement insertRoom     = null;
				PreparedStatement testRoom = null;
				PreparedStatement insertPlayerInv = null;
				PreparedStatement insertActions = null;
				
				PreparedStatement mapInventory = null;
				//PreparedStatement testRoom       = null;
				PreparedStatement insertLog      = null;
				PreparedStatement insertCoordinate      = null;
				PreparedStatement insertHidden = null;

				try {
					
					//populating the hidden table
					insertHidden = conn.prepareStatement(""
							+ "insert into hidden (item, status) "
							+ "values(?, ?) ");
					
					for(Hidden hidden: hiddenList) {
						insertHidden.setString(1, hidden.getItem());
						insertHidden.setInt(2, hidden.getStatus());
						insertHidden.addBatch();
					}
					
					insertHidden.executeBatch();
					
					insertRoom = conn.prepareStatement("insert into room (roomNumber) VALUES (?)");
					insertRoom.setString(1, String.valueOf(room));
					insertRoom.execute();
					System.out.println("Room table populated");	
					
					
					insertLog = conn.prepareStatement("insert into log (logs) values (?)");
					for (String statement : logList) {
//			
						insertLog.setString(1, statement);
						insertLog.addBatch();
					}
					insertLog.executeBatch();
					
					System.out.println("Logs table populated");		
					
					
					//populate the player coord database
					insertCoordinate = conn.prepareStatement("insert into playerCoordinate"
							+ "(x,y) values (?,?)");
					System.out.println("derby test of initial coord" + String.valueOf(coord.getX()));
					insertCoordinate.setInt(1, coord.getX());
					insertCoordinate.setInt(2, coord.getY());
					
					insertCoordinate.executeUpdate();
					//Test to print out the room
					
					ResultSet resultSet = null;
					testRoom = conn.prepareStatement("select logs from log");
					resultSet = testRoom.executeQuery();
					
					//Test to see if this actually works
					while(resultSet.next())
					{
						System.out.println("ITS NOT EMPTY");
						System.out.println("Log: " + resultSet.getString("logs"));
					}
					

					//populates the player's inventory with the initial data
					insertPlayerInv = conn.prepareStatement("INSERT INTO playerInventory (item) VALUES (?)");
					for (String item : playerInv) {
						insertPlayerInv.setString(1, item);
						insertPlayerInv.addBatch();
					}
					insertPlayerInv.executeBatch();
					
					
					
					/*
					resultSet = null;
					testRoom = conn.prepareStatement("select * from playerInventory");
					resultSet = testRoom.executeQuery();
					
					while(resultSet.next())
					{
						System.out.println("ITS NOT EMPTY");
						System.out.println("ITEM: " + resultSet.getString("item"));
					}
					*/
					
					insertActions = conn.prepareStatement("INSERT INTO actions (action) VALUES (?)");
					for (String action : actions) {
						insertActions.setString(1, action);
						insertActions.addBatch();
					}
					insertActions.executeBatch();

					mapInventory = conn.prepareStatement("insert into mapInventory (spotid, item) VALUES (?,?)");
					for(String item : mapInv) {
						mapInventory.setString(1, item.substring(0,3));
						mapInventory.setString(2, item.substring(3));
						mapInventory.addBatch();
					}
					
					
					mapInventory.executeBatch();
					
					System.out.println("mapInventory table populated");	
					
					//Test to print out the room
					
					resultSet = null;
					testRoom = conn.prepareStatement("select * from mapInventory");
					resultSet = testRoom.executeQuery();
					System.out.println(resultSet.getFetchSize());
					//Test to see if this actually works
					while(resultSet.next())
					{
						System.out.println("MAPINV: " + resultSet.getString("spotid") + resultSet.getString("item"));
					}

					
					return true;
				} finally {
					DBUtil.closeQuietly(insertLog);
					DBUtil.closeQuietly(insertAuthor);
					DBUtil.closeQuietly(insertRoom);
					DBUtil.closeQuietly(testRoom);
					DBUtil.closeQuietly(insertPlayerInv);
					DBUtil.closeQuietly(mapInventory);
					DBUtil.closeQuietly(insertCoordinate);
				}
			}
		});
	}
	
	public void loadInitialData2() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<String> playerInv;
				List<String> actions;

				//list for the map inventory
				List<String> mapInv;

				List<String> logList;
				
				List<Hidden> hiddenList;
				
				//coordinate for the player coord
				Coordinate coord;

				//TEST OF INT
				int room = 0;
				
				try {
					logList = InitialData.getLog();
					room = InitialData.getRoom();
					playerInv = InitialData.getplayerInventory();
					actions = InitialData.getActions();
					mapInv = InitialData.getMapInventory();
					coord = InitialData.getCoordinate();
					hiddenList = InitialData.getHidden();

				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}
				
				PreparedStatement insertAuthor   = null;
				PreparedStatement insertRoom     = null;
				PreparedStatement testRoom = null;
				PreparedStatement insertPlayerInv = null;
				PreparedStatement insertActions = null;
				
				PreparedStatement mapInventory = null;
				//PreparedStatement testRoom       = null;
				PreparedStatement insertCoordinate      = null;
				PreparedStatement insertHidden = null;

				try {
					
					//populating the hidden table
					insertHidden = conn.prepareStatement(""
							+ "insert into hidden (item, status) "
							+ "values(?, ?) ");
					
					for(Hidden hidden: hiddenList) {
						insertHidden.setString(1, hidden.getItem());
						insertHidden.setInt(2, hidden.getStatus());
						insertHidden.addBatch();
					}
					
					insertHidden.executeBatch();
					
					insertRoom = conn.prepareStatement("insert into room (roomNumber) VALUES (?)");
					insertRoom.setString(1, String.valueOf(room));
					insertRoom.execute();
					System.out.println("Room table populated");	

					//populate the player coord database
					insertCoordinate = conn.prepareStatement("insert into playerCoordinate"
							+ "(x,y) values (?,?)");
					System.out.println("derby test of initial coord" + String.valueOf(coord.getX()));
					insertCoordinate.setInt(1, coord.getX());
					insertCoordinate.setInt(2, coord.getY());
					
					insertCoordinate.executeUpdate();
					//Test to print out the room
					
					ResultSet resultSet = null;
					testRoom = conn.prepareStatement("select logs from log");
					resultSet = testRoom.executeQuery();
					
					//Test to see if this actually works
					while(resultSet.next())
					{
						System.out.println("ITS NOT EMPTY");
						System.out.println("Log: " + resultSet.getString("logs"));
					}
					

					//populates the player's inventory with the initial data
					insertPlayerInv = conn.prepareStatement("INSERT INTO playerInventory (item) VALUES (?)");
					for (String item : playerInv) {
						insertPlayerInv.setString(1, item);
						insertPlayerInv.addBatch();
					}
					insertPlayerInv.executeBatch();
					
					
					
					/*
					resultSet = null;
					testRoom = conn.prepareStatement("select * from playerInventory");
					resultSet = testRoom.executeQuery();
					
					while(resultSet.next())
					{
						System.out.println("ITS NOT EMPTY");
						System.out.println("ITEM: " + resultSet.getString("item"));
					}
					*/
					
					insertActions = conn.prepareStatement("INSERT INTO actions (action) VALUES (?)");
					for (String action : actions) {
						insertActions.setString(1, action);
						insertActions.addBatch();
					}
					insertActions.executeBatch();

					mapInventory = conn.prepareStatement("insert into mapInventory (spotid, item) VALUES (?,?)");
					for(String item : mapInv) {
						mapInventory.setString(1, item.substring(0,3));
						mapInventory.setString(2, item.substring(3));
						mapInventory.addBatch();
					}
					
					
					mapInventory.executeBatch();
					
					System.out.println("mapInventory table populated");	
					
					//Test to print out the room
					
					resultSet = null;
					testRoom = conn.prepareStatement("select * from mapInventory");
					resultSet = testRoom.executeQuery();
					System.out.println(resultSet.getFetchSize());
					//Test to see if this actually works
					while(resultSet.next())
					{
						System.out.println("MAPINV: " + resultSet.getString("spotid") + resultSet.getString("item"));
					}

					
					return true;
				} finally {
					DBUtil.closeQuietly(insertAuthor);
					DBUtil.closeQuietly(insertRoom);
					DBUtil.closeQuietly(testRoom);
					DBUtil.closeQuietly(insertPlayerInv);
					DBUtil.closeQuietly(mapInventory);
					DBUtil.closeQuietly(insertCoordinate);
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
