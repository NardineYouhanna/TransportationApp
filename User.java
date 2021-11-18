import java.io.IOException;
import java.util.ArrayList;

public class User {

	public String name;
	public String password;
	public String email;
	public String mobilenum;
	public String role;
	public String drivlic;
	public String nationalid;
	public String fav;
	public String verified;
	ArrayList<String> favareas  = new ArrayList<String>();

	public void getFavareas() {
		for(int i=0;i<=favareas.size();i++)
		{
			System.out.println(favareas.get(i));
		}
	}

	public void setFavareas(String fav) {
			favareas.add(fav);
	}

	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	public User() {
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getmobilenum() {
		return mobilenum;
	}
	public String getName() {
		return name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setmobilenum(String num) {
		mobilenum = num;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getdrivlic() {
		return drivlic;
	}
	public void setdrivlic(String dl) {
		this.drivlic = dl;
	}
	public String getnationalid() {
		return nationalid;
	}
	public void setnationalid(String ni) {
		this.nationalid = ni;
	}
	public String getrole() {
		return role;
	}
	public void setrole(String Role) {
		this.role = Role;
	}
	
	public void update()
	{
		
	}
	
	boolean Login(String email , String Password, String role) {
		Validation vd = new Validation();
		boolean bo = vd.Login(email, Password, role);
		 
			if(bo) {
				  System.out.println("You logged in succesfully");
				  return true;
			}
			else
				System.out.println("Email or password not match");
			return false;
	}
	
	boolean Register(String name , String password , String email , String Mobilenum, String role) {
	try {	
		Validation vd = new Validation();
		 vd.Register(name, password, email, Mobilenum, role);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	boolean RegisterDriv(String name , String password , String email , String mobilenum, String drivlic, String nationalid) {
		try {	
			Validation vd = new Validation();
			 vd.RegisterDriv(name, password, email, mobilenum, drivlic, nationalid);

			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	
}
