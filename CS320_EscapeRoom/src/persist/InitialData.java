package persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Coordinate;
import model.Hidden;


public class InitialData {
	// reads initial hidden statuses from csv and returns arraylist
	public static List<Hidden> getHidden() throws IOException {
		List<Hidden> hiddenList = new ArrayList<Hidden>();
		ReadCSV readhidden = new ReadCSV("hidden.csv");
		try {
			while (true) {
				List<String> tuple = readhidden.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				
				
				if(i.hasNext()) {
				String item = i.next();
				String status = i.next();
				
				System.out.println("initial data of item for hidden : " + item);
				System.out.println("initial data of item for hidden : " + status);
				int hiddenStatus = Integer.parseInt(status);
				Hidden hidden = new Hidden(item, hiddenStatus);
				hiddenList.add(hidden);
				
				}
			}
			System.out.println("hiddenList loaded from CSV file");
			return hiddenList;
		} finally {
			readhidden.close();
		}
	}

	//GET THE INTIAL LOG FROM THE CSV
	public static List<String> getLog() throws IOException {
		List<String> logList = new ArrayList<String>();
		ReadCSV readlog = new ReadCSV("log.csv");
		try {
			while (true) {
				List<String> tuple = readlog.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();

				logList.add(i.next());
			}
			System.out.println("authorList loaded from CSV file");
			return logList;
		} finally {
			readlog.close();
		}
	}
	
	//GET the Intial Room number from the csv
	public static int getRoom() throws IOException {
		int room = 0;
		ReadCSV readRoom = new ReadCSV("room.csv");
		List<String> tuple = readRoom.next();
		
		Iterator<String> i = tuple.iterator();
		try {
			room = Integer.parseInt(i.next());
			System.out.println("The first room is: " + room);
			
			return room;
		} finally {
			readRoom.close();
		}
	}
	
	public static int getHighScore() throws IOException {
		int score = 0;
		ReadCSV readHighScore = new ReadCSV("highScore.csv");
		List<String> tuple = readHighScore.next();
		
		Iterator<String> i = tuple.iterator();
		try {
			score = Integer.parseInt(i.next());
			System.out.println("The high score is: " + score);
			
			return score;
		} finally {
			readHighScore.close();
		}
	}

	public static List<String> getplayerInventory() throws IOException {
		
		List<String> inv = new ArrayList<String>();
		ReadCSV readAuthors = new ReadCSV("playerInventory.csv");
		try {
			while (true) {
				List<String> tuple = readAuthors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				inv.add(i.next());
				
			}
			System.out.println("player inventory loaded from CSV file:" + inv);
			return inv;
		} finally {
			readAuthors.close();
		}
		
	}
	
	public static List<String> getActions() throws IOException {
		
		List<String> actions = new ArrayList<String>();
		ReadCSV readAuthors = new ReadCSV("actions.csv");
		try {
			while (true) {
				List<String> tuple = readAuthors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				actions.add(i.next());
				
			}
			System.out.println("player inventory loaded from CSV file:" + actions);
			return actions;
		} finally {
			readAuthors.close();
		}
		
	}

	public static List<String> getMapInventory() throws IOException {
		List<String> result = new ArrayList<String>();
		
		ReadCSV readMapInv = new ReadCSV("mapInventory.csv");
		
		try {
		while(true) {
		List<String> tuple = readMapInv.next();
		if(tuple == null) {
			break;
		}
		
		Iterator<String> i = tuple.iterator();
		
			
			String addition = i.next() + i.next() + " ";
			result.add(addition);
			System.out.println(addition + "testing in initial data");
		}	
		}finally {
			readMapInv.close();
		}
		
		
		return result;
	}
	
	public static Coordinate getCoordinate() throws IOException{
		Coordinate result = new Coordinate();
		
		ReadCSV readCoordinate = new ReadCSV("coordinate.csv");
		
		try {
			while(true) {
				List<String> tuple = readCoordinate.next();
				if(tuple == null) {
					break;
				}
				
				Iterator<String> i = tuple.iterator();
				
				int x = Integer.parseInt(i.next());
				int y = Integer.parseInt(i.next());
				
				result.setX(x);
				System.out.println("initialdata version of x " + x);
				result.setY(y);
				System.out.println("initialdata version of y " + y);
				
			}
		}
		finally {
			readCoordinate.close();
		}
		
		
		return result;
	}
	
}