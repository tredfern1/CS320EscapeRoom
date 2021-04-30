package model;

public class Hidden {

	String item;
	int status;
	
	public Hidden(String item, int status) {
		this.item = item;
		this.status = status;
	}
	
	public String getItem() {
		return this.item;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
}
