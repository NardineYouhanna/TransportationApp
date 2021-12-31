import java.io.IOException;

public class Admin implements User{
	public String name = "";
	public String password = "";
	public String email= "";
	public String mobilenum= "";
	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getmobilenum() {
		return mobilenum;
	}
	@Override
	public void setmobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}

	@Override
	public boolean Login(String username , String Password, String role) {
		Validation vd = new Validation();
		boolean bo = vd.Login(username, Password, role);
		 
			if(bo) {
				  System.out.println("You logged in succesfully");
				  return true;
			}
			else
				System.out.println("Username or password not match");
			return false;
	}


	public boolean Register(String name , String password , String email , String Mobilenum, String role) {
		try {	
			Validation vd = new Validation();
			 vd.Register(name, password, email, Mobilenum, role);

			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}

	@Override
	public boolean RegisterDriv(String name, String password, String email, String mobilenum, String drivlic,
			String nationalid) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setFavareas(String fav) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getVerified() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setVerified(String verified) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getdrivlic() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setdrivlic(String dl) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getnationalid() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setnationalid(String ni) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getrole() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setrole(String Role) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Addfavareass(String fav) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void AddBalance(int balance) {
		// TODO Auto-generated method stub
		
	}
}
