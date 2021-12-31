import java.util.ArrayList;

public class History {
	
	ArrayList<Trip> history;
	int rate ;
	
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public History() {
		history = new ArrayList<Trip>();
	}

	public ArrayList<Trip> getHistory() {
		return history;
	}

	public void setHistory(ArrayList<Trip> history) {
		this.history = history;
	}
	
	

}
