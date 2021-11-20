import java.util.ArrayList;

public class Trip {

	public String source;
	public String destination;
	public int tripid=0;
	public int fees;
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTripid() {
		return tripid;
	}

	public void setTripid(int tripid) {
		this.tripid = tripid;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}
	public Trip checktripid(int id, ArrayList<Trip> t)
	{	Trip tt = null;
		for(int i=0;i<=t.size();i++)
		{
			if(t.get(i).getTripid()==id)
			{
				tt= t.get(i);
			}
		}
		return tt;
	}
}