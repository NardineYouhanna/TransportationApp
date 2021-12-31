import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Paths;
import java.time.Duration;
public class TransportationApp {
		
		ArrayList<Trip> Trips = new ArrayList<Trip>();
		ArrayList<User> ObserversD = new ArrayList<User>();
		ArrayList<User> ObserversC = new ArrayList<User>();
        public void addObserverD(User usr)
        {
        	ObserversD.add(usr);
        }
        public void removeObserverD(User usr)
        {
        	ObserversD.remove(usr);
        }
        public void addObserverC(User usr)
        {
        	ObserversC.add(usr);
        }
        public void removeObserverC(User usr)
        {
        	ObserversC.remove(usr);
        }
        public void addtrip(Trip t) //
        {
        	Trips.add(t);
        	notifyD();
        }
        public void addoffer(Trip t1)
        {
        	Trip t2 = new Trip();
        	t2 = t1;
        	Trips.add(t2);      	
        	notifyC();
        }
        public void notifyC() {
			// TODO Auto-generated method stub
        	for(int i=0;i<ObserversC.size();i++)
        	{
        		ObserversC.get(i).update(this);
        	}
		}
		public void ListTrips()
        {for(int i = 0 ; i < Trips.size(); i++)
        	System.out.println(Trips.get(i).getTripid() +" "+Trips.get(i).getSource()+ " " + Trips.get(i).getDestination());
        }
        public void ListOberservsD() //notify dirvers
        {
        	for(int i=0;i<ObserversD.size();i++)
        	{
        		ObserversD.get(i).getName();
        		ObserversD.get(i).getmobilenum();
        		ObserversD.get(i).getEmail();
        	}
        }
        public void notifyD() //notify dirvers
        {
        	for(int i=0;i<ObserversD.size();i++)
        	{
        		ObserversD.get(i).update(this);
        	}
        }
        public void getState() 
        {
        	System.out.println("A new request found of trip ");
    	}
        
        public void getPriceState() 
        {
        	//System.out.println("A new request found !");
        	for(int i = 0 ; i < Trips.size() ; i++)
        		Trips.get(i).getFees();
    	}

    	
        
