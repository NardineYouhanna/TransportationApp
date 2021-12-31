import java.io.IOException;
import java.util.ArrayList;

public interface User {

	public static ArrayList<String> favareas  = new ArrayList<String>();
	ArrayList<Driver> Drivers  = new ArrayList<Driver>();
	
	
	public void Addfavareass(String fav);
	public void update(Object o);
	public void setFavareas(String fav);
	public String getVerified();
	public void setVerified(String verified);
	public String getPassword() ;
	public String getEmail();
	public String getmobilenum() ;
	public String getName();
	public void setEmail(String email);
	public void setmobilenum(String num);
	public void setName(String name);
	public void setPassword(String password);
	public String getdrivlic();
	public void setdrivlic(String dl);
	public String getnationalid();
	public void setnationalid(String ni) ;
	public String getrole() ;
	public void setrole(String Role);
	boolean Login(String email , String Password, String role) ;
	public boolean Register(String name , String password , String email , String Mobilenum, String role);
	public boolean RegisterDriv(String name , String password , String email , String mobilenum, String drivlic, String nationalid);
	public void AddBalance(int balance);
}
