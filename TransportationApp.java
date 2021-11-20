import java.util.ArrayList;
import java.util.Scanner;

public class TransportationApp {
		
		ArrayList<Trip> Trips = new ArrayList<Trip>();
		ArrayList<User> Observers = new ArrayList<User>();
        public void addobserver(User usr)
        {
        	Observers.add(usr);
        }
        public void removeobserver(User usr)
        {
        	Observers.remove(usr);
        }
        public void addtrip(Trip t)
        {
        	Trips.add(t);
        	notifyy();
        }
        public void ListTrips()
        {for(int i = 0 ; i < Trips.size(); i++)
        	System.out.println(Trips.get(i).getTripid() +" "+Trips.get(i).getSource()+ " " + Trips.get(i).getDestination());
        }
        public void notifyy()
        {
        	for(int i=0;i<Observers.size();i++)
        	{
        		Observers.get(i).update(this);
        	}
        }
        
        public void getState() 
        {
        	System.out.println("A new request found !");
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
        Scanner s = new Scanner(System.in);
		int respond;
        respond = s.nextInt();
        boolean n;
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
   	        		App.addobserver(usrd);
   	             
              }		  
        		
        	  else if(role.equalsIgnoreCase("client")) 
              {
        		  usrc.setName(nam);
      	          usrc.setPassword(pass);
      	          usrc.setmobilenum(mobilenum);
      	          usrc.setEmail(email);
            	  usrc.Register(nam, pass, email, mobilenum, role);
            	  n= true;
              }
        	  else if(role.equalsIgnoreCase("Admin"))
        	  {
        		  usra.setName(nam);
      	          usra.setPassword(pass);
      	          usra.setmobilenum(mobilenum);
      	          usra.setEmail(email);
        		  usra.Register(nam, pass, email, mobilenum, role);
            	  n= true;
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
          	    	if(usrc.Login(nam, pass, role)) {
          	    	
          	    	System.out.println("Request a ride: ");
                    System.out.println("Enter your location: ");
                    src=s.nextLine(); 
                    System.out.println("Enter your destination: ");
                    dest=s.nextLine(); 
                    t.setDestination(dest);
                    t.setSource(src);
                    t.tripid++;
                    App.addtrip(t);
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
                	 Scanner sss = new Scanner(System.in);
             	  	int n1 = 0;
             	  	String srca="";
                     respond = sss.nextInt();
                     if (n1 == 1)
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
                     else if(n1==2)
                     {
                     	Scanner s2 = new Scanner(System.in);
                    	int fees;
                 		int id;
                 		System.out.println("Enter trip id: ");
                        id = s2.nextInt();
                    	System.out.println("offer: ");
                        fees = s2.nextInt();
                        t.checktripid(id, App.Trips);
                        t.setFees(fees);
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