	public static void main(String[] args) {
		TransportationApp App = new TransportationApp();
 		Trip t = new Trip();
 		User usrd = new Driver();
 		User usrc= new Client();
 		User usra = new Admin();
	    ArrayList<User> Drivers  = new ArrayList<User>();
	    System.out.println("1-Register");
        System.out.println("2-Login");
        System.out.println("3-Exit");
        int favanum;
        String pass= "" , nam = "", email = "" , mobilenum = "", role="", drivlic="", nationalid="", fav="";
        String verified="";String src="", dest="";
        boolean addedOfer = false;
		History hist = new History();
        Scanner s = new Scanner(System.in);
		int respond;
       
        boolean n;
        for(;;) {
        	 respond = s.nextInt();
        if (respond == 1) {
        	
        	System.out.println("Who are you? Driver-Client-Admin"); 
            role=s.nextLine();
            for(int i=0;i>=0;i++)
	      	  {
	      		  if (role.length() == 0) 
	      		  {
	      			  System.out.println("Enter your role: ");
	                    role=s.nextLine();   //n7ot el check hna
	                    break;
	      		  }
	      	  }
        	 System.out.println("Enter a unique username: ");
       	  	 nam = s.nextLine();
        	  for(int i=0;i>=0;i++)
        	  {
        		  if (nam.length() == 0) 
        		  {
        			  System.out.println("Username cannot be null");
        			  System.out.println("Enter a unique username: ");
        	       	  	 nam = s.nextLine();
        	             nam += s.nextLine();
        	             break;
        		  }
        	  }
        	  
              System.out.println("Enter your mobile number: ");
              mobilenum=s.nextLine();
              for(int i=0;i>=0;i++)
        	  {
        		  if (mobilenum.length() == 0) 
        		  {
        			  System.out.println("Mobile number cannot be null");
        			  System.out.println("Enter your mobile number: ");
                      mobilenum=s.nextLine();
                      break;
        		  }
        	  }
              
              System.out.println("Enter your password: ");
              pass=s.nextLine();
              for(int i=0;i>=0;i++)
        	  {
        		  if (pass.length() == 0) 
        		  {
        			  System.out.println("Password cannot be null");
        			  System.out.println("Enter your password: ");
                      pass=s.nextLine();
                      break;
        		  }
        	  }
              System.out.println("Enter your email: ");
              email=s.nextLine();
              
        	  if (role.equalsIgnoreCase("Driver"))
        	 {
        		  for(int i1=0;i1>=0;i1++)
        	        {
        			  if (drivlic.length() == 0) 
        	        {
        				  System.out.println("Enter your driving license: ");
        				  drivlic=s.nextLine();
        	        }
        	        }    
        	        for(int i2=0;i2>=0;i2++)
        	        {
        	        	if (nationalid.length() == 0) 
        	           {
        	        	System.out.println("Enter your national id: ");
        	        	nationalid=s.nextLine();
        	           }
        	        }
        	        usrd.setName(nam);
        	        usrd.setPassword(pass);
        	        usrd.setmobilenum(mobilenum);
        	        usrd.setEmail(email);
        	        usrd.setdrivlic(drivlic);
        	        usrd.setnationalid(nationalid);
        	        usrd.setVerified("False");
        	        usrd.RegisterDriv(nam, pass, email, mobilenum, drivlic, nationalid);
 	        		Scanner sc= new Scanner(System.in);
   	        		System.out.println("How many favourite areas do you want to add: ");
   	        		favanum= sc.nextInt();
     	        	System.out.println("Enter your favourite areas: ");
   	        		for(int j=0;j<favanum;j++)
   	        		{
         	          fav=s.nextLine();
         	          usrd.Addfavareass(fav);
   	        		 }
   	        		Drivers.add(usrd);
   	        		t.setDname(usrd.getName());
   	        		App.addObserverD(usrd);
   	        	
              }		  
        		
        	  else if(role.equalsIgnoreCase("client")) 
              {
        		  usrc.setName(nam);
      	          usrc.setPassword(pass);
      	          usrc.setmobilenum(mobilenum);
      	          usrc.setEmail(email);
            	  usrc.Register(nam, pass, email, mobilenum, role);
            	  App.addObserverC(usrc);
            	 
            	  
              }
        	  else if(role.equalsIgnoreCase("Admin"))
        	  {
        		  usra.setName(nam);
      	          usra.setPassword(pass);
      	          usra.setmobilenum(mobilenum);
      	          usra.setEmail(email);
        		  usra.Register(nam, pass, email, mobilenum, role);
        		 
            	 
        	  }
        	 
              
        }
 
        else if (respond == 2)
        {
        	System.out.println("Who are you? Driver-Client-Admin"); 
            role=s.nextLine();
            for(int i=0;i>=0;i++)
	      	  {
	      		  if (role.length() == 0) 
	      		  {
	      			  System.out.println("Enter your role: ");
	                    role=s.nextLine();
	                    break;
	      		  }
	      	  }
          	  //eldriver mesh hynf3 y3ml login 8er law verify b true
                System.out.println("Enter your Username: ");
                nam = s.nextLine();
                System.out.println("Enter your password: ");
                pass=s.nextLine(); 
                
          	    if(role.equalsIgnoreCase("client"))
          	    {
          	    	if(usrc.Login(nam, pass, role))
          	    	{
	          	    	
	          	    	System.out.println("Request a ride: ");
	                    System.out.println("Enter your location: ");
	                    src=s.nextLine(); 
	                    System.out.println("Enter your destination: ");
	                    dest=s.nextLine(); 
	                    t.setDestination(dest);
	                    t.setSource(src);
	                    t.tripid++;
	                    App.addtrip(t);
	                    
	                    
	                    //7-should be able to list all ride offers and check the driver details for each offer
	                    if(addedOfer)
	                    {
	                    	for (int i = 0; i < App.Trips.size(); i++) {
								System.out.println("Trip id :" + App.Trips.get(i).getTripid() + " "
										+ 
										 " Offers : "+   App.Trips.get(i).getFees());
								
							}
	                    	for (int i = 0; i < Drivers.size(); i++) {
	                    		System.out.println( "Driver name : " +  Drivers.get(i).getName() );
								
							}
	                    	//8-The user should be able to select a specific offer
	                    	int offer; //fees
	                    	System.out.println("Select an offer! ");
	                    	offer=s.nextInt();
	                    	
	                    	for (int i = 0; i < App.Trips.size(); i++) {
	                    		if(offer ==  App.Trips.get(i).getFees())
	                    		{	
	                    			Trip selectedTrip = new Trip();
	                    			selectedTrip = App.Trips.get(i);
	                    		try {
	                    			//9-10The system should calculate the distance and estimate time arrival (ETA) with the help of google maps API
									selectedTrip.getDistance(selectedTrip.getSource(), selectedTrip.getDestination());
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
	                    			boolean end = false ;
	                    			
	                    			
	                    			//12- ride should be added to the rides history
	                    			hist.history.add(selectedTrip);
	                    			
	                    		}
	                    		
	                    		
	                    	}
	                    	
	                    	
	                    }
	                    /*
	                     *12 The user should be able to rate any completed ride requested before by the user ( through the 
							rides history ), meaning the user should be able to list all of his rides history and rate any of 

	                     * 
	                     */
	                    System.out.println("Trip History: ");
	                    for(int i=0;i<hist.history.size();i++)
	                    {
	                    	System.out.println(" ID " + hist.history.get(i).getTripid() + hist.history.get(i).getSource() +" "+hist.history.get(i).getDestination() );
	                    	
	                    }
	                    //11 The driver should be able to end the ride once the ride
	                    int rate=0;
	                    System.out.println("which ride do u want to rate : ");
	                    int tid = s.nextInt();
	                    for (int i = 0; i <hist.history.size(); i++) {
	                    	if(tid ==  hist.history.get(i).getTripid())
	                    	{
	                    		System.out.println("Rate you trip out of 5 " );
	                    		rate = s.nextInt();
	                    		hist.setRate(rate);
	                    		System.out.println("Your rate is " + hist.getRate());
	                    	}
							
						}
          	    	}
          	    	else
          	    	{
          	    		System.out.println("byeee!");
          	    		
          	    	}
          	    }    
          	    else if(role.equalsIgnoreCase("admin"))
                {
	          	     if(usra.Login(nam, pass, role))
	          	     {
		                 String name;
		                 Scanner dname = new Scanner(System.in);	
						 System.out.println("Which driver to verify?");
						 name = dname.nextLine();
						 int d1=0;
						 for(int i=0;i<Drivers.size();i++)
				    	 if (Drivers.get(i).getName().equals(name)) 
				    	 {
						     d1=i; 
						     Drivers.get(d1).setVerified("True");
						     break;
				    	 }
						 System.out.println("Driver " + " is Verified: "+ Drivers.get(d1).getVerified());
	          	     }
	          	     else
	          	     {
	          	    	 System.out.println("byeee!");
	          	     }
                }
                else if(role.equalsIgnoreCase("driver"))
                {
                	if(usrd.Login(nam, pass, role))
                	{
	                	System.out.println("1- List all rides: ");
	                	System.out.println("2- Suggest an offer: ");
	                	System.out.println("3- End ride: ");
	                	 Scanner sss = new Scanner(System.in);
	             	  	int n1 = 0;
	             	  	String srca="";
	                     respond = sss.nextInt();
	                     if (respond == 1)
	                     {
	                    	 System.out.println(" Enter Source Area: ");
	                         srca=s.nextLine(); 
	                         for(int i=0;i<=usrd.favareas.size();i++)
	                         {
	                        	 for(int j=0;j<=App.Trips.size();j++)
	                        	 {
	                        		 if(usrd.favareas.get(i)==App.Trips.get(j).getSource())
	                        		 {
	                        			 System.out.println(App.Trips.get(j));
	                        		 }
	                        	 }
	                         }
	                     }
	                     else if(respond==2)
	                     {
	                     	Scanner s2 = new Scanner(System.in);
	                    	int fees;
	                 		int id;
	                 		System.out.println("Enter trip id: ");
	                        id = s2.nextInt();
	                    	System.out.println("enter offer: ");
	                        fees = s2.nextInt();
	                       // t.checktripid(id, App.Trips);
	                        t.setFees(fees);
	                        
	                       
	                        App.addoffer(t);
	                         addedOfer =true;
	                        //notify t.getFees()
	                     }
	                     else if (respond==3)
	                     {	//The ride cost should be added to the driver balance 1 The driver should be able to end the ride once the ride is finished
	                    	 t.endRide();
	                    	 int balance = t.getFees();
	                    	 usrd.AddBalance(balance);
	                     }
	                
                	}
                }else
                {
                	System.out.println("byeee!");
                }
                
        }
        else if(respond == 3) {
        	System.exit(0);
        }
	}
	}
}
