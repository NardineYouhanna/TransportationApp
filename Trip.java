import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;



public class Trip {

	public String source;
	public String destination;
	public int tripid=0;
	public int fees;
	public String dname;
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public void endRide() {
		System.out.println(" Ride has ended , please pay " + this.getFees());
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
	//9) 10}The system should calculate the distance and estimate time arrival (ETA) with the help of google maps API
	public String getDistance(String source, String destination) throws IOException, InterruptedException {
		final String API_KEY="AIzaSyCCWGB4tDZFGtBA7H22XRKWiLe_jo6YQIg";
		String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+source+"&destinations="+destination+"&key="+ API_KEY;
       

		HttpClient client =  HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());
		return response.body().toString();
	}

}
