
public class Door extends Room {
	
	private Room isPartOf;
	private Coordinate location;
	private boolean isOpen;
	
	Door(Room r, Coordinate c, boolean isOpen) {
		this.isPartOf = r;
		this.location = c;
		this.isOpen = isOpen;
	}
	
	//unlocks a door
	public void unlock() {
		isOpen = true;
	}
	
	//returns the coordinate where a door is located
	public Coordinate getLocation() {
		return location;
	}
	
	//returns wether a door is locked or open
	//false = locked, true = open
	public boolean isOpen() {
		return isOpen;
	}
}
