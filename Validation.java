import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Validation {
     public boolean Login(String username , String password , String role) {	
    	try {
    		Scanner sc = null;
    		if(role.equalsIgnoreCase("admin"))
    		{
        		 sc = new Scanner(new File("D:\\eclipse workspace\\TransportationApp\\src\\LogAdmin.TXT"));

    		}
    		else if(role.equalsIgnoreCase("client"))
    		{
        		 sc = new Scanner(new File("D:\\eclipse workspace\\TransportationApp\\src\\LogClient.TXT"));
    		}
    		else if(role.equalsIgnoreCase("driver"))
    		{
        		 sc = new Scanner(new File("D:\\eclipse workspace\\TransportationApp\\src\\LogDriver.TXT"));
    		}
		
    	String linereader;
    	String[] users;
    	
    	while(sc.hasNext()) {
    		
    		linereader = sc.nextLine();
    		users=linereader.split(",");
    		if(users[0].equalsIgnoreCase(username) && users[1].equals(password))
                  return true;
               
    	  }
    	}
    	catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("Falied to login");
    	}
    	 return false;
    	}    
     //register lel client w admin
     boolean Register(String name , String password , String email , String mobilenum, String role) throws IOException {
    	
    	 try {
    		 File fil = null ;
    		 if(role.equalsIgnoreCase("Client"))
    		 {
        		  fil = new File("D:\\eclipse workspace\\TransportationApp\\src\\LogClient.TXT");

    		 }
    		 else if (role.equalsIgnoreCase("Admin"))
    		 {
        		  fil = new File("D:\\eclipse workspace\\TransportationApp\\src\\LogAdmin.TXT");
    		 }
			BufferedReader br = new BufferedReader(new FileReader(fil));
			String linereader;
			boolean checkname = false;
            while ((linereader = br.readLine()) != null) {
               if(linereader.contains(name) && linereader.contains(email) ) {
            	   checkname = true;
               }
               
            	
    	    }
            
            if (checkname)
            	System.out.println("Name or email is not unique");
            else {
            FileWriter f = new FileWriter(fil.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(f);
            if(email.contains("@") && email.contains(".com") || email.length()==0) {
            	 bw.append(name);
                 bw.append(',');
                 bw.append(password);
                 bw.append(',');
                 bw.append(email);
                 bw.append(',');
                 bw.append(mobilenum);
                 bw.append("\n");
                 bw.close();
                 br.close();  
                 System.out.println("You registered succesfully");
                 return true;
            }
             else {
             	System.out.println("Email format is not correct..");
                 	
             }
            bw.close();
            }
           
    	 }
		 catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
    	 
 		return false;
 	}

boolean RegisterDriv(String name , String password , String email , String mobilenum, String drivlic, String nationalid) throws IOException {
	
	 try {
		 File fil = new File("D:\\eclipse workspace\\TransportationApp\\src\\LogDriver.TXT");
		BufferedReader br = new BufferedReader(new FileReader(fil));
		String linereader;
		boolean checkname = false;
		
       while ((linereader = br.readLine()) != null) {
          if(linereader.contains(name) && linereader.contains(email) ) {
       	   checkname = true;
          }
       	
	    }
       
       if (checkname)
       	System.out.println("Name or email is not unique");
       else {
       FileWriter f = new FileWriter(fil.getAbsoluteFile(),true);
       BufferedWriter bw = new BufferedWriter(f);
       if(email.contains("@") && email.contains(".com") || email.length()==0) {
       	 	bw.append(name);
            bw.append(',');
            bw.append(password);
            bw.append(',');
            bw.append(email);
            bw.append(',');
            bw.append(mobilenum);
            bw.append(",");
            bw.append(drivlic);
            bw.append(',');
            bw.append(nationalid);
            bw.append("\n");
            System.out.println("You registered succesfully");
            bw.close();
            br.close();  
            return true;
       }
        else {
        	System.out.println("Email format is not correct..");
        }
       bw.close();
       }
      
	 }
	 catch (FileNotFoundException e) {
	
		e.printStackTrace();
	}
	 
	return false;
}
}